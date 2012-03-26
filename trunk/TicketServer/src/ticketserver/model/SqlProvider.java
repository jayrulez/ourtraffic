package ticketserver.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import trafficticket.model.Police;

public class SqlProvider
{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private ResultSet resultSet;
	
	public SqlProvider() 
	{
		this.connection = null;
		this.statement = null;
		this.preparedStatement = null;
		this.statement = null;
		this.callableStatement = null;
	}
	
	public void dbConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.sql.jbdc.Driver");
		this.connection = DriverManager.getConnection("jbdc:mysql://localhost/feedback?"+"user=root&password=");
	}
	
	public void dbDisconnect() throws SQLException
	{
		if(this.connection!=null)
		{
			this.connection.close();
		}
		if(this.statement != null)
		{
			this.statement.close();
		}
		if(this.preparedStatement != null)
		{
			this.preparedStatement.close();
		}
		if(this.resultSet != null)
		{
			
		}
	}
	
	public Vector getUser(String userHandle) throws SQLException
	{

		this.callableStatement = connection.prepareCall("{call getUser(?)}");
		this.callableStatement.setString(1,userHandle);
		
		this.resultSet = this.callableStatement.executeQuery();
		
		Vector results = new Vector();
		
		if(this.resultSet != null)
		{
			while(this.resultSet.next())
			{
				if(this.resultSet.getInt("accountType")==2)
				{
					results.add(new Police(this.resultSet.getInt("badgeId"),this.resultSet.getString("firstName"),this.resultSet.getString("lastName"),this.resultSet.getString("middleInitial"),this.resultSet.getDate("DOB"),
							this.resultSet.getString("street"),this.resultSet.getString("city"),this.resultSet.getString("parish"),this.resultSet.getString("pin"),this.resultSet.getInt("accountType")));
				}
				else if(this.resultSet.getInt("accountType")==3)
				{
					results.add(new Police(this.resultSet.getInt("id"),this.resultSet.getString("firstName"),this.resultSet.getString("lastName"),this.resultSet.getString("middleInitial"),this.resultSet.getDate("DOB"),
							this.resultSet.getString("street"),this.resultSet.getString("city"),this.resultSet.getString("parish"),this.resultSet.getString("pin"),this.resultSet.getInt("accountType")));
				}
				
			}
		}
		return results;
	}
	
	public boolean addUser() throws SQLException
	{
		this.callableStatement = connection.prepareCall("{call AddUser(?)}");
		this.callableStatement.setString(1,"");
		
		this.resultSet = this.callableStatement.executeQuery();		
		return true;
	}
}