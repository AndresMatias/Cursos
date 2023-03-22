// Filtro IIR:
//`timescale 1ns / 1ps        
// 3x --->  X -------b0---> + ------> + -----------> Y
//               |          |         |          |
//               Z1         |         |          Z1
//               |          |         |          |
//               ----b1-----+         +----a1-----
//               |          |         |          |
//               Z2         |         |          Z2
//               |          |         |          |
//               ----b2-----+         -----a2-----
//               |          |         
//               Z2         |                 
//               |          |                   
//               |----b3-----
//NBI: Numero de Bits Enteros
//NBF: Numero de Bits Fraccionales
//NB:  Numero de Bits(por lo general totales NBI+NBF)
module iir
#(
    parameter NB_SAMPLE     = 9,  //! NB of samples x[n]
    parameter NBF_SAMPLE    = 7,  //! NBF de x[n]
    parameter NB_COEFF      = 15, //! NB de los coeficientes A y B
    parameter NBF_COEFF     = 13, //! NBF de los coeficientes
    parameter N_COEFFS      = 4   //! Numeros de Coeficientes del Filtro IIR
)
(
    output signed [NB_SAMPLE - 1 : 0] y_o,      //! output data

    input signed [NB_SAMPLE-1 : 0]    x_i,      //! input data x[n] Ver tema de signo
    input                             i_reset,  //! reset 
    input                             clock     //! clock
);
//--Constantes para las operaciones en la parte de los coeficientes B--
localparam NB_PROD_B  = NB_SAMPLE + NB_COEFF;   //! Numeros de bits de los productos de B
localparam NB_ADD_B   = NB_PROD_B + 3;          //! Numero de bits de las suma de B, el 3 sale de la cantida de sumas y se agrega en la parte de signo, NO en la fraccional
localparam NBF_PROD_B = NBF_SAMPLE + NBF_COEFF; //! NBF de los productos de B
localparam NBF_ADD_B  = NBF_PROD_B;             //! NBF de las sumas de B

//--Constantes para las operaciones en la parte de los coeficientes A--
localparam NB_PROD_A  = NB_ADD_B + NB_COEFF;    //! NB de los productos de A
localparam NBF_PROD_A = NBF_ADD_B + NBF_COEFF;  //! NBF de los productos de A
localparam NB_ADD_A   = NB_PROD_A + 2;          //! NB de las suma de A
localparam NBF_ADD_A  = NBF_PROD_A;             //! NBF de las suma de A
localparam NBI_ADD_A  = NB_ADD_A - NBF_ADD_A;   //! NBI de las sumas de A

//--Constates en la entrada de muestras de la parte A del filtro--
/*La suma addB es la entrada de muestras de la parte A del filtro*/
localparam NB_SAMPLE_A  = NB_ADD_B;                     //! Numeros de bits de saturacion de A
localparam NBF_SAMPLE_A = NBF_ADD_B;                    //! Numeros de bits fraccionales de registros de A
localparam NBI_SAMPLE_A = NB_SAMPLE_A - NBF_SAMPLE_A;   //! NBI de resgistros de A

localparam NB_SAT     = NBI_ADD_A-NBI_SAMPLE_A; //! NB de saturacion
localparam NBI_SAMPLE = NB_SAMPLE - NBF_SAMPLE; //! NBI de saturacion
localparam NB_SAT_OUT = NBI_ADD_A-NBI_SAMPLE;   //! NB para verificar la saturaciÃ³n

