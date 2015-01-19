package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class client_gui extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	Container pane;
	CardLayout layout;
	JLabel headline;
	JLabel usernamelabel;
	JTextField username;
	JLabel passwordlabel;
	JTextField password;
	JButton but_login;
	JButton but_newuser;	
	JButton but_newgame;
	JButton but_antwort1;
	JButton but_antwort2;
	JButton but_antwort3;
	JButton but_antwort4;	
	JButton but_nextquestion;
	JButton but_highscore;
	JButton but_quit;
	
	public client_gui() {
		layout = new CardLayout();
		setLayout(layout);
		pane = this.getContentPane();		

		//JPanel loginPanel = new JPanel();
		//JPanel menuPanel = new JPanel();
    	JPanel gamePanel = new JPanel();
    	JPanel highscorePanel = new JPanel();
    	
    	Dimension d = new Dimension(200,50);
		Dimension t = new Dimension(150,25);
		Dimension t2 = new Dimension(200,50);
		Dimension t3 = new Dimension(400,100);
		Font font = new Font("Arial", Font.PLAIN, 18);
		Font font2 = new Font("Arial", Font.PLAIN, 30);
		
		// Login-Panel fängt hier an
		
    	Panel_login login = new Panel_login();
    	login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
    	pane.add("Login", login);
    	
    	/*loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
    	loginPanel.setBackground(Color.GRAY);
    	pane.add("Login", loginPanel);
    	
    	loginPanel.add(Box.createVerticalStrut(20));		
		
		headline = new JLabel("Quiz KMI 13");
		headline.setMaximumSize(t2);
		headline.setMinimumSize(t2);
		headline.setPreferredSize(t2);
		headline.setFont(font2);
		headline.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginPanel.add(headline);
		
		loginPanel.add(Box.createVerticalStrut(80));
		
		usernamelabel = new JLabel("Benutzername:");
		usernamelabel.setMaximumSize(t);
		usernamelabel.setMinimumSize(t);
		usernamelabel.setPreferredSize(t);
		usernamelabel.setFont(font);
		usernamelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginPanel.add(usernamelabel);
		
		loginPanel.add(Box.createVerticalStrut(10));
		
		username = new JTextField();
		username.setMaximumSize(t);
		username.setMinimumSize(t);
		username.setPreferredSize(t);
		username.setFont(font);
		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginPanel.add(username);
		
		loginPanel.add(Box.createVerticalStrut(20));
		
		passwordlabel = new JLabel("Passwort:");
		passwordlabel.setMaximumSize(t);
		passwordlabel.setMinimumSize(t);
		passwordlabel.setPreferredSize(t);
		passwordlabel.setFont(font);
		passwordlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginPanel.add(passwordlabel);
		
		loginPanel.add(Box.createVerticalStrut(10));
		
		password = new JTextField();
		password.setMaximumSize(t);
		password.setMinimumSize(t);
		password.setPreferredSize(t);
		password.setFont(font);
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginPanel.add(password);
		
		loginPanel.add(Box.createVerticalStrut(20));
		
		but_login = new JButton("Login");
		but_login.setSize(d);
    	but_login.setMinimumSize(d);
    	but_login.setMaximumSize(d);
    	but_login.setPreferredSize(d);    	
    	but_login.addActionListener(this);
    	but_login.setAlignmentX(Component.CENTER_ALIGNMENT);
    	loginPanel.add(but_login);
    	  	
    	loginPanel.add(Box.createVerticalStrut(20));
    	
		but_newuser = new JButton("New User");
		but_newuser.setSize(d);
		but_newuser.setMinimumSize(d);
		but_newuser.setMaximumSize(d);
		but_newuser.setPreferredSize(d);	
		but_newuser.addActionListener(this);
		but_newuser.setAlignmentX(Component.CENTER_ALIGNMENT);
    	loginPanel.add(but_newuser); */
    	
    	// Menu-Panel fängt hier an
    	
    	Panel_menu menu = new Panel_menu();
    	menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
    	pane.add("Menu", menu);
    	
/*    	menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
    	menuPanel.setBackground(Color.GREEN);
    	pane.add("Menu", menuPanel);
    	
    	menuPanel.add(Box.createVerticalStrut(140));
		    	
    	but_newgame = new JButton("New Game");
    	but_newgame.setSize(d);
    	but_newgame.setMinimumSize(d);
    	but_newgame.setMaximumSize(d);
    	but_newgame.setPreferredSize(d);    	
    	but_newgame.addActionListener(this);
    	but_newgame.setAlignmentX(Component.CENTER_ALIGNMENT);
    	menuPanel.add(but_newgame);
    	
    	menuPanel.add(Box.createVerticalStrut(20));
    	
		but_highscore = new JButton("Highscore");
		but_highscore.setSize(d);
		but_highscore.setMinimumSize(d);
		but_highscore.setMaximumSize(d);
		but_highscore.setPreferredSize(d);    	
		but_highscore.addActionListener(this);
		but_highscore.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuPanel.add(but_highscore);
		
		menuPanel.add(Box.createVerticalStrut(20));
		
		but_quit = new JButton("Quit");
		but_quit.setSize(d);
		but_quit.setMinimumSize(d);
		but_quit.setMaximumSize(d);
		but_quit.setPreferredSize(d);
		but_quit.addActionListener(this);
		but_quit.setAlignmentX(Component.CENTER_ALIGNMENT);		
		menuPanel.add(but_quit); */
		
		// Game-Panel fängt hier an
		
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
    	gamePanel.setBackground(Color.BLUE);    	
    	pane.add("Game", gamePanel);
    	
    	String text = "Das ist eine lange Frage1 und hier noch eine lange Frage2!";
    	Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    	
		gamePanel.add(Box.createVerticalStrut(20));
    	
    	JTextArea fragenfeld = new JTextArea(text, 3, 20);
    	fragenfeld.setFont(font);
    	fragenfeld.setAlignmentX(Component.CENTER_ALIGNMENT);
    	fragenfeld.setOpaque(true);
    	fragenfeld.setBorder(border);
    	fragenfeld.setBackground(Color.WHITE);
    	fragenfeld.setMaximumSize(t3);
    	fragenfeld.setMinimumSize(t3);
    	fragenfeld.setPreferredSize(t3);
    	fragenfeld.setEditable(false);
    	fragenfeld.setLineWrap(true);
    	gamePanel.add(fragenfeld);
    	
		gamePanel.add(Box.createVerticalStrut(100));
		
		// Antwortknopf 1 und 2
		
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.LINE_AXIS));
		
		String Antwort1 = "Ant 1";
		String Antwort2 = "Ant 2";
		
		buttonPanel1.add(Box.createRigidArea(new Dimension(100, 0)));
		
    	but_antwort1 = new JButton(Antwort1);
    	but_antwort1.setSize(d);
    	but_antwort1.setMinimumSize(d);
    	but_antwort1.setMaximumSize(d);
    	but_antwort1.setPreferredSize(d);    	
    	but_antwort1.addActionListener(this);
    	but_antwort1.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel1.add(but_antwort1);
    	
    	buttonPanel1.add(Box.createHorizontalGlue());
    	
    	but_antwort2 = new JButton(Antwort2);
    	but_antwort2.setSize(d);
    	but_antwort2.setMinimumSize(d);
    	but_antwort2.setMaximumSize(d);
    	but_antwort2.setPreferredSize(d);    	
    	but_antwort2.addActionListener(this);
    	but_antwort2.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel1.add(but_antwort2);
    	
		buttonPanel1.add(Box.createRigidArea(new Dimension(100, 0)));
    	
    	gamePanel.add(buttonPanel1);
		gamePanel.add(Box.createVerticalStrut(50));
		
		// Antwortknopf 3 und 4
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.LINE_AXIS));
		
		String Antwort3 = "Ant 3";
		String Antwort4 = "Ant 4";
		
		buttonPanel2.add(Box.createRigidArea(new Dimension(100, 0)));
		
    	but_antwort3 = new JButton(Antwort3);
    	but_antwort3.setSize(d);
    	but_antwort3.setMinimumSize(d);
    	but_antwort3.setMaximumSize(d);
    	but_antwort3.setPreferredSize(d);    	
    	but_antwort3.addActionListener(this);
    	but_antwort3.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel2.add(but_antwort3);
    	
    	buttonPanel2.add(Box.createHorizontalGlue());
    	
    	but_antwort4 = new JButton(Antwort4);
    	but_antwort4.setSize(d);
    	but_antwort4.setMinimumSize(d);
    	but_antwort4.setMaximumSize(d);
    	but_antwort4.setPreferredSize(d);    	
    	but_antwort4.addActionListener(this);
    	but_antwort4.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel2.add(but_antwort4);
    	
		buttonPanel2.add(Box.createRigidArea(new Dimension(100, 0)));
    	
    	gamePanel.add(buttonPanel2);
		gamePanel.add(Box.createVerticalStrut(100));
		
		// Nächste-Frage-Knopf
		
		JPanel buttonPanel3 = new JPanel();
		buttonPanel3.setLayout(new BoxLayout(buttonPanel3, BoxLayout.LINE_AXIS));		

    	buttonPanel3.add(Box.createHorizontalGlue());
		
		but_nextquestion = new JButton("Nächste Frage");
		but_nextquestion.setSize(d);
		but_nextquestion.setMinimumSize(d);
		but_nextquestion.setMaximumSize(d);
		but_nextquestion.setPreferredSize(d);    	
		but_nextquestion.addActionListener(this);
		but_nextquestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		but_nextquestion.setVisible(false);
    	buttonPanel3.add(but_nextquestion);
    	
		buttonPanel3.add(Box.createRigidArea(new Dimension(100, 0)));
    	
    	gamePanel.add(buttonPanel3);
    	
    	// Highscore-Panel fängt hier an
    	
    	highscorePanel.setLayout(new BoxLayout(highscorePanel, BoxLayout.Y_AXIS));
    	highscorePanel.setBackground(Color.RED); 	
    	pane.add("Highscore", highscorePanel);
    	

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == but_login) {
			layout.show(pane, "Menu");
			setTitle("Menu");
		}
		
		if(event.getSource() == but_newuser) {
			layout.show(pane, "Menu");
			setTitle("Menu");
		}		
		
		if(event.getSource() == but_newgame) {
			layout.show(pane, "Game");
			setTitle("Neues Spiel");
		}
		
		if(event.getSource() == but_antwort1) {
			but_antwort1.setOpaque(true);
			but_antwort1.setBackground(Color.RED);			
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);
		}
		
		if(event.getSource() == but_antwort2) {
			but_antwort2.setOpaque(true);
			but_antwort2.setBackground(Color.GREEN);			
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);
		}
		
		if(event.getSource() == but_antwort3) {
			but_antwort3.setOpaque(true);
			but_antwort3.setBackground(Color.GREEN);			
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);
		}
		
		if(event.getSource() == but_antwort4) {
			but_antwort4.setOpaque(true);
			but_antwort4.setBackground(Color.RED);			
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);
		}
		
		if(event.getSource() == but_nextquestion) {
			but_antwort1.setOpaque(false);
			but_antwort2.setOpaque(false);
			but_antwort3.setOpaque(false);
			but_antwort4.setOpaque(false);
			but_antwort1.setEnabled(true);
			but_antwort2.setEnabled(true);
			but_antwort3.setEnabled(true);
			but_antwort4.setEnabled(true);
			but_nextquestion.setVisible(false);
		}
		
		if(event.getSource() == but_highscore) {
			layout.show(pane, "Highscore");
			setTitle("Highscore");
		}

		if(event.getSource() == but_quit) {
			System.exit(0);
		}
	}
}