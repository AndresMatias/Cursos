--------------------------------------------------------------------------------
-- Copyright (c) 1995-2008 Xilinx, Inc.  All rights reserved.
--------------------------------------------------------------------------------
--   ____  ____
--  /   /\/   /
-- /___/  \  /    Vendor: Xilinx
-- \   \   \/     Version: K.39
--  \   \         Application: netgen
--  /   /         Filename: Tp_2_timesim.vhd
-- /___/   /\     Timestamp: Thu Jun 08 17:14:24 2017
-- \   \  /  \ 
--  \___\/\___\
--             
-- Command	: -intstyle ise -rpw 100 -ar Structure -tm Tp_2 -w -dir netgen/fit -ofmt vhdl -sim Tp_2.nga Tp_2_timesim.vhd 
-- Device	: XC9572XL-5-PC44 (Speed File: Version 3.0)
-- Input file	: Tp_2.nga
-- Output file	: D:\andres\Tp_2\Tp_2\netgen\fit\Tp_2_timesim.vhd
-- # of Entities	: 1
-- Design Name	: Tp_2.nga
-- Xilinx	: C:\Xilinx\10.1\ISE
--             
-- Purpose:    
--     This VHDL netlist is a verification model and uses simulation 
--     primitives which may not represent the true implementation of the 
--     device, however the netlist is functionally correct and should not 
--     be modified. This file cannot be synthesized and should only be used 
--     with supported simulation tools.
--             
-- Reference:  
--     Development System Reference Guide, Chapter 23
--     Synthesis and Simulation Design Guide, Chapter 6
--             
--------------------------------------------------------------------------------

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library SIMPRIM;
use SIMPRIM.VCOMPONENTS.ALL;
use SIMPRIM.VPACKAGE.ALL;

entity Tp_2 is
  port (
    Transistor : out STD_LOGIC; 
    Vec_E : in STD_LOGIC_VECTOR ( 3 downto 0 ); 
    Display_7 : out STD_LOGIC_VECTOR ( 6 downto 0 ) 
  );
end Tp_2;

