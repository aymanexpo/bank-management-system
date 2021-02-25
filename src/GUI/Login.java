package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	public Login() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("IntellijAymaneBank");
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Bank");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(147, 11, 151, 41);
		frame.getContentPane().add(label);
		
		JLabel lblLoginScreen = new JLabel("Authentification");
		lblLoginScreen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoginScreen.setBounds(170, 63, 101, 23);
		frame.getContentPane().add(lblLoginScreen);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(55, 119, 64, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(55, 159, 64, 23);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(130, 121, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("aymane");
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(130, 161, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String user,pass;
				textField.setText("aymane");
				user="aymane";
				//user=textField.getText();
				pass=textField_1.getText();
				if((user.equals("aymane")&&(pass.equals("aymane"))))
						{
							JOptionPane.showMessageDialog(frame.getComponent(0), "Authentification par succés");
							frame.setVisible(false);
							
							GUIForm.menu.setVisible(true);
							
						}
				else
				{
					JOptionPane.showMessageDialog(frame.getComponent(0), "Erreur d'authentification");
				}
			}
		});
		btnLogin.setBounds(260, 138, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}