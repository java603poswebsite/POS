public class Calc {
	private UserReceiptList allSales; 		// Record of all sales.
	private InventoryList masterInventory; 	// Reference to the master inventory list.
	private Receipt sale = null;			// A sale.			
	
	// Inject the master inventory list to the local register.
	public Calc(InventoryList invList) {
		allSales = new UserReceiptList();
		masterInventory = invList;
	}
	
	// Method for starting a sale.
	public void startSale(int registerID, int cashierID) {
		if(sale == null) {
			sale = new Receipt(registerID, cashierID);
		}
	}
	
	// Method for adding individual items to a sale.
	public void addItem(String item, int quantity, double price) {
		Product p = new Product(item, quantity, 0, price, null);
		sale.addReceiptItem(p);
	}
	
	// Method for removing individual items from a sale.
	public void removeItem(String item, int quantity, double price) {
		Product p = new Product(item, quantity, 0, price, null);
		sale.removeReceiptItem(p);
	}
	
	// Method for finishing a sale.
	public void finishSale() {
		allSales.addReceipt(sale);
		
		// Update master inventory.	
		for(Product p : sale.getItems()) {
			masterInventory.removeProduct(p);
		}
		sale = null;
	}
	
	// Method for returning individual items.
	public void returnItem(String item, int quantity, double price) {
		Product p = new Product(item, quantity, 0, price, null);
		masterInventory.addProduct(p);
	}
	
	// Method for canceling a sale.
	public void cancelSale() {
		sale = null;
	}
}