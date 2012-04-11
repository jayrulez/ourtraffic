package trafficticket.jcf.controller;

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
import extension.model.Offender;
import extension.model.ServiceRequest;

public class ViewOffenderController implements ActionListener, ItemListener, DocumentListener
{
	private ViewOffender viewOffenderPage;
	private String eventSource;
	
	public ViewOffenderController(ViewOffender viewOffenderPage,String eventSource)
	{
		this.viewOffenderPage = viewOffenderPage;
		this.eventSource = eventSource;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnRunView"))
		{
			this.viewOffenderPage.getLblOffenderSearchStatus().setText("");
			
			DefaultTableModel defaultTableModel;
			
			defaultTableModel = (DefaultTableModel) this.viewOffenderPage.getOffenderTable().getModel();
			
			Offender offender = new Offender();
			
			if(!this.viewOffenderPage.getChbxViewAll().isSelected())
			{
				if(!this.viewOffenderPage.getTxtOffenderFirstName().getText().trim().isEmpty())
				{
					offender.setFirstName(this.viewOffenderPage.getTxtOffenderFirstName().getText().trim());
				}
				else
				{
					offender.setFirstName(null);
				}
				
				if(!this.viewOffenderPage.getTxtOffenderLastName().getText().trim().isEmpty())
				{
					offender.setLastName(this.viewOffenderPage.getTxtOffenderLastName().getText().trim());
				}
				else
				{
					offender.setLastName(null);
				}
			}
			else
			{
				offender.setTrnNumber(null);
				offender.setFirstName(null);
				offender.setLastName(null);
			}
			
			ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_OFFENDERS);
			
			serviceRequest.getData().add(offender);
	
			ConnectionController connectionController = new ConnectionController(serviceRequest);
			
			try 
			{
				System.out.println("HELLO");
				connectionController.submitRequest();
				if(connectionController.isDialogSuccess())
				{
					if(connectionController.getSuccessServiceResponse().getData()!=null)
					{
						if(!connectionController.getSuccessServiceResponse().getData().isEmpty())
						{
							System.out.println("OffenderFound:"+connectionController.getSuccessServiceResponse().getData().size());
							
							Iterator itr = connectionController.getSuccessServiceResponse().getData().iterator();
							
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
								
								rowData.add(offenderRow.getLicenseType());
								
								rowData.add(dateFormat.format(offenderRow.getPoints()));
								
								defaultTableModel.addRow(rowData);
								rowData = null;
							}
						}
						else
						{
							
							defaultTableModel.setRowCount(0);
							this.viewOffenderPage.getLblOffenderSearchStatus().setForeground(Color.decode("#3300ff"));
							this.viewOffenderPage.getLblOffenderSearchStatus().setText("Offender record was not found.");
							//defaultTableModel.getDataVector().removeAllElements();
						}
					}
					else
					{				
						defaultTableModel.setRowCount(0);
						this.viewOffenderPage.getLblOffenderSearchStatus().setForeground(Color.decode("#3300ff"));
						this.viewOffenderPage.getLblOffenderSearchStatus().setText("Offender record was not found.");
						
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
				this.viewOffenderPage.getTxtOffenderFirstName().setEnabled(false);
				this.viewOffenderPage.getTxtOffenderLastName().setEnabled(false);
				this.viewOffenderPage.getTxtOffenderTrn().setEnabled(false);
			}
			else
			{
				this.viewOffenderPage.getTxtOffenderFirstName().setEnabled(true);
				this.viewOffenderPage.getTxtOffenderLastName().setEnabled(true);
				this.viewOffenderPage.getTxtOffenderTrn().setEnabled(true);		
			}
		}
		
	}
	
}