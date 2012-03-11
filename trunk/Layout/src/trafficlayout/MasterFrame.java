package trafficlayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class MasterFrame extends JFrame implements Runnable 
{
	private static final long serialVersionUID = 1L;
	protected JPanel contentPanel;
	protected JPanel leftNavPanel;
	protected JMenuBar mainMenuBar;
	
	public MasterFrame() 
	{
		this.initiate();
		//TODO Auto-generated constructor stub
	}
	
	public void run()
	{
		this.render();
		
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

	}
	public void render()
	{
		this.setTitle("JmAtm");
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLayout(new BorderLayout());
	}
}