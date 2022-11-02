import java.util.*;

import users.*;
import items.*;

public class Main {
	
	private List<item>	itemList = new ArrayList<item>();
	private books b;
	private utilities u;
	private staff s;
	private customer c;
	private static Scanner sc = new Scanner(System.in);
	
	int inputMenu;
	int login;
	String itemType,utilType,size,staff_job, customer_id,address,staff_id,name,password;
	int amount;
	int totalBalance = 0;
	
	public Main() {
		login();
	}
	
	public void login() {
		do {
			loginPrint(); 
			login = catchs();
			if(login == 1) {
				userLogin();
				roleInfo();
				staffMenu();
			}else if (login == 2) {
				userLogin();
				roleInfo();
				customerMenu();
			}
		} while (login != 3);
	}
	
	public void userLogin() {
		do {
			System.out.print("Input Name [5 - 25 characters]: ");
			name = sc.nextLine();
		} while (name.length() < 5 || name.length() > 25);
		
		do {
			System.out.print("Input Password [5 - 25 characters]: ");
			password = sc.nextLine();
		} while (password.length() < 5 || password.length() > 25);
	}
	
	public void roleInfo() {
		if (login == 1) {
			do {
				System.out.print("Input Staff ID [5 digits]: ");
				staff_id = sc.nextLine();
			} while (staff_id.length() != 5);
			do {
				System.out.print("Input Job [Cashier | Warehouse] [Case Sensitive]: ");
				staff_job = sc.nextLine();
			} while (!staff_job.equals("Cashier") && !staff_job.equals("Warehouse"));
		
		} else if(login == 2) {
			do {
				System.out.print("Input Customer ID [5 digits]: ");
				customer_id = sc.nextLine();
			} while (customer_id.length()!= 5);
			
			do {
				System.out.print("Input Address [Less than 30 characters]: ");
				address = sc.nextLine();
			} while (address.length() > 30);
		}
	}
	
	public void staffMenu() {
		if (staff_job.equals("Cashier")) {
			do {
				printCashierMenu();
				inputMenu = catchs();
				switch (inputMenu) {	
				case 1:
					total();
					break;
				}		
			} while (inputMenu != 2);		
		
		} else if(staff_job.equals("Warehouse")) {
			do {
				printWarehouseMenu();
				inputMenu = catchs();
				switch (inputMenu) {	
				case 1: 
					inventory();
					break;
				}		
			} while (inputMenu != 2);		
			s = new staff(name, password, staff_id, staff_job);
		}
	}
	
	public void customerMenu() {
		do {
			printCustomerMenu();
			inputMenu = catchs();
			switch (inputMenu) {
			case 1:
				purchaseItems();
				break;
			case 2:
				viewItems();
				break;
			}
		} while (inputMenu != 3);	
		c = new customer(name, password, customer_id, address);
	}	
	
	public void purchaseItems() {
		do {
			System.out.print("\nWhat would you like to buy [Books | School Utilities][Case Sensitive]: ");
			itemType = sc.nextLine();
		} while (!itemType.equals("Books") && !itemType.equals("School Utilities"));
		
		if (itemType.equals("Books")) {
			do {
				System.out.print("\nWhat book size would you like [S | L][Case Insensitive]: ");
				size = sc.nextLine();
			} while (!size.equalsIgnoreCase("S") && !size.equalsIgnoreCase("L"));	
			b = new books(itemType, size);
			removeList();
			add();
			System.out.print("\nYou bought a "+size+"sized"+itemType+" for "+ b.price()
					+"\n");
							
		}else if (itemType.equals("School Utilities")){
			do {
				System.out.print("\nWhich school utility would you like [Pencil | Eraser][Case Sensitive]: ");
				utilType = sc.nextLine();
			} while (!utilType.equals("Pencil") && !utilType.equals("Eraser"));
			u = new utilities(itemType, utilType);
			removeList();
			add();
			System.out.print("\nYou bought a "+utilType+" for"+ u.price()
					+"\n");
		}
	}
	
	public void removeList() {
		int idx = 0;
		if(itemList.isEmpty()) {
			System.out.print("\nNo item found!");
		} else {			
			viewItems();
			do {
				System.out.println("\nInput the number of which item to buy![1..."+itemList.size()+"]: ");
				idx = sc.nextInt();				
				}while(idx < 1 || idx > itemList.size()); 
			
			itemList.remove(idx-1);
		}
	}
	
	public void viewItems() {
		if (itemList.size() == 0) {
			System.out.println("\nSorry! No items being sold!");
		} else {
			cusPrint();
		}
	}
	
