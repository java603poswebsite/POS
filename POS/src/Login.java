import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class Login  {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private User user;
	private Register reg;
	private WriteReadDatabase dbService = new WriteReadDatabase();
	private RegisterList regList;
	private JPanel panel = new JPanel();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setResizable(false);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		initialize();
	}

	
	private void initialize() {
		try {
			frame = new JFrame();
			panel.setBackground(Color.DARK_GRAY);
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
			JButton newUser = new JButton("New User?");
			newUser.setForeground(Color.BLACK);
			newUser.setBackground(Color.WHITE);
			newUser.setFont(new Font("Tahoma", Font.BOLD, 14));
			newUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newUser();
				}
			});
			textField.setColumns(10);
			GroupLayout groupLayout = new GroupLayout(panel);
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
						.addComponent(newUser)
						.addContainerGap(179, Short.MAX_VALUE)
						)
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
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLogin)
							.addComponent(newUser))
						.addContainerGap(52, Short.MAX_VALUE)
						
							)
			);
			panel.setLayout(groupLayout);
			frame.add(panel);
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
				
					MainGUI home = new MainGUI ();
					home.setUser(user);
					home.setRegister(reg);
					((MainGUI) home).setVisible(true);
					frame.dispose();
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

	public void setuName(String uname)
	{
	    uname= textField.getText();
	}

	public String getuName()
	{
	    return textField.getText();
	}

	private void newUser() {
		try {
			panel.removeAll();
			JLabel lblUsername = new JLabel("Username ");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblPw = new JLabel("Password ");
			lblPw.setForeground(Color.WHITE);
			lblPw.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblPw2 = new JLabel("Password again ");
			lblPw2.setForeground(Color.WHITE);
			lblPw2.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblSupermartLogin = new JLabel("SUPERMART LOGIN ");
			lblSupermartLogin.setForeground(Color.WHITE);
			lblSupermartLogin.setFont(new Font("Agency FB", Font.BOLD, 25));
			
			JPasswordField pw = new JPasswordField();
			JPasswordField newpw = new JPasswordField();
			
			textField = new JTextField();
			textField.setColumns(20);
			
			JButton btnConfirm = new JButton("Okay");
			btnConfirm.setForeground(Color.BLACK);
			btnConfirm.setBackground(Color.WHITE);
			btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String uname= textField.getText();
					String pas= pw.getText();
					String newpas= newpw.getText();
					if (uname != null && pas != null && pas.equals(newpas)) {
						try {
							UserList ul = dbService.ReadUserList();
							User preExistingUser = ul.findUserByName(uname);
							if (preExistingUser == null) {
								User newUser = new User(uname, pas);
								ul.addUser(newUser);
								dbService.writeUserList(ul);
								back();
							}
							else if (preExistingUser.getName() == uname) {
								JOptionPane.showMessageDialog(frame, "UserName already exists.");
							}
							else if (!pas.equals(newpas)) {
								JOptionPane.showMessageDialog(frame, "Passwords don't match.");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
			JButton btnBack = new JButton("Back");
			btnBack.setForeground(Color.BLACK);
			btnBack.setBackground(Color.WHITE);
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					back();
				}
			});
			
			GroupLayout groupLayout = new GroupLayout(panel);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(120)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblUsername)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPw, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(pw))
							.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPw2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(newpw))
							)
						.addContainerGap(56, Short.MAX_VALUE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(176)
						.addComponent(btnBack)
						.addComponent(btnConfirm)
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
							.addComponent(lblUsername)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPw, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(pw))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPw2)
							.addComponent(newpw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(42)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirm)
						.addComponent(btnBack))
						.addContainerGap(52, Short.MAX_VALUE)
						
						)
			);
			panel.setLayout(groupLayout);
			panel.validate();
			panel.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void back() {
		try {
			panel.removeAll();
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
			JButton newUser = new JButton("New User?");
			newUser.setForeground(Color.BLACK);
			newUser.setBackground(Color.WHITE);
			newUser.setFont(new Font("Tahoma", Font.BOLD, 14));
			newUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newUser();
				}
			});
			textField.setColumns(10);
			GroupLayout groupLayout = new GroupLayout(panel);
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
						.addComponent(newUser)
						.addContainerGap(179, Short.MAX_VALUE)
						)
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
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLogin)
							.addComponent(newUser))
						.addContainerGap(52, Short.MAX_VALUE)
						
							)
			);
			panel.setLayout(groupLayout);
			panel.validate();
			panel.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


