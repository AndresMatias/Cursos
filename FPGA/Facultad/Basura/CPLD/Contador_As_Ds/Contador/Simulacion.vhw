--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 10.1
--  \   \         Application : ISE
--  /   /         Filename : Simulacion.vhw
-- /___/   /\     Timestamp : Thu Nov 02 10:43:12 2017
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: Simulacion
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY Simulacion IS
END Simulacion;

ARCHITECTURE testbench_arch OF Simulacion IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT Contador
        PORT (
            A_D : In std_logic;
            Salida : Out std_logic_vector (2 DownTo 0);
            Clock : In std_logic
        );
    END COMPONENT;

    SIGNAL A_D : std_logic := '0';
    SIGNAL Salida : std_logic_vector (2 DownTo 0) := "000";
    SIGNAL Clock : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 100 ns;

    BEGIN
        UUT : Contador
        PORT MAP (
            A_D => A_D,
            Salida => Salida,
            Clock => Clock
        );

        PROCESS    -- clock process for Clock
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                Clock <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                Clock <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            BEGIN
                WAIT FOR 1200 ns;

            END PROCESS;

    END testbench_arch;

