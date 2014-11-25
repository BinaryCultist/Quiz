package main;

import gui.QuizcatFrame;
import javax.swing.UIManager;
 
public class Main
{
    public static void main(String[] args)
    {
    	try
    	{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	
    	QuizcatFrame frame = new QuizcatFrame();
    	/*frame.setResizable(false);*/				//Fenstergr��e nicht ver�nderbar
    	frame.setVisible(true);						//Sichtbar
    }
}