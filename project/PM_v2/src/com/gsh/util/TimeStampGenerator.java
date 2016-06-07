package com.gsh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampGenerator
{
	public String getTimeStamp()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
