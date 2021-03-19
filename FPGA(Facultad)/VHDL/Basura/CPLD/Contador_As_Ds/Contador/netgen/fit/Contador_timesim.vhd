--------------------------------------------------------------------------------
-- Copyright (c) 1995-2008 Xilinx, Inc.  All rights reserved.
--------------------------------------------------------------------------------
--   ____  ____
--  /   /\/   /
-- /___/  \  /    Vendor: Xilinx
-- \   \   \/     Version: K.31
--  \   \         Application: netgen
--  /   /         Filename: Contador_timesim.vhd
-- /___/   /\     Timestamp: Thu Nov 02 10:45:26 2017
-- \   \  /  \ 
--  \___\/\___\
--             
-- Command	: -intstyle ise -rpw 100 -ar Structure -tm Contador -w -dir netgen/fit -ofmt vhdl -sim Contador.nga Contador_timesim.vhd 
-- Device	: XC9572XL-5-PC44 (Speed File: Version 3.0)
-- Input file	: Contador.nga
-- Output file	: C:\Xilinx\Tp\Contador_As_Ds\Contador\netgen\fit\Contador_timesim.vhd
-- # of Entities	: 1
-- Design Name	: Contador.nga
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

entity Contador is
  port (
    Clock : in STD_LOGIC := 'X'; 
    A_D : in STD_LOGIC := 'X'; 
    Salida : out STD_LOGIC_VECTOR ( 2 downto 0 ) 
  );
end Contador;

