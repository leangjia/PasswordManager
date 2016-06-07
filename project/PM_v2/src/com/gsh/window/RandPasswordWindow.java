package com.gsh.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RandPasswordWindow implements Window
{
	private Stage stage;
	
	public RandPasswordWindow(Stage stage)
	{
		this.stage = stage;
	}
	@Override
	public void show() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/RandPasswordWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("css/ui.css");
		scene.getStylesheets().add("css/RandStyle.css");
		this.stage.setScene(scene);
		this.stage.getIcons().add(new Image("images/icon.png"));
		this.stage.setTitle("随机密码");
		this.stage.show();
	}

}
