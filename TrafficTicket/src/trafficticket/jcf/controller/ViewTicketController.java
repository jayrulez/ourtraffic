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

import extension.model.Offender;
import extension.model.ServiceRequest;
import extension.model.Ticket;

import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.ViewTicket;

public class ViewTicketController implements ActionListener, ItemListener, DocumentListener
{
	private ViewTicket viewTicketPage;
	private String eventSource;
	
	public ViewTicketController(ViewTicket viewTicketPage,String eventSource)
	{
		this.setViewTicketPage(viewTicketPage);
		this.eventSource = eventSource;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnRunView"))
		{
			if(this.viewTicketPage.isViewTicketFormValid())
			{
				this.viewTicketPage.getLblSearchTicketStatus().setText("");
				
				DefaultTableModel defaultTableModel;
				
				defaultTableModel = (DefaultTableModel) this.viewTicketPage.getTblTicketResults().getModel();
				
				Ticket ticket = new Ticket();
				Offender offender = new Offender();
				
				if(!this.viewTicketPage.getChbxViewAll().isSelected())
				{
					if(!this.viewTicketPage.getTxtOffenderTrn().getText().trim().isEmpty())
					{
						offender.setTrnNumber(Integer.parseInt(this.viewTicketPage.getTxtOffenderTrn().getText().trim()));
					}
					else
					{
						offender.setTrnNumber(null);
					}
					
					if(!this.viewTicketPage.getTxtTicketNumber().getText().trim().isEmpty())
					{
						ticket.setTicketNumber(Integer.parseInt(this.viewTicketPage.getTxtTicketNumber().getText().trim()));
					}
					else
					{
						ticket.setTicketNumber(null);
					}
					
					if(this.viewTicketPage.getChckbxUnpaid().isSelected() && this.viewTicketPage.getChckbxPaid().isSelected())
					{
						ticket.setPaymentStatus(null);
					}
					else
					{
						if(this.viewTicketPage.getChckbxPaid().isSelected())
						{
							ticket.setPaymentStatus(1);
						}
						
						else if(this.viewTicketPage.getChckbxUnpaid().isSelected())
						{
							ticket.setPaymentStatus(0);
						}
						else if(this.viewTicketPage.getChckbxUnpaid().isSelected() && this.viewTicketPage.getChckbxPaid().isSelected())
						{
							ticket.setPaymentStatus(null);
						}
						else
						{
							ticket.setPaymentStatus(null);
						}
					}
				}
				else
				{
					offender.setTrnNumber(null);
					ticket.setTicketNumber(null);
					ticket.setPaymentStatus(null);
				}
				
				ticket.setOffender(offender);
				
				ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_TICKETS);
				serviceRequest.getData().add(ticket);
		
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
								System.out.println("Tickets Found:"+connectionController.getSuccessServiceResponse().getData().size());
								
								Iterator itr = connectionController.getSuccessServiceResponse().getData().iterator();
								
								Ticket ticketRow;
								
								defaultTableModel.setRowCount(0);
								
								SimpleDateFormat dateFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
								
								while(itr.hasNext())
								{
									
									ticketRow = (Ticket) itr.next();
									
									Vector rowData = new Vector();
									System.out.println("Tickets Number: "+ ticketRow.getTicketNumber());
									rowData.add(ticketRow.getTicketNumber());
									if(ticketRow.getPaymentStatus()==1)
									{
										rowData.add("Paid");
									}
									else if(ticketRow.getPaymentStatus()==0)
									{
										rowData.add("unPaid");
									}
										
									rowData.add(ticketRow.getOffender().getTrnNumber());
									rowData.add(ticketRow.getOffender().getFirstName()+ " " + ticketRow.getOffender().getMiddleInitial() + " " +ticketRow.getOffender().getLastName());
									
									rowData.add(dateFormat.format(ticketRow.getOffenseDate()));
									rowData.add(ticketRow.getFine());
									rowData.add(ticketRow.getPoints());
									
									defaultTableModel.addRow(rowData);
									rowData = null;
								}
							}
							else
							{
								
								defaultTableModel.setRowCount(0);
								this.viewTicketPage.getLblSearchTicketStatus().setForeground(Color.decode("#3300ff"));
								this.viewTicketPage.getLblSearchTicketStatus().setText("Ticket record was not found.");
								//defaultTableModel.getDataVector().removeAllElements();
							}
						}
						else
						{				
							defaultTableModel.setRowCount(0);
							this.viewTicketPage.getLblSearchTicketStatus().setForeground(Color.decode("#3300ff"));
							this.viewTicketPage.getLblSearchTicketStatus().setText("Ticket record was not found.");
							
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
					this.viewTicketPage.getLblSearchTicketStatus().setForeground(Color.RED);
					this.viewTicketPage.getLblSearchTicketStatus().setText("Error: Could not contact the server.");
					e1.printStackTrace();
				} 
				catch (ClassNotFoundException e1) 
				{
					this.viewTicketPage.getLblSearchTicketStatus().setForeground(Color.RED);
					this.viewTicketPage.getLblSearchTicketStatus().setText("Error: An unexpected error occurred.");
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
			else
			{
				this.viewTicketPage.getLblSearchTicketStatus().setForeground(Color.RED);
				this.viewTicketPage.getLblSearchTicketStatus().setText("Please select a search criteria.");
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
	public ViewTicket getViewTicketPage() 
	{
		return viewTicketPage;
	}
	public void setViewTicketPage(ViewTicket viewTicketPage) 
	{
		this.viewTicketPage = viewTicketPage;
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("chbxViewAll"))
		{
			if(e.getStateChange() == e.SELECTED)
			{
				this.viewTicketPage.getChckbxPaid().setEnabled(false);
				this.viewTicketPage.getChckbxUnpaid().setEnabled(false);
				this.viewTicketPage.getTxtOffenderTrn().setEnabled(false);
				this.viewTicketPage.getTxtTicketNumber().setEnabled(false);
			}
			else
			{
				this.viewTicketPage.getChckbxPaid().setEnabled(true);
				this.viewTicketPage.getChckbxUnpaid().setEnabled(true);
				this.viewTicketPage.getTxtOffenderTrn().setEnabled(true);
				this.viewTicketPage.getTxtTicketNumber().setEnabled(true);			
			}
		}
		
	}
	
}