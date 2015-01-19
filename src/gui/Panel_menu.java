package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel_menu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Panel_menu() {
		
		JButton but_newgame = new JButton("New Game");
		JButton but_highscore = new JButton("Highscore");
		JButton but_quit = new JButton("Quit");
		
		ActionListener aL = new Button_Listener(but_newgame, but_highscore, but_quit);
		
		//JPanel Panel_menu = new JPanel();
		Dimension d = new Dimension(200,50);
	
		//setLayout(new BoxLayout(Panel_menu, BoxLayout.Y_AXIS));
		setBackground(Color.GREEN);
		
		add(Box.createVerticalStrut(140));
		    	
		//but_newgame = new JButton("New Game");
		but_newgame.setSize(d);
		but_newgame.setMinimumSize(d);
		but_newgame.setMaximumSize(d);
		but_newgame.setPreferredSize(d);    	
		but_newgame.addActionListener(aL);
		but_newgame.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(but_newgame);
		
		add(Box.createVerticalStrut(20));
		
		//but_highscore = new JButton("Highscore");
		but_highscore.setSize(d);
		but_highscore.setMinimumSize(d);
		but_highscore.setMaximumSize(d);
		but_highscore.setPreferredSize(d);    	
		but_highscore.addActionListener(aL);
		but_highscore.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(but_highscore);
		
		add(Box.createVerticalStrut(20));
		
		//but_quit = new JButton("Quit");
		but_quit.setSize(d);
		but_quit.setMinimumSize(d);
		but_quit.setMaximumSize(d);
		but_quit.setPreferredSize(d);
		but_quit.addActionListener(aL);
		but_quit.setAlignmentX(Component.CENTER_ALIGNMENT);		
		add(but_quit);
	}
}