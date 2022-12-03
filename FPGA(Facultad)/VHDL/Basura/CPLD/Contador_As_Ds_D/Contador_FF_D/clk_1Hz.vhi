
-- VHDL Instantiation Created from source file clk_1Hz.vhd -- 12:55:32 11/09/2017
--
-- Notes: 
-- 1) This instantiation template has been automatically generated using types
-- std_logic and std_logic_vector for the ports of the instantiated module
-- 2) To use this template to instantiate this entity, cut-and-paste and then edit

	COMPONENT clk_1Hz
	PORT(
		clk : IN std_logic;
		reset : IN std_logic;
		enable : IN std_logic;          
		clk_1Hz : OUT std_logic
		);
	END COMPONENT;

	Inst_clk_1Hz: clk_1Hz PORT MAP(
		clk => ,
		reset => ,
		enable => ,
		clk_1Hz => 
	);


