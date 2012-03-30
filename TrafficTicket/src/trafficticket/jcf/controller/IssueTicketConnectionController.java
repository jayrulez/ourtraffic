package trafficticket.jcf.controller;

import java.awt.Color;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.Offense;
import extension.model.ServiceRequest;
import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.IssueTicket;

public class IssueTicketConnectionController implements Runnable
{
	private String component;
	private IssueTicket issueTicketPage;
	
	
	public IssueTicketConnectionController(String component, IssueTicket issueTicketPage) 
	{
		this.component = component;
		this.issueTicketPage = issueTicketPage;
	}
	
	@Override
	public void run()
	{
		switch (this.component)
		{
			case "loadOffenses":
				while(!Thread.interrupted())
				{
					this.loadOffenses();
					try 
					{
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			break;
		}
		
	}

	public void loadOffenses()
	{
		ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_ALL_OFFENSES);
		
		ConnectionController connectionController = new ConnectionController(serviceRequest);
		this.issueTicketPage.getLblOffenseStatus().setText("");
		try 
		{
			connectionController.submitRequest();
			if(connectionController.isDialogSuccess())
			{
				Vector<Offense> offenses;
				
				offenses = (Vector<Offense>) connectionController.getSuccessServiceResponse().getData();
				
				this.issueTicketPage.getCmbxOffense().addItem("Select an offense");
				if(!offenses.isEmpty())
				{
					for(Offense offense:offenses)
					{
						this.issueTicketPage.getCmbxOffense().addItem(offense.getOffenceName());
					}
				}
				connectionController = null;
			}
		} 
		catch (NumberFormatException | ClassNotFoundException | SAXException | IOException| ParserConfigurationException e) 
		{
			this.issueTicketPage.getLblOffenseStatus().setText("Could not load offenses");
			this.issueTicketPage.getLblOffenseStatus().setForeground(Color.RED);
		}
	
	}
	
	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public IssueTicket getIssueTicketPage() {
		return issueTicketPage;
	}

	public void setIssueTicketPage(IssueTicket issueTicketPage) {
		this.issueTicketPage = issueTicketPage;
	}
	
}