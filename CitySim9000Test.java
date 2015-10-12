import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import java.util.Random; 

public class CitySim9000Test {

	/*GetLocation Test when parameter is integer*/ 
	
	@Test
	//Returns the string at a specified location in the array
	//The position of the mall is at 0, so getLocation returns "Mall" when input is 0
	public void getLocation_returns_mall() 
	{
		Location l=new Location(); 
		String loc=l.getLocation(0);
		assertEquals("Mall",loc);	
	}
	
	@Test
	//Returns the string at the specified location in the array
	//The position of the Outside City is 4, so the getLocation returns "Outside City" when input is 4
	public void getLocation_returns_outsidecity()
	{
		Location l=new Location();
		String loc=l.getLocation(4);
		assertEquals("Outside City",loc);
	}
	
	@Test
	//getLocation returns null if the user enters in a number less than 0
	public void getLocation_returns_null_lessthan_zero()
	{
		Location l=new Location(); 
		String loc=l.getLocation(-1);
		assertNull(loc);
	}
	
	@Test
	//getLocation returns null if the user entes in a number greater than 4
	public void getLocation_returns_null_greaterthan_four()
	{
		Location l=new Location(); 
		String loc=l.getLocation(5);
		assertNull(loc);
	}
	
	/*GetLocation Test when parameter is String*/ 
	
	@Test
	//Returns the position of a specified string in the array
	//The String being passed through is "Mall", so getLocation returns 0 as the position
	public void getLocation_returns_zero()
	{
		Location l=new Location();
		int loc=l.getLocation("Mall");
		assertEquals(0,loc);
	}
	
	@Test
	//Returns the position of the specified string in the array
	//The String being passed through is "Outside City", so getLocation returns 4 as the position
	public void getLocation_returns_four()
	{
		Location l=new Location();
		int loc=l.getLocation("Outside City");
		assertEquals(4,loc);
	}
	
	@Test
	//Returns -1 if an invalid string is inputted
	public void get_Location_returns_negative_one()
	{
		Location l=new Location();
		int loc=l.getLocation("Invalid Location");
		assertEquals(-1,loc);
	}
	
	/*GetStreet Test when parameter is integer*/ 
	
	@Test
	//Returns the string at a specified location in the array
	//The position of Meow St is at 0, so getStreet returns "Meow St." when input is 0
	public void get_street_returns_meowst()
	{
		Location l=new Location();
		String str=l.getStreet(0);
		assertEquals("Meow St.",str);
	}
	
	@Test
	//Returns the string at a specified location in the array
	//The position of Fifth Ave is at 5, so getStreet returns "Fifth Ave." when input is 3
	public void get_street_returns_fifthave()
	{
		Location l=new Location();
		String str=l.getStreet(3);
		assertEquals("Fifth Ave.",str);
	}
	
	@Test
	//Returns null when the input is less than zero 
	public void get_street_returns_null_with_negative_input()
	{
		Location l=new Location();
		String str=l.getStreet(-1);
		assertNull(str);
		
	}
	
	@Test
	//Returns null when the input is greater than 3
	public void get_street_returns_null_greaterthan_three()
	{
		Location l=new Location();
		String str=l.getStreet(4);
		assertNull(str);
	}
	
	//*Get Start Tests*//
	
	@Test
	//Gets one of the starting locations 
	//Gets the Mall as the starting location if the RNG chooses 0 
	public void getStart_Mall()
	{
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		
		Random mockedRandom=mock(Random.class);
		when(mockedRandom.nextInt(5)).thenReturn(0);
		when(mockedLocation.getLocation(0)).thenReturn("Mall");
		
		String returnVal=d.getStart(mockedLocation,mockedRandom);
		assertEquals("Mall",returnVal);

	}
	
	@Test
	//Gets one of the starting locations
	//Gets the Outside City as the starting location if the RNG chooses 4
	public void getStart_OutsideCity()
	{
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		
		Random mockedRandom=mock(Random.class);
		when(mockedRandom.nextInt(5)).thenReturn(4);
		when(mockedLocation.getLocation(4)).thenReturn("Outside City");
		
		String returnVal=d.getStart(mockedLocation,mockedRandom);
		assertEquals("Outside City",returnVal);
	}
	
	@Test
	//If the RNG happens to calculate a number too high, then return null
	public void getStart_returnsNull()
	{
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		when(mockedRandom.nextInt(5)).thenReturn(6);
		when(mockedLocation.getLocation(6)).thenReturn(null);
		
		String returnVal=d.getStart(mockedLocation,mockedRandom);
		assertNull(returnVal);
	}

	/*NextLocation Tests*/
	
