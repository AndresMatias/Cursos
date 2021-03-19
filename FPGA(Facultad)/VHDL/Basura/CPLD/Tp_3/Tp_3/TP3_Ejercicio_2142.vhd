----------------------------------------------------------------------------------

----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity TP3_Ejercicio_2142 is
    Port ( bin : in  STD_LOGIC_VECTOR (4 downto 0);--bit de entrada
			  A : in std_logic; --bit de error 1
			  B : in std_logic; --bit de error 2
			  C : in std_logic; --bit de error 3
           bout : out  STD_LOGIC_VECTOR (4 downto 0);--bit de salida
			  bce_out : out std_logic; --bit con error salida
			  LED : out std_logic_vector (6 downto 0));

end TP3_Ejercicio_2142;

architecture Behavioral of TP3_Ejercicio_2142 is
	signal kp : std_logic_vector (3 downto 0);--k de paridad
	signal kc : std_logic_vector (3 downto 0);--k de control
	signal bit_error : std_logic_vector (4 downto 0);--bit del error (F)
	signal codigo_error : std_logic_vector (4 downto 0);--codigo con error (T)
	signal deteccion : std_logic_vector (3 downto 0);
	signal control : std_logic_vector (2 downto 0);
	signal bce_in : std_logic; --bit con error señal

begin

	--K de paridad
	kp(3)<= bin(4);
	kp(2)<= bin(3) xor bin(2) xor bin(1);
	kp(1)<= bin(3) xor bin(2) xor bin(0);
	kp(0)<= bin(4) xor bin(3) xor bin(1) xor bin(0);
	
	--datos a traves de las 3 llaves
	bit_error(4)<= A and not B and C;
	bit_error(3)<= A and not B and not C;
	bit_error(2)<= not A and B and C;
	bit_error(1)<= not A and B and not C;
	bit_error(0)<= not A and not B and C;
	
	codigo_error(4)<= bit_error(4) xor bin (4);
	codigo_error(3)<= bit_error(3) xor bin (3);
	codigo_error(2)<= bit_error(2) xor bin (2);
	codigo_error(1)<= bit_error(1) xor bin (1);
	codigo_error(0)<= bit_error(0) xor bin (0);
	
	kc(3)<= codigo_error(4);
	kc(2)<= codigo_error(3) xor codigo_error(2) xor codigo_error(1);
	kc(1)<= codigo_error(3) xor codigo_error(2) xor codigo_error(0);
	kc(0)<= codigo_error(4) xor codigo_error(3) xor codigo_error(1) xor codigo_error(0);
	
	--deteccion de error
	deteccion(3)<=kc(3)xor kp(3);
	deteccion(2)<=kc(2)xor kp(2);
	deteccion(1)<=kc(1)xor kp(1);
	deteccion(0)<=kc(0)xor kp(0);
	
	--decodificacion
	bout(4)<= not codigo_error(4) when deteccion="1001" else codigo_error(4);
	bout(3)<= not codigo_error(3) when deteccion="0111" else codigo_error(3);
	bout(2)<= not codigo_error(2) when deteccion="0110" else codigo_error(2);
	bout(1)<= not codigo_error(1) when deteccion="0101" else codigo_error(1);
	bout(0)<= not codigo_error(0) when deteccion="0011" else codigo_error(0);
	
	--Display 7 segmentos
	 control(2)<= A;
	 control(1)<= B;
	 control(0)<= C;
	 
	 with control select
	 LED <= "0110000" when "001", --el bit 1
			  "1101101" when "010", --el bit 2
			  "1111001" when "011", --el bit 3
			  "0110011" when "100", --el bit 4
			  "1011001" when "101", --el bit 5
			  "1111110" when others; --no hay error
			  bce_in <='0';
			  bce_out <= bce_in;
	
end Behavioral;

