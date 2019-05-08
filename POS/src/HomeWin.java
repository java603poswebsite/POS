

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

public class HomeWin extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Container jDesktopPanel;
	private WriteReadDatabase database = new WriteReadDatabase();

	/**
	 * Launch the application.hello
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWin window = new HomeWin();
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
	public HomeWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 1020, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		dispose();
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel lblTotal = new JLabel("Total:");
		
		JButton btnCalcelOrder = new JButton("Cancel Order");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		
		JLabel lblTax = new JLabel("Tax:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		
		JLabel lblAmountReceived = new JLabel("Amount received $:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblTotalChange = new JLabel("Total change $:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnConfirmTransaction = new JButton("Confirm Transaction");
		
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
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnCalcelOrder))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAmountReceived)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTotalChange, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_5, 0, 0, Short.MAX_VALUE))
								.addComponent(btnConfirmTransaction)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
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
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblTax)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(17)
										.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
								.addGap(12)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSubtotal)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAmountReceived)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(12)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTotal)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnConfirmTransaction))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnCalcelOrder)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTotalChange)))))
					.addGap(8))
		);
		
		JTextPane txtpnReceipt = new JTextPane();
		txtpnReceipt.setBackground(Color.DARK_GRAY);
		txtpnReceipt.setForeground(Color.WHITE);
		txtpnReceipt.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpnReceipt.setText("ITEM COST - RECEIPT ");
		panel_3.add(txtpnReceipt);
		
		//JButton btnBananas = new JButton("");
		//btnBananas.setIcon(new ImageIcon("C:\\Users\\Maria Torres\\git\\POS1\\POS\\images\\bananas.jpg"));
		
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
					//.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
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
						//.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panelProductButtons = new JPanel();
		panel_1.add(panelProductButtons);
		// adding inventory buttons dynamically
				inventoryButtons(panel_1);
				
			//	JButton addProd = new JButton("Add");
			//	addProd.setBounds(450 , 700 , 100 , 30);
			//	panel_1.add(addProd);
			//	addProd.addActionListener(new ActionListener() {
				//	public void actionPerformed(ActionEvent e) {
				//		addProd(frame, panel_1);
				//	}
				//});
		
		
		JTextPane txtpnSupermart = new JTextPane();
		txtpnSupermart.setBackground(Color.DARK_GRAY);
		txtpnSupermart.setForeground(Color.WHITE);
		txtpnSupermart.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		txtpnSupermart.setText("SUPERMART");
		panel.add(txtpnSupermart);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnMainMenu = new JButton("Main Menu");
		menuBar.add(btnMainMenu);
		
		JButton btnReports = new JButton("Reports");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Reports repo = new Reports ();
				//repo.setVisible(true);
			}
		});
		menuBar.add(btnReports);
		//Reports repo = new Reports();
		//((Reports) repo).setVisible(true);
		
		JButton btnRegisters = new JButton("Registers");
		menuBar.add(btnRegisters);
	}

	public void setVisible(boolean visible) {
		
	}
	
	private void inventoryButtons(JPanel panel_1) {
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
				String name = p.getName();
				
				final JButton button = new JButton(name);
				button.setBounds(0 + 135*row , 50 + 60*col , 135 , 60);
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
                if (numberCheck(Inventory.getText()) && numberCheck(Threshhold.getText()) && numberCheck(Price.getText()) && prodName.getText().length() > 3) 
            	{
                	try {
						Product p = new Product(prodName.getText(), Integer.parseInt(Inventory.getText()), Integer.parseInt(Threshhold.getText()), Double.parseDouble(Price.getText()), Supplier.getText() );
						InventoryList invList = database.ReadInventoryList();
						//if (invList.findProductByName(p.getName()) == null && p.getName() != null) {
							invList.addProduct(p);
							database.writeInventoryList(invList);
							inventoryButtons(panel);
						//}
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
}

	

