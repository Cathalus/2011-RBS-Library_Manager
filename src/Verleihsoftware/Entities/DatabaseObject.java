package Verleihsoftware.Entities;

public interface DatabaseObject {
	public String getTableName();
	public int getColumns();
	public String getColumnName(int column);
	public String getColumnValue(int column);
	public void setColumnValue(int column, String value);
	public boolean isColumnValueString(int column);
}
