----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:25:13 10/26/2017 
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
port(E,clk:in std_logic;
	  Salida:out std_logic_vector(2 downto 0)
	  );
end Main;

architecture Behavioral of Main is

COMPONENT Flip_Flop_D
	PORT(
		D : IN std_logic;
		CLK : IN std_logic;          
		Q : OUT std_logic;
		Q_N : OUT std_logic
		);
		
	END COMPONENT;
signal Q_aux,Q_N_aux,D_aux: std_logic_vector(2 downto 0);
begin
D_aux(0)<=(((not E) and (not Q_aux(0)) and (not Q_aux(1)) and (not Q_aux(2))) or (E and Q_aux(1) and Q_aux(2)));
D_aux(1)<=(((not E) and Q_aux(0) and (not Q_aux(1))) or ((not E) and Q_aux(1) and Q_aux(2)) or (E and (not Q_aux(1)) and Q_aux(2)) or (E and Q_aux(1) and (not Q_aux(2))));
D_aux(2)<=((Q_aux(1) and (not Q_aux(2))) or ((not E) and Q_aux(1)) or (E and (not Q_aux(1)) and (not Q_aux(2))));
FF_D_0: Flip_Flop_D PORT MAP(
		D =>D_aux(0),
		CLK => clk,
		Q =>Q_aux(0),
		Q_N => Q_N_aux(0)
	);
FF_D_1: Flip_Flop_D PORT MAP(
		D =>D_aux(1),
		CLK => clk,
		Q =>Q_aux(1),
		Q_N => Q_N_aux(1)
	);
FF_D_2: Flip_Flop_D PORT MAP(
		D =>D_aux(2),
		CLK => clk,
		Q =>Q_aux(2),
		Q_N => Q_N_aux(2)
	);
Salida<=Q_aux;	
end Behavioral;

