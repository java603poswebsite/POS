import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class WriteFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product pineapple = new Product("PineApple", 10, 1, 10, "Hawaii");
		Product Strawberry = new Product("Strawberry", 10, 1, 5, "California");
		Product CannedFood = new Product("CannedFood", 10, 1, 2.5, "Minnesota");
		Receipt receipt = new Receipt(1, 1);
		
		receipt.addReceiptItem(pineapple);
		receipt.addReceiptItem(Strawberry);
		receipt.addReceiptItem(CannedFood);
		//URL urlmango = Object.class.getClass().getResource("Mango.jpg");
		//System.out.println("File Path = " + urlmango.getPath());
		
		//Path currentRelativePath = Paths.get(""); 
		//String s = currentRelativePath.toAbsolutePath().toString(); 
		//System.out.println("Current relative path is: " + s);
		
		WriteReceipt wr = new WriteReceipt();
		wr.writeReceipt(receipt);
		
	}

}
