
package openformula.value;

public class Reference
{
	private String sheetName;
	private String cellPosition;
	
	public Reference(String sheetName, String cellPosition)
	{
		this.sheetName = sheetName;
		this.cellPosition = cellPosition;
	}
	
	public String getSheetName()
	{
		return sheetName;
	}

	public String getCellPosition()
	{
		return cellPosition;
	}
}
