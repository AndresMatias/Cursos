----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:54:06 10/25/2017 
-- Design Name: 
-- Module Name:    Flip_Flop_JK - Behavioral 
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

entity Flip_Flop_JK is
port(J,K,CLK:in std_logic;
	  Q,Q_N:out std_logic
	  );
end Flip_Flop_JK;

architecture Behavioral of Flip_Flop_JK is
signal JK: std_logic_vector(1 downto 0);
signal Q_aux: std_logic;
begin
process(CLK) --Actualizo Estados
begin
	if CLK 'event and CLK='1' then
	Q<=Q_aux;
	Q_N<=(not Q_aux);
	end if;
end process;

JK<=J&K; --Logica de Conmutacion
with JK select
	Q_aux <= Q_aux when "00",
		 '0' when "01",
		 '1' when "10",
  (not Q_aux) when others;
  
end Behavioral;

