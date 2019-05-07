import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Receipt.class})
public class UserReceiptList {
	private List<Receipt> userReceipts = new LinkedList<Receipt>();
	private String date;
	private String userName = "";
	private int userId = 0;
	private int registerId = 0;
	
	public UserReceiptList() {
		this.date = LocalDate.now().toString();
	}
	
	public UserReceiptList(String userName, int userId, int registerId) {
		this.date = LocalDate.now().toString();
		this.userName = userName;
		this.userId = userId;
		this.registerId = registerId;
	}
	
	
	@XmlElementWrapper(name = "Receipts")
    @XmlElement(name = "Receipt")
    public String getReceipts() {
        return userReceipts.toString();
    }
	 public List<Receipt> getReceipt() {
	        return userReceipts;
	    }
	
	public void addReceipt(Receipt r) {
		if (!userReceipts.contains(r)) {
			userReceipts.add(r);
		}
	}
	
	@XmlElement(name = "UserName")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
	@XmlElement(name = "UserID")
	public int getUserId() {
		return userId;
		}
		
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@XmlElement(name = "registerId")
	public int getRegisterId() {
		return registerId;
		}
		
	public void setRegisterId(int regId) {
		this.registerId = regId;
	}
	
	@XmlElement(name = "Date")
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
}
	public Receipt getReceipt(int receiptID) {
		for (Receipt r : userReceipts ) {
			if (r.getReceiptId() == receiptID) {
				return r;
			}
		}
		return null;
		
	}
	
}
