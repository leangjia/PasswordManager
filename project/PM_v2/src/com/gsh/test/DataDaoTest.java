package com.gsh.test;

import org.junit.Test;

import com.gsh.util.DataDao;
import com.gsh.util.DataDaoImpl;

public class DataDaoTest
{
	@Test
	public void test()
	{
		DataDao dao = new DataDaoImpl();
		try
		{
//			dao.addHistory();
//			System.out.println(dao.getHistory());
			System.out.println(dao.listData().size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
