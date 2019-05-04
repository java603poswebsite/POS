import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Product.class})
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
	private List<Product> items = new LinkedList<Product>();
	
	public Receipt(int regId, int userId) {
		this.registerId = regId;
		this.userId = userId;
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.receiptId = n;
		this.date = LocalDate.now().toString();
		this.receiptName = "" + date +"-"+ receiptId;
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
	
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "product")
    public List<Product> getItems() {
        return items;
    }
    
    public void addReceiptItem(Product p) {
    	this.items.add(p);
    }

	public void removeReceiptItem(Product p) {
		// This needs to be implemented.
	}
	
	
	
}
