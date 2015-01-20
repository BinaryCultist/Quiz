package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Panel_highscore extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Panel_highscore() {
		JButton but_menu = new JButton("Menu");
		
		ActionListener aL = new Button_Listener(but_menu);
		
		Dimension d = new Dimension(200,50);
		
		setBackground(Color.YELLOW);
		
		add(Box.createVerticalStrut(400));
		
		but_menu.setSize(d);
		but_menu.setMinimumSize(d);
		but_menu.setMaximumSize(d);
		but_menu.setPreferredSize(d);    	
		but_menu.addActionListener(aL);
		but_menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(but_menu);
		
	}

}
