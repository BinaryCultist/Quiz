package gui;

import java.awt.*;
import javax.swing.*;

public class Panel_GUI extends JFrame {
	
	private CardLayout layout;
	private Container pane;
	
	private static final long serialVersionUID = 1L;
	private Panel_game panel_game;
	private Panel_highscore panel_highscore;
	
	public void zeigMenu() {
		layout.show(pane, "Menu");
	}
	
	public void zeigGame() {
		panel_game = new Panel_game();
		panel_game.setLayout(new BoxLayout(panel_game, BoxLayout.Y_AXIS));
		Main.HolFragen();
		panel_game.InitGame();
    	pane.add("Game", panel_game);
		layout.show(pane, "Game");
	}
	
	public void zeigHighscore() {
		Main.Highscore_laden();
		panel_highscore.showHighscore();
		layout.show(pane, "Highscore");		
	}	
	
	public Panel_GUI () {
		pane = new Container();
		layout = new CardLayout();
		setLayout(layout);
		pane = this.getContentPane();
		
    	Panel_login login = new Panel_login();
    	login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
    	pane.add("Login", login);
		
    	Panel_menu menu = new Panel_menu();
    	menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
    	pane.add("Menu", menu);    	
    	
    	panel_highscore = new Panel_highscore();
    	panel_highscore.setLayout(new BoxLayout(panel_highscore, BoxLayout.Y_AXIS));
    	pane.add("Highscore", panel_highscore);
	}
}