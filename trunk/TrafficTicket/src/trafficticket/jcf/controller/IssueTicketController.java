package trafficticket.jcf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.Address;
import extension.model.Offender;
import extension.model.Offense;
import extension.model.ServiceRequest;
import extension.model.Ticket;

import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.IssueTicket;
import trafficticket.jcf.view.JCFFrame;

public class IssueTicketController implements ActionListener, ItemListener
{
	private IssueTicket issueTicketPage;
	private String eventSource;
	
	public IssueTicketController(IssueTicket issueTicketPage,String eventSource)
	{
		this.issueTicketPage = issueTicketPage;
		this.eventSource = eventSource;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnSearchOffender"))
		{
			
		}
		else  if(this.eventSource.equalsIgnoreCase("btnIssueTicket"))
		{
			ServiceRequest serviceRequest = null;
			Ticket ticket = null;
			Offense offense = null;		
			
			//public Offender(Integer trnNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish,String licenseType,Integer points, Date expiryDate) 
			if(this.issueTicketPage.getChbxNewOffender().isSelected())
			{
				Offender offender = new Offender(Integer.parseInt(this.issueTicketPage.getTxtOffenderTrn().getText().trim()),this.issueTicketPage.getTxtFirstName().getText().trim(),this.issueTicketPage.getTxtLastName().getText().trim(),this.issueTicketPage.getTxtMiddleInitial().getText().trim(),this.issueTicketPage.getExistingOffenderDobChooser().getDate(),this.issueTicketPage.getTxtAddress1().getText().trim(),this.issueTicketPage.getTxtAddress2().getText().trim(),(String)this.issueTicketPage.getCmbxOffenderParish().getSelectedItem(),(String)this.issueTicketPage.getCmbxLicenseType().getSelectedItem(),Integer.parseInt(this.issueTicketPage.getTxtPoints().getText().trim()),this.issueTicketPage.getExpiryDateChooser().getDate());
				ticket = new Ticket();
				offense = new Offense();
				
				ticket.setDescription(this.issueTicketPage.getTxtTicketAddress1().getText().trim());
				ticket.setFine(Float.parseFloat(this.issueTicketPage.getTxtTicketFine().getText().trim()));
				
				ticket.setOffender(offender);
				ticket.setOffense(offense);
				
				ticket.setOffenseDate(this.issueTicketPage.getOffenseDateChooser().getDate());
				ticket.setOffensePlace(new Address(this.issueTicketPage.getTxtTicketAddress1().getText().trim(),this.issueTicketPage.getTxtTicketAddress2().getText().trim(),(String)this.issueTicketPage.getCmbxTicketParish().getSelectedItem()));
				ticket.setPoints(Integer.parseInt(this.issueTicketPage.getTxtTicketPoints().getText().trim()));
				
				serviceRequest = new ServiceRequest(ServiceRequest.ISSUE_TICKET_NEW_OFFENDER);
			}
			else
			{
				Offender offender = new Offender();
				offender.setTrnNumber(Integer.parseInt(this.issueTicketPage.getLblExistingOffenderTrnValue().getText().trim()));
				
				ticket = new Ticket();
				offense = new Offense();
				
				ticket.setDescription(this.issueTicketPage.getTxtTicketAddress1().getText().trim());
				ticket.setFine(Float.parseFloat(this.issueTicketPage.getTxtTicketFine().getText().trim()));
				
				ticket.setOffender(offender);
				ticket.setOffense(offense);
				
				ticket.setOffenseDate(this.issueTicketPage.getOffenseDateChooser().getDate());
				ticket.setOffensePlace(new Address(this.issueTicketPage.getTxtTicketAddress1().getText().trim(),this.issueTicketPage.getTxtTicketAddress2().getText().trim(),(String)this.issueTicketPage.getCmbxTicketParish().getSelectedItem()));
				ticket.setPoints(Integer.parseInt(this.issueTicketPage.getTxtTicketPoints().getText().trim()));
				
				serviceRequest = new ServiceRequest(ServiceRequest.ISSUE_TICKET_EXISTING_OFFENDER);
			}

			ConnectionController connectionController = new ConnectionController(serviceRequest);
			
			try 
			{
				connectionController.submitRequest();
				if(connectionController.isDialogSuccess())
				{
					
				}
			} 
			catch (SAXException ex) 
			{
				JOptionPane.showMessageDialog((JCFFrame)this.issueTicketPage.getTopLevelAncestor(), "Could not connect to sever. Please Check your configuration setting.","JCF Traffic: Configuration Error",JOptionPane.ERROR_MESSAGE);
			} 
			catch (IOException ex) 
			{
				if(ex.getMessage().equalsIgnoreCase("config file"))
				{
					JOptionPane.showMessageDialog((JCFFrame)this.issueTicketPage.getTopLevelAncestor(), "Error: Configuration file could not be read.","JCF Traffic: Configuration",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog((JCFFrame)this.issueTicketPage.getTopLevelAncestor(), "Error: Could not contact Server.","JCF Traffic: Server Connection",JOptionPane.ERROR_MESSAGE);
				}
			} 
			catch (ParserConfigurationException ex) 
			{

				JOptionPane.showMessageDialog((JCFFrame)this.issueTicketPage.getTopLevelAncestor(), "Could not connect to sever. Please Check your configuration setting.","JCF Traffic: Configuration",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog((JCFFrame)this.issueTicketPage.getTopLevelAncestor(), "Could not connect to sever. Incorrect configuation connection setting.","JCF Traffic: Configuration",JOptionPane.ERROR_MESSAGE);
			} 
			catch (ClassNotFoundException ex) 
			{
				JOptionPane.showMessageDialog((JCFFrame)this.issueTicketPage.getTopLevelAncestor(), "Error: Some needed resources are unavailable.","JCF Traffic",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(this.eventSource.equalsIgnoreCase("btnResetIssueTicket"))
		{
			
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		if(this.eventSource.equalsIgnoreCase("chbxNewOffender"))
		{
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				//disable existing offender detail view
				this.issueTicketPage.getExistingOffenderPanel().setVisible(false);
				//enable new offender form
				this.issueTicketPage.getOffenderPanel().setVisible(true);
				
				//disable search tools
				this.issueTicketPage.getTxtSearchOffenderTrn().setEditable(false);
				this.issueTicketPage.getBtnSearchOffender().setEnabled(false);
			}
			else if(e.getStateChange() == ItemEvent.DESELECTED)
			{	
				this.issueTicketPage.getExistingOffenderPanel().setVisible(false);
				this.issueTicketPage.getOffenderPanel().setVisible(false);
				
				//enable search tools
				this.issueTicketPage.getTxtSearchOffenderTrn().setEditable(true);
				this.issueTicketPage.getBtnSearchOffender().setEnabled(true);
			}
		}
	}
	
}