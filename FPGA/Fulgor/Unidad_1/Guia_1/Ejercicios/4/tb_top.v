`timescale 1ns / 1ps
module tb_iir_filter();
   
   parameter NB_SAMPLE     = 9;  //! NB of Samples
   parameter NBF_SAMPLE    = 7;  //! NBF of Samples
   parameter NB_COEFF      = 15; //! NB of Coefficients
   parameter NBF_COEFF     = 13; //! NBF of Coefficients
   parameter N_COEFFS      = 4;  //! Number of Coefficients
   
   //--Inputs--
   wire signed [NB_SAMPLE - 1 : 0]  o_sample; //! Output Samples
   reg signed [NB_SAMPLE - 1 : 0]   i_sample; //! Input Samples
   reg 				                i_reset;  //! Reset
   reg 				                clock;    //! Clock
   reg 				                reset;    //! Local Reset
   real 			                i;        //! Pointer to FOR
   real 			                sinValue; //! Real Value of Sin
   reg signed [NB_SAMPLE - 1 : 0]   dataFp;   //! Fixed Value of Sin
   
   //--Instantiate the Unit Under Test (UUT)--
    filter_iir
        #(
            .NB_SAMPLE     (NB_SAMPLE),
            .NBF_SAMPLE    (NBF_SAMPLE),
            .NB_COEFF      (NB_COEFF),
            .NBF_COEFF     (NBF_COEFF),
            .N_COEFFS      (N_COEFFS)
        )
       u_filter_iir
        (
            .y_o (o_sample),
            .x_i (i_sample),
            .i_reset  (~i_reset),
            .clock    (clock)
        );
     
   //--Clock Generator--
    always #10 clock = ~clock;   

   //--Data register--
    always@(posedge clock) begin: regData
        i_sample <= dataFp;
        i_reset  <= reset;
    end
      
    //--initial begin--
    initial begin 
        reset   = 1;
        clock   = 0;
        dataFp  = 0;
        #100;
        reset   = 0;
        #100;
        for (i=0;i<4000;i=i+1) begin  
            sinValue = (0.5*$sin(2.0*3.1415926*i*15000.0/48000.0)+$sin(2.0*3.1415926*i*1000.0/48000.0))*(2**NBF_SAMPLE);
            dataFp = sinValue;
            #20;
        end
        $display("Simulation Finished");
        $display("");
        $finish;
    end 
endmodule
