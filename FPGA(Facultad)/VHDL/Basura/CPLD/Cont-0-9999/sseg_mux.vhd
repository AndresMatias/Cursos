----------------------------------------------------------------------------------
-- Module Name:    sseg_mux - arch 
----------------------------------------------------------------------------------
library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity sseg_mux is
   port(
      clk, reset					: 	in std_logic;
      in3, in2, in1, in0		: 	in std_logic_vector(3 downto 0);
		sseg							:	out	std_logic_vector(6 downto 0);
      an								: 	out std_logic_vector(3 downto 0)
   );
end sseg_mux;

architecture arch of sseg_mux is
   -- refreshing rate around 800 Hz (50MHz/2^16)
   constant N: integer:=18;
   signal q_reg, q_next: unsigned(N-1 downto 0);
	
	signal	sseg0_next, sseg1_next, sseg2_next, sseg3_next	: std_logic_vector(6 downto 0);
	signal	sseg0_reg, sseg1_reg, sseg2_reg, sseg3_reg		: std_logic_vector(6 downto 0);
	

   signal sel: std_logic_vector(1 downto 0);
begin
   -- register
   process(clk,reset)
   begin
      if reset='1' then
         q_reg <= (others=>'0');
			sseg0_reg <= (others=>'0');
			sseg1_reg <= (others=>'0');
			sseg2_reg <= (others=>'0');
			sseg3_reg <= (others=>'0');
			
      elsif (clk'event and clk='1') then
         q_reg <= q_next;
			sseg0_reg <= sseg0_next;
			sseg1_reg <= sseg1_next;
			sseg2_reg <= sseg2_next;
			sseg3_reg <= sseg3_next;
      end if;
   end process;
	
	
	with in0 select        
	sseg0_next <= 
	"0000001" when "0000",-- '0'
	"1001111" when "0001",-- '1'
	"0010010" when "0010",-- '2'
	"0000110" when "0011",-- '3'
	"1001100" when "0100",-- '4'
	"0100100" when "0101",-- '5'
	"0100000" when "0110",-- '6'
	"0001111" when "0111",-- '7'
	"0000000" when "1000",-- '8'
	"0000100" when "1001",-- '9'
	"1111110" when others; -- '-'
	
	with in1 select        
	sseg1_next <= 
	"0000001" when "0000",-- '0'
	"1001111" when "0001",-- '1'
	"0010010" when "0010",-- '2'
	"0000110" when "0011",-- '3'
	"1001100" when "0100",-- '4'
	"0100100" when "0101",-- '5'
	"0100000" when "0110",-- '6'
	"0001111" when "0111",-- '7'
	"0000000" when "1000",-- '8'
	"0000100" when "1001",-- '9'
	"1111110" when others; -- '-'
	
	with in2 select        
	sseg2_next <= 
	"0000001" when "0000",-- '0'
	"1001111" when "0001",-- '1'
	"0010010" when "0010",-- '2'
	"0000110" when "0011",-- '3'
	"1001100" when "0100",-- '4'
	"0100100" when "0101",-- '5'
	"0100000" when "0110",-- '6'
	"0001111" when "0111",-- '7'
	"0000000" when "1000",-- '8'
	"0000100" when "1001",-- '9'
	"1111110" when others; -- '-'
	
	with in3 select        
	sseg3_next <= 
	"0000001" when "0000",-- '0'
	"1001111" when "0001",-- '1'
	"0010010" when "0010",-- '2'
	"0000110" when "0011",-- '3'
	"1001100" when "0100",-- '4'
	"0100100" when "0101",-- '5'
	"0100000" when "0110",-- '6'
	"0001111" when "0111",-- '7'
	"0000000" when "1000",-- '8'
	"0000100" when "1001",-- '9'
	"1111110" when others; -- '-'
	 

   -- next-state logic for the counter
   q_next <= q_reg + 1;

   -- 2 MSBs of counter to control 4-to-1 multiplexing
   -- and to generate active-low enable signal
   sel <= std_logic_vector(q_reg(N-1 downto N-2));
   process(sel,sseg0_reg,sseg1_reg,sseg2_reg,sseg3_reg)
	  begin
			case sel is
				when "00" =>
					an <= "1110";
					--an <= "0001";	--active high
					sseg <= sseg0_reg;
				when "01" =>
					an <= "1101";
					--an <= "0010";
					sseg <= sseg1_reg;
				when "10" =>
					an <= "1011";
					--an <= "0100";
					sseg <= sseg2_reg;
				when others =>
					an <= "0111";
					--an <= "0100";
					sseg <= sseg3_reg;
			end case;
	end process;

end arch;