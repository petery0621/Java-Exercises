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
		char number1 =  location.charAt(1);
		char number0 =  '1';		
		
		System.out.println("number1: "+ number1);
		System.out.println("number0: " + number0);
		
		row = number1 - number0;
		col = letter1 - letter0;
		
		System.out.println("row: " + row );
		System.out.println("col: " + col );
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
