----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:32:01 11/09/2017 
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

port(			clk50Mhz, clk_enable :in std_logic;
            x:in std_logic;
            bcd:out std_logic_vector(2 downto 0);
            sseg:out std_logic_vector(6 downto 0);
            an:out std_logic_vector(3 downto 0)
            );
end Top;

architecture Behavioral of Top is

signal reset: std_logic;
signal FE: std_logic;
signal s0, s1, s2: std_logic;
signal d0, d1, d2: std_logic;
signal q0, q1, q2: std_logic;
signal not_q0, not_q1, not_q2: std_logic;
signal bcd_aux: std_logic_vector(2 downto 0);
signal clk_1Hz: std_logic;

begin
    
    clk_1Hz_unit    : entity work.clk_1Hz(arch)
    port map(
                clk         => clk50Mhz,
                reset   => reset,
                enable  => clk_enable,
                clk_1Hz => clk_1Hz
                );
    
    FF_D0_unit  : entity work.FFD(arch)
    port map(
                clk     => clk_1Hz,
                reset => reset,
                d       => FE,
                q       => q0,
                not_q   => not_q0
                );
    
    FF_D1_unit  : entity work.FFD(arch)
    port map(
                clk     => clk_1Hz,
                reset => reset,
                d       => q0,
                q       => q1,
                not_q   => not_q1
                );
    
    FF_D2_unit  : entity work.FFD(arch)
    port map(
                clk     => clk_1Hz,
                reset => reset,
                d       => q1,
                q       => q2,
                not_q   => not_q2
                );
     
    FE      <= not_q2 and not_q1;
    reset   <= (q2 and q0) or (not_q2 and q1 and not_q0);
    s0      <= q1 xor q0;
    s1      <= (not(x) and q0) or (x and q1);
    s2      <= (x and q2 and not_q1) or (not(x) and not_q2 and not_q0);
    
    bcd_aux <= s2&s1&s0;
    bcd   <= bcd_aux;
    
    with bcd_aux select        
    sseg <= 
    "0000001" when "000",   -- '0'
    "1001111" when "001",   -- '1'
    "0010010" when "010",   -- '2'
    "0000110" when "011",   -- '3'
    "1001100" when others;  -- '4'
    
    an <= "1110";


end Behavioral;

