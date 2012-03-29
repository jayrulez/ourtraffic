package ticketserver.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import extension.model.Police;

//import com.mysql.jdbc.Driver;
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
	
	public void dbConnect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		//Class.forName("com.mysql.jbdc.Driver").newInstance();
		Class.forName("com.mysql.jdbc.Driver");
		
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketingdb?user=root&password=");
		//System.out.println("connected");
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
					results.add(new Police(this.resultSet.getString("badgeId"),this.resultSet.getString("firstName"),this.resultSet.getString("lastName"),this.resultSet.getString("middleInitial"),this.resultSet.getDate("DOB"),
							this.resultSet.getString("street"),this.resultSet.getString("city"),this.resultSet.getString("parish"),this.resultSet.getString("pin"),this.resultSet.getInt("accountType")));
				}
				else if(this.resultSet.getInt("accountType")==3)
				{
					results.add(new Police(this.resultSet.getString("id"),this.resultSet.getString("firstName"),this.resultSet.getString("lastName"),this.resultSet.getString("middleInitial"),this.resultSet.getDate("DOB"),
							this.resultSet.getString("street"),this.resultSet.getString("city"),this.resultSet.getString("parish"),this.resultSet.getString("pin"),this.resultSet.getInt("accountType")));
				}
				
			}
		}
		return results;
	}
	
	public Integer addPolice(String badgeId, Integer divisionId, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_addPolice(?,?,?,?,?,?,?,?,?,?,?)");
		this.callableStatement.setString(1,badgeId);
		this.callableStatement.setInt(2,divisionId);
		this.callableStatement.setString(3,firstName);
		this.callableStatement.setString(4,lastName);
		this.callableStatement.setString(5,middleInitial);
		this.callableStatement.setDate(6,new java.sql.Date(dob.getTime()));
		this.callableStatement.setString(7,address1);
		this.callableStatement.setString(8,address2);
		this.callableStatement.setString(9,parish);
		this.callableStatement.setString(10,password);
		this.callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);
	
		this.callableStatement.execute();	
		System.out.println(this.callableStatement.getInt("result"));

		return this.callableStatement.getInt("result");
	}
	
	public Integer addTaxOfficer(String officerId, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_addPolice(?,?,?,?,?,?,?,?,?,?)");
		this.callableStatement.setString(1,officerId);
		this.callableStatement.setString(2,firstName);
		this.callableStatement.setString(3,lastName);
		this.callableStatement.setString(4,middleInitial);
		this.callableStatement.setDate(5,new java.sql.Date(dob.getTime()));
		this.callableStatement.setString(6,address1);
		this.callableStatement.setString(7,address2);
		this.callableStatement.setString(8,parish);
		this.callableStatement.setString(9,password);
		this.callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
	
		this.callableStatement.execute();	
		System.out.println(this.callableStatement.getInt("result"));

		return this.callableStatement.getInt("result");
	}
	
	public int issueTicketNewOffender(Integer offenderTrn, String firstName, String lastName, String middleInitial,Date dob, String address1, String address2, String parish, String licenseType, Integer licensePoints, Date expiryDate, String policeId, Integer offenseId, Date offenseDate, String ticketAddress1, String ticketAddress2, String ticketParish, String description, Float fine, Integer ticketPoints) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_issueTicketNewOffender(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		this.callableStatement.setInt(1,offenderTrn);
		this.callableStatement.setString(2,firstName);
		this.callableStatement.setString(3,lastName);
		this.callableStatement.setString(4,middleInitial);
		this.callableStatement.setString(5,address1);
		this.callableStatement.setString(6,address2);
		this.callableStatement.setString(7,parish);
		this.callableStatement.setDate(8,new java.sql.Date(dob.getTime()));
		this.callableStatement.setString(9,licenseType);
		this.callableStatement.setInt(10,licensePoints);
		this.callableStatement.setDate(11,new java.sql.Date(expiryDate.getTime()));
		
		this.callableStatement.setString(12,policeId);
		this.callableStatement.setInt(13,offenseId);
		this.callableStatement.setDate(14,new java.sql.Date(offenseDate.getTime()));
		this.callableStatement.setString(15,ticketAddress1);
		this.callableStatement.setString(16,ticketAddress2);
		this.callableStatement.setString(17,ticketParish);
		this.callableStatement.setString(18,description);
		this.callableStatement.setFloat(19,fine);
		this.callableStatement.setInt(20,ticketPoints);
		
		this.callableStatement.registerOutParameter(21, java.sql.Types.INTEGER);
		this.callableStatement.execute();	
		System.out.println(this.callableStatement.getInt("result"));

		return this.callableStatement.getInt("result");
	}
	//offenderTrn int(11), firstName varchar(30), lastName varchar(30), middleInitial varchar(1),street varchar(50), city varchar(30), parish varchar(30), dob date,licenseType varchar(20),licensePoints int(11), expiryDate Date ,policeId varchar(16), offenseId int(11), offenseDate date, street varchar(50), city varchar(50), parish varchar(30), description text, fine float, points int(11),OUT result int
	public int issueTicket(Integer offenderTrn ,String policeId, Integer offenseId, Date offenseDate, String ticketAddress1, String ticketAddress2, String ticketParish, String description, Float fine, Integer ticketPoints)throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		
		this.callableStatement = connection.prepareCall("call sp_issueTicketNewOffender(?,?,?,?,?,?,?,?,?,?,?)");
		this.callableStatement.setInt(1,offenderTrn);
		this.callableStatement.setString(2,policeId);
		this.callableStatement.setInt(3,offenseId);
		this.callableStatement.setDate(4,new java.sql.Date(offenseDate.getTime()));
		this.callableStatement.setString(5,ticketAddress1);
		this.callableStatement.setString(6,ticketAddress2);
		this.callableStatement.setString(7,ticketParish);
		this.callableStatement.setString(8,description);
		this.callableStatement.setFloat(9,fine);
		this.callableStatement.setInt(10,ticketPoints);
		
		this.callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);	
		
		this.callableStatement.execute();	
		System.out.println(this.callableStatement.getInt("result"));

		return this.callableStatement.getInt("result");
	}
	
	public void addOffense()
	{
		
	}
	
	
}