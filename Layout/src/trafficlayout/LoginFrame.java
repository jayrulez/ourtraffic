package trafficlayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import trafficlayout.form.LoginForm;


public class LoginFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JMenuBar mainMenuBar;
	
	public LoginFrame() 
	{
		
		//TODO Auto-generated constructor stub
	}
	
	public void run()
	{
		this.initiate();
		
	}

	public void setContentPanel(JPanel contentPanel)
	{
		this.contentPanel = contentPanel;
		this.add(this.contentPanel,BorderLayout.CENTER);
	}
	
	public void setMainMenuBar(JMenuBar mainMenuBar) 
	{
		this.mainMenuBar = mainMenuBar;
		this.setJMenuBar(this.mainMenuBar);
	}
	
	public void initiate()
	{
		this.setTitle("Traffic Ticket");
		super.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLayout(new BorderLayout());
	}
	
	public static void main(String args[])
	{
		LoginFrame loginFrame = new LoginFrame();

		//System.out.println(transferMenu);
		//JPanel panel = new JPanel();
		//panel.add new JScrollPane(new JTree(new DefaultMutableTreeNode("Tasks",true))));
		//new JScrollPane(new JTree(new DefaultMutableTreeNode("Tasks",true)))
		LoginForm loginForm = new LoginForm("Username:","Password:","","","Login");
		loginForm.render();
		loginFrame.setContentPanel(loginForm);
		
		SwingUtilities.invokeLater(loginFrame);	
	}
}