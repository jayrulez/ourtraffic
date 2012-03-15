package trafficlayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dimension;

public abstract class MasterFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	protected JPanel contentPanel;
	protected JPanel leftNavPanel;
	protected JMenuBar mainMenuBar;
	protected JSplitPane splitPane;
	protected JScrollPane scrollPane;
	protected JScrollPane contentScrollPane;
	
	public MasterFrame() 
	{
		
	}

	public abstract void initiate();

	public void render()
	{
		this.setMinimumSize(new Dimension(600, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.splitPane.setLeftComponent(this.scrollPane);
		this.splitPane.setRightComponent(this.contentScrollPane);
		this.splitPane.setAutoscrolls(true);
		
		this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setWheelScrollingEnabled(true);
		
		this.contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.contentScrollPane.setWheelScrollingEnabled(true);
		
		this.splitPane.setContinuousLayout(true);
		
		
		this.add(this.splitPane);
		this.setVisible(true);	
		
	}
}