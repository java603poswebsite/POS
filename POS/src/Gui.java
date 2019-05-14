import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Gui  {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private User user;
	private Register reg;
	private WriteReadDatabase dbService = new WriteReadDatabase();
	private RegisterList regList;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Gui() {
		initialize();
	}

	
	private void initialize() {
		try {
			frame = new JFrame();
			frame.getContentPane().setBackground(Color.DARK_GRAY);
			frame.getContentPane().setForeground(Color.BLACK);
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocationRelativeTo(null); 
			
			JLabel lblUsername = new JLabel("Username ");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblSupermartLogin = new JLabel("SUPERMART LOGIN ");
			lblSupermartLogin.setForeground(Color.WHITE);
			lblSupermartLogin.setFont(new Font("Agency FB", Font.BOLD, 25));
			
			JLabel regChoiceLabel = new JLabel("Register: ");
			regChoiceLabel.setForeground(Color.WHITE);
			regChoiceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnLogin = new JButton("LOGIN");
			btnLogin.setForeground(Color.BLACK);
			btnLogin.setBackground(Color.WHITE);
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkUserPassword();
				}
			});
			
			passwordField = new JPasswordField();
			
			textField = new JTextField();
			RegisterList rl = dbService.ReadRegisterList();
			List<Register> regList = rl.getRegisters();
			String stringRegisters[]= new String[regList.size()];  
			Register[] registers = new Register[regList.size()];
			int count = 0;
			for (Register reg : regList) {
				stringRegisters[count] = Integer.toString(reg.getRegId());
				registers[count] = reg;
				count++;
			}
			
			JComboBox<String> RegChoice = new JComboBox<String>(stringRegisters);
			
			RegChoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String RegChoiceOption = (String) RegChoice.getSelectedItem();
					for (Register regist : regList) {
						if (RegChoiceOption.equals(Integer.toString(regist.getRegId()))) {
							reg = regist;
						}
					}
				}
			});
			
			textField.setColumns(10);
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(120)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(regChoiceLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(RegChoice))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblUsername)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(passwordField)))
						.addContainerGap(56, Short.MAX_VALUE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(176)
						.addComponent(btnLogin)
						.addContainerGap(179, Short.MAX_VALUE))
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(137, Short.MAX_VALUE)
						.addComponent(lblSupermartLogin, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()
						
							)
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblSupermartLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(regChoiceLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(RegChoice))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsername)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPassword)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(42)
						.addComponent(btnLogin)
						.addContainerGap(52, Short.MAX_VALUE))
			);
			frame.getContentPane().setLayout(groupLayout);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void checkUserPassword() {
		
		try {
			String uname= textField.getText();
			String pas= passwordField.getText();
			
			UserList ul = dbService.ReadUserList();
			List<User> uList = ul.getUsers();
			
			for (User u : uList) 
			{
				if (uname.equals(u.getName()) && pas.equals(u.getPW()) && reg != null)
					{ 
					user = u;
					}
			}
			if (user != null) {
				JOptionPane.showMessageDialog(frame, "you are sucessfully logged in");
				
					HomeWin home = new HomeWin ();
					home.setUser(user);
					home.setRegister(reg);
					((HomeWin) home).setVisible(true);
			}
			else if (reg == null) {
				JOptionPane.showMessageDialog(frame, "Please choose a register.");
			}
			else 
			{
				JOptionPane.showMessageDialog(frame, "Invalid username or password");
			}
			
			
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
