module top
(
    parameter  NB_SW=3,
    parameter NB_COUNTER=32,
    parameter NB_LEDS = 4
)
(
    /*Defino pines de entrada y/o salida*/
    output [NB_LEDS-1:0] o_led, //! Salida de 4 bits siendo el bit mas significativo empezando por el 3 aunque puede ser a la inversa
    output [NB_LEDS-1:0] o_led_b, //! Leds Azules
    output [NB_LEDS-1:0] o_led_g, //! Leds Verdes

    input [NB_SW-1:0] i_sw, //! swich
    input             i_reset, //! reset
    input             clock //! clock
);

    //--Varaibles--
    wire connect_count2sr_valid;
    wire [NB_LEDS-1 : 0] leds_w;
    cont //Instancio cont
        #(
            .NB_SW      (NB_SW-1), //A mi derecha pertenece a top y a mi izquierda hace referencia al parametro de cont
            .NB_COUNTER (NB_COUNTER)
        )
        u_cont(
            .o_valid(connect_count2sr_valid),
            .i_sw   (i_sw[NB_SW-2:0]),
            .i_reset(i_reset),
            .clock  (clock)
    );

    shiftreg //Instancio shiftreg
        #(
            .NB_LEDS    (NB_LEDS)
        )
        u_shiftreg(
            .o_led(leds_w),
            .i_valid(connect_count2sr_valid),
            .i_reset(i_reset),
            .clock(clock)
    );

    assign o_led=leds_w;
    assign o_led_b=(i_sw[NB_SW-1]==1'b1) ? leds_w: 4'b0000;
    assign o_led_g=(i_sw[NB_SW-1]==1'b0) ? leds_w: 4'b0000;
endmodule
