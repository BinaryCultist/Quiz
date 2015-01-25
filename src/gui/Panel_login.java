package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Panel_login extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton but_login;
	private JTextField username;
	private JTextField password;
	
	public Panel_login() {
		JLabel headline = new JLabel("Quiz KMI 13");
		JLabel usernamelabel = new JLabel("Benutzername:");
		username = new JTextField();
		JLabel passwordlabel = new JLabel("Passwort:");
		password = new JTextField();
		but_login = new JButton("Login");
		//JButton but_newuser = new JButton("New User");
		
		//ActionListener aL = new Button_Listener(but_login, but_newuser);
		
    	Dimension d = new Dimension(200,50);
		Dimension t = new Dimension(150,25);
		Dimension t2 = new Dimension(200,50);
		Font font = new Font("Arial", Font.PLAIN, 18);
		Font font2 = new Font("Arial", Font.PLAIN, 30);		

    	setBackground(Color.LIGHT_GRAY);
    	
    	add(Box.createVerticalStrut(20));		

		headline.setMaximumSize(t2);
		headline.setMinimumSize(t2);
		headline.setPreferredSize(t2);
		headline.setFont(font2);
		headline.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(headline);
		
		add(Box.createVerticalStrut(80));
		
		usernamelabel.setMaximumSize(t);
		usernamelabel.setMinimumSize(t);
		usernamelabel.setPreferredSize(t);
		usernamelabel.setFont(font);
		usernamelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(usernamelabel);
		
		add(Box.createVerticalStrut(10));
		
		username.setMaximumSize(t);
		username.setMinimumSize(t);
		username.setPreferredSize(t);
		username.setFont(font);
		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(username);
		
		add(Box.createVerticalStrut(20));
		
		passwordlabel.setMaximumSize(t);
		passwordlabel.setMinimumSize(t);
		passwordlabel.setPreferredSize(t);
		passwordlabel.setFont(font);
		passwordlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(passwordlabel);
		
		add(Box.createVerticalStrut(10));
		
		password.setMaximumSize(t);
		password.setMinimumSize(t);
		password.setPreferredSize(t);
		password.setFont(font);
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(password);
		
		add(Box.createVerticalStrut(20));
		
		but_login.setSize(d);
    	but_login.setMinimumSize(d);
    	but_login.setMaximumSize(d);
    	but_login.setPreferredSize(d);    	
    	but_login.addActionListener(this);
    	but_login.setAlignmentX(Component.CENTER_ALIGNMENT);
    	add(but_login);
    	  	
    	/*add(Box.createVerticalStrut(20));
    	
		but_newuser.setSize(d);
		but_newuser.setMinimumSize(d);
		but_newuser.setMaximumSize(d);
		but_newuser.setPreferredSize(d);	
		but_newuser.addActionListener(aL);
		but_newuser.setAlignmentX(Component.CENTER_ALIGNMENT);
    	add(but_newuser);   */ 	
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource() == but_login) {
			
				Boolean isLoginOK = Client_main.Login(username.getText(), password.getText());
				if (isLoginOK) {
					Client_main.AktNutzername = username.getText();
					Client_main.GUI.zeigMenu();
				} else {
					JOptionPane.showMessageDialog(null, "Nutzername und/oder Passwort ist ungültig!");
				}			
		}
	}
	
}
