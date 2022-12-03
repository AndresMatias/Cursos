--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   00:57:55 11/23/2016
-- Design Name:   
-- Module Name:   C:/Users/facun/Desktop/Lab 5/Counter_mod5_ShiftR/test.vhd
-- Project Name:  Counter_mod5_ShiftR
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: Mod5_LR_Up_Down
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
 
    COMPONENT Mod5_LR_Up_Down
    PORT(
         clk50Mhz : IN  std_logic;
         clk_enable : IN  std_logic;
         x : IN  std_logic;
         bcd : OUT  std_logic_vector(2 downto 0);
         sseg : OUT  std_logic_vector(6 downto 0);
         an : OUT  std_logic_vector(3 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal clk50Mhz : std_logic := '0';
   signal clk_enable : std_logic := '0';
   signal x : std_logic := '0';

 	--Outputs
   signal bcd : std_logic_vector(2 downto 0);
   signal sseg : std_logic_vector(6 downto 0);
   signal an : std_logic_vector(3 downto 0);

   -- Clock period definitions
   constant clk50Mhz_period : time := 10 ns;
   constant clk_enable_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: Mod5_LR_Up_Down PORT MAP (
          clk50Mhz => clk50Mhz,
          clk_enable => clk_enable,
          x => x,
          bcd => bcd,
          sseg => sseg,
          an => an
        );

   -- Clock process definitions
   clk50Mhz_process :process
   begin
		clk50Mhz <= '0';
		wait for clk50Mhz_period/2;
		clk50Mhz <= '1';
		wait for clk50Mhz_period/2;
   end process;
 
   clk_enable_process :process
   begin
		clk_enable <= '0';
		wait for clk_enable_period/2;
		clk_enable <= '1';
		wait for clk_enable_period/2;
   end process;
 

   -- Stimulus process
   stim_proc: process
   begin		
      -- hold reset state for 100 ns.
      wait for 100 ns;	

      wait for clk50Mhz_period*10;

      -- insert stimulus here 

      wait;
   end process;

END;
