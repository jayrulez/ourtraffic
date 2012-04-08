package ticketserver.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import ticketserver.model.SqlProvider;
import ticketserver.view.AddUser;

public class AddUserController implements ActionListener
{
	private SqlProvider sqlProvider;
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
			this.sqlProvider = new SqlProvider();
			if(this.addUserPage.getCmbxUserTye().getSelectedIndex() == 2)
			{
				try
				{
					Integer result;

					result = this.sqlProvider.addPolice(this.addUserPage.getTxtBadgeNo().getText().trim(),Integer.parseInt(this.addUserPage.getTxtDivisionId().getText().trim()),this.addUserPage.getTxtFirstName().getText(), this.addUserPage.getTxtLastName().getText().trim(), this.addUserPage.getTxtMiddleInitial().getText().trim(), this.addUserPage.getDateDob().getDate(), this.addUserPage.getTxtAddress1().getText().trim(), this.addUserPage.getTxtAddress2().getText().trim(), this.addUserPage.getCmbxParish().getSelectedItem().toString().trim(), "password");
		
					if(result == 1)
					{
						JOptionPane.showMessageDialog(this.addUserPage, "Police Officer: " + this.addUserPage.getTxtFirstName().getText().trim() + " " + this.addUserPage.getTxtLastName().getText().trim(),"Add Policer Officer: success",JOptionPane.DEFAULT_OPTION,new ImageIcon(AddUserController.class.getResource("/ticketserver/resources/addUserIcon_32x32.png")));
					}
					else if(result == -1)
					{
						JOptionPane.showMessageDialog(this.addUserPage,"Police Officer with Badge Number "+ "\""+ this.addUserPage.getTxtBadgeNo().getText().trim()+"\"" +" already exist.","Add Police Officer: failed",JOptionPane.ERROR_MESSAGE);
					}
					else if(result == 0)
					{
						JOptionPane.showMessageDialog(this.addUserPage,"An error occurred while trying to add Police Officer "+ "\""+ this.addUserPage.getTxtFirstName().getText().trim()+ " " + this.addUserPage.getTxtLastName().getText().trim() +"\".","Add Police Officer: failed",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this.addUserPage,"Could not accesss the Data Source.Police Officer "+ "\""+ this.addUserPage.getTxtFirstName().getText().trim()+ " " + this.addUserPage.getTxtLastName().getText().trim()+"\" was not added","Add Police Officer: failed",JOptionPane.ERROR_MESSAGE);
					//System.out.println("here");
				} 
				catch (ClassNotFoundException ex) 
				{
					JOptionPane.showMessageDialog(this.addUserPage,"An error occurred while trying to add Police Officer "+ "\""+ this.addUserPage.getTxtBadgeNo().getText().trim()+"\".","Add Police Officer: failed",JOptionPane.ERROR_MESSAGE);
				} catch (InstantiationException ex) {
					JOptionPane.showMessageDialog(this.addUserPage,"An error occurred while trying to add Police Officer "+ "\""+ this.addUserPage.getTxtBadgeNo().getText().trim()+"\".","Add Police Officer: failed",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				} catch (IllegalAccessException ex) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this.addUserPage,"Data access denied.","Add Police Officer: failed",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else if(this.addUserPage.getCmbxUserTye().getSelectedIndex() == 1)
			{
				try
				{
					Integer result;

					result = this.sqlProvider.addTaxOfficer(this.addUserPage.getTxtTaxOfficerId().getText().trim(),this.addUserPage.getTxtFirstName().getText(), this.addUserPage.getTxtLastName().getText().trim(), this.addUserPage.getTxtMiddleInitial().getText().trim(), this.addUserPage.getDateDob().getDate(), this.addUserPage.getTxtAddress1().getText().trim(), this.addUserPage.getTxtAddress2().getText().trim(), this.addUserPage.getCmbxParish().getSelectedItem().toString().trim(), "password");
		
					if(result == 1)
					{
						JOptionPane.showMessageDialog(this.addUserPage, "Tax Officer: " + this.addUserPage.getTxtFirstName().getText().trim() + " " + this.addUserPage.getTxtLastName().getText().trim(),"Add Tax Officer: success",JOptionPane.DEFAULT_OPTION,new ImageIcon(AddUserController.class.getResource("/ticketserver/resources/addUserIcon_32x32.png")));
					}
					else if(result == -1)
					{
						JOptionPane.showMessageDialog(this.addUserPage,"Tax Officer with Id Number "+ "\""+ this.addUserPage.getTxtBadgeNo().getText().trim()+"\"" +" already exist.","Add Tax Officer: failed",JOptionPane.ERROR_MESSAGE);
					}
					else if(result == 0)
					{
						JOptionPane.showMessageDialog(this.addUserPage,"An error occurred while trying to add Tax Officer "+ "\""+ this.addUserPage.getTxtBadgeNo().getText().trim()+"\".","Add Tax Officer: failed",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this.addUserPage,"An error occured while saving data. Tax Officer "+ "\""+ this.addUserPage.getTxtFirstName().getText().trim() + " " +this.addUserPage.getTxtLastName().getText().trim() +"\" was not added","Add Tax Officer",JOptionPane.ERROR_MESSAGE);
					//System.out.println("here");
				} 
				catch (ClassNotFoundException ex) 
				{
					JOptionPane.showMessageDialog(this.addUserPage,"An error occurred while trying to add Tax Officer "+ "\""+ this.addUserPage.getTxtBadgeNo().getText().trim()+"\".","Add Tax Officer: failed",JOptionPane.ERROR_MESSAGE);
				} catch (InstantiationException ex) {
					JOptionPane.showMessageDialog(this.addUserPage,"An error occurred while trying to add Tax Officer "+ "\""+ this.addUserPage.getTxtBadgeNo().getText().trim()+"\".","Add Tax Officer: failed",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				} catch (IllegalAccessException ex) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this.addUserPage,"Data access denied.","Add Tax Officer: failed",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(this.eventSource.equalsIgnoreCase("btnResetFields"))
		{
			this.resetFields();
		}
	}
	public void resetFields()
	{
		if(this.addUserPage.getCmbxUserTye().getSelectedIndex()==2)
		{
			this.addUserPage.getTxtBadgeNo().setText("");
			this.addUserPage.getTxtDivisionId().setText("");
		}
		else if(this.addUserPage.getCmbxUserTye().getSelectedIndex()==3)
		{
			this.addUserPage.getTxtTaxOfficerId().setText("");
		}
		this.addUserPage.getTxtAddress1().setText("");
		this.addUserPage.getTxtAddress2().setText("");
		this.addUserPage.getTxtFirstName().setText("");
		this.addUserPage.getTxtLastName().setText("");
		this.addUserPage.getTxtMiddleInitial().setText("");
		this.addUserPage.getCmbxParish().setSelectedIndex(0);
		this.addUserPage.getDateDob().setDate(null);
	}
}