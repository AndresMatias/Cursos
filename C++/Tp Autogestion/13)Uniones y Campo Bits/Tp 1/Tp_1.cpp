#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

struct Campos_De_Bits
{
	unsigned int Bit_1:1;
	unsigned int Bit_2:1;
	//unsigned char Bit_3:4;
	unsigned int Bit_4:1;
};
int main(int argc, char *argv[]) 
{
	struct Campos_De_Bits Base;
	Base.Bit_1=1;
	Base.Bit_4=0;
	Base.Bit_2=Base.Bit_4&Base.Bit_1; //Operador binario and (como la compuerta multiplicadora logica and es lo mismo)
	cout<<"sizeof:"<<sizeof(Base)<<endl;
	cout<<"Bit 4:"<<Base.Bit_4<<ends<<" Bit 1:"<<Base.Bit_1<<ends<<ends<<"Operacion ""AND"":"<<Base.Bit_2<<endl;
	Base.Bit_2=Base.Bit_4^Base.Bit_1; //Operador binario xor (como la compuerta xor logica es lo mismo)
	cout<<"Bit 4:"<<Base.Bit_4<<ends<<" Bit 1:"<<Base.Bit_1<<ends<<ends<<"Operacion ""OR Exclusivo(XOR)"":"<<Base.Bit_2<<endl;
	Base.Bit_2=Base.Bit_4|Base.Bit_1; //Operador binario or (como la compuerta or logica es lo mismo)
	cout<<"Bit 4:"<<Base.Bit_4<<ends<<" Bit 1:"<<Base.Bit_1<<ends<<ends<<"Operacion ""OR Inclusivo"":"<<Base.Bit_2<<endl;
	return 0;
}