	public void total() {	
		if (totalBalance == 0) {
			System.out.println("\nBalance is 0");
		}else {
			System.out.println("\nTotal Balance is: " + totalBalance);
		}
	}
	
	public void add() {
		int add = 0;
		if (size.equals("L")) {
			add = 5000;
		}
		if (size.equals("S")) {
			add = 2500;
		}
		if (utilType.equals("Pencil")) {
			add = 1000;
		}
		if (utilType.equals("Eraser")) {
			add = 3000;
		}
		totalBalance = totalBalance + add;	
	}
	
	public void inventory() {
		viewInventory();
		do {
			inventoryMenu();
			inputMenu = catchs();
			switch (inputMenu) {
			case 1:
				addInventory();
				break;
			case 2:
				viewInventory();
				break;
			}
		} while (inputMenu != 3);
	}

	public void addInventory() {
		do {
			System.out.print("\nWhat would you like to add [Books | School Utilities][Case Sensitive]: ");
			itemType = sc.nextLine();
		} while (!itemType.equals("Books") && !itemType.equals("School Utilities"));		
		
		do {
			System.out.print("\nHow many would you like to stock: ");
			amount = sc.nextInt();
			sc.nextLine();
		} while (amount <= 0);
		
		if (itemType.equals("Books")) {
			do {
				System.out.print("\nWhat size of books are these [S | L][Case Insensitive]: ");
				size = sc.nextLine();
			} while (!size.equalsIgnoreCase("S") && !size.equalsIgnoreCase("L"));
			books sb = new books(itemType, size);
			for (int i = 0; i < amount; i++) {
				itemList.add(sb);
			}
			System.out.print("\n"+size+" "+itemType+" has been sucessfully stocked!"
							+"\n");
			
			
		}else if (itemType.equals("School Utilities")){
			do {
				System.out.print("\nWhich school utility types are these [Pencil | Eraser][Case Sensitive]: ");
				utilType = sc.nextLine();
			} while (!utilType.equals("Pencil") && !utilType.equals("Eraser"));
			utilities su = new utilities(itemType, utilType);
			for (int i = 0; i < amount; i++) {
				itemList.add(su);
			}
			System.out.print("\n"+amount+" "+utilType+" "+itemType+" has been sucessfully stocked!"
							+"\n");
		}
	}
	
	public void viewInventory() {
		if (itemList.size() == 0) {
			System.out.println("\nItems out of stock!");
		} else {
			print();
		}
	}
	
	public void cusPrint() {
		int idx = 1;
		for(item i: itemList) {
			i.cusPrint();			
			System.out.print(" "+idx);
			System.out.println("");
			idx++;
		}
	}
	
	public void print() {
		int idx = 1;
		for(item i :itemList) {
			i.print();
			System.out.println(" ");
			idx++;
		}
	}
		
	public int catchs(){
		int a;
		try {
			a = sc. nextInt();
		} catch (Exception e) {
			a = -1;
			System.out.println("\nPlease input numbers only!");
		}
		sc.nextLine();
		return a;	
	}

	public static void main(String[] args) {
		new Main();
	}

	private void loginPrint() {
		System.out.print("\n============================================" 
				+ "\nWelcome to our cooperative shop application!"
				+ "\n============================================" 
				+ "\n"
				+ "\nWhat is your role?"
				+ "\n1. Staff"
				+ "\n2. Customer"
				+ "\n3. Cancel"
				+ "\n>>");
	}
	
	private void printCashierMenu() {
		System.out.print("\n============================================"
				+"\nWelcome to our cooperative shop application!"
				+"\n============================================"
				+"\n"
				+"\n1. Check Balance"
				+"\n2. Exit"
				+"\n>>");
	}
	
	private void printWarehouseMenu() {
		System.out.print("\n============================================"
				+"\nWelcome to our cooperative shop application!"
				+"\n============================================"
				+"\n"
				+"\n1. Inventory"
				+"\n2. Exit"
				+"\n>>");
	}
	
	private void printCustomerMenu() {
		System.out.print("\n============================================" 
						+ "\nWelcome to our cooperative shop application!"
						+ "\n============================================" 
						+ "\n" 
						+ "\n1. Purchase Items"
						+ "\n2. View Items For Sale"
						+ "\n3. Exit" 
						+ "\n>>");
	}

	private void inventoryMenu() {
		System.out.print("\nInventory Manager"
						+"\n1. Add items"
						+"\n2. View Inventory"
						+"\n3. Back"
						+">>");
	}
}
