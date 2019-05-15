import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainCalc {
	private UserReceiptList allSales; 		// Local record of all sales.
	private Receipt sale = null;			// A sale.
	private User user;						// Local user object
	private Register pos;					// Local register object.
	private InventoryList masterInventory; 	// Reference to the master inventory list.
	private WriteReadDatabase dbService;	// Global database services	
	private JTextArea ReceiptDisplay;
	private final double taxRate = 0.075;
	
	// Constructor
	public MainCalc(User u, Register r, JTextArea display) {
		allSales = new UserReceiptList();
		user = u;
		this.ReceiptDisplay = display;
		pos = r;
		this.dbService = new WriteReadDatabase();
		try {
			masterInventory = dbService.ReadInventoryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
	}
	
	// Method for keeping track of cash in the register.
	public void registerCash(double a) {
		pos.setAmountInRegister(pos.getAmountInRegister() + a);
	}
	
	// Method for starting a sale.
	public void startSale() {
		if(sale == null) {
			sale = new Receipt(pos.getRegId(), user.getUserId(), taxRate);
		}
	}
	
	// Method for adding individual items to a sale.
	public void addItem(Product prod, int quantity) {
		ReceiptItem ri = new ReceiptItem(sale, prod, quantity, taxRate);
		sale.addReceiptItem(ri);
		refreshDisplay();
	}
	
	// Method for removing individual items from a sale.
	public void removeItem(String item, int quantity, double price) {
		Product p = new Product(item, quantity, 0, price, null);
		sale.removeReceiptItem(p);
	}
	
	// Method for finishing a sale.
	public void finishSale() {
		
		try {
			allSales.addReceipt(sale);
			
			// Update master inventory.	
			InventoryList inv = dbService.ReadInventoryList();
			List<Product> prods = inv.getProducts();
			UserReceiptList rcptList = dbService.ReadReceiptList(pos.getRegId(), sale.getDate(), user.getName());
			List<ReceiptItem> items = sale.getItems();
			for(ReceiptItem ri : items) {
				Product DBItem = inv.findProductByName(ri.getType().getName());
				DBItem.removeInventoryAmount(ri.getAmount());
			}
			for (int i = 0; i < prods.size(); i++) {
				Product p = prods.get(i);
				if (p.getInventory() == 0) {
					inv.removeProduct(p);
					i--;
				}
			}
			
			dbService.writeInventoryList(inv);
			rcptList.addReceipt(sale);
			dbService.writeReceipt(rcptList);
			sale = null;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		dbService.writeInventoryList(masterInventory);
		try {
			RegisterList regList = dbService.ReadRegisterList();
			for(Register r : regList.getRegisters()) {
				if(r.getRegId() == pos.getRegId()) {
					r.setAmountInRegister(r.getAmountInRegister() + pos.getAmountInRegister());
					break;
				}
			}
			dbService.writeRegisterList(regList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refreshDisplay() {
		if (sale != null) {
			List<ReceiptItem> ril = sale.getItems();
			ReceiptDisplay.setText("Sale #: "+ sale.getReceiptId() + ", User #: " + user.getUserId() + "\n");
			for (ReceiptItem ri : ril) {
			ReceiptDisplay.setText(ReceiptDisplay.getText() + ri.getName() + ", qty: " + ri.getAmount() + ", $" + ri.getPrice() + " = $" + (ri.getAmount() * ri.getPrice())+"\n");
			}
			
		}
		else {
				ReceiptDisplay.setText("");
			}
	}
	
	public double getTaxRate() {
		return this.taxRate;
	}
	
}