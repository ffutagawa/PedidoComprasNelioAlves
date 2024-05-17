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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Entre com o CLiente");
		
		System.out.print("Nome: ");
		String name = sc.nextLine();
		
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		
		System.out.print("Data de nascimento (DD/MM/AAAA): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Entre com os dados do pedido");
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);
		
		System.out.println("Quantos itens o pedido vai ter? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Entre com o " + i + "º pedido:");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			
			System.out.print("Preço do produto: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem item = new OrderItem(quantity, productPrice, product);
			
			order.addItem(item);
		}

		System.out.println();
		System.out.print(order);
		
		sc.close();
	}

}
