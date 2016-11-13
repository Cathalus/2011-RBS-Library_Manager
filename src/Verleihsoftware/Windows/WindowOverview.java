package Verleihsoftware.Windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Verleihsoftware.Utils.Constants;
import Verleihsoftware.Utils.Globals;

public class WindowOverview extends Window implements ActionListener, WindowListener {

	public int ID = Constants.ID_WINDOW_WELCOME;
	public boolean visible = true;
	private String title = Constants.PROGRAM_NAME+" "+Constants.PROGRAM_VERSION+" Übersicht"; 
	
	public JMenuBar menueleiste = new JMenuBar();
	public JMenu system = new JMenu("System");
	public JMenuItem system_benutzerverwaltung = new JMenuItem("Benutzerverwaltung");
	public JMenuItem system_ausloggen = new JMenuItem("Ausloggen");
	public JMenuItem system_beenden = new JMenuItem("Beenden");
	public JLabel welcome_text = new JLabel("");
	
	public WindowOverview()
	{		
		FensterID = ID;
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(325/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(125/2));
		setTitle(title);
		setVisible(false);
		setEnabled(false);
		setPreferredSize(new Dimension(325,125));
		addWindowListener(this);
		system_benutzerverwaltung.addActionListener(this);
		system_beenden.addActionListener(this);
		system_ausloggen.addActionListener(this);		
		pack();
	}
	
	public void fillMenue()
	{
		welcome_text.setText("");
		welcome_text.setText("Willkommen "+Globals.currentUser.Username+" ("+Globals.currentUser.Name+", "+Globals.currentUser.Vorname+")");
		menueleiste.remove(system);
		menueleiste.add(system);
		if(Globals.currentUser.Admin == 1)
		{
			system.add(system_benutzerverwaltung);
		}
		system.add(system_ausloggen);
		system.add(system_beenden);
		add(menueleiste,BorderLayout.NORTH);
		add(welcome_text,BorderLayout.CENTER);
		pack();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == system_beenden)
		{
			System.exit(0);
		}else if(e.getSource() == system_ausloggen)
		{
			Globals.windows.closeAll();
			Globals.windows.showWindow(Constants.ID_WINDOW_LOGIN);
			Globals.users.logout();
		}else if(e.getSource() == system_benutzerverwaltung)
		{
			Globals.windows.showWindow(Constants.ID_WINDOW_USERMANAGEMENT);
			Globals.windows.fillMenue(Constants.ID_WINDOW_USERMANAGEMENT);
		}
	}
	
	public void windowActivated(WindowEvent arg0) {
	}
	
	public void windowClosed(WindowEvent arg0) {
		System.exit(0);
	}
	
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	
	public void windowDeactivated(WindowEvent arg0) {
	
	}
	
	public void windowDeiconified(WindowEvent arg0) {
		
	}

	public void windowIconified(WindowEvent arg0) {
	
	}
	
	public void windowOpened(WindowEvent arg0) {
		
	}
}
