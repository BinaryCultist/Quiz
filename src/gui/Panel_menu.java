package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Panel_menu extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton but_newgame;
	private JButton but_highscore;
	private JButton but_quit;
	
	public Panel_menu() {		
		but_newgame = new JButton("New Game");
		but_highscore = new JButton("Highscore");
		but_quit = new JButton("Quit");
		
		Dimension d = new Dimension(200,50);
	
		setBackground(Color.LIGHT_GRAY);
		
		add(Box.createVerticalStrut(140));
		    	
		but_newgame.setSize(d);
		but_newgame.setMinimumSize(d);
		but_newgame.setMaximumSize(d);
		but_newgame.setPreferredSize(d);    	
		but_newgame.addActionListener(this);
		but_newgame.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(but_newgame);
		
		add(Box.createVerticalStrut(20));
		
		but_highscore.setSize(d);
		but_highscore.setMinimumSize(d);
		but_highscore.setMaximumSize(d);
		but_highscore.setPreferredSize(d);    	
		but_highscore.addActionListener(this);
		but_highscore.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(but_highscore);
		
		add(Box.createVerticalStrut(20));
		
		but_quit.setSize(d);
		but_quit.setMinimumSize(d);
		but_quit.setMaximumSize(d);
		but_quit.setPreferredSize(d);
		but_quit.addActionListener(this);
		but_quit.setAlignmentX(Component.CENTER_ALIGNMENT);		
		add(but_quit);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == but_newgame) {
			
			Client_main.GUI.zeigGame();
		}
		
		if(event.getSource() == but_highscore) {
			Client_main.GUI.zeigHighscore();
		}
		
		if(event.getSource() == but_quit) {
			System.exit(0);
		}
		
	}
}