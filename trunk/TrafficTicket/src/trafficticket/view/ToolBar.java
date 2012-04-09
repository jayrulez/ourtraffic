package trafficticket.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import extension.utility.PrintUtilities;

public class ToolBar extends JToolBar implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton btnPrint;
	private PrintUtilities printerUtility;
	public ToolBar() 
	{
		this.initilise();
	}
	public void initilise()
	{
		this.btnPrint = new JButton(new ImageIcon(ToolBar.class.getResource("/trafficticket/resources/printerIconEnhanced_20x21.png")));
		this.add(this.btnPrint);
		this.btnPrint.addActionListener(this);
	}
	public JButton getBtnPrint() {
		return btnPrint;
	}
	public void setBtnPrint(JButton btnPrint) {
		this.btnPrint = btnPrint;
	}
	public PrintUtilities getPrinterUtility() {
		return printerUtility;
	}
	public void setPrinterUtility(PrintUtilities printerUtility) {
		this.printerUtility = printerUtility;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==this.btnPrint)
		{
			if(this.printerUtility!=null)
			{
				this.printerUtility.print();
			}
		}
		
	}

}