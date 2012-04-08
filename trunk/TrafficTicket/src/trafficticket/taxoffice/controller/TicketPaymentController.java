package trafficticket.taxoffice.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.Payment;
import extension.model.ServiceRequest;
import extension.model.TaxOfficer;
import extension.model.Ticket;

import trafficticket.controller.ConnectionController;
import trafficticket.taxoffice.view.TaxFrame;
import trafficticket.taxoffice.view.TicketPayment;
import trafficticket.view.MasterFrame;

public class TicketPaymentController implements ActionListener, DocumentListener
{
	private TicketPayment ticketPaymentPage;
	private String eventSource;
	
	public TicketPaymentController(TicketPayment issueTicketPage,String eventSource)
	{
		this.ticketPaymentPage = issueTicketPage;
		this.eventSource = eventSource;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnSearchTicket"))
		{
			
			Ticket targetTicket = new Ticket();
			
			targetTicket.setTicketNumber(Integer.parseInt(this.ticketPaymentPage.getTxtSearchTicketNumber().getText().trim()));
			
			ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_TICKET);
			serviceRequest.getData().add(targetTicket);
		
			ConnectionController connectionController = new ConnectionController(serviceRequest);
			
			try 
			{
				connectionController.submitRequest();
				
				this.resetIssueTicket();
				
				if(connectionController.isDialogSuccess())	
				{
					this.ticketPaymentPage.getLblTicketSearchStatus().setText("");
					
					if(!connectionController.getSuccessServiceResponse().getData().isEmpty())	
					{
						Ticket foundTicket = (Ticket) connectionController.getSuccessServiceResponse().getData().firstElement();
						if(foundTicket != null)	
						{
							this.ticketPaymentPage.getPnlOffenderSummary().setVisible(true);
							this.ticketPaymentPage.getPnlOffensePlaceSummary().setVisible(true);
							this.ticketPaymentPage.getPnlPoliceSummary().setVisible(true);
							this.ticketPaymentPage.getPnlTicketDetails().setVisible(true);
							this.ticketPaymentPage.getPnlButtonPanel().setVisible(true);
							
							//ticket summary
							this.ticketPaymentPage.getTxtTicketNumber().setText(String.valueOf(foundTicket.getTicketNumber()));
							this.ticketPaymentPage.getTxtOffenseCode().setText(String.valueOf(foundTicket.getOffense().getOffenseCode()));
							this.ticketPaymentPage.getTxtOffenseName().setText(foundTicket.getOffense().getOffenceName());
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
							
							this.ticketPaymentPage.getTxtOffenseDate().setText(dateFormat.format(foundTicket.getOffenseDate()));
							this.ticketPaymentPage.getTxtFine().setText(String.valueOf(foundTicket.getFine()));
							this.ticketPaymentPage.getTxtTicketPoints().setText(String.valueOf(foundTicket.getPoints()));
							this.ticketPaymentPage.getTxtTicketDescription().setText(foundTicket.getDescription());
							
							//issued to
							this.ticketPaymentPage.getTxtOffenderTrn().setText(String.valueOf(foundTicket.getOffender().getTrnNumber()));
							this.ticketPaymentPage.getTxtOffenderFirstName().setText(foundTicket.getOffender().getFirstName());
							this.ticketPaymentPage.getTxtOffenderLastName().setText(foundTicket.getOffender().getLastName());
							this.ticketPaymentPage.getTxtOffenderMiddleInitial().setText(foundTicket.getOffender().getMiddleInitial());
							this.ticketPaymentPage.getTxtOffenderLicensePoints().setText(String.valueOf(foundTicket.getOffender().getPoints()));
							
							//issued by
							this.ticketPaymentPage.getTxtDivision().setText(String.valueOf(foundTicket.getPolice().getDivision().getStationNumber()));
							this.ticketPaymentPage.getTxtBadgeNumber().setText(foundTicket.getPolice().getBadgeNumber());
							this.ticketPaymentPage.getTxtPoliceFirstName().setText(foundTicket.getPolice().getFirstName());
							this.ticketPaymentPage.getTxtPoliceLastName().setText(foundTicket.getPolice().getLastName());
							
							
							//issued at
							this.ticketPaymentPage.getTxtTicketAddress1().setText(foundTicket.getOffensePlace().getAddress1());
							this.ticketPaymentPage.getTxtTicketAddress2().setText(foundTicket.getOffensePlace().getAddress2());
							this.ticketPaymentPage.getTxtTicketParish().setText(foundTicket.getOffensePlace().getParish());
							
							if(foundTicket.getPaymentStatus()==0)
							{
								this.ticketPaymentPage.getLblTicketSearchStatus().setText("");
								this.ticketPaymentPage.getBtnPayTicket().setEnabled(true);
							}
							else
							{
								this.ticketPaymentPage.getLblTicketSearchStatus().setForeground(Color.BLUE);
								this.ticketPaymentPage.getLblTicketSearchStatus().setFont(new Font("Comic Sans MS",Font.BOLD,20));
								this.ticketPaymentPage.getLblTicketSearchStatus().setText("This ticket is already paid.");
								this.ticketPaymentPage.getBtnPayTicket().setEnabled(false);
							}
						}
						else
						{
							this.ticketPaymentPage.getLblTicketSearchStatus().setForeground(Color.RED);
							this.ticketPaymentPage.getLblTicketSearchStatus().setText("Error occured while attemping to load the ticket information.");
						}
					}
					else
					{
						this.ticketPaymentPage.getLblTicketSearchStatus().setForeground(Color.RED);
						this.ticketPaymentPage.getLblTicketSearchStatus().setText("Ticket was not found. Try searching again.");
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
		else  if(this.eventSource.equalsIgnoreCase("btnPayTicket"))
		{
			TaxOfficer paymentOfficer = new TaxOfficer();
			Payment ticketPayment = new Payment();
			Ticket targetTicket = new Ticket();
			
			MasterFrame parentFrame = (TaxFrame)this.ticketPaymentPage.getTopLevelAncestor();
			
			if(parentFrame != null)
			{
				paymentOfficer.setIdNumber(parentFrame.getCurrentUser().getHandle());
				
				targetTicket.setTicketNumber(Integer.parseInt(this.ticketPaymentPage.getTxtSearchTicketNumber().getText().trim()));
				
				ticketPayment.setAmount(Float.parseFloat(this.ticketPaymentPage.getTxtFine().getText().trim()));
				
				ticketPayment.setTicket(targetTicket);
				
				paymentOfficer.getPayments().add(ticketPayment);
				
				ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.PAY_TICKET);
				
				serviceRequest.getData().add(paymentOfficer);
			
				ConnectionController connectionController = new ConnectionController(serviceRequest);
				
				try 
				{
					connectionController.submitRequest();
					
					if(connectionController.isDialogSuccess())	
					{
						switch(connectionController.getSuccessServiceResponse().getStatus())
						{
							case 0:
							break;
							case 1:
								JOptionPane.showMessageDialog(this.ticketPaymentPage, "The ticket was paid successfully.","Tax Ticket: payment success",JOptionPane.PLAIN_MESSAGE,new ImageIcon(TicketPaymentController.class.getResource("/trafficticket/resources/paidIcon_32x32.png")));
								this.resetIssueTicket();
							break;
							case -1:
							break;
							case -2:
							break;
							case -3:
							break;
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
					JOptionPane.showMessageDialog(this.ticketPaymentPage, "An unexpected error occured. The Ticket could not be paid. [0x12]","Tax Ticket: payment failed",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(this.ticketPaymentPage, "An unexpected error occured. The Ticket could not be paid.[0x1a","Tax Ticket: payment failed",JOptionPane.ERROR_MESSAGE);
			}
		}
		else  if(e.getSource()==this.ticketPaymentPage.getBtnReset())
		{
			this.resetIssueTicket();
		}
	}
	
	public void resetIssueTicket()
	{
		this.ticketPaymentPage.getPnlOffenderSummary().setVisible(false);
		this.ticketPaymentPage.getPnlOffensePlaceSummary().setVisible(false);
		this.ticketPaymentPage.getPnlPoliceSummary().setVisible(false);
		this.ticketPaymentPage.getPnlTicketDetails().setVisible(false);
		this.ticketPaymentPage.getPnlButtonPanel().setVisible(false);
		
		this.ticketPaymentPage.getTxtBadgeNumber().setText("");
		this.ticketPaymentPage.getTxtDivision().setText("");
		this.ticketPaymentPage.getTxtFine().setText("");
		this.ticketPaymentPage.getTxtOffenderFirstName().setText("");
		this.ticketPaymentPage.getTxtOffenderLastName().setText("");
		this.ticketPaymentPage.getTxtOffenderMiddleInitial().setText("");
		this.ticketPaymentPage.getTxtOffenderLicensePoints().setText("");
		this.ticketPaymentPage.getTxtOffenderTrn().setText("");
		this.ticketPaymentPage.getTxtOffenseCode().setText("");
		this.ticketPaymentPage.getTxtOffenseDate().setText("");
		this.ticketPaymentPage.getTxtOffenseName().setText("");
		
		this.ticketPaymentPage.getTxtPoliceFirstName().setText("");
		this.ticketPaymentPage.getTxtPoliceLastName().setText("");
		this.ticketPaymentPage.getTxtSearchTicketNumber().setText("");
		
		this.ticketPaymentPage.getTxtTicketAddress1().setText("");
		this.ticketPaymentPage.getTxtTicketAddress2().setText("");
		this.ticketPaymentPage.getTxtTicketDescription().setText("");
		this.ticketPaymentPage.getTxtTicketNumber().setText("");
		this.ticketPaymentPage.getTxtTicketParish().setText("");
		this.ticketPaymentPage.getTxtTicketPoints().setText("");
	}
	

	@Override
	public void changedUpdate(DocumentEvent e) 
	{
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnSearchTicket"))
		{

		}
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnSearchTicket"))
		{
			
		}		
	}
	
}