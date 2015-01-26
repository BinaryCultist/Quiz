package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import functions.Frage;
import functions.Highscore_eintrag;


public class Panel_game extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Frage aktuellefrage;
	private int aktuellerindex = 0;
	public int punkte = 0;
	private JTextArea fragenfeld;
	private JButton but_antwort1;
	private JButton but_antwort2;
	private JButton but_antwort3;
	private JButton but_antwort4;
	private JButton but_nextquestion;
	
	public void InitGame() {
		aktuellerindex = 0;
		punkte = 0;
		aktuellefrage = Main.Allefragen.get(0);
		SetButtons();
	}
	
	public Panel_game() {
		

		but_antwort1 = new JButton();
		but_antwort2 = new JButton();
		but_antwort3 = new JButton();
		but_antwort4 = new JButton();
		but_nextquestion = new JButton("Nächste Frage");
    	Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    	
    	setBackground(Color.LIGHT_GRAY);
    	
    	Dimension d2 = new Dimension(200,50);
    	Dimension d = new Dimension(300,60);
		Dimension t3 = new Dimension(400,100);
		Font font = new Font("Arial", Font.PLAIN, 18);
    	
		add(Box.createVerticalStrut(20));    	
    	
		fragenfeld = new JTextArea("", 3, 20);
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
    	fragenfeld.setWrapStyleWord(true);
    	add(fragenfeld);
    	
		add(Box.createVerticalStrut(60));
		
		// Antwortknopf 1 und 2
		
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setBackground(Color.LIGHT_GRAY);
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.LINE_AXIS));
		
		buttonPanel1.add(Box.createRigidArea(new Dimension(50, 0)));
		
    	but_antwort1.setSize(d);
    	but_antwort1.setMinimumSize(d);
    	but_antwort1.setMaximumSize(d);
    	but_antwort1.setPreferredSize(d);    	
    	but_antwort1.addActionListener(this);
    	but_antwort1.setAlignmentX(Component.CENTER_ALIGNMENT);
    	but_antwort1.setBackground(Color.WHITE);
    	buttonPanel1.add(but_antwort1);
    	
    	buttonPanel1.add(Box.createHorizontalGlue());
    	
    	but_antwort2.setSize(d);
    	but_antwort2.setMinimumSize(d);
    	but_antwort2.setMaximumSize(d);
    	but_antwort2.setPreferredSize(d);    	
    	but_antwort2.addActionListener(this);
    	but_antwort2.setAlignmentX(Component.CENTER_ALIGNMENT);
    	but_antwort2.setBackground(Color.WHITE);
    	buttonPanel1.add(but_antwort2);
    	
		buttonPanel1.add(Box.createRigidArea(new Dimension(50, 0)));
    	
    	add(buttonPanel1);
		add(Box.createVerticalStrut(50));
		
		// Antwortknopf 3 und 4
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.LINE_AXIS));
		buttonPanel2.setBackground(Color.LIGHT_GRAY);
		
		buttonPanel2.add(Box.createRigidArea(new Dimension(50, 0)));
		
    	but_antwort3.setSize(d);
    	but_antwort3.setMinimumSize(d);
    	but_antwort3.setMaximumSize(d);
    	but_antwort3.setPreferredSize(d);    	
    	but_antwort3.addActionListener(this);
    	but_antwort3.setAlignmentX(Component.CENTER_ALIGNMENT);
    	but_antwort3.setBackground(Color.WHITE);
    	buttonPanel2.add(but_antwort3);
    	
    	buttonPanel2.add(Box.createHorizontalGlue());
    	
    	but_antwort4.setSize(d);
    	but_antwort4.setMinimumSize(d);
    	but_antwort4.setMaximumSize(d);
    	but_antwort4.setPreferredSize(d);    	
    	but_antwort4.addActionListener(this);
    	but_antwort4.setAlignmentX(Component.CENTER_ALIGNMENT);
    	but_antwort4.setBackground(Color.WHITE);
    	buttonPanel2.add(but_antwort4);
    	
		buttonPanel2.add(Box.createRigidArea(new Dimension(50, 0)));
    	
    	add(buttonPanel2);
		add(Box.createVerticalStrut(100));
		
		// Nächste-Frage-Knopf
		
		JPanel buttonPanel3 = new JPanel();
		buttonPanel3.setBackground(Color.LIGHT_GRAY);
		buttonPanel3.setLayout(new BoxLayout(buttonPanel3, BoxLayout.LINE_AXIS));		

    	buttonPanel3.add(Box.createHorizontalGlue());
		
		but_nextquestion.setSize(d2);
		but_nextquestion.setMinimumSize(d2);
		but_nextquestion.setMaximumSize(d2);
		but_nextquestion.setPreferredSize(d2);    	
		but_nextquestion.addActionListener(this);
		but_nextquestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		but_nextquestion.setBackground(Color.WHITE);
		but_nextquestion.setVisible(false);
    	buttonPanel3.add(but_nextquestion);
    	
		buttonPanel3.add(Box.createRigidArea(new Dimension(50, 0)));
    	
    	add(buttonPanel3);    	
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == but_antwort1) {
			if(aktuellefrage.RichtigeAntwort == 1)
			{
				but_antwort1.setOpaque(true);
				but_antwort1.setBackground(Color.GREEN);
				punkte++;
			}
			else{
				but_antwort1.setOpaque(true);
				but_antwort1.setBackground(Color.RED);
			}
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);
		}
		
		if(event.getSource() == but_antwort2) {
			if(aktuellefrage.RichtigeAntwort == 2)
			{
				but_antwort2.setOpaque(true);
				but_antwort2.setBackground(Color.GREEN);
				punkte++;
			}
			else{
				but_antwort2.setOpaque(true);
				but_antwort2.setBackground(Color.RED);
			}
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);

		}
		
		if(event.getSource() == but_antwort3) {
			if(aktuellefrage.RichtigeAntwort == 3)
			{
				but_antwort3.setOpaque(true);
				but_antwort3.setBackground(Color.GREEN);
				punkte++;
			}
			else{
				but_antwort3.setOpaque(true);
				but_antwort3.setBackground(Color.RED);
			}
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);

		}
		
		if(event.getSource() == but_antwort4) {
			if(aktuellefrage.RichtigeAntwort == 4)
			{
				but_antwort4.setOpaque(true);
				but_antwort4.setBackground(Color.GREEN);
				punkte++;
			}
			else{
				but_antwort4.setOpaque(true);
				but_antwort4.setBackground(Color.RED);
			}
			but_antwort1.setEnabled(false);
			but_antwort2.setEnabled(false);
			but_antwort3.setEnabled(false);
			but_antwort4.setEnabled(false);
			but_nextquestion.setVisible(true);

		}
		
		if(event.getSource() == but_nextquestion) {
			if(aktuellerindex == 9) {
				System.out.println("Richtige Antworten: " + punkte);
				Highscore_eintrag neuerEintrag = new Highscore_eintrag();
				neuerEintrag.Nutzername = Main.AktNutzername;
				neuerEintrag.Punkte = punkte;
				Main.Highscore_speichern(neuerEintrag);
				Main.GUI.zeigHighscore();
				return;				
			}
			aktuellerindex++;
			aktuellefrage = Main.Allefragen.get(aktuellerindex);
			SetButtons();
		}
	}
	
	private void SetButtons(){	
		but_antwort1.setEnabled(true);
		but_antwort2.setEnabled(true);
		but_antwort3.setEnabled(true);
		but_antwort4.setEnabled(true);
		but_antwort1.setOpaque(true);
		but_antwort2.setOpaque(true);
		but_antwort3.setOpaque(true);
		but_antwort4.setOpaque(true);
		but_antwort1.setBackground(Color.WHITE);
		but_antwort2.setBackground(Color.WHITE);
		but_antwort3.setBackground(Color.WHITE);
		but_antwort4.setBackground(Color.WHITE);
		fragenfeld.setText(aktuellefrage.Frage);			
		but_antwort1.setText("<html><div style='max-width:180px;'>"+aktuellefrage.Antwort1+"</div></html>");
		but_antwort2.setText("<html><div style='max-width:180px;'>"+aktuellefrage.Antwort2+"</div></html>");
		but_antwort3.setText("<html><div style='max-width:180px;'>"+aktuellefrage.Antwort3+"</div></html>");
		but_antwort4.setText("<html><div style='max-width:180px;'>"+aktuellefrage.Antwort4+"</div></html>");
		but_nextquestion.setVisible(false);
	}
}
