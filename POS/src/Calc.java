public class Calc {
	private UserReceiptList allSales; 		// Local record of all sales.
	private Receipt sale = null;			// A sale.
	private User user;						// Local user object
	private Register pos;					// Local register object.
	private InventoryList masterInventory; 	// Reference to the master inventory list.
	private WriteReadDatabase dbService;	// Global database services			
	
	// Constructor
	public Calc(User u, Register r, InventoryList mI, WriteReadDatabase dbS) {
		allSales = new UserReceiptList();
		user = u;
		pos = r;
		masterInventory = mI;
		this.dbService = dbS;
	}
	
	// Method for starting a sale.
	public void startSale() {
		if(sale == null) {
			sale = new Receipt(pos.getRegId(), user.getUserId());
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
	
	// Method for finishing a shift.
	public void finishShift() {
		dbService.writeReceipt(allSales);
	}
}