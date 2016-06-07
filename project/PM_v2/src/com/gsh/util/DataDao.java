package com.gsh.util;

import com.gsh.data.Data;

import javafx.collections.ObservableList;

/**
 * 数据记录XML文件操作接口
 * @author gaoshuhang
 *
 */
public interface DataDao
{
	/**
	 * 添加密码条目
	 * @param data 数据模型
	 * @throws Exception
	 */
	public void addPassword(Data data) throws Exception;
	/**
	 * 通过ID删除密码条目
	 * @param id 数据ID
	 * @throws Exception
	 */
	public void removePassword(String id) throws Exception;
	/**
	 * 匹配查找
	 * @param keyword 要匹配的关键字
	 * @return 数据模型列表
	 * @throws Exception
	 */
	public ObservableList<Data> searchItem(String keyword) throws Exception;
	/**
	 * 列出所有数据
	 * @return 包含所有数据的数据模型列表
	 * @throws Exception
	 */
	public ObservableList<Data> listData() throws Exception;
	/**
	 * 读取ID最大值
	 * @return XML文件中的ID值
	 * @throws Exception
	 */
	public int getHistory() throws Exception;
	/**
	 * XML文件中ID加1操作
	 * @throws Exception
	 */
	public void addHistory() throws Exception;
}
