package extension.model;

import javax.swing.JTextField;

public class FormValidation
{
	private Integer errorStatus;
	@SuppressWarnings("unused")
	private Integer targetSize;
	
	public FormValidation() 
	{
		this.errorStatus = 0;
		this.targetSize = 0;
	}
	
	public boolean isValid()
	{
		if(this.errorStatus == 0)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(JTextField textField)
	{
		if(textField.getText().trim().isEmpty())
		{
			errorStatus--;
		}
		return true;
	}
	
	public void reset()
	{
		this.errorStatus = 0;
	}
}