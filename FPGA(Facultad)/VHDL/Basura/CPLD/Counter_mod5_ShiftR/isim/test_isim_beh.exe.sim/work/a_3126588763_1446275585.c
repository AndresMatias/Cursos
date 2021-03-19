/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

/* This file is designed for use with ISim build 0x7708f090 */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "C:/Users/facun/Desktop/Lab 5/Cont-0-9999/clk_1Hz.vhd";
extern char *IEEE_P_1242562249;

unsigned char ieee_p_1242562249_sub_1781507893_1035706684(char *, char *, char *, int );
char *ieee_p_1242562249_sub_1919365254_1035706684(char *, char *, char *, char *, int );


static void work_a_3126588763_1446275585_p_0(char *t0)
{
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;

LAB0:    xsi_set_current_line(26, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    t2 = (t0 + 4336);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(27, ng0);
    t4 = (t0 + 1832U);
    t8 = *((char **)t4);
    t4 = (t0 + 4464);
    t9 = (t4 + 56U);
    t10 = *((char **)t9);
    t11 = (t10 + 56U);
    t12 = *((char **)t11);
    memcpy(t12, t8, 26U);
    xsi_driver_first_trans_fast(t4);
    goto LAB3;

LAB5:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

}

static void work_a_3126588763_1446275585_p_1(char *t0)
{
    char t25[16];
    unsigned char t1;
    char *t2;
    char *t3;
    unsigned char t4;
    unsigned char t5;
    unsigned char t6;
    char *t7;
    char *t8;
    char *t9;
    int t10;
    unsigned char t11;
    char *t12;
    unsigned char t13;
    unsigned char t14;
    char *t15;
    char *t16;
    char *t17;
    char *t18;
    char *t19;
    char *t20;
    char *t21;
    char *t22;
    unsigned char t23;
    unsigned char t24;
    char *t26;
    char *t27;
    char *t28;
    unsigned int t29;
    unsigned int t30;
    unsigned char t31;
    char *t32;
    char *t33;
    char *t34;
    char *t35;
    char *t36;
    char *t37;
    char *t38;
    char *t39;
    char *t40;
    char *t41;
    char *t42;
    char *t43;

LAB0:    xsi_set_current_line(31, ng0);
    t2 = (t0 + 1192U);
    t3 = *((char **)t2);
    t4 = *((unsigned char *)t3);
    t5 = (t4 == (unsigned char)3);
    if (t5 == 1)
        goto LAB5;

LAB6:    t2 = (t0 + 1672U);
    t7 = *((char **)t2);
    t2 = (t0 + 6744U);
    t8 = (t0 + 2288U);
    t9 = *((char **)t8);
    t10 = *((int *)t9);
    t11 = ieee_p_1242562249_sub_1781507893_1035706684(IEEE_P_1242562249, t7, t2, t10);
    if (t11 == 1)
        goto LAB8;

LAB9:    t6 = (unsigned char)0;

LAB10:    t1 = t6;

LAB7:    if (t1 != 0)
        goto LAB3;

LAB4:    t21 = (t0 + 1352U);
    t22 = *((char **)t21);
    t23 = *((unsigned char *)t22);
    t24 = (t23 == (unsigned char)3);
    if (t24 != 0)
        goto LAB11;

LAB12:
LAB15:    t37 = (t0 + 1672U);
    t38 = *((char **)t37);
    t37 = (t0 + 4528);
    t39 = (t37 + 56U);
    t40 = *((char **)t39);
    t41 = (t40 + 56U);
    t42 = *((char **)t41);
    memcpy(t42, t38, 26U);
    xsi_driver_first_trans_fast(t37);

LAB2:    t43 = (t0 + 4352);
    *((int *)t43) = 1;

LAB1:    return;
LAB3:    t8 = xsi_get_transient_memory(26U);
    memset(t8, 0, 26U);
    t15 = t8;
    memset(t15, (unsigned char)2, 26U);
    t16 = (t0 + 4528);
    t17 = (t16 + 56U);
    t18 = *((char **)t17);
    t19 = (t18 + 56U);
    t20 = *((char **)t19);
    memcpy(t20, t8, 26U);
    xsi_driver_first_trans_fast(t16);
    goto LAB2;

LAB5:    t1 = (unsigned char)1;
    goto LAB7;

LAB8:    t8 = (t0 + 1352U);
    t12 = *((char **)t8);
    t13 = *((unsigned char *)t12);
    t14 = (t13 == (unsigned char)3);
    t6 = t14;
    goto LAB10;

LAB11:    t21 = (t0 + 1672U);
    t26 = *((char **)t21);
    t21 = (t0 + 6744U);
    t27 = ieee_p_1242562249_sub_1919365254_1035706684(IEEE_P_1242562249, t25, t26, t21, 1);
    t28 = (t25 + 12U);
    t29 = *((unsigned int *)t28);
    t30 = (1U * t29);
    t31 = (26U != t30);
    if (t31 == 1)
        goto LAB13;

LAB14:    t32 = (t0 + 4528);
    t33 = (t32 + 56U);
    t34 = *((char **)t33);
    t35 = (t34 + 56U);
    t36 = *((char **)t35);
    memcpy(t36, t27, 26U);
    xsi_driver_first_trans_fast(t32);
    goto LAB2;

LAB13:    xsi_size_not_matching(26U, t30, 0);
    goto LAB14;

LAB16:    goto LAB2;

}

static void work_a_3126588763_1446275585_p_2(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    int t5;
    unsigned char t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;

LAB0:    xsi_set_current_line(34, ng0);
    t1 = (t0 + 1672U);
    t2 = *((char **)t1);
    t1 = (t0 + 6744U);
    t3 = (t0 + 2288U);
    t4 = *((char **)t3);
    t5 = *((int *)t4);
    t6 = ieee_p_1242562249_sub_1781507893_1035706684(IEEE_P_1242562249, t2, t1, t5);
    if (t6 != 0)
        goto LAB3;

LAB4:
LAB5:    t11 = (t0 + 4592);
    t12 = (t11 + 56U);
    t13 = *((char **)t12);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    *((unsigned char *)t15) = (unsigned char)2;
    xsi_driver_first_trans_fast(t11);

LAB2:    t16 = (t0 + 4368);
    *((int *)t16) = 1;

LAB1:    return;
LAB3:    t3 = (t0 + 4592);
    t7 = (t3 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    *((unsigned char *)t10) = (unsigned char)3;
    xsi_driver_first_trans_fast(t3);
    goto LAB2;

LAB6:    goto LAB2;

}

static void work_a_3126588763_1446275585_p_3(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(37, ng0);

LAB3:    t1 = (t0 + 1992U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 4656);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t8 = (t0 + 4384);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}


extern void work_a_3126588763_1446275585_init()
{
	static char *pe[] = {(void *)work_a_3126588763_1446275585_p_0,(void *)work_a_3126588763_1446275585_p_1,(void *)work_a_3126588763_1446275585_p_2,(void *)work_a_3126588763_1446275585_p_3};
	xsi_register_didat("work_a_3126588763_1446275585", "isim/test_isim_beh.exe.sim/work/a_3126588763_1446275585.didat");
	xsi_register_executes(pe);
}
