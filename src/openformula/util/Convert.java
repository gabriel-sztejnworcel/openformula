package openformula.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import openformula.env.Config;

public class Convert
{
	public static GregorianCalendar numberToDate(Double number)
	{
		GregorianCalendar calendar = (GregorianCalendar) Config.getInstance().getEpoch().clone();
		calendar.add(Calendar.DAY_OF_MONTH, number.intValue() - 1);
		return calendar;
	}

	public static Double dateToNumber(GregorianCalendar calendar)
	{
		Date epochDate = Config.getInstance().getEpoch().getTime();
		Date argDate = calendar.getTime();
		
		long diffInMilliseconds = argDate.getTime() - epochDate.getTime();
		Long diffInDays = TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
		
		return diffInDays.doubleValue();
	}
	
	public static GregorianCalendar stringToDate(String str, String dateFormatStr) throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
		Date date = dateFormat.parse(str);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal;
	}
	
	public static String dateToString(GregorianCalendar cal, String dateFormatStr)
	{
		DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
		String formattedDate = dateFormat.format(cal.getTime());
		return formattedDate;
	}
}
