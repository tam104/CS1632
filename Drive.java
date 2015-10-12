import java.util.Random; 

public class Drive 
{

	Random rng =new Random();
	
	
	public Drive()
	{
	}
	
	public Drive(int s)
	{
		rng.setSeed(s);
	}
	
	
	public String getStart(Location l,Random rng)
	{
		int num=rng.nextInt(5);
		return l.getLocation(num); 
	}

	
	public String nextLocation(String curlocation, Location l, Random rng)
	{
		int num=l.getLocation(curlocation); 
		int decision; 
		if(num==0) //If we are at the Mall
		{
			decision=rng.nextInt(2);
			if(decision==0) //Go to the Bookstore
			{
				System.out.print(l.getLocation(1)+" via "+l.getStreet(2));
				return l.getLocation(1);
			}
			if(decision==1) //Go to the Coffee Shop
			{
				System.out.print(l.getLocation(2)+" via "+l.getStreet(0));
				return l.getLocation(2);
			}
			
		}
		else if(num==1) //If we are at the Bookstore
		{
			decision=rng.nextInt(2);
			if(decision==0)//Go to the Outside City
			{
				System.out.print(l.getLocation(4)+" via "+l.getStreet(2));
				return l.getLocation(4);
			}
			if(decision==1)//Go to the University
			{
				System.out.print(l.getLocation(3)+" via "+l.getStreet(1));
				return l.getLocation(3);
			}
		}
		else if(num==2) //If we are at the Coffee Shop 
		{
			decision=rng.nextInt(2);
			if(decision==0)//Go to the Mall
			{
				System.out.print(l.getLocation(0)+" via "+l.getStreet(0));
				return l.getLocation(0);
			}
			if(decision==1)//Go to the Outside City
			{
				System.out.print(l.getLocation(4)+" via "+l.getStreet(3));
				return l.getLocation(4);
			}
			
		}
		else if(num==3) //If we are at the University 
		{
			decision=rng.nextInt(2);
			if(decision==0)//Go to the Coffee Shop
			{
				System.out.print(l.getLocation(2)+" via "+l.getStreet(3));
				return l.getLocation(2);
			}
			if(decision==1)//Go to the Bookstore
			{
				System.out.print(l.getLocation(1)+" via "+l.getStreet(1));
				return l.getLocation(1);
			}
		}
		else if (num==4) //If we are at the Outside city
		{
			decision=rng.nextInt(2);
			if(decision==0)//Go to the Mall
			{
				System.out.print(l.getLocation(0)+" via "+l.getStreet(2));
				return l.getLocation(0);
			}
			if(decision==1)//Go to the University
			{
				System.out.print(l.getLocation(3)+" via "+l.getStreet(3));
				return l.getLocation(3);
			}
		}
		return null; 
	}
}
