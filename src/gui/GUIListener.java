package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class GUIListener extends WindowAdapter implements ActionListener, CaretListener
{
	private JButton btn_game;
	private JButton btn_highscore;
	private JButton btn_quit;
	private JButton btn_menu;
	private ClientGUI cg;
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == btn_game)
		{
			cg.pnl_menu.setVisible(false);
			cg.pnl_outside.setVisible(false);
			cg.pnl_quiz.setVisible(true);
			cg.setTitle("Quizcat");
			
			{
				/*
				 * Get Inhalt für Fragenlabel und Buttons vom Server, Richtig/Falsch
				 * TRUE/FALSE Zuweisung der Buttons und jeweilige Farbenänderung
				 * Actionlistenerfür Buttons aktivieren
				 */
			}
			
			new Thread()
			{
				@Override
				public void run()
				{
					for(int i = 120; i>=0; i--)
					{
						try
						{
							Thread.sleep((long) (Math.random() * 200));
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						cg.prog_time.setValue(i);
					}
				}
			}.start();
			
		}
		if(event.getSource() == btn_highscore)
		{
			cg.pnl_menu.setVisible(false);
			cg.pnl_outside.setVisible(false);
			cg.pnl_highscore.setVisible(true);
			cg.setTitle("Highscore");
		}
		if(event.getSource() == btn_menu)
		{
			cg.pnl_menu.setVisible(true);
			cg.pnl_outside.setVisible(true);
			cg.pnl_highscore.setVisible(false);
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
		this.cg = cg;
		this.btn_game = cg.getBtn_newgame();
		this.btn_highscore = cg.getBtn_highscore();
		this.btn_quit = cg.getBtn_quit();
		this.btn_menu = cg.getBtn_menu();
	}
	
	protected GUIListener()
	{
		
	}
}
