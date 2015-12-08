import static org.junit.Assert.*;

import org.junit.Test;

public class RetailSimulatorTests {

	
	//Tests the validOption method of the menu class
	//Tests if it is too low returns false
	@Test
	public void menu_validOption_entry_too_low() 
	{
		Menu m=new Menu(); 
		m.addOption("Test");
		m.addOption("Test");
		m.addOption("Test");
		boolean returnVal; 
		returnVal=m.validOption(-1);
		assertFalse(returnVal); 
	}
	
	//Tests the validOption method of the menu class
	//Tests if it is too high returns false
	@Test
	public void menu_validOption_entry_too_high() 
	{
		Menu m=new Menu(); 
		m.addOption("Test");
		m.addOption("Test");
		m.addOption("Test");
		boolean returnVal; 
		returnVal=m.validOption(4);
		assertFalse(returnVal); 
	}
	
	//Tests the validOption method of the menu class
	//Tests if it is within bounds, returns true
	@Test
	public void menu_validOption_entry_within_bounds() 
	{
		Menu m=new Menu(); 
		m.addOption("Test");
		m.addOption("Test");
		m.addOption("Test");
		boolean returnVal; 
		returnVal=m.validOption(2);
		assertTrue(returnVal); 
	}
	
	//Tests the validItemOption method of the menu class
	//Tests if it is too low, returns false
	@Test
	public void menu_validItemOption_entry_too_low() 
	{
		Menu m=new Menu(); 
		m.addItem(new Item("Test",1.0));
		m.addItem(new Item("Test",2.0));
		m.addItem(new Item("Test",2.0));
		boolean returnVal; 
		returnVal=m.validItemOption(-1);
		assertFalse(returnVal); 
	}
	
	//Tests the validItemOption method of the menu class
	//Tests if it is too high, returns false
	@Test
	public void menu_validItemOption_entry_too_high()
	{
		Menu m=new Menu(); 
		m.addItem(new Item("Test",1.0));
		m.addItem(new Item("Test",2.0));
		m.addItem(new Item("Test",2.0));
		boolean returnVal; 
		returnVal=m.validItemOption(4);
		assertFalse(returnVal); 
	}
	
	//Tests the validItemOption method of the menu class
	//Tests if it is within the bounds, return true
	@Test
	public void menu_validItemOption_entry_within_bounds()
	{
		Menu m=new Menu(); 
		m.addItem(new Item("Test",1.0));
		m.addItem(new Item("Test",2.0));
		m.addItem(new Item("Test",2.0));
		boolean returnVal; 
		returnVal=m.validItemOption(2);
		assertTrue(returnVal); 
	}
	
	//Tests that the getItem method returns the item at the specified location 
	//Asserts that the original item and the one received are equal
	@Test
	public void menu_getItem_validTest() 
	{
		Item test1=new Item("Test1",2.00);
		Item test2=new Item("Test2",3.00);
		
		Menu m=new Menu(); 
		m.addItem(test1);
		m.addItem(test2);
		
		Item returnItem=m.getItem(0); //Gets the item at position 0, which should be test1
		
		assertEquals(test1,returnItem);
	}
	
	//Tests to make sure that a menu selection is being added
	//Size should be greater than the original size 
	@Test
	public void menu_addOption_valid()
	{
		Menu m=new Menu();
		int originalSize=m.getMenuSize();
		m.addOption("Test");
		int newSize=m.getMenuSize(); 
		
		assertTrue(originalSize < newSize); 
	}
	
	//Tests to make sure that a menu selection is being added
	//Size should be greater than the original size 
	@Test
	public void menu_addItem_valid()
	{
		Menu m=new Menu();
		int originalSize=m.getItemSize();
		m.addItem(new Item("Test",1.0));
		int newSize=m.getItemSize(); 
		
		assertTrue(originalSize < newSize); 
	}
	
	//Tests the getName method of the Item class
	//Returns the name associated with the item
	@Test
	public void item_getName_valid()
	{
		Item test=new Item("Test",1.0);
		String returnVal=test.getName(); 
		assertEquals("Test",returnVal);
	}
	
	//Tests the getPrice method of the Item class 
	//Returns the name associated with the item
	@Test
	public void item_getPrice_valid()
	{
		Item test=new Item("Test",1.0);
		double returnVal=test.getPrice();
		double val=1.0;

		assertEquals(val,returnVal,val);
	}
	
	//Tests to make sure that the cart becomes empty
	//Size of the cart should be 0 
	@Test
	public void cart_clearCart_valid()
	{
		Cart c=new Cart(); 
		c.addItem(new Item("Test",1.0));
		c.addItem(new Item("Test",1.0));
		
		c.clearCart();
		
		int cartSize=c.getSize(); 
		
		assertEquals(0,cartSize);
		
	}
	
	//Tests to make sure price is being added correctly
	@Test
	public void cart_totalPrice_valid()
	{
		Cart c=new Cart(); 
		c.addItem(new Item("Test",1.0));
		c.addItem(new Item("Test",1.0));
		c.addItem(new Item("Test",1.0));
		
		double expectedPrice=3.0; 
		double price=c.totalPrice(); 
		
		assertEquals(expectedPrice,price,expectedPrice); 
	}
	
	//Tests to make sure that an item is being added
	//Size should be greater than the original size 
	@Test
	public void cart_addItem_valid()
	{
		Cart c=new Cart(); 
		int originalSize=c.getSize(); 
		c.addItem(new Item("Test",1.0));
		int newSize=c.getSize(); 
		
		assertTrue(originalSize < newSize); 
	}
	
	//Tests to make sure that an item is being removed
	//Size should be less than the original size
	@Test
	public void cart_removeItem_valid()
	{
		Cart c=new Cart(); 
		c.addItem(new Item("Test",1.0));
		int originalSize=c.getSize(); 
		c.removeItem("Test");
		int newSize=c.getSize(); 
		
		assertTrue(originalSize > newSize); 
	}
	
	//Tests to try and remove an item that isn't there
	//Should do nothing
	@Test
	public void cart_removeItem_invalidEntry()
	{
		Cart c=new Cart(); 
		c.addItem(new Item("Test",1.0));
		int originalSize=c.getSize(); 
		c.removeItem("Invalid");
		int newSize=c.getSize(); 
		assertEquals(originalSize,newSize);
	}

	//Check to make sure that the cart sorts it alphabetically 
	@Test
	public void cart_sortAlphabetically ()
	{
		Cart c=new Cart();
		c.addItem(new Item("b",1.0));
		c.addItem(new Item("a",1.0));
		c.addItem(new Item("d",1.0));
		c.addItem(new Item("c",1.0));
		
		c.sortAlphabeticly();
		
		Item firstItem=c.getItem(0); 
		Item lastItem=c.getItem(3); 
		
		assertTrue(firstItem.getName().compareTo(lastItem.getName()) < 0 ); //Check the first and last element are in order 
	}
	
	//Check to make sure that the cart sorts it by price
	@Test
	public void cart_sortPrice()
	{
		Cart c=new Cart(); 
		c.addItem(new Item("b",2.0));
		c.addItem(new Item("a",1.0));
		c.addItem(new Item("d",4.0));
		c.addItem(new Item("c",3.0));
		
		c.sortPrice();
		Item firstItem=c.getItem(0);
		Item lastItem=c.getItem(3); 
		
		assertTrue(firstItem.getPrice() < lastItem.getPrice());
	}
}
