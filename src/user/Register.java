package user;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("\u7528\u6237\u540D\uFF1A");
		name.setHorizontalAlignment(SwingConstants.TRAILING);
		name.setBounds(47, 76, 91, 28);
		frame.getContentPane().add(name);
		
		textField = new JTextField();
		textField.setBounds(159, 77, 132, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel name_1 = new JLabel("\u5BC6\u7801\uFF1A");
		name_1.setHorizontalAlignment(SwingConstants.TRAILING);
		name_1.setBounds(47, 134, 91, 28);
		frame.getContentPane().add(name_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 138, 132, 28);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				String name = textField.getText();
				String password = passwordField.getText();
				user.setName(name);
				user.setPassword(password);
				JOptionPane.showMessageDialog(null,"É¾³ý³É¹¦");
			}
		});
		btnNewButton.setBounds(86, 192, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(227, 192, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
