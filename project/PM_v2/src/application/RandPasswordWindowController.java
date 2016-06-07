package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.gsh.global.GlobalVar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * 随机密码窗口控制器
 * @author gaoshuhang
 *
 */
public class RandPasswordWindowController implements Initializable
{
	@FXML
	TextField password;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		password.setText(GlobalVar.randPassword);
	}
}
