#Calculo del area de una funcion mediante el metodo del trapecio
function [int]= Integral_Trapecio(Funcion,a,b,m) #a y b extremos de la integral Funcion:Funcion a introducir m:Numero de divisiones de rectangulos
  f=inline(Funcion) #Sirve para luego llamar a la funcion en la forma f(x) y solo ingreso la x sin poner toda la funcion
  h=(b-a)/m #Genero la amplitud de cada intervalor
  x=(a : h : b)  #Discretizo x
  int=0
  for i=1 : m
    int=int+f(x(i))+f(x(i+1))
  endfor
int=h/2*int #Calculo el area de la funcion 
endfunction