package Verleihsoftware.Controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import Verleihsoftware.Entities.Benutzer;
import Verleihsoftware.Utils.Globals;

public class UserController {
	
	ArrayList<Benutzer> benutzer = new ArrayList();
	
	public boolean login(String Username, String Passwort)
	{
		boolean result = false;
		benutzer = Globals.data.loadAllData(new Benutzer());
		for(Benutzer b:benutzer)
		{
			if(b.Username.equals(Username) && b.Passwort.equals(MD5(Passwort).toString()))
			{
				result = true;
				Globals.logged_in = true;
				Globals.currentUser = b;
			}
		}
		return result;
	}
	
	public String MD5(String Passwort)
	{
		String result = "";
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(Passwort.getBytes(),0,Passwort.length());
			result = new String(new BigInteger(1,m.digest()).toString(16));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void logout()
	{
		Globals.logged_in = false;
		Globals.currentUser = new Benutzer();
	}
	
}
