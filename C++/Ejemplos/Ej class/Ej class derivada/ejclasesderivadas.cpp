using namespace std;
#include <iostream>
#include <stdlib.h>
class par
{
	protected:
		float x;
		float y;
	public:
		par(float a, float b){x=a,y=b;};  
		int imprimir (){cout<< x << y;return 0;};
};
class terna:public par 
{
		float z;
	public:
		terna(float a, float b, float c):par(a,b){z=c;};
};

int main()
{
	class par p1=par(2,3);
	class terna t1=terna(4,5,6);
	p1.imprimir();
	t1.imprimir();
	return 0;
}
