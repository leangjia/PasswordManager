package com.gsh.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AddWindow implements Window
{
	private Stage stage;
	
	public AddWindow(Stage stage)
	{
		this.stage = stage;
	}
	@Override
	public void show() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("css/ui.css");
		scene.getStylesheets().add("css/AddStyle.css");
		this.stage.setScene(scene);
		this.stage.getIcons().add(new Image("images/icon.png"));
		this.stage.setTitle("添加密码");
		this.stage.show();
	}
}
