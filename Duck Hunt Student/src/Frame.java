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
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		window1.paint(g);
		window2.paint(g); 
		bg.paint(g);
		tv.paint(g);
		person.paint(g);
		
		//----------------- POSITIONS -------------------//
		window1.setX(bg.getX() + 1252);
		window2.setX(bg.getX() + 1720);
		window1.setY(25);
		window2.setY(40);
		window1.setImage("bad");
		
		tv.setX(bg.getX() + 1747);
		
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
	    if (arg0.getX() > tv.getX() && arg0.getX() < tv.getX() + tv.getWidth()) {
	        tv.setImage();
	        if (tv.getIsTVOn()) {
	            System.out.println("Turning off");
	        } else {
	            System.out.println("Turning on");
	        }
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
