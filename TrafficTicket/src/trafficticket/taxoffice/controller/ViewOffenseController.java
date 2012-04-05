package trafficticket.taxoffice.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.ViewOffender;
import trafficticket.jcf.view.ViewOffense;
import extension.model.Offender;
import extension.model.Offense;
import extension.model.ServiceRequest;

public class ViewOffenseController implements ActionListener, ItemListener, DocumentListener
{
	private ViewOffense viewOffensePage;
	private String eventSource;
	
	public ViewOffenseController(ViewOffense viewOffensePage,String eventSource)
	{
		this.viewOffensePage = viewOffensePage;
		this.eventSource = eventSource;
	}
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
			
			ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_OFFENSES);
			
			serviceRequest.getData().add(offense);
	
			ConnectionController connectionController = new ConnectionController(serviceRequest);
			
			try 
			{
				connectionController.submitRequest();
				if(connectionController.isDialogSuccess())
				{
					if(connectionController.getSuccessServiceResponse().getData()!=null)
					{
						if(!connectionController.getSuccessServiceResponse().getData().isEmpty())
						{
							System.out.println("Offense Found:"+connectionController.getSuccessServiceResponse().getData().size());
							
							Iterator itr = connectionController.getSuccessServiceResponse().getData().iterator();
							
							Offense offenseRow;
							
							defaultTableModel.setRowCount(0);
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
							
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
			} 
			catch (NumberFormatException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (UnknownHostException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (ClassNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (SAXException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (ParserConfigurationException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
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