#Rotulos a ejes y titulos del dibujo:
# xlabel('')
# ylabel('')
# zlabel('')
# title('')

#Propiedades a los rotulos: zlabel('Eje z','Fontsize',16)

#Para etiquetar varias figuras(asignacion segun orden de aparicion):
# legend('Etiqueta figura 1','Etiqueta figura 2',...)

#Ejemplo
    #x=(-pi  : pi/60 : pi)
    #y_1=sin(x)
    #y_2=cos(x)
    #plot(x,y_1,'k','linewidth',3,x,y_2,'r','linewidth',3)
    #legend('sen(x)','cos(x)')
    #ylabel('sen(x);cos(x)','fontsize',15,'fontweight','bold')

#Puntos de vista:view()
  #view([az,el])  Situa el punto de vista con azimut y elevacion
  #view([x,y,z])  Situa el punto de vista con coordenadas cartesianas
  #view(3)  Vuelve al punto de vista por defecto
#Azimut:Angulo de rotacion en sentido antihorario en el eje xy medido desde el eje -y
#Elevacion:Con respecto al plano xy
#Ejemplo:Ejecutar instrucion surf(peaks()) Instruccion para prueba de graficos secuencia de comandos como sigue
    #>>surf(peaks())
    #>> view([0,0,-100])
    #>> view([0,100,0])
    #>> view([37,45])

#Funcion subplot(m,n,p): Divide una ventana en subventanas mxn activando p-nesimas subventanas para visualizar diferentes graficos
#Ejemplo
    #x=(0 : pi/60 : pi)
    #y_1=log(x)
    #subplot(1,2,1)  #(m,n,p): mxn: Define el numero de subventanas 1x2: 2 subventanas p: Define la ubicacion del grafico en algunas de esas ventanas
    #plot(x,y_1)
    #title('log(x)','fontsize',15)
    #subplot(1,2,2)
    #y_2=log10(x)
    #plot(x,y_2)
    #title('log10(x)','fontsize',15)

#Perzonalizar los ejes:
  #axis off: Desactiva ejes
  #axis on: Activa ejes
  #axis([xmin xmax ymin ymax]): Establece la escala para ejes x e y
  #axis([xmin xmax ymin ymax zmin zmax]): Establece la escala para ejes x,y,z
  #axis tight: Obliga a conicidir los limites de los ejes con los datos representados
  #axis equal: Obliga a que las marcas en unidades de los ejes x y z sean iguales principalmente para representar figuras con secciones circuilares
  #axis image = axis tight + axis equal

#Comandos utilitarios:
  #clf: Borra la figura activa
  #colorbar: Muestra en la figura la escala de color para el grfico representado
  #grid off: Se eliminan las lineas discontinuas en los planos coordenados que marcan las divisiones en los ejes
  #grid on: Lo contrario de grid off

#hold on: Sirve para dibujar varias figuras en una misma ventanas con diferentes plot
#Ejemplo
x=(0 : 0.001 : 1)
y_1=x.^2
y_2=x.^0.5
y_3=x.^3
hold on
plot(x,y_1,'r','linewidth',3)
plot(x,y_2,'b','linewidth',3)
plot(x,y_3,'g','linewidth',3)  