architecture Structure of Contador is
  signal FCLKIO_0_1 : STD_LOGIC; 
  signal A_D_IBUF_3 : STD_LOGIC; 
  signal Salida_2_OBUF_Q_5 : STD_LOGIC; 
  signal Salida_1_OBUF_Q_7 : STD_LOGIC; 
  signal Salida_0_OBUF_Q_9 : STD_LOGIC; 
  signal Salida_2_OBUF_Q_10 : STD_LOGIC; 
  signal Salida_2_OBUF_11 : STD_LOGIC; 
  signal Salida_2_OBUF_D_12 : STD_LOGIC; 
  signal Gnd_13 : STD_LOGIC; 
  signal Vcc_14 : STD_LOGIC; 
  signal Salida_2_OBUF_D1_15 : STD_LOGIC; 
  signal Salida_2_OBUF_D2_16 : STD_LOGIC; 
  signal Salida_1_OBUF_17 : STD_LOGIC; 
  signal JK_2_Q_aux_18 : STD_LOGIC; 
  signal Salida_2_OBUF_D2_PT_0_19 : STD_LOGIC; 
  signal Salida_0_OBUF_20 : STD_LOGIC; 
  signal Salida_2_OBUF_D2_PT_1_21 : STD_LOGIC; 
  signal Salida_2_OBUF_D2_PT_2_22 : STD_LOGIC; 
  signal Salida_1_OBUF_Q_23 : STD_LOGIC; 
  signal Salida_1_OBUF_D_24 : STD_LOGIC; 
  signal Salida_1_OBUF_D1_25 : STD_LOGIC; 
  signal Salida_1_OBUF_D2_26 : STD_LOGIC; 
  signal JK_1_Q_aux_27 : STD_LOGIC; 
  signal Salida_0_OBUF_Q_28 : STD_LOGIC; 
  signal Salida_0_OBUF_D_29 : STD_LOGIC; 
  signal Salida_0_OBUF_D1_30 : STD_LOGIC; 
  signal Salida_0_OBUF_D2_31 : STD_LOGIC; 
  signal JK_0_Q_aux_32 : STD_LOGIC; 
  signal Salida_0_OBUF_D2_PT_0_33 : STD_LOGIC; 
  signal Salida_0_OBUF_D2_PT_1_34 : STD_LOGIC; 
  signal JK_1_Q_aux_Q : STD_LOGIC; 
  signal JK_1_Q_aux_RSTF_36 : STD_LOGIC; 
  signal JK_1_Q_aux_SETF_37 : STD_LOGIC; 
  signal JK_1_Q_aux_tsimcreated_set_and_noreset_Q_38 : STD_LOGIC; 
  signal JK_1_Q_aux_tsimcreated_prld_Q_39 : STD_LOGIC; 
  signal JK_1_Q_aux_D_40 : STD_LOGIC; 
  signal JK_1_Q_aux_CLKF_41 : STD_LOGIC; 
  signal JK_1_Q_aux_D1_42 : STD_LOGIC; 
  signal JK_1_Q_aux_D2_43 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_UIM_44 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_UIM_45 : STD_LOGIC; 
  signal JK_0_Q_aux_Q_46 : STD_LOGIC; 
  signal JK_0_Q_aux_D_47 : STD_LOGIC; 
  signal JK_0_Q_aux_D1_48 : STD_LOGIC; 
  signal JK_0_Q_aux_D2_49 : STD_LOGIC; 
  signal JK_0_Q_aux_D2_PT_0_50 : STD_LOGIC; 
  signal JK_0_Q_aux_D2_PT_1_51 : STD_LOGIC; 
  signal JK_2_Q_aux_Q_52 : STD_LOGIC; 
  signal JK_2_Q_aux_D_53 : STD_LOGIC; 
  signal JK_2_Q_aux_D1_54 : STD_LOGIC; 
  signal JK_2_Q_aux_D2_55 : STD_LOGIC; 
  signal JK_2_Q_aux_D2_PT_0_56 : STD_LOGIC; 
  signal JK_2_Q_aux_D2_PT_1_57 : STD_LOGIC; 
  signal JK_2_Q_aux_D2_PT_2_58 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_Q_59 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_D_60 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_D1_61 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_D2_62 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_0_63 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1_64 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_65 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_Q_66 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_D_67 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_D1_68 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_69 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_70 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1_71 : STD_LOGIC; 
  signal JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2_72 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_2_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_2_OBUF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN3 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_0_OBUF_D2_PT_1_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_Salida_0_OBUF_D2_PT_1_IN3 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_tsimcreated_set_and_noreset_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN3 : STD_LOGIC; 
  signal NlwInverterSignal_JK_0_Q_aux_D2_PT_1_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_JK_0_Q_aux_D2_PT_1_IN3 : STD_LOGIC; 
  signal NlwInverterSignal_JK_2_Q_aux_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_JK_2_Q_aux_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN0 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN2 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1_IN1 : STD_LOGIC; 
  signal NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2_IN0 : STD_LOGIC; 