architecture Structure of Tp_2 is
  signal Vec_E_2_IBUF_1 : STD_LOGIC; 
  signal Vec_E_3_IBUF_3 : STD_LOGIC; 
  signal Vec_E_1_IBUF_5 : STD_LOGIC; 
  signal Vec_E_0_IBUF_7 : STD_LOGIC; 
  signal Display_7_0_OBUF_9 : STD_LOGIC; 
  signal Display_7_3_OBUF_11 : STD_LOGIC; 
  signal Display_7_1_OBUF_13 : STD_LOGIC; 
  signal Display_7_2_OBUF_15 : STD_LOGIC; 
  signal Display_7_4_OBUF_17 : STD_LOGIC; 
  signal Display_7_5_OBUF_19 : STD_LOGIC; 
  signal Display_7_6_OBUF_21 : STD_LOGIC; 
  signal Transistor_OBUF_23 : STD_LOGIC; 
  signal Display_7_0_OBUF_Q_24 : STD_LOGIC; 
  signal Display_7_0_OBUF_D_25 : STD_LOGIC; 
  signal Display_7_0_OBUF_D1_26 : STD_LOGIC; 
  signal Display_7_0_OBUF_D2_27 : STD_LOGIC; 
  signal Display_7_0_OBUF_D2_PT_0_28 : STD_LOGIC; 
  signal Display_7_0_OBUF_D2_PT_1_29 : STD_LOGIC; 
  signal Display_7_3_OBUF_Q_30 : STD_LOGIC; 
  signal Display_7_3_OBUF_D_31 : STD_LOGIC; 
  signal Display_7_3_OBUF_D1_32 : STD_LOGIC; 
  signal Display_7_3_OBUF_D2_33 : STD_LOGIC; 
  signal Display_7_3_OBUF_D2_PT_0_34 : STD_LOGIC; 
  signal Display_7_3_OBUF_D2_PT_1_35 : STD_LOGIC; 
  signal Display_7_3_OBUF_D2_PT_2_36 : STD_LOGIC; 
  signal Display_7_1_OBUF_Q_37 : STD_LOGIC; 
  signal Display_7_1_OBUF_D_38 : STD_LOGIC; 
  signal Display_7_1_OBUF_D1_39 : STD_LOGIC; 
  signal Display_7_1_OBUF_D2_40 : STD_LOGIC; 
  signal Display_7_1_OBUF_D2_PT_0_41 : STD_LOGIC; 
  signal Display_7_1_OBUF_D2_PT_1_42 : STD_LOGIC; 
  signal Display_7_1_OBUF_D2_PT_2_43 : STD_LOGIC; 
  signal Display_7_2_OBUF_Q_44 : STD_LOGIC; 
  signal Display_7_2_OBUF_D_45 : STD_LOGIC; 
  signal Display_7_2_OBUF_D1_46 : STD_LOGIC; 
  signal Display_7_2_OBUF_D2_47 : STD_LOGIC; 
  signal Display_7_2_OBUF_D2_PT_0_48 : STD_LOGIC; 
  signal Display_7_2_OBUF_D2_PT_1_49 : STD_LOGIC; 
  signal Display_7_2_OBUF_D2_PT_2_50 : STD_LOGIC; 
  signal Display_7_4_OBUF_Q_51 : STD_LOGIC; 
  signal Display_7_4_OBUF_D_52 : STD_LOGIC; 
  signal Display_7_4_OBUF_D1_53 : STD_LOGIC; 
  signal Display_7_4_OBUF_D2_54 : STD_LOGIC; 
  signal Display_7_4_OBUF_D2_PT_0_55 : STD_LOGIC; 
  signal Display_7_4_OBUF_D2_PT_1_56 : STD_LOGIC; 
  signal Display_7_4_OBUF_D2_PT_2_57 : STD_LOGIC; 
  signal Display_7_5_OBUF_Q_58 : STD_LOGIC; 
  signal Display_7_5_OBUF_D_59 : STD_LOGIC; 
  signal Display_7_5_OBUF_D1_60 : STD_LOGIC; 
  signal Display_7_5_OBUF_D2_61 : STD_LOGIC; 
  signal Display_7_5_OBUF_D2_PT_0_62 : STD_LOGIC; 
  signal Display_7_5_OBUF_D2_PT_1_63 : STD_LOGIC; 
  signal Display_7_5_OBUF_D2_PT_2_64 : STD_LOGIC; 
  signal Display_7_5_OBUF_D2_PT_3_65 : STD_LOGIC; 
  signal Display_7_6_OBUF_Q_66 : STD_LOGIC; 
  signal Display_7_6_OBUF_D_67 : STD_LOGIC; 
  signal Display_7_6_OBUF_D1_68 : STD_LOGIC; 
  signal Display_7_6_OBUF_D2_69 : STD_LOGIC; 
  signal Display_7_6_OBUF_D2_PT_0_70 : STD_LOGIC; 
  signal Display_7_6_OBUF_D2_PT_1_71 : STD_LOGIC; 
  signal Transistor_OBUF_Q_72 : STD_LOGIC; 
  signal Transistor_OBUF_D_73 : STD_LOGIC; 
  signal Transistor_OBUF_D1_74 : STD_LOGIC; 
  signal Transistor_OBUF_D2_75 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_0_OBUF_D_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_0_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_3_OBUF_D_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_3_OBUF_D2_PT_0_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_3_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_3_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN3 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_1_OBUF_D_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_1_OBUF_D2_PT_0_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_1_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_1_OBUF_D2_PT_1_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_1_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_1_OBUF_D2_PT_2_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_2_OBUF_D_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_2_OBUF_D2_PT_0_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_2_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_2_OBUF_D2_PT_1_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_2_OBUF_D2_PT_2_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_2_OBUF_D2_PT_2_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_4_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_4_OBUF_D2_PT_1_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_4_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_4_OBUF_D2_PT_2_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_0_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_1_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_2_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_6_OBUF_D_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN3 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN2 : STD_LOGIC; 
