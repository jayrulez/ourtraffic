package trafficticket.config;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import trafficticket.model.Connection;

public class Configuration
{
	private File file;
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document doc;
	
	public Configuration() throws SAXException, IOException, ParserConfigurationException
	{
		try
		{
			file = new File("./config.xml");
			this.dbf = DocumentBuilderFactory.newInstance();
			this.db = dbf.newDocumentBuilder();
			this.doc = db.parse(file);
			this.doc.getDocumentElement().normalize();
			if(this.doc.getDocumentElement().getNodeName().compareToIgnoreCase("Configuration")!=0)
			{
				throw new SAXException("Configuration file is incorrect.");
			}
		}//throws SAXException, SAXParseException, ParserConfigurationException
		catch(SAXException ex)
		{
			throw ex;
		}
		catch(IOException ex)
		{
			throw new IOException("config file");
			//JOptionPane.showMessageDialog(null, "Error: Configuration file could not be read.","Configuration Error",JOptionPane.ERROR_MESSAGE);
		} 
		catch (ParserConfigurationException ex) 
		{
			// TODO Auto-generated catch block
			throw ex;
		}
	}
	
	public Connection getConnection(String connectionName)throws UnknownHostException,NumberFormatException
	{
		String address="";
		Integer port = 0;
		
		NodeList nodeLst = this.doc.getElementsByTagName("Connection");		

		for (int s = 0; s < nodeLst.getLength(); s++) 
		{
		    Node node = nodeLst.item(s);
		    if(node.getNodeType() == Node.ELEMENT_NODE)
		    {
		    	Element connectionElement = (Element)node;
		    	
		    	String name = this.getTagValue("Name", connectionElement);
		
		    	if(name.compareToIgnoreCase(connectionName)==0)
		    	{
		    		address = this.getTagValue("Address", connectionElement);
		    		port = Integer.parseInt(this.getTagValue("Port", connectionElement));
		    		break;
		    	}
		    }
		}
		return new Connection(address,port);
	}
	
	private String getTagValue(String sTag, Element eElement) 
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 
	    Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeValue();
	}
}