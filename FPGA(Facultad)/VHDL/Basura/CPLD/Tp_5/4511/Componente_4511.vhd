----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:03:31 08/25/2017 
-- Design Name: 
-- Module Name:    Componente_4511 - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

---- Uncomment the following library declaration if instantiating
---- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity Componente_4511 is
port(	Control:in std_logic_vector(2 downto 0); --Control(2):Enable, Control(1):Blancking, Control(0):Lamp Test
	 	Binario:in std_logic_vector(3 downto 0);
	 	Display_7:out std_logic_vector(6 downto 0)
	  );

end Componente_4511;

architecture Behavioral of Componente_4511 is
signal Vec: std_logic_vector(6 downto 0);
begin


with Binario select
	   Vec<= 	"1111110" when "0000", --0
					"0110000" when "0001",	--1
					"1101101" when "0010",	--2
					"1111001" when "0011",	--3
					"0110011" when "0100",	--4
					"1011011" when "0101",	--5
					"1011111" when "0110",	--6
					"1110000" when "0111",	--7
					"1111111" when "1000",	--8
					"1110011" when "1001",	--9
					"1001111" when "1010",	--E
					"1001111" when "1011",	--E
					"1001111" when "1100",	--E
					"1001111" when "1101",	--E
					"1001111" when "1110",	--E
					"1001111" when "1111",	--E
					"0000000" when others;
					 
with Control select
	Display_7<=  "1111111" when "000",
					 "0000000" when "001",
					 "1111111" when "010",
							 Vec when "011",
					 "1111111" when "100",
					 "0000000" when "101",
					 "1111111" when "110",
					 "1001111" when "111", --Reemplazar por E de error
					 "0000000" when others; 

end Behavioral;

