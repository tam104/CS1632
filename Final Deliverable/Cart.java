import java.util.*; 
import java.util.Collections;
public class Cart 
{
	ArrayList<Item> ItemList=new ArrayList<Item>(); 
	
	public Cart()
	{
	}
	//Shows the users cart
	//Order by price
	//Order Alphabeticly
	//Display Cart
	//Remove an Item
	//Add an Item 
	
	public void viewCart()
	{
		if(ItemList.size()==0)
		{
			System.out.println("No Items to display in your cart");
		}
		else
		{
			for(Item i: new LinkedHashSet<>(ItemList)) //Uses a hash set to not print out duplicate items
			{
				String formattedPrice=String.format("%.02f", i.price); //Formats the price to two decimal places
				System.out.println(i.name+" $"+formattedPrice+" x"+Collections.frequency(ItemList, i)); //Prints out the item name, price, and how many are in the cart
			}
		}
	}
	
	public int getSize()
	{
		return ItemList.size();
	}
	
	public double totalPrice()
	{
		double total=0; 
		for(int x=0;x<ItemList.size();x++)
		{
			total=total+ItemList.get(x).price;
		}
		return total; 
	}
	
	public void clearCart()
	{
		ItemList=new ArrayList<Item>(); 
	}

	public Item getItem(int i)
	{
		return ItemList.get(i);
	}
	
	public void addItem(Item i)
	{
		ItemList.add(i);
	}
	
	public void removeItem(String s)
	{
		Item i=new Item(); 				//Temporary Item holder to remove from the cart
		int found=-1; 					//Variable to keep track of the item to remove 
		for(int x=0;x<ItemList.size();x++)
		{
			if(ItemList.get(x).name.equalsIgnoreCase(s))
			{
				found=x;
				break;
			}
		}
		if(found==-1)
		{
			System.out.println("Error: Item not found");
			return;
		}
		else
		{
			i=ItemList.get(found);
			ItemList.remove(i); 
		}
		
	}
	
	public void sortAlphabeticly()
	{	
		nameComparator comparator = new nameComparator();
		Collections.sort(ItemList, comparator);
		
		viewCart();
	}
	
	public void sortPrice()
	{
		priceComparator comparator = new priceComparator();
		Collections.sort(ItemList, comparator);

		viewCart();
	}
	
	public class priceComparator implements Comparator<Item>
	{

	    public int compare(Item one, Item another)
	    {
	        int returnVal = 0;

		    if(one.getPrice() < another.getPrice())
		    {
		        returnVal =  -1;
		    }else if(one.getPrice() > another.getPrice())
		    {
		        returnVal =  1;
		    }else if(one.getPrice() == another.getPrice())
		    {
		        returnVal =  0;
		    }
		    return returnVal;

	    }
	}
	
	
	public class nameComparator implements Comparator<Item> 
	{
	    public int compare(Item obj1, Item obj2) 
	    {
	        return obj1.getName().compareTo(obj2.getName());
	    }

	}

	
	
}


