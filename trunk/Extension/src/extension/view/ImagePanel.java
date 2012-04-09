package extension.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	private static final long serialVersionUID = 1L;
	private Image img;
 
	public ImagePanel() 
	{
    
		//img = (new ImageIcon(ImagePanel.class.getResource("/ticketserver/resources/trafficStartBackGround.png"))).getImage();
		img = (new ImageIcon()).getImage();
	}
 
	@Override
	protected void paintComponent(Graphics g) 
	{
	    super.paintComponent(g);
	    // paint the background image and scale it to fill the entire space
	    int x = (this.getWidth() - img.getWidth(null)) / 2;
	    int y = (this.getHeight() - img.getHeight(null)) / 2;
	    g.drawImage(img,x,y, this);
	}
	
}