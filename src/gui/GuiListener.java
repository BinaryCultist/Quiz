package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import function.Connectionmgr;

public class GuiListener extends WindowAdapter implements ActionListener, CaretListener
{
	private JButton btn;
	private String Address;
	private JTextField fldL;	//Login
	private JTextField fldP;	//Password
	
	public void actionPerformed(ActionEvent e)
	{
		Address = fldL.getText();
		Connectionmgr test = new Connectionmgr(Address);
		test.connectionless();
	}
	
	public void caretUpdate(CaretEvent e)
	{
		JTextField fldL = (JTextField)e.getSource();
		JTextField fldP = (JTextField)e.getSource();
		String textL = fldL.getText();
		String textP = fldP.getText();
		btn.setEnabled(!textL.trim().isEmpty() && !textP.trim().isEmpty());
	}
	
	public void windowClosing(WindowEvent e)
	{
		//TODO
		System.out.println("Wollen Sie wirklich beenden?");
		System.exit(0);
	}
	
	protected GuiListener(JButton btn)
	{
		this.btn = btn;
	}
	
	protected GuiListener()
	{
		
	}
	
	protected GuiListener(JTextField fldL, JTextField fldP)
	{
		this.fldL = fldL;
		this.fldP = fldP;
	}
}