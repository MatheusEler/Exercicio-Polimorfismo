import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import entities.ImportedProduct;
import entities.Product;
import entities.Usedproduct;
public class Main {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		String name;
		Double price;
		Double customsFee;
		
		SimpleDateFormat manufacture;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		List<Product> lista = new ArrayList<> ();
		
	
		System.out.println("Enter the number of products:");
		int n = in.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #"+(i)+ "data:\n");
			System.out.println("Common, used or imported (c/u/i)?");
			char resp = in.next().charAt(0);
			System.out.println("Name:");
			name = in.next();
			System.out.println("Price:");
			price = in.nextDouble();
			if(resp == 'i' || resp == 'I') {
				System.out.println("Customs Fee:");
				customsFee = in.nextDouble();
				lista.add(new ImportedProduct(name, price, customsFee));
			}if (resp == 'c' || resp == 'C'){
				lista.add(new Product(name, price));
			}if(resp == 'u' || resp == 'U') {
				
				System.out.print("Data de fabricacao (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(in.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				lista.add(new Usedproduct(name, price, date));
			}
			
			
		}
		System.out.println("\n\n");
		System.out.println("Price TAGS: \n");
		for(Product prod: lista) {
			System.out.println(prod.priceTag());
		}
		in.close();
	}

}
