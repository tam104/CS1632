import java.util.*; 
public class Item 
{
	String name; 
	double price; 
	
	public Item ()
	{
		
	}
	
	public Item (String n, double p) 
	{
		this.name=n; 
		this.price=p; 
	}
	
	public String getName()
	{
		return this.name; 
	}
	
	public double getPrice()
	{
		return this.price; 
	}

}
