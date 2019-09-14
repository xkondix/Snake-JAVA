package snake;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class Frame {
	

	   public static void main(String[] args)                       
	   {                                                           
		   javax.swing.SwingUtilities.invokeLater(new Runnable()  
				      //http://pojava.fizyka.pw.edu.pl/images/wyklady/wyklad6.pdf 21str
				      {                                                        
				         public void run()                                     
				         {                                                     
				            
				        	Board board;
				        	board = new Board();
				        	 
				            JFrame jf=new JFrame();              
				            jf.add(board);                                         
				                                                               
				            jf.setTitle("Snake");                       
				            jf.setSize(400,300);
				            jf.setResizable(false);
				            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				            jf.setLocationRelativeTo(null);
				            jf.setVisible(true);
				            
				          

				         }                                                     
				      });     

	   }

}
