library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity Ejercicio is
    Port ( Clk, R, Realimentacion, ShiftLoad : in  STD_LOGIC;
			  D : in std_logic_vector(5 downto 0);
           S : out  STD_LOGIC);
end Ejercicio;

architecture Behavioral of Ejercicio is

signal sig : std_logic_vector(4 downto 0);
signal G : std_logic_vector(10 downto 0);
signal F : std_logic_vector(5 downto 0);
Signal mux : std_logic;
Signal w : std_logic;

component ff
port(
		E, reloj, reset : in std_logic;
		Q : out std_logic
);
end component;

begin

G(0)  <= D(0)   AND (NOT ShiftLoad);
G(1)  <= sig(0) AND 	  ShiftLoad;
G(2)  <= D(1)   AND (NOT ShiftLoad);
G(3)  <= sig(1) AND 	  ShiftLoad;
G(4)  <= D(2)   AND (NOT ShiftLoad);
G(5)  <= sig(2) AND 	  ShiftLoad;
G(6)  <= D(3)   AND (NOT ShiftLoad);
G(7)  <= sig(3) AND 	  ShiftLoad;
G(8)  <= D(4)   AND (NOT ShiftLoad);
G(9)  <= sig(4) AND 	  ShiftLoad;
G(10) <= D(5)   AND (NOT ShiftLoad);

F(0) <= G(1) AND G(2);
F(1) <= G(3) AND G(4);
F(2) <= G(5) AND G(6);
F(3) <= G(7) AND G(8);
F(4) <= G(9) AND G(10);

S <= w;

with Realimentacion select
	mux <= G(0) when '0',
			 w when others;

FF0 : ff port map
(
		 E <= mux,
	reloj <= clk,
	reset <= R,
		 Q <= sig(0)
);

FF1 : ff port map
(
		 E <= F(0),
	reloj <= clk,
	reset <= R,
		 Q <= sig(1)
);

FF2 : ff port map
(
		 E<=F(1),
	reloj <= clk,
	reset <= R,
		 Q <= sig(2)
);

FF3 : ff port map
(
		 E<=F(2),
	reloj <= clk,
	reset <= R,
		 Q <= sig(3)
);

FF4 : ff port map
(
		 E<=F(3),
	reloj <= clk,
	reset <= R,
		 Q <= sig(4)
);

FF5 : ff port map
(
		 E <= F(4),
	reloj <= clk,
	reset <= R,
		 Q <= w
);

end Behavioral;

