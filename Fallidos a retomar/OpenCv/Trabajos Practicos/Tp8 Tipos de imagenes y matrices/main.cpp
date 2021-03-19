#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;
void Estructura_De_Matriz_Mat();
int main(int argc, char** argv) 
{
	float sum( const CvMat* mat ) 
	{
		
		float s = 0.0f;  
		for(int row=0; row<mat->rows; row++ ) 
		{    
			const float* ptr = (const float*)(mat->data.ptr + row * mat->step);    
			for( col=0; col<mat->cols; col++ ) 
			{      
				s += *ptr++;   
			}  
		}
	return( s ); 
	}
	return 0;
} 

