#Metodo iterativo para ecuaciones no lineales
  #Newton-Raphson apra f(x)=0, se estima el error en cada paso
#Ejemplo
function Sistemas_No_Lineales(Funcion,derivada,x0,tolerancia,maxit) #Metodo Newton-Raphson
  f=inline(Funcion)
  df=inline(derivada)
  niter=0
  while niter<maxit
    x1=x0-f(x0)/df(x0) #Ver Grafica del video para esta formula
    niter=niter+1
    if abs(x1-x0)<tolerancia  #Estimacion del error
      fprintf("Solucion: %f\n",x1)
      fprintf("Iteraciones: %d\n",niter)
      return;      
    endif
    x0=x1
  endwhile
  disp("El metodo no converge")
endfunction
