package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Panel_highscore extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton but_menu;
	
	public Panel_highscore() {
		but_menu = new JButton("Menu");
		
		Dimension d = new Dimension(200,50);
		
		setBackground(Color.LIGHT_GRAY);
		
		add(Box.createVerticalStrut(400));
		
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
			Client_main.GUI.zeigMenu();
		}		
	}
}