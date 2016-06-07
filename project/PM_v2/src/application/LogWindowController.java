package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

import com.gsh.global.GlobalVar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * 同步日志窗口控制器
 * @author gaoshuhang
 *
 */
public class LogWindowController implements Initializable
{
	@FXML
	private TextArea text;
	
	/**
	 * 同步日志窗口初始化，将syncLog.txt的内容读入TextArea
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(GlobalVar.logPath));
			String str;
			while((str = reader.readLine()) != null)
			{
				String textContent = text.getText();
				textContent += str + "\n";
				text.setText(textContent);
			}
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
