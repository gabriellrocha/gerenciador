package br.com.faculdade.models.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static Calendar calendar = Calendar.getInstance();
	
	private DateUtil(){}
	
	public static String convertToAppropriateString(java.sql.Date date) {
		
		Date utilDate = new Date(date.getTime());
		
		calendar.setTime(utilDate);
		
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		int moth = calendar.get(Calendar.MONTH) + 1;
		
		int year = calendar.get(Calendar.YEAR);
		
		if(moth < 10) {
			return year + "-0" + moth + "-" + day;
		}
		
		return  year + "-" + moth + "-" + day;
	}
}
