package ticketserver.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import ticketserver.view.AddUser;

public class AddUserController implements ActionListener
{

	private AddUser addUserPage;
	private String eventSource;
	
	public AddUserController(AddUser addUserPage,String eventSource)
	{
		this.addUserPage = addUserPage;
		this.eventSource = eventSource;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("cmbxUserType"))
		{
			if(((JComboBox)e.getSource()).getSelectedIndex()==0)
			{
				this.addUserPage.getPnlControlButton().setVisible(false);
				this.addUserPage.getPnlUserInfo().setVisible(false);
				this.addUserPage.getPnlPoliceBadgeId().setVisible(false);
				this.addUserPage.getPnlTaxOfficerId().setVisible(false);
			}
			if(((JComboBox)e.getSource()).getSelectedIndex()==1)
			{
				this.addUserPage.getPnlControlButton().setVisible(true);
				TitledBorder border = (TitledBorder) this.addUserPage.getPnlUserInfo().getBorder();
				border.setTitle("Tax Officer Info");
				this.addUserPage.getPnlUserInfo().setBorder(border);
				this.addUserPage.getPnlUserInfo().setVisible(false);
				this.addUserPage.getPnlUserInfo().setVisible(true);
				this.addUserPage.getPnlPoliceBadgeId().setVisible(false);
				this.addUserPage.getPnlTaxOfficerId().setVisible(true);
			}
			
			if(((JComboBox)e.getSource()).getSelectedIndex()==2)
			{
				this.addUserPage.getPnlControlButton().setVisible(true);
				TitledBorder border = (TitledBorder) this.addUserPage.getPnlUserInfo().getBorder();
				border.setTitle("Police Officer Info");
				this.addUserPage.getPnlUserInfo().setVisible(false);
				this.addUserPage.getPnlUserInfo().setVisible(true);
				this.addUserPage.getPnlPoliceBadgeId().setVisible(true);
				this.addUserPage.getPnlTaxOfficerId().setVisible(false);
			}
		}
		
		else if(this.eventSource.equalsIgnoreCase("btnSaveUser"))
		{
			
		}
		else if(this.eventSource.equalsIgnoreCase("btnResetFields"))
		{
			
		}
	}
	
}