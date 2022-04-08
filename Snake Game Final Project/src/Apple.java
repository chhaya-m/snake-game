import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Apple {

		public int x,y;
		private int width, height;
		private String fileName; //for image
		public Image img; 	
		public AffineTransform tx;
		private double scaleW = 5.0, scaleH = 5.0;

		public Apple(int x, int y) {
			//assigns the x and y
			this.x = x;
			this.y = y;
			img = getImage("/imgs/apple.png");
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 	
		}
		
		public void paint(Graphics g) {
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;
			
			//g.drawRect(x, y, 84, 370);call update to update the actual picture location
			update();
			g2.drawImage(img, tx, null);
				//COINS REMAIN IF GAME HAS NOT STARTED
			if(Frame.gameStart == false) {
				if(x <= -100) {
					x = 700;
					
				}
			}else { //COINS START MOVING IF GAME HAS STARTED
					x -= 5; //COINS MOVING
					if(x <= -100) {
						x = 700;			
					}
			}
			
		}


		/* update the picture variable location */
		private void update() {
			tx.setToTranslation(x, y);
			tx.scale(1.3, 1.3);
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(1.2, 0.9);
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


