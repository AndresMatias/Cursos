#Calculo del area de una funcion mediante el metodo del rectangulo o punto medio
function [int]= Integral_Rectangulo(Funcion,a,b,m) #a y b extremos de la integral Funcion:Funcion a introducir m:Numero de divisiones de rectangulos
  f=inline(Funcion) #Sirve para luego llamar a la funcion en la forma f(x) y solo ingreso la x sin poner toda la funcion
  h=(b-a)/m #Genero la amplitud de cada intervalor
  x=(a : h : b)  #Discretizo x
  int=0
  for i=1 : m
    xm=(x(i)+x(i+1))/2  #Calculo de punto medio
    int=int+(f(xm)*h) #Calculo el area de la funcion f(xm): Altura, h:Base
  endfor
endfunction
