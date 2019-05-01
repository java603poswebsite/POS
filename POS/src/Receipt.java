import java.util.List;
import java.util.Random;

import javax.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.*;

@XmlRootElement
public class Receipt {
	private LocalDate date = null;
	private long registerId = 0;
	private long userId = 0;
	private int receiptId = 0;
	private String receiptName = "";
	private List<Product> items;
	
	public Receipt(long regId, long userId) {
		this.registerId = regId;
		this.userId = userId;
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.receiptId = n;
		this.date = LocalDate.now();
		this.receiptName = "" + regId + date;
	}
	
	
	
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "product")
    public List<Product> getItems() {
        return items;
    }
	
	
	
}
