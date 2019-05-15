

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainGUI extends JFrame {

	// Global Transaction Types
	public static int TRAN_ALL = 0;
	public static int TRAN_NON_RETURN = 1;
	public static int TRAN_RETURN = 2;
	
	private JFrame frame;
	private JTextField taxField;
	private JTextField subtotalField;
	private JTextField totalField;
	private JTextArea receiptBox = new JTextArea();	// Receipt text field box
	private JTextField amountReceivedField;
	private JTextField totalChangeField;
	private Container jDesktopPanel;
	private User user;
	private Register register;
	private WriteReadDatabase database = new WriteReadDatabase();
	//private Receipt receipt = new Receipt(396432, 35); // placeholder until we get real credentials in here
	private MainCalc calc = null;
	private JPanel panel_1 = new JPanel();
	
	private double tax;
	private double subTotal;
	private double total;
	private double cashReceived;
	private double cashChange;
	private int transactionType = TRAN_ALL;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Launch the application.hello
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
		this.tax = 0.0;
		this.subTotal = 0.0;
		this.subTotal = 0.0;
		this.cashReceived = 0.0;
		this.cashChange = 0.0;
	}
	
	private void homeWinReset() {
		
		// Clear text fields after finishing a sale.
		taxField.setText("");
		subtotalField.setText("");
		totalField.setText("");
		amountReceivedField.setText("");
		totalChangeField.setText("");
		receiptBox.setText("");
		
		// Reset values after finishing a sale.
		tax = 0.0;
		subTotal = 0.0;
		total = 0.0;
		cashReceived = 0.0;
		cashChange = 0.0;
		
		// Reset transaction type.
		transactionType = TRAN_ALL;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 1020, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		dispose();
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel lblTotal = new JLabel("Total:");
		
		// Cancel Order button
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.cancelSale();
				homeWinReset();
			};
		});
				
		receiptBox.setEditable(false);
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		
		JLabel lblTax = new JLabel("Tax:");
		
		// Tax text field
		taxField = new JTextField();
		taxField.setColumns(10);
		taxField.setEditable(false);
		
		// Sub-total text field
		subtotalField = new JTextField();
		subtotalField.setColumns(10);
		subtotalField.setEditable(false);
		
		// Total text field
		totalField = new JTextField();
		totalField.setColumns(10);
		totalField.setEditable(false);
		
		// Receipt text field box
		receiptBox.setLineWrap(true);
		receiptBox.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		
		JLabel lblAmountReceived = new JLabel("Amount received $:");
		
		// Amount received text field
		amountReceivedField = new JTextField();
		amountReceivedField.setColumns(10);
		amountReceivedField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashReceived = Double.parseDouble(amountReceivedField.getText());
				cashChange = cashReceived - total;
				if(cashChange < 0.0) {
					JOptionPane.showMessageDialog(frame, "Insufficient payment.");
				}
				totalChangeField.setText(df.format(cashChange));
			};
		});
		
		JLabel lblTotalChange = new JLabel("Total change $:");
		
		// Total change text field
		totalChangeField = new JTextField();
		totalChangeField.setEditable(false);
		
		// Confirm Transaction button
		JButton btnConfirmTransaction = new JButton("Confirm Transaction");
		btnConfirmTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (transactionType == TRAN_NON_RETURN) {
					if (totalChangeField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please add items and payment.");
						return;
					}
					else if (cashChange < 0.0) {
						JOptionPane.showMessageDialog(frame, "Insufficient payment.");
						return;
					}
					calc.finishSale(TRAN_NON_RETURN);	
					inventoryButtons();
					homeWinReset();		
					JOptionPane.showMessageDialog(frame, "Sale complete.");
				}
				else if (transactionType == TRAN_RETURN) {
					try {
						InventoryList invList = database.ReadInventoryList();
						for (ReceiptItem itm : calc.getSale().getItems()) {
							Product invP = invList.findProductByName(itm.getName());
							invP.addInventoryAmount(itm.getAmount());
							database.writeInventoryList(invList);
							inventoryButtons();						
						}	
						calc.finishSale(TRAN_RETURN);						
						homeWinReset();		
						JOptionPane.showMessageDialog(frame, "Return complete.");
					}
					catch (Exception e) {
						
					}
				}
			}
		});
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTax, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblSubtotal, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(totalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(taxField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(subtotalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnCancelOrder))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAmountReceived)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(amountReceivedField, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTotalChange, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(totalChangeField, 0, 0, Short.MAX_VALUE))
								.addComponent(btnConfirmTransaction)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(receiptBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(receiptBox, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblTax)
											.addComponent(taxField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(17)
										.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
								.addGap(12)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSubtotal)
									.addComponent(subtotalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAmountReceived)
									.addComponent(amountReceivedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(12)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTotal)
									.addComponent(totalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTotalChange)
									.addComponent(totalChangeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnCancelOrder)
									.addComponent(btnConfirmTransaction))
									)))
					.addGap(8))
		);
		
		JTextPane txtpnReceipt = new JTextPane();
		txtpnReceipt.setBackground(Color.DARK_GRAY);
		txtpnReceipt.setForeground(Color.WHITE);
		txtpnReceipt.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpnReceipt.setText("ITEM COST - RECEIPT ");
		panel_3.add(txtpnReceipt);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		
		JTextPane txtpnGroceries = new JTextPane();
		txtpnGroceries.setForeground(Color.WHITE);
		txtpnGroceries.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtpnGroceries.setBackground(Color.DARK_GRAY);
		txtpnGroceries.setText("GROCERIES");
		panel_2.add(txtpnGroceries);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
					.addGap(16))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panelProductButtons = new JPanel();
		panel_1.add(panelProductButtons);
		// adding inventory buttons dynamically
				inventoryButtons();
				
		
		JTextPane txtpnSupermart = new JTextPane();
		txtpnSupermart.setBackground(Color.DARK_GRAY);
		txtpnSupermart.setForeground(Color.WHITE);
		txtpnSupermart.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		txtpnSupermart.setText("SUPERMART");
		panel.add(txtpnSupermart);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//JButton btnMainMenu = new JButton("Main Menu");
		//menuBar.add(btnMainMenu);
		
		JButton btnReports = new JButton("Reports");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setLocationRelativeTo(null);
				ReportsUI repo = new ReportsUI ();
				repo.setUser(user);
				repo.setRegister(register);
				repo.frame.setVisible(true);
			}
		});
		menuBar.add(btnReports);
		
		
		//JButton btnRegisters = new JButton("Registers");
		//menuBar.add(btnRegisters);
	}

	public void setVisible(boolean visible) {
		
	}
	
	private void inventoryButtons() {
		try {
			InventoryList inv = database.ReadInventoryList();
			List<Product> prod = inv.getProducts();
			panel_1.removeAll();
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.DARK_GRAY);
			
			JTextPane txtpnGroceries = new JTextPane();
			txtpnGroceries.setForeground(Color.WHITE);
			txtpnGroceries.setFont(new Font("Tahoma", Font.BOLD, 19));
			txtpnGroceries.setBackground(Color.DARK_GRAY);
			txtpnGroceries.setText("GROCERIES");
			panel_2.add(txtpnGroceries);
			
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGap(16))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							
								)
						.addContainerGap())
			);
			panel_1.setLayout(gl_panel_1);
			JButton addProd = new JButton("Add");
			addProd.setBounds(450 , 500 , 100 , 30);
			panel_1.add(addProd);
			addProd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addProd(frame, panel_1);
				}
			});
			
			int row = 0;
			int col = 0;
			for (Product p : prod) {
				String name = p.getName() + " ("+p.getInventory() + ")";
				
				final JButton button = new JButton(name);
				if (p.getInventory() <= p.getThreshhold())
					button.setBackground(Color.pink);
				
				// Receipt dialogue window buttons
				button.setBounds(0 + 135*row , 50 + 60*col , 135 , 60);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JDialog dlgReceipt = new JDialog(frame, "Add/Remove Item(s)", true);	// Receipt dialogue window
						dlgReceipt.setLayout( new FlowLayout(FlowLayout.LEADING) );  
				        JButton btnAdd = new JButton ("Add");									// Add Button
				        JButton btnRemove = new JButton ("Remove");								// Remove Button
				        JButton btnReturn = new JButton ("Return");								// Return Button
				        JButton btnRestock = new JButton ("Restock");							// Re-stock Button
				        dlgReceipt.add( new JLabel ("Amount:"));  
				        JTextField amount = new JTextField();
				        amount.setColumns(10);		
				        
				        // Event handler for MainCalc actions
				        
				        // Add Action
				        btnAdd.addActionListener(new ActionListener() {	
							public void actionPerformed(ActionEvent e) {
								if (transactionType == TRAN_ALL) {
									transactionType = TRAN_NON_RETURN;								
								}
								if (transactionType != TRAN_NON_RETURN) {
									JOptionPane.showMessageDialog(frame, "Please start a separate sale transaction.");
									return;
								}
								if (numberCheck(amount.getText())) {
									try {
										if (Integer.parseInt(amount.getText()) <= p.getInventory()) {
											if (calc == null)
												calc = new MainCalc(user, register, receiptBox);
										calc.startSale();
										calc.addItem(p, Integer.parseInt(amount.getText()));
										dlgReceipt.setVisible(false);
										
										int quantity = Integer.parseInt(amount.getText());
										tax += calc.getTaxRate() * p.getPrice() * quantity;
										subTotal += p.getPrice() * quantity;
										total = tax + subTotal;
						
										taxField.setText(df.format(tax));
										subtotalField.setText(df.format(subTotal));
										totalField.setText(df.format(total));
										}
										else {
											JOptionPane.showMessageDialog(frame, "Not Enough Inventory.");
										}
									} 
									catch (NumberFormatException e1) {
										e1.printStackTrace();
									}
								}
							};
						});
				        
				        // Remove Action
				        btnRemove.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (transactionType == TRAN_ALL) {
									transactionType = TRAN_NON_RETURN;								
								}
								if (transactionType != TRAN_NON_RETURN) {
									JOptionPane.showMessageDialog(frame, "Please start a separate sale transaction.");
									return;
								}
								if (numberCheck(amount.getText())) {
									try {
										if (Integer.parseInt(amount.getText()) <= p.getInventory()) {
											if (calc == null)
												calc = new MainCalc(user, register, receiptBox);
										
											if (calc.getSale() == null) {
												JOptionPane.showMessageDialog(frame, "There is nothing to remove from this sale.");
												return;
											}
											int currentAmount = 0;
											for (ReceiptItem itm : calc.getSale().getItems()) {
												if (p.getName().equals(itm.getName())) {
													currentAmount += itm.getAmount();
												}										
											}
											if (currentAmount < Integer.parseInt(amount.getText())) {
												JOptionPane.showMessageDialog(frame, "Not enough quantity to remove for this item.");
												return;
											}
										
											calc.startSale();
											calc.addItem(p, -Integer.parseInt(amount.getText()));
											dlgReceipt.setVisible(false);
											
											int quantity = Integer.parseInt(amount.getText());
											tax -= calc.getTaxRate() * p.getPrice() * quantity;
											subTotal -= p.getPrice() * quantity;
											total = tax + subTotal;
							
											taxField.setText(df.format(tax));
											subtotalField.setText(df.format(subTotal));
											totalField.setText(df.format(total));
										}
										else {
											JOptionPane.showMessageDialog(frame, "Not Enough Inventory.");
										}
									} 
									catch (NumberFormatException e1) {
										e1.printStackTrace();
									}
								}
							};
						});
				        
				     // Return Action
				        btnReturn.addActionListener(new ActionListener() {				     
							public void actionPerformed(ActionEvent e) {
								if (transactionType == TRAN_ALL) {
									transactionType = TRAN_RETURN;								
								}
								if (transactionType != TRAN_RETURN) {
									JOptionPane.showMessageDialog(frame, "Please start a separate return transaction.");
									return;
								}
								if (numberCheck(amount.getText())) {
									try {										
										if (calc == null) {
											calc = new MainCalc(user, register, receiptBox);
										}
										calc.startSale();
										calc.addItem(p, Integer.parseInt(amount.getText()));
										dlgReceipt.setVisible(false);
										
										int quantity = Integer.parseInt(amount.getText());
										tax += calc.getTaxRate() * p.getPrice() * quantity;
										subTotal += p.getPrice() * quantity;
										total = tax + subTotal;
						
										taxField.setText(df.format(tax));
										subtotalField.setText(df.format(subTotal));
										totalField.setText(df.format(total));									
									} 
									catch (NumberFormatException e1) {
										e1.printStackTrace();
									}
								}
							};
						});
				        
				        // Re-stock Action
				        btnRestock.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (numberCheck(amount.getText())) {
									try {
										InventoryList invList = database.ReadInventoryList();
										Product invP = invList.findProductByName(p.getName());
										if ( invP != null) {
											invP.addInventoryAmount(Integer.parseInt(amount.getText()));;
											database.writeInventoryList(invList);
											inventoryButtons();
											dlgReceipt.setVisible(false);
										}
									} 
									catch (NumberFormatException e1) {
										e1.printStackTrace();
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								}
							};
						});
				        
				        dlgReceipt.add(amount);
				        dlgReceipt.add(btnAdd);
				        dlgReceipt.add(btnRemove);
				        dlgReceipt.add(btnReturn);
				        dlgReceipt.add(btnRestock);
				        dlgReceipt.setSize(180,130);    
				        dlgReceipt.setLocationRelativeTo(panel_1);
				        dlgReceipt.pack();
				        dlgReceipt.setVisible(true);
					};
				});
				panel_1.add(button);
				row++;
				if (row >= 4) {
					col++;
					row = 0;
				}
			}
			panel_1.revalidate();
			panel_1.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addProd(JFrame frame, JPanel panel) {
		JDialog d = new JDialog(frame, "Add Product", true);
		d.setLayout( new FlowLayout(FlowLayout.LEADING) );  
        JButton b = new JButton ("Add");  
        d.add( new JLabel ("Product name:"));  
        JTextField prodName = new JTextField();
        prodName.setColumns(10);
        d.add(prodName);
        d.add( new JLabel ("Inventory:"));  
        JTextField Inventory = new JTextField();
        Inventory.setColumns(10);
        d.add(Inventory);
        d.add( new JLabel ("Threshhold:"));  
        JTextField Threshhold = new JTextField();
        Threshhold.setColumns(10);
        d.add(Threshhold);
        d.add( new JLabel ("Price:"));  
        JTextField Price = new JTextField();
        Price.setColumns(10);
        d.add(Price);
        d.add( new JLabel ("Supplier:"));  
        JTextField Supplier = new JTextField();
        Supplier.setColumns(10);
        d.add(Supplier);
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                if (numberCheck(Inventory.getText()) && numberCheck(Threshhold.getText()) && numberCheck(Price.getText()) && prodName.getText().length() >= 3) 
            	{
                	try {
						Product p = new Product(prodName.getText(), Integer.parseInt(Inventory.getText()), Integer.parseInt(Threshhold.getText()), Double.parseDouble(Price.getText()), Supplier.getText() );
						InventoryList invList = database.ReadInventoryList();
						if (invList.findProductByName(p.getName()) == null && p.getName() != null) {
							invList.addProduct(p);
							database.writeInventoryList(invList);
							inventoryButtons();
						}
					d.setVisible(false);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
                }

                
            }  
        });  
        d.add(b);   
        d.setSize(150,300);    
        d.setLocationRelativeTo(panel);
        d.setVisible(true);  
        
        
        
	}
	
	public boolean numberCheck(String input){
		  final String Digits = "(\\p{Digit}+)";
		  final String HexDigits = "(\\p{XDigit}+)";
		  // an exponent is 'e' or 'E' followed by an optionally
		  // signed decimal integer.
		  final String Exp = "[eE][+-]?" + Digits;
		  final String fpRegex =
		          ("[\\x00-\\x20]*" +  // Optional leading "whitespace"
		                  "[+-]?(" + // Optional sign character
		                  "NaN|" +           // "NaN" string
		                  "Infinity|" +      // "Infinity" string

		                  // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		                  "(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" +

		                  // . Digits ExponentPart_opt FloatTypeSuffix_opt
		                  "(\\.(" + Digits + ")(" + Exp + ")?)|" +

		                  // Hexadecimal strings
		                  "((" +
		                  // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		                  "(0[xX]" + HexDigits + "(\\.)?)|" +

		                  // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		                  "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		                  ")[pP][+-]?" + Digits + "))" +
		                  "[fFdD]?))" +
		                  "[\\x00-\\x20]*");// Optional trailing "whitespace"

		  return Pattern.matches(fpRegex, input);
}
	
	public void setUser(User u) {
		this.user = u;
		
	}
	
	public void setRegister(Register r) {
		this.register = r;
	}
	
}

	
