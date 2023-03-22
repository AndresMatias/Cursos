// Definitions
`define N_DATAI 3
`define N_DATAO 6
`define NB_SEL 2
`define NB_COUNT 14
`define NB_SW 2

`timescale 1ns/100ps

module tb_shiftleds();

  // Parameters
  parameter N_DATAI   = `N_DATAI ; //!Number of bits of the data input (3)
  parameter N_DATAO   = `N_DATAO ; //!Number of bits of the data ouput (6)
  parameter NB_SEL    = `NB_SEL  ; //! Number of bits of the selectors (2)


  wire [N_DATAO - 1 : 0] o_data    ; //! 
  wire                   o_overflow; //! 
  reg  [N_DATAI - 1 : 0] i_data1    ; //! Entrada de Datos 1
  reg  [N_DATAI - 1 : 0] i_data2    ; //! Entrada de Datos 2
  reg  [NB_SEL - 1 : 0]  i_sw       ; //! Switchs
  reg                    i_reset    ; //! Reset
  reg                    clock      ; //! System clock

  integer i;
  //! Stimulus by initial
  initial begin: stimulus
      //**Condiciones Iniciales**
      i_sw         = {NB_SEL{1'b0}};
      i_data1      = {N_DATAI{1'b0}}; 
      i_data2      = {N_DATAI{1'b0}};      
      clock        = 1'b0  ;
      i_reset      = 1'b0  ;

      //--Reseteo--
      #10 i_reset = 1'b1  ;
      #60 i_reset = 1'b0  ;
      
      //****Condiciones de simulacion****
      //*********************************
      //i_sw <= 2'b01;
      i_data1 = 3'b010;
      //--Multiplexor--
      for (i = 0;i<4 ;i=i+1 ) begin
        #100 i_sw <= i ;
      end
    
      /*
      //--Entrada de datos a sumar--
      for (i = 0;i<8 ;i=i+1 ) begin //Caso 1 suma de numeros iguales
        #100 i_data1 = i ;
        #100 i_data2 = i ;
      end

      for (i = 0;i<8 ;i=i+1 ) begin //Caso 2 un numero en cero y solo el otro aumenta
        #100 i_data1 = i ;
        #100 i_data2 = 0 ;
      end

      for (i = 0;i<8 ;i=i+1 ) begin //Caso 3 igual que caso 2 solo que cambia para la entrada de datos
        #100 i_data1 = 0 ;
        #100 i_data2 = i ;
      end
    
      for (i = 0;i<8 ;i=i+1 ) begin //Caso 4 un numero va mas adelante por una unidad
        #100 i_data1 = i+1 ;
        #100 i_data2 = i ;
      end*/


      //--Finaliza Simulacion
      #1000000 $finish;
  end

  //! Clock generator
  always #5 clock = ~clock;

  //! Instance of shiftleds module
  top
    #(
      .NB_DATAI   (N_DATAI  ),
      .NB_DATAO   (N_DATAO  ),
      .NB_SEL     (NB_SEL   )
      )
    u_top
      (
      .o_data     (o_data)  ,
      .o_overflow (o_overflow)  ,
      .i_data1    (i_data1)  ,
      .i_data2    (i_data2)  ,
      .i_sel      (i_sw   )  ,
      .i_rst_n    (i_reset)  ,
      .clock      (clock  )
      );

endmodule // tb_shiftleds