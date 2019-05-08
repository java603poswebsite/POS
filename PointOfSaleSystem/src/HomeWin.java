

import java.awt.EventQueue;

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
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class HomeWin extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Container jDesktopPanel;

	/**
	 * Launch the application.hello
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWin window = new HomeWin();
					window.frame.setVisible(true);
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
		frame.setBounds(100, 100, 1020, 600);
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
								.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
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
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
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
		
		JButton btnBananas = new JButton("");
		btnBananas.setIcon(new ImageIcon("C:\\Users\\Maria Torres\\git\\POS1\\POS\\images\\bananas.jpg"));
		
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
					.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(btnBananas, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
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
				
				Reports repo = new Reports ();
				repo.setVisible(true);
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
}
