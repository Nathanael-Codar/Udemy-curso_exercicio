package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Program {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
//		Instanciando um cliente.
		
		Client client = new Client(name, email, birthDate);

		spaceLine();
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		
//		Forma de conseguir os dados do Status.
		
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		
		for(int i=0; i<n; ++i) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			spaceLine();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, productName);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order.toString());
		
		sc.close();
	}
	
	public static void spaceLine() {
		System.out.println();
	}

}

