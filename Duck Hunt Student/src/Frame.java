import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Person person = new Person();
	Background bg = new Background();
	Window window1 = new Window();
	Window window2 = new Window();
	TV tv = new TV();
	Sink sink = new Sink();
	Light light1 = new Light();
	Light light2 = new Light();
	Light light3 = new Light();
	Light light4 = new Light();
	Dresser dresser = new Dresser();
	Clothes clothes = new Clothes();
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		window1.paint(g);
		window2.paint(g); 
		bg.paint(g);
		tv.paint(g);
		sink.paint(g);
		light1.paint(g);
		light2.paint(g);
		light3.paint(g);
		light4.paint(g);
		dresser.paint(g);
		clothes.paint(g);
		person.paint(g);
		
		//----------------- POSITIONS -------------------//
		window1.setX(bg.getX() + 1277);
		window2.setX(bg.getX() + 1680);
		window1.setY(26);
		window2.setY(40);
		window1.setImage("bad");
		
		tv.setX(bg.getX() + 1640);
		
		sink.setX(bg.getX() + 2085);
		
		light1.setX(bg.getX() + 350);
		light2.setX(bg.getX() + 1300);
		light3.setX(bg.getX() + 1550);
		light4.setX(bg.getX() + 2300);
		
		dresser.setX(bg.getX() + 1876);
		clothes.setX(bg.getX() + 1830);
		
		//----------------- BOUNDARIES ------------------//
		if (person.getX() < 10) {
			person.setX(10);
		}
		if (person.getX() + person.getWidth() > 990) {
			person.setX(990 - person.getWidth());
		}
		
		if (bg.getX() > -5){
			bg.setX(-5);
		}
		
		if (bg.getX() + bg.getWidth() < 990){
			bg.setX(990-bg.getWidth());
		}
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Can Your Waffle");
		f.setSize(new Dimension(1000, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(true);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	 
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	    // TODO Auto-generated method stub
		
		// ----------- TV On/Off Collision -------------
	    if (arg0.getX() > tv.getX() && arg0.getX() < tv.getX() + tv.getWidth() && arg0.getY() > tv.getY() && arg0.getY() < tv.getY() + tv.getHeight()) {
	        tv.setImage();
	        if (tv.getIsTVOn()) {
	            System.out.println("Turning tv off");
	        } else {
	            System.out.println("Turning tv on");
	        }
	    }
	    
		// ----------- Sink On/Off Collision -------------
	    if (arg0.getX() > sink.getX() && arg0.getX() < sink.getX() + sink.getWidth() && arg0.getY() > sink.getY() && arg0.getY() < sink.getY() + sink.getHeight()) {
	        sink.setImage();
	        if (sink.getIsSinkOn()) {
	            System.out.println("Turning sink off");
	        } else {
	            System.out.println("Turning sink on");
	        }
	    }
	    
	 // ----------- Light On/Off Collision -------------
	    if (arg0.getX() > light1.getX() && arg0.getX() < light1.getX() + light1.getWidth() && arg0.getY() > light1.getY() && arg0.getY() < light1.getY() + light1.getHeight()) {
	        light1.setImage();
	        if (light1.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	        }
	    }
	    
	    if (arg0.getX() > light2.getX() && arg0.getX() < light2.getX() + light2.getWidth() && arg0.getY() > light2.getY() && arg0.getY() < light2.getY() + light2.getHeight()) {
	        light2.setImage();
	        if (light2.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	        }
	    }
	    
	    if (arg0.getX() > light3.getX() && arg0.getX() < light3.getX() + light3.getWidth() && arg0.getY() > light3.getY() && arg0.getY() < light3.getY() + light3.getHeight()) {
	        light3.setImage();
	        if (light3.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	        }
	    }
	    
	    if (arg0.getX() > light4.getX() && arg0.getX() < light4.getX() + light4.getWidth() && arg0.getY() > light4.getY() && arg0.getY() < light4.getY() + light4.getHeight()) {
	        light4.setImage();
	        if (light4.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	        }
	    }
	    
	    if (arg0.getX() > dresser.getX() && arg0.getX() < dresser.getX() + dresser.getWidth() && arg0.getY() > dresser.getY() && arg0.getY() < dresser.getY() + dresser.getHeight()) {
	        clothes.setImage();
	    }
	    
	    if(arg0.getX() > clothes.getX() && arg0.getX() < clothes.getX() + (clothes.getWidth()/2) && arg0.getY() > clothes.getY() && arg0.getY() < clothes.getY() + clothes.getHeight()) {
	    	person.setOutfitState(1);
	    	clothes.setImage();
	    }
	    
	    if(arg0.getX() > (clothes.getX() + clothes.getWidth()/2) && arg0.getX() < clothes.getX() + clothes.getWidth() && arg0.getY() > clothes.getY() && arg0.getY() < clothes.getY() + clothes.getHeight()) {
	    	person.setOutfitState(2);
	    	clothes.setImage();
	    }
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub	

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
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
		System.out.println(arg0.getKeyCode());
		if (arg0.getKeyCode() == 39) {
			person.setImage(false, true);
			person.rightPressed(true);
			bg.slide(false, true);
		}
		if (arg0.getKeyCode() == 37) {
			person.setImage(true, false);
			person.leftPressed(true);
			bg.slide(true, false);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 39) {
			person.setImage(false, false);
			person.rightPressed(false);
			bg.slide(false, false);
		}
		if (arg0.getKeyCode() == 37) {
			person.setImage(false, false);
			person.leftPressed(false);
			bg.slide(false, false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
