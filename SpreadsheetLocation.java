package Excel;

public class SpreadsheetLocation {
	protected int row = 0;
	protected int col = 0;
	
	public SpreadsheetLocation(int newRow, int newCol)
	{
		row = newRow;
		col = newCol;
	}
	
	public SpreadsheetLocation(String location)
	{
		int letter1 = (int) location.charAt(0);
		int letter0 = (int) 'A';
		int number1 = (int) location.charAt(1);
		int number0 = (int) '1';
		
		
		row = number1 - number0;
		col = letter1 - letter0;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
}
