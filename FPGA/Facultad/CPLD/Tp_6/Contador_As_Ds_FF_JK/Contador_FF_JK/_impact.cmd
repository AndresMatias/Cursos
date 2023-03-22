loadProjectFile -file "D:\CPLD\Tp_6\Contador_As_Ds_FF_JK\Contador_FF_JK/Contador_FF_JK.ipf"
setMode -ss
setMode -sm
setMode -hw140
setMode -spi
setMode -acecf
setMode -acempm
setMode -pff
setMode -bs
setMode -bs
setMode -bs
setMode -bs
assignFile -p 1 -file "D:/CPLD/Tp_6/Contador_As_Ds_FF_JK/Contador_FF_JK/Contador.jed"
Program -p 1 -e -v 
Verify -p 1 
Program -p 1 -e -v 
saveProjectFile -file "D:/CPLD/Tp_6/Contador_As_Ds_FF_JK/Contador_FF_JK/Contador_FF_JK.ipf"
setMode -bs
deleteDevice -position 1
setMode -bs
setMode -bs
setCable -port auto
Identify 
identifyMPM 
assignFile -p 1 -file "D:/CPLD/Tp_7/Contador_As_Ds_D/Contador_FF_D/Main.jed"
Program -p 1 -e -v 
saveProjectFile -file "D:/CPLD/Tp_7/Contador_As_Ds_D/Contador_FF_D/Contador_FF_D.ipf"
setMode -bs
deleteDevice -position 1
setMode -bs
setMode -bs
setCable -port auto
Identify 
identifyMPM 
assignFile -p 1 -file "D:/CPLD/Tp_7/Contador_As_Ds_D/M_E/Top.jed"
Program -p 1 -e -v 
saveProjectFile -file "D:/CPLD/Tp_7/Contador_As_Ds_D/M_E/M_E.ipf"
setMode -bs
deleteDevice -position 1
setMode -ss
setMode -sm
setMode -hw140
setMode -spi
setMode -acecf
setMode -acempm
setMode -pff
setMode -bs
