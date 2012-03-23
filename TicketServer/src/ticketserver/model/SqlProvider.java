package ticketserver.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SqlProvider
{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public SqlProvider() 
	{
		this.connection = null;
		this.statement = null;
		this.preparedStatement = null;
		this.statement = null;
	}
	
	public void dbConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.sql.jbdc.Driver");
		this.connection = DriverManager.getConnection("jbdc:mysql://localhost/feedback?"+"user=root&password=");
	}
	
	public void dbDisconnect()
	{
		this.connection = null;
		this.statement = null;
		this.preparedStatement = null;
		this.resultSet = null;
	}
	
	public Vector getUser(String userName)
	{
		
	}
}