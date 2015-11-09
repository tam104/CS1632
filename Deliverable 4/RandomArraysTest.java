import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*; 

public class RandomArraysTest 
{

	@Test
	//Test sees if the sizes of the array before and after sorting are the same 
	public void arrays_keep_same_size() 
	{
		RandomArrays ra=new RandomArrays(); 
		ArrayList<Integer []> list_of_arrays=ra.getArrayList();   //Get all the randomly generated arrays (unsorted)
		
		int  unsortedSize; 									 //Holds the sizes of the unsorted Arrays
		int  sortedSize;  									 //Holds the sizes of the sorted Array
		Integer [] sortArray; 
		
		for(int x=0;x<list_of_arrays.size();x++)
		{
			unsortedSize=list_of_arrays.get(x).length;  //Gets the size of the unsorted array
			
			sortArray=list_of_arrays.get(x);			//Gets the random unsorted array  
			
			Arrays.sort(sortArray);						//Sorts the array 
			
			sortedSize=sortArray.length; 				//Gets the length of the sorted array
			
			assertEquals(unsortedSize,sortedSize); 		//Asserts the unsorted and sorted size are the same 
		}	
	}
	
	
	@Test
	//Tests to see if the arrays contain the same values 
	public void arrays_contain_same_values()
	{
		RandomArrays ra=new RandomArrays(); 
		ArrayList<Integer []> list_of_arrays=ra.getArrayList();
		Integer [] unsortedArray; 
		Integer [] sortedArray; 
				
		for(int x=0;x<list_of_arrays.size();x++)
		{
			unsortedArray=list_of_arrays.get(x);		//Gets the array Unsorted
			sortedArray=list_of_arrays.get(x); 			//Gets the array to be sorted 
			
			Arrays.sort(sortedArray);					//Sorts the Array
			
			for(int y=0;y<unsortedArray.length;y++)
			{
				assertTrue(Arrays.asList(sortedArray).contains(unsortedArray[y])); //Sees if the sorted array contains the values in the unsorted array 
			}
		}
	}
	
	@Test
	//Test to see if the last element is the largest number and the first element is the smallest number
	public void sorted_array_max_and_min_in_correct_spots()
	{
		RandomArrays ra=new RandomArrays(); 
		ArrayList<Integer []> list_of_arrays=ra.getArrayList(); 
		
		Integer first; 
		Integer last; 
		Integer [] sortedArray;
		
		for(int x=0;x<list_of_arrays.size();x++)
		{
			sortedArray=list_of_arrays.get(x); 			//Gets the unsorted array to be sorted 
			Arrays.sort(sortedArray);					//Sorts the array 
			
			List<Integer> holder=Arrays.asList(sortedArray);
			
			first=Collections.min(holder);				//Gets the minimum value 
			last=Collections.max(holder); 				//Gets the maximum value 
				
			assertTrue(sortedArray[0]==first);			//Assert that the first position is the smallest value 
			assertTrue(sortedArray[sortedArray.length-1]==last); //Assert that the last position is the largest value 
		}
	}
	
	
	

}
