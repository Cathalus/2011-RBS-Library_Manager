package Verleihsoftware.Entities;

public class Genre implements DatabaseObject {

	public int id = 0;
	public String genre = "";
	public int medium = 0;
	/* Medium:
	 * 1 - Buch
	 * 2 - CD
	 * 3 - DVD 
	 */
	
	public String getTableName() {
		return "Genres";
	}
	
	public int getColumns() {
		return 3;
	}

	public String getColumnName(int column) {
		switch(column)
		{
			case 0:
				return "ID";
			case 1:
				return "Genre";
			case 2:
				return "Medium";
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
				return this.genre;
			case 2:
				return Integer.toString(this.medium);
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
				this.genre = value;
				break;
			case 2:
				try{
					this.medium = Integer.parseInt(value);
				}catch(Exception e)
				{}
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
