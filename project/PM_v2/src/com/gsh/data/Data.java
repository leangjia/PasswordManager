package com.gsh.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * table中显示的数据的模型
 * @author gaoshuhang
 */
public class Data
{
	private final StringProperty item;
	private final StringProperty account;
	private final StringProperty password;
	private final StringProperty remark;
	private final StringProperty id;
	
	public Data(String item, String account, String password, String remark, int id)
	{
		this.item = new SimpleStringProperty(item);
		this.account = new SimpleStringProperty(account);
		this.password = new SimpleStringProperty(password);
		this.remark = new SimpleStringProperty(remark);
		this.id = new SimpleStringProperty(String.valueOf(id));
	}
	
	public String getId()
	{
		return this.id.get();
	}
	
	public String getItem()
	{
		return this.item.get();
	}
	
	public String getAccount()
	{
		return this.account.get();
	}
	
	public String getPassword()
	{
		return this.password.get();
	}
	
	public String getRemark()
	{
		return this.remark.get();
	}
	
}
