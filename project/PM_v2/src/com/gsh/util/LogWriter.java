package com.gsh.util;

/**
 * 同步日志读写接口
 * @author gaoshuhang
 *
 */
public interface LogWriter
{
	/**
	 * 写入成功信息
	 * @throws Exception
	 */
	public void success() throws Exception;
	/**
	 * 写入失败信息
	 * @param err 错误信息
	 * @throws Exception
	 */
	public void fail(String err) throws Exception;
}
