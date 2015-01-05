package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientGUI extends JFrame
{
	private JButton btn_newgame;
	private JButton btn_highscore;
	private JButton btn_quit;
	private JButton btn_menu;
	protected JPanel pnl_menu;
	protected JPanel pnl_outside;
	protected JPanel pnl_highscore;
	protected JPanel pnl_game;
	
	public ClientGUI()
	{
		setTitle("Quizcat");												//Fenstertitel
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);				//Beendet den Thread
		createWidgets();													//Erstellt die Widgets
		addWidgets();														//Fügt die Widgets hinzu
		setupInteractions();												//Ermöglicht die Interaktionen
		setLayout(new CardLayout());										//Layoutsetting
		pack();																//Passt das Layout an
		setLocationRelativeTo(null);										//Zentriert auf Desktop
	}
	
	private void setupInteractions()										//Listener
	{
		btn_newgame.addActionListener(new GUIListener(this));
		btn_highscore.addActionListener(new GUIListener(this));
		btn_quit.addActionListener(new GUIListener());
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
	}
	
	private void createWidgets()											//Erstellen der Widgets
	{
		Dimension d = new Dimension(200,50);
		
		pnl_outside = new JPanel();
		pnl_outside.setLayout(new BoxLayout(pnl_outside, BoxLayout.LINE_AXIS));
		pnl_outside.setBackground(Color.GREEN);
		
		pnl_menu = new JPanel();
		pnl_menu.setLayout(new BoxLayout(pnl_menu, BoxLayout.PAGE_AXIS));
		pnl_menu.setPreferredSize(new Dimension(200,50));					//Dimension d = new Dimension(200,50);
		pnl_menu.setBackground(Color.YELLOW);
		
    	pnl_game = new JPanel();
    	pnl_game.setBackground(Color.BLUE);
    	
    	pnl_highscore = new JPanel();
    	pnl_highscore.setBackground(Color.RED);
    	
    	btn_newgame = new JButton("New Game");
    	btn_newgame.setSize(d);
		btn_newgame.setMinimumSize(d);
		btn_newgame.setMaximumSize(d);
		btn_newgame.setPreferredSize(d);
    	
    	btn_highscore = new JButton("Highscore");
    	btn_highscore.setSize(d);
		btn_highscore.setMinimumSize(d);
		btn_highscore.setMaximumSize(d);
		btn_highscore.setPreferredSize(d);
		
		btn_quit = new JButton("Quit");
		btn_quit.setSize(d);
		btn_quit.setMinimumSize(d);
		btn_quit.setMaximumSize(d);
		btn_quit.setPreferredSize(d);
		
		btn_menu = new JButton("Menu");
	}
}