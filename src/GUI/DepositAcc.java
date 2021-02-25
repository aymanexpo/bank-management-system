package GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import Data.FileIO;
import java.awt.SystemColor;

public class DepositAcc extends JFrame implements Serializable {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public DepositAcc() {
		setTitle("Deposer montant");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepositToAccount = new JLabel("Deposer montant");
		lblDepositToAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepositToAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositToAccount.setBounds(10, 11, 414, 36);
		contentPane.add(lblDepositToAccount);
		
		JLabel lblName = new JLabel("Num compte :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(0, 86, 111, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(121, 83, 211, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 147, 211, 20);
		contentPane.add(textField_1);
		
		JLabel lblAmount = new JLabel("Compte :");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(0, 150, 111, 14);
		contentPane.add(lblAmount);
		
		JButton btnDeposit = new JButton("Deposer");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aacountNum;
				double amt;
				aacountNum=textField.getText();
				amt=Double.parseDouble(textField_1.getText());
				int a=JOptionPane.showConfirmDialog(getComponent(0), "Confirmer ?");
				if(a==0)
				{
				try {
					
						
						FileIO.bank.deposit(aacountNum, amt);
						JOptionPane.showMessageDialog(getComponent(0),"Depot avec succés");
						dispose();
					
						textField.setText(null);
						textField_1.setText(null);
					
				} 
				catch (InvalidAmount e1) {
					JOptionPane.showMessageDialog(getComponent(0), "montant non valid");
					
				} catch (AccNotFound e1) {
					JOptionPane.showMessageDialog(getComponent(0), "Compte non trouvé");
					
				}
				finally
				{
					textField.setText(null);
					textField_1.setText(null);
				}
				}
				else
				{
					textField.setText(null);
					textField_1.setText(null);
				}
			}
		});
		btnDeposit.setBounds(73, 212, 89, 23);
		contentPane.add(btnDeposit);
		
		JButton btnReset = new JButton("Annuler");
		btnReset.setBounds(243, 212, 89, 23);
		contentPane.add(btnReset);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textField.setText(null);
				textField_1.setText(null);
			}
		});
	}
}
