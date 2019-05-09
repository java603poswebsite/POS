import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.swing.JOptionPane;

@XmlRootElement
public class Register {
	private int regId = 0;
	private double amountInRegister = 0;
	
	public Register() {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.regId = n;
		
	};
	public Register(double startCash) {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		this.regId = n;
		this.amountInRegister = startCash;
		
	};
	public Register(int registerId, double startCash) {
		this.regId = registerId;
		this.amountInRegister = startCash;
		
	};
	
	@XmlElement(name = "RegisterId")
	public int getRegId() {
		return regId;
		
	}
	
	public void setRegId(int regId) {
		this.regId = regId;
		
	}
	
	@XmlElement(name = "amountInRegister")
	public double getAmountInRegister() {
		return amountInRegister;
		
	}
	
	public void setAmountInRegister(double amount) {
		this.amountInRegister = amount;
		
	}
	
	public void addAmountInRegister(double amount) {
		this.amountInRegister += amount;
		
	}
	
	public void subtractAmountInRegister(double amount) {
		if (amount < amountInRegister)
			this.amountInRegister -= amount;
		else {
			JOptionPane.showMessageDialog(null, "Insufficient funds in register", "INSUFFICIENT FUNDS", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
}