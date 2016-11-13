package Verleihsoftware.Entities;

public class Benutzer implements DatabaseObject {

	public int id = 0;
	public String Name = "";
	public String Vorname = "";
	public String Username = "";
	public String Passwort = "";
	public int Admin = 0;
	
	public String getTableName() {
		return "Benutzer";
	}

	public int getColumns() {
		return 6;
	}

	@Override
	public String getColumnName(int column) {
		switch(column)
		{
			case 0:
				return "ID";
			case 1:
				return "Name";
			case 2:
				return "Vorname";
			case 3:
				return "Username";
			case 4:
				return "Passwort";
			case 5:
				return "Admin";
			default:
				return null;
		}
	}

	public String getColumnValue(int column) {
		switch(column)
		{
			case 0:
				return Integer.toString(this.id);
			case 1:
				return this.Name;
			case 2:
				return this.Vorname;
			case 3:
				return this.Username;
			case 4:
				return this.Passwort;
			case 5:
				return Integer.toString(this.Admin);
			default:
				return null;
		}
	}

	public void setColumnValue(int column, String value) {
		switch(column)
		{
			case 0:
				try{
					this.id = Integer.parseInt(value);
				}catch(Exception e)
				{}
				break;
			case 1:
				this.Name = value;
				break;
			case 2:
				this.Vorname = value;
				break;
			case 3:
				this.Username = value;
				break;
			case 4:
				this.Passwort = value;
				break;
			case 5:
				try{
					this.Admin = Integer.parseInt(value);
				}catch(Exception e)
				{}
				break;
		}
	}

	@Override
	public boolean isColumnValueString(int column) {
		boolean result = true;
		try{
			Integer.parseInt(this.getColumnValue(column));
			result = false;
		}catch(Exception e)
		{
			
		}
		return result;
	}

}
