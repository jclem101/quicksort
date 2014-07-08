#quicksort in python
import random
ARRAYSIZE = 50

def quicksort(array, left, right):
	if left < right:
		pivotvalue =array[left]
		tleft = left
		tright = right
		
		while 1:
			
			while array[tleft] <= pivotvalue and tleft < right: 
				tleft+=1
		
			while array[tright] > pivotvalue: 
				tright-=1
				
			if tleft >= tright: 
				break
			
			temp = array[tleft]
			array[tleft] = array[tright] 
			array[tright] = temp
	   
		temp = array[left]
		array[left] = array[tright] 
		array[tright] = temp
       
		quicksort( array, left, tright-1)
		quicksort( array, tright+1, right)
   

def main():
#create empty list
	array = []
#seed pseudo random number generator
	random.seed()
#populate list with random numbers
	for i in range(0, ARRAYSIZE):
		array.append(random.randint(0, 10))
	print(array)
#call quicksort
	quicksort(array, 0, ARRAYSIZE - 1)
#print sorted array
	print array
		

main()
