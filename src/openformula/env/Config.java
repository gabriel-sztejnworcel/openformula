
package openformula.env;

import java.util.GregorianCalendar;

public class Config
{
	private static Config instance = null;
	
	private GregorianCalendar epoch;
	private String dateFormat;
	
	public static Config getInstance()
	{
		if (instance == null)
		{
			instance = new Config();
			setDefaults();
		}
		
		return instance;
	}
	
	private static void setDefaults()
	{
		instance.setEpoch(new GregorianCalendar(1899, 12, 31));
		instance.setDateFormat("MM/dd/yyyy");
	}
	
	private Config()
	{
		
	}
	
	public void setEpoch(GregorianCalendar epoch)
	{
		this.epoch = epoch;
	}
	
	public GregorianCalendar getEpoch()
	{
		return epoch;
	}
	
	public void setDateFormat(String dateFormat)
	{
		this.dateFormat = dateFormat;
	}
	
	public String getDateFormat()
	{
		return dateFormat;
	}
}
