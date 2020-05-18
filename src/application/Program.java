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
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birthdate(DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem item = new OrderItem(quantity, new Product(productName, productPrice));
			order.addItems(item);
		}
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}
}
