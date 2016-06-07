package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.gsh.data.Data;
import com.gsh.global.GlobalVar;
import com.gsh.util.DataDao;
import com.gsh.util.DataDaoImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 添加窗口控制器
 * @author gaoshuhang
 *
 */
public class AddWindowController implements Initializable
{

	@FXML
	TextField item;
	@FXML
	TextField account;
	@FXML
	TextField password;
	@FXML
	TextField remark;
	@FXML
	Label state;
	
	/**
	 * 添加按钮控制器
	 * @param event
	 */
	@FXML
	public void handleAddItemButton(ActionEvent event)
	{
		Data data = new Data(item.getText(), account.getText(), password.getText(), remark.getText(), GlobalVar.history + 1);
		DataDao dao = new DataDaoImpl();
		try
		{
			dao.addPassword(data);
			dao.addHistory();
			GlobalVar.history = dao.getHistory();
			state.setText("添加成功");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			state.setText("IO 错误");
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//
	}
	
}
