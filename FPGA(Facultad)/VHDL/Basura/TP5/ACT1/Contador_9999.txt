----------------------------------------------------------------------------------

----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;



entity contador is
    Port ( reloj 		: in  STD_LOGIC;
			  pulsador  : in 	STD_LOGIC;
			  llave		: in 	STD_LOGIC;
           inicio 	: in  STD_LOGIC;
           reset 		: in  STD_LOGIC;
           display 	: out STD_LOGIC_VECTOR (6 downto 0);
           transistor1, transistor2, transistor3, transistor4 : out  STD_LOGIC
			 );
end contador;

architecture Behavioral of contador is

type maquina is (unidades,decenas,centenas,milesimos);

signal estado_p, estado_f : maquina := unidades;


signal desicion : std_logic;
signal CE_CONTADOR1: std_logic;
signal CE_CONTADOR2: std_logic;
signal CE_CONTADOR3: std_logic;

signal CONTADOR0 : std_logic_vector(3 downto 0);
signal CONTADOR1 : std_logic_vector(3 downto 0);
signal CONTADOR2 : std_logic_vector(3 downto 0);
signal CONTADOR3 : std_logic_vector(3 downto 0);
signal contador_out : std_logic_vector(3 downto 0);
begin

desicion <= reloj 	when llave = '1' else
				pulsador when llave = '0';

CONTADOR_UNIDAD:
process (desicion)
begin
	if reset = '1' then
		CONTADOR0 <= (OTHERS =>'0'); --"0000"
		CE_CONTADOR1<='0';
	elsif (desicion'event and desicion ='1') then
		if(CONTADOR0 ="1001") then
			CE_CONTADOR1<='1';
			CONTADOR0 <="0000";
		else
			CE_CONTADOR1<='0';
			CONTADOR0 <= CONTADOR0 + 1;
		end if;
	end if;	
END process;	
	
CONTADOR_DECENA:
process (desicion)
begin
	if reset = '1' then
		CONTADOR1 <= (OTHERS =>'0'); --"0000"
		CE_CONTADOR2<='0';
	elsif (desicion'event and desicion ='1' and CE_CONTADOR1 = '1') then
		if(CONTADOR1 ="1001") then
			CE_CONTADOR2<='1';
			CONTADOR1 <="0000";
		else
			CE_CONTADOR2<='0';
			if( CE_CONTADOR1='1') then
				CONTADOR1 <= CONTADOR1 + 1;
			else
				CONTADOR1 <= CONTADOR0;
			end if;
		end if;
	end if;	
END process;	

CONTADOR_CENTENA:
process (desicion)
begin
	if reset = '1' then
		CONTADOR2 <= (OTHERS =>'0'); --"0000"
		CE_CONTADOR3<='0';
	elsif (desicion'event and desicion ='1') then
		if(CONTADOR2 ="1001") then
			CE_CONTADOR3<='1';
			CONTADOR2 <="0000";
		else
			if( CE_CONTADOR2='1') then
				CONTADOR2 <= CONTADOR2 + 1;
			else
				CONTADOR2 <= CONTADOR1;
			end if;
		end if;
	end if;	
END process;	

CONTADOR_MILESIMOS:
process (desicion)
begin
	if reset = '1' then
		CONTADOR3 <= (OTHERS =>'0'); --"0000"
	elsif (desicion'event and desicion ='1' and CE_CONTADOR3 = '1') then
		if(CONTADOR3 ="1001") then
			CONTADOR3 <="0000";
		else
			if( CE_CONTADOR3='1') then
				CONTADOR3 <= CONTADOR3 + 1;
			else
				CONTADOR3 <= CONTADOR2;
			end if;
		end if;
	end if;	
END process;	

process(desicion, estado_p)
begin
	estado_f<=estado_p;
	case(estado_p)is
		when(unidades)=>
			transistor1<='0';
			if(CE_CONTADOR1 = '1')then
				estado_f<=decenas;
			end if;
		when(decenas)=>
		transistor2<='0';
			if(CE_CONTADOR2 = '1')then
				estado_f<=centenas;
			end if;
		when(centenas)=>
		transistor3<='0';
			if(CE_CONTADOR3 = '1')then
				estado_f<=milesimos;
			end if;
		when(milesimos)=>
		transistor4<='0';
			if(CE_CONTADOR3 = '1')then
				estado_f<=decenas;
			end if;
	end case;
end process;

contador_out <= CONTADOR0 when estado_p = unidades else
					 CONTADOR1 when estado_p = decenas else
					 CONTADOR2 when estado_p = centenas else
					 CONTADOR3 when estado_p = milesimos;

			 --ABCDEFG	
display <= "0000000" when contador_out = "0000" else
			  "0110000" when contador_out = "0001" else
			  "1101101" when contador_out = "0010" else
			  "1111001" when contador_out = "0011" else
			  "0110011" when contador_out = "0100" else
			  "1011011" when contador_out = "0101" else
			  "1011111" when contador_out = "0110" else
			  "1110000" when contador_out = "0111" else
			  "1111111" when contador_out = "1000" else
			  "1111011" when contador_out = "1001";
			  
			  

transistor1<='0';
transistor2<='0';
transistor3<='0';
transistor4<='0';


end Behavioral;