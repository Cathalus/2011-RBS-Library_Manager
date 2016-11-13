package Verleihsoftware.Utils;

import java.util.ArrayList;

import Verleihsoftware.Controllers.*;
import Verleihsoftware.Entities.*;

public class Globals {
	
	public static boolean logged_in = false;
	public static Benutzer currentUser = new Benutzer();
	public static DBController data = new DBController();
	public static WindowController windows = new WindowController();
	public static UserController users = new UserController();
	
	public Globals()
	{
		data.createTable(new Buch());
		data.createTable(new Genre());
		data.createTable(new Benutzer());
		/*Benutzer raymond = new Benutzer();
		raymond.Vorname = "Raymond";
		raymond.Name = "Walter";
		raymond.Username = "rwalter";
		raymond.id = 1;
		raymond.Admin = 1;
		raymond.Passwort = users.MD5("geheim");
		data.saveObject(raymond); */
	}
	
	public void finalize()
	{
		data.finalize();
	}
}
