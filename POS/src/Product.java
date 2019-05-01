import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	String name = "";
	long pIdent = 0;
	long inventory = 0;
	long threshHold = 0;
	
	public Product(String name, long inv, long thresh) {
		this.name = name;
		Random rand = new Random();
		long n = rand.nextInt(1000000);
		this.pIdent = n;
		this.inventory = inv;
		this.threshHold = thresh;
	}
	
	
	
	
	
}
