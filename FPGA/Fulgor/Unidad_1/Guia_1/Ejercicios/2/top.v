module top_2
    #(
        parameter NB_DATAI = 16, //! Numbers of Bits input data
        parameter NB_DATAO = 16 //! Numbers of Bits output data
    )
    (
        output [NB_DATAO-1:0] o_dataC, //! Output data

        input [NB_DATAI-1:0]  i_dataA, //! Input data A
        input [NB_DATAI-1:0]  i_dataB, //! Input data B
        input [1:0]           i_sel,   //! Multiplexer selector
        input                 i_reset, //! Reset
        input                 clock    //! Clock
    );
    //--Variables--
    wire signed [NB_DATAI-1:0] connectSumAB  ; //! Addition signed Operation Bus
    wire signed [NB_DATAI-1:0] connectRestAB ; //! Subtraction signed Operation Bus
    wire signed [NB_DATAI-1:0] connectAndAB  ; //! And signed Operation Bus
    wire signed [NB_DATAI-1:0] connectOrAB   ; //! Or signed Operation Bus
    wire        [NB_DATAO-1:0] multiplexer   ; //! Multiplexer
    reg  signed [NB_DATAO-1:0] data          ; //! Output Data 

    //--Operations--
    assign connectSumAB  = i_dataA+i_dataB ;
    assign connectRestAB = i_dataA-i_dataB ; 
    assign connectAndAB  = i_dataA&i_dataB ; 
    assign connectOrAB   = i_dataA|i_dataB ; 

    //--Multiplexer--
    assign multiplexer = (i_sel==2'b00) ? connectSumAB : 
                         (i_sel==2'b01) ? connectRestAB :
                         (i_sel==2'b10) ? connectAndAB : connectOrAB;
    
    //--Register--
    always @(posedge clock or i_reset) begin
        if(i_reset)begin //Reseto
            data <= {NB_DATAO-1{1'b0}};
        end 
        else begin //Asigno Valor
            data <= multiplexer;
        end       
    end
    assign o_dataC=data;
endmodule