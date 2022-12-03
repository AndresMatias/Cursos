#Funcion quiver(Mx,My,U,V): Visualizar campo vectorial en 2D Mx y My matrices de mallado, U y V:Vectores
#Ejemplo: F=[(x^2)*y,3*sen(x+y)]=F(u,v)
    #x=linspace(-1,1,10)
    #y=x
    #[Mx,My]=meshgrid(x,y)
    #U=Mx.^2.*My
    #V=3*sin(Mx+My)
    #quiver(Mx,My,U,V)
    #axis equal
    #xlabel('Eje x')
    #ylabel('Eje y')  

#Para 3D se utilizar quiver3(Mx,My,Mz,U,V,W) es lo mismo pero con tres matrices de mallado y tres vectores u,v,w
#Ejemplo:
    #x=linspace(-3,3,6)
    #y=x
    #z=linspace(-1,1,6)
    #[Mx,My,Mz]=meshgrid(x,y,z)
    #U=1+0*Mx
    #V=Mx.^2+My.^2
    #W=3*Mz
    #quiver3(Mx,My,Mz,U,V,W)
    #xlabel('Eje x','Fontsize',16)
    #ylabel('Eje y','Fontsize',16)
    #zlabel('Eje z','Fontsize',16)
    #grid off
    
#Curvas de Nivel:contour
#pcolor(Mx,My,Mz) igual que surf pero con z que tiende a infinito
#contour(Mx,My,Mz,N,str) M:Matrices de mallado N=Dibuja N lineas de nivel si N es un vector dibuja length(N) lineas de nivel si N es un vector de dos valores iguales dibuja un solo contorno al nivel especificado en los elementos N
                         #str:Personalizar color etc
#Ejemplo z=6*exp(-3*x^2-My^2)+0.5*x+y 
x=(-2 : 0.05 : 2)
y=(-2 : 0.05 : 3)
[Mx,My]=meshgrid(x,y)
Mz=6*exp(-3*Mx.^2-My.^2)+0.5*Mx+My
subplot(1,2,1)
surf(Mx,My,Mz)
shading flat
subplot(1,2,2)
pcolor(Mx,My,Mz)
shading flat

hold on
contour(Mx,My,Mz,7,'k')
hold off                          