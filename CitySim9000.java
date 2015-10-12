import java.util.Random; 


public class CitySim9000 
{
	
	public static void main(String[] args) 
	{
		/*Try catch exceptions to make sure the appropriate argument was passed through*/ 
		/*Handles no input, more than one input, and non integer input*/ 
		try
		{
			if(args.length==0)
			{
				throw new Exception("No inputs were given");
			}
			else if(args.length>1)
			{
				throw new Exception("Too many inputs were given");
			}
			else 
			{
				try
				{
					int num=Integer.parseInt(args[0]);
				}
				catch(NumberFormatException ex)
				{
					System.err.println("Error: "+'"'+args[0]+'"'+" is not an integer");
					System.exit(1);
				}
			}
		}
		catch(Exception ex)
		{
			System.err.println("Error: "+ex.getMessage());
			System.exit(1);
		}
		
		
		int seed=Integer.parseInt(args[0]);
		int iteration=0; 
		int driver=0; 

		Random rng =new Random();
		rng.setSeed(seed);
		Drive drive=new Drive(); 
		Location loc=new Location(); 
		
		while(driver<=4)
		{
			String initallocation=drive.getStart(loc,rng);
		
			System.out.print("Driver "+driver+" is heading from "+initallocation+" to ");
			String nextLocation=drive.nextLocation(initallocation,loc,rng);
			System.out.println();
			String curlocation=nextLocation; 
		
		
			while(iteration!=0 || !curlocation.equals("Outside City"))
			{
			
				System.out.print("Driver "+driver+" is heading from "+curlocation+" to ");
				nextLocation=drive.nextLocation(curlocation,loc,rng);
				System.out.println();
				curlocation=nextLocation;
				if(curlocation.equals("Outside City"))
				{
					break;
				}
				iteration++;
			}
			iteration=0;
		
			System.out.println("Driver "+driver+" has left the city!");
			System.out.println();
			driver++; 
		
		}	
		
	}

}


