package ticketserver.controller;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ticketserver.model.SqlProvider;
import ticketserver.view.MasterFrame;

public class MasterFrameConnectionController implements Runnable
{
	private MasterFrame masterFrame;
	public MasterFrameConnectionController(MasterFrame masterFrame) 
	{
		this.masterFrame = masterFrame;
	}
	
	public MasterFrameConnectionController() {
		// TODO Auto-generated constructor stub
	}
	
	public void connectionStatus()
	{
		SqlProvider sqlProvider = new SqlProvider();
		while(this.masterFrame !=null)
		{
			try 
			{
				sqlProvider.dbConnect();
				this.masterFrame.getLblSystemConnectionStatusValue().setForeground(Color.GREEN);
				this.masterFrame.getLblSystemConnectionStatusValue().setText("Connected");
				sqlProvider.dbConnect();
			} 
			catch (ClassNotFoundException e) 
			{
				this.masterFrame.getLblSystemConnectionStatusValue().setForeground(Color.RED);
				this.masterFrame.getLblSystemConnectionStatusValue().setText("Disconnected");
				JOptionPane.showMessageDialog(this.masterFrame, "Could not connect to Data Server. Critical recources are missing.","Ticket Server: connection error",JOptionPane.ERROR_MESSAGE);
				
			} 
			catch (InstantiationException e) 
			{
				this.masterFrame.getLblSystemConnectionStatusValue().setForeground(Color.RED);
				this.masterFrame.getLblSystemConnectionStatusValue().setText("Disconnected");
				JOptionPane.showMessageDialog(this.masterFrame, "Could not connect to the Data Server. An unexpected error occured.","Ticket Server: connection error",JOptionPane.ERROR_MESSAGE);
			} 
			catch (IllegalAccessException e) 
			{
				this.masterFrame.getLblSystemConnectionStatusValue().setForeground(Color.RED);
				this.masterFrame.getLblSystemConnectionStatusValue().setText("Disconnected");
				JOptionPane.showMessageDialog(this.masterFrame, "Could not connect to the Data Sever. You not have sufficient privilege","Ticket Server: connection failed",JOptionPane.ERROR_MESSAGE);
			} 
			catch (SQLException e) 
			{
				//JOptionPane.showMessageDialog(this.ticketServerFrame, "Could not connect to Data Sever. The Data Server is unreachable","Ticket Server: connection error",JOptionPane.ERROR_MESSAGE);
				this.masterFrame.getLblSystemConnectionStatusValue().setForeground(Color.RED);
				this.masterFrame.getLblSystemConnectionStatusValue().setText("Disconnected");
			}
			finally
			{
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block;
				}
			}
		}
	}
	
	@Override
	public void run() 
	{
		this.connectionStatus();
		
	}
	
}