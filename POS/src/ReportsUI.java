import java.io.File;
import java.io.FilenameFilter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.awt.*;  
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import java.lang.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class ReportsUI extends Login {

	JFrame frame;
	private JTextField txtSelectReportType;
	private JTextArea reportArea;
	private WriteReadDatabase w = new WriteReadDatabase();
	private JComboBox<String> RegChoice;
	private String RegChoiceOption;
	private String dayChoiceOption;
	private JPanel panel;
	private JComboBox<String> dayChoice;
	private JPanel panel_2;
	private User user;
	private Register reg;
	//private JTextArea reportArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsUI window = new ReportsUI();
					window.frame.setVisible(true);
//					ReportsUI frame = new ReportsUI();
	//				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
						
				}
			}
		});
	}

	

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ReportsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		
		
		JButton rdbtnInventoryReport = new JButton("Inventory Report");
		rdbtnInventoryReport.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		Component[] comp =panel_2.getComponents();
		    		for (int i = 0; i < comp.length; i++) {
		    			if (comp[i] == RegChoice)
		    				panel_2.remove(RegChoice);
		    			else if (comp[i] == dayChoice)
		    				panel_2.remove(dayChoice);	
		    		}
		    		panel_2.validate();
		    		panel_2.repaint();
		    		
		    		
					printI();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		JButton rdbtnCashierReport = new JButton("Cashier Report");
		rdbtnCashierReport.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		Component[] comp =panel_2.getComponents();
		    		for (int i = 0; i < comp.length; i++) {
		    			if (comp[i] == RegChoice)
		    				panel_2.remove(RegChoice);
		    			else if (comp[i] == dayChoice)
		    				panel_2.remove(dayChoice);	
		    		}
		    		panel_2.validate();
		    		panel_2.repaint();
		    		addChoicesRegistersC();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		JButton rdbtnRegisterReport = new JButton("Register Report");
		rdbtnRegisterReport.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		Component[] comp =panel_2.getComponents();
		    		for (int i = 0; i < comp.length; i++) {
		    			if (comp[i] == RegChoice)
		    				panel_2.remove(RegChoice);
		    			else if (comp[i] == dayChoice)
		    				panel_2.remove(dayChoice);
		    		}
		    		panel_2.validate();
		    		panel_2.repaint();
		    		addChoicesRegistersR();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		
		txtSelectReportType = new JTextField();
		txtSelectReportType.setText("Select Report Type");
		txtSelectReportType.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					//.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(rdbtnInventoryReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnCashierReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnRegisterReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(txtSelectReportType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					//.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						//.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
						))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					//.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					//.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						//.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSelectReportType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						//.addGap(12)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnInventoryReport)
									//.addGap(24)
									.addComponent(rdbtnCashierReport)
									//.addGap(13)
									.addComponent(rdbtnRegisterReport))
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 515, Short.MAX_VALUE)
								)
							.addContainerGap())))
		);
		
		JTextPane txtpnReceipt = new JTextPane();
		txtpnReceipt.setBackground(Color.DARK_GRAY);
		txtpnReceipt.setForeground(Color.WHITE);
		txtpnReceipt.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		panel_3.add(txtpnReceipt);
		
	
	    
		JButton btnMangos = new JButton("Inventory Report");
		btnMangos.setForeground(Color.WHITE);
		btnMangos.setBackground(Color.WHITE);
		btnMangos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Component[] comp =panel_2.getComponents();
	    		for (int i = 0; i < comp.length; i++) {
	    			if (comp[i] == RegChoice)
	    				panel_2.remove(RegChoice);
	    			else if (comp[i] == dayChoice)
	    				panel_2.remove(dayChoice);
	    		}
	    		panel_2.validate();
	    		panel_2.repaint();
			}
		});
		
		
		JButton btnBananas = new JButton("Cashier Report");
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		
		JTextPane txtpnGroceries = new JTextPane();
		txtpnGroceries.setForeground(Color.WHITE);
		txtpnGroceries.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtpnGroceries.setBackground(Color.DARK_GRAY);
		txtpnGroceries.setText("REPORTS");
		panel_2.add(txtpnGroceries);
		
		reportArea = new JTextArea();
		reportArea.setColumns(10);
		reportArea.setBorder(null);
		reportArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
	
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
				//.addGroup(gl_panel_1.createSequentialGroup()
					//.addContainerGap()
					//.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
				//		)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(reportArea, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					//.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
					//.addGap(18)
					//.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					//.addGap(63)
					)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							//.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(reportArea, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							//.addGap(78)
							//.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							//.addGap(32616)
							//.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							)
						.addGroup(gl_panel_1.createSequentialGroup()
							//.addGap(35)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
							)))
		);
		
		reportArea = new JTextArea();
		reportArea.setEditable(false);
		scrollPane_1.setViewportView(reportArea);
		reportArea.setColumns(10);
		panel_1.setLayout(gl_panel_1);
		
		JTextPane txtpnSupermart = new JTextPane();
		txtpnSupermart.setBackground(Color.DARK_GRAY);
		txtpnSupermart.setForeground(Color.WHITE);
		txtpnSupermart.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		txtpnSupermart.setText("REPORTS");
		panel.add(txtpnSupermart);
		frame.getContentPane().setLayout(groupLayout);
		
		//JMenuBar menuBar = new JMenuBar();
		//frame.setJMenuBar(menuBar);
		
		//JButton btnMainMenu = new JButton("Main Menu");
		//menuBar.add(btnMainMenu);

		//JButton btnReports = new JButton("Reports");
		//menuBar.add(btnReports);
		
		//JButton btnRegisters = new JButton("Registers");
		//menuBar.add(btnRegisters);
	}
	
	 
	void printI() throws Exception {
		reportArea.setText("");
		WriteReadDatabase w = new WriteReadDatabase();
		InventoryList inv = w.ReadInventoryList();
		String invReport = "Inventory report: \n";
		List<Product> products = inv.getProducts();
		for (Product p : products)
		{
			invReport = invReport + p.getName() + ", inventory: " + p.getInventory() + "\n";
		}
		
		reportArea.setText(invReport);
	}
	private void printR(String regId, String day) throws Exception {
		// TODO Auto-generated method stub
		reportArea.setText("");
		WriteReadDatabase w = new WriteReadDatabase();
		UserList ul = w.ReadUserList();
		List<User> users = ul.getUsers();
		double total = 0;
		double tax = 0;
		RegisterList rl = w.ReadRegisterList();
		List<Register> registers = rl.getRegisters();
		//String day = LocalDate.now().toString();
		String userReport = "End of Day Report: \n";
		for (Register r : registers) {
			Path currentRelativePath = Paths.get(""); 
			String s = currentRelativePath.toAbsolutePath().toString();
			File file = new File(s+ "\\Database\\" + regId + "\\");
			boolean exists = file.exists();
			if (exists) {
				userReport = userReport + "Date: " + day + ", Register ID: " + r.getRegId() + "\n";
				for (User u : users) {
					File userPath = new File(s+ "\\Database\\" + regId + "\\" + day + "\\" + u.getName() +"\\" );
							boolean userExists = userPath.exists();
					if (userExists) {
						double sale = 0;
						double usertax = 0;
						int amountSold = 0;
						UserReceiptList user = w.ReadReceiptList(r.getRegId(), day, u.getName());
						List<Receipt> userReceipts = user.getReceipts();
						for (Receipt rcpt : userReceipts)
						{
							amountSold += rcpt.getSize();
							usertax += rcpt.getTax();
							sale += rcpt.getTotal();
						}	
						userReport = userReport + "     UserName: " + u.getName() + ", Amount Sold: " + amountSold + ", Total Sale: " + sale + ", Tax: " + usertax+ "\n";
						total += sale;
						tax += tax;
					}
				}
			}
		}		
		userReport = userReport +"Total Sales: "+total + ", Total Tax: " + tax;
		reportArea.setText(userReport);
	}
	void printC(String regId, String day) throws Exception {
		reportArea.setText("");
		double total = 0;
		double tax = 0;
		WriteReadDatabase w = new WriteReadDatabase();
		Login g = new Login();
		UserList ul = w.ReadUserList();
		List<User> users = ul.getUsers();
		RegisterList rl = w.ReadRegisterList();
		List<Register> registers = rl.getRegisters();
		//String day = LocalDate.now().toString();
		String userReport = "End of Shift Report: \n";
			Path currentRelativePath = Paths.get(""); 
			String s = currentRelativePath.toAbsolutePath().toString();
			File file = new File(s+ "\\Database\\" + regId + "\\");
			boolean exists = file.exists();
			if (exists) {
				userReport = userReport + "Date: " + day + ", Register ID: " + regId + ", User: " +user.getName()+"\n";
					File userPath = new File(s+ "\\Database\\" + regId + "\\" + day + "\\" + user.getName() +"\\" );
							boolean userExists = userPath.exists();
					if (userExists) {
						UserReceiptList userL = w.ReadReceiptList(Integer.parseInt(regId), day, user.getName());
						List<Receipt> userReceipts = userL.getReceipts();
						for (Receipt rcpt : userReceipts)
						{
							userReport = userReport + "\n";
							userReport = userReport + "     Receipt ID: " + rcpt.getReceiptId() + ", Items Sold: " + rcpt.getSize() +", Total Sale: $" + rcpt.getTotal() +  ", Total Tax: $" + rcpt.getTax() + "\n";
							List<ReceiptItem> rcptItems = rcpt.getItems();
							for (ReceiptItem item : rcptItems) {
								userReport = userReport + "          Product: " + item.getName() + ", Amount: " + item.getAmount() + ", Price: " + item.getPrice() + "\n";
								
							}
							total += rcpt.getTotal();
							tax += rcpt.getTax();
							userReport = userReport + "\n";
						}
						userReport = userReport + "Total Sales: $" + total + ", Total Tax: $" + tax + "\n";
						
						
						
					}
			}

			reportArea.setText(userReport);
	}



	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	private void addChoicesDaysR() {
		Component[] comp =panel_2.getComponents();
		for (int i = 0; i < comp.length; i++) {
			if (comp[i] == dayChoice)
				panel_2.remove(dayChoice);	
		}
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s+"\\database\\" + RegChoiceOption + "\\");
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		
		dayChoice = new JComboBox<String>(directories);
		
		dayChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dayChoiceOption = (String) dayChoice.getSelectedItem();
				try {
					printR(RegChoiceOption, dayChoiceOption);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(dayChoice);
		panel_2.validate();
		panel_2.repaint();
	}
	
	private void addChoicesDaysC() {
		Component[] comp =panel_2.getComponents();
		for (int i = 0; i < comp.length; i++) {
			if (comp[i] == dayChoice)
				panel_2.remove(dayChoice);	
		}
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s+"\\database\\" + RegChoiceOption + "\\");
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		
		dayChoice = new JComboBox<String>(directories);
		
		dayChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dayChoiceOption = (String) dayChoice.getSelectedItem();
				try {
					printC(RegChoiceOption, dayChoiceOption);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(dayChoice);
		panel_2.validate();
		panel_2.repaint();
	}
	
	
	
	private void addChoicesRegistersR() {
		try {
			RegisterList rl = w.ReadRegisterList();
			List<Register> regList = rl.getRegisters();
			String stringRegisters[]= new String[regList.size()];  
			Register[] registers = new Register[regList.size()];
			int count = 0;
			for (Register reg : regList) {
				stringRegisters[count] = Integer.toString(reg.getRegId());
				registers[count] = reg;
				count++;
			}
			
			RegChoice = new JComboBox<String>(stringRegisters);
			
			RegChoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegChoiceOption = (String) RegChoice.getSelectedItem();
					addChoicesDaysR();
				}
			});
			panel_2.add(RegChoice);
			panel_2.validate();
			panel_2.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void addChoicesRegistersC() {
		try {
			RegisterList rl = w.ReadRegisterList();
			List<Register> regList = rl.getRegisters();
			String stringRegisters[]= new String[regList.size()];  
			Register[] registers = new Register[regList.size()];
			int count = 0;
			for (Register reg : regList) {
				stringRegisters[count] = Integer.toString(reg.getRegId());
				registers[count] = reg;
				count++;
			}
			
			RegChoice = new JComboBox<String>(stringRegisters);
			
			RegChoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegChoiceOption = (String) RegChoice.getSelectedItem();
					addChoicesDaysC();
				}
			});
			panel_2.add(RegChoice);
			panel_2.validate();
			panel_2.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void setUser(User u) {
		this.user = u;
		
	}
	
	public void setRegister(Register r) {
		this.reg = r;
	}
	
}