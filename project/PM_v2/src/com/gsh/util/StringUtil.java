package com.gsh.util;

public class StringUtil
{
	public static boolean includeIngnoreCase(String str, String pattern)
	{
		if(str.length() >= pattern.length())
		{
			int strLen = str.length();
			int patLen = pattern.length();
			if(str.substring(0, patLen).equalsIgnoreCase(pattern))
			{
				return true;
			}
			else
			{
				for(int i = 0; i < strLen - patLen; i++)
				{
					if(str.substring(i + 1, patLen + i + 1).equalsIgnoreCase(pattern))
					{
						return true;
					}
				}
			}
			return false;
		}
		else
		{
			return false;
		}
	}
}
