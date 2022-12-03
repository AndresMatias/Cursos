# https://www.it-swarm-es.com/es/python/creando-un-singleton-en-python/972393601/
# https://puropython.blogspot.com/2016/09/el-patron-singleton-o-una-instanciar.html
# https://www.youtube.com/watch?v=RSnU0GFRwTo&ab_channel=codigofacilito

def singleton(cls):
    obj = cls()
    # Siempre devuelve el mismo objeto
    cls.__new__ = staticmethod(lambda cls: obj)
    # Desabilita __init__
    try:
        del cls.__init__
    except AttributeError:
        pass
    return cls

@singleton
class A(object):
    def __init__(self):
    	print('Hola')


if A() is A():
	print("Es lo mismo!")
else:
    print("Es diferente!")

#No repite el contructor
B=A()
C=A()
