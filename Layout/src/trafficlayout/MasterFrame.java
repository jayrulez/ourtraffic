package trafficlayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class MasterFrame extends JFrame implements Runnable 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel leftNavPanel;
	private JMenuBar mainMenuBar;
	
	public MasterFrame() 
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
	
	public void setLeftNavPanel(JPanel leftNavPanel)
	{
		this.leftNavPanel = leftNavPanel;
		this.add(this.leftNavPanel,BorderLayout.WEST);
	}
	
	public void setMainMenuBar(JMenuBar mainMenuBar) 
	{
		this.mainMenuBar = mainMenuBar;
		this.setJMenuBar(this.mainMenuBar);
	}
	
	public void initiate()
	{
		this.setTitle("JmAtm");
		super.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLayout(new BorderLayout());
	}
	
}