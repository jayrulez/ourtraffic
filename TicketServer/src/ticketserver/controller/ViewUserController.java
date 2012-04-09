package ticketserver.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import ticketserver.model.SqlProvider;
import ticketserver.view.ViewUser;



import extension.model.Police;
import extension.model.TaxOfficer;
import extension.model.User;

public class ViewUserController implements ActionListener, ItemListener, DocumentListener
{
	private ViewUser viewUserPage;
	private String eventSource;
	
	public ViewUserController(ViewUser viewUserPage,String eventSource)
	{
		this.viewUserPage = viewUserPage;
		this.eventSource = eventSource;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnRunView"))
		{
			this.viewUserPage.getLblUserSearchStatus().setText("");
			
			DefaultTableModel defaultTableModel;
			
			defaultTableModel = (DefaultTableModel) this.viewUserPage.getUserTable().getModel();
			
			String userId = null;
			String firstName = null;
			String lastName = null;
			Integer policeType = null;
			Integer taxOfficerType = null;
			
			if(!this.viewUserPage.getChbxViewAll().isSelected())
			{
				if(!this.viewUserPage.getTxtUserId().getText().trim().isEmpty())
				{
					userId = this.viewUserPage.getTxtUserId().getText().trim();
				}
				else
				{

				}
				
				if(!this.viewUserPage.getTxtUserFirstName().getText().trim().isEmpty())
				{
					firstName = this.viewUserPage.getTxtUserFirstName().getText().trim();
				}
				else
				{

				}
				
				if(!this.viewUserPage.getTxtUserLastName().getText().trim().isEmpty())
				{
					firstName = this.viewUserPage.getTxtUserLastName().getText().trim();
				}
				else
				{

				}
				
				if(this.viewUserPage.getChckbxPolice().isSelected())
				{
					policeType = User.POLICE;
				}
				else
				{

				}
				
				if(this.viewUserPage.getChckbxTaxOfficer().isSelected())
				{
					taxOfficerType = User.TAXOFFICER;
				}
				else
				{

				}
			}

			try
			{
				SqlProvider sqlProvider = new SqlProvider();
				Vector users = sqlProvider.getUsers(userId,firstName,lastName,policeType,taxOfficerType);
					
				if(users!=null)
				{
					if(!users.isEmpty())
					{
							
						Iterator itr = users.iterator();
		
						
						defaultTableModel.setRowCount(0);
						
						//SimpleDateFormat dateFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
						
						Police police;
						TaxOfficer taxOfficer;
						
						while(itr.hasNext())
						{
							Vector rowData = new Vector();
							
							Object obj = itr.next();
							
							
							if(obj  instanceof Police)
							{
								police = (Police)obj;
								
								rowData.add(police.getBadgeNumber());
								
								rowData.add(new ImageIcon(ViewUserController.class.getResource("/ticketserver/resources/policeOfficerIcon_32x32.png")));
								
								rowData.add("Police");
								rowData.add(police.getFirstName());
								rowData.add(police.getMiddleInitial());
								rowData.add(police.getLastName());
								
								
								rowData.add(police.getAddress().getAddress1());
								rowData.add(police.getAddress().getAddress2());
								rowData.add(police.getAddress().getParish());
								
								defaultTableModel.addRow(rowData);
								rowData = null;	
							}
							else if (obj  instanceof TaxOfficer)
							{
								taxOfficer = (TaxOfficer)obj;
								
								rowData.add(taxOfficer.getIdNumber());
								rowData.add(new ImageIcon(ViewUserController.class.getResource("/ticketserver/resources/taxOfficerIcon_32x32.png")));
								
								rowData.add("Tax Officer");
								rowData.add(taxOfficer.getFirstName());
								rowData.add(taxOfficer.getMiddleInitial());
								rowData.add(taxOfficer.getLastName());
								
								
								rowData.add(taxOfficer.getAddress().getAddress1());
								rowData.add(taxOfficer.getAddress().getAddress2());
								rowData.add(taxOfficer.getAddress().getParish());
								
								
								defaultTableModel.addRow(rowData);
								rowData = null;
							}
							
							//System.out.println("Tickets Number: "+ offenderRow.getTrnNumber());

						}
					}
					else
					{
						
						defaultTableModel.setRowCount(0);
						this.viewUserPage.getLblUserSearchStatus().setForeground(Color.decode("#3300ff"));
						this.viewUserPage.getLblUserSearchStatus().setText("Offender record was not found.");
						//defaultTableModel.getDataVector().removeAllElements();
					}
				}
				else
				{				
					defaultTableModel.setRowCount(0);
					this.viewUserPage.getLblUserSearchStatus().setForeground(Color.decode("#3300ff"));
					this.viewUserPage.getLblUserSearchStatus().setText("Offender record was not found.");
					
					//defaultTableModel.getDataVector().removeAllElements();
				}
			}
			catch (ClassNotFoundException e1) 
			{	
				System.out.println(e1.getMessage());
			} 
			catch (InstantiationException e2) 
			{
				System.out.println("Unexpected error occured.");
			} 
			catch (IllegalAccessException e3) 
			{
				System.out.println("Access to the Data Server denied.");
			} 
			catch (SQLException e4) 
			{
				// TODO Auto-generated catch block
				System.out.println("Sql Error: "+e4.getErrorCode());
			}	
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

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("chbxViewAll"))
		{
			if(e.getStateChange() == e.SELECTED)
			{
				this.viewUserPage.getTxtUserId().setEnabled(false);
				this.viewUserPage.getTxtUserLastName().setEnabled(false);
				this.viewUserPage.getTxtUserFirstName().setEnabled(false);
				
				this.viewUserPage.getChckbxTaxOfficer().setEnabled(false);
				this.viewUserPage.getChckbxPolice().setEnabled(false);
			}
			else
			{
				this.viewUserPage.getTxtUserFirstName().setEnabled(true);
				this.viewUserPage.getTxtUserLastName().setEnabled(true);
				this.viewUserPage.getTxtUserId().setEnabled(true);	
				
				this.viewUserPage.getChckbxTaxOfficer().setEnabled(true);
				this.viewUserPage.getChckbxPolice().setEnabled(true);
			}
		}
		
	}
	
}