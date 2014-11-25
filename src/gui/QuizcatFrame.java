package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuizcatFrame extends JFrame
{
	private JLabel lblHeader;
	private JProgressBar progBar;
	private JPanel pnlLeft;
	private JLabel lblLoginName;
	private JLabel lblPassword;
	protected JTextField fldLoginName;
	protected JTextField fldPassword;
	private JButton btnLogin;
	private JPanel pnlRight;
	private JLabel lblWaitResult;
	
	public QuizcatFrame()
	{
		setTitle("Quizcat");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		//Beendet den Thread
		createWidgets();
		addWidgets();
		setupInteractions();
		pack();
		setLocationRelativeTo(null);						//Zentriert auf Desktop
		addWindowListener(new GuiListener());
	}
	
	private void setupInteractions()
	{
		btnLogin.addActionListener(new GuiListener(fldLoginName, fldPassword));
		fldLoginName.addCaretListener(new GuiListener(btnLogin));
	}
	
	private void addWidgets()
	{
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(BorderLayout.PAGE_START,lblHeader);
		getContentPane().add(BorderLayout.PAGE_END,progBar);
		getContentPane().add(BorderLayout.WEST,pnlLeft);
		{
			pnlLeft.add(lblLoginName);
			pnlLeft.add(lblPassword);
			pnlLeft.add(fldLoginName);
			pnlLeft.add(fldPassword);
			pnlLeft.add(btnLogin);
		}
		getContentPane().add(BorderLayout.EAST,pnlRight);
		{
			pnlRight.add(lblWaitResult);
		}
	}
	
	private void createWidgets()
	{
		lblHeader = new JLabel("Quizcat");
		lblHeader.setFont(lblHeader.getFont().deriveFont(Font.BOLD + Font.ITALIC, 30));
		lblHeader.setForeground(Color.YELLOW);
		lblHeader.setOpaque(true);
		lblHeader.setBackground(Color.BLUE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlLeft = new JPanel();
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(Color.GRAY);
		pnlLeft.setPreferredSize(new Dimension(400, 400));
		{
			lblLoginName = new JLabel("Login Name");
			lblLoginName.setBounds(30, 30, 110, 25);
			
			lblPassword = new JLabel("Passwort");
			lblPassword.setBounds(230, 30, 110, 25);
			
			fldLoginName = new JTextField();
			fldLoginName.setBounds(30, 60, 110, 20);
			
			fldPassword = new JTextField();
			fldPassword.setBounds(230, 60, 110, 20);
			
			btnLogin = new JButton("Login");
			btnLogin.setEnabled(false);
			btnLogin.setBounds(30, 100, 100, 25);
		}
		
		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		pnlRight.setBackground(Color.ORANGE);
		pnlRight.setPreferredSize(new Dimension(400, 400));
		{
			lblWaitResult = new JLabel("Warte auf Check...");
			lblWaitResult.setFont(lblWaitResult.getFont().deriveFont(Font.BOLD + Font.ITALIC, 18));
			lblWaitResult.setHorizontalAlignment(SwingConstants.CENTER);
			lblWaitResult.setVerticalAlignment(SwingConstants.CENTER);
			lblWaitResult.setVisible(true);
			lblWaitResult.setBounds(0, 0, 400, 400);
		}
		
		progBar = new JProgressBar(0,100);
		progBar.setPreferredSize(new Dimension(0, 30));
	}
}