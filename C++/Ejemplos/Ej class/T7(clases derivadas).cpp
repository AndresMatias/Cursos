#include<iostream>
using namespace std;

class par{
protected:
	float x;
	float y;
public:
	par(float a,float b){x=a;y=b;};
	int imprimir(){cout<<x<<y;return 0;};
};

class terna:public par{
protected:
	float z;
public:
	terna(float h,float b,float c):par(h,b){z=c;};
	int imprimir(){cout<<x<<y<<z;return 0;};
};

class cuaterna:public terna{
	float w;
public:
	cuaterna(float a,float b, float c, float d): terna(a,b,c){w=d;};
	int imprimir(){cout<<x<<y<<z<<w;return 0;};
	};

int main()
{
	class par *p1=new par(2,3);
	class terna *t1=new terna(4,5,6);
	class cuaterna *c1=new cuaterna(7,8,9,10);
	p1->imprimir();
	t1->imprimir();
	c1->imprimir();
}