	@Test
	//If we are at the mall, then go to the bookstore
	public void nextLocation_mall_to_bookstore()
	{
		String curlocation="Mall";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(0);
		when(mockedLocation.getLocation(curlocation)).thenReturn(0);
		when(mockedLocation.getLocation(1)).thenReturn("Bookstore");
		
		
		String returnVal=d.nextLocation(curlocation,mockedLocation,mockedRandom);
		assertEquals("Bookstore",returnVal);
	}
	
	@Test
	//If we are at the mall, then go to the Coffee Shop
	public void nextLocation_mall_to_coffeeshop()
	{
		String curlocation="Coffee Shop";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(1);
		when(mockedLocation.getLocation(curlocation)).thenReturn(0);
		when(mockedLocation.getLocation(2)).thenReturn("Coffee Shop");
			
		String returnVal=d.nextLocation(curlocation,mockedLocation,mockedRandom);
		assertEquals("Coffee Shop",returnVal);
	}
	
	@Test
	//If we are at the Bookstore, then go to the Outside City
	public void nextlocation_bookstore_to_outsidecity()
	{
		String curlocation="Bookstore";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(0);
		when(mockedLocation.getLocation(curlocation)).thenReturn(1);
		when(mockedLocation.getLocation(4)).thenReturn("Outside City");
		
		String returnVal=d.nextLocation(curlocation,mockedLocation,mockedRandom);
		assertEquals("Outside City",returnVal);
	}
	
	@Test
	//If we are at the Bookstore, then go to the University
	public void nextlocation_bookstore_to_university()
	{
		String curlocation="Bookstore";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(1);
		when(mockedLocation.getLocation(curlocation)).thenReturn(1);
		when(mockedLocation.getLocation(3)).thenReturn("University");
		
		String returnVal=d.nextLocation(curlocation, mockedLocation, mockedRandom);
		assertEquals("University",returnVal);
	}
	
	@Test
	//If we are at the Coffee Shop then go to the Mall
	public void nextlocation_coffeeshop_to_mall()
	{
		String curlocation="Coffee Shop";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(0);
		when(mockedLocation.getLocation(curlocation)).thenReturn(2);
		when(mockedLocation.getLocation(0)).thenReturn("Mall");
		
		String returnVal=d.nextLocation(curlocation, mockedLocation, mockedRandom);
		assertEquals("Mall",returnVal);
		
	}
	
	@Test
	//If we are at the Coffee Shop then go to the Outside City
	public void nextLocation_coffeeshop_to_outsidecity()
	{
		String curlocation="Coffee Shop";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(1);
		when(mockedLocation.getLocation(curlocation)).thenReturn(2);
		when(mockedLocation.getLocation(4)).thenReturn("Outside City");
		
		String returnVal=d.nextLocation(curlocation, mockedLocation, mockedRandom);
		assertEquals("Outside City",returnVal);
		
	}
	
	@Test
	//If we are at the University then go to the Coffee Shop
	public void nextLocation_university_to_coffeeshop()
	{
		String curlocation="University";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(0);
		when(mockedLocation.getLocation(curlocation)).thenReturn(3);
		when(mockedLocation.getLocation(2)).thenReturn("Coffee Shop");
		
		String returnVal=d.nextLocation(curlocation, mockedLocation, mockedRandom);
		assertEquals("Coffee Shop",returnVal);
	}
	
	@Test
	//If we are at the University then go to the Bookstore
	public void nextLocation_university_to_bookstore()
	{
		String curlocation="University";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(1);
		when(mockedLocation.getLocation(curlocation)).thenReturn(3);
		when(mockedLocation.getLocation(1)).thenReturn("Bookstore");
		
		String returnVal=d.nextLocation(curlocation, mockedLocation, mockedRandom);
		assertEquals("Bookstore",returnVal);
		
	}
	
	@Test
	//If we are at the Outside City then go to the Mall
	public void nextLocation_outsidecity_to_mall()
	{
		String curlocation="Outside City";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(0);
		when(mockedLocation.getLocation(curlocation)).thenReturn(4);
		when(mockedLocation.getLocation(0)).thenReturn("Mall");
		
		String returnVal=d.nextLocation(curlocation, mockedLocation, mockedRandom);
		assertEquals("Mall",returnVal);	
	}
	
	@Test
	//If we are at the Outside City then go to the University
	public void nextLocation_outsidecity_to_university()
	{
		String curlocation="Outside City";
		Drive d=new Drive();
		Location mockedLocation=mock(Location.class);
		Random mockedRandom=mock(Random.class);
		
		when(mockedRandom.nextInt(2)).thenReturn(1);
		when(mockedLocation.getLocation(curlocation)).thenReturn(4);
		when(mockedLocation.getLocation(3)).thenReturn("University");
		
		String returnVal=d.nextLocation(curlocation, mockedLocation, mockedRandom);
		assertEquals("University",returnVal);	
	}
	
	
}
