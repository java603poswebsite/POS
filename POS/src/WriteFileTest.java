import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.io.File;

public class WriteFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//User u = new User("Nikolai", "12345");
		//UserList ul = new UserList();
		//ul.addUser(u);
		//Register reg = new Register(1000);
		
		
		//Product pineapple = new Product("PineApple", 10, 1, 10, "Hawaii");
		//Product Strawberry = new Product("Strawberry", 10, 1, 5, "California");
		//Product CannedFood = new Product("CannedFood", 10, 1, 2.5, "Minnesota");
		
		
		//InventoryList inv = new InventoryList();
		
		//inv.addProduct(pineapple);
		//inv.addProduct(Strawberry);
		//inv.addProduct(CannedFood);
		
		//receipt.addReceiptItem(pineapple);
		//receipt.addReceiptItem(Strawberry);
		//receipt.addReceiptItem(CannedFood);
		
		//UserReceiptList receiptList = new UserReceiptList(u.getUserName(), u.getUserId(), reg.getRegId());
		//RegisterList regList = new RegisterList();
		//regList.addRegister(reg);
		
		
		WriteReadDatabase wrd = new WriteReadDatabase();
		try {
			UserList ul = wrd.ReadUserList();
			InventoryList il = wrd.ReadInventoryList();
			RegisterList rl = wrd.ReadRegisterList();
			
			//String s = "2019-05-01";
			//LocalDate date = LocalDate.parse(s);
			//UserReceiptList receiptList = new UserReceiptList("Nikolai", 480574, 396432);
			UserReceiptList receiptList = wrd.ReadReceiptList(396432, "2019-05-02", "Nikolai");
			
			
			Product p4 = new Product("Cat", 3, 1, 200, "Minnesota");
			Product p5 = new Product("Dog", 4, 1, 500, "Minnesota");
			
			il.addProduct(p4);
			il.addProduct(p5);
			
			Product p1 = il.findProductByName("PineApple");
			Product p2 = il.findProductByName("Strawberry");
			Product p3 = il.findProductByName("CannedFood");
			Product p8 = il.findProductByName("Dog");
			
			Receipt receipt = receiptList.getReceipt(899004);
			receipt.addReceiptItem(p1);
			receipt.addReceiptItem(p2);
			receipt.addReceiptItem(p3);
			
			//receiptList.addReceipt(receipt);
			
			//wrd.writeInventoryList(il);
			//wrd.writeReceipt(receiptList);
			//wrd.writeRegisterList(rl);
			//wrd.writeUserList(ul);
			//wrd.writeReceipt(receiptList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		//wrd.writeInventoryList(inv);
		//wrd.writeReceipt(receiptList);
		//wrd.writeRegisterList(regList);
		//wrd.writeUserList(ul);
		
	}

}
