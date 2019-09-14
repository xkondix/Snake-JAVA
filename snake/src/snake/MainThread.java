package snake;

public class MainThread extends Thread {
	
	Board board;
	
	MainThread(Board board)
	{
		super();
		this.board=board;
		this.start();
	}
	
	public void run()
	{
		while(board.game())
		{
			board.color();
						
			if(board.getMode()=="left")
			{
				board.body.get(0).left();
				board.repaint();
			}
			else if(board.getMode()=="right")
			{
				board.body.get(0).right();
				board.repaint();
			}
			else if(board.getMode()=="up")
			{
				board.body.get(0).up();
				board.repaint();
			}
			else if(board.getMode()=="down")			
			{
				board.body.get(0).down();
				board.repaint();
			}
			try {
				sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			

			board.gameOver();
			
			try {
				sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			board.next();
			board.newElement();
			

			
		}
	}

}
