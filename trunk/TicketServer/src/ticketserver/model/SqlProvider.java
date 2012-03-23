package ticketserver.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
}