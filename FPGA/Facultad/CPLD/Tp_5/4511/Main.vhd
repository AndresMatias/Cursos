----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:04:43 08/25/2017 
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
PORT(
		Ctrl : in std_logic_vector(2 downto 0);
		Bin : in std_logic_vector(3 downto 0);
		T : OUT std_logic;		
		Dis_7 : out std_logic_vector(6 downto 0)
	  );
end Main;

architecture Behavioral of Main is

COMPONENT Componente_4511
	PORT(
		Control : IN std_logic_vector(2 downto 0);
		Binario : IN std_logic_vector(3 downto 0);	
		Display_7 : OUT std_logic_vector(6 downto 0)
		);
	END COMPONENT;

	
begin

Conversor_1: Componente_4511 PORT MAP
	(
		Control => Ctrl ,
		Binario => Bin ,
		Display_7 => Dis_7 
	);
	
	T<='0';
end Behavioral;

