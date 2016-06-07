package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.gsh.data.Data;
import com.gsh.global.GlobalVar;
import com.gsh.global.WindowChooser;
import com.gsh.util.DataDao;
import com.gsh.util.DataDaoImpl;
import com.gsh.util.DataSync;
import com.gsh.util.DataSyncImpl;
import com.gsh.util.KeyManager;
import com.gsh.util.KeyManagerImpl;
import com.gsh.util.LogWriter;
import com.gsh.util.LogWriterImpl;
import com.gsh.util.RandGenerator;
import com.gsh.util.RandGeneratorImpl;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

/**
 * 主窗口控制器
 * @author gaoshuhang
 */
public class MainWindowController implements Initializable
{
	/*状态标签*/
	@FXML
	private Label state;
	
	/*tab-密码清单*/
	@FXML
	private TextField searchText;
	@FXML
	private TableView<Data> table;
	@FXML
	private TableColumn<Data, String> columnId;
	@FXML
	private TableColumn<Data, String> columnItem;
	@FXML
	private TableColumn<Data, String> columnAccount;
	@FXML
	private TableColumn<Data, String> columnPassword;
	@FXML
	private TableColumn<Data, String> columnRemark;
	@FXML
	private TextField deleteId;

	/*tab-密码生成*/
	@FXML
	private CheckBox allowNum;
	@FXML
	private CheckBox allowUppercase;
	@FXML
	private CheckBox allowLowercase;
	@FXML
	private CheckBox allowSymbol;
	@FXML
	private TextField figures;
	
	/*网络备份*/
	@FXML
	private TextField serverHost;
	@FXML
	private TextField serverPort;
	
	/*tab-帮助*/
	@FXML
	private WebView webView;
	
	/**
	 * 秘钥生成按钮控制器，在用户家目录生成秘钥文件.lilac_pm2_keyfile
	 * @param event
	 */
	@FXML
	public void handleGenerateKeyButton(ActionEvent event)
	{
		String path = GlobalVar.homePath + "/" + GlobalVar.defaultKeyFileName;
		File keyFile = new File(path);
		if(keyFile.exists())
		{
			state.setText("秘钥文件" + path + "已存在，请先存至其他位置");
		}
		else
		{
			try
			{
				KeyManager km = new KeyManagerImpl();
				km.createKey(keyFile);
				InputStream in = new FileInputStream(keyFile);
				GlobalVar.keyLoaded = new byte[16];
				in.read(GlobalVar.keyLoaded);
				state.setText("秘钥" + path + "已自动载入");
				in.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				state.setText("IO 错误");
			}
		}
	}
	
	/**
	 * 外部秘钥加载按钮控制器
	 * @param event
	 */
	@FXML
	public void handleLoadKeyButton(ActionEvent event)
	{
		FileChooser fc = new FileChooser();
		File keyFile = fc.showOpenDialog(WindowChooser.mainStage);
		if(keyFile.length() == 16)
		{
			try
			{
				InputStream in = new FileInputStream(keyFile);
				GlobalVar.keyLoaded = new byte[16];
				in.read(GlobalVar.keyLoaded);
				in.close();
				state.setText("秘钥" + keyFile.getAbsolutePath() + "已载入");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				state.setText("IO 错误");
			}
			
		}
		else
		{
			state.setText("错误文件");
		}
	}
	
	/**
	 * 密码条目删除按钮，通过读取条目ID进行删除
	 * @param event
	 */
	@FXML
	public void handleDeleteButton(ActionEvent event)
	{
		if(GlobalVar.keyLoaded != null && !GlobalVar.errState)
		{
			String id = deleteId.getText();
			DataDao dao = new DataDaoImpl();
			try
			{
				dao.removePassword(id);
				refresh();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				state.setText("IO 错误");
			}
		}
	}
	
	/**
	 * 添加密码条目按钮控制器，启动新窗口进行输入
	 * @param event
	 */
	@FXML
	public void handleAddButton(ActionEvent event)
	{
		if(GlobalVar.keyLoaded != null && !GlobalVar.errState)
		{
			WindowChooser.showAddWindow();
		}
	}
	
	/**
	 * 刷新按钮控制器
	 * @param event
	 */
	@FXML
	public void handleRefreshButton(ActionEvent event)
	{
		if(GlobalVar.keyLoaded != null)
		{
			refresh();
		}
	}
	
