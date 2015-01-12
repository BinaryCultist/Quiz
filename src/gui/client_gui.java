package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class client_gui extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	Container pane;
	CardLayout layout;
	JButton but_newgame;
	JButton but_highscore;
	JButton but_quit;
	JButton but_menu;
	JButton but_menu2;
	
	public client_gui() {		
		layout = new CardLayout();
		setLayout(layout);
		pane = this.getContentPane();
		
		JPanel outside = new JPanel();		
		JPanel menuPanel = new JPanel();
    	JPanel gamePanel = new JPanel();
    	JPanel highscorePanel = new JPanel();
    	pane.add("Auswahl", outside);
		outside.setLayout(new BoxLayout(outside, BoxLayout.LINE_AXIS));
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
		pack();
		outside.add(Box.createHorizontalStrut(300));
		outside.add(menuPanel);
		outside.add(Box.createHorizontalStrut(300));
		outside.setBackground(Color.GREEN);
		menuPanel.add(Box.createVerticalStrut(225));
		Dimension d = new Dimension(200,50);		
		
		menuPanel.setBackground(Color.YELLOW);		
		    	
    	but_newgame = new JButton("New Game");
    	but_newgame.setSize(d);
    	but_newgame.setMinimumSize(d);
    	but_newgame.setMaximumSize(d);
    	but_newgame.setPreferredSize(d);    	
    	but_newgame.addActionListener(this);
    	
		but_highscore = new JButton("Highscore");
		but_highscore.setSize(d);
		but_highscore.setMinimumSize(d);
		but_highscore.setMaximumSize(d);
		but_highscore.setPreferredSize(d);    	
		but_highscore.addActionListener(this);
		
		but_quit = new JButton("Quit");
		but_quit.setSize(d);
		but_quit.setMinimumSize(d);
		but_quit.setMaximumSize(d);
		but_quit.setPreferredSize(d);
		but_quit.addActionListener(this);		
		menuPanel.add(but_newgame);
		menuPanel.add(but_highscore);
		menuPanel.add(but_quit);
		
		menuPanel.add(Box.createVerticalStrut(225));
    	

    	gamePanel.setBackground(Color.BLUE);    	
    	pane.add("Game", gamePanel);
    	but_menu = new JButton("Menu");
    	but_menu.addActionListener(this);
    	gamePanel.add(but_menu);

    	highscorePanel.setBackground(Color.RED);    	
    	pane.add("Highscore", highscorePanel);
    	but_menu2 = new JButton("Menu");
    	but_menu2.addActionListener(this);
    	highscorePanel.add(but_menu2);		
	}
	
	public static void main(String[]args){
		client_gui GUI = new client_gui();
		GUI.setTitle("Quiz");
		GUI.setSize(800, 600);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == but_newgame) {
			layout.show(pane, "Game");
			setTitle("Neues Spiel");
		}
		if(event.getSource() == but_highscore) {
			layout.show(pane, "Highscore");
			setTitle("Highscore");
		}
		if(event.getSource() == but_menu || event.getSource() == but_menu2) {
			layout.show(pane, "Auswahl");
			setTitle("Quiz");
		}
		if(event.getSource() == but_quit) {
			System.exit(0);
		}
	}	
}