package main;

import gui.ClientGUI;
import javax.swing.UIManager;

public class Main
{
	public static void main(String[]args)
	{
		try
    	{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
		
		ClientGUI frame = new ClientGUI();
		/*frame.setResizable(false);*/				//Fenstergröße nicht veränderbar
		frame.setVisible(true);						//Sichtbar
		// Neue Zeile von Steve
	}
}