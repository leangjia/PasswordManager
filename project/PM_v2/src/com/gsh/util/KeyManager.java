package com.gsh.util;

import java.io.File;

/**
 * 秘钥文件保存/读取接口
 * @author gaoshuhang
 */
public interface KeyManager
{
	/**
	 * 向文件写入二进制随机AES128位秘钥
	 * @param keyFile 待写入文件
	 * @throws Exception
	 */
	public void createKey(File keyFile) throws Exception;
	/**
	 * 读取文件中的二进制秘钥
	 * @param keyFile 待读取文件
	 * @return 二进制秘钥信息
	 * @throws Exception
	 */
	public byte[] readKey(File keyFile) throws Exception;
}
