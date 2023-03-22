module top();
    parameter NB_INPUT = 13;    //! NB de entrada de los numeros
    parameter NB_EXPONENTE = 4; //! NB de mantisa del numero flotante
    parameter NB_SIGNO = 1;     //! NB de signo
    parameter NB_SESGO = 4;     //! NB de sesgo igual al del exponente para igualar
    
    wire signed [NB_EXPONENTE+3+NB_SIGNO+((NB_INPUT-(NB_SIGNO+NB_EXPONENTE))*2)-1:0]  o_sample; //! Output Samples
    reg 				                  reset;  //! Reset
    reg 				                  clock;    //! Clock
    prod_flotante
        #(
            .NB_INPUT(NB_INPUT),    //! NB de entrada de los numeros
            .NB_EXPONENTE(NB_EXPONENTE), //! NB de mantisa del numero flotante
            .NB_SIGNO(NB_SIGNO),     //! NB de signo
            .NB_SESGO(NB_SESGO)     //! NB de sesgo igual al del exponente para igualar
        )
        u_prod_flotante
        (
            .o_prod(o_sample),
            .i_n1(13'b1_0001_01000000),     //! Nro 1
            .i_n2(13'b1_0001_01000000),     //! Nro 2              
            .i_reset(reset),  //! reset negado
            .clock(clock)   
        );
        //! Sin generator
   initial 
      begin
         reset   = 1;
         clock   = 0;
         #100;
         reset   = 0;
         #100;
         $display("Simulation Finished");
         $display("");
         $finish;
   end // initial begin
endmodule