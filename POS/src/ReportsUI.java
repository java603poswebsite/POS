import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ReportsUI extends Gui {

	JFrame frame;
	private JTextField txtSelectReportType;
	private JTextField reportArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsUI window = new ReportsUI();
					window.frame.setVisible(true);
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
		frame.setBounds(100, 100, 1020, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		
		JRadioButton rdbtnInventoryReport = new JRadioButton("Inventory Report");
		
		JRadioButton rdbtnCashierReport = new JRadioButton("Cashier Report");
		
		JRadioButton rdbtnRegisterReport = new JRadioButton("Register Report");
		
		txtSelectReportType = new JTextField();
		txtSelectReportType.setText("Select Report Type");
		txtSelectReportType.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(rdbtnInventoryReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnCashierReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnRegisterReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(txtSelectReportType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGenerate))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSelectReportType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGap(12)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnInventoryReport)
									.addGap(24)
									.addComponent(rdbtnCashierReport)
									.addGap(13)
									.addComponent(rdbtnRegisterReport)
									.addGap(29)
									.addComponent(btnGenerate))
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 415, Short.MAX_VALUE))
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
		
		InventoryList I = new InventoryList();
		UserReceiptList U = new UserReceiptList();
		RegisterList R = new RegisterList();
		
		reportArea = new JTextField();
		reportArea.setColumns(10);
		
		if(rdbtnInventoryReport.isSelected()){
				reportArea.setText(I.getProducts());	
            }
        else if(rdbtnCashierReport.isSelected()){
        		reportArea.setText(U.getReceipts());	
        	}
        else if(rdbtnRegisterReport.isSelected()){
            reportArea.setText(R.getRegisters());
        }
       
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(reportArea, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(reportArea, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addGap(32468)
					.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JTextPane txtpnSupermart = new JTextPane();
		txtpnSupermart.setBackground(Color.DARK_GRAY);
		txtpnSupermart.setForeground(Color.WHITE);
		txtpnSupermart.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		txtpnSupermart.setText("REPORTS");
		panel.add(txtpnSupermart);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnMainMenu = new JButton("Main Menu");
		menuBar.add(btnMainMenu);
		
		JButton btnReports = new JButton("Reports");
		menuBar.add(btnReports);
		
		JButton btnRegisters = new JButton("Registers");
		menuBar.add(btnRegisters);
	}
}
