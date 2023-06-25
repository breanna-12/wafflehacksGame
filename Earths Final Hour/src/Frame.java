import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.awt.MouseInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Person person = new Person();
	Intro intro = new Intro();
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
	Car car = new Car();
	Bathtub bathtub = new Bathtub();
	Shower shower = new Shower();
	
	// ---------- FOOD ------------ //
	Food meat = new Food(150, 85, 0.2,0.2,"meat");
	Food milk = new Food(160,185, 0.10,0.10,"milk");
	Food rice = new Food(190,330, 0.07 , 0.07,"rice");
	Food trash = new Food(650, 350, 0.8,0.8,"trash");
	Food lettuce = new Food(150,220,0.15,0.15,"lettuce");
	Food eggs = new Food(185,195,0.15,0.15,"eggs");
	Food chocolate = new Food(230,230,0.2,0.2,"chocolate");
	Food apples = new Food(160,275,0.15,0.15,"apples");
	Food cereal = new Food(430,125,0.1,0.1,"cereal");
	Food beans = new Food(480,135,0.1,0.1,"beans");
	Food almonds = new Food(350,60,0.1,0.1,"almonds");
	int score = 0;
	double co2 = 0;
	double water =0;
	Font f1 = new Font("Calibri",Font.BOLD,30);
	String status = " ";
	
	Timer timer = new Timer(16, this);
	
	int meatleft = 2;
	int milkleft=1;
	int riceleft=4;
	int trashleft=1;
	int lettuceleft=2;
	int eggsleft=2;
	int chocolateleft=5;
	int applesleft = 7;
	int cerealleft=2;
	int beansleft=3;
	int almondsleft=3;
	
	 String carText = " ";
		String storeText = " ";
		int max = 15;
		int min = 2;
		int range = max - min + 1;
		int m = (int)(Math.random() * range) + min;
		int num = (int)(Math.random() * 8);

	
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
		car.paint(g);
		bathtub.paint(g);
		shower.paint(g);
		
		// --------- FOOD --------- //
		meat.paint(g);
		milk.paint(g);
		rice.paint(g);
		trash.paint(g);
		lettuce.paint(g);
		eggs.paint(g);
		chocolate.paint(g);
		apples.paint(g);
		cereal.paint(g);
		beans.paint(g);
		almonds.paint(g);
		
		person.paint(g);
		
		intro.paint(g);
		
		g.setFont(f1);			
		g.drawString(status,400,250);
		timer.start();

		//car stuff
		g.drawString(carText, 200, 140);
		g.drawString(storeText, 200, 140);

		
		//----------------- POSITIONS -------------------//
		window1.setX(bg.getX() + 1277);
		window2.setX(bg.getX() + 1680);
		window1.setY(26);
		window2.setY(40);
		
		tv.setX(bg.getX() + 1640);
		
		sink.setX(bg.getX() + 2085);
		
		light1.setX(bg.getX() + 350);
		light2.setX(bg.getX() + 1315);
		light3.setX(bg.getX() + 1550);
		light4.setX(bg.getX() + 2300);
		
		dresser.setX(bg.getX() + 1876);
		clothes.setX(bg.getX() + 1830);
		
		bathtub.setX(bg.getX() + 2220);
		
		shower.setX(bg.getX() + 2435);
		
		if(!car.getIsPersonInCar()) {
			car.setX(bg.getX() + 50);
		}
		
			// Food Positions //
		meat.setX(bg.getX() + 870);
		milk.setX(bg.getX() + 880);
		rice.setX(bg.getX() + 910);
		trash.setX(bg.getX() + 1370);
		lettuce.setX(bg.getX() + 870);
		eggs.setX(bg.getX() + 905);
		chocolate.setX(bg.getX() + 950);
		apples.setX(bg.getX() + 880);
		cereal.setX(bg.getX() + 1150);
		beans.setX(bg.getX() + 1200);
		almonds.setX(bg.getX() + 1070);	

		
		//----------------- BOUNDARIES ------------------//
		
		//person
		if(!car.getIsPersonInCar()) {
		if (person.getX() < 10 && person.getX() > -100) {
			person.setX(10);
		}
		if (person.getX() + person.getWidth() > 990) {
			person.setX(990 - person.getWidth());
		}
		}
				
		//car
		if (car.getX() > bg.getX()+ 10){
			car.setX(bg.getX()+ 10);
		}
				
		if (car.getX() + car.getWidth() < bg.getX()-1000){
			car.setX(bg.getX()-15);
		}
				
		//bg
		if (bg.getX() > -5){
			bg.setX(-5);
		}
				
		if (bg.getX() + bg.getWidth() < 990){
			bg.setX(990-bg.getWidth());
		}
		
		//car
		if (person.getX() + person.getWidth() < bg.getX()+900){
			storeText = "click car to drive to store";
			if(car.getIsPersonInCar()) {
				storeText = " ";
			}
		}
		else {
			storeText = " ";
			}
				
				
		if (car.getX() + car.getWidth() < bg.getX()-300){
			carText = "you traveled " + m + " miles";
		}
		else {
			carText = " ";
		}
		
		// ------- WINDOWS -------- //
		if (score > 0 && score < 40) {
			window1.setImage("good");
			window2.setImage("good");
		}
		else if (score > 41 && score < 90) {
			window1.setImage("mid");
			window2.setImage("mid");
		}
		else if (score > 91) {
			window1.setImage("bad");
			window2.setImage("bad");
		}
		System.out.println(score);
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Earth's Final Hour");
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
		
		// ----------- INTRO CLICK -------------
		if (intro.getX() == 0 && intro.getY() == 0) {
			if (arg0.getX() > 333 && arg0.getX() < 666 && arg0.getY() > 150 && arg0.getY() < 450) {
				intro.setScaleX(0.2);
				intro.setScaleY(0.2);
				intro.setY(-400);
			}
		}
		
		// ----------- TV On/Off Collision -------------
	    if (arg0.getX() > tv.getX() && arg0.getX() < tv.getX() + tv.getWidth() && arg0.getY() > tv.getY() && arg0.getY() < tv.getY() + tv.getHeight()) {
	        tv.setImage();
	        if (tv.getIsTVOn()) {
	            System.out.println("Turning tv off");
	        } else {
	            System.out.println("Turning tv on");
	            score += 3;
	            co2+=3.2;
	        }
	    }
	    
		// ----------- Sink On/Off Collision -------------
	    if (arg0.getX() > sink.getX() && arg0.getX() < sink.getX() + sink.getWidth() && arg0.getY() > sink.getY() && arg0.getY() < sink.getY() + sink.getHeight()) {
	        sink.setImage();
	        if (sink.getIsSinkOn()) {
	            System.out.println("Turning sink off");
	        } else {
	            System.out.println("Turning sink on");
	            score += 2;
	            water+=20;
	        }
	    }
	    
	 // ----------- Shower On/Off Collision -------------
	    if (arg0.getX() > shower.getX() && arg0.getX() < shower.getX() + shower.getWidth() && arg0.getY() > shower.getY() && arg0.getY() < shower.getY() + shower.getHeight()) {
	        shower.setImage();
	        if (shower.getisShowerOn()) {
	            System.out.println("Turning shower off");
	        } else {
	            System.out.println("Turning shower on");
	            score += 4;
	            water+=16;
	        }
	    }
	    
	 // ----------- Light On/Off Collision -------------
	    if (arg0.getX() > light1.getX() && arg0.getX() < light1.getX() + light1.getWidth() && arg0.getY() > light1.getY() && arg0.getY() < light1.getY() + light1.getHeight()) {
	        light1.setImage();
	        if (light1.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	            score += 2;
	            co2+=1.39;
	        }
	    }
	    
	    if (arg0.getX() > light2.getX() && arg0.getX() < light2.getX() + light2.getWidth() && arg0.getY() > light2.getY() && arg0.getY() < light2.getY() + light2.getHeight()) {
	        light2.setImage();
	        if (light2.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	            score += 2;
	            co2+=1.39;
	        }
	    }
	    
	    if (arg0.getX() > light3.getX() && arg0.getX() < light3.getX() + light3.getWidth() && arg0.getY() > light3.getY() && arg0.getY() < light3.getY() + light3.getHeight()) {
	        light3.setImage();
	        if (light3.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	            score += 2;
	            co2+=1.39;
	        }
	    }
	    
	    if (arg0.getX() > light4.getX() && arg0.getX() < light4.getX() + light4.getWidth() && arg0.getY() > light4.getY() && arg0.getY() < light4.getY() + light4.getHeight()) {
	        light4.setImage();
	        if (light4.getisLightOn()) {
	            System.out.println("Turning light off");
	        } else {
	            System.out.println("Turning light on");
	            score += 2;
	            co2+=1.39;
	        }
	    }
	    
	    if (arg0.getX() > dresser.getX() && arg0.getX() < dresser.getX() + dresser.getWidth() && arg0.getY() > dresser.getY() && arg0.getY() < dresser.getY() + dresser.getHeight()) {
	        clothes.setImage();
	    }
	    
	    if(arg0.getX() > clothes.getX() && arg0.getX() < clothes.getX() + (clothes.getWidth()/2) && arg0.getY() > clothes.getY() && arg0.getY() < clothes.getY() + clothes.getHeight()) {
	    	person.setOutfitState(1);
	    	clothes.setImage();
            score += 2;
            co2+=15;
            water +=700;
            
	    }
	    
	    if(arg0.getX() > (clothes.getX() + clothes.getWidth()/2) && arg0.getX() < clothes.getX() + clothes.getWidth() && arg0.getY() > clothes.getY() && arg0.getY() < clothes.getY() + clothes.getHeight()) {
	    	person.setOutfitState(2);
	    	clothes.setImage();
            score += 4;
            co2+=25;
            water+=8000;
	    }
	    
	    // --------- Bathtub Collision ----------- //
	    if (arg0.getX() > bathtub.getX() && arg0.getX() < bathtub.getX() + bathtub.getWidth() && arg0.getY() > bathtub.getY() && arg0.getY() < bathtub.getY() + bathtub.getHeight()) {
	        bathtub.setImage();
	        if (bathtub.getIsBathtubOn()) {
	            System.out.println("Turning bathtub off");
	        } else {
	            System.out.println("Turning bathtub on");
	            score += 5;
	            water +=40;
	        }
	    }
	    
	 // ----------- Car Person In/Out Collision -------------
		 if (arg0.getX() > car.getX() && arg0.getX() < car.getX() + car.getWidth()) {
			 car.setImage();
			 if (car.getIsPersonInCar()) {
				 System.out.println("person out of car");
				 person.setX(-100000000);
			 } 
			 else {
				 System.out.println("person in car");
				 person.setX(10);
		         score += 5;
		         co2+=5;
			 }
		 }

		 
		 // ----------- FOOD ----------- //
		//TRASHCLICK
			trash.clicked();
			if(arg0.getX()>trash.getX()&&arg0.getX()<trash.getX()+3*trash.width() && arg0.getY()>trash.getY()+trash.height()&&arg0.getY()<trash.getY()+3*trash.height()){
				System.out.println("trash");
				if(trashleft>0) {
				score+=1;
				trashleft-=1;
			 status= trashleft+" trash left";
			 }
				else {
					status="No trash left";
					
				}
				repaint();
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
		 }
			
			
			
			
			//MEATCLICKED
			meat.clicked();
			if(arg0.getX()>meat.getX()&&arg0.getX()<meat.getX()+meat.width() && arg0.getY()>meat.getY()+meat.height()&&arg0.getY()<meat.getY()+2*meat.height()){
				System.out.println("meat");
				if (meatleft>1) {
					meat.setY(85);
					co2+=15.5;
					water=1;
					score+=5;
					trashleft+=1;
					meatleft-=1;
					status= meatleft+" meat left";
				}
				else{
					meat.setY(-300);
					status="No meat, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
				
			}
			
			
			//MILK CLICKED
			milk.clicked();
			if(arg0.getX()>milk.getX()&&arg0.getX()<milk.getX()+0.5*milk.width() && arg0.getY()>milk.getY()&&arg0.getY()<milk.getY()+0.8*milk.height()) {
				System.out.println("milk");
				if (milkleft>1) {
					milk.setY(185);
					co2+=0.8;
					score+=4;
					trashleft+=1;
					milkleft-=1;
					status= milkleft+" milk left";
				}
				else{
					milk.setY(-1000);
					status="No milk, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
				
				
			}
			
			
			//RICE CLICKED
			rice.clicked();
			if(arg0.getX()>rice.getX()&&arg0.getX()<rice.getX()+rice.width() && arg0.getY()>rice.getY()+10&&arg0.getY()<rice.getY()+1.5*rice.height()) {
				System.out.println("rice");
				if (riceleft>1) {
					rice.setY(330);
					co2+=0.16;
					score+=2;
					trashleft+=1;
					riceleft-=1;
					status= riceleft+" rice left";
				}
				else{
					rice.setY(-1000);
					status="No rice, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
			}
			
		
			//LETTUCECLICKED
			lettuce.clicked();
			if(arg0.getX()>lettuce.getX()+10&&arg0.getX()<lettuce.getX()+2.5*lettuce.width() && arg0.getY()>lettuce.getY()+lettuce.width()&&arg0.getY()<lettuce.getY()+2*lettuce.height()) {
				System.out.println("lettuce");
				if (lettuceleft>1) {
					lettuce.setY(220);
					co2+=3;
					score+=2;
					trashleft+=1;
					lettuceleft-=1;
					status= lettuceleft+" lettuce left";
				}
				else{
					lettuce.setY(-1000);
					status="No lettuce, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
			}
			
			
			//EGGS CLICKED
			eggs.clicked();
			if(arg0.getX()>eggs.getX()&&arg0.getX()<eggs.getX()+1.5*eggs.width() && arg0.getY()>eggs.getY()+0.3*eggs.height()&&arg0.getY()<eggs.getY()+1.5*eggs.height()) {
				System.out.println("eggs");
				if (eggsleft>1) {
					eggs.setY(195);
					co2+=3.18;
					score+=2;
					trashleft+=1;
					eggsleft-=1;

					status= eggsleft+" eggs left";
				}
				else{
					eggs.setY(-1000);
					status="No eggs, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
			}
			
			
			
			//CHOCOLATE CLICKED
			chocolate.clicked();
			
			if(arg0.getX()>chocolate.getX()+chocolate.width()&&arg0.getX()<chocolate.getX()+2*chocolate.width() && arg0.getY()>chocolate.getY()+0.3*chocolate.height()&&arg0.getY()<chocolate.getY()+2*chocolate.height()) {
				System.out.println("choco");
				if (chocolateleft>1) {
					chocolate.setY(230);
					co2+=0.95;
					water+=0.4;
					score+=4;
					trashleft+=1;
					chocolateleft-=1;
					status= chocolateleft+" chocolate left";
				}
				else{
					chocolate.setY(-1000);
					status="No chocolate, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
			}
			
			//APPLES CLICKED
			apples.clicked();
			if(arg0.getX()>apples.getX()&&arg0.getX()<apples.getX()+2.5*apples.width() && arg0.getY()>apples.getY()+0.9*apples.height()&&arg0.getY()<apples.getY()+1.5*apples.height()) {
				System.out.println("apples");
				if (applesleft>1) {
					apples.setY(275);
					co2+=0.06;
					score+=1;
					trashleft+=1;
					applesleft-=1;
					status= applesleft+" apples left";
				}
				else{
					apples.setY(-1000);
					status="No apples, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
			}
			
			
			
			//CEREAL CLICKED
			cereal.clicked();
			if(arg0.getX()>cereal.getX()-5&&arg0.getX()<cereal.getX()+2*cereal.width() && arg0.getY()>cereal.getY()+cereal.height()&&arg0.getY()<cereal.getY()+3*cereal.height()) {
				System.out.println("cereal");
				if (cerealleft>1) {
					cereal.setY(125);
					co2+=2.64;
					score+=2;
					trashleft+=1;
					cerealleft-=1;
					status= cerealleft+" cereal left";
				}
				else{
					cereal.setY(-1000);
					status="No cereal, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
			}
			
			
			
			//BEANS CLICKED
			beans.clicked();
			if(arg0.getX()>beans.getX()&&arg0.getX()<beans.getX()+beans.width() && arg0.getY()>beans.getY()+0.5*beans.height()&&arg0.getY()<beans.getY()+1.7*beans.height()) {
				System.out.println("beans");
				if (beansleft>1) {
					beans.setY(135);
					co2+=0.8;
					score+=1;
					trashleft+=1;
					beansleft-=1;
					status= beansleft+" beans left";
				}
				else{
					beans.setY(-1000);
					status="No beans, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
			}
			
			
			
			
			//ALMONDS CLICKED
			almonds.clicked();
			if(arg0.getX()>almonds.getX()&&arg0.getX()<almonds.getX()+almonds.width() && arg0.getY()>almonds.getY()&&arg0.getY()<almonds.getY()+2*almonds.height()) {
				System.out.println("almonds");
				if (almondsleft>1) {
					almonds.setY(60);
					co2+=1.2;
					water+=0.5;
					score+=3;
					trashleft+=1;
					almondsleft-=1;
					status= almondsleft+" almonds left";
				}
				else{
					almonds.setY(-1000);
					status="No almonds, go to car";
				}
			 repaint();
			
			 new Thread(() -> {
		 try {
		 Thread.sleep(4000);
		 } catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		 status = "";
		 repaint();
		 }).start();
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
		
		//for car
		if (arg0.getKeyCode() == 39 && car.getIsPersonInCar()) {
			car.rightPressed(true);
			bg.slide(false, true);
			car.update();
		}
		if (arg0.getKeyCode() == 37 && car.getIsPersonInCar()) {
			car.leftPressed(true);
			bg.slide(true, false);
			car.update();
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
		
		//for car
		if (arg0.getKeyCode() == 39 && car.getIsPersonInCar()) {
			car.rightPressed(false);
			bg.slide(false, false);
			car.update();
		}
		if (arg0.getKeyCode() == 37 && car.getIsPersonInCar()) {
			car.leftPressed(false);
			bg.slide(false, false);
			car.update();
		}


		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
