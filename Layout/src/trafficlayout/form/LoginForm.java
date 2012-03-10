package trafficlayout.form;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class LoginForm extends JPanel 
{
	private JTextField txtUserName;
	private JTextField txtPassword;

	private JLabel lblUserName;
	private JLabel lblPassword;
	
	private JPanel userNameFieldSet;
	private JPanel passwordFieldSet;
	private JPanel buttonFieldSet;
	
	private JButton btnLogin;
	
	private static final long serialVersionUID = 1L;
	
	public LoginForm() 
	{
		this.initiate();
	}
	
	public LoginForm(String lblUserName, String lblPassword, String txtUserName, String txtPassword,String btnLogin)
	{
		try
		{
			this.initiate();
		}
		catch(Exception ex)
		{

		}
		this.lblPassword.setText(lblPassword);
		this.lblUserName.setText(lblUserName);
		this.txtPassword.setText(txtPassword);
		this.txtUserName.setText(txtUserName);
		this.btnLogin.setText(btnLogin);
	}
	
	
	public void initiate()
	{
		this.lblPassword = new JLabel();
		this.lblUserName = new JLabel();
		
		this.txtPassword = new JTextField();
		this.txtUserName = new JTextField();
		
		this.btnLogin = new JButton();
		
		this.userNameFieldSet = new JPanel();
		this.passwordFieldSet = new JPanel();
		this.buttonFieldSet = new JPanel();
	}
	
	public void render()
	{
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.passwordFieldSet.setLayout(new BoxLayout(this.passwordFieldSet,BoxLayout.X_AXIS));
		this.userNameFieldSet.setLayout(new BoxLayout(this.userNameFieldSet,BoxLayout.X_AXIS));
		this.buttonFieldSet.setLayout(new BoxLayout(this.buttonFieldSet,BoxLayout.X_AXIS));
		
		this.txtUserName.setMaximumSize(new Dimension(180,30));
		this.txtPassword.setMaximumSize(new Dimension(180,30));
		
		LineBorder formBorder = new LineBorder(Color.BLACK,2);
		
		this.setBorder(formBorder);
		
		this.userNameFieldSet.add(this.lblUserName);
		this.userNameFieldSet.add(this.txtUserName);
		
		this.passwordFieldSet.add(this.lblPassword);
		this.passwordFieldSet.add(this.txtPassword);
		
		this.buttonFieldSet.add(this.btnLogin);
		
		this.add(this.userNameFieldSet);
		this.add(this.passwordFieldSet);
		this.add(this.buttonFieldSet);
	}
	public void btnLoginClickedListener(ActionListener btnLoginListener)
	{
		this.btnLogin.addActionListener(btnLoginListener);
	}
}