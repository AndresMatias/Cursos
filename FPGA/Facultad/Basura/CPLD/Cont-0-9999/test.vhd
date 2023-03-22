--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   22:54:56 11/22/2016
-- Design Name:   
-- Module Name:   C:/Users/facun/Desktop/Lab 5/Cont-0-9999/test.vhd
-- Project Name:  Cont-0-9999
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: Counter_Top
-- 
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
-- This testbench has been automatically generated using types std_logic and
-- std_logic_vector for the ports of the unit under test.  Xilinx recommends
-- that these types always be used for the top-level I/O of a design in order
-- to guarantee that the testbench will bind correctly to the post-implementation 
-- simulation model.
--------------------------------------------------------------------------------
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY test IS
END test;
 
ARCHITECTURE behavior OF test IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT Counter_Top
    PORT(
         clock_50Mhz : IN  std_logic;
         reset : IN  std_logic;
         clock_sel : IN  std_logic;
         clock_push : IN  std_logic;
         enable_clk_osc : IN  std_logic;
         sseg : OUT  std_logic_vector(6 downto 0);
         an : OUT  std_logic_vector(3 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal clock_50Mhz : std_logic := '0';
   signal reset : std_logic := '0';
   signal clock_sel : std_logic := '0';
   signal clock_push : std_logic := '0';
   signal enable_clk_osc : std_logic := '0';

 	--Outputs
   signal sseg : std_logic_vector(6 downto 0);
   signal an : std_logic_vector(3 downto 0);

   -- Clock period definitions
   constant clock_50Mhz_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: Counter_Top PORT MAP (
          clock_50Mhz => clock_50Mhz,
          reset => reset,
          clock_sel => clock_sel,
          clock_push => clock_push,
          enable_clk_osc => enable_clk_osc,
          sseg => sseg,
          an => an
        );

   -- Clock process definitions
   clock_50Mhz_process :process
   begin
		clock_50Mhz <= '0';
		wait for clock_50Mhz_period;
		clock_50Mhz <= '1';
		wait for clock_50Mhz_period;
   end process;
 
 

-- Stimulus process
	stim_proc: process
	begin
		--Sample way of setting inputs - reset used as a redundant example.
		clock_sel <= '0';
		clock_push <= '1';
		wait for 1000ms;
	wait;
 end process;

END;
