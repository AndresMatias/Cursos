#Funcion plot(x,y), x e y son vectores de coordenadas x e y
x=[1 6 5 2 1]
y=[1 0 4 3 1]

#plot(x,y,Cadena_Estilo) y=amarillo g=verde r=rojo b=azul c=cian w=blanco k=negro
#Marcador de punto: "*"  "x"  "o"  "+"
#Tipo de linea: "-"  "--"  "-."  ":"

#Distintans Variantes
  #plot(x,y)
  #plot(x,y,'*r:') #No importa el orden del tercer parametro
  #plot(x,y,'*r:','linewidth',4) linewidth:ancho de linea
  #plot(x,y,'*r:','markersize',5) markersize:tamaño del punto que une a las lineas
  
#Funcion Parabola
  #x=(-10 : 0.1 : 10) #Vector de -10 a 10 con intervalos de 0.1
  #y=x.^2 #Funcion Parabola
  #plot(x,y) #Grafico

#Cicunferencia Parametrizada
  #t=(0 : 0.1 : 2*pi)
  #x=2*cos(t)
  #y=2*sin(t)
  #plot(x,y)