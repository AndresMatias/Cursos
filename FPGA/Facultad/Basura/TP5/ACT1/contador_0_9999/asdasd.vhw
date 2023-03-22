--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 10.1.03
--  \   \         Application : ISE
--  /   /         Filename : asdasd.vhw
-- /___/   /\     Timestamp : Wed Oct 25 18:00:41 2017
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: asdasd
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY asdasd IS
END asdasd;

ARCHITECTURE testbench_arch OF asdasd IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT contador
        PORT (
            reloj : In std_logic;
            pulsador : In std_logic;
            llave : In std_logic;
            inicio : In std_logic;
            reset : In std_logic;
            display : Out std_logic_vector (6 DownTo 0);
            transistor1 : Out std_logic;
            transistor2 : Out std_logic;
            transistor3 : Out std_logic;
            transistor4 : Out std_logic
        );
    END COMPONENT;

    SIGNAL reloj : std_logic := '0';
    SIGNAL pulsador : std_logic := '0';
    SIGNAL llave : std_logic := '0';
    SIGNAL inicio : std_logic := '0';
    SIGNAL reset : std_logic := '0';
    SIGNAL display : std_logic_vector (6 DownTo 0) := "0000000";
    SIGNAL transistor1 : std_logic := '0';
    SIGNAL transistor2 : std_logic := '0';
    SIGNAL transistor3 : std_logic := '0';
    SIGNAL transistor4 : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 100 ns;

    BEGIN
        UUT : contador
        PORT MAP (
            reloj => reloj,
            pulsador => pulsador,
            llave => llave,
            inicio => inicio,
            reset => reset,
            display => display,
            transistor1 => transistor1,
            transistor2 => transistor2,
            transistor3 => transistor3,
            transistor4 => transistor4
        );

        PROCESS    -- clock process for reloj
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                reloj <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                reloj <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            BEGIN
                -- -------------  Current Time:  100ns
                WAIT FOR 100 ns;
                inicio <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  385ns
                WAIT FOR 285 ns;
                inicio <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  985ns
                WAIT FOR 600 ns;
                inicio <= '1';
                -- -------------------------------------
                WAIT FOR 9215 ns;

            END PROCESS;

    END testbench_arch;

