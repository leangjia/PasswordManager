package com.gsh.global;

/**
 * 全局变量
 * @author gaoshuhang
 *
 */
public class GlobalVar
{
	/*随机密码，用于主窗口和随机密码窗口之间传值*/
	public static String randPassword = "";
	/*用户家目录*/
	public static String homePath = "";
	/*默认秘钥文件名*/
	public static String defaultKeyFileName = ".lilac_pm2_keyfile";
	/*加载的二进制秘钥*/
	public static byte[] keyLoaded = null;
	/*ID值记录*/
	public static int history = 0;
	/*数据文件位置*/
	public static String dataPath = "data/data.xml";
	/*同步日志文件位置*/
	public static String logPath = "data/syncLog.txt";
	/*陷入秘钥错误状态*/
	public static boolean errState = false;
}
