package ticketserver.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ticketserver.model.SqlProvider;
import ticketserver.view.AddOffense;

public class AddOffenseController implements ActionListener
{
	private SqlProvider sqlProvider;
	private AddOffense addOffensePage;
	private String eventSource;
	
	public AddOffenseController(AddOffense addOffensePage,String eventSource)
	{
		this.addOffensePage = addOffensePage;
		this.eventSource = eventSource;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(this.eventSource.equalsIgnoreCase("btnSaveOffense"))
		{
			if(this.addOffensePage.isFormValidationSuccess())
			{
				this.sqlProvider = new SqlProvider();
	
				try
				{
					Integer result;
	
					result = this.sqlProvider.addOffense(this.addOffensePage.getTxtOffenseName().getText().trim(),this.addOffensePage.getTxtOffenseDescription().getText().trim());
					if(result == 0)
					{
						JOptionPane.showMessageDialog(this.addOffensePage,"An error occurred while trying to add Offense "+ "\""+ this.addOffensePage.getTxtOffenseName().getText().trim()+"\".","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
					}
					else if(result > 0)
					{
						JOptionPane.showMessageDialog(this.addOffensePage, "<html>The Offense was added.<br/><table><tr><td><strong>Offense ID:</strong></td><td>"+result+"</td></tr> <tr><td><strong>Name:</strong></td><td>"+this.addOffensePage.getTxtOffenseName().getText().trim()+"</td></tr> <tr><td><strong>Description:</strong></td><td>"+this.addOffensePage.getTxtOffenseDescription().getText().trim()+"</td></tr></table></html>","Add Offense: success",JOptionPane.DEFAULT_OPTION,new ImageIcon(AddOffenseController.class.getResource("/ticketserver/resources/addOffenseIcon.png")));
						this.resetFields();
					}
					else if(result == -1)
					{
						JOptionPane.showMessageDialog(this.addOffensePage,"An error occurred while trying to add Offense "+ "\""+ this.addOffensePage.getTxtOffenseName().getText().trim()+"\".","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
					}
					else if(result == -2)
					{
						JOptionPane.showMessageDialog(this.addOffensePage,"An Offense with the name "+ "\""+ this.addOffensePage.getTxtOffenseName().getText().trim()+"\" already exist.","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
					}
					else if(result == -10)
					{
						JOptionPane.showMessageDialog(this.addOffensePage,"An error occured while attempting to initiate the add offense prodecure "+ "\""+ this.addOffensePage.getTxtOffenseName().getText().trim()+"\".","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
					}
	
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(this.addOffensePage,"Could not accesss the Data Source. Offense "+ "\""+ this.addOffensePage.getTxtOffenseName().getText().trim()+"\" was not added","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
					System.out.println(ex.getErrorCode());
				} 
				catch (ClassNotFoundException ex) 
				{
					JOptionPane.showMessageDialog(this.addOffensePage,"An error occurred while trying to add Offense "+ "\""+ this.addOffensePage.getTxtOffenseName().getText().trim()+"\".","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
				} 
				catch (InstantiationException ex) 
				{
					JOptionPane.showMessageDialog(this.addOffensePage,"An error occurred while trying to add Offense "+ "\""+ this.addOffensePage.getTxtOffenseName().getText().trim()+"\".","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				} 
				catch (IllegalAccessException ex) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this.addOffensePage,"Data access denied.","Add Offense: failed",JOptionPane.ERROR_MESSAGE);
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
		this.addOffensePage.getTxtOffenseDescription().setText("");
		this.addOffensePage.getTxtOffenseName().setText("");
	}
	
}
