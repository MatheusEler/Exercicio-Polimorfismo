package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Usedproduct extends Product {
	
	private LocalDate manufactureDate;
	
	

	public Usedproduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}


	@Override
	
	public String priceTag() {
		return getName()+  " (Used)" +"$ "+ getPrice()+ "(Manufacture date: "+manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +")";
	}
	

}
