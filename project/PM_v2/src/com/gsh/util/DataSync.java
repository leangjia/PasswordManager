package com.gsh.util;

/**
 * 加密数据服务器同步接口
 * @author gaoshuhang
 */
public interface DataSync
{
	/**
	 * 以HTTP POST形式向服务器提交数据
	 * @param data 全部加密数据
	 * @throws Exception
	 */
	public void doPost(String data) throws Exception;
}
