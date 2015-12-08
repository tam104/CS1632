import java.util.*; 

public class RentalSimulator 
{

	public static void main(String[] args) 
	{
		Menu main=new Menu(); 
		Scanner input=new Scanner(System.in); 
		int userSelection=-1; 
		System.out.println("Welcome to the Shop Simulator!");
		main.addOption("1) View Items Available");
		main.addItem(new Item("Apples",2.50));
		main.addItem(new Item("Bananas",1.50));
		main.addItem(new Item("Grapes",1.75));
		main.addItem(new Item("Watermelon",3.00));
		main.addItem(new Item("Strawberries",2.00));
		main.addOption("2) View Your Cart");
		main.addOption("3) Remove Item from Cart");
		main.addOption("4) Sort Cart Alphabeticly");
		main.addOption("5) Sort Cart by Price");
		main.addOption("6) Checkout");
		main.addOption("7) Exit");
		
		Cart cart=new Cart(); 									//Creates a new empty user cart
		
		while(userSelection!=7)									//While the user hasn't hit exit
		{
			do													//Loop to iterate until the user enters a valid number
			{
				System.out.println("Main menu");
				System.out.println("------------------");
				main.displayMenu();
				System.out.print("Please enter in an option: ");
				System.out.println();
				userSelection=input.nextInt(); 
				if(main.validOption(userSelection)==false)
				{
					System.out.println("Error: Please enter in a valid number");
				}
				
			}while(!main.validOption(userSelection));
			
			if(userSelection==1) //Shows items to be purchased
			{
				int itemSelection=-1; 
				do
				{
					System.out.println("List of Items for Purchase");
					System.out.println("---------------------------");
					main.displayItems();
					System.out.println("6) Exit");
					System.out.print("Enter the number of the item to add to cart: ");
					do
					{
						itemSelection=input.nextInt(); 
						if(itemSelection<=0 || itemSelection>6)
						{
							System.out.println("Error: Invalid Input");
							System.out.println("List of Items for Purchase");
							System.out.println("---------------------------");
							main.displayItems();
							System.out.println("6) Exit");
							System.out.print("Enter the number of the item to add to cart: ");
						}
					}while(itemSelection<=0 || itemSelection>6);
					
					if(itemSelection==6)
					{
						break;
					}
					
					cart.addItem(main.getItem(itemSelection-1));
				} while(itemSelection!=6);
				
			}
			if(userSelection==2) //Displays the cart 
			{
				System.out.println("My Cart");
				System.out.println("----------");
				cart.viewCart();
				System.out.println();
			}
			if(userSelection==3) //Remove an item from the cart with a specified string 
			{
				String s;
				System.out.println("My Cart");
				System.out.println("----------");
				cart.viewCart();
				System.out.print("Enter in the name of the item you would like to remove: ");
				s=input.next();
				cart.removeItem(s);
				
			}
			if(userSelection==4) //Sorts the cart alphabeticly 
			{
				cart.sortAlphabeticly();
			}
			if(userSelection==5) //Sorts the cart by price 
			{
				cart.sortPrice();
			}
			if(userSelection==6) //Payment page 
			{
				double totalPrice=cart.totalPrice();
				String selection; 
					
				do
				{
					String totalPriceFormatted=String.format("%.02f", totalPrice);
					System.out.println("Your total price is: $"+totalPriceFormatted); 
					System.out.println("Would you like to proceed with checking out? Y/N");
					selection=input.next(); 
					
					if(selection.equalsIgnoreCase("Y"))
					{
						System.out.println("Your order is now processing");
						System.out.println("Thank you for shopping!"); 
						cart.clearCart();
						break;
					}
					else if(selection.equalsIgnoreCase("N"))
					{
						break;
					}
					else
					{
						System.out.println("Please enter a valid input");
					}
				}while(!selection.equalsIgnoreCase("Y") || !selection.equalsIgnoreCase("N"));
				
			}
			if(userSelection==7)
			{
				System.out.println("Thank you for stopping by! Goodbye!");
			}
			
		}
				
	}

}