	/**
	 * 刷新函数
	 */
	private void refresh()
	{
		DataDao dao = new DataDaoImpl();
		try
		{
			ObservableList<Data> arr = dao.listData();
			table.setItems(arr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			GlobalVar.errState = true;
			state.setText("IO 错误 或 秘钥错误");
		}
	}
	
	/**
	 * 查找按钮控制器，通过关键字匹配进行查找
	 * @param event
	 */
	@FXML
	public void handleSearchButton(ActionEvent event)
	{
		if(GlobalVar.keyLoaded != null)
		{
			DataDao dao = new DataDaoImpl();
			String keyword = searchText.getText();
			if(!keyword.equals(""))
			{
				try
				{
					ObservableList<Data> arr = dao.searchItem(keyword);
					table.setItems(arr);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					state.setText("IO 错误");
				}
			}
			else
			{
				refresh();
			}
		}
	}
	
	/**
	 * 随机密码生成控制器
	 * @param e
	 */
	@FXML
	public void handleRandGenerateButton(ActionEvent event)
	{
		String passwordNum_str = figures.getText();
		int passwordNum = 0;
		if(!passwordNum_str.equals(""))
		{
			try
			{
				passwordNum = Integer.valueOf(passwordNum_str);
			}
			catch(Exception e)
			{
				state.setText("错误输入");
				return ;
			}
		}
		String range = "";
		String range_1 = "0123456789";
		String range_2 = "abcdefghijklmnopqrstuvwxyz";
		String range_3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String range_4 = "~!@#$%^&*()-=_+[]{};':,.<>/?";
		if(allowNum.selectedProperty().getValue())
		{
			range += range_1;
		}
		if(allowLowercase.selectedProperty().getValue())
		{
			range += range_2;
		}
		if(allowUppercase.selectedProperty().getValue())
		{
			range += range_3;
		}
		if(allowSymbol.selectedProperty().getValue())
		{
			range += range_4;
		}
		RandGenerator generator = new RandGeneratorImpl();
		String result = generator.randCreate(range, passwordNum);
		GlobalVar.randPassword = result;
		WindowChooser.showRandPasswordWindow();
		state.setText("随机密码生成成功");
	}
	
	/**
	 * 网络同步按钮控制器
	 * @param event
	 */
	@FXML
	public void handleSyncButton(ActionEvent event)
	{
		String host = serverHost.getText();
		String port = serverPort.getText();
		if(host != null && port != null)
		{
			DataSync sync = new DataSyncImpl(host, port);
			File dataFile = new File(GlobalVar.dataPath);
			Long length = dataFile.length();
			byte[] buff = new byte[length.intValue()];
			InputStream in;
			LogWriter logWriter = new LogWriterImpl();
			try
			{
				in = new FileInputStream(dataFile);
				in.read(buff);
				String data = new String(buff);
				sync.doPost(data);
				in.close();
				logWriter.success();
			}
			catch (Exception e)
			{
				e.printStackTrace();
				state.setText("IO或网络错误");
				try
				{
					logWriter.fail("IO或网络错误");
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					state.setText("IO 错误");
				}
			}
		}
	}
	
	/**
	 * 同步日志查看按钮控制器，启动新窗口显示同步日志
	 * @param event
	 */
	@FXML
	public void handleWatchLogButton(ActionEvent event)
	{
		WindowChooser.showLogWindow();
	}

	/**
	 * 初始化帮助文档 状态标签 载入数据表
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		WebEngine engine = webView.getEngine();
		engine.load(new File("src/articles/help.html").toURI().toString());
		
		File keyFile = new File(GlobalVar.homePath + "/" + GlobalVar.defaultKeyFileName);
		if(keyFile.exists())
		{
			try
			{
				if(keyFile.length() == 16)
				{
					InputStream in = new FileInputStream(keyFile);
					GlobalVar.keyLoaded = new byte[16];
					in.read(GlobalVar.keyLoaded);
					state.setText("秘钥" + keyFile.getAbsolutePath() + "已自动载入");
					in.close();
				}
				else
				{
					state.setText("错误文件，请用正确秘钥覆盖");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				state.setText("IO 错误");
			}
		}
		else
		{
			state.setText("秘钥未载入");
		}
		
		DataDao dao = new DataDaoImpl();
		try
		{
			GlobalVar.history = dao.getHistory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			state.setText("IO 错误");
		}
		
		columnId.setCellFactory(TextFieldTableCell.<Data>forTableColumn());
		columnItem.setCellFactory(TextFieldTableCell.<Data>forTableColumn());
		columnAccount.setCellFactory(TextFieldTableCell.<Data>forTableColumn());
		columnPassword.setCellFactory(TextFieldTableCell.<Data>forTableColumn());
		columnRemark.setCellFactory(TextFieldTableCell.<Data>forTableColumn());
		
		if(GlobalVar.keyLoaded != null)
		{
			refresh();
		}
	}
	
}
