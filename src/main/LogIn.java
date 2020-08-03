package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame {

	public LogIn() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JTextField txtID = new JTextField(10);
		
		JLabel pwLabel = new JLabel("Password : ");
		JPasswordField txtPass = new JPasswordField(10);
		
		JButton logBtn = new JButton("Log In");
		
		logBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "Dan";
				String pass = "1234";
				
				if(id.equals(txtID.getText())&&pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "You have logged in successfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}
		});
		
		panel.add(label);
		panel.add(txtID);
		panel.add(pwLabel);
		panel.add(txtPass);
		panel.add(logBtn);
		
		add(panel);
		
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LogIn();
	}
	
}
