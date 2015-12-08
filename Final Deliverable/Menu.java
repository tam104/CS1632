import java.util.*; 

public class Menu 
{
	ArrayList<String> options=new ArrayList<String>(); 
	ArrayList<Item> ItemList=new ArrayList<Item>(); 
	
	public Menu()
	{
		
	}
	
	public void addOption(String s)
	{
		options.add(s); 
	}
	
	
	/*Displays the entire menu to the user*/
	public void displayMenu()
	{
		for(int x=0;x<options.size();x++)
		{
			System.out.println(options.get(x));
		}
	}
	
	public int getMenuSize()
	{
		return options.size();
	}
	
	public int getItemSize()
	{
		return ItemList.size(); 
	}
	
	/*Checks to make sure the number the user entered is valid for the main menu*/ 
	public boolean validOption(int x)
	{
		if(x<=0 || x>options.size())
		{
			return false;
		}
		
		return true; 
	}
	
	/*Checks to make sure the number the user entered is a valid option for the list of items*/
	public boolean validItemOption(int x)
	{
		if(x<=0 || x>ItemList.size())
		{
			return false;
		}
		
		return true;
	}
	
	/*If the menu contains Items, add them to the Item List*/
	public void addItem(Item i)
	{
		ItemList.add(i);
	}
	
	/*Gets an item that's listed*/ 
	public Item getItem(int i)
	{
		return ItemList.get(i); 
	}
	
	/*Displays all the items available for purchase*/ 
	public void displayItems()
	{
		for(int x=0; x<ItemList.size();x++)
		{
			String formattedPrice=String.format("%.02f", ItemList.get(x).price); //Formats the price to two decimal places
			System.out.println((x+1)+") "+ItemList.get(x).name+" $"+formattedPrice);
		}
	}
}
