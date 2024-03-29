package trafficticket.controller.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.ServiceRequest;
import extension.model.User;

import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.JCFFrame;
import trafficticket.taxoffice.view.TaxFrame;
import trafficticket.view.TrafficTicketLoginForm;
import trafficticket.view.TrafficTicketLoginFrame;

public class BtnLoginController extends MouseAdapter implements ActionListener {

	private TrafficTicketLoginForm loginPage;
	private String eventSource;
	public BtnLoginController() 
	{
	
	}

	public BtnLoginController(TrafficTicketLoginForm loginPage,String eventSource) 
	{
		this.loginPage = loginPage;
		this.eventSource = eventSource;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnLogin"))
		{
			this.login();
		}
	}

	private void login() {
		
		
		ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_USER_LOGIN);
		
		User loginUser = new User();
		
		loginUser.setHandle(this.loginPage.getTxtUsername().getText().trim());
		loginUser.setPassword(String.valueOf(this.loginPage.getTxtPassword().getPassword()));
		
		serviceRequest.getData().add(loginUser);
		
		ConnectionController connectionController = new ConnectionController(serviceRequest);

		try 
		{
			connectionController.submitRequest();
			
			if(connectionController.isDialogSuccess())
			{
				Vector<User> users;
				
				users = (Vector<User>) connectionController.getSuccessServiceResponse().getData();
				
				if(!users.isEmpty())
				{
					TrafficTicketLoginFrame loginFrame = (TrafficTicketLoginFrame) this.loginPage.getTopLevelAncestor();
					if(loginFrame != null)
					{
						User foundUser = (User) users.firstElement();
						if(foundUser.getType()==User.POLICE)
						{
							
							loginFrame.setVisible(false);
							
							/* distroy the login frame and all its contents */
							loginFrame.dispose();
	
							// start Tax Office program module
							// TaxFrame taxFrame = new TaxFrame();
							// SwingUtilities.invokeLater(taxFrame);
	
							// start Tax Office program module
							
							JCFFrame jcfFrame = new JCFFrame();
							SwingUtilities.invokeLater(jcfFrame);
							jcfFrame.setCurrentUser(User.copy(foundUser));
							
							jcfFrame.getLblUserInfo().setText(foundUser.getFirstName().substring(0, 1) + ". " + foundUser.getMiddleInitial() + ". " + foundUser.getLastName());
						}
						else if(foundUser.getType()==User.TAXOFFICER)
						{
							loginFrame.setVisible(false);
							
							/* distroy the login frame and all its contents */
							loginFrame.dispose();
	
							// start Tax Office program module
							// TaxFrame taxFrame = new TaxFrame();
							// SwingUtilities.invokeLater(taxFrame);
	
							// start Tax Office program module
							TaxFrame taxFrame = new TaxFrame();
							SwingUtilities.invokeLater(taxFrame);
							taxFrame.setCurrentUser(User.copy(foundUser));
							
							taxFrame.getLblUserInfo().setText(foundUser.getFirstName().substring(0, 1) + ". " + foundUser.getMiddleInitial() + ". " + foundUser.getLastName());
						}
					}
					else
					{
						
					}
				}
				else
				{
					this.loginPage.getLblLoginStatus().setText("Username or Password is incorrect");
					this.loginPage.getLblLoginStatus().setForeground(Color.RED);
				}
				connectionController = null;
			}
		} 
		catch (NumberFormatException | SAXException | IOException| ParserConfigurationException e) 
		{
			this.loginPage.getLblLoginStatus().setText("Error: Could not contact host. [0x1]");
			this.loginPage.getLblLoginStatus().setForeground(Color.RED);
		}
		catch(ClassNotFoundException| ClassCastException e)
		{
			this.loginPage.getLblLoginStatus().setText("An unexpected error occured.[0x2]");
			this.loginPage.getLblLoginStatus().setForeground(Color.RED);
		}

	}
}