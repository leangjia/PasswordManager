package application;

import com.gsh.global.GlobalVar;
import com.gsh.global.WindowChooser;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		GlobalVar.homePath = System.getProperty("user.home");
		WindowChooser.mainStage = primaryStage;
		WindowChooser.showMainWindow();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
