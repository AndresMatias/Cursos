--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 10.1.03
--  \   \         Application : ISE
--  /   /         Filename : simulacion.vhw
-- /___/   /\     Timestamp : Thu Jun 08 15:58:45 2017
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: simulacion
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY simulacion IS
END simulacion;

ARCHITECTURE testbench_arch OF simulacion IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT Tp_2
        PORT (
            Vec_E : In std_logic_vector (3 DownTo 0);
            Display_7 : Out std_logic_vector (6 DownTo 0);
            Transistor : Out std_logic
        );
    END COMPONENT;

    SIGNAL Vec_E : std_logic_vector (3 DownTo 0) := "0000";
    SIGNAL Display_7 : std_logic_vector (6 DownTo 0) := "0000000";
    SIGNAL Transistor : std_logic := '0';

    BEGIN
        UUT : Tp_2
        PORT MAP (
            Vec_E => Vec_E,
            Display_7 => Display_7,
            Transistor => Transistor
        );

        PROCESS
            BEGIN
                -- -------------  Current Time:  200ns
                WAIT FOR 200 ns;
                Vec_E <= "0001";
                -- -------------------------------------
                -- -------------  Current Time:  300ns
                WAIT FOR 100 ns;
                Vec_E <= "0010";
                -- -------------------------------------
                -- -------------  Current Time:  400ns
                WAIT FOR 100 ns;
                Vec_E <= "0011";
                -- -------------------------------------
                -- -------------  Current Time:  500ns
                WAIT FOR 100 ns;
                Vec_E <= "0100";
                -- -------------------------------------
                -- -------------  Current Time:  600ns
                WAIT FOR 100 ns;
                Vec_E <= "0101";
                -- -------------------------------------
                -- -------------  Current Time:  700ns
                WAIT FOR 100 ns;
                Vec_E <= "0110";
                -- -------------------------------------
                -- -------------  Current Time:  800ns
                WAIT FOR 100 ns;
                Vec_E <= "0111";
                -- -------------------------------------
                -- -------------  Current Time:  900ns
                WAIT FOR 100 ns;
                Vec_E <= "0000";
                -- -------------------------------------
                WAIT FOR 100 ns;

            END PROCESS;

    END testbench_arch;

