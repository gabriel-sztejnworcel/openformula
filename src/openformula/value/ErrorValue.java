
package openformula.value;

public class ErrorValue
{
	public static final String NA = "#NA!";
	public static final String VALUE = "#VALUE!";
	public static final String REF = "#REF!";
	public static final String NAME = "#NAME?";
	
	private String error;
	
	public ErrorValue(String error)
	{
		this.error = error;
	}
	
	public String getError()
	{
		return error;
	}
}
