#rem(m,n) Da el resto de la divicion de m/n
m=input("Ingrene numerador\n")
n=input("Ingrene denominador\n")
#No es del todo correcto es solo para ver como funciona el if y el else
if(rem(m,n)==2)
disp("Numero par") #disp tenia un inconveniente con mostrar valores float o algo asi para eso uso fprintf
else
disp("Numero impar")
end
fprintf("Condicional resumido: rem(m,n)==0 \n")
rem(m,n)==0 #Si el resto es igual a cero devuelve un 1 como true sino un 0 como false

#elseif

if(n<0)
disp("Numero Negativo")
elseif(rem(n,2)==2)
disp("Numero par")
else
disp("Numero positivo")
end