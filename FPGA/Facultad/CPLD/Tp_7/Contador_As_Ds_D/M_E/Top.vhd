----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:22:22 10/31/2017 
-- Design Name: 
-- Module Name:    Top - Behavioral 
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

entity Top is
port(en:in std_logic;
	  clk:in std_logic;
	  s:out std_logic_vector(2 downto 0)
     );
end Top;

architecture Behavioral of Top is
type Tipo_Estado is (A,B,C,D,E);
signal Estado,Estado_Sig:Tipo_Estado;
signal s_a: std_logic_vector(2 downto 0);
begin

process(clk)
begin
	if clk 'event and clk='1' then
		Estado<=Estado_Sig;
		s<=s_a;
	end if;
end process;

process(Estado,en) --Transicion
begin
	Estado_Sig<=Estado;
	case(Estado) is
	 when A =>
		if en='1' then
			Estado_Sig<=B;
		elsif en='0' then
			Estado_Sig<=E;
		end if;
	 when B =>
		if en='1' then
			Estado_Sig<=C;
		elsif en='0' then
			Estado_Sig<=A;
		end if;
	 when C =>
		if en='1' then
			Estado_Sig<=D;
		elsif en='0' then
			Estado_Sig<=B;
		end if;
	 when D =>
		if en='1' then
			Estado_Sig<=E;
		elsif en='0' then
			Estado_Sig<=C;
		end if;
	 when E =>
		if en='1' then
			Estado_Sig<=A;
		elsif en='0' then
			Estado_Sig<=D;
		end if;
	end case;	
end process;

process(Estado) --Asignacion de Estados
begin
	case(Estado) is
	 when A =>
		s_a<="000";
	 when B =>
		s_a<="001";
	 when C =>
		s_a<="010";
	 when D =>
		s_a<="011";
	 when E =>
		s_a<="100";
	end case;	
end process;
end Behavioral;

