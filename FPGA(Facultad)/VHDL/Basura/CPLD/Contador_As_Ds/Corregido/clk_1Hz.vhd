---------------------------------------------------------------------------------- 
-- Module Name:    clk_1Hz - arch 
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.numeric_std. all ; 

entity clk_1Hz is
port(

		clk				:	in		std_logic;
		reset,enable	:	in		std_logic;
		clk_1Hz			:	out	std_logic
);
end clk_1Hz;

architecture arch of clk_1Hz is
	constant DVSR	:	integer :=5000000;
	signal s_reg , s_next : unsigned (25 downto 0);
	signal s_tick	:	std_logic;

begin
	
	process(clk)
	begin
		if(clk'event and clk ='1') then 
			s_reg <= s_next;
		end if;
	end process;
	
	s_next <= (others => '0') when ((s_reg = DVSR and enable ='1')) else
				 s_reg + 1 		  when (enable = '1') else
				 s_reg;
	s_tick <= '1' when (s_reg = DVSR) else 
				 '0';
	
	clk_1Hz <=	s_tick;
end arch;

