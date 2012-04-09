package ticketserver.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import ticketserver.model.SqlProvider;
import ticketserver.view.ViewOffense;
import extension.model.Offense;

public class ViewOffenseController implements ActionListener, ItemListener, DocumentListener
{
	private ViewOffense viewOffensePage;
	private String eventSource;
	
	public ViewOffenseController(ViewOffense viewOffensePage,String eventSource)
	{
		this.viewOffensePage = viewOffensePage;
		this.eventSource = eventSource;
	}
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnRunView"))
		{
			this.viewOffensePage.getLblOffenseSearchStatus().setText("");
			
			DefaultTableModel defaultTableModel;
			
			defaultTableModel = (DefaultTableModel) this.viewOffensePage.getOffenseTable().getModel();
			
			Offense offense = new Offense();
			
			if(!this.viewOffensePage.getChbxViewAll().isSelected())
			{
				if(!this.viewOffensePage.getTxtOffenseCode().getText().trim().isEmpty())
				{
					offense.setOffenseCode(Integer.parseInt(this.viewOffensePage.getTxtOffenseCode().getText().trim()));
				}
				else
				{
					offense.setOffenseCode(null);
				}
				
				if(!this.viewOffensePage.getTxtOffenseName().getText().trim().isEmpty())
				{
					offense.setOffenceName(this.viewOffensePage.getTxtOffenseName().getText().trim());
				}
				else
				{
					offense.setOffenceName(null);
				}
			}
			else
			{
				offense.setOffenceName(null);
				offense.setOffenseCode(null);
			}
			
			try 
			{
				SqlProvider sqlProvider = new SqlProvider();
				Vector<Offense> offenses = sqlProvider.getOffenses(offense.getOffenseCode(),offense.getOffenceName());
				System.out.println("Server Received Data:"+offenses.size());
				
				if(offenses!=null)
				{
					if(!offenses.isEmpty())
					{
						Iterator itr = offenses.iterator();
						
						Offense offenseRow;
						
						defaultTableModel.setRowCount(0);
						
						while(itr.hasNext())
						{	
							offenseRow = (Offense) itr.next();
							
							Vector rowData = new Vector();
							
							//System.out.println("Tickets Number: "+ offenderRow.getTrnNumber());
							
							rowData.add(offenseRow.getOffenseCode());
						
							rowData.add(offenseRow.getOffenceName());
							
							rowData.add(offenseRow.getDescription());
							
							defaultTableModel.addRow(rowData);
							rowData = null;
						}
					}
					else
					{
						
						defaultTableModel.setRowCount(0);
						this.viewOffensePage.getLblOffenseSearchStatus().setForeground(Color.decode("#3300ff"));
						this.viewOffensePage.getLblOffenseSearchStatus().setText("Offense record was not found.");
						//defaultTableModel.getDataVector().removeAllElements();
					}
				}
				else
				{
					
					defaultTableModel.setRowCount(0);
					this.viewOffensePage.getLblOffenseSearchStatus().setForeground(Color.decode("#3300ff"));
					this.viewOffensePage.getLblOffenseSearchStatus().setText("Offense record was not found.");
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

	@SuppressWarnings("static-access")
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("chbxViewAll"))
		{
			if(e.getStateChange() == e.SELECTED)
			{
				this.viewOffensePage.getTxtOffenseCode().setEnabled(false);
				this.viewOffensePage.getTxtOffenseName().setEnabled(false);
			}
			else
			{
				this.viewOffensePage.getTxtOffenseCode().setEnabled(true);
				this.viewOffensePage.getTxtOffenseName().setEnabled(true);	
			}
		}
		
	}
	
}