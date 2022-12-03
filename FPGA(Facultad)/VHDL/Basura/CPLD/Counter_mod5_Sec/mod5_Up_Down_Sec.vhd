----------------------------------------------------------------------------------
-- Module Name:    mod5_Up_Down_Sec - arch 
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity mod5_Up_Down_Sec is
port(
			clk50Mhz, clk_enable		:		in		std_logic;
			x								:		in		std_logic;
			bcd							:		out	std_logic_vector(2 downto 0);
			sseg							:		out	std_logic_vector(6 downto 0);
			an								:		out 	std_logic_vector(3 downto 0)
			);
end mod5_Up_Down_Sec;

architecture arch of mod5_Up_Down_Sec is
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
				reset 	=> '0',
				enable	=> clk_enable,
				clk_1Hz	=> clk_1Hz
				);
	
	FF_D0_unit	: entity work.FFD(arch)
	port map(
				clk 	=> clk_1Hz,
				reset => '0',
				d		=> d0,
				q		=> q0,
				not_q	=> not_q0
				);
	
	FF_D1_unit	: entity work.FFD(arch)
	port map(
				clk 	=> clk_1Hz,
				reset => '0',
				d		=> d1,
				q		=> q1,
				not_q	=> not_q1
				);
	
	FF_D2_unit	: entity work.FFD(arch)
	port map(
				clk 	=> clk_1Hz,
				reset => '0',
				d		=> d2,
				q		=> q2,
				not_q	=> not_q2
				);
	
	
	d0	<=	(not(x) and q2 and not_q1 and not_q0) or
			(not_q2 and q1 and not_q0)	or
			(x and not_q2 and not_q0);
			
	d1 <=	(not(x) and q2 and not_q1 and not_q0) or
			(x and not_q2 and not_q1 and q0) or
			(not(x) and not_q2 and q1 and q0) or
			(x and not_q2 and q1 and not_q0);
			
	d2	<= (not(x) and not_q2 and not_q1 and not_q0) or
			(x and not_q2 and q1 and q0);
	
	s0		<= q0;
	s1		<= q1;
	s2		<= q2;
	
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
