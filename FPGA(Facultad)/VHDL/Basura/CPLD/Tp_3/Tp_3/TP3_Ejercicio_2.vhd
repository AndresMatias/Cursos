----------------------------------------------------------------------------------

----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity TP3_Ejercicio_2 is

    Port ( bit_in : in  STD_LOGIC_VECTOR (4 downto 0);
           bit_out : out  STD_LOGIC_VECTOR (4 downto 0);
			  LED : out std_logic_vector (6 downto 0);
			  A : IN STD_LOGIC;
			  B : IN STD_LOGIC;
			  C : IN STD_LOGIC;
			  bit_out_ce : out std_logic); --bit_in con el error
			 
end TP3_Ejercicio_2;

architecture Behavioral of TP3_Ejercicio_2 is
signal kp : std_logic_vector (3 downto 0); --k_paridad
signal kc : std_logic_vector (3 downto 0); --k_control
signal bit_ce : std_logic_vector (4 downto 0); --bit con error
signal deteccion : std_logic_vector (3 downto 0);
signal vde : std_logic_vector (4 downto 0); --valores de error
signal control : std_logic_vector (2 downto 0);
signal bit_in_ce : std_logic;


begin

--k de paridad
kp(3) <= bit_in(4);
kp(2) <= bit_in(3) xor bit_in(2) xor bit_in(1);
kp(1) <= bit_in(3) xor bit_in(2) xor bit_in(0);
kp(0) <= bit_in(4) xor bit_in(3) xor bit_in(1) xor bit_in(0);

--generacion de error
vde(4) <= A and (not B) and C;
vde(3) <= A and (not B) and (not C);
vde(2) <= (not A) and B and C;
vde(1) <= (not A) and B and (not C);
vde(0) <= (not A) and (not B) and C;

	--bit con errores
	bit_ce(4) <= vde(4) xor bit_in(4);
	bit_ce(3) <= vde(3) xor bit_in(3);
	bit_ce(2) <= vde(2) xor bit_in(2);
	bit_ce(1) <= vde(1) xor bit_in(1);
	bit_ce(0) <= vde(0) xor bit_in(0);
	
	--k de control
	kc(3) <= bit_ce(4);
	kc(2) <= bit_ce(3) xor bit_ce(2) xor bit_ce(1);
	kc(1) <= bit_ce(3) xor bit_ce(2) xor bit_ce(0);
	kc(0) <= bit_ce(4) xor bit_ce(3) xor bit_ce(1) xor bit_ce(0);
	
		--deteccion del error
		deteccion(3) <= kc(3) xor kp(3);
		deteccion(2) <= kc(2) xor kp(2);
		deteccion(1) <= kc(1) xor kp(1);
		deteccion(0) <= kc(0) xor kp(0);

	--decodificador 
	bit_out(4) <= not bit_ce(4) when deteccion="1001" else bit_ce(4);
	bit_out(3) <= not bit_ce(3) when deteccion="0111" else bit_ce(3);
	bit_out(2) <= not bit_ce(2) when deteccion="0110" else bit_ce(2);
	bit_out(1) <= not bit_ce(1) when deteccion="0101" else bit_ce(1);
	bit_out(0) <= not bit_ce(0) when deteccion="0011" else bit_ce(0);

	--Diplay de 7 segmentos
	
	control(2) <= A;
	control(1) <= B;
	control(0) <= C;
	
	with control select
	LED <= "1001111" when "001", --bit de posicion 3
			 "1101101" when "010", --bit de posicion 5
			 "1111101" when "011", --bit de posicion 6
			 "0000111" when "100", --bit de posicion 7
			 "1101111" when "101", --bit de posicion 9
			 "0111111" when others; --sin errores
			 bit_in_ce <= '0';
			 bit_out_ce <= bit_in_ce;

end Behavioral;