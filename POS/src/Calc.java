import java.util.List;

public class Calc {
	private UserReceiptList allReceipts;
	
	public Calc() {
		allReceipts = new UserReceiptList();
	}
	
	public void addSale(List<String> items, List<Integer> quantities, List<Double> prices, int registerID, int cashierID) {
		Receipt thisSale = new Receipt(registerID, cashierID);
		for(int i = 0; i < items.size(); i++) {
			Product p = new Product(items.get(i), quantities.get(i), 0, prices.get(i), null);
			thisSale.addReceiptItem(p);
		}
	}
}