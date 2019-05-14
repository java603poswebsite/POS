
import java.awt.Color;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.awt.EventQueue;
import java.awt.Font;
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

public class ReportsUI extends Gui {

	JFrame frame;
	private JTextField txtSelectReportType;
	private JTextArea reportArea;
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
		
		JPanel panel = new JPanel();
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
					printC();
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
					printR();
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
			}
		});
		
		
		JButton btnBananas = new JButton("Cashier Report");
		
		
		JPanel panel_2 = new JPanel();
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
	void printC() throws Exception {
		WriteReadDatabase w = new WriteReadDatabase();
		UserList ul = w.ReadUserList();
		List<User> users = ul.getUsers();
		RegisterList rl = w.ReadRegisterList();
		List<Register> registers = rl.getRegisters();
		String day = LocalDate.now().toString();
		String userReport = "End of Shift Report: \n";
		for (Register r : registers) {
			Path currentRelativePath = Paths.get(""); 
			String s = currentRelativePath.toAbsolutePath().toString();
			File file = new File(s+ "\\Database\\" + r.getRegId() + "\\");
			boolean exists = file.exists();
			if (exists) {
				userReport = userReport + "Date: " + day + ", Register ID: " + r.getRegId() + "\n";
				for (User u : users) {
					File userPath = new File(s+ "\\Database\\" + r.getRegId() + "\\" + day + "\\" + u.getName() +"\\" );
							boolean userExists = userPath.exists();
					if (userExists) {
						userReport = userReport + "User ID: "+u.getUserId() + ", UserName: " + u.getName() + "\n";
						UserReceiptList user = w.ReadReceiptList(r.getRegId(), day, u.getName());
						List<Receipt> userReceipts = user.getReceipts();
						for (Receipt rcpt : userReceipts)
						{
							userReport = userReport + "Receipt ID: " + rcpt.getReceiptId() + ", Items Sold: " + rcpt.getSize() +", Total Sale: " + rcpt.getTotal() + "\n";
						}
						
						
						
					}
				}
			}
		}
		
		reportArea.setText(userReport);
	}
	void printR() throws Exception {
		WriteReadDatabase w = new WriteReadDatabase();

		reportArea.setText("Register day report: " +w.ReadReceiptList(2019-05-02, null, null).getClass().getSimpleName());
	}



	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}