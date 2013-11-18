package com.idetronic.portlet;

import java.util.Date;

public class TimeDifference {
	//return the difference in miliseconds
	public static long getDifferenceMs(Date low,Date high)
	{
		return high.getTime() - low.getTime();
	}
	public static String getDifferenceStr(Date low,Date high)
	{
		long diff = getDifferenceMs(low,high);
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		String ret = diffDays + " days,"+ diffHours + " hours,"+
					diffMinutes + " minutes,"+	
					diffSeconds + " seconds.";
		return ret;
	}

}
