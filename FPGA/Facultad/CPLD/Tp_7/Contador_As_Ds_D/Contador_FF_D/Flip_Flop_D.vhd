----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:19:52 10/26/2017 
-- Design Name: 
-- Module Name:    Flip_Flop_D - Behavioral 
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

entity Flip_Flop_D is
port(D,CLK:in std_logic;
	  Q,Q_N:out std_logic
	  );
end Flip_Flop_D;

architecture Behavioral of Flip_Flop_D is

begin

process(CLK)
begin
	if CLK 'event and CLK='1' then
		Q<=D;
		Q_N<=(not D);
	end if;
end process;

end Behavioral;

