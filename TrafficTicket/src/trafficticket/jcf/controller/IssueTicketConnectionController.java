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

		try 
		{
			connectionController.submitRequest();
			this.issueTicketPage.getLblOffenseStatus().setText("");
			if(connectionController.isDialogSuccess())
			{
				Vector<Offense> offenses;
				
				offenses = (Vector<Offense>) connectionController.getSuccessServiceResponse().getData();
				if(this.issueTicketPage.getCmbxOffense().getItemAt(0) != "Select an offense")
				{
					this.issueTicketPage.getCmbxOffense().addItem("Select an offense");
				}
				if(!offenses.isEmpty())
				{
					int index = 1;
					for(Offense offense:offenses)
					{
						//if there is an item in position x
						if(this.issueTicketPage.getCmbxOffense().getItemAt(index) != null)
						{
							//if the item does not match that of the source
							if(!this.issueTicketPage.getCmbxOffense().getItemAt(index).toString().equalsIgnoreCase(offense.toString()))
							{
								//update that item
								this.issueTicketPage.getCmbxOffense().removeItemAt(index);
								this.issueTicketPage.getCmbxOffense().insertItemAt(offense, index);
							}
						}
						else //when there is not item in position x
						{
							//insert a new item
							this.issueTicketPage.getCmbxOffense().insertItemAt(offense, index);
						}
						index++;
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