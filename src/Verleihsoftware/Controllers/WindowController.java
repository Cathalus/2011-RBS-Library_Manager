package Verleihsoftware.Controllers;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.sun.org.apache.bcel.internal.Constants;

import Verleihsoftware.Windows.*;

public class WindowController {
	
	ArrayList<Window> windows = new ArrayList();
	
	public WindowController()
	{
		windows.add(new WindowLogin());
		windows.add(new WindowOverview());
		windows.add(new WindowUserManagement());
	}
	
	public void closeAll()
	{
		for(Window w:windows)
		{
			hideWindow(w.FensterID);
		}
	}
	
	public void hideWindow(int id)
	{
		for(Window w:windows)
		{
			if(w.FensterID == id)
			{
				w.setVisible(false);
				w.setEnabled(false);
			}
		}
	}
	
	public void showWindow(int id)
	{
		for(Window w:windows)
		{
			if(w.FensterID == id)
			{
				w.setVisible(true);
				w.setEnabled(true);
			}
		}
	}
	
	public void fillMenue(int id)
	{
		for(Window w:windows)
		{
			if(w.FensterID == id)
			{
				w.fillMenue();
			}
		}
	}
	
}
