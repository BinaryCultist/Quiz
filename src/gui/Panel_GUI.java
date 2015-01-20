package gui;

import java.awt.*;
import javax.swing.*;

public class Panel_GUI extends JFrame {
	
	private CardLayout layout;
	private Container pane;
	
	private static final long serialVersionUID = 1L;
	
	public void zeigMenu() {
		layout.show(pane, "Menu");
	}
	
	public void zeigGame() {
		layout.show(pane, "Game");
	}
	
	public void zeigHighscore() {
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
    	
    	Panel_game game = new Panel_game();
    	game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
    	pane.add("Game", game);
    	
    	Panel_highscore highscore = new Panel_highscore();
    	highscore.setLayout(new BoxLayout(highscore, BoxLayout.Y_AXIS));
    	pane.add("Highscore", highscore);
	}
}