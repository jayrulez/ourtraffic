package trafficticket.jcf.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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

import extension.model.Address;
import extension.model.Offender;
import extension.model.Offense;
import extension.model.Police;
import extension.model.ServiceRequest;
import extension.model.Ticket;

import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.IssueTicket;
import trafficticket.jcf.view.JCFFrame;

public class IssueTicketController implements ActionListener, ItemListener, DocumentListener
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
			Offender targetOffender = new Offender();
			
			targetOffender.setTrnNumber(Integer.parseInt(this.issueTicketPage.getTxtSearchOffenderTrn().getText().trim()));
			
			ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_OFFENDER);
			serviceRequest.getData().add(targetOffender);
		
			ConnectionController connectionController = new ConnectionController(serviceRequest);
			
			try 
			{
				connectionController.submitRequest();
				if(connectionController.isDialogSuccess())
				{
					if(connectionController.getSuccessServiceResponse().getData().isEmpty())
					{
						this.issueTicketPage.getLblSearchOffenderStatus().setVisible(true);
						this.issueTicketPage.getLblSearchOffenderStatus().setForeground(Color.RED);
						this.issueTicketPage.getLblSearchOffenderStatus().setText("Offender \"" + this.issueTicketPage.getTxtSearchOffenderTrn().getText().trim() + "\" does not Exist");
					}
					else
					{
						this.issueTicketPage.getLblSearchOffenderStatus().setText("");
						this.issueTicketPage.getLblSearchOffenderStatus().setVisible(false);
						try
						{
							Offender foundOffender = (Offender) connectionController.getSuccessServiceResponse().getData().firstElement();
							
							if(foundOffender != null)
							{
								this.issueTicketPage.getLblExistingOffenderTrnValue().setText(String.valueOf(foundOffender.getTrnNumber()));
								this.issueTicketPage.getLblExistingFirstNameValue().setText(foundOffender.getFirstName());
								this.issueTicketPage.getLblExistingLastNameValue().setText(foundOffender.getLastName());
								this.issueTicketPage.getLblExistingMiddleInitialValue().setText(foundOffender.getMiddleInitial());
								
								SimpleDateFormat dobFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
								
								this.issueTicketPage.getLblExistingDobValue().setText(dobFormat.format(foundOffender.getDob()));
								this.issueTicketPage.getTxtExistingAddress1().setText(foundOffender.getAddress().getAddress1());
								this.issueTicketPage.getTxtExistingAddress2().setText(foundOffender.getAddress().getAddress2());
								this.issueTicketPage.getLblExistingParishValue().setText(foundOffender.getAddress().getParish());
								
								this.issueTicketPage.getLblExistingLicenseTypeValue().setText(foundOffender.getLicenseType());
								this.issueTicketPage.getLblExistingPointsValue().setText(String.valueOf(foundOffender.getPoints()));
								
								SimpleDateFormat expiryDateFormat = new SimpleDateFormat("d'-'MMM'-'yyyy");
								this.issueTicketPage.getLblExistingExpiryDateValue().setText(expiryDateFormat.format(foundOffender.getExpiryDate()));
								
								this.issueTicketPage.getExistingOffenderPanel().setVisible(true);
							}
							else
							{
								this.issueTicketPage.getLblSearchOffenderStatus().setVisible(true);
								this.issueTicketPage.getLblSearchOffenderStatus().setForeground(Color.RED);
								this.issueTicketPage.getLblSearchOffenderStatus().setText("Offender \"" + this.issueTicketPage.getTxtSearchOffenderTrn().getText().trim() + "\" does not Exist");
							}
						}
						catch(ClassCastException ex)
						{
							this.issueTicketPage.getLblSearchOffenderStatus().setVisible(true);
							this.issueTicketPage.getLblSearchOffenderStatus().setForeground(Color.RED);
							this.issueTicketPage.getLblSearchOffenderStatus().setText("Unexpected error occured while rendering the offender data.");
						}
					}
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
		else  if(this.eventSource.equalsIgnoreCase("btnIssueTicket"))
		{
			ServiceRequest serviceRequest = null;
			Ticket ticket = null;
			Offense offense = null;		
			Police police = null;
			
			JCFFrame parentFrame = (JCFFrame)this.issueTicketPage.getTopLevelAncestor();
			
			//public Offender(Integer trnNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish,String licenseType,Integer points, Date expiryDate) 
			if(this.issueTicketPage.getChbxNewOffender().isSelected())
			{
				Offender offender = new Offender(Integer.parseInt(this.issueTicketPage.getTxtOffenderTrn().getText().trim()),this.issueTicketPage.getTxtFirstName().getText().trim(),this.issueTicketPage.getTxtLastName().getText().trim(),this.issueTicketPage.getTxtMiddleInitial().getText().trim(),this.issueTicketPage.getOffenderDobChooser().getDate(),this.issueTicketPage.getTxtAddress1().getText().trim(),this.issueTicketPage.getTxtAddress2().getText().trim(),(String)this.issueTicketPage.getCmbxOffenderParish().getSelectedItem(),(String)this.issueTicketPage.getCmbxLicenseType().getSelectedItem(),Integer.parseInt(this.issueTicketPage.getTxtPoints().getText().trim()),this.issueTicketPage.getExpiryDateChooser().getDate());
				ticket = new Ticket();
				offense = new Offense();
				police = new Police();
				
				if(parentFrame != null)
				{
					police.setBadgeNumber(parentFrame.getCurrentUser().getHandle());
				}
				ticket.setPolice(police);
				offense.setOffenseCode(Integer.parseInt(Offense.extractCode(this.issueTicketPage.getCmbxOffense().getSelectedItem().toString())));
				
				ticket.setDescription(this.issueTicketPage.getTxtTicketAddress1().getText().trim());
				ticket.setFine(Float.parseFloat(this.issueTicketPage.getTxtTicketFine().getText().trim()));
				
				ticket.setOffender(offender);
				ticket.setOffense(offense);
				
				ticket.setOffenseDate(this.issueTicketPage.getOffenseDateChooser().getDate());
				ticket.setOffensePlace(new Address(this.issueTicketPage.getTxtTicketAddress1().getText().trim(),this.issueTicketPage.getTxtTicketAddress2().getText().trim(),(String)this.issueTicketPage.getCmbxTicketParish().getSelectedItem()));
				ticket.setPoints(Integer.parseInt(this.issueTicketPage.getTxtTicketPoints().getText().trim()));
				
				serviceRequest = new ServiceRequest(ServiceRequest.ISSUE_TICKET_NEW_OFFENDER);
				
				serviceRequest.getData().add(ticket);
			}
			else
			{
				Offender offender = new Offender();
				offender.setTrnNumber(Integer.parseInt(this.issueTicketPage.getLblExistingOffenderTrnValue().getText().trim()));
				
				ticket = new Ticket();
				offense = new Offense();
				police = new Police();
				
				if(parentFrame != null)
				{
					System.out.println("Police User:" + parentFrame.getCurrentUser().getFirstName());
					police.setBadgeNumber(parentFrame.getCurrentUser().getHandle());
				}
				ticket.setPolice(police);
				offense.setOffenseCode(Integer.parseInt(Offense.extractCode(this.issueTicketPage.getCmbxOffense().getSelectedItem().toString())));
				
				ticket.setDescription(this.issueTicketPage.getTxtTicketAddress1().getText().trim());
				ticket.setFine(Float.parseFloat(this.issueTicketPage.getTxtTicketFine().getText().trim()));
				
				ticket.setOffender(offender);
				ticket.setOffense(offense);
				
				ticket.setOffenseDate(this.issueTicketPage.getOffenseDateChooser().getDate());
				ticket.setOffensePlace(new Address(this.issueTicketPage.getTxtTicketAddress1().getText().trim(),this.issueTicketPage.getTxtTicketAddress2().getText().trim(),(String)this.issueTicketPage.getCmbxTicketParish().getSelectedItem()));
				ticket.setPoints(Integer.parseInt(this.issueTicketPage.getTxtTicketPoints().getText().trim()));
				
				serviceRequest = new ServiceRequest(ServiceRequest.ISSUE_TICKET_EXISTING_OFFENDER);
				serviceRequest.getData().add(ticket);
			}

			ConnectionController connectionController = new ConnectionController(serviceRequest);
			
			try 
			{
				connectionController.submitRequest();
				if(connectionController.isDialogSuccess())
				{
					if(connectionController.getSuccessServiceResponse().getStatus()==1)
					{
						if(!this.issueTicketPage.getExistingOffenderPanel().isVisible())
						{
							JOptionPane.showMessageDialog(this.issueTicketPage, "Ticket was issued to: " + this.issueTicketPage.getTxtFirstName().getText().trim() + " " + this.issueTicketPage.getTxtLastName().getText().trim(),"Issue Ticket: success",JOptionPane.DEFAULT_OPTION,new ImageIcon(IssueTicketController.class.getResource("/trafficticket/resources/successIcon_32x32.png")));
							this.resetIssueTicket();
						}
						else
						{
							JOptionPane.showMessageDialog(this.issueTicketPage, "Ticket was issued to: " + this.issueTicketPage.getLblExistingFirstNameValue().getText().trim() + " " + this.issueTicketPage.getLblExistingLastNameValue().getText().trim(),"Issue Ticket: success",JOptionPane.DEFAULT_OPTION,new ImageIcon(IssueTicketController.class.getResource("/trafficticket/resources/successIcon_32x32.png")));
						}
					}
					else
					{
						if(!this.issueTicketPage.getExistingOffenderPanel().isVisible())
						{
							JOptionPane.showMessageDialog(this.issueTicketPage,"Failed to issue ticket to "+ "\""+ this.issueTicketPage.getTxtFirstName().getText().trim() +" "+this.issueTicketPage.getTxtLastName().getText().trim() +"\". Please Try again." ,"Issue Ticket: failed",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(this.issueTicketPage,"Failed to issue ticket to "+ "\""+ this.issueTicketPage.getLblExistingFirstNameValue().getText().trim() +" "+this.issueTicketPage.getLblExistingLastNameValue().getText().trim() +"\". Please Try again." ,"Issue Ticket: failed",JOptionPane.ERROR_MESSAGE);
						}
					}
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
			this.resetIssueTicket();
		}
	}
	
	public void resetIssueTicket()
	{
		this.issueTicketPage.getTxtAddress1().setText("");
		this.issueTicketPage.getTxtAddress2().setText("");
		this.issueTicketPage.getCmbxOffenderParish().setSelectedIndex(0);
		this.issueTicketPage.getTxtFirstName().setText("");
		this.issueTicketPage.getTxtLastName().setText("");
		this.issueTicketPage.getTxtMiddleInitial().setText("");
		this.issueTicketPage.getTxtPoints().setText("");
		this.issueTicketPage.getTxtSearchOffenderTrn().setText("");
		this.issueTicketPage.getCmbxLicenseType().setSelectedIndex(0);
		this.issueTicketPage.getExpiryDateChooser().setDate(null);
		this.issueTicketPage.getOffenderDobChooser().setDate(null);
		
		if(this.issueTicketPage.getExistingOffenderPanel().isVisible())
		{
			this.issueTicketPage.getExistingOffenderPanel().setVisible(false);
		}
		this.issueTicketPage.getTxtExistingAddress1().setText("");
		this.issueTicketPage.getTxtExistingAddress2().setText("");
		this.issueTicketPage.getLblExistingDobValue().setText("");
		this.issueTicketPage.getLblExistingExpiryDateValue().setText("");
		this.issueTicketPage.getLblExistingFirstNameValue().setText("");
		this.issueTicketPage.getLblExistingLastNameValue().setText("");
		this.issueTicketPage.getLblExistingMiddleInitialValue().setText("");
		this.issueTicketPage.getLblExistingLicenseTypeValue().setText("");
		this.issueTicketPage.getLblExistingOffenderTrnValue().setText("");
		this.issueTicketPage.getLblExistingPointsValue().setText("");
		this.issueTicketPage.getLblExistingParishValue().setText("");
		
		this.issueTicketPage.getTxtTicketPoints().setText("");
		this.issueTicketPage.getTxtTicketFine().setText("");
		this.issueTicketPage.getTxtTicketDescription().setText("");
		this.issueTicketPage.getTxtTicketAddress1().setText("");
		this.issueTicketPage.getTxtTicketAddress2().setText("");
		this.issueTicketPage.getOffenseDateChooser().setDate(null);
		this.issueTicketPage.getCmbxOffense().setSelectedIndex(0);
		this.issueTicketPage.getCmbxTicketParish().setSelectedIndex(0);	
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
	@Override
	public void changedUpdate(DocumentEvent e) 
	{
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("txtSearchOffenderTrn"))
		{
			
			if(!this.issueTicketPage.getLblSearchOffenderStatus().getText().isEmpty())
			{
				this.issueTicketPage.getLblSearchOffenderStatus().setText("");
				this.issueTicketPage.getLblSearchOffenderStatus().setVisible(false);
			}
		}
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("txtSearchOffenderTrn"))
		{
			
			if(!this.issueTicketPage.getLblSearchOffenderStatus().getText().isEmpty())
			{
				this.issueTicketPage.getLblSearchOffenderStatus().setText("");
				this.issueTicketPage.getLblSearchOffenderStatus().setVisible(false);
			}
		}		
	}
	
}