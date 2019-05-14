import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({ReceiptItem.class})
public class Receipt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date = null;
	private int registerId = 0;
	private int userId = 0;
	private int receiptId = 0;
	private String receiptName = "";
	private List<ReceiptItem> items = new LinkedList<ReceiptItem>();
	private int size = 0;
	private double taxRate = 0.075;
	private double Total = 0;
	private double tax = 0;
	
	public Receipt(int regId, int userId) {
		this.registerId = regId;
		this.userId = userId;
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.receiptId = n;
		this.date = LocalDate.now().toString();
		this.receiptName = "" + date +"-"+ receiptId;
	}
	
	public Receipt(int regId, int userId, double taxRate) {
		this.registerId = regId;
		this.userId = userId;
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.receiptId = n;
		this.date = LocalDate.now().toString();
		this.receiptName = "" + date +"-"+ receiptId;
		this.taxRate = taxRate;
	}
	
	public Receipt() {
		this.date = LocalDate.now().toString();
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.receiptId = n;
	}
	
	@XmlElement(name = "RegisterId")
    public void setRegisterId(int regId) {
        this.registerId = regId;
    }
	
	public int getRegisterId() {
        return this.registerId;
    }
	
	@XmlElement(name = "UserId")
    public void setUserId(int userId) {
        this.userId = userId;
    }
	
	public int getUserId() {
        return this.userId;
    }
	
	@XmlElement(name = "ReceiptId")
    public void setReceiptId(int recId) {
        this.receiptId = recId;
    }
	
	public int getReceiptId() {
        return this.receiptId;
    }
	
	@XmlElement(name = "Date")
    public void setDate(String date) {
        this.date = date;
    }
	
	public String getDate() {
        return this.date;
    }
	
	@XmlElement(name = "ReceiptName")
    public void setReceiptName(String name) {
        this.receiptName = name;
    }
	
	public String getReceiptName() {
        return this.receiptName;
    }
	
	@XmlElement(name = "Tax Rate")
    public void setTaxRate(double rate) {
        this.taxRate = rate;
    }
	
	public double getTaxRate() {
        return this.taxRate;
    }
	
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "ReceiptItems")
    public List<ReceiptItem> getItems() {
        return items;
    }
    
    public void addReceiptItem(ReceiptItem ri) {
    	this.items.add(ri);
    	amountSize(ri.getAmount());
    	amountTotal(ri.getAmount()*ri.getType().getPrice());
    	amountTax((ri.getTaxRate() * ri.getPrice() * ri.getAmount()));
    }
    
    public void addReceiptItem(Product type, int amount) {
    	ReceiptItem ri = new ReceiptItem(this, type, amount, taxRate);
    	this.items.add(ri);
    	amountSize(amount);
    	amountTotal(amount*type.getPrice());
    }
    
    public void addReceiptItem(Product type, int amount, double price, int ident) {
    	ReceiptItem ri = new ReceiptItem(this, type, amount, price, ident);
    	this.items.add(ri);
    	amountSize(amount);
    	amountTotal(amount*price);
    }

	public void removeReceiptItem(Product p) {
		// This needs to be implemented.
	}
	
	
	public ReceiptItem findProductByName(String productName) {
		ListBinarySearch<ReceiptItem> search = new ListBinarySearch<ReceiptItem>();
		ReceiptItem ri = (ReceiptItem) search.BinarySearchName(productName, 0, items.size()-1, items);
		if (ri != null)
			return ri;
		else
			return null;
	}
	
	@XmlElement(name = "Total")
    public void setTotal(double tot) {
        this.Total = tot;
    }
	
	public double getTotal() {
        return this.Total;
    }
	
	@XmlElement(name = "size")
    public void setSize(int sz) {
        this.size = sz;
    }
	
	public int getSize() {
        return this.size;
    }
	
	public void amountSize(int amount) {
        this.size+=amount;
    }
	
	public void amountTotal(double amount) {
        this.Total+=amount;
    }
	
	public void amountTax(double amount) {
        this.tax+=amount;
    }
	
	@XmlElement(name = "Tax")
    public void setTax(double tax) {
        this.tax = tax;
    }
	
	public double getTax() {
        return this.tax;
    }
	
	
}

