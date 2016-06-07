package com.gsh.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.gsh.global.GlobalVar;

public class LogWriterImpl implements LogWriter
{

	@Override
	public void success() throws Exception
	{
		String path = GlobalVar.logPath;
		BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
		TimeStampGenerator tg = new TimeStampGenerator();
		String info = tg.getTimeStamp() + "\t同步成功\n";
		writer.write(info);
		writer.close();
	}

	@Override
	public void fail(String err) throws Exception
	{
		String path = GlobalVar.logPath;
		BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
		TimeStampGenerator tg = new TimeStampGenerator();
		String info = tg.getTimeStamp() + "\t同步失败 " + err + "\n";
		writer.write(info);
		writer.close();
	}

}
