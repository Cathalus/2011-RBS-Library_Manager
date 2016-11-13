package Verleihsoftware.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Verleihsoftware.Entities.*;

public class DBController {
	public Connection con;
	public Statement stm;
	public ResultSet res;
	
	public DBController()
	{
		try{
			// Treiber laden
			Class.forName("org.hsqldb.jdbcDriver");
			// Verbindung aufbauen
			con = DriverManager.getConnection("jdbc:hsqldb:file:res/db/data.db", "user", ""); 
			// SQL Statement
			stm = con.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	public void createTable(DatabaseObject dbobj)
	{
		try {
			String query = "CREATE CACHED TABLE IF NOT EXISTS "+ dbobj.getTableName() +"(";
			for(int i = 0; i < dbobj.getColumns(); i++)
			{
				boolean isstring = false;
				try{
					Integer.parseInt(dbobj.getColumnValue(i));
					isstring = false;
				}catch(Exception e){
					isstring = true;
				}
				if(isstring)
				{
					query += dbobj.getColumnName(i)+" LONGVARCHAR";
				}else{
					if(dbobj.getColumnName(i).equals("ID"))
					{
						query += dbobj.getColumnName(i)+" Integer IDENTITY";
					}else{
						query += dbobj.getColumnName(i)+" Integer";
					}
				}
				if(i < dbobj.getColumns()-1)
				{
					query += ", ";
				}
			}
			query += ");";
			stm.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void saveObject(DatabaseObject obj)
	{
		String query = "INSERT INTO "+obj.getTableName()+" (";
		for(int i = 0; i < obj.getColumns(); i++)
		{
			if(i == obj.getColumns()-1)
			{
				query += obj.getColumnName(i);
			}else{
				query += obj.getColumnName(i)+",";
			}
		}
		query += ") VALUES (";
		for(int i = 0; i < obj.getColumns(); i++)
		{
			if(i == obj.getColumns()-1)
			{
				if(obj.isColumnValueString(i))
				{
					query += "'"+obj.getColumnValue(i)+"'";
				}else{
					if(!obj.getColumnName(i).equals(obj.getColumnName(0)))
					{
						query += obj.getColumnValue(i);
					}else{
						query += null;
					}
				}
			}else{
				if(obj.isColumnValueString(i))
				{
					query += "'"+obj.getColumnValue(i)+"',";
				}else{
					if(!obj.getColumnName(i).equals(obj.getColumnName(0)))
					{
						query += obj.getColumnValue(i)+", ";
					}else{
						query += null+", ";
					}
				}
			}
		}
		query += ");";
		try {
			stm.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateObject(DatabaseObject obj, int id)
	{
		String query = "UPDATE "+obj.getTableName()+" SET ";
		for(int i = 0; i < obj.getColumns(); i++)
		{
			query += obj.getColumnName(i)+" = ";
			if(obj.isColumnValueString(i))
			{
				query += "'"+obj.getColumnValue(i)+"'";
			}else{
				if(!obj.getColumnName(i).equals("ID"))
				{
					query += obj.getColumnValue(i);
				}else{
					query += null;
				}
			}
			if(i != obj.getColumns()-1)
			{
				query += ", ";
			}
		}
		query += " WHERE "+obj.getColumnName(0)+" = "+id+";";
		try{
			stm.execute(query);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void loadData(DatabaseObject obj, int id)
	{
		try {
			res = stm.executeQuery("SELECT * FROM "+obj.getTableName()+" WHERE "+obj.getColumnName(0)+" = "+id+";");
			while(res.next())
			{
				for(int i = 0; i < obj.getColumns(); i++)
				{
					if(obj.isColumnValueString(i))
					{
						obj.setColumnValue(i, res.getString(i+1));
					}else{
						obj.setColumnValue(i, Integer.toString(res.getInt(i+1)));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList loadAllData(DatabaseObject dbobj)
	{
		ArrayList<DatabaseObject> result = new ArrayList();
		try {
			res = stm.executeQuery("SELECT * FROM "+dbobj.getTableName()+";");
			while(res.next())
			{
				DatabaseObject obj = null;
				if(dbobj.getTableName().equals("Buecher"))
				{
					obj = new Buch();
				}else if(dbobj.getTableName().equals("Genres"))
				{
					obj = new Genre();
				}else if(dbobj.getTableName().equals("Benutzer"))
				{
					obj = new Benutzer();
				}
				for(int i = 1; i <= dbobj.getColumns(); i++)
				{
					String value = "";
					if(!dbobj.isColumnValueString(i-1))
					{
						value = Integer.toString(res.getInt(dbobj.getColumnName(i-1)));
					}else
					{
						value = res.getString(dbobj.getColumnName(i-1));
					}
					obj.setColumnValue(i-1, value);
				}
				result.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void finalize()
	{
		try {
			stm.execute("SHUTDOWN");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
