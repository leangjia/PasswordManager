package com.gsh.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LogWindow implements Window
{
	private Stage stage;
	
	public LogWindow(Stage stage)
	{
		this.stage = stage;
	}
	@Override
	public void show() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/LogWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("css/ui.css");
		this.stage.setScene(scene);
		this.stage.getIcons().add(new Image("images/icon.png"));
		this.stage.setTitle("同步日志");
		this.stage.show();
	}
}
