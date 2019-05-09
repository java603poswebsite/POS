import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User implements NameBinarySearch {
	private int userId = 0;
	private String userName = "";
	private String pw = "";
	
	
	public User() {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.userId = n;
	}
	
	
	public User(String userName, String pw) {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.userId = n;
		this.userName = userName;
		this.pw = pw;
	}
	
	
	
	@XmlElement(name = "UserID")
	public int getUserId() {
		return userId;
		
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
		
	@XmlElement(name = "UserName")
		public String getUserName() {
			return userName;
			
		}
		
		public void setUserName(String userName) {
			this.userName = userName;
		
	}
		
	@XmlElement(name = "PW")
		public String getPW() {
			return pw;
		}
		
		public void setPW(String pw) {
			this.pw = pw;
	}


		@Override
		public String getName() {
			return userName;
		}
}
