package snake;

import java.util.LinkedList;

public class PartBody extends Square {

	PartBody(int x, int y) {
		super(x, y);
		
	}

	@Override
	String getPath() {
		String list[] = new String[]{"niebies.png","poma.png","red.png","ziel.png","zolt.png","braz.png",};
		return list[0];
	}
	
	public boolean cannibal(LinkedList<PartBody> p)
	{
		
		LinkedList<PartBody> copy = new LinkedList<PartBody>();
		copy = (LinkedList) p.clone();

		
		if(copy.size()>1)
		{
		copy.removeFirst();
		
		for(PartBody b: copy)
		{
			if(this.getX()==b.getX() && this.getY()==b.getY())
			{
				System.out.println(this.getX()+" "+b.getX()+" "+ this.getY()+" "+b.getY());
				return true;
			}
		}
		}
		
		return false;
	}

}
