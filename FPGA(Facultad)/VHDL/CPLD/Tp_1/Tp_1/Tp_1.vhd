----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:25:35 05/11/2017 
-- Design Name: 
-- Module Name:    Tp_1 - Behavioral 
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

entity Tp_1 is
port(	a: in std_logic;
		b: in std_logic;
		sel: in std_logic;
		salida: out std_logic);

end Tp_1;

architecture Behavioral of Tp_1 is
signal ax: std_logic;
signal bx: std_logic;
begin

ax<=a and (not sel);
bx<=b and sel;
salida<=ax or bx;

end Behavioral;

