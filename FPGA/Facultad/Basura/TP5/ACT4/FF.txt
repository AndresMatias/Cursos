library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ff is
	Port (E : in std_logic;
			reloj,reset : in std_logic;
			Q : out std_logic
	);
end ff;

architecture Behavioral of ff is

begin

process(reset,reloj)
begin
	If (reset = '0') then
		Q <= '0';
	Elsif (reloj'event AND reloj = '1') then
		Q <= E;
	end If;
End process;

end Behavioral;

