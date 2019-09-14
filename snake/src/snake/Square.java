package snake;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;


public abstract class Square
{
	int x,y;
	Image image = null;
	
	Square(int x, int y)
	{
		this.x=x;
		this.y=y;
		this.image=imageLoad();
	}
	
	public Image imageLoad()
	{
		Image image = new ImageIcon(getClass().getResource(getPath())).getImage();
		image = image.getScaledInstance(10, 10, 10000);
		return image;
		
	}
	
	//public void paint(Graphics g)
	//{
		//Graphics2D g2 = (Graphics2D) g;
		//g2.drawImage(image,getX(),getY(),null);
		//System.out.println("ala");


	
	
	public void setX(int x)
	{
		this.x=x;
	}
	
	public void setY(int y)
	{
		this.y=y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	public void setImage(String path)
	{
		image = new ImageIcon(getClass().getResource(path)).getImage();
		image = image.getScaledInstance(10, 10, 10000);

	}
	
	
	abstract String getPath();
	
	public boolean check(LinkedList<? extends Square> list)
	{
		//Point self = new Point(this.getX(),this.getY());
		//Point other = new Point(s.getX(),s.getY());
		
		Rectangle food = new Rectangle(this.getX(),this.getY(),10,10);
		
		
		for(Square s: list)
		{
			//System.out.println(s instanceof  PartBody);
			
			if(!food.intersects(new Rectangle(s.getX(),s.getY(),10,10)))
			{
				return false;
			}
		}
		
		return true;	
	}
	
	
	public boolean contact(Square s)
	{
		if(new Rectangle(this.getX(),this.getY(),10,10).intersects(new Rectangle(s.getX(),s.getY(),13,13)))
		{
			return true;
		}
		return false;
	}
	
	
	public void left()
	{
		setX(getX()-10);
	}
	
	public void right()
	{
		setX(getX()+10);
	}
	
	public void up()
	{
		setY(getY()-10);
	}
	
	public void down()
	{
		setY(getY()+10);
	}
	
	
	public int getMaxX()
	{
		return x+20;
	}
	
	public int getMaxY()
	{
		return y+20;
	}
	
	public int getMinX()
	{
		return x-10;
	}
	
	public int getMinY()
	{
		return y-10;
	}
	
	
	
}
