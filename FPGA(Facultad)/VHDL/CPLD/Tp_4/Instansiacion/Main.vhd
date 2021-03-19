----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:56:00 06/29/2017 
-- Design Name: 
-- Module Name:    Main - Behavioral 
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

entity Main is
port(	nro1:in std_logic_vector(3 downto 0);
		nro2:in std_logic_vector(3 downto 0);
		cin:in std_logic;
		cout:out std_logic;
		suma:out std_logic_vector(3 downto 0));
end Main;

architecture Behavioral of Main is

signal sAux: std_logic_vector(2 downto 0);

COMPONENT Sumador
port(cin,x,y: in STD_LOGIC;
		cout,s: out STD_LOGIC);
	END COMPONENT;

begin

	Componente1: Sumador PORT MAP(
						cin=>cin,
						x=>nro1(0),
						y=>nro2(0),
						s=>suma(0),
						cout=>sAux(0)
						);
	Componente2: Sumador PORT MAP(
						cin=>sAux(0),
						x=>nro1(1),
						y=>nro2(1),
						s=>suma(1),
						cout=>sAux(1)
						);
	Componente3: Sumador PORT MAP(
						cin=>sAux(1),
						x=>nro1(2),
						y=>nro2(2),
						s=>suma(2),
						cout=>sAux(2)
						);
	Componente4: Sumador PORT MAP(
						cin=>sAux(2),
						x=>nro1(3),
						y=>nro2(3),
						s=>suma(3),
						cout=>cout
						);

end Behavioral;

