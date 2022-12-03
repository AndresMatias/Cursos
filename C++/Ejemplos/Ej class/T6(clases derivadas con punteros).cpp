#include<iostream>
using namespace std;

class par{
protected:
	float x;
	float y;
public:
	par(float a,float b){x=a;y=b;};
	int imprimir(){cout<<x<<"hola"<<y;return 0;};
};

class terna:public par{
	float z;
public:
	terna(float a,float b,float c):par(a,b){z=c;};
	int imprimir(){cout<<x<<"hola2"<<y<<z;return 0;};
};

int main(){
	class par *p1=new par(2,3);
	class terna *t1=new terna(4,5,6);
	p1->imprimir();
	t1->imprimir();
}
