package com.gsh.util;

import java.util.Random;

public class RandGeneratorImpl implements RandGenerator
{

	@Override
	public String randCreate(String range, int num)
	{
		if(num == 0 || range.equals(""))
		{
			return "";
		}
		else
		{
			int length = range.length();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < num; i++)
			{
				Random rand = new Random();
				int randPos = rand.nextInt(length - 1);
				sb.append(range.charAt(randPos));
			}
			return sb.toString();
		}
	}

}
