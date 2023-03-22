module prod_flotante
    #(
        parameter NB_INPUT     = 16,    //! NB de entrada de los numeros
    )
    (
        output []  o_prod,     //! Salida del producto 
        input  [NB_INPUT - 1 : 0]  i_n1,       //! Nro 1
        input  [NB_INPUT - 1 : 0]  i_n2,       //! Nro 2
        input                      i_us1,      //! Control signed/unisgned de Nro 1
        input                      i_us2,      //! Control signed/unisgned de Nro 2
        input                      i_fi,       //! Control integer/fractional         
        input                      i_reset,    //! reset negado
        input                      clock       //! clock
    );

    //--Variables--
    wire [] mux_1;     //!Multiplexor 1
    wire [] mux_2;     //!Multiplexor 2
    wire [] bus_mul_1; //!Bus de conexion entre la salida del multiplexor 1 en union con el nro 1 y la entrada al multiplicador del nro 1
    wire [] bus_mul_2; //!Bus de conexion entre la salida del multiplexor 1 en union con el nro 2 y la entrada al multiplicador del nro 1
    //reg  [] in_prod;    //!Entrada del Multiplicador
    reg  [] out_prod;  //!Salida del Multiplicador
    wire [] bus_mul;   //!Multiplexor a la salida del multiplicador
    

    //--Multiplexores controlados por el control de signo--
    assign mux_1 = (i_us1==2'b00) ? {i_n1[14]} : {1'b0}
    assign mux_2 = (i_us2==2'b00) ? {i_n2[14]} : {1'b0}

    //--Bus de conexion entre la entrada de los multiplicadores y la union de cada nro con la salida de cada multiplexor--
    assign bus_mul_1={mux_1,i_n1};
    assign bus_mul_2={mux_2,i_n2};

    //--Multiplicador--
    always @(posedge clock) begin
        if (i_reset == 1'b1) begin //Reset
            //out_prod <= {NB_SAMPLE_A{1'b0}};
        end 
        else begin
            out_prod <= bus_mul_1*bus_mul_2;
        end
    end

    //--Truncado, Redondeo y multiplexor--
    bus_mul = ((i_us1*i_us2*i_fi)==1'b0) ? :



endmodule