//quicksort in JAVA

import java.util.Random;
public class quicksort{
	public final static int ARRAYSIZE = 10;

	public static void quicksort(int array[], int left, int right){

   		if( left < right ){
		   int pivotvalue, tleft, tright, temp;
		   pivotvalue = array[left];
		   tleft = left; tright = right;
		
		   while(true){
				
			   	while( array[tleft] <= pivotvalue && tleft < right ){//note difference in logic from c version
			   		tleft++;
			   	}
			   	
			   	while( array[tright] > pivotvalue ){
			   		tright--;
			   	}
			   	if( tleft >= tright ){//needed to move this block from c version
			   		break;
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

	public static void main(String[] args){

		int[] array = new int[ARRAYSIZE];
		Random rand = new Random();
		int previous;

		for(int i = 0;i<ARRAYSIZE;i++){
			array[i] =rand.nextInt(10);//pseudo random numbers between 0 and 9
			System.out.print(""+array[i]+"");
		}
		System.out.println(" ");


		quicksort(array,0,ARRAYSIZE-1);
	
		previous = array[0];
	
		for(int i = 0;i<ARRAYSIZE;i++){
			if(previous > array[i]){//test for sorted condition
				System.out.print("error");
			}
			System.out.print("" + array[i] + "");
			previous  = array[i];
		}
		System.out.println("");
	}

}
