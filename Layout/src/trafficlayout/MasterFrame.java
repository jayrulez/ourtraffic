package trafficlayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;

import java.awt.Dimension;

public abstract class MasterFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	protected JPanel contentPanel;
	protected JPanel leftNavPanel;
	protected JMenuBar mainMenuBar;
	protected JSplitPane splitPane;
	
	public MasterFrame() 
	{
		
	}

	public abstract void initiate();

	public void render()
	{
		this.setMinimumSize(new Dimension(600, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.splitPane.setLeftComponent(this.leftNavPanel);
		this.splitPane.setRightComponent(this.contentPanel);
		this.splitPane.setContinuousLayout(true);
		
		
		this.add(this.splitPane);
		this.setVisible(true);	
	}
}