package trafficticket.taxoffice.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.ServiceRequest;
import extension.model.Ticket;

import trafficticket.controller.ConnectionController;
import trafficticket.taxoffice.view.TicketPayment;

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
				
				if(connectionController.isDialogSuccess())	
				{
					this.ticketPaymentPage.getLblTicketSearchStatus().setText("");
					
					Ticket foundTicket = (Ticket) connectionController.getSuccessServiceResponse().getData().firstElement();
					
					if(foundTicket != null)
					{
						this.ticketPaymentPage.getTxtTicketNumber().setText(String.valueOf(foundTicket.getTicketNumber()));
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