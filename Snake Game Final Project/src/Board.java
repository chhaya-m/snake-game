import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Board{
	
	//add location attributes
	private Image img; 	
	public int x, y;
	private AffineTransform tx;

	public Board(int x, int y) {
		img = getImage("/imgs/board2.png"); //load the image for background
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		//call update to update the actually picture location
		update();
		g2.drawImage(img, tx, null);
		
		

	}
	/* update the picture variable location */
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(11, 11);
	}
		

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 0.8);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Board.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}


