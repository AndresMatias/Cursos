loadProjectFile -file "D:\andres\Tp_2\Tp_2/Tp_2.ipf"
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
Verify -p 1 
Verify -p 1 
Program -p 1 -e -v 
Erase -p 1 
Program -p 1 -e -v 
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
