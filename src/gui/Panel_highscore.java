package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import functions.Highscore_eintrag;

public class Panel_highscore extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextArea HighscoreFeld;	
	private JButton but_menu;
	
	public void showHighscore () {
		HighscoreFeld.setText("");
		
		for (Highscore_eintrag e : Main.Highscore) {
			HighscoreFeld.append(e.Nutzername + ": " + e.Punkte.toString() + " Punkte\n");
			System.out.println(e.Nutzername + ": " + e.Punkte.toString() + " Punkte\n");
		}
	}
	
	public Panel_highscore() {
		but_menu = new JButton("Menu");
		Font font = new Font("Arial", Font.PLAIN, 18);
		Dimension t = new Dimension(400,300);
		Dimension d = new Dimension(200,50);
		
		setBackground(Color.LIGHT_GRAY);
		
		add(Box.createVerticalStrut(20));
		
		HighscoreFeld = new JTextArea("", 10, 20);
		HighscoreFeld.setFont(font);
		HighscoreFeld.setAlignmentX(Component.CENTER_ALIGNMENT);
		HighscoreFeld.setOpaque(true);
		HighscoreFeld.setBackground(Color.WHITE);
		HighscoreFeld.setMaximumSize(t);
		HighscoreFeld.setMinimumSize(t);
		HighscoreFeld.setPreferredSize(t);
		HighscoreFeld.setEditable(false);
		HighscoreFeld.setLineWrap(true);
		HighscoreFeld.setWrapStyleWord(true);
    	add(HighscoreFeld);		
		
		add(Box.createVerticalStrut(50));
		
		but_menu.setSize(d);
		but_menu.setMinimumSize(d);
		but_menu.setMaximumSize(d);
		but_menu.setPreferredSize(d);    	
		but_menu.addActionListener(this);
		but_menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(but_menu);		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == but_menu) {
			Main.GUI.zeigMenu();
		}		
	}
}