import java.util.*; 

public class RandomArrays 
{
	
	ArrayList<Integer []> list_of_arrays=new ArrayList<Integer []>(); 
	Random rng=new Random(); 
	
	public RandomArrays()
	{
		Integer [] array; 
		
		for(int x=0; x<100;x++)
		{
			array=new Integer[rng.nextInt(99)+1]; 
				
			for(int y=0;y<array.length;y++)
			{
				array[y]=rng.nextInt(100);
			}
				
			list_of_arrays.add(array); 
		}
	}
	
	public ArrayList<Integer []> getArrayList()
	{
		return list_of_arrays; 
	}

}
