----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    13:37:45 10/25/2017 
-- Design Name: 
-- Module Name:    Contador - Behavioral 
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

entity Contador is

port(A_D:in std_logic;
	  Salida:out std_logic_vector(2 downto 0);
	  Clock:in std_logic
	  );

end Contador;

architecture Behavioral of Contador is

COMPONENT Flip_Flop_JK
	PORT(
		J : IN std_logic;
		K : IN std_logic;
		CLK : IN std_logic;          
		Q : OUT std_logic;
		Q_N : OUT std_logic
		);
	END COMPONENT;
signal J_aux: std_logic_vector(2 downto 0);   -- 3 Señales auxiliares para los datos de salida de los flipflops 
signal K_aux: std_logic_vector(2 downto 0);   -- 3 Señales auxiliares para los datos de salida de los flipflops
signal Q_aux: std_logic_vector(2 downto 0);   -- 3 Señales auxiliares para los datos de salida de los flipflops
signal Q_N_aux: std_logic_vector(2 downto 0); -- 3 Señales auxiliares para los datos de salida de los flipflops

begin 

Salida<=Q_aux;
J_aux(0)<=(((not A_D) and Q_aux(2) and Q_aux(1)) or (A_D and (not Q_aux(2)) and (not Q_aux(1))));
K_aux(0)<= '1';
J_aux(1)<=((A_D and Q_aux(0)) or ((not A_D) and Q_aux(2)));
K_aux(1)<=(((not A_D) and Q_aux(2)) or (A_D and (not Q_aux(2))));
J_aux(2)<=(((not A_D) and (not Q_aux(0))) or (A_D and Q_aux(0)) or (Q_aux(1)));
K_aux(2)<='1';
JK_0: Flip_Flop_JK PORT MAP
	(
		J => J_aux(0),
		K => K_aux(0),
		CLK => Clock,
		Q => Q_aux(0),
		Q_N => Q_N_aux(0)
	);
JK_1: Flip_Flop_JK PORT MAP
	(
		J => J_aux(1),
		K => K_aux(1),
		CLK => Clock,
		Q => Q_aux(1),
		Q_N => Q_N_aux(1)
	);
JK_2: Flip_Flop_JK PORT MAP
	(
		J => J_aux(2),
		K => K_aux(2),
		CLK => Clock,
		Q => Q_aux(2),
		Q_N => Q_N_aux(2)
	);

end Behavioral;

