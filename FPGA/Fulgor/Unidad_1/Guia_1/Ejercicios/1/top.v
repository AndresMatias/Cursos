module top
    #(
        parameter  NB_DATAI=3, //! Nro de datos de entrada
        parameter  NB_DATAO=6, //! Nro de datos de salida
        parameter  NB_SEL=2    //! Nro de bits del selector del multiplexor
    )
    (
        output [NB_DATAO-1:0] o_data,     //! Salida Datos
        output                o_overflow, //! Leds Verdes

        input [NB_DATAI-1:0]  i_data1, //! Entrada de datos 1
        input [NB_DATAI-1:0]  i_data2, //! Entrada de datos 2
        input [1:0]           i_sel,   //! Seleccion multiplexor
        input                 i_rst_n, //! reset negado
        input                 clock    //! clock
    );
    //--Variables--
    //Logica multiplexor
    wire [NB_DATAI-1:0] multiplexor;  //! Multiplexor 
    wire [NB_DATAI-1:0] sum1_connect; //! Salida Sumador 1
    wire [NB_DATAO:0]   sum2_connect; //! Salida Sumador 2
    reg  [NB_DATAO-1:0] registro;     //! Salida registro
    reg                 overflow;     //! Salida overflow registro

    //Sumador 1(no funciona dentro del always a menos que asigne con un registro)
    assign sum1_connect = i_data1+i_data2;
    //Multiplexor(si uso case tengo que usar un registro para asignacion de valores)
    assign multiplexor = (i_sel==2'b00) ? {1'b0,i_data1} :
                         (i_sel==2'b01) ? sum1_connect :
                         (i_sel==2'b10) ? {1'b0,i_data2} : {1'b0};

    //Sumador 2
    assign sum2_connect = multiplexor + registro;
    
    always @(posedge clock) begin //Logica Secuencial
        if(i_rst_n)begin //Reset
            registro<={NB_DATAO-1{1'b0}};
            overflow<=1'b0;
        end
        else begin //Funcionamiento normal
            registro<=sum2_connect[5:0];
            overflow<=sum2_connect[6];
        end
    end
    
    //Asignaciones de salida
    assign o_data     = registro;
    assign o_overflow = overflow;
    
endmodule