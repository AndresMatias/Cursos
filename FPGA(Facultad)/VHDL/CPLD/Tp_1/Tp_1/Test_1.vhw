--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 10.1.03
--  \   \         Application : ISE
--  /   /         Filename : Test_1.vhw
-- /___/   /\     Timestamp : Thu May 11 17:55:18 2017
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: Test_1
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY Test_1 IS
END Test_1;

ARCHITECTURE testbench_arch OF Test_1 IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT Tp_1
        PORT (
            a : In std_logic;
            b : In std_logic;
            sel : In std_logic;
            salida : Out std_logic
        );
    END COMPONENT;

    SIGNAL a : std_logic := '0';
    SIGNAL b : std_logic := '0';
    SIGNAL sel : std_logic := '0';
    SIGNAL salida : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 100 ns;

    BEGIN
        UUT : Tp_1
        PORT MAP (
            a => a,
            b => b,
            sel => sel,
            salida => salida
        );

        PROCESS    -- clock process for a
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                a <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                a <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            BEGIN
                -- -------------  Current Time:  185ns
                WAIT FOR 185 ns;
                b <= '1';
                sel <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  385ns
                WAIT FOR 200 ns;
                b <= '0';
                sel <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  585ns
                WAIT FOR 200 ns;
                b <= '1';
                sel <= '1';
                -- -------------------------------------
                WAIT FOR 615 ns;

            END PROCESS;

    END testbench_arch;

