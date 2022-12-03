# coding: utf-8
# Schwab Urbani, Danel. Visión por computadora: TP3.

import sys
import cv2

#if(len(sys.argv) > 1):
#    filename = sys.argv[1]
#else:
#    print('Pass a filename as first argument')
#    sys.exit(0)
    
cap = cv2.VideoCapture("messi.mp4")
fps = cap.get(cv2.CAP_PROP_FPS) #Obtengo las fps para quitar el valor hardcodeado en el ejemplo 
tamaño = (int(cap.get(cv2.CAP_PROP_FRAME_WIDTH)), int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))) #igual con el tamaño

print ("tamaño: ", tamaño)
print ("fps: ", fps)


fourcc = cv2.VideoWriter_fourcc('X','V','I','D')  
out = cv2.VideoWriter('output.avi',fourcc, fps, tamaño, isColor = False)# Incorporo isColor=False sino error al abrir video
# isColor: If it is not zero, the encoder will expect and encode color frames, otherwise it will work with grayscale frames (the flag is currently supported on Windows only).
while(cap.isOpened()):
    ret, frame = cap.read()
    if ret == True:
        
        gray = cv2.cvtColor(frame, cv2.COLOR_RGB2GRAY)
        out.write(gray)
        cv2.imshow('Image gray ', gray)
        if cv2.waitKey(int(fps)) & 0xFF == ord('q'):
            break
    else:
        break       
        
cap.release()
out.release()
cv2.destroyAllWindows()