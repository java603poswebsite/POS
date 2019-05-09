import java.io.Serializable;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReceiptItem implements Serializable, NameBinarySearch {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = "";
	private int RIIdent = 0;
	private int RecptId = 0;
	private int amount = 0;
	private int isVoid = 0;
	private double price = 0;
	private Product type;
	private Receipt recpt;
	
	
	public ReceiptItem(Receipt recpt, Product prod, int amount ) {
		this.name = prod.getName();
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.RIIdent = n;
		this.amount = amount;
		this.recpt = recpt;
		this.RecptId = recpt.getReceiptId();
		this.price = prod.getPrice();
		this.isVoid = 0;
		this.type = prod;
	}
	
	public ReceiptItem(Receipt recpt, Product prod, int amount, double price ) {
		this.name = prod.getName();
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.RIIdent = n;
		this.amount = amount;
		this.recpt = recpt;
		this.RecptId = recpt.getReceiptId();
		this.price = price;
		this.isVoid = 0;
		this.type = prod;
	}
	
	public ReceiptItem(Receipt recpt, Product prod, int amount, double price, int ident ) {
		this.name = prod.getName();
		this.RIIdent = ident;
		this.amount = amount;
		this.recpt = recpt;
		this.RecptId = recpt.getReceiptId();
		this.price = price;
		this.isVoid = 0;
		this.type = prod;
	}
	
	public ReceiptItem() {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.RIIdent = n;
		
	}
	
	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
}
	@XmlElement(name = "RIIdent")
	public int getRIIdent() {
		return RIIdent;
	}
	
	public void setRIIdent(int pIdent) {
		this.RIIdent = pIdent;
}
	
	@XmlElement(name = "Amount")
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amt) {
		this.amount = amt;
}

	public Product getType() {
		return type;
	}
	
	//public void setType(Product type) {
	//	this.type = type;
//}
	
	@XmlElement(name = "Price")
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double amt) {
		this.price = amt;
}
	
	@XmlElement(name = "isVoid")
	public int getIsVoid() {
		return isVoid;
	}
	
	public void setIsVoid(int voided) {
		this.isVoid = voided;
}
	public void voidReceiptItem () {
		this.isVoid = 1;
		double prc = this.price;
		int amt = this.amount * -1;
		this.recpt.addReceiptItem(this.type, amt, prc, this.RIIdent);
	}
	
	public void unvoidReceiptItem () {
		this.isVoid = 0;
	}
	
}
