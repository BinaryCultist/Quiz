package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class GUIListener extends WindowAdapter implements ActionListener, CaretListener
{
	private JButton btn_game;
	private JButton btn_highscore;
	private JButton btn_quit;
	private JButton btn_menu;
	private ClientGUI cg;
	
	public void actionPerformed(ActionEvent event)		//Action Buttons
	{
		if(event.getSource() == btn_game)
		{
			cg.pnl_game.setVisible(true);
			cg.setTitle("Neues Spiel");
		}
		if(event.getSource() == btn_highscore)
		{
			cg.pnl_highscore.setVisible(true);
			cg.setTitle("Highscore");
		}
		if(event.getSource() == btn_menu)
		{
			cg.pnl_menu.setVisible(true);
			cg.pnl_outside.setVisible(true);
			cg.setTitle("Quiz");
		}
		if(event.getSource() == btn_quit)
		{
			//TODO
			System.out.println("Wollen Sie wirklich beenden?");
			System.exit(0);
		}
	}

	@Override
	public void caretUpdate(CaretEvent arg0)
	{
		// TODO Auto-generated method stub
	}
	
	protected GUIListener(ClientGUI cg)	
	{
		this.cg =cg;
	}
	
	protected GUIListener()
	{
		
	}
}
