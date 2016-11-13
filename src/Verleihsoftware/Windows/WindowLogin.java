package Verleihsoftware.Windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Verleihsoftware.Utils.Constants;
import Verleihsoftware.Utils.Globals;

public class WindowLogin extends Window implements ActionListener, WindowListener{
	
	public int ID = Constants.ID_WINDOW_LOGIN;
	public boolean visible = true;
	private String title = Constants.PROGRAM_NAME+" "+Constants.PROGRAM_VERSION+" Mitarbeiterlogin"; 
	
	JPanel all = new JPanel(new GridLayout(3,2));
	JTextField Name = new JTextField();
	JPasswordField Passwort = new JPasswordField();
	JButton login = new JButton("Einloggen");
	JLabel meldung = new JLabel("");
	
	public WindowLogin()
	{
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(325/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(125/2));
		setTitle(title);
		setVisible(true);
		setPreferredSize(new Dimension(325,125));
		setResizable(false);
		addWindowListener(this);
		meldung.setForeground(Color.RED);
		login.addActionListener(this);
		add(meldung,BorderLayout.NORTH);
		all.add(new JLabel("Benutzername:"));
		all.add(Name);
		all.add(new JLabel("Passwort:"));
		all.add(Passwort);
		all.add(new JLabel(""));
		all.add(login);
		add(all,BorderLayout.SOUTH);
		pack();
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login)
		{
			meldung.setText("");
			if(!Globals.users.login(Name.getText().toString(), new String(Passwort.getPassword())))
			{
				meldung.setText("Benutzername und Passwort stimmen nicht überein!");
			}else{
				Globals.windows.hideWindow(Constants.ID_WINDOW_LOGIN);
				Globals.windows.showWindow(Constants.ID_WINDOW_WELCOME);
				Globals.windows.fillMenue(Constants.ID_WINDOW_WELCOME);
			}
		}
	}

	
	public void windowActivated(WindowEvent arg0) {
		
	}
	
	public void windowClosed(WindowEvent arg0)
	{
		System.exit(0);
	}
	
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	
	public void windowDeactivated(WindowEvent arg0) {
		Name.setText("");
		Passwort.setText("");
	}
	
	public void windowDeiconified(WindowEvent arg0) {
	
	}

	public void windowIconified(WindowEvent arg0) {
		
	}

	public void windowOpened(WindowEvent arg0) {
	
	}


	@Override
	public void fillMenue() {
		// TODO Auto-generated method stub
		
	}
	
}
