import java.io.Serializable;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product implements Serializable, NameBinarySearch {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = "";
	private int pIdent = 0;
	private int inventory = 0;
	private int threshHold = 0;
	private double price = 0.00;
	private String supplier = "";
	
	
	public Product(String name, int inv, int thresh, double price, String supplier ) {
		this.name = name;
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.pIdent = n;
		this.inventory = inv;
		this.threshHold = thresh;
		this.price = price;
		this.supplier = supplier;
	}
	
	public Product() {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.pIdent = n;
		
	}
	
	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
}
	@XmlElement(name = "pIdent")
	public int getpIdent() {
		return pIdent;
	}
	
	public void setpIdent(int pIdent) {
		this.pIdent = pIdent;
}
	
	@XmlElement(name = "Inventory")
	public int getInventory() {
		return inventory;
	}
	
	public void setInventory(int inventory) {
		this.inventory = inventory;
}
	@XmlElement(name = "Threshhold")
	public int getThreshhold() {
		return threshHold;
	}
	
	public void setThreshhold(int threshhold) {
		this.threshHold = threshhold;
}
	@XmlElement(name = "Price")
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
}
	
	@XmlElement(name = "Supplier")
	public String getSupplier() {
		return supplier;
	}
	
	public void setSupplier(String supplier) {
		this.supplier = supplier;
}
	
	
	
}
