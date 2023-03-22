--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 10.1
--  \   \         Application : ISE
--  /   /         Filename : TP3_Ejercicio_2_bench.vhw
-- /___/   /\     Timestamp : Thu Jun 08 10:09:27 2017
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: TP3_Ejercicio_2_bench
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY TP3_Ejercicio_2_bench IS
END TP3_Ejercicio_2_bench;

ARCHITECTURE testbench_arch OF TP3_Ejercicio_2_bench IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT TP3_Ejercicio_2142
        PORT (
            bin : In std_logic_vector (4 DownTo 0);
            A : In std_logic;
            B : In std_logic;
            C : In std_logic;
            bout : Out std_logic_vector (4 DownTo 0);
            bce_out : Out std_logic;
            LED : Out std_logic_vector (6 DownTo 0)
        );
    END COMPONENT;

    SIGNAL bin : std_logic_vector (4 DownTo 0) := "00000";
    SIGNAL A : std_logic := '0';
    SIGNAL B : std_logic := '0';
    SIGNAL C : std_logic := '0';
    SIGNAL bout : std_logic_vector (4 DownTo 0) := "00000";
    SIGNAL bce_out : std_logic := '0';
    SIGNAL LED : std_logic_vector (6 DownTo 0) := "0000000";

    BEGIN
        UUT : TP3_Ejercicio_2142
        PORT MAP (
            bin => bin,
            A => A,
            B => B,
            C => C,
            bout => bout,
            bce_out => bce_out,
            LED => LED
        );

        PROCESS
            BEGIN
                -- -------------  Current Time:  100ns
                WAIT FOR 100 ns;
                A <= '1';
                B <= '1';
                bin <= "10000";
                -- -------------------------------------
                -- -------------  Current Time:  200ns
                WAIT FOR 100 ns;
                B <= '0';
                bin <= "11000";
                -- -------------------------------------
                -- -------------  Current Time:  300ns
                WAIT FOR 100 ns;
                C <= '1';
                bin <= "11010";
                -- -------------------------------------
                -- -------------  Current Time:  400ns
                WAIT FOR 100 ns;
                bin <= "11011";
                -- -------------------------------------
                -- -------------  Current Time:  500ns
                WAIT FOR 100 ns;
                A <= '0';
                bin <= "10011";
                -- -------------------------------------
                -- -------------  Current Time:  600ns
                WAIT FOR 100 ns;
                B <= '1';
                C <= '0';
                bin <= "10000";
                -- -------------------------------------
                -- -------------  Current Time:  700ns
                WAIT FOR 100 ns;
                C <= '1';
                bin <= "01000";
                -- -------------------------------------
                -- -------------  Current Time:  800ns
                WAIT FOR 100 ns;
                B <= '0';
                C <= '0';
                bin <= "00011";
                -- -------------------------------------
                WAIT FOR 200 ns;

            END PROCESS;

    END testbench_arch;

