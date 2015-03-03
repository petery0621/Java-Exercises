//ExcelJava 
//Made by Sean Liu
//Ap Comp Sci. 2/16/2015
package Excel;

public class Spreadsheet {

	//	Var to be implemented in CP2
	final int NUM_COLS = 7;
	final int NUM_ROWS = 10;
	final int COL_WIDTH = 12;
	protected Cell[][] cells;

	//	Var already implemented in CP1
	private String[][] table = new String [11][8];
	private char yaxis = 'A';
	private int xaxis = 1;

	// for testing purpose
	public static void main(String[] args){
		
	
	}

	//	Spreadsheet constructor
	public Spreadsheet()
	{
		cells = new Cell[NUM_ROWS][NUM_COLS];

		for (int row = 0; row < NUM_ROWS; row++)
		{
			for (int col = 0; col < NUM_COLS; col++)
			{
				cells[row][col] = new EmptyCell(" ");
			}
		}
	}

	//	Method processes the command from command
	public void processCommand(String input)
	{
		try{
			double realValue = Double.parseDouble(input);
		}catch (NumberFormatException e){			
			
		}
		
		
		
		//Redefine value of both to reset
		yaxis = 'A';
		xaxis = 1;

		// Tokens the input
		String[] inputSplit = input.split(" ");		
		
		// If the input is a single token
		if(inputSplit.length == 1){
			//"#@!SAFA"
			//"B1", "print", "exit"
			
			if(input.equalsIgnoreCase("print")){
				String[][] table = getGridText();
				String decoration = decoration();
				for(int i = 0; i < table.length; i++){
					for(int j = 0; j < table[i].length; j++){
						System.out.print(table[i][j]);
					}
					System.out.println(decoration);
				}
			}else{
				SpreadsheetLocation loc = new SpreadsheetLocation(input);
				System.out.print(cells[loc.getRow()][loc.getCol()].abbreviatedCellText());
			}
		}else{
			// debugging
			for (int i=0; i<inputSplit.length;i++){
				System.out.println(inputSplit[i]);
			}
			
			assignValueToCell(inputSplit[0], inputSplit[2]);			
		}
	}

	//	Method returns column / row/ column width values
	public int getCols(){return NUM_COLS;}	
	public int getRows(){return NUM_ROWS;}
	public int getColWidth(){return COL_WIDTH;}
	
	//	Assign value to the cell
	private void assignValueToCell(String cell, String value)
	{
		System.out.println(cell);
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		Cell c = null;
		if(value.contains("\""))
		{
			c = new ValueCell(value);
		}
		System.out.println("getRow:" + (loc.getRow()-1));
		System.out.println("getCol:" + (loc.getCol()-1));
		cells[loc.getRow()-1][loc.getCol()-1] = c;
	}

	//	Method prints the String Grid
	public String[][] getGridText()
	{		

		//		Sets the x and y axis labels
		//		First box
		table[0][0] = cells[0][0].abbreviatedCellText() + "|";

		//		First Row
		for(int i = 1; i < table[0].length; i++){
			table[0][i] = "     "+yaxis +"      |";
			yaxis = (char) (yaxis + 1);
		}

		//		First Column
		for(int i = 1; i < table.length; i++){
			table[i][0] = "     " + xaxis + "      |";
			xaxis = xaxis + 1;
		}

		//		Last Row
		xaxis = xaxis - 1;
		table[10][0] = "     " + xaxis + "     |";

		//		Sets each cell in the grid to a value
		for(int i = 1; i < table.length; i++){
			for(int j = 1; j < table[i].length; j++){
				table[i][j] = cells[i-1][j-1].abbreviatedCellText() + "|";
			}	
		}
		return table;
	}

	//	Method the decoration around the outer edges of the cells
	public String decoration(){
		String decoration = "";
		for(int i = 0; i <= 7; i++){
			decoration += "------------+";
		}
		return "\n" +decoration;
	}
}
