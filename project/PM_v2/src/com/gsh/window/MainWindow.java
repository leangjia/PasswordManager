package com.gsh.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainWindow implements Window
{
	private Stage stage;
	
	public MainWindow(Stage stage)
	{
		this.stage = stage;
	}
	
	@Override
	public void show() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("css/MainStyle.css");
		scene.getStylesheets().add("css/ui.css");
		this.stage.setScene(scene);
		this.stage.getIcons().add(new Image("images/icon.png"));
		this.stage.setTitle("密码管理器");
		this.stage.show();
	}
}
