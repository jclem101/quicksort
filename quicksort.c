//quicksort in C
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define ARRAYSIZE 10 //change this to see different sizes of arrays sorted

void quicksort( int array[], int left, int right){


   if( left < right ){
       int pivotvalue, tleft, tright, temp;
	   pivotvalue = array[left];
	   tleft = left; tright = right;
		
	   while(1){
			if( tleft >= tright ){ 
		   		break;
		   	}
		   	while( array[tleft] <= pivotvalue && tleft <= right ){
		   		tleft++;
		   	}
		   	
		   	while( array[tright] > pivotvalue ){
		   		tright--;
		   	}
		   	

		   	
		   	temp = array[tleft]; 
		   	array[tleft] = array[tright]; 
		   	array[tright] = temp;
	   }
	   temp = array[left]; 
	   array[left] = array[tright]; 
	   array[tright] = temp;
       
       quicksort( array, left, tright-1);
       quicksort( array, tright+1, right);
   }
	
}


int main(){
	int array[ARRAYSIZE];
	srand(time(NULL));
	int i, previous;

	for(i = 0;i<ARRAYSIZE;i++){
		array[i] = rand()%10;//pseudo random numbers between 0 and 9
		printf("%i", array[i]);
	}
	printf("\n");


	quicksort(array,0,ARRAYSIZE-1);
	
	previous = array[0];
	
	for(i = 0;i<ARRAYSIZE;i++){
		if(previous > array[i]){//test for sorted condition
			printf("error");
		}
		printf("%i", array[i]);
		previous  = array[i];
	}
	printf("\n");
}
