package ticketserver.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;

import ticketserver.model.SqlProvider;
import ticketserver.view.ViewUser;



import extension.model.Offender;
import extension.model.ServiceRequest;
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
			this.viewUserPage.getLblOffenderSearchStatus().setText("");
			
			DefaultTableModel defaultTableModel;
			
			defaultTableModel = (DefaultTableModel) this.viewUserPage.getOffenderTable().getModel();
			
			String userId = null;
			String firstName = null;
			String lastName = null;
			Integer policeType = null;
			Integer taxOfficerType = null;
			
			if(!this.viewUserPage.getChbxViewAll().isSelected())
			{
				if(!this.viewUserPage.getTxtOffenderFirstName().getText().trim().isEmpty())
				{

				}
				else
				{

				}
				
				if(!this.viewUserPage.getTxtOffenderLastName().getText().trim().isEmpty())
				{

				}
				else
				{

				}
			}
			else
			{

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
						
						Offender offenderRow;
						
						defaultTableModel.setRowCount(0);
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
						
						while(itr.hasNext())
						{
							
							offenderRow = (Offender) itr.next();
							
							Vector rowData = new Vector();
							
							//System.out.println("Tickets Number: "+ offenderRow.getTrnNumber());
							
							rowData.add(offenderRow.getTrnNumber());
						
								
							rowData.add(offenderRow.getFirstName());
							rowData.add(offenderRow.getMiddleInitial());
							rowData.add(offenderRow.getFirstName());
							
							
							rowData.add(offenderRow.getAddress().getAddress1());
							rowData.add(offenderRow.getAddress().getAddress2());
							rowData.add(offenderRow.getAddress().getParish());
							
							rowData.add(dateFormat.format(offenderRow.getDob()));
							
							rowData.add(dateFormat.format(offenderRow.getLicenseType()));
							
							rowData.add(dateFormat.format(offenderRow.getPoints()));
							
							defaultTableModel.addRow(rowData);
							rowData = null;
						}
					}
					else
					{
						
						defaultTableModel.setRowCount(0);
						this.viewUserPage.getLblOffenderSearchStatus().setForeground(Color.decode("#3300ff"));
						this.viewUserPage.getLblOffenderSearchStatus().setText("Offender record was not found.");
						//defaultTableModel.getDataVector().removeAllElements();
					}
				}
				else
				{				
					defaultTableModel.setRowCount(0);
					this.viewUserPage.getLblOffenderSearchStatus().setForeground(Color.decode("#3300ff"));
					this.viewUserPage.getLblOffenderSearchStatus().setText("Offender record was not found.");
					
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
				System.out.println(e4.getErrorCode());
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
				this.viewUserPage.getTxtOffenderFirstName().setEnabled(false);
				this.viewUserPage.getTxtOffenderLastName().setEnabled(false);
				this.viewUserPage.getTxtOffenderTrn().setEnabled(false);
			}
			else
			{
				this.viewUserPage.getTxtOffenderFirstName().setEnabled(true);
				this.viewUserPage.getTxtOffenderLastName().setEnabled(true);
				this.viewUserPage.getTxtOffenderTrn().setEnabled(true);		
			}
		}
		
	}
	
}