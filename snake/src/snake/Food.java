package snake;

import java.util.Random;

public class Food extends Square {

	private String color;
	private static String list[] = new String[]{"e1.png","e2.png","e3.png","e4.png","e5.png","e6.png",};
	
	Food(int x, int y) {
		super(x, y);
	}

	@Override
	String getPath() 
	{
		Random rand = new Random();
		color = list[rand.nextInt(6)];
		return color;
	}
	
	String getColor()
	{
		return color;
	}
	
	
	

}
