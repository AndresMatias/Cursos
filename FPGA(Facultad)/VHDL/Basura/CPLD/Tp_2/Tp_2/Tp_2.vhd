----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:40:16 05/18/2017 
-- Design Name: 
-- Module Name:    Tp_2 - Behavioral 
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

entity Tp_2 is
port(	Vec_E: in std_logic_vector(3 downto 0);--Si pongo "(0 to 3)" es mas significativo es el 3
		Display_7: out std_logic_vector(6 downto 0);
		Transistor:	out std_logic);
end Tp_2;

architecture Behavioral of Tp_2 is

begin
with Vec_E select
	 Display_7<="1111110"when"0000", --0
					"0110000"when"0001",	--1
					"1101101"when"0010",	--2
					"1111001"when"0011",	--3
					"0110011"when"0100",	--4
					"1011011"when"0101",	--5
					"1011111"when"0110",	--6
					"1110000"when"0111",	--7
					"1111111"when"1000",	--8
					"1110011"when"1001",	--9
					"1001111"when"1010",	--E
					"1001111"when"1011",	--E
					"1001111"when"1100",	--E
					"1001111"when"1101",	--E
					"1001111"when"1110",	--E
					"1001111"when"1111",	--E
					"0000000"when others;
Transistor<='0';			

end Behavioral;

