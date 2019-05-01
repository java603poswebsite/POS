import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Register {
	private int regId = 0;
	
	public Register() {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.regId = n;
		
	};
	
	
	@XmlElement(name = "RegisterId")
	public int getRegId() {
		return regId;
		
	}
	
	public void setRegId(int regId) {
		this.regId = regId;
		
	}
	
}
