package Project2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class CashRegister {
	public static double overallDiscount = 0;
	public static double totalDiscount = 0;
	static Scanner userInput = new Scanner(System.in);
	static ArrayList <DrinkItem> DrinkOrder = new ArrayList <DrinkItem>(); 
	static ArrayList <DessertItem> DessertOrder = new ArrayList <DessertItem> ();
	static ArrayList <DrinkItem> AllDrinkOrders = new ArrayList <DrinkItem>(); 
	static ArrayList <DessertItem> AllDessertOrders = new ArrayList <DessertItem> ();
	static ArrayList <String> bobaOrder = new ArrayList <String>();
	
	//below is the menu as the "correct answers"
	static ArrayList<String> bobaDrinks =  new ArrayList<String>(Arrays.asList("green-tea", "black-tea", "jasmine-green-tea", "rose-tea", "oolong-tea"));
	static ArrayList<String> Sizes =  new ArrayList<String>(Arrays.asList("S","M","L"));
	static ArrayList<String> milks =  new ArrayList<String>(Arrays.asList("whole-milk","half-and-half","almond-milk","coconut-milk", "none"));
	static ArrayList<String> coffeeMilk = new ArrayList<String>(Arrays.asList("water", "whole-milk", "almond-milk"));
	static ArrayList<String> Sweetness =  new ArrayList<String>(Arrays.asList("1","3/4", "1/2", "1/4","0"));
	static ArrayList<String> toppings =  new ArrayList<String>(Arrays.asList("boba","popping-boba","grass-jelly","lychee-jelly", "coconut-jelly","mini-mochi","none"));
	
	static ArrayList<String> pastriesArray = new ArrayList<String>(Arrays.asList("shortcrust","puff","flaky"));
	static ArrayList<String> heat = new ArrayList<String>(Arrays.asList("hot","cold"));
	
	static ArrayList<String> cookieArray = new ArrayList<String>(Arrays.asList("chocolate","choco-chip","white-choco"));
	static ArrayList<String> macaroonArray = new ArrayList<String>(Arrays.asList("strawberry","chocolate","vanilla","green-tea"));
	
	/**
	 * asks what tea drink the user would like to order
	 * @return the drink name
	 */
	public static String getDrink() {
		System.out.println("What drink would you like to order? green-tea, black-tea, jasmine-green-tea, rose-tea, oolong-tea :");
		String drink = userInput.next();
		while (bobaDrinks.contains(drink) != true) {
			System.out.println("We do not have that drink here\nWhat drink would you like to order? green-tea, black-tea, jasmine-green-tea, rose-tea, oolong-tea :");
			drink = userInput.next();
		}
		return drink;
	}
	/**
	 * asks what size the user would like the drink to be
	 * @return the size of the drink
	 */
	public static String getSize() {
		System.out.println("What size do you want? S M L ?");
		String size = userInput.next();
		while(Sizes.contains(size) != true) {
			System.out.println("We don't have that size, S M L? ");
			size = userInput.next();
		}
		return size;
	}
	/**
	 * asks what base they would like their tea to be with
	 * @return the base of the milk
	 */
	public static String getMilk() {
		System.out.println("What milk do you want to add?  whole-milk, half-and-half, almond-milk, coconut-milk or none?");
		String milk = userInput.next();
		while (milks.contains(milk)!= true) {
			System.out.println("What milk do you want to add?  whole-milk, half-and-half, almond-milk, coconut-milk or none?");
			milk = userInput.next();
		}
		return milk;
	}
	/**
	 * asks what base they would like their coffee to be with 
	 * @return the base of the milk
	 */
	public static String getCoffeeMilk() {
		System.out.println("What milk do you want to use as your base?  water, whole-milk, or almond-milk? ");
		String milk = userInput.next();
		while (coffeeMilk.contains(milk)!= true) {
			System.out.println("What milk do you want to use as your base?  water, whole-milk, or almond-milk? ");
			milk = userInput.next();
		}
		return milk;
	}
	/**
	 * asks for how sweet the user's drink to be 
	 * @return the sweetness level
	 */
	public static String getSweet() {
		System.out.println("what sweetness level do you want? 1, 3/4, 1/2, 1/4 or 0");
		String sweet = userInput.next();
		while(Sweetness.contains(sweet) != true) {
			System.out.println("what sweetness level do you want? 1, 3/4, 1/2, 1/4 or 0");
			sweet = userInput.next();
		}
		return sweet;
	}
	/**
	 * asks what toppins they would like to add to their drink
	 * @return the amount of toppings
	 */
	public static int getTopping() {
		int count = 0;
		System.out.println("What toppings do you want to add into your drink?: boba, popping-boba, grass-jelly, lychee-jelly, coconut-jelly, mini-mochi, or none?");
		String topping = userInput.next();
		if (topping.equals("none")){
			return 0;
		}
		else if(toppings.contains(topping)) {
			count += 1;
			bobaOrder.add(topping);
			System.out.println("Anymore toppings? Y/N");
		}
		else {
			System.out.println("we don't have that here");
			System.out.println("What toppings do you want to add into your drink?: boba, popping-boba, grass-jelly, lychee-jelly, coconut-jelly, mini-mochi, or none?");
			topping = userInput.next();
			System.out.println("Anymore toppings? Y/N");
		}
		char answer = userInput.next().charAt(0);
		while (answer == 'Y') {
			count += 1;
			bobaOrder.add(topping);
			System.out.println("What toppings do you want to add into your drink?: boba, popping-boba, grass-jelly, lychee-jelly, coconut-jelly, mini-mochi?");
			topping = userInput.next();
			System.out.println("Anymore toppings? Y/N");
			answer = userInput.next().charAt(0);
		}
		return count;
	}
	/**
	 * asks what pastry the user would like to order
	 * @return the name of the pastry
	 */
	public static String getPastry() {
		System.out.println("What pastry would you like to order? shortcrust, puff,or flaky :");
		String pastry = userInput.next();
		while (pastriesArray.contains(pastry) != true) {
			System.out.println("We do not have that pastry here\nWhat pastry would you like to order? shortcrust,puff,or flak :");
			pastry = userInput.next();
		}
		return pastry;
	}
	/**
	 * asks for how much of an item the user would like to order
	 * @return
	 */
	public static int getQuantity() {
		System.out.println("How many do you want? : ");
		int quantity = userInput.nextInt();
		return quantity;
	}
	/**
	 * asks if they would like their pastry to be hot or cold
	 * @return hot or cold
	 */
	public static String getHeat() {
		System.out.println("Hot or cold? Hot is 0.25 more each time");
		String heat = userInput.next();
		return heat;
	}
	/**
	 * asks the user what type of cookie they would like
	 * @return the type of cookie 
	 */
	public static String getCookie() {
		System.out.println("What cookie would you like to order? chocolate,choco-chip,white-choco, $20 for 12: ");
		String cookie = userInput.next();
		while (cookieArray.contains(cookie) == false) {
			System.out.println("We do not have that cookie here\nWhat cookie would you like to order? chocolate,choco-chip,white-choco, $20 for 12 : ");
			cookie = userInput.next();
		}
		return cookie;
	}
	/**
	 * asks the user what macaroon they would like to order
	 * @return macaroon
	 */
	public static String getMacaroon() {
		System.out.println("What macaroon would you like to order? strawberry,chocolate,vanilla,green-tea? $3.50 for 3 or 1.25 each:");
		String mac = userInput.next();
		while (macaroonArray.contains(mac) != true) {
			System.out.println("We do not have that macaroon here\nWhat macaroon would you like to order? strawberry,chocolate,vanilla,green-tea? $3.50 for 3 or 1.25 each:");
			mac = userInput.next();
		}
		return mac;
	}
	/**
	 * is the steps of constructing a tea drink
	 */
	public static void getBoba() {
		String drink = getDrink();
		String size = getSize();
		String milk = getMilk();
		String sweet = getSweet();
		int count = getTopping();
		BobaDrink bobaDrink = new BobaDrink(drink,size,milk,sweet,count,bobaOrder);
		DrinkOrder.add(bobaDrink);
		AllDrinkOrders.add(bobaDrink);
	}
	/**
	 * is the steps of constructing a coffee drink
	 */
	public static void getCoffee () {
		String size = getSize();
		System.out.println("How many teaspoon would u like to add?");
		String sweet = userInput.next();
		String base = getCoffeeMilk();
		DrinkOrder.add(new CoffeeDrink("coffee",size,sweet,base));
		AllDrinkOrders.add(new CoffeeDrink("coffee",size,sweet,base));
	}
	/**
	 * is the steps of constructing a pastry object
	 */
	public static void getPastries() {
		String pastry = getPastry();
		int quantity = getQuantity();
		String heat = getHeat();
		DessertOrder.add(new pastry(pastry,quantity,5.0,heat));
		AllDessertOrders.add(new pastry(pastry,quantity,5.0,heat));
	}
	/**
	 * is the steps of creating a cookie object
	 */
	public static void getCookies() {
		String cookie = getCookie();
		int quantity = getQuantity();
		DessertOrder.add(new cookies(cookie,quantity,20.0));
		AllDessertOrders.add(new cookies(cookie,quantity,20.0));
	}
	/**
	 * is the steps of creating a macaroon object
	 */
	public static void getMac() {
		String mac = getMacaroon();
		int quantity = getQuantity();
		DessertOrder.add(new Macaroon(mac,quantity,1.25,3.5));
		AllDessertOrders.add(new Macaroon(mac,quantity,1.25,3.5));
	}
	/**
	 * clears the arraylist of the order
	 */
	public static void clearReg() {
		DessertOrder.clear();
		DrinkOrder.clear();
	}
	/**
	 * gets the total cost of an order
	 * @return the cost of the order
	 */
	public static double getTotal() {
		double total = 0;
		for(DrinkItem i: DrinkOrder) {
			total += i.getCost();
		}
		for (DessertItem i: DessertOrder) {
			total += i.getCost();
		}
		return total;
	}
	/**
	 * gets the total cost of an order with coupons
	 * @param c coupon item type and the discount amount
	 * @return the cost of the order with the coupon included
 	 */
	public static double getTotal(Coupon c) {
		double total = 0;
		for(DrinkItem i: DrinkOrder) {
			if (i.getDrink() == c.getItem()) {
				double discount = i.getCost() * (c.getDiscount()/100);
				totalDiscount =  discount + totalDiscount;
				total += i.getCost();
			}
			else {
				total += i.getCost();	
			}
		}
		for(DessertItem i: DessertOrder) {
			if (i.getName() == c.getItem()) {
				double discount = i.getCost() * (c.getDiscount()/100) ;
				totalDiscount = discount + totalDiscount;
				total += i.getCost();
			}
			else {
				total += i.getCost();	
			}
		}
		double tax = total* 0.09;
		overallDiscount = totalDiscount + overallDiscount;
		total = total + tax - totalDiscount;
		System.out.printf("\nDiscount :-$%.2f\n", totalDiscount);
		return total;
	}
	/**
	 * counts the number of items the order has
	 * @return the number of items in an order
	 */
	public static int numItems() {
		int count = 0;
		for(DrinkItem i: AllDrinkOrders) {
			count += 1;
		}
		for(DessertItem i: AllDessertOrders) {
			count += 1;
		}
		return count;
	}
	/**
	 * print out the customer's order receipt
	 * @param discount is the discount for a certain item
	 */
	public static void printReceipt(double discount) {
		double total = 0;
		for(DrinkItem i: DrinkOrder) {
			i.display();
			
			total += i.getCost();
		}
		for(DessertItem i: DessertOrder) {
			i.display();
			total += i.getCost();
		}
		double tax = total* 0.09;
		total = total + tax;
		System.out.printf("\n\t\t\t\t\t\ttax :  %s%.2f","$",tax);
		System.out.printf("\n\t\t\t\t\t    discount: -%s%.2f","$",discount);
		System.out.printf("\n\t\t\t\t\t\tTotal: %s%.2f","$",total-discount);
		clearReg();
		bobaOrder.clear();
	}
	/**
	 * prints out all the orders 
	 */
	public static void AllReceipt() {
		double total = 0;
		for(DrinkItem i: AllDrinkOrders) {
			i.display();
			total += i.getCost();
		}
		for(DessertItem i: AllDessertOrders) {
			i.display();
			total += i.getCost();
		}
		double tax = total* 0.09;
		total = total + tax - overallDiscount;
		System.out.printf("\n\t\t\t\t\t\ttax :  %s%.2f","$",tax);
		System.out.printf("\n\t\t\t\t      Discounts total: %s%.2f","$", overallDiscount);
		System.out.printf("\n\t\t\t\t\t\tTotal: %s%.2f","$",total);
		System.out.println("\nThere was a total of " + numItems()+ " items");
	}
	/**
	 * creates an coupon 
	 * @param type is the type of coupon it is
	 * @param discount is the amount of discount
	 * @return the constructed coupon
	 */
	public static Coupon useCoupon(int type, int discount) {
		Collections.sort(DessertOrder);
		double DessertMax = 0;
		double DrinkMax = 0;
		String itemType = null;
		if (type == 1) {
			if (DrinkOrder.size() > 0) { 
				DrinkMax = DrinkOrder.get(DrinkOrder.size()-1).getCost();
				itemType = DrinkOrder.get(DrinkOrder.size()-1).getDrink();
}
		}
		else if (type == 2) {
			if (DessertOrder.size() > 0) {
				DessertMax = DessertOrder.get(DessertOrder.size()-1).getCost();
				itemType = DessertOrder.get(DessertOrder.size()-1).getName();			}
		}
		
		if (DessertMax > DrinkMax) {
			Coupon c = new Coupon(itemType, discount);
			String x = c.toString();
			System.out.println(x);
			return c;
		}
		else if (DrinkMax > DessertMax) {
			Coupon c = new Coupon(itemType, discount);
			String x = c.toString();
			System.out.println(x);
			return c;
		}
		return null;
	}
	/**
	 * prints out the menu 
	 */
	public static void menu() {
		System.out.println("Hello, what do you want to do? \n(a)Purchase a drink \n(b)Purchase pastries \n(c)Purchace cookies "
				+ "\n(d)Purchase macaroons \n(e)Finalize Sale ");
	}
	/**
	 * the steps of an order
	 */
	public static void order() {
		char input = userInput.next().charAt(0);
		while(input != 'e') {
			if (input == 'a') {
				System.out.println("1.Coffee\n2.Tea");
				int numInput = userInput.nextInt();
				if (numInput == 1) {
					getCoffee();
					menu();
					input = userInput.next().charAt(0);
				}
				else {
					getBoba();
					menu();
					input = userInput.next().charAt(0);
				}
			}
			else if (input == 'b') {
				getPastries();
				menu();
				input = userInput.next().charAt(0);
			}
			else if (input == 'c') {
				getCookies();
				menu();
				input = userInput.next().charAt(0);
			}
			else if (input == 'd') {
				getMac();
				menu();
				input = userInput.next().charAt(0);
			}
			else {
				menu();
				input = userInput.next().charAt(0);
			}
		}
		System.out.println("Do you want to use a coupon?");
		char ans = userInput.next().charAt(0);
		double total;
		Coupon c = null;
		if (ans == 'Y') {
			System.out.println("1. Drink Item \n2. Dessert Item");
			int ans1 = userInput.nextInt();
			System.out.println("Enter how much discount the coupon gives: ");
			int ans2 = userInput.nextInt();
			c = useCoupon(ans1,ans2);
			total = getTotal(c);
		}
		else {
			total = getTotal();
		}
		System.out.printf("\nTotal: %s%.2f","$",total);
		//System.out.println("Do you have a coupon?");
		System.out.println("\nEnter your payment : ");
		String payment = userInput.next();
		double x = Double.parseDouble(payment);
		while (total > x) {
			System.out.println("Not enough money Please enter it again :");
			payment = userInput.next();
			x = Double.parseDouble(payment);
		}
		System.out.printf("Your change is %s%.2f\n","$",x-total);
		System.out.println("Here is your receipt: ");
		printReceipt(totalDiscount);
		totalDiscount = 0;
	}
	public static void main(String[] args) {
		System.out.println("\n1.New sale \n2.Print all sale \n3.Close the register");
		int input = userInput.nextInt();
		while(input != 3) {
			if (input == 1) {
				menu();
				order();
				System.out.println("\n1.New sale \n2.Print all sale \n3.Close the register");;
				input = userInput.nextInt();
			}
			else if(input == 2) {
				AllReceipt();
				System.out.println("\n1.New sale \n2.Print all sale \n3.Close the register");
				input = userInput.nextInt();
			}
			else {
				break;
			}
		}
	}

}
