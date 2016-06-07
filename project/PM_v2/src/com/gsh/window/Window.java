package com.gsh.window;

/**
 * 窗口生成接口，供WindowChooser调用
 * @author gaoshuhang
 *
 */
public interface Window
{
	/**
	 * 生成窗口 主窗口通过全局变量传入Stage，其余函数内部实例化Stage
	 * @throws Exception
	 */
	public void show() throws Exception;
}
