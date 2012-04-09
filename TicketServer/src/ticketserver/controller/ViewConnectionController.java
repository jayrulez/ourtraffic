package ticketserver.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import ticketserver.view.TicketServerFrame;
import ticketserver.view.ViewConnection;

import extension.model.User;

public class ViewConnectionController implements ActionListener, ItemListener, DocumentListener, Runnable
{
	private ViewConnection viewConnectionPage;
	
	public ViewConnectionController(ViewConnection viewConnectionPage)
	{
		this.viewConnectionPage = viewConnectionPage;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.viewConnectionPage.getBtnRunView())
		{
			this.viewConnectionPage.getLblUserSearchStatus().setText("");
			
		}
	}
	
	public void resetIssueTicket()
	{
		
	}
	

	@Override
	public void changedUpdate(DocumentEvent e) 
	{
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) 
	{

		
	}
	@Override
	public void removeUpdate(DocumentEvent e) 
	{
	
	}

	@SuppressWarnings("static-access")
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource() == this.viewConnectionPage.getChbxViewAll())
		{
			if(e.getStateChange() == e.SELECTED)
			{
				this.viewConnectionPage.getTxtUserId().setEnabled(false);
				this.viewConnectionPage.getTxtUserLastName().setEnabled(false);
				this.viewConnectionPage.getTxtUserFirstName().setEnabled(false);
				
				this.viewConnectionPage.getChckbxTaxOfficer().setEnabled(false);
				this.viewConnectionPage.getChckbxPolice().setEnabled(false);
			}
			else
			{
				this.viewConnectionPage.getTxtUserFirstName().setEnabled(true);
				this.viewConnectionPage.getTxtUserLastName().setEnabled(true);
				this.viewConnectionPage.getTxtUserId().setEnabled(true);	
				
				this.viewConnectionPage.getChckbxTaxOfficer().setEnabled(true);
				this.viewConnectionPage.getChckbxPolice().setEnabled(true);
			}
		}
		
	}
	
	public void run()
	{
		this.viewConnectionTableController();
	}
	
	public void viewConnectionTableController()
	{
		TicketServerFrame parentFrame = (TicketServerFrame) this.viewConnectionPage.getTopLevelAncestor();
		while(true)
		{
			if(parentFrame !=null)
			{
				DefaultTableModel defaultTableModel;
				
				defaultTableModel = (DefaultTableModel) this.viewConnectionPage.getUserTable().getModel();
				
				Vector<User> clientUsers = parentFrame.getCurrentClients();
				while(true)
				{
					Iterator itr = clientUsers.iterator();
				
					defaultTableModel.setRowCount(0);
					
					//SimpleDateFormat dateFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
						
					while(itr.hasNext())
					{
						Vector rowData = new Vector();
						
						User currentClientUser = (User)itr.next();
					
						rowData.add(currentClientUser.getHandle());
						
						System.out.println("Current Clients:"+currentClientUser.getHandle());
						if(currentClientUser.getType()==User.POLICE)
						{
							rowData.add(new ImageIcon(ViewConnectionController.class.getResource("/ticketserver/resources/policeOfficerIcon_32x32.png")));
						}
						else if(currentClientUser.getType()==User.TAXOFFICER)
						{
							rowData.add(new ImageIcon(ViewConnectionController.class.getResource("/ticketserver/resources/taxOfficerIcon_32x32.png")));
						}
							
						rowData.add(currentClientUser.getFirstName());
						rowData.add(currentClientUser.getMiddleInitial());
						rowData.add(currentClientUser.getLastName());	
						
						defaultTableModel.addRow(rowData);
						rowData = null;
					}
					try 
					{
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		}
	}
}