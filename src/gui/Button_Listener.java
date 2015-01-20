package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button_Listener implements ActionListener {
	
	private JButton but_newgame;
	private JButton but_highscore;
	private JButton but_quit;
	private JButton but_login;
	private JButton but_newuser;
	private JButton but_antwort1;
	private JButton but_antwort2;
	private JButton but_antwort3;
	private JButton but_antwort4;
	private JButton but_nextquestion;
	private JButton but_menu;
	
	public Button_Listener(JButton but_newgame, JButton but_highscore, JButton but_quit) {
		this.but_newgame=but_newgame;
		this.but_highscore=but_highscore;
		this.but_quit=but_quit;		
	}
	
	public Button_Listener(JButton but_login, JButton but_newuser) {
		this.but_login=but_login;
		this.but_newuser=but_newuser;			
	}
	
	public Button_Listener(JButton but_menu) {
		this.but_menu=but_menu;
	}
	
	public Button_Listener(JButton but_antwort1, JButton but_antwort2, JButton but_antwort3, JButton but_antwort4, JButton but_nextquestion) {
		this.but_antwort1=but_antwort1;
		this.but_antwort2=but_antwort2;
		this.but_antwort3=but_antwort3;
		this.but_antwort4=but_antwort4;
		this.but_nextquestion=but_nextquestion;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == but_newgame) {
			Client_main.GUI.zeigGame();
		}
		
		if(event.getSource() == but_highscore) {
			Client_main.GUI.zeigHighscore();
		}
		
		if(event.getSource() == but_login || event.getSource() == but_newuser) {
			Client_main.GUI.zeigMenu();
		}
		
		if(event.getSource() == but_menu) {
			Client_main.GUI.zeigMenu();
		}
		
		if(event.getSource() == but_antwort1) {

		}
		
		if(event.getSource() == but_antwort2) {

		}
		
		if(event.getSource() == but_antwort3) {

		}
		
		if(event.getSource() == but_antwort4) {

		}
		
		if(event.getSource() == but_nextquestion) {

		}

		if(event.getSource() == but_quit) {
			System.exit(0);
		}
	}	

}
