package components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class DecimalTextField extends JTextField implements  DocumentListener, FocusListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean allowEmpty = false;
	private boolean emptyCheckFailed = true;
	private boolean formatCheckFailed = true;
	
	private JLabel validationMessage;
	
	public DecimalTextField(float defval, int size)
	{
	    super("" + defval, size);
	}
	public DecimalTextField()
	{
	    
	}
	  protected Document createDefaultModel()
	  {
		  return new NumberTextDocument();
	  }
	
	  public void initialiseListensers()
	  {
			this.addFocusListener(this);
			this.getDocument().addDocumentListener(this);
	  }
	  public boolean isValid() 
	  {
		    try 
		    {
		    	Float.parseFloat(getText());
		    	return true;
		    } 
		    catch (NumberFormatException e) 
		    {
		    	return false;
		    }
		    catch (NullPointerException e) 
		    {
		    	return false;
		    }
	  }
	
	  public float getValue() 
	  {
		    try 
		    {
		      return Float.parseFloat(getText());
		    } 
		    catch (NumberFormatException e) 
		    {
		      return 0;
		    }
	  }
	  
  	public boolean getAllowEmpty() {
		return allowEmpty;
	}

	public void setAllowEmpty(boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
	}

	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		if(getText().trim().isEmpty())
		{
			return true;
		}
		return false;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void focusGained(FocusEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == this)
		{
			
		}
	}

	@Override
	public void focusLost(FocusEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == this)
		{
			if(this.isEmpty())
			{
				this.validationMessage.setForeground(Color.RED);
				this.validationMessage.setVisible(true);
				this.emptyCheckFailed = true;
			}
			else
			{
				this.validationMessage.setVisible(false);
				this.emptyCheckFailed = false;
				
				if(!this.isValid())
				{
					this.validationMessage.setForeground(Color.RED);
					this.validationMessage.setVisible(true);
					this.formatCheckFailed = true;
				}
				else
				{
					this.validationMessage.setVisible(false);
					this.formatCheckFailed = false;
				}
			}
		}	
	}
	
	public boolean isValidateSuccess()
	{
		if(this.emptyCheckFailed || this.formatCheckFailed)
		{
			return false;
		}
		return true;
	}
	
	public JLabel getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(JLabel validationMessage) {
		this.validationMessage = validationMessage;
	}

	class NumberTextDocument extends PlainDocument 
  	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public void insertString(int offs, String str, AttributeSet a)throws BadLocationException 
		{
			if (str == null)
				 
			    return; 
			String oldString = getText(0, getLength());
			String newString = oldString.substring(0, offs) + str+ oldString.substring(offs);
			try 
			{
			  Float.parseFloat(newString);
			  super.insertString(offs, str, a);
			} 
			catch (NumberFormatException e) 
			{
			}
		}
  	}

}