package com.gsh.util;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataSyncImpl implements DataSync
{
	
	private String host;
	private String port;

	public DataSyncImpl(String host, String port)
	{
		this.host = host;
		this.port = port;
	}
	
	@Override
	public void doPost(String data) throws Exception
	{
		String requestUrl = "http://" + host + ":" + port + "/";
		URL url = new URL(requestUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.connect();
		OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
		osw.write(data);
		osw.flush();
		osw.close();
	}
}
