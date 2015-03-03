//ExcelJava 
//Made by Sean Liu
//Ap Comp Sci. 
//2/16/2015
package Excel;

abstract class Cell {

	private String value = "";

	public Cell(String newValue)
	{
		value = newValue;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String newValue)
	{
		this.value = newValue;
	}
	// fullCellText() must return "<empty>" 
	// Isn't it a string, "<empty>"? 
	public String fullCellText()
	{
		String empty = "";
		for (int i = 1; i <= 12; i++){
			empty = empty + " ";
		}
		return empty;
	}
	public String abbreviatedCellText()
	{
		String empty = "";
		for (int i = 1; i <= 12; i++){
			empty = empty + " ";
		}
		return empty;
	}

	public String formatInput(String newInput)
	{
		Spreadsheet sheet = new Spreadsheet();
		String out = "";
		for(int i = 0; i < (sheet.COL_WIDTH - newInput.length())/2; i++)
		{
			out = out + " ";
		}
		if (newInput.length() > 12){
			out = newInput.substring(0, 10) + ">";
		}else{
			out = out + newInput;
		}
		int numSpaces = sheet.COL_WIDTH - out.length();
		for(int j = 0; j < numSpaces; j++)
		{
			out = out + " ";
		}
		return out;
	}
}
