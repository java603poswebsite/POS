import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import java.io.Serializable;
import java.time.*;

@XmlRootElement
@XmlSeeAlso({Product.class})
public class Receipt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate date = null;
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
		this.date = LocalDate.now();
		this.receiptName = "" + regId + date;
	}
	
	public Receipt() {}
	
	@XmlElement(name = "RegisterId")
    public void setRegisterId(int regId) {
        this.registerId = regId;
    }
	
	public int getRegisterId() {
        return this.registerId;
    }
	
	
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "product")
    public List<Product> getItems() {
        return items;
    }
    
    public void addReceiptItem(Product p) {
    	this.items.add(p);
    }
	
	
	
}
