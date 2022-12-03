#include <iostream>
using namespace std;

union unEjemplo 
{ 
	int A; 
	char B; 
	double C; 
} UnionEjemplo;

int main() 
{ 
	UnionEjemplo.A = 100; 
	cout << UnionEjemplo.A << endl; 
	UnionEjemplo.B = 'a'; 
	cout << UnionEjemplo.B << endl; 
	UnionEjemplo.C = 10.32; 
	cout << UnionEjemplo.C << endl; 
	cout << &UnionEjemplo.A << endl; 
	cout << (void*)&UnionEjemplo.B << endl; 
	cout << &UnionEjemplo.C << endl; 
	cout << sizeof(unEjemplo) << endl; 
	cout << sizeof(UnionEjemplo.A) << endl; 
	cout << sizeof(UnionEjemplo.B) << endl; 
	cout << sizeof(UnionEjemplo.C) << endl; 
	
	return 0; 
}
