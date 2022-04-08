import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	int score = 0;
	int highScore = 0;
	
	int upCounter = 0;
	int upCounterMax = 2;
	
	public static boolean gameStart = false;
	
	
	//CREATING THE OBJECTS
	Board bg = new Board(0, 0);
	Apple apple = new Apple (90, 87);

	//PAINTING OBJECTS
	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		apple.paint(g);
		
		
	
		//reset game when dino touches tree
		if(gameStart == false) {
			score = 0;
		}
		//WRITING RULES AND SCORE
		g.setColor(Color.white);
		g.drawString("Score: "+ score, 30, 45);
		//draws instructions to play
		
		
		/*
		//COLLISION, IF COLLISION OCCURS, GAME IS OVER
		Rectangle o2b = new Rectangle(coin.x+6, coin.y, 40, 40); //change this for dif picture by drawing rect
		Rectangle dRect1 = new Rectangle(dino.x, dino.y, 54, 72);
		Rectangle o1b = new Rectangle(tree.x, tree.y, 50, 300);
		System.out.println(dRect1.intersects(o1b));
		if(dRect1.intersects(o1b)) {
			gameStart = false;	
		}
		*/
		
		//CHECKING FOR NEW HIGH SCORE, IF APLICABLE, REPLACE HIGH SCORE WITH NEW HIGH SCORE
		if(highScore < score) {
			highScore = score;
		}
		
		//HIGH SCORE LABLE
		g.setColor(Color.white);
		g.drawString("High score: " + highScore, 100, 45 );
	}
		
		/*
		//COLLECTING THE COIN, IF THERE IS "COLLISION" WITH GAME, POINT INCREASE BY 1
		if(dRect1.intersects(o2b)){
			if(gameStart == true) {
				score++;
				//coin.x += 700;
			}else {
				
			}
			
		}
		
	}
	*/
	
	public static void main(String[] args) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("snake game");
		f.setSize(new Dimension(675, 700));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,1));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			//System.out.println(arg0.getKeyCode());
			
			
			
			//DINO JUMPING USING UP KEY
				//if(arg0.getKeyCode() == 38) {
					 //dino.up();
				//}
		
			
			/*	
			if((dino.y  >= 240) && (upCounter >= upCounterMax)) {
				upCounter = 0;
			}
			*/
			
			
			
			
			//STARTING GAME, PRESS SPACE BAR
			if(arg0.getKeyCode() == 32) {
				gameStart = true;
				
			}		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


