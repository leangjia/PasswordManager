package com.gsh.util;

/**
 * 随机密码生成器接口
 * @author gaoshuhang
 */
public interface RandGenerator
{
	/**
	 * 随机生成密码
	 * @param range 密码范围字符串
	 * @param num 密码位数
	 * @return 密码字符串
	 */
	public String randCreate(String range, int num);
}
