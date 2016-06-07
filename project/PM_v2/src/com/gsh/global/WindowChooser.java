package com.gsh.global;

import com.gsh.window.AddWindow;
import com.gsh.window.LogWindow;
import com.gsh.window.MainWindow;
import com.gsh.window.RandPasswordWindow;
import com.gsh.window.Window;

import javafx.stage.Stage;

/**
 * 全局窗口控制
 * @author gaoshuhang
 *
 */
public class WindowChooser
{
	public static Stage mainStage;
	
	/**
	 * 显示主窗口
	 */
	public static void showMainWindow()
	{
		Window mainWindow = new MainWindow(WindowChooser.mainStage);
		try
		{
			mainWindow.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示密码添加窗口
	 */
	public static void showAddWindow()
	{
		Stage addStage = new Stage();
		Window addWindow = new AddWindow(addStage);
		try
		{
			addWindow.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示随机密码窗口
	 */
	public static void showRandPasswordWindow()
	{
		Stage randPasswordStage = new Stage();
		Window addWindow = new RandPasswordWindow(randPasswordStage);
		try
		{
			addWindow.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示日志窗口
	 */
	public static void showLogWindow()
	{
		Stage LogStage = new Stage();
		Window logWindow = new LogWindow(LogStage);
		try
		{
			logWindow.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
