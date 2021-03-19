#Pasos a seguir para graficar una superficie
 #1)Discretizo x en un vector
 #2)Discretizo y en un vector
 #3)Calcular[M_x,M_y]=meshgrid(x,y) es el mallado que genera una matriz de coordena
 #4)Calcular M_z=f(M_x,M_y)
 #5)Dibujar las graficas con las siguientes funciones: 
                   #surf(M_x,M_y,M_z)
                   #mesh(M_x,M_y,M_z)
                   #plot3(M_x,M_y,M_z)
                   
#------------------------------------------------------------------------------------------                   

#Ejemplo 1
#Sea f(x,y)=sen(x)*cos(y) representar en [-2pi,2pi],[-2pi,2pi]
  #Discretizo
    x=(-2*pi : pi/10 :2*pi)
    y=x
  #Mallado
    [M_x,M_y]=meshgrid(x,y)
  #Calculo
    M_z=sin(M_x).*cos(M_y) #.* es operacion elemento a elemento
  #Grafico con alguna de las tres funciones
    mesh(M_x,M_y,M_z)

#Ejemplo 2:Funcion ya parametrizada
#Sea f(x(u,v),y(u,v),z(u,v)) x=R*cos(u)*cos(v), y=R*sen(u)*cos(v), z=R*sen(v)
#Con R=2 u=[0,2pi] y v=[-pi/2,pi/2]
  #Discretizo
    u=linspace(0 , 2*pi , 60) #Espaciado lineal para evitar perder ultimo punto
    v=linspace(-pi/2 , pi/2 , 30)
  #Mallado
    [U,V]=meshgrid(u,v)
  #Calculo
    x=2*cos(U).*cos(V)
    y=2*sin(U).*cos(V) 
    z=2*sin(V)
  #Grafico
    surf(x,y,z)
    
#--------------------------------------------------------------------------------------------

#Superficies Cilindricas o Esfericas: Se parametriza
#Se utiliza x=r*cos() y=r*sen() z=z
#Ejemplo 1
#Sea una superficie cilindrica r^2=z con z=[0,1] y el angulo=[0,2pi] graficar
  #Discretizo
    tt=(0 : pi/30 : 2*pi) #tt=tita
    r=(0:0.1:1)
  #Mallada
    [R,TT]=meshgrid(r,tt) #Parametrizacion en funcion de r y tt
  #Calculo
    z=R.^2 #  .^  Operacion elmento a elemento
    x=R.*cos(TT)
    y=R.*sin(TT)
  #Calculo
    surf(x,y,z)
#Discretizo al radio y al angulo, genero el mallado en base al radio y al angulo, y calculo reemplazando por .* o .^ segun lo requiera porque son matrices y/o vectores para que hagan operacion elemento a elemento    