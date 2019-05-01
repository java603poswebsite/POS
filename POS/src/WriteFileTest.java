
public class WriteFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product pineapple = new Product("PineApple", 10, 1);
		Product Strawberry = new Product("Strawberry", 10, 1);
		Product CannedFood = new Product("CannedFood", 10, 1);
		Receipt receipt = new Receipt(1, 1);
		
		receipt.addReceiptItem(pineapple);
		receipt.addReceiptItem(Strawberry);
		receipt.addReceiptItem(CannedFood);
		
		ReadWriteXML<Receipt> xml = new ReadWriteXML<Receipt>();
		
		try {
			xml.receiptToXML("Firstreceipt.xml", receipt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
