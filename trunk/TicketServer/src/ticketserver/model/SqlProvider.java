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

import extension.model.Address;
import extension.model.Division;
import extension.model.Offender;
import extension.model.Offense;
import extension.model.Police;
import extension.model.TaxOfficer;
import extension.model.Ticket;
import extension.model.User;

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
			this.resultSet.close();
		}
	}
	
	public Vector<User> getUser(String userHandle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_getUser(?)");
		this.callableStatement.setString(1,userHandle);
		
		this.resultSet = this.callableStatement.executeQuery();
		
		Vector<User> results = new Vector<User>();
		
		if(this.resultSet != null)
		{
			while(this.resultSet.next())
			{

				results.add(new User(this.resultSet.getString("firstName"),this.resultSet.getString("lastName"),this.resultSet.getString("middleInitial"),this.resultSet.getDate("DOB"),
							this.resultSet.getString("street"),this.resultSet.getString("city"),this.resultSet.getString("parish"),"",this.resultSet.getInt("accountType")));
		
			}
		}
		this.dbDisconnect();
		return results;
	}
	
	public Vector<User> getUserLogin(String userHandle,String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_getUserLogin(?,?)");
		this.callableStatement.setString(1,userHandle);
		this.callableStatement.setString(2,password);
		
		this.resultSet = this.callableStatement.executeQuery();
		
		Vector<User> results = new Vector<User>();
		
		if(this.resultSet != null)
		{
			while(this.resultSet.next())
			{

				results.add(new User(this.resultSet.getString("firstName"),this.resultSet.getString("lastName"),this.resultSet.getString("middleInitial"),this.resultSet.getDate("DOB"),
							this.resultSet.getString("street"),this.resultSet.getString("city"),this.resultSet.getString("parish"),"",this.resultSet.getInt("accountType"),this.resultSet.getString("handle")));
		
			}
		}
		this.dbDisconnect();
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
		int result = this.callableStatement.getInt("result");
		
		this.dbDisconnect();
		
		return result;
	}
	
	public Integer addTaxOfficer(String officerId, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_addTaxOfficer(?,?,?,?,?,?,?,?,?,?)");
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
		
		int result = this.callableStatement.getInt("result");
		
		this.dbDisconnect();
		
		return result;
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
		int result = this.callableStatement.getInt("result");
		
		this.dbDisconnect();
		
		return result;
	}
	//offenderTrn int(11), firstName varchar(30), lastName varchar(30), middleInitial varchar(1),street varchar(50), city varchar(30), parish varchar(30), dob date,licenseType varchar(20),licensePoints int(11), expiryDate Date ,policeId varchar(16), offenseId int(11), offenseDate date, street varchar(50), city varchar(50), parish varchar(30), description text, fine float, points int(11),OUT result int
	public int issueTicketExistingOffender(String policeId,Integer offenderTrn, Integer offenseId, Date offenseDate, String ticketAddress1, String ticketAddress2, String ticketParish, String description, Float fine, Integer ticketPoints)throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		
		this.callableStatement = connection.prepareCall("call sp_issueTicket(?,?,?,?,?,?,?,?,?,?,?)");
		this.callableStatement.setString(1,policeId);
		this.callableStatement.setInt(2,offenderTrn);
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
		
		System.out.println("QUERY EXECUTED");
		System.out.println(this.callableStatement.getInt("result"));
		
		int result = 0;
		result = this.callableStatement.getInt("result");
		
		this.dbDisconnect();
		
		return result;

	}
	
	public int addOffense(String offenseName, String offenseDescription) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		
		this.callableStatement = connection.prepareCall("call sp_addOffense(?,?,?)");
		this.callableStatement.setString(1,offenseName);
		this.callableStatement.setString(2,offenseDescription);
		
		this.callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);	
	
		this.callableStatement.execute();	
		
		System.out.println("QUERY EXECUTED");
		System.out.println(this.callableStatement.getInt("result"));
		
		int result = -10;
		result = this.callableStatement.getInt("result");
		
		this.dbDisconnect();
		
		return result;		
	}
	
	public Vector<Offense> getAllOffenses() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_getAllOffenses()");
		
		this.resultSet = this.callableStatement.executeQuery();
		Offense offense;
		Vector<Offense> offenses = new Vector<Offense>();
		while(this.resultSet.next())
		{
			offense = new Offense(this.resultSet.getInt("id"),this.resultSet.getString("name"),this.resultSet.getString("description"));
			offenses.add(offense);
		}
		this.dbDisconnect();
		System.out.println("Data Server Sends Data:"+offenses.size());
		return offenses;
	}
	
	public Vector<Offender> getOffender(int OffenderTrn) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		this.callableStatement = connection.prepareCall("call sp_getOffender(?)");
		this.callableStatement.setInt(1, OffenderTrn);
		
		this.resultSet = this.callableStatement.executeQuery();
		Offender offender;
		Vector<Offender> offenders = new Vector<Offender>();
		while(this.resultSet.next())
		{
			offender = new Offender(this.resultSet.getInt("trn"),this.resultSet.getString("firstName"),this.resultSet.getString("lastName"),this.resultSet.getString("middleInitial"),this.resultSet.getDate("DOB"),this.resultSet.getString("street"),this.resultSet.getString("city"),this.resultSet.getString("parish"),this.resultSet.getString("licenseType"),this.resultSet.getInt("points"),this.resultSet.getDate("expiryDate"));
			offenders.add(offender);
		}
		this.dbDisconnect();
		System.out.println("Data Server Sends Data:"+offenders.size());
		return offenders;		
	}
	
	public Vector<Ticket> getTicket(int ticketNumber) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		
		this.callableStatement = connection.prepareCall("call sp_getTicket(?)");

		this.callableStatement.setInt(1, ticketNumber);
		
		this.resultSet = this.callableStatement.executeQuery();	
		
		Ticket ticket;
		Offense offense;
		Police police;
		Offender offender;
		Division policeDivison;
		
		Vector<Ticket> tickets = new Vector<Ticket>();
		while(this.resultSet.next())
		{
			ticket = new Ticket(this.resultSet.getInt("ticketNumber"),this.resultSet.getDate("offenseDate"),new Address(this.resultSet.getString("ticketStreet"),this.resultSet.getString("ticketCity"),this.resultSet.getString("ticketParish")),this.resultSet.getString("ticketDescription"),this.resultSet.getFloat("ticketFine"),this.resultSet.getInt("ticketPoints"),this.resultSet.getInt("paymentStatus"));
			offender = new Offender(this.resultSet.getInt("offenderTrn"),this.resultSet.getString("offenderFirstName"),this.resultSet.getString("offenderLastName"),this.resultSet.getString("offenderMiddleInitial"),this.resultSet.getDate("offenderDob"),this.resultSet.getString("offenderStreet"),this.resultSet.getString("offenderCity"),this.resultSet.getString("offenderParish"),this.resultSet.getString("licenseType"),this.resultSet.getInt("licensePoints"),this.resultSet.getDate("licenseExpiryDate"));
			
			police = new Police();
			police.setBadgeNumber(this.resultSet.getString("badgeId"));
			policeDivison = new Division();
			policeDivison.setStationNumber(this.resultSet.getInt("divisionId"));
			police.setDivision(policeDivison);
			police.setFirstName(this.resultSet.getString("policeFirstName"));
			police.setLastName(this.resultSet.getString("policeLastName"));
			police.setMiddleInitial(this.resultSet.getString("policeMiddleInitial"));
		
			offense = new Offense(this.resultSet.getInt("offenseId"),this.resultSet.getString("offenseName"),"");
			ticket.setOffender(offender);
			ticket.setOffense(offense);
			ticket.setPolice(police);
			tickets.add(ticket);
		}
		this.dbDisconnect();
		System.out.println("Data Server Sends Data:"+tickets.size());
		return tickets;			
	}
	
	public int payTicket(int ticketNumber, String officerId, float amount) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		
		this.callableStatement = connection.prepareCall("call sp_payTicket(?,?,?,?)");
		
		this.callableStatement.setInt(1,ticketNumber);
		this.callableStatement.setString(2,officerId);
		this.callableStatement.setFloat(3,amount);
		this.callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);	
	
		this.callableStatement.execute();	
		
		System.out.println("QUERY EXECUTED");
		System.out.println(this.callableStatement.getInt("result"));
		
		int result = 0;
		result = this.callableStatement.getInt("result");
		
		this.dbDisconnect();
		
		return result;
	}
	
	public Vector<Ticket> getTickets(Integer ticketNumber,Integer offenderTrn,Integer paymentStatus) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		this.dbConnect();
		
		
		String queryString = " select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where 1=1";
		
		if(ticketNumber != null)
		{
			queryString = queryString.concat(" and `ticket`.id = "+ticketNumber);
		}
		if(offenderTrn != null)
		{
			queryString = queryString.concat(" and `offender`.trn = "+offenderTrn);
		}
		if(paymentStatus != null)
		{
			queryString = queryString.concat(" and `ticket`.paymentStatus = "+paymentStatus);
		}
		
		queryString = queryString.concat(";");
		
		System.out.println("QUERY: "+queryString);
		
		this.callableStatement = connection.prepareCall(queryString);

		this.resultSet = this.callableStatement.executeQuery();	
		
		Ticket ticket;
		Offense offense;
		Police police;
		Offender offender;
		Division policeDivison;
		
		Vector<Ticket> tickets = new Vector<Ticket>();
		while(this.resultSet.next())
		{
			ticket = new Ticket(this.resultSet.getInt("ticketNumber"),this.resultSet.getDate("offenseDate"),new Address(this.resultSet.getString("ticketStreet"),this.resultSet.getString("ticketCity"),this.resultSet.getString("ticketParish")),this.resultSet.getString("ticketDescription"),this.resultSet.getFloat("ticketFine"),this.resultSet.getInt("ticketPoints"),this.resultSet.getInt("paymentStatus"));
			offender = new Offender(this.resultSet.getInt("offenderTrn"),this.resultSet.getString("offenderFirstName"),this.resultSet.getString("offenderLastName"),this.resultSet.getString("offenderMiddleInitial"),this.resultSet.getDate("offenderDob"),this.resultSet.getString("offenderStreet"),this.resultSet.getString("offenderCity"),this.resultSet.getString("offenderParish"),this.resultSet.getString("licenseType"),this.resultSet.getInt("licensePoints"),this.resultSet.getDate("licenseExpiryDate"));
			
			police = new Police();
			police.setBadgeNumber(this.resultSet.getString("badgeId"));
			policeDivison = new Division();
			policeDivison.setStationNumber(this.resultSet.getInt("divisionId"));
			police.setDivision(policeDivison);
			police.setFirstName(this.resultSet.getString("policeFirstName"));
			police.setLastName(this.resultSet.getString("policeLastName"));
			police.setMiddleInitial(this.resultSet.getString("policeMiddleInitial"));
		
			offense = new Offense(this.resultSet.getInt("offenseId"),this.resultSet.getString("offenseName"),"");
			ticket.setOffender(offender);
			ticket.setOffense(offense);
			ticket.setPolice(police);
			tickets.add(ticket);
		}
		
		this.dbDisconnect();
		System.out.println("Data Server Sends Data:"+tickets.size());
		
		return tickets;		
	}

	public Vector<Offender> getOffenders(Integer trnNumber, String firstName,String lastName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
	{
		this.dbConnect();
		
		
		String queryString = " select `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate where 1=1";
		
		if(trnNumber != null)
		{
			queryString = queryString.concat(" and `offender`.trn = "+trnNumber);
		}
		if(firstName != null)
		{
			queryString = queryString.concat(" and `offender`.firstName = "+firstName);
		}
		if(lastName != null)
		{
			queryString = queryString.concat(" and `offender`.lastName = "+lastName);
		}
		
		queryString = queryString.concat(";");
		
		System.out.println("QUERY: "+queryString);
		
		this.callableStatement = connection.prepareCall(queryString);

		this.resultSet = this.callableStatement.executeQuery();	
		
		
		Vector<Offender> offenders = new Vector<Offender>();
		while(this.resultSet.next())
		{
			offenders.add(new Offender(this.resultSet.getInt("offenderTrn"),this.resultSet.getString("offenderFirstName"),this.resultSet.getString("offenderLastName"),this.resultSet.getString("offenderMiddleInitial"),this.resultSet.getDate("offenderDob"),this.resultSet.getString("offenderStreet"),this.resultSet.getString("offenderCity"),this.resultSet.getString("offenderParish"),this.resultSet.getString("licenseType"),this.resultSet.getInt("licensePoints"),this.resultSet.getDate("licenseExpiryDate")));
		}
		
		this.dbDisconnect();
		System.out.println("Data Server Sends Data:"+offenders.size());
		
		return offenders;		
	}
	
	public Vector<Offense> getOffenses(Integer offenseCode, String offenseName ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
	{
		this.dbConnect();
		
		
		String queryString = " select `offense`.id,`offense`.name,`offense`.description as where 1=1";
		
		if(offenseCode != null)
		{
			queryString = queryString.concat(" and `offense`.id = "+offenseCode);
		}
		if(offenseName != null)
		{
			queryString = queryString.concat(" and `offense`.name = "+offenseName);
		}
		
		queryString = queryString.concat(";");
		
		System.out.println("QUERY: "+queryString);
		
		this.callableStatement = connection.prepareCall(queryString);

		this.resultSet = this.callableStatement.executeQuery();	
		
		Vector<Offense> offenses = new Vector<Offense>();
		while(this.resultSet.next())
		{
			offenses.add(new Offense(this.resultSet.getInt("id"),this.resultSet.getString("name"),this.resultSet.getString("description")));	
		}
		
		this.dbDisconnect();
		System.out.println("Data Server Sends Data:"+offenses.size());
		
		return offenses;		
	}

	public Vector getUsers(String userId,String firstName, String lastName,Integer policeType,Integer taxOfficerType) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
	{
		this.dbConnect();
		
		
		String queryString = " select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where 1=1";
		
		if(firstName != null)
		{
			//queryString = queryString.concat(" and `firstName`.id = "+ticketNumber);
		}
		if(lastName != null)
		{
			//queryString = queryString.concat(" and `offender`.trn = "+offenderTrn);
		}
		if(userId != null)
		{
			//queryString = queryString.concat(" and `ticket`.paymentStatus = "+paymentStatus);
		}
		if(policeType != null)
		{
			//queryString = queryString.concat(" and `ticket`.paymentStatus = "+paymentStatus);
		}
		if(taxOfficerType != null)
		{
			//queryString = queryString.concat(" and `ticket`.paymentStatus = "+paymentStatus);
		}
		
		queryString = queryString.concat(";");
		
		System.out.println("QUERY: "+queryString);
		
		this.callableStatement = connection.prepareCall(queryString);

		this.resultSet = this.callableStatement.executeQuery();	
		
		Vector users = new Vector();
		while(this.resultSet.next())
		{

			users.add(new Police());
			users.add(new TaxOfficer());
		}
		
		this.dbDisconnect();
		return null;
	}
}