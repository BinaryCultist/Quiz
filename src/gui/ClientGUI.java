package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class ClientGUI extends JFrame
{
	//Buttons für Hauptmenü
	private JButton btn_newgame;
	private JButton btn_highscore;
	private JButton btn_quit;
	private JButton btn_menu;
	
	//Buttons für Fragen
	
	private JButton btn_quest1;
	private JButton btn_quest2;
	private JButton btn_quest3;
	private JButton btn_quest4;
	
	//Fortschrittsbalken für Frage
	protected JProgressBar prog_time;
	
	//Label für Frage
	private JLabel lbl_ask;
	
	//Hauptpanels
	protected JPanel pnl_quiz;
	protected JPanel pnl_menu;
	protected JPanel pnl_outside;
	protected JPanel pnl_highscore;
	
	public JButton getBtn_menu()
	{
		return btn_menu;
	}
	
	public JButton getBtn_highscore()
	{
		return btn_highscore;
	}
	
	public JButton getBtn_newgame()
	{
		return btn_newgame;
	}
	
	public JButton getBtn_quit()
	{
		return btn_quit;
	}
	
	public ClientGUI()
	{
		setTitle("Quizcat");												//Fenstertitel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//Beendet den Thread
		createWidgets();													//Erstellt die Widgets
		addWidgets();														//Fügt die Widgets hinzu
		setupInteractions();												//Ermöglicht die Interaktionen
		setLayout(new CardLayout());		//800x600						//Layoutsetting
		pack();																//Passt das Layout an
		setLocationRelativeTo(null);										//Zentriert auf Desktop
	}
	
	private void setupInteractions()										//Listener
	{
		btn_newgame.addActionListener(new GUIListener(this));
		btn_highscore.addActionListener(new GUIListener(this));
		btn_quit.addActionListener(new GUIListener(this));
		btn_menu.addActionListener(new GUIListener(this));
	}
	
	private void addWidgets()												//Hinzufügen der Widgets
	{
		getContentPane().setLayout(new CardLayout());
		getContentPane().add(pnl_menu);
		{
			pnl_menu.add(Box.createVerticalStrut(225));
			pnl_menu.add(btn_newgame);
			pnl_menu.add(btn_highscore);
			pnl_menu.add(btn_quit);
			pnl_menu.add(Box.createVerticalStrut(225));
		}
		
		getContentPane().add(pnl_outside);
		{
			pnl_outside.add(Box.createHorizontalStrut(300));
			pnl_outside.add(pnl_menu);
			pnl_outside.add(Box.createHorizontalStrut(300));
		}
		
		getContentPane().add(pnl_highscore);
		{
			pnl_highscore.add(btn_menu);
		}
		
		getContentPane().add(pnl_quiz);
		{
			pnl_quiz.add(BorderLayout.NORTH,lbl_ask);
			pnl_quiz.add(BorderLayout.CENTER,btn_quest1);
			pnl_quiz.add(BorderLayout.CENTER,btn_quest2);
			pnl_quiz.add(BorderLayout.CENTER,btn_quest3);
			pnl_quiz.add(BorderLayout.CENTER,btn_quest4);
			pnl_quiz.add(BorderLayout.SOUTH,prog_time);
		}
		
	}
	
	private void createWidgets()											//Erstellen der Widgets
	{
		Dimension d = new Dimension(200,50);								//Dimension für Menü
		Dimension q = new Dimension(700,750);								//Dimnsion für QuizPanel
		Dimension a = new Dimension(700,70);								//Dimension für Frage
		Dimension b = new Dimension(350,70);
		Dimension p = new Dimension(700,30);
		
		pnl_outside = new JPanel();
		pnl_outside.setLayout(new BoxLayout(pnl_outside, BoxLayout.LINE_AXIS));
		pnl_outside.setBackground(Color.GREEN);
		
		pnl_menu = new JPanel();
		pnl_menu.setLayout(new BoxLayout(pnl_menu, BoxLayout.PAGE_AXIS));
		pnl_menu.setPreferredSize(d);												//Dimension d = new Dimension(200,50);
		pnl_menu.setBackground(Color.YELLOW);

    	btn_newgame = new JButton("New Game");
		btn_newgame.setMinimumSize(d);
		btn_newgame.setMaximumSize(d);
		{
			pnl_quiz = new JPanel();
			pnl_quiz.setBackground(Color.BLUE);
			pnl_quiz.setPreferredSize(q);
			{
				lbl_ask = new JLabel("Hier die Frage");						//Per Get-Methode
				lbl_ask.setPreferredSize(a);
				lbl_ask.setBackground(Color.GRAY);
				lbl_ask.setOpaque(true);
				lbl_ask.setFont(lbl_ask.getFont().deriveFont(Font.BOLD + Font.ITALIC, 18));
				lbl_ask.setHorizontalAlignment(SwingConstants.CENTER);
				
				btn_quest1 = new JButton("Hier die Antwort1");				//Per Get-Methode
				btn_quest1.setPreferredSize(b);

				btn_quest2 = new JButton("Hier die Antwort2");				//Per Get-Methode
				btn_quest2.setPreferredSize(b);

				btn_quest3 = new JButton("Hier die Antwort3");				//Per Get-Methode
				btn_quest3.setPreferredSize(b);

				btn_quest4 = new JButton("Hier die Antwort4");				//Per Get-Methode
				btn_quest4.setPreferredSize(b);
				
				prog_time = new JProgressBar(0,120);
				prog_time.setPreferredSize(p);
			}
		}
		
		pnl_highscore = new JPanel();
		pnl_highscore.setBackground(Color.RED);

    	btn_highscore = new JButton("Highscore");
		btn_highscore.setMinimumSize(d);
		btn_highscore.setMaximumSize(d);
		
		btn_quit = new JButton("Quit");
		btn_quit.setMinimumSize(d);
		btn_quit.setMaximumSize(d);
		
		btn_menu = new JButton("Menu");
	}
}