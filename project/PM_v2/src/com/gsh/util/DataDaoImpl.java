package com.gsh.util;

import java.io.PrintWriter;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.gsh.data.Data;
import com.gsh.global.GlobalVar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataDaoImpl implements DataDao
{
	
	private Encryptor enc;
	
	public DataDaoImpl()
	{
		enc = new EncryptorImpl();
	}
	
	private String encode(String text) throws Exception
	{
		byte[] key = GlobalVar.keyLoaded;
		if(key != null)
		{
			return enc.base64Encode(enc.encrypt(key, text));
		}
		else
		{
			return "";
		}
	}
	
	private String decode(String base64Data) throws Exception
	{
		byte[] key = GlobalVar.keyLoaded;
		if(key != null)
		{
			return enc.decrypt(key, enc.base64Decode(base64Data));
		}
		else
		{
			return "";
		}
	}

	@Override
	public void addPassword(Data data) throws Exception
	{
		String path = GlobalVar.dataPath;
		SAXReader sax = new SAXReader();
		String id = data.getId();
		String item = data.getItem();
		String account = data.getAccount();
		String password = data.getPassword();
		String remark = data.getRemark();
		Document doc = sax.read(path);
		Element root = doc.getRootElement();
		Element userNode = root.addElement("user");
		userNode.addAttribute("id", id);
		userNode.addAttribute("item", encode(item));
		userNode.addAttribute("account", encode(account));
		userNode.addAttribute("password", encode(password));
		userNode.addAttribute("remark", encode(remark));
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new PrintWriter(path, "utf-8"), format);
		writer.write(doc);
		writer.close();
	}

	@Override
	public void removePassword(String id) throws Exception
	{
		SAXReader sax = new SAXReader();
		String path = GlobalVar.dataPath;
		Document doc = sax.read(path);
		Element root = doc.getRootElement();
		for ( @SuppressWarnings("rawtypes")
		Iterator i = root.elementIterator("user"); i.hasNext(); )
		{
		    Element userNode = (Element) i.next();
		    if(userNode.attributeValue("id").equals(id))
		    {
		    	root.remove(userNode);
		    }
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new PrintWriter(path, "UTF-8"), format);
		writer.write(doc);
		writer.close();
	}

	@Override
	public ObservableList<Data> searchItem(String keyword) throws Exception
	{
		SAXReader sax = new SAXReader();
		String path = GlobalVar.dataPath;
		Document doc = sax.read(path);
		Element root = doc.getRootElement();
		ObservableList<Data> result = FXCollections.observableArrayList();
		for ( @SuppressWarnings("rawtypes")
		Iterator i = root.elementIterator("user"); i.hasNext(); )
		{
		    Element node = (Element) i.next();
		    if(StringUtil.includeIngnoreCase(decode(node.attributeValue("item")), keyword) || StringUtil.includeIngnoreCase(decode(node.attributeValue("account")), keyword) || StringUtil.includeIngnoreCase(decode(node.attributeValue("remark")), keyword))
		    {
		    	String id = node.attributeValue("id");
		    	String account = decode(node.attributeValue("account"));
		    	String password = decode(node.attributeValue("password"));
		    	String remark = decode(node.attributeValue("remark"));
		    	String item = decode(node.attributeValue("item"));
		    	Data data = new Data(item, account, password, remark, Integer.valueOf(id));
		    	result.add(data);
		    }
		}
		return result;
	}

	@Override
	public ObservableList<Data> listData() throws Exception
	{
    	String path = GlobalVar.dataPath;
    	ObservableList<Data> result = FXCollections.observableArrayList();
		SAXReader sax = new SAXReader();
		Document doc = sax.read(path);
		Element root = doc.getRootElement();
		for ( @SuppressWarnings("rawtypes")
		Iterator i = root.elementIterator("user"); i.hasNext(); )
		{
		    Element node = (Element) i.next();
	    	String id = node.attributeValue("id");
	    	String account = decode(node.attributeValue("account"));
	    	String password = decode(node.attributeValue("password"));
	    	String remark = decode(node.attributeValue("remark"));
	    	String item = decode(node.attributeValue("item"));
	    	Data data = new Data(item, account, password, remark, Integer.valueOf(id));
	    	result.add(data);
		}
		return result;
	}

	@Override
	public int getHistory() throws Exception
	{
		String path = GlobalVar.dataPath;
		SAXReader sax = new SAXReader();
		Document doc = sax.read(path);
		Element root = doc.getRootElement();
		return Integer.valueOf(root.attributeValue("history"));
	}

	@Override
	public void addHistory() throws Exception
	{
		String path = GlobalVar.dataPath;
		SAXReader sax = new SAXReader();
		Document doc = sax.read(path);
		Element root = doc.getRootElement();
		int history = Integer.valueOf(root.attributeValue("history"));
		history++;
		root.addAttribute("history", String.valueOf(history));
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new PrintWriter(path, "utf-8"), format);
		writer.write(doc);
		writer.close();
	}

	
}
