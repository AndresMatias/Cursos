module cont
#(
    /*Parametros(Se pueden cambiar cada vez que instancio el modulo como si fuera una variable publica)*/
    parameter  NB_SW=3, //Cantidad de bits a nivel de swich
    parameter NB_COUNTER=32
)
(
    output      o_valid, //! salida para conectar internamente

    input [NB_SW-1:0] i_sw, //! swich
    input             i_reset, //! reset
    input             clock //! clock
);
    //localparam(No se pueden cambiar cada vez que instancio el modulo como si fuera una variable privada)
    localparam R0 = (2**(NB_COUNTER)-10)-1; //Valores para visualizaciones de los leds
    localparam R1 = (2**(NB_COUNTER)-9)-1;
    localparam R2 = (2**(NB_COUNTER)-8)-1;
    localparam R3 = (2**(NB_COUNTER)-7)-1;
    
    //variables
    wire [NB_COUNTER-1 : 0] limit_ref;
    reg [NB_COUNTER-1 : 0]  counter;
    reg                     valid;
    assign limit_ref = (i_sw[2:1]==2'b00) ? R0: //Si es true
                       (i_sw[2:1]==2'b01) ? R1:
                       (i_sw[2:1]==2'b10) ? R2:R3; //R3 seria el else
    
    always @(posedge clock) begin //como esta el clock se percibe como un registro
        // <= No Bloqueante(para logica secuncial)
        if(i_reset) begin
            //counter <= 0; //No asignar DE ESTA FORMA creo que pq ocupa un monton de espacio ese 0 como si fuera de 32 bits
            counter <= {NB_COUNTER{1'b0}}; //De esta forma el ancho de palabra solo ocupa el espacio necesario     
            valid <= 1b'0; //0
        end
        else if(i_sw[0]) begin
            if(conunter <= limit_ref) begin //Sigue contando
                counter <= counter+{{NB_COUNTER-1{1'b0}},1'b1}; //1; 
                valid <= 1b'1; //1
            end
            else begin //Se reseta el contador(Se recomienda escribir el else por temas de no generar lach...creo filmina clase 3)
                counter <= {NB_COUNTER{1'b0}};; //No combiene igualar con NB_Counter por el ancho de palabra?
                valid <= 1b'0; //0
            end
        end
        assign o_valid=valid;
    end
endmodule