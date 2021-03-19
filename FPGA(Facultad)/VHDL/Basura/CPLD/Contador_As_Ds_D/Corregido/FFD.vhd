----------------------------------------------------------------------------------
-- Module Name:    FFD - arch 
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity FFD is
	port (
			clk, reset		:		in 	std_logic;
			d					:		in 	std_logic;
			q, not_q			: 		out	std_logic
			);
end FFD;

architecture arch of FFD is
begin
	process (clk, reset) 
	begin
		if (reset = '1') then
			q <= '0';
			not_q <= '1';
		elsif (clk'event and clk = '1') then 
			q <=(d);
			not_q <=not(d);
		end if;
	end process;

end arch;

