----------------------------------------------------------------------------------
-- Module Name:    Mod5_LR_Up_Down - arch 
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Mod5_LR_Up_Down is
	port(
			clk50Mhz, clk_enable		:		in		std_logic;
			x								:		in		std_logic;
			bcd							:		out	std_logic_vector(2 downto 0);
			sseg							:		out	std_logic_vector(6 downto 0);
			an								:		out 	std_logic_vector(3 downto 0)
			);
end Mod5_LR_Up_Down;

architecture arch of Mod5_LR_Up_Down is
signal reset							:	std_logic;
signal FE								:	std_logic;
signal s0, s1, s2						:	std_logic;
signal d0, d1, d2						:	std_logic;
signal q0, q1, q2						:	std_logic;
signal not_q0, not_q1, not_q2		:	std_logic;
signal bcd_aux							:	std_logic_vector(2 downto 0);
signal clk_1Hz							:	std_logic;

begin
	
	clk_1Hz_unit	: entity work.clk_1Hz(arch)
	port map(
				clk 		=> clk50Mhz,
				reset 	=> reset,
				enable	=> clk_enable,
				clk_1Hz	=> clk_1Hz
				);
	
	FF_D0_unit	: entity work.FFD(arch)
	port map(
				clk 	=> clk_1Hz,
				reset => reset,
				d		=> FE,
				q		=> q0,
				not_q	=> not_q0
				);
	
	FF_D1_unit	: entity work.FFD(arch)
	port map(
				clk 	=> clk_1Hz,
				reset => reset,
				d		=> q0,
				q		=> q1,
				not_q	=> not_q1
				);
	
	FF_D2_unit	: entity work.FFD(arch)
	port map(
				clk 	=> clk_1Hz,
				reset => reset,
				d		=> q1,
				q		=> q2,
				not_q	=> not_q2
				);
	 
	FE		<= not_q2 and not_q1;
	reset	<= (q2 and q0) or (not_q2 and q1 and not_q0);
	s0		<= q1 xor q0;
	s1		<= (not(x) and q0) or (x and q1);
	s2		<= (x and q2 and not_q1) or (not(x) and not_q2 and not_q0);
	
	bcd_aux <= s2&s1&s0;
	bcd	  <= bcd_aux;
	
	with bcd_aux select        
	sseg <= 
	"0000001" when "000",	-- '0'
	"1001111" when "001",	-- '1'
	"0010010" when "010",	-- '2'
	"0000110" when "011",	-- '3'
	"1001100" when others;	-- '4'
	
	an <= "1110";
end arch;

