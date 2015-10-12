
public class Location 
{
	String[] location={"Mall","Bookstore","Coffee Shop","University","Outside City"};
	String[] street={"Meow St.","Chirp St.","Fourth Ave.","Fifth Ave."};
	
	public Location()
	{
	}
	public String getLocation(int num)
	{
		if(num<0 || num>4)
		{
			return null; 
		}
		return location[num]; 
	}
	public int getLocation(String curlocation)
	{
		int x=0; 
		while(!curlocation.equals(location[x]))
		{
			x++;
			
			if(x>4)
			{
				break;
			}
		}
		if(x>4)
		{
			return -1; 
		}
		return x; 
	}
	
	public String getStreet(int num)
	{
		if(num<0 || num>3)
		{
			return null; 
		}
		return street[num];
	}

}
