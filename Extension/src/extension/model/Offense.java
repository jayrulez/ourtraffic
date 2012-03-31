package extension.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Offense implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer offenseCode;
	private String offenceName;
	private String description;
	
	public Offense() 
	{
		// TODO Auto-generated constructor stub
	}
	public Offense(Integer offenseCode, String offenseName, String description) 
	{
		this.offenceName = offenseName;
		this.offenseCode = offenseCode;
		this.description = description;
	}
	
	public Offense(Integer offenseCode) 
	{
		this.offenseCode = offenseCode;
	}
	
	public void setOffenceName(String offenceName) 
	{
		this.offenceName = offenceName;
	}
	public void setOffenseCode(Integer offenseCode) 
	{
		this.offenseCode = offenseCode;
	}
	public String getOffenceName() 
	{
		return offenceName;
	}
	public Integer getOffenseCode() 
	{
		return offenseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static String extractCode(String input)
	{
		Pattern pattern = Pattern.compile("\\d+:");
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.find())
		{
			return matcher.group(0).replace(":", "");
		}
		return null;
	}
	
	@Override
	public String toString() 
	{
		return this.offenseCode + ": " + this.offenceName;
	}
}