//--Variables--
reg  signed [NB_SAMPLE   - 1 : 0] register_x [N_COEFFS - 1 : 1]; //! Muestras en x desplazadas
reg  signed [NB_SAMPLE_A - 1 : 0] register_y [N_COEFFS - 2 : 1]; //! Muestras en y desplazadas
//wire signed [NB_COEFF    - 1 : 1] coeffA     [N_COEFFS - 1 : 1]; //! Matrix of Coef A 
//wire signed [NB_COEFF    - 1 : 0] coeffB     [N_COEFFS - 1 : 0]; //! Matrix of Coef B
wire signed [NB_PROD_B   - 1 : 0] prodB      [N_COEFFS - 1 : 0]; //! Products B
wire signed [NB_PROD_A   - 1 : 0] prodA      [N_COEFFS - 2 : 1]; //! Products A
wire signed [NB_ADD_B    - 1 : 0] addB;                          //! Adders B
wire signed [NB_ADD_A    - 1 : 0] addA;                          //! Adders A
wire signed [NB_SAMPLE_A - 1 : 0] addA_trunc;                    //! Adders A Trunc
wire signed [NB_PROD_A   - 1 : 0] addBExpand;                    //! Expand adder A

    //--Productos B--
    assign prodB[0] = x_i;
    assign prodB[1] = register_x[1];
    assign prodB[2] = register_x[2];
    assign prodB[3] = register_x[3];
    
    //--Suma B--
    assign addB = prodB[0] - prodB[1] + prodB[2] + prodB[3];
    
    //--Expasion Suma B para poder sumar con A--
    /*Aplico una expasion en la suma total de B para alinear la coma con respecto a la suma total de A
      y poder sumar correctamente los numeros
      ----------------------------------------------------------------------------
      {NBI_ADD_A-NBI_SAMPLE_A{addb[NB_ADD_B-1]}}: Ajusta los bits de signos de NBI
                  |                    |
                  |           addb[NB_ADD_B-1]: Extraigo Signo de addb
       (NBI_ADD_A-NBI_SAMPLE_A) {addb[NB_ADD_B-1]}: creo un vector con al cantidad de signos que faltan para expandir
      ----------------------------------------------------------------------------
      {NBF_ADD_A-NBF_SAMPLE_A{1'b0}}}: Ajusta los bits de la parte fraccional NBF para expandir y se aline
    */
    assign addBExpand = $signed({{NBI_ADD_A-NBI_SAMPLE_A{addB[NB_ADD_B-1]}},addB,{NBF_ADD_A-NBF_SAMPLE_A{1'b0}}});
    
    always @(posedge clock) begin
        if (i_reset == 1'b1) begin
            register_x[1] <= {NB_SAMPLE{1'b0}};
            register_x[2] <= {NB_SAMPLE{1'b0}};
            register_x[3] <= {NB_SAMPLE{1'b0}};
        end 
        else begin
            register_x[1] <= x_i;           
            register_x[2] <= register_x[1]; 
            register_x[3] <= register_x[2]; 
        end
    end
    
    //--Truncado de Suma A--
    /*
        ~|adda[NB_ADDA-1 -: NB_SAT+1] || &adda[NB_ADDA-1 -: NB_SAT+1]): Comprueba que los bit de signo sean todos iguales y si es asi asigna todos los bit de la parte fraccional y creo un solo bit de signo eliminando el resto a addA_trunc
        adda[NB_ADDA-1] Comprueba que el ultimo bit sea verdadero(creo que un 1) asignando un 1 de bit de signo y el resto de parte fraccional como 1
        y sino hace lo mismo pero asignando un 0 como signo
        El truncado se realiza para que la cantidad de bits de salida de addA_trunc se igual a la cantidad de bits de addB y sample_A esto para que al asignarlo a la salida y se mantenga
        coherencia en la cantidad de bits
    */
    
    assign addA_trunc = ( ~|addA[NB_ADD_A-1 -: NB_SAT+1] || &addA[NB_ADD_A-1 -: NB_SAT+1]) ? addA[NB_ADD_A-(NBI_ADD_A-NBI_SAMPLE_A) - 1 -: NB_SAMPLE_A] :
    (addA[NB_ADD_A-1]) ? {{1'b1},{NB_SAMPLE_A-1{1'b0}}} : {{1'b0},{NB_SAMPLE_A-1{1'b1}}};
    
    always @(posedge clock) begin
        if (i_reset == 1'b1) begin
            register_y[1] <= {NB_SAMPLE_A{1'b0}};
            register_y[2] <= {NB_SAMPLE_A{1'b0}};
        end 
        else begin
            //----------------------------------------------------------------------
            // >>1: corro a la derecha 1 bit, esto equivale a multiplicar por 0.5
            // >>2: corro a la derecha 2 bit, esto equivale a multiplicar por 0.25
            //----------------------------------------------------------------------
            register_y[1] <= addA_trunc >> 1;           
            register_y[2] <= register_y[1] >> 2;   
        end
    end
    
    //--Productos A--
    assign prodA[1] = register_y[1];
    assign prodA[2] = register_y[2];
    
    //--Suma A--
    assign addA = addBExpand + prodA[1] + prodA[2];
    
    //--Saturacion y Truncado--
    /*
        Exactamente lo mismo que adda_trunc solo que y_o es para la salida y adda_trunc lo asigno a los resgistros
    */
    assign y_o  = ( ~|addA[NB_ADD_A-1 -: NB_SAT_OUT+1] || &addA[NB_ADD_A-1 -: NB_SAT+1]) ? addA[NB_ADD_A-(NBI_ADD_A-NBI_SAMPLE) - 1 -: NB_SAMPLE] :
              (addA[NB_ADD_A-1]) ? {{1'b1},{NB_SAMPLE-1{1'b0}}} : {{1'b0},{NB_SAMPLE-1{1'b1}}};
    
endmodule