begin
  Vec_E_2_IBUF : X_BUF
    port map (
      I => Vec_E(2),
      O => Vec_E_2_IBUF_1
    );
  Vec_E_3_IBUF : X_BUF
    port map (
      I => Vec_E(3),
      O => Vec_E_3_IBUF_3
    );
  Vec_E_1_IBUF : X_BUF
    port map (
      I => Vec_E(1),
      O => Vec_E_1_IBUF_5
    );
  Vec_E_0_IBUF : X_BUF
    port map (
      I => Vec_E(0),
      O => Vec_E_0_IBUF_7
    );
  Display_7_0_Q : X_BUF
    port map (
      I => Display_7_0_OBUF_9,
      O => Display_7(0)
    );
  Display_7_3_Q : X_BUF
    port map (
      I => Display_7_3_OBUF_11,
      O => Display_7(3)
    );
  Display_7_1_Q : X_BUF
    port map (
      I => Display_7_1_OBUF_13,
      O => Display_7(1)
    );
  Display_7_2_Q : X_BUF
    port map (
      I => Display_7_2_OBUF_15,
      O => Display_7(2)
    );
  Display_7_4_Q : X_BUF
    port map (
      I => Display_7_4_OBUF_17,
      O => Display_7(4)
    );
  Display_7_5_Q : X_BUF
    port map (
      I => Display_7_5_OBUF_19,
      O => Display_7(5)
    );
  Display_7_6_Q : X_BUF
    port map (
      I => Display_7_6_OBUF_21,
      O => Display_7(6)
    );
  Transistor_24 : X_BUF
    port map (
      I => Transistor_OBUF_23,
      O => Transistor
    );
  Display_7_0_OBUF : X_BUF
    port map (
      I => Display_7_0_OBUF_Q_24,
      O => Display_7_0_OBUF_9
    );
  Display_7_0_OBUF_Q : X_BUF
    port map (
      I => Display_7_0_OBUF_D_25,
      O => Display_7_0_OBUF_Q_24
    );
  Display_7_0_OBUF_D : X_XOR2
    port map (
      I0 => NlwInverterSignal_Display_7_0_OBUF_D_IN0,
      I1 => Display_7_0_OBUF_D2_27,
      O => Display_7_0_OBUF_D_25
    );
  Display_7_0_OBUF_D1 : X_ZERO
    port map (
      O => Display_7_0_OBUF_D1_26
    );
  Display_7_0_OBUF_D2_PT_0 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN0,
      I1 => NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN1,
      I2 => NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN2,
      O => Display_7_0_OBUF_D2_PT_0_28
    );
  Display_7_0_OBUF_D2_PT_1 : X_AND4
    port map (
      I0 => Vec_E_2_IBUF_1,
      I1 => NlwInverterSignal_Display_7_0_OBUF_D2_PT_1_IN1,
      I2 => Vec_E_1_IBUF_5,
      I3 => Vec_E_0_IBUF_7,
      O => Display_7_0_OBUF_D2_PT_1_29
    );
  Display_7_0_OBUF_D2 : X_OR2
    port map (
      I0 => Display_7_0_OBUF_D2_PT_0_28,
      I1 => Display_7_0_OBUF_D2_PT_1_29,
      O => Display_7_0_OBUF_D2_27
    );
  Display_7_3_OBUF : X_BUF
    port map (
      I => Display_7_3_OBUF_Q_30,
      O => Display_7_3_OBUF_11
    );
  Display_7_3_OBUF_Q : X_BUF
    port map (
      I => Display_7_3_OBUF_D_31,
      O => Display_7_3_OBUF_Q_30
    );
  Display_7_3_OBUF_D : X_XOR2
    port map (
      I0 => NlwInverterSignal_Display_7_3_OBUF_D_IN0,
      I1 => Display_7_3_OBUF_D2_33,
      O => Display_7_3_OBUF_D_31
    );
  Display_7_3_OBUF_D1 : X_ZERO
    port map (
      O => Display_7_3_OBUF_D1_32
    );
  Display_7_3_OBUF_D2_PT_0 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_3_OBUF_D2_PT_0_IN0,
      I1 => NlwInverterSignal_Display_7_3_OBUF_D2_PT_0_IN1,
      I2 => Vec_E_0_IBUF_7,
      O => Display_7_3_OBUF_D2_PT_0_34
    );
  Display_7_3_OBUF_D2_PT_1 : X_AND4
    port map (
      I0 => Vec_E_2_IBUF_1,
      I1 => NlwInverterSignal_Display_7_3_OBUF_D2_PT_1_IN1,
      I2 => Vec_E_1_IBUF_5,
      I3 => Vec_E_0_IBUF_7,
      O => Display_7_3_OBUF_D2_PT_1_35
    );
  Display_7_3_OBUF_D2_PT_2 : X_AND4
    port map (
      I0 => Vec_E_2_IBUF_1,
      I1 => NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN1,
      I2 => NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN2,
      I3 => NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN3,
      O => Display_7_3_OBUF_D2_PT_2_36
    );
  Display_7_3_OBUF_D2 : X_OR3
    port map (
      I0 => Display_7_3_OBUF_D2_PT_0_34,
      I1 => Display_7_3_OBUF_D2_PT_1_35,
      I2 => Display_7_3_OBUF_D2_PT_2_36,
      O => Display_7_3_OBUF_D2_33
    );
  Display_7_1_OBUF : X_BUF
    port map (
      I => Display_7_1_OBUF_Q_37,
      O => Display_7_1_OBUF_13
    );
  Display_7_1_OBUF_Q : X_BUF
    port map (
      I => Display_7_1_OBUF_D_38,
      O => Display_7_1_OBUF_Q_37
    );
  Display_7_1_OBUF_D : X_XOR2
    port map (
      I0 => NlwInverterSignal_Display_7_1_OBUF_D_IN0,
      I1 => Display_7_1_OBUF_D2_40,
      O => Display_7_1_OBUF_D_38
    );
  Display_7_1_OBUF_D1 : X_ZERO
    port map (
      O => Display_7_1_OBUF_D1_39
    );
  Display_7_1_OBUF_D2_PT_0 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_1_OBUF_D2_PT_0_IN0,
      I1 => NlwInverterSignal_Display_7_1_OBUF_D2_PT_0_IN1,
      I2 => Vec_E_1_IBUF_5,
      O => Display_7_1_OBUF_D2_PT_0_41
    );
  Display_7_1_OBUF_D2_PT_1 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_1_OBUF_D2_PT_1_IN0,
      I1 => NlwInverterSignal_Display_7_1_OBUF_D2_PT_1_IN1,
      I2 => Vec_E_0_IBUF_7,
      O => Display_7_1_OBUF_D2_PT_1_42
    );
  Display_7_1_OBUF_D2_PT_2 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_1_OBUF_D2_PT_2_IN0,
      I1 => Vec_E_1_IBUF_5,
      I2 => Vec_E_0_IBUF_7,
      O => Display_7_1_OBUF_D2_PT_2_43
    );
  Display_7_1_OBUF_D2 : X_OR3
    port map (
      I0 => Display_7_1_OBUF_D2_PT_0_41,
      I1 => Display_7_1_OBUF_D2_PT_1_42,
      I2 => Display_7_1_OBUF_D2_PT_2_43,
      O => Display_7_1_OBUF_D2_40
    );
  Display_7_2_OBUF : X_BUF
    port map (
      I => Display_7_2_OBUF_Q_44,
      O => Display_7_2_OBUF_15
    );
  Display_7_2_OBUF_Q : X_BUF
    port map (
      I => Display_7_2_OBUF_D_45,
      O => Display_7_2_OBUF_Q_44
    );
  Display_7_2_OBUF_D : X_XOR2
    port map (
      I0 => NlwInverterSignal_Display_7_2_OBUF_D_IN0,
      I1 => Display_7_2_OBUF_D2_47,
      O => Display_7_2_OBUF_D_45
    );
  Display_7_2_OBUF_D1 : X_ZERO
    port map (
      O => Display_7_2_OBUF_D1_46
    );
  Display_7_2_OBUF_D2_PT_0 : X_AND2
    port map (
      I0 => NlwInverterSignal_Display_7_2_OBUF_D2_PT_0_IN0,
      I1 => Vec_E_0_IBUF_7,
      O => Display_7_2_OBUF_D2_PT_0_48
    );
  Display_7_2_OBUF_D2_PT_1 : X_AND3
    port map (
      I0 => Vec_E_2_IBUF_1,
      I1 => NlwInverterSignal_Display_7_2_OBUF_D2_PT_1_IN1,
      I2 => NlwInverterSignal_Display_7_2_OBUF_D2_PT_1_IN2,
      O => Display_7_2_OBUF_D2_PT_1_49
    );
  Display_7_2_OBUF_D2_PT_2 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_2_OBUF_D2_PT_2_IN0,
      I1 => NlwInverterSignal_Display_7_2_OBUF_D2_PT_2_IN1,
      I2 => Vec_E_0_IBUF_7,
      O => Display_7_2_OBUF_D2_PT_2_50
    );
  Display_7_2_OBUF_D2 : X_OR3
    port map (
      I0 => Display_7_2_OBUF_D2_PT_0_48,
      I1 => Display_7_2_OBUF_D2_PT_1_49,
      I2 => Display_7_2_OBUF_D2_PT_2_50,
      O => Display_7_2_OBUF_D2_47
    );
  Display_7_4_OBUF : X_BUF
    port map (
      I => Display_7_4_OBUF_Q_51,
      O => Display_7_4_OBUF_17
    );
  Display_7_4_OBUF_Q : X_BUF
    port map (
      I => Display_7_4_OBUF_D_52,
      O => Display_7_4_OBUF_Q_51
    );
  Display_7_4_OBUF_D : X_XOR2
    port map (
      I0 => Display_7_4_OBUF_D1_53,
      I1 => Display_7_4_OBUF_D2_54,
      O => Display_7_4_OBUF_D_52
    );
  Display_7_4_OBUF_D1 : X_ZERO
    port map (
      O => Display_7_4_OBUF_D1_53
    );
  Display_7_4_OBUF_D2_PT_0 : X_AND2
    port map (
      I0 => Vec_E_2_IBUF_1,
      I1 => NlwInverterSignal_Display_7_4_OBUF_D2_PT_0_IN1,
      O => Display_7_4_OBUF_D2_PT_0_55
    );
  Display_7_4_OBUF_D2_PT_1 : X_AND2
    port map (
      I0 => NlwInverterSignal_Display_7_4_OBUF_D2_PT_1_IN0,
      I1 => NlwInverterSignal_Display_7_4_OBUF_D2_PT_1_IN1,
      O => Display_7_4_OBUF_D2_PT_1_56
    );
  Display_7_4_OBUF_D2_PT_2 : X_AND2
    port map (
      I0 => NlwInverterSignal_Display_7_4_OBUF_D2_PT_2_IN0,
      I1 => Vec_E_0_IBUF_7,
      O => Display_7_4_OBUF_D2_PT_2_57
    );
  Display_7_4_OBUF_D2 : X_OR3
    port map (
      I0 => Display_7_4_OBUF_D2_PT_0_55,
      I1 => Display_7_4_OBUF_D2_PT_1_56,
      I2 => Display_7_4_OBUF_D2_PT_2_57,
      O => Display_7_4_OBUF_D2_54
    );
  Display_7_5_OBUF : X_BUF
    port map (
      I => Display_7_5_OBUF_Q_58,
      O => Display_7_5_OBUF_19
    );
  Display_7_5_OBUF_Q : X_BUF
    port map (
      I => Display_7_5_OBUF_D_59,
      O => Display_7_5_OBUF_Q_58
    );
  Display_7_5_OBUF_D : X_XOR2
    port map (
      I0 => Display_7_5_OBUF_D1_60,
      I1 => Display_7_5_OBUF_D2_61,
      O => Display_7_5_OBUF_D_59
    );
  Display_7_5_OBUF_D1 : X_ZERO
    port map (
      O => Display_7_5_OBUF_D1_60
    );
  Display_7_5_OBUF_D2_PT_0 : X_AND2
    port map (
      I0 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_0_IN0,
      I1 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_0_IN1,
      O => Display_7_5_OBUF_D2_PT_0_62
    );
  Display_7_5_OBUF_D2_PT_1 : X_AND2
    port map (
      I0 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_1_IN0,
      I1 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_1_IN1,
      O => Display_7_5_OBUF_D2_PT_1_63
    );
  Display_7_5_OBUF_D2_PT_2 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_2_IN0,
      I1 => Vec_E_1_IBUF_5,
      I2 => Vec_E_0_IBUF_7,
      O => Display_7_5_OBUF_D2_PT_2_64
    );
  Display_7_5_OBUF_D2_PT_3 : X_AND3
    port map (
      I0 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN0,
      I1 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN1,
      I2 => NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN2,
      O => Display_7_5_OBUF_D2_PT_3_65
    );
  Display_7_5_OBUF_D2 : X_OR4
    port map (
      I0 => Display_7_5_OBUF_D2_PT_0_62,
      I1 => Display_7_5_OBUF_D2_PT_1_63,
      I2 => Display_7_5_OBUF_D2_PT_2_64,
      I3 => Display_7_5_OBUF_D2_PT_3_65,
      O => Display_7_5_OBUF_D2_61
    );
  Display_7_6_OBUF : X_BUF
    port map (
      I => Display_7_6_OBUF_Q_66,
      O => Display_7_6_OBUF_21
    );
  Display_7_6_OBUF_Q : X_BUF
    port map (
      I => Display_7_6_OBUF_D_67,
      O => Display_7_6_OBUF_Q_66
    );
  Display_7_6_OBUF_D : X_XOR2
    port map (
      I0 => NlwInverterSignal_Display_7_6_OBUF_D_IN0,
      I1 => Display_7_6_OBUF_D2_69,
      O => Display_7_6_OBUF_D_67
    );
  Display_7_6_OBUF_D1 : X_ZERO
    port map (
      O => Display_7_6_OBUF_D1_68
    );
  Display_7_6_OBUF_D2_PT_0 : X_AND4
    port map (
      I0 => Vec_E_2_IBUF_1,
      I1 => NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN1,
      I2 => NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN2,
      I3 => NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN3,
      O => Display_7_6_OBUF_D2_PT_0_70
    );
  Display_7_6_OBUF_D2_PT_1 : X_AND4
    port map (
      I0 => NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN0,
      I1 => NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN1,
      I2 => NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN2,
      I3 => Vec_E_0_IBUF_7,
      O => Display_7_6_OBUF_D2_PT_1_71
    );
  Display_7_6_OBUF_D2 : X_OR2
    port map (
      I0 => Display_7_6_OBUF_D2_PT_0_70,
      I1 => Display_7_6_OBUF_D2_PT_1_71,
      O => Display_7_6_OBUF_D2_69
    );
  Transistor_OBUF : X_BUF
    port map (
      I => Transistor_OBUF_Q_72,
      O => Transistor_OBUF_23
    );
  Transistor_OBUF_Q : X_BUF
    port map (
      I => Transistor_OBUF_D_73,
      O => Transistor_OBUF_Q_72
    );
  Transistor_OBUF_D : X_XOR2
    port map (
      I0 => Transistor_OBUF_D1_74,
      I1 => Transistor_OBUF_D2_75,
      O => Transistor_OBUF_D_73
    );
  Transistor_OBUF_D1 : X_ZERO
    port map (
      O => Transistor_OBUF_D1_74
    );
  Transistor_OBUF_D2 : X_ZERO
    port map (
      O => Transistor_OBUF_D2_75
    );
  NlwInverterBlock_Display_7_0_OBUF_D_IN0 : X_INV
    port map (
      I => Display_7_0_OBUF_D1_26,
      O => NlwInverterSignal_Display_7_0_OBUF_D_IN0
    );
  NlwInverterBlock_Display_7_0_OBUF_D2_PT_0_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN0
    );
  NlwInverterBlock_Display_7_0_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Display_7_0_OBUF_D2_PT_0_IN2 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_0_OBUF_D2_PT_0_IN2
    );
  NlwInverterBlock_Display_7_0_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_0_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Display_7_3_OBUF_D_IN0 : X_INV
    port map (
      I => Display_7_3_OBUF_D1_32,
      O => NlwInverterSignal_Display_7_3_OBUF_D_IN0
    );
  NlwInverterBlock_Display_7_3_OBUF_D2_PT_0_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_3_OBUF_D2_PT_0_IN0
    );
  NlwInverterBlock_Display_7_3_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_3_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Display_7_3_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_3_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Display_7_3_OBUF_D2_PT_2_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN1
    );
  NlwInverterBlock_Display_7_3_OBUF_D2_PT_2_IN2 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN2
    );
  NlwInverterBlock_Display_7_3_OBUF_D2_PT_2_IN3 : X_INV
    port map (
      I => Vec_E_0_IBUF_7,
      O => NlwInverterSignal_Display_7_3_OBUF_D2_PT_2_IN3
    );
  NlwInverterBlock_Display_7_1_OBUF_D_IN0 : X_INV
    port map (
      I => Display_7_1_OBUF_D1_39,
      O => NlwInverterSignal_Display_7_1_OBUF_D_IN0
    );
  NlwInverterBlock_Display_7_1_OBUF_D2_PT_0_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_1_OBUF_D2_PT_0_IN0
    );
  NlwInverterBlock_Display_7_1_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_1_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Display_7_1_OBUF_D2_PT_1_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_1_OBUF_D2_PT_1_IN0
    );
  NlwInverterBlock_Display_7_1_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_1_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Display_7_1_OBUF_D2_PT_2_IN0 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_1_OBUF_D2_PT_2_IN0
    );
  NlwInverterBlock_Display_7_2_OBUF_D_IN0 : X_INV
    port map (
      I => Display_7_2_OBUF_D1_46,
      O => NlwInverterSignal_Display_7_2_OBUF_D_IN0
    );
  NlwInverterBlock_Display_7_2_OBUF_D2_PT_0_IN0 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_2_OBUF_D2_PT_0_IN0
    );
  NlwInverterBlock_Display_7_2_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_2_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Display_7_2_OBUF_D2_PT_1_IN2 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_2_OBUF_D2_PT_1_IN2
    );
  NlwInverterBlock_Display_7_2_OBUF_D2_PT_2_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_2_OBUF_D2_PT_2_IN0
    );
  NlwInverterBlock_Display_7_2_OBUF_D2_PT_2_IN1 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_2_OBUF_D2_PT_2_IN1
    );
  NlwInverterBlock_Display_7_4_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_4_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Display_7_4_OBUF_D2_PT_1_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_4_OBUF_D2_PT_1_IN0
    );
  NlwInverterBlock_Display_7_4_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_4_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Display_7_4_OBUF_D2_PT_2_IN0 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_4_OBUF_D2_PT_2_IN0
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_0_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_0_IN0
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_1_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_1_IN0
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_2_IN0 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_2_IN0
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_3_IN0 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN0
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_3_IN1 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN1
    );
  NlwInverterBlock_Display_7_5_OBUF_D2_PT_3_IN2 : X_INV
    port map (
      I => Vec_E_0_IBUF_7,
      O => NlwInverterSignal_Display_7_5_OBUF_D2_PT_3_IN2
    );
  NlwInverterBlock_Display_7_6_OBUF_D_IN0 : X_INV
    port map (
      I => Display_7_6_OBUF_D1_68,
      O => NlwInverterSignal_Display_7_6_OBUF_D_IN0
    );
  NlwInverterBlock_Display_7_6_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Display_7_6_OBUF_D2_PT_0_IN2 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN2
    );
  NlwInverterBlock_Display_7_6_OBUF_D2_PT_0_IN3 : X_INV
    port map (
      I => Vec_E_0_IBUF_7,
      O => NlwInverterSignal_Display_7_6_OBUF_D2_PT_0_IN3
    );
  NlwInverterBlock_Display_7_6_OBUF_D2_PT_1_IN0 : X_INV
    port map (
      I => Vec_E_2_IBUF_1,
      O => NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN0
    );
  NlwInverterBlock_Display_7_6_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => Vec_E_3_IBUF_3,
      O => NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Display_7_6_OBUF_D2_PT_1_IN2 : X_INV
    port map (
      I => Vec_E_1_IBUF_5,
      O => NlwInverterSignal_Display_7_6_OBUF_D2_PT_1_IN2
    );
  NlwBlockROC : X_ROC
    generic map (ROC_WIDTH => 100 ns)
    port map (O => PRLD);

end Structure;

