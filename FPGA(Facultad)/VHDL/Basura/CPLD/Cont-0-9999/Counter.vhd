----------------------------------------------------------------------------------
-- Create Date:    10:01:41 11/21/2016 
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity Counter is
	port(
			clk_50Mhz										:	in		std_logic;
			clk_sel											:	in 	std_logic;
			clock_button									:	in 	std_logic;
			enable											:	in		std_logic;
			reset												:	in		std_logic;
			bcd0, bcd1, bcd2, bcd3						:	out 	std_logic_vector (3 downto 0)		
		);
end Counter;

architecture arch of Counter is
signal clk														:	std_logic;
signal clk_osc													:	std_logic;
signal bcd0_next, bcd1_next, bcd2_next, bcd3_next	:	std_logic_vector (3 downto 0);
signal bcd0_reg, bcd1_reg, bcd2_reg, bcd3_reg		:	std_logic_vector (3 downto 0);
	
begin
------------------------------------------------------------		
--//////////// Reloj  a 1 seg //////////////
------------------------------------------------------------	
clk_1Hz_unit: entity work.clk_1Hz(arch)
	port map(
				enable=>enable,
				clk=>clk_50Mhz,
				clk_1Hz=>clk_osc,
				reset=>reset
				);
------------------------------------------------------------
--##########################################################
------------------------------------------------------------

------------------------------------------------------------		
--//////////// ASIGNACION DE REGISTROS //////////////
------------------------------------------------------------			
process (clk, reset)
begin 
	if (reset = '1') then
		bcd0_reg <= (others=>'0');
		bcd1_reg <= (others=>'0');
		bcd2_reg <= (others=>'0');
		bcd3_reg <= (others=>'0');
	
	elsif(clk_50Mhz'event and clk_50Mhz = '1') then
		bcd0_reg <= bcd0_next;
		bcd1_reg <= bcd1_next;
		bcd2_reg <= bcd2_next;
		bcd3_reg <= bcd3_next;
	end if;
end process;
------------------------------------------------------------
--##########################################################
------------------------------------------------------------

------------------------------------------------------------		
--//////////// Selector de la fuente del clk //////////////
------------------------------------------------------------
process(clk_sel, clk, clk_osc, clock_button)
begin
	if(clk_sel = '1') then
		clk <= clk_osc;			--clk derivado del contador de 1Hz
	else
		clk <= clock_button;		--clk derivado del contador del pulsador
	end if;
end process;
------------------------------------------------------------
--##########################################################
------------------------------------------------------------

------------------------------------------------------------		
--//////////// Algoritmo contador BCD //////////////
------------------------------------------------------------
process(clk, reset)
begin
	if (clk'event and clk='1') then	
		if(bcd0_reg = 9) then
			bcd0_next <= (others=>'0');
			if(bcd1_reg = 9) then
				bcd1_next <= (others=> '0');
				if(bcd2_reg = 9) then
					bcd2_next <= (others=> '0');
					if(bcd3_reg = 9) then
						bcd3_next <= (others=> '0');
					else
						bcd3_next <= bcd3_reg + 1;
					end if;
				else
					bcd2_next <= bcd2_reg + 1;
				end if;
			else
				bcd1_next <= bcd1_reg +1;
			end if;
		else
			bcd0_next <= bcd0_reg +1;
		end if;
	end if;
end process;

------------------------------------------------------------		
--//////////// Salida contador BCD //////////////
------------------------------------------------------------
	
	bcd0 <= bcd0_reg;
	bcd1 <= bcd1_reg;
	bcd2 <= bcd2_reg;
	bcd3 <= bcd3_reg;
	
------------------------------------------------------------
--##########################################################
------------------------------------------------------------

end arch;
