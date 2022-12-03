----------------------------------------------------------------------------------
-- Module Name:    Counter_Top - arch 
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Counter_Top is
port(
		clock_50Mhz, reset			:	in std_logic;
		clock_sel, clock_push		:	in std_logic;
		enable_clk_osc					:	in std_logic;
		sseg								: out std_logic_vector (6 downto 0);
		an									: out std_logic_vector (3 downto 0)
	);
end Counter_Top;

architecture arch of Counter_Top is
signal bcd0, bcd1, bcd2, bcd3		:	std_logic_vector(3 downto 0); 

begin

Counter_unit: entity work.Counter(arch)
	port map(
				clk_50Mhz 		=> clock_50Mhz,									
				clk_sel	 		=> clock_sel,				
				clock_button 	=> clock_push,
				enable			=> enable_clk_osc,
				reset				=> reset,
				bcd0				=> bcd0,
				bcd1				=> bcd1,
				bcd2 				=> bcd2,
				bcd3				=> bcd3
				);

sseg_driver_unit: entity work.sseg_mux(arch)
	port map(
				clk 	=> clock_50Mhz,
				reset	=> reset,
				in3	=> bcd3,
				in2	=> bcd2,
				in1	=> bcd1,
				in0	=> bcd0,
				sseg	=>	sseg,							
				an		=> an							
	);

end arch;

