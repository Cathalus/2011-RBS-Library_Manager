package Verleihsoftware.Windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Verleihsoftware.Utils.Constants;
import Verleihsoftware.Utils.Globals;

public class WindowUserManagement extends Window implements ActionListener, WindowListener {

	public int ID = Constants.ID_WINDOW_USERMANAGEMENT;
	public boolean visible = true;
	private String title = Constants.PROGRAM_NAME+" "+Constants.PROGRAM_VERSION+" Benutzerverwaltung";
	
	boolean editMitarbeiter, editKunde = false;
	
	JPanel ma_Buttons = new JPanel(new FlowLayout());
	JButton ma_new = new JButton("Neuen Benutzer anlegen");
	JButton ma_edit = new JButton("Gewählten Benutzer bearbeiten");
	JButton ma_delete = new JButton("Gewählten Benutzer löschen");
	
	JPanel ma_Input = new JPanel(new GridLayout(7,2));
	JTextField ma_Vorname = new JTextField();
	JTextField ma_Name = new JTextField(); 
	JTextField ma_Username = new JTextField();
	JPasswordField ma_Passwort = new JPasswordField();
	JPasswordField ma_RepeatPasswort = new JPasswordField();
	JCheckBox ma_Admin = new JCheckBox("Admin");
	JButton ma_Save = new JButton("Speichern");
	JButton ma_Cancel = new JButton("Abbrechen");
	
	JPanel ma_UserList = new JPanel();
	
	JTabbedPane editModes = new JTabbedPane();
	JPanel editBenutzer = new JPanel();
	JPanel editKunden = new JPanel();
	
	public WindowUserManagement()
	{
		FensterID = ID;
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(800/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(600/2));
		setTitle(title);
		setVisible(false);
		setEnabled(false);
		setPreferredSize(new Dimension(615,400));
		addWindowListener(this);
		editModes.add("Kundenverwaltung", editKunden);
		editKunden.add(new JLabel("Kundenverwaltung"));
		
		ma_Buttons.add(ma_new);
		ma_Buttons.add(ma_edit);
		ma_Buttons.add(ma_delete);
		
		ma_Input.add(new JLabel("Vorname: "));
		ma_Input.add(ma_Vorname);
		ma_Input.add(new JLabel("Name: "));
		ma_Input.add(ma_Name);
		ma_Input.add(new JLabel("Benutzername: "));
		ma_Input.add(ma_Username);
		ma_Input.add(new JLabel("Passwort: "));
		ma_Input.add(ma_Passwort);
		ma_Input.add(new JLabel("Passwort (Wdh.): "));
		ma_Input.add(ma_RepeatPasswort);
		ma_Input.add(new JLabel(""));
		ma_Input.add(ma_Admin);
		ma_Input.add(ma_Cancel);
		ma_Input.add(ma_Save);
		
		ma_Cancel.addActionListener(this);
		ma_Save.addActionListener(this);
		
		editBenutzer.add(ma_Buttons,BorderLayout.NORTH);
		editBenutzer.add(ma_Input,BorderLayout.CENTER);
		
		
		pack();
	}
	
	public void fillMenue() {
		editModes.remove(editBenutzer);
		if(Globals.currentUser.Admin == 1)
		{
			editModes.add("Mitarbeiterverwaltung",editBenutzer);
		}
		this.add(editModes);
		pack();
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public void windowActivated(WindowEvent arg0) {
		
	}

	public void windowClosed(WindowEvent arg0) {
		
	}

	public void windowClosing(WindowEvent arg0) {
		
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