begin
  FCLKIO_0 : X_BUF
    port map (
      I => Clock,
      O => FCLKIO_0_1
    );
  A_D_IBUF : X_BUF
    port map (
      I => A_D,
      O => A_D_IBUF_3
    );
  Salida_2_Q : X_BUF
    port map (
      I => Salida_2_OBUF_Q_5,
      O => Salida(2)
    );
  Salida_1_Q : X_BUF
    port map (
      I => Salida_1_OBUF_Q_7,
      O => Salida(1)
    );
  Salida_0_Q : X_BUF
    port map (
      I => Salida_0_OBUF_Q_9,
      O => Salida(0)
    );
  Salida_2_OBUF_Q : X_BUF
    port map (
      I => Salida_2_OBUF_Q_10,
      O => Salida_2_OBUF_Q_5
    );
  Salida_2_OBUF : X_BUF
    port map (
      I => Salida_2_OBUF_Q_10,
      O => Salida_2_OBUF_11
    );
  Salida_2_OBUF_REG : X_FF
    generic map(
      INIT => '0'
    )
    port map (
      I => Salida_2_OBUF_D_12,
      CE => Vcc_14,
      CLK => FCLKIO_0_1,
      SET => Gnd_13,
      RST => Gnd_13,
      O => Salida_2_OBUF_Q_10
    );
  Gnd : X_ZERO
    port map (
      O => Gnd_13
    );
  Vcc : X_ONE
    port map (
      O => Vcc_14
    );
  Salida_2_OBUF_D : X_XOR2
    port map (
      I0 => Salida_2_OBUF_D1_15,
      I1 => Salida_2_OBUF_D2_16,
      O => Salida_2_OBUF_D_12
    );
  Salida_2_OBUF_D1 : X_ZERO
    port map (
      O => Salida_2_OBUF_D1_15
    );
  Salida_2_OBUF_D2_PT_0 : X_AND2
    port map (
      I0 => Salida_1_OBUF_17,
      I1 => NlwInverterSignal_Salida_2_OBUF_D2_PT_0_IN1,
      O => Salida_2_OBUF_D2_PT_0_19
    );
  Salida_2_OBUF_D2_PT_1 : X_AND3
    port map (
      I0 => A_D_IBUF_3,
      I1 => NlwInverterSignal_Salida_2_OBUF_D2_PT_1_IN1,
      I2 => Salida_0_OBUF_20,
      O => Salida_2_OBUF_D2_PT_1_21
    );
  Salida_2_OBUF_D2_PT_2 : X_AND3
    port map (
      I0 => NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN0,
      I1 => NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN1,
      I2 => NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN2,
      O => Salida_2_OBUF_D2_PT_2_22
    );
  Salida_2_OBUF_D2 : X_OR3
    port map (
      I0 => Salida_2_OBUF_D2_PT_0_19,
      I1 => Salida_2_OBUF_D2_PT_1_21,
      I2 => Salida_2_OBUF_D2_PT_2_22,
      O => Salida_2_OBUF_D2_16
    );
  Salida_1_OBUF_Q : X_BUF
    port map (
      I => Salida_1_OBUF_Q_23,
      O => Salida_1_OBUF_Q_7
    );
  Salida_1_OBUF : X_BUF
    port map (
      I => Salida_1_OBUF_Q_23,
      O => Salida_1_OBUF_17
    );
  Salida_1_OBUF_REG : X_FF
    generic map(
      INIT => '0'
    )
    port map (
      I => Salida_1_OBUF_D_24,
      CE => Vcc_14,
      CLK => FCLKIO_0_1,
      SET => Gnd_13,
      RST => Gnd_13,
      O => Salida_1_OBUF_Q_23
    );
  Salida_1_OBUF_D : X_XOR2
    port map (
      I0 => Salida_1_OBUF_D1_25,
      I1 => Salida_1_OBUF_D2_26,
      O => Salida_1_OBUF_D_24
    );
  Salida_1_OBUF_D1 : X_ZERO
    port map (
      O => Salida_1_OBUF_D1_25
    );
  Salida_1_OBUF_D2 : X_AND2
    port map (
      I0 => JK_1_Q_aux_27,
      I1 => JK_1_Q_aux_27,
      O => Salida_1_OBUF_D2_26
    );
  Salida_0_OBUF_Q : X_BUF
    port map (
      I => Salida_0_OBUF_Q_28,
      O => Salida_0_OBUF_Q_9
    );
  Salida_0_OBUF : X_BUF
    port map (
      I => Salida_0_OBUF_Q_28,
      O => Salida_0_OBUF_20
    );
  Salida_0_OBUF_REG : X_FF
    generic map(
      INIT => '0'
    )
    port map (
      I => Salida_0_OBUF_D_29,
      CE => Vcc_14,
      CLK => FCLKIO_0_1,
      SET => Gnd_13,
      RST => Gnd_13,
      O => Salida_0_OBUF_Q_28
    );
  Salida_0_OBUF_D : X_XOR2
    port map (
      I0 => Salida_0_OBUF_D1_30,
      I1 => Salida_0_OBUF_D2_31,
      O => Salida_0_OBUF_D_29
    );
  Salida_0_OBUF_D1 : X_ZERO
    port map (
      O => Salida_0_OBUF_D1_30
    );
  Salida_0_OBUF_D2_PT_0 : X_AND4
    port map (
      I0 => A_D_IBUF_3,
      I1 => NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN1,
      I2 => NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN2,
      I3 => NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN3,
      O => Salida_0_OBUF_D2_PT_0_33
    );
  Salida_0_OBUF_D2_PT_1 : X_AND4
    port map (
      I0 => NlwInverterSignal_Salida_0_OBUF_D2_PT_1_IN0,
      I1 => Salida_1_OBUF_17,
      I2 => Salida_2_OBUF_11,
      I3 => NlwInverterSignal_Salida_0_OBUF_D2_PT_1_IN3,
      O => Salida_0_OBUF_D2_PT_1_34
    );
  Salida_0_OBUF_D2 : X_OR2
    port map (
      I0 => Salida_0_OBUF_D2_PT_0_33,
      I1 => Salida_0_OBUF_D2_PT_1_34,
      O => Salida_0_OBUF_D2_31
    );
  JK_1_Q_aux : X_BUF
    port map (
      I => JK_1_Q_aux_Q,
      O => JK_1_Q_aux_27
    );
  JK_1_Q_aux_tsimcreated_set_and_noreset_Q : X_AND2
    port map (
      I0 => NlwInverterSignal_JK_1_Q_aux_tsimcreated_set_and_noreset_IN0,
      I1 => JK_1_Q_aux_SETF_37,
      O => JK_1_Q_aux_tsimcreated_set_and_noreset_Q_38
    );
  JK_1_Q_aux_tsimcreated_prld_Q : X_OR2
    port map (
      I0 => JK_1_Q_aux_RSTF_36,
      I1 => Gnd_13,
      O => JK_1_Q_aux_tsimcreated_prld_Q_39
    );
  JK_1_Q_aux_REG : X_FF
    generic map(
      INIT => '0'
    )
    port map (
      I => JK_1_Q_aux_D_40,
      CE => Vcc_14,
      CLK => JK_1_Q_aux_CLKF_41,
      SET => JK_1_Q_aux_tsimcreated_set_and_noreset_Q_38,
      RST => JK_1_Q_aux_tsimcreated_prld_Q_39,
      O => JK_1_Q_aux_Q
    );
  JK_1_Q_aux_D : X_XOR2
    port map (
      I0 => JK_1_Q_aux_D1_42,
      I1 => JK_1_Q_aux_D2_43,
      O => JK_1_Q_aux_D_40
    );
  JK_1_Q_aux_D1 : X_ZERO
    port map (
      O => JK_1_Q_aux_D1_42
    );
  JK_1_Q_aux_D2 : X_ZERO
    port map (
      O => JK_1_Q_aux_D2_43
    );
  JK_1_Q_aux_CLKF : X_ZERO
    port map (
      O => JK_1_Q_aux_CLKF_41
    );
  JK_1_Q_aux_SETF : X_AND2
    port map (
      I0 => JK_1_Q_aux_JK_1_Q_aux_SETF_UIM_44,
      I1 => JK_1_Q_aux_JK_1_Q_aux_SETF_UIM_44,
      O => JK_1_Q_aux_SETF_37
    );
  JK_1_Q_aux_RSTF : X_AND2
    port map (
      I0 => JK_1_Q_aux_JK_1_Q_aux_RSTF_UIM_45,
      I1 => JK_1_Q_aux_JK_1_Q_aux_RSTF_UIM_45,
      O => JK_1_Q_aux_RSTF_36
    );
  JK_0_Q_aux : X_BUF
    port map (
      I => JK_0_Q_aux_Q_46,
      O => JK_0_Q_aux_32
    );
  JK_0_Q_aux_Q : X_BUF
    port map (
      I => JK_0_Q_aux_D_47,
      O => JK_0_Q_aux_Q_46
    );
  JK_0_Q_aux_D : X_XOR2
    port map (
      I0 => JK_0_Q_aux_D1_48,
      I1 => JK_0_Q_aux_D2_49,
      O => JK_0_Q_aux_D_47
    );
  JK_0_Q_aux_D1 : X_ZERO
    port map (
      O => JK_0_Q_aux_D1_48
    );
  JK_0_Q_aux_D2_PT_0 : X_AND4
    port map (
      I0 => A_D_IBUF_3,
      I1 => NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN1,
      I2 => NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN2,
      I3 => NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN3,
      O => JK_0_Q_aux_D2_PT_0_50
    );
  JK_0_Q_aux_D2_PT_1 : X_AND4
    port map (
      I0 => NlwInverterSignal_JK_0_Q_aux_D2_PT_1_IN0,
      I1 => Salida_1_OBUF_17,
      I2 => Salida_2_OBUF_11,
      I3 => NlwInverterSignal_JK_0_Q_aux_D2_PT_1_IN3,
      O => JK_0_Q_aux_D2_PT_1_51
    );
  JK_0_Q_aux_D2 : X_OR2
    port map (
      I0 => JK_0_Q_aux_D2_PT_0_50,
      I1 => JK_0_Q_aux_D2_PT_1_51,
      O => JK_0_Q_aux_D2_49
    );
  JK_2_Q_aux : X_BUF
    port map (
      I => JK_2_Q_aux_Q_52,
      O => JK_2_Q_aux_18
    );
  JK_2_Q_aux_Q : X_BUF
    port map (
      I => JK_2_Q_aux_D_53,
      O => JK_2_Q_aux_Q_52
    );
  JK_2_Q_aux_D : X_XOR2
    port map (
      I0 => JK_2_Q_aux_D1_54,
      I1 => JK_2_Q_aux_D2_55,
      O => JK_2_Q_aux_D_53
    );
  JK_2_Q_aux_D1 : X_ZERO
    port map (
      O => JK_2_Q_aux_D1_54
    );
  JK_2_Q_aux_D2_PT_0 : X_AND2
    port map (
      I0 => Salida_1_OBUF_17,
      I1 => NlwInverterSignal_JK_2_Q_aux_D2_PT_0_IN1,
      O => JK_2_Q_aux_D2_PT_0_56
    );
  JK_2_Q_aux_D2_PT_1 : X_AND3
    port map (
      I0 => A_D_IBUF_3,
      I1 => NlwInverterSignal_JK_2_Q_aux_D2_PT_1_IN1,
      I2 => Salida_0_OBUF_20,
      O => JK_2_Q_aux_D2_PT_1_57
    );
  JK_2_Q_aux_D2_PT_2 : X_AND3
    port map (
      I0 => NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN0,
      I1 => NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN1,
      I2 => NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN2,
      O => JK_2_Q_aux_D2_PT_2_58
    );
  JK_2_Q_aux_D2 : X_OR3
    port map (
      I0 => JK_2_Q_aux_D2_PT_0_56,
      I1 => JK_2_Q_aux_D2_PT_1_57,
      I2 => JK_2_Q_aux_D2_PT_2_58,
      O => JK_2_Q_aux_D2_55
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_UIM : X_BUF
    port map (
      I => JK_1_Q_aux_JK_1_Q_aux_SETF_Q_59,
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_UIM_44
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_Q : X_BUF
    port map (
      I => JK_1_Q_aux_JK_1_Q_aux_SETF_D_60,
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_Q_59
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_D : X_XOR2
    port map (
      I0 => JK_1_Q_aux_JK_1_Q_aux_SETF_D1_61,
      I1 => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_62,
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_D_60
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_D1 : X_ZERO
    port map (
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_D1_61
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_0 : X_AND3
    port map (
      I0 => A_D_IBUF_3,
      I1 => Salida_0_OBUF_20,
      I2 => Salida_2_OBUF_11,
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_0_63
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1 : X_AND3
    port map (
      I0 => A_D_IBUF_3,
      I1 => Salida_0_OBUF_20,
      I2 => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1_IN2,
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1_64
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2 : X_AND3
    port map (
      I0 => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN0,
      I1 => Salida_2_OBUF_11,
      I2 => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN2,
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_65
    );
  JK_1_Q_aux_JK_1_Q_aux_SETF_D2 : X_OR3
    port map (
      I0 => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_0_63,
      I1 => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1_64,
      I2 => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_65,
      O => JK_1_Q_aux_JK_1_Q_aux_SETF_D2_62
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_UIM : X_BUF
    port map (
      I => JK_1_Q_aux_JK_1_Q_aux_RSTF_Q_66,
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_UIM_45
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_Q : X_BUF
    port map (
      I => JK_1_Q_aux_JK_1_Q_aux_RSTF_D_67,
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_Q_66
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_D : X_XOR2
    port map (
      I0 => JK_1_Q_aux_JK_1_Q_aux_RSTF_D1_68,
      I1 => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_69,
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_D_67
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_D1 : X_ZERO
    port map (
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_D1_68
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0 : X_AND3
    port map (
      I0 => A_D_IBUF_3,
      I1 => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN1,
      I2 => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN2,
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_70
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1 : X_AND3
    port map (
      I0 => A_D_IBUF_3,
      I1 => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1_IN1,
      I2 => JK_1_Q_aux_27,
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1_71
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2 : X_AND3
    port map (
      I0 => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2_IN0,
      I1 => Salida_2_OBUF_11,
      I2 => JK_1_Q_aux_27,
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2_72
    );
  JK_1_Q_aux_JK_1_Q_aux_RSTF_D2 : X_OR3
    port map (
      I0 => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_70,
      I1 => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1_71,
      I2 => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2_72,
      O => JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_69
    );
  NlwInverterBlock_Salida_2_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => JK_2_Q_aux_18,
      O => NlwInverterSignal_Salida_2_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Salida_2_OBUF_D2_PT_1_IN1 : X_INV
    port map (
      I => JK_2_Q_aux_18,
      O => NlwInverterSignal_Salida_2_OBUF_D2_PT_1_IN1
    );
  NlwInverterBlock_Salida_2_OBUF_D2_PT_2_IN0 : X_INV
    port map (
      I => A_D_IBUF_3,
      O => NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN0
    );
  NlwInverterBlock_Salida_2_OBUF_D2_PT_2_IN1 : X_INV
    port map (
      I => JK_2_Q_aux_18,
      O => NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN1
    );
  NlwInverterBlock_Salida_2_OBUF_D2_PT_2_IN2 : X_INV
    port map (
      I => Salida_0_OBUF_20,
      O => NlwInverterSignal_Salida_2_OBUF_D2_PT_2_IN2
    );
  NlwInverterBlock_Salida_0_OBUF_D2_PT_0_IN1 : X_INV
    port map (
      I => Salida_1_OBUF_17,
      O => NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN1
    );
  NlwInverterBlock_Salida_0_OBUF_D2_PT_0_IN2 : X_INV
    port map (
      I => Salida_2_OBUF_11,
      O => NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN2
    );
  NlwInverterBlock_Salida_0_OBUF_D2_PT_0_IN3 : X_INV
    port map (
      I => JK_0_Q_aux_32,
      O => NlwInverterSignal_Salida_0_OBUF_D2_PT_0_IN3
    );
  NlwInverterBlock_Salida_0_OBUF_D2_PT_1_IN0 : X_INV
    port map (
      I => A_D_IBUF_3,
      O => NlwInverterSignal_Salida_0_OBUF_D2_PT_1_IN0
    );
  NlwInverterBlock_Salida_0_OBUF_D2_PT_1_IN3 : X_INV
    port map (
      I => JK_0_Q_aux_32,
      O => NlwInverterSignal_Salida_0_OBUF_D2_PT_1_IN3
    );
  NlwInverterBlock_JK_1_Q_aux_tsimcreated_set_and_noreset_IN0 : X_INV
    port map (
      I => JK_1_Q_aux_RSTF_36,
      O => NlwInverterSignal_JK_1_Q_aux_tsimcreated_set_and_noreset_IN0
    );
  NlwInverterBlock_JK_0_Q_aux_D2_PT_0_IN1 : X_INV
    port map (
      I => Salida_1_OBUF_17,
      O => NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN1
    );
  NlwInverterBlock_JK_0_Q_aux_D2_PT_0_IN2 : X_INV
    port map (
      I => Salida_2_OBUF_11,
      O => NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN2
    );
  NlwInverterBlock_JK_0_Q_aux_D2_PT_0_IN3 : X_INV
    port map (
      I => JK_0_Q_aux_32,
      O => NlwInverterSignal_JK_0_Q_aux_D2_PT_0_IN3
    );
  NlwInverterBlock_JK_0_Q_aux_D2_PT_1_IN0 : X_INV
    port map (
      I => A_D_IBUF_3,
      O => NlwInverterSignal_JK_0_Q_aux_D2_PT_1_IN0
    );
  NlwInverterBlock_JK_0_Q_aux_D2_PT_1_IN3 : X_INV
    port map (
      I => JK_0_Q_aux_32,
      O => NlwInverterSignal_JK_0_Q_aux_D2_PT_1_IN3
    );
  NlwInverterBlock_JK_2_Q_aux_D2_PT_0_IN1 : X_INV
    port map (
      I => JK_2_Q_aux_18,
      O => NlwInverterSignal_JK_2_Q_aux_D2_PT_0_IN1
    );
  NlwInverterBlock_JK_2_Q_aux_D2_PT_1_IN1 : X_INV
    port map (
      I => JK_2_Q_aux_18,
      O => NlwInverterSignal_JK_2_Q_aux_D2_PT_1_IN1
    );
  NlwInverterBlock_JK_2_Q_aux_D2_PT_2_IN0 : X_INV
    port map (
      I => A_D_IBUF_3,
      O => NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN0
    );
  NlwInverterBlock_JK_2_Q_aux_D2_PT_2_IN1 : X_INV
    port map (
      I => JK_2_Q_aux_18,
      O => NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN1
    );
  NlwInverterBlock_JK_2_Q_aux_D2_PT_2_IN2 : X_INV
    port map (
      I => Salida_0_OBUF_20,
      O => NlwInverterSignal_JK_2_Q_aux_D2_PT_2_IN2
    );
  NlwInverterBlock_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1_IN2 : X_INV
    port map (
      I => JK_1_Q_aux_27,
      O => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_1_IN2
    );
  NlwInverterBlock_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN0 : X_INV
    port map (
      I => A_D_IBUF_3,
      O => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN0
    );
  NlwInverterBlock_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN2 : X_INV
    port map (
      I => JK_1_Q_aux_27,
      O => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_SETF_D2_PT_2_IN2
    );
  NlwInverterBlock_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN1 : X_INV
    port map (
      I => Salida_0_OBUF_20,
      O => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN1
    );
  NlwInverterBlock_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN2 : X_INV
    port map (
      I => Salida_2_OBUF_11,
      O => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_0_IN2
    );
  NlwInverterBlock_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1_IN1 : X_INV
    port map (
      I => Salida_2_OBUF_11,
      O => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_1_IN1
    );
  NlwInverterBlock_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2_IN0 : X_INV
    port map (
      I => A_D_IBUF_3,
      O => NlwInverterSignal_JK_1_Q_aux_JK_1_Q_aux_RSTF_D2_PT_2_IN0
    );
  NlwBlockROC : X_ROC
    generic map (ROC_WIDTH => 100 ns)
    port map (O => PRLD);

end Structure;

