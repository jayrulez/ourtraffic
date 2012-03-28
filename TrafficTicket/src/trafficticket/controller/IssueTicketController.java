package trafficticket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import trafficticket.jcf.view.IssueTicket;

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