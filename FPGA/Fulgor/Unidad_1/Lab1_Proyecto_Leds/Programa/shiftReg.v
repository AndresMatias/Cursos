module shiftreg
(
    parameter NB_LEDS = 4
)
(
    output [NB_LEDS-1:0] o_led, //!
    
    input        i_valid, //!  
    input        i_reset, //! 
    input        clock //! 
);

    //variables
    reg [NB_LEDS-1 : 0] shiftreg_r;

    //Only with for
    integer ptr;
    always @(posedge clock) begin
        if(i_reset) begin
            shiftreg_r <= {{NB_LEDS-1{1'b0}},1'b1}; //Ver {{NB_LEDS-1{1'b0}},1'b1 como asigna
        end
        if(i_valid) begin
            //****Formas de Desplazar bits****
            //--Forma 1--
            //shiftreg_r <= shiftreg_r << 1; //Desplazo un bit a la izquierda

            //--Forma 2--
            //shiftreg_r[0] <= shiftreg_r[NB_LEDS-1];

            //--Forma 3--
            //for(ptr=0,ptr<NB_LEDS;ptr=ptr+1) begin
            //    shiftreg_r[ptr+1] <= shiftreg_r[ptr];
            //end
            ///shiftreg_r[0] <= shiftreg_r[NB_LEDS-1]; //Ver video

            //--Forma 5--
            shiftreg_r <={shiftreg_r[2:0],shiftreg_r{NB_LEDS-1}};
        end
        else begin
            shiftreg_r <= shiftreg_r;
        end
        assign o_led <=shiftreg_r;
    end
endmodule