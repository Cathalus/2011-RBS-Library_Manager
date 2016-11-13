package Verleihsoftware.Entities;

public class Buch implements DatabaseObject {
	public int id = 0;
	public String titel = "";
	public String autor = "";
	public int genre = 0;
	public int erscheinungsjahr = 0;

	public String getColumnName(int column) {
		switch(column)
		{
			case 0:
				return "ID";
			case 1:
				return "Titel";
			case 2:
				return "Autor";
			case 3:
				return "Genre";
			case 4:
				return "Erscheinungsjahr";
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
				return this.titel;
			case 2:
				return this.autor;
			case 3:
				return Integer.toString(this.genre);
			case 4:
				return Integer.toString(this.erscheinungsjahr);
			default:
				return null;
		}
	}
	public int getColumns() {
		return 5;
	}
	public String getTableName() {
		return "Buecher";
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
				this.titel = value;
				break;
			case 2:
				this.autor = value;
				break;
			case 3:
				try{
					this.genre = Integer.parseInt(value);
				}catch(Exception e)
				{}
				break;
			case 4:
				try{
					this.erscheinungsjahr = Integer.parseInt(value);
				}catch(Exception e)
				{}
				break;
		}
	}
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
