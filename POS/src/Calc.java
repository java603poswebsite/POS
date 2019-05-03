import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Calc {
	private UserReceiptList allSales; // Record of all sales (lists that include items, register, cashier, etc.)
	
	public Calc() {
		allSales = new UserReceiptList();
	}
	
	public void addSale(List<String> items, List<Integer> quantities, List<Double> prices, int registerID, int cashierID) {
		Receipt thisSale = new Receipt(registerID, cashierID);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		thisSale.setDate(dateFormat.format(date));
		
		for(int i = 0; i < items.size(); i++) {
			Product p = new Product(items.get(i), quantities.get(i), 0, prices.get(i), null);
			thisSale.addReceiptItem(p);
		}
		allSales.addReceipt(thisSale);
	}
}