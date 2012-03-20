package ticketserver.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class ContentTab extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JScrollPane contentScrollPane;
	private JPanel contentPanel;
	private JPanel contentPagePanel;

	public ContentTab() 
	{
		this.initialize();
	}
	
	public JPanel getContentPanel() 
	{
		return contentPanel;
	}
	
	public void addContentPanel(JPanel content) {
		this.contentPanel.add(content);
	}
	
	public void setContentPanel(JPanel content) {
		this.contentPanel = content;
	}
	
	public void initialize()
	{
		this.contentPanel = new JPanel();
		this.contentScrollPane = new JScrollPane();
		this.contentPagePanel = new JPanel();
		
		this.contentPanel.add(this.contentPagePanel);
		
		this.contentScrollPane
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.contentScrollPane.setWheelScrollingEnabled(true);
		
		this.contentScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.contentScrollPane.setWheelScrollingEnabled(true);
		this.contentScrollPane.setViewportView(this.contentPanel);
		
	}
	
	public void setContentPagePanel(JPanel contentPagePanel)
	{
		this.contentPagePanel = contentPagePanel;
		//this.setContentPanel(this.contentPagePanel);
	}
	public JPanel getContentPagePanel()
	{
		return contentPagePanel;
	}
}