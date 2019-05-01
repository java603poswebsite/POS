import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User {
	private int userId = 0;
	private String userName = "";
	private String password = "";
	
	@XmlElement(name = "UserID")
	public int getUserId() {
		return userId;
		
	}
	
	public void setRegId(int userId) {
		this.userId = userId;
	}
		
	@XmlElement(name = "UserName")
		public String getUserName() {
			return userName;
			
		}
		
		public void setUserName(String userName) {
			this.userName = userName;
		
	}
		
	@XmlElement(name = "PassWord")
		public String getPassWord() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
	}
}
