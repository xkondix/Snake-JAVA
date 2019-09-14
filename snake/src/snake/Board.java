package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Board extends JPanel implements KeyListener
{
	LinkedList<PartBody> body;
	Food food;
	public String mode = "right";
	MainThread thread;
	public boolean play = true;

	
	
	public Board()
	{
		super();
	    addKeyListener(this);
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
	    
		body = new LinkedList<PartBody>(); 
		body.add(new PartBody(100,100));
		food=setBounds();
		
		thread = new MainThread(this);
	}
	
	public Boolean game()
	{
		return play;
	}
	
	public void setGame(boolean b)
	{
		this.play=b;
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(PartBody p: body)
		{
			g2.drawImage(p.getImage(),p.getX(),p.getY(),this);

		}
		g2.drawImage(food.getImage(),food.getX(),food.getY(),this);
		
		
		if(!game())
		{
			
			
	
			
			
	    	  g.setColor(Color.RED);
	    	  g.setFont(new Font("Courier New", Font.BOLD, 22));
	    	  g.drawString("GAME OVER PKT -> " + body.size(), getWidth()-370, getHeight()-120);

	    	  
	    	  g.setFont(new Font("Courier New", Font.BOLD, 15));
	    	  g.drawString("TO EXIT PRESS -> E", getWidth()-370, getHeight()-200);
	    	  g.drawString("TO RESTART PRESS -> R", getWidth()-370, getHeight()-220);

	    	 

		}
		

	}
	
	public void color()
	{
		String color = food.getColor();
		
		switch(color)
		{
		case "e1.png":
		{
			for(PartBody b: body)
			{
				b.setImage("red.png");
			}
		break;
		}
		case "e2.png":
		{
			for(PartBody b: body)
			{
				b.setImage("poma.png");
			}
		break;
		}
		case "e3.png":
		{
			for(PartBody b: body)
			{
				b.setImage("ziel.png");
			}
		break;
		}
		case "e4.png":
		{
			for(PartBody b: body)
			{
				b.setImage("zolt.png");
			}
		break;
		}
		case "e5.png":
		{
			for(PartBody b: body)
			{
				b.setImage("niebies.png");
			}
		break;
		}
		case "e6.png":
		{
			for(PartBody b: body)
			{
				b.setImage("braz.png");
			}
		break;
		}
		default:
			System.out.println("error");
		}
	}
	
	public Food setBounds()
	{
		Random rand = new Random();
		Food food = new Food(100,100);

		
		while(true)
		{
			food.setX(rand.nextInt(300)+25);
			food.setY(rand.nextInt(200)+25);
			System.out.println(food.getX());

			if(!food.check(body))
			{
				break;
			}
		}
		
		return food;
		
	}
	
	public void newElement()
	{
		PartBody b = body.get(0);
		if(food.contact(b))
		{
			body.add(new PartBody(b.getX(),b.getY()));
			food = setBounds();
			repaint();
		}
	}
	
	public void next()
	{
		PartBody b = body.get(0);

		
		if(body.size()>1)
		{
			if(getMode()=="left")
			{
				body.addFirst(new PartBody(b.getX()-10,b.getY()));
			}
			else if(getMode()=="right")
			{
				body.addFirst(new PartBody(b.getX()+10,b.getY()));
			}
			else if(getMode()=="up")
			{
				body.addFirst(new PartBody(b.getX(),b.getY()-10));
			}
			else if(getMode()=="down")			
			{
				body.addFirst(new PartBody(b.getX(),b.getY()+10));
			}
			
			body.removeLast();
		}
	}
	
	
	public String getMode()
	{
		return mode;
	}

	@Override
	public void keyPressed(KeyEvent k) {
	
			
		if(game())
			{
				
				
				if ( k.getKeyCode()  == KeyEvent.VK_LEFT)
				{ 
					mode = "left";
					repaint();
				}
				
				if ( k.getKeyCode()  == KeyEvent.VK_RIGHT)
				{ 
					mode = "right";
					repaint();

				}

				if ( k.getKeyCode()  == KeyEvent.VK_UP)
				{ 
					mode = "up";
					repaint();

				}

				
				if ( k.getKeyCode()  == KeyEvent.VK_DOWN)
				{ 
					mode = "down";
					repaint();

				}

			}
		if(!game())
		{
			if( k.getKeyCode()  == KeyEvent.VK_R)
			{
			restart();
			}
		
		
		else if ( k.getKeyCode()  == KeyEvent.VK_E)
		{
			System.exit(0);
		}
			
			
		}

		}
	
	
	public void restart()
	{
		body = new LinkedList<PartBody>(); 
		body.add(new PartBody(100,100));
		food=setBounds();
		setGame(true);
		MainThread thread = new MainThread(this);
		repaint();
	}
	
	public void gameOver()
	{
		
		PartBody b = body.get(0);

		
		if(b.getMinX()<0)
		{
			setGame(false);
		}
		else if(b.getMinY()<0 ) 
	    {
			setGame(false);

	    }
		else if(b.getMaxY()>=300)
	    {
			setGame(false);

	    }
	    
		else if(b.getMaxX()>=400)
	    {
			setGame(false);
	    }
		
		
		
		if(b.cannibal(body) && body.size()>1 )
		{
			setGame(false);
		}
		
		 repaint();
		
	    
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	
	
}
