package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Panel_game extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Panel_game() {		
		String Antwort1 = "Ant 1";
		String Antwort2 = "Ant 2";
		String Antwort3 = "Ant 3";
		String Antwort4 = "Ant 4";
		JButton but_antwort1 = new JButton(Antwort1);
		JButton but_antwort2 = new JButton(Antwort2);
		JButton but_antwort3 = new JButton(Antwort3);
		JButton but_antwort4 = new JButton(Antwort4);
		JButton but_nextquestion = new JButton("Nächste Frage");
    	String text = "Das ist eine lange Frage1 und hier noch eine lange Frage2!";    	
    	Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    	
		ActionListener aL = new Button_Listener(but_antwort1, but_antwort2, but_antwort3, but_antwort4, but_nextquestion);
		
    	setBackground(Color.BLUE);    	
    	
    	Dimension d = new Dimension(200,50);
		Dimension t3 = new Dimension(400,100);
		Font font = new Font("Arial", Font.PLAIN, 18);
    	
		add(Box.createVerticalStrut(20));    	
    	
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
    	add(fragenfeld);
    	
		add(Box.createVerticalStrut(100));
		
		// Antwortknopf 1 und 2
		
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.LINE_AXIS));
		
		buttonPanel1.add(Box.createRigidArea(new Dimension(100, 0)));
		
    	but_antwort1.setSize(d);
    	but_antwort1.setMinimumSize(d);
    	but_antwort1.setMaximumSize(d);
    	but_antwort1.setPreferredSize(d);    	
    	but_antwort1.addActionListener(aL);
    	but_antwort1.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel1.add(but_antwort1);
    	
    	buttonPanel1.add(Box.createHorizontalGlue());
    	
    	but_antwort2.setSize(d);
    	but_antwort2.setMinimumSize(d);
    	but_antwort2.setMaximumSize(d);
    	but_antwort2.setPreferredSize(d);    	
    	but_antwort2.addActionListener(aL);
    	but_antwort2.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel1.add(but_antwort2);
    	
		buttonPanel1.add(Box.createRigidArea(new Dimension(100, 0)));
    	
    	add(buttonPanel1);
		add(Box.createVerticalStrut(50));
		
		// Antwortknopf 3 und 4
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.LINE_AXIS));
		
		buttonPanel2.add(Box.createRigidArea(new Dimension(100, 0)));
		
    	but_antwort3.setSize(d);
    	but_antwort3.setMinimumSize(d);
    	but_antwort3.setMaximumSize(d);
    	but_antwort3.setPreferredSize(d);    	
    	but_antwort3.addActionListener(aL);
    	but_antwort3.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel2.add(but_antwort3);
    	
    	buttonPanel2.add(Box.createHorizontalGlue());
    	
    	but_antwort4.setSize(d);
    	but_antwort4.setMinimumSize(d);
    	but_antwort4.setMaximumSize(d);
    	but_antwort4.setPreferredSize(d);    	
    	but_antwort4.addActionListener(aL);
    	but_antwort4.setAlignmentX(Component.CENTER_ALIGNMENT);
    	buttonPanel2.add(but_antwort4);
    	
		buttonPanel2.add(Box.createRigidArea(new Dimension(100, 0)));
    	
    	add(buttonPanel2);
		add(Box.createVerticalStrut(100));
		
		// Nächste-Frage-Knopf
		
		JPanel buttonPanel3 = new JPanel();
		buttonPanel3.setLayout(new BoxLayout(buttonPanel3, BoxLayout.LINE_AXIS));		

    	buttonPanel3.add(Box.createHorizontalGlue());
		
		but_nextquestion.setSize(d);
		but_nextquestion.setMinimumSize(d);
		but_nextquestion.setMaximumSize(d);
		but_nextquestion.setPreferredSize(d);    	
		but_nextquestion.addActionListener(aL);
		but_nextquestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		but_nextquestion.setVisible(false);
    	buttonPanel3.add(but_nextquestion);
    	
		buttonPanel3.add(Box.createRigidArea(new Dimension(100, 0)));
    	
    	add(buttonPanel3);
	}
}
