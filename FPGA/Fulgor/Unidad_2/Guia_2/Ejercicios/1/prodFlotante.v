module prod_flotante
    #(
        parameter NB_INPUT     = 13,    //! NB de entrada de los numeros
        parameter NB_EXPONENTE = 4,     //! NB de mantisa del numero flotante
        parameter NB_SIGNO     = 1,     //! NB de signo
        parameter NB_SESGO     = 4      //! NB de sesgo igual al del exponente para igualar
    )
    (
        //NB_EXPONENTE+3+NB_SIGNO+((NB_INPUT-(NB_SIGNO+NB_EXPONENTE))*2)-1: Cantidad de bits totales de mantisa, exponentes y signo del nro resultado de la operacion,el 3 sale de la cantidad de sumas y resta de calcular el exponente final
        output signed [NB_EXPONENTE+3+NB_SIGNO+((NB_INPUT-(NB_SIGNO+NB_EXPONENTE))*2)-1:0]  o_prod,   //! Salida del producto flotante
        input  signed [NB_INPUT-1:0]                                                        i_n1,     //! Nro 1
        input  signed [NB_INPUT-1:0]                                                        i_n2,     //! Nro 2              
        input                                                                               i_reset,  //! reset negado
        input                                                                               clock     //! clock
    );
    //localparam signed [12:0] A = 13'b1_0000_00000000;
    /*--Posiciones de los bit mas y menos significativos del exponente--*/
    localparam  NB_EXP_S= NB_INPUT-(NB_SIGNO+1); //Posicion del bit mas significativo del exponente 
    localparam  NB_EXP_I= NB_INPUT-(NB_SIGNO+NB_EXPONENTE); //Posicion del bit menos significativo del exponente 
    
    //--Posiciones de los bit mas y menos significativos de la mantisa--
    localparam  NB_MAN_S= NB_EXP_I-1; //Posicion del bit mas significativo del exponente 
    //La posicion menos significativa de la mantisa es cero
    
    //--Otros parametros--
    localparam NB_MANTISA_T=(NB_INPUT-(NB_SIGNO+NB_EXPONENTE))*2; //! NB de la mantisa resultante de las dos mantisas
    
    //--Varaibles para almacenar resultados--
    wire [NB_MANTISA_T-1:0]                                                     mantisa;   //Bus de conexion para la el resultado de la mantisa
    wire [NB_EXP_S-NB_EXP_I+3:0]                                                exponente; //El 3 es pq hay dos sumas y una resta
    wire                                                                        signo;     //Bus de conexion para la el resultado del signo
    wire [NB_SESGO-1:0]                                                         sesgo;     //Bus de conexion para la el resultado del sesgo
    wire [NB_EXPONENTE+3+NB_SIGNO+((NB_INPUT-(NB_SIGNO+NB_EXPONENTE))*2)-1:0]   o_prod;    //Salida para el registro que almacena el resultado final
    reg  [NB_EXPONENTE+3+NB_SIGNO+((NB_INPUT-(NB_SIGNO+NB_EXPONENTE))*2)-1:0]   prod;      //Registro para almecenar el resultado de producto incluyendo el truncado de mantisa
    
    assign sesgo = {4'b0111}; //7 en binario le agrego un cero para que tenga misma cantidad de bits que el exponente

    //--Calculo multiplicacion--
    assign signo     = i_n1[NB_INPUT-1] ^ i_n2[NB_INPUT-1]; //Aplico XOR
    assign exponente = (i_n1[NB_EXP_S:NB_EXP_I]+sesgo)+(i_n2[NB_EXP_S:NB_EXP_I]+sesgo)-sesgo; //(e1+sesgo)+(e2+sesgo)-sesgo
    assign mantisa   = {i_n1[NB_MAN_S:0]*i_n2[NB_EXP_S:0]}; //Me falta truncar

    always @(posedge clock) begin
        if (i_reset == 1'b1) begin //Reset
            prod <= {NB_SAMPLE_A{1'b0}};
        end 
        else begin
            prod <= {signo,exponente,mantisa[NB_MANTISA_T-1 : (NB_MANTISA_T/2) - 1]}; //mantisa[NB_MANTISA_T-1 : (NB_MANTISA_T/2) - 1] --> Trunco la mantisa  a 8 bits eliminando los menos significativos         
        end
    end
    
    //--Resutaldo Final--
    assign o_prod=prod;

endmodule