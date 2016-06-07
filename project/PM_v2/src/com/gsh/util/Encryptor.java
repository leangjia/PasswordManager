package com.gsh.util;

/**
 * 加解密操作接口
 * @author gaoshuhang
 */
public interface Encryptor
{
	/**
	 * 加密函数
	 * @param key 二进制秘钥
	 * @param text 明文信息
	 * @return 二进制密文
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] key, String text) throws Exception;
	/**
	 * 解密函数
	 * @param key 二进制秘钥
	 * @param cipherText 二进制密文
	 * @return 明文字符串
	 * @throws Exception
	 */
	public String decrypt(byte[] key, byte[] cipherText) throws Exception;
	/**
	 * Base64编码函数
	 * @param data 二进制数据
	 * @return 字符串
	 */
	public String base64Encode(byte[] data);
	/**
	 * Base64解码函数
	 * @param str 字符串
	 * @return 二进制数据
	 */
	public byte[] base64Decode(String str);
}
