package trafficticket.taxoffice.view;

import javax.swing.ImageIcon;

import extension.utility.PrintUtilities;
import extension.view.ImagePanel;

public class Start extends ImagePanel
{

	private static final long serialVersionUID = 1L;

	public Start() 
	{
		
	}

	public void startInit() 
	{
		this.setImg((new ImageIcon(Start.class.getResource("/trafficticket/resources/taxOfficeStartImage.png"))).getImage());
		
		TaxFrame parentFrame =(TaxFrame)this.getTopLevelAncestor();
		if(parentFrame!=null)
		{
			parentFrame.getMainToolBar().setPrinterUtility(new PrintUtilities(this));
		}
	}
}