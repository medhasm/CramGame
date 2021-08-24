package cramgame;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import com.sun.prism.Image;


import java.awt.Graphics;
import java.awt.Point;

public class PVP extends JPanel implements MouseListener {
	game g;
	
	JLabel jb;
	JLabel background;
	private JButton A1;
	private JButton A2;
	private JButton A3;
	private JButton A4;

    public ImageIcon im1=new ImageIcon("edited1.png");
    public ImageIcon im2=new ImageIcon("edited2.png");

	static Piece pc = null;
    private JButton Reset;
    public ImageIcon bl=new ImageIcon("black.png");
	JButton[][] buttons;
	JFrame frame = new JFrame();
	public PVP() {
		 frame = new JFrame();
				frame.setSize(800, 600);
				frame.setTitle("Cram Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
        JLabel background;
        Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
        
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
	       int rows=Integer.parseInt(input);
        	
     	   ;
     	   this.setSize(800, 600);
     	   this.setLayout(null);
     	   background=new JLabel(getbackground());   	   
     	   background.setSize(800, 600);
     	   background.setName("background");
     	    jb=new JLabel("Cant place this peace her");//,this place has been already been taken.
     	    jb.setLocation(80, 210);
     	    jb.setName("MyLabel");
     	    jb.setSize(0, 0);
     	    this.Reset=new JButton("new Game");
     	    this.Reset.setLocation(0,0);
     	    this.Reset.setSize(100, 30);
     	    this.add(this.Reset);
     	    
     	   this.A1=new JButton("");
     	   this.A1.setIcon(new ImageIcon("l.png"));
    	    this.A1.setLocation(100,300);
    	    this.A1.setSize(100, 100);
    	    this.add(this.A1);
    	    
    	    this.A2=new JButton("");
      	   this.A2.setIcon(new ImageIcon("l2.png"));
     	    this.A2.setLocation(250,300);
     	    this.A2.setSize(100, 100);
     	    this.add(this.A2);
     	    
     	   this.A3=new JButton("");
     	   this.A3.setIcon(new ImageIcon("l3.png"));
    	    this.A3.setLocation(400,300);
    	    this.A3.setSize(100, 100);
    	    this.add(this.A3);
    	    
    	   this.A4=new JButton("");
      	   this.A4.setIcon(new ImageIcon("l4.png"));
     	   this.A4.setLocation(550,300);
     	   this.A4.setSize(100, 100);
     	   this.add(this.A4);
     	   
     	   this.add(jb);
     	   this.Reset.addMouseListener(this);
     	   this.A1.addMouseListener(this);
     	   this.A2.addMouseListener(this);
     	   this.A3.addMouseListener(this);
     	   this.A4.addMouseListener(this);

     	   getRows(rows);
            this.add(background);
            
   		 this.repaint();
   		 this.revalidate();
          frame.getContentPane().add(this);
        frame.setVisible(true);

	}
	public void getRows(int rows) {
		//String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
		int numrow=rows;
		g=new game(numrow,false);
		int x=(numrow / 2) * 50;
		int counter=1;
		buttons=new JButton[2][rows];
		for(int i=0; i < numrow ; i++ ) {
			JButton j=new JButton();
			JButton k=new JButton();
			j.setName(Integer.toString(counter));
			k.setName(Integer.toString(counter + 1));
			j.setBounds(350-x, 100, 50, 50);
			k.setBounds(350-x, 150, 50, 50);
			x=x-50;
			this.add(j);
			this.add(k);

			counter=counter + 2;
			buttons[0][i]=j;
			buttons[1][i]=k;


			j.addMouseListener(this);
			k.addMouseListener(this);
            this.revalidate();
            this.repaint();
			
		}
	}
	
	public ImageIcon getbackground() {
		ImageIcon img;
		try {
  	   img=new ImageIcon(ImageIO.read(new File("background4.jpg")));
  	 return img;
   
     } catch (IOException e   ) {
         e.printStackTrace();
     }
		return null;
		
	}
	public  ImageIcon getfirst() {
		 ImageIcon img;
		try {
			img = new ImageIcon(ImageIO.read(new File("edited1.png")));
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
		
		
	}
	
	public  ImageIcon getsecond() {
		 ImageIcon img;
		try {
			img = new ImageIcon(ImageIO.read(new File("edited2.png")));
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
		
		
	}
	
	 public static void main(String[] args)
	 {

		 new PVP();
	 }
	  public void Reset() {  
		  
		  frame.setVisible(false);
		  new PVP();
	  }		  
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
			JButton demo=(JButton) arg0.getComponent();
		int row , col;
		if(demo == this.Reset) {
			
			Reset();
			return;
		}
		else if(demo == this.A1) {
			
			pc=new piece1();
			System.out.println("111");
			return;
		}
		else if(demo == this.A2) {
	
			pc=new piece2();
			System.out.println("2");

			return;
		}
		else if(demo == this.A3) {
	
			pc=new piece3();
			System.out.println("3");

			return;
		}
		else if(demo == this.A4) {
	
			pc=new piece4();
			System.out.println("4");

			return;
		}
		else if(arg0.getComponent() instanceof JButton) {
			
		
			int c=Integer.parseInt(demo.getName());
			int v=c%2;
			if(v == 1) {
			 row=(c/2) ;
			 col=v - 1;
			}else {
				row = (c/2) - 1;
				col = 1;
				
			}
			Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
			Player turn=g.getTurn();
			System.out.println(turn);
			ImageIcon im=null;
			if (turn==Player.PLAYERONE)
				im=new ImageIcon("edited1.png");
			else 
				im=new ImageIcon("edited2.png");
				
				if (pc!=null)
			{
				for (int j=0; j< 2;j++)
				for(int i=0;i<buttons[0].length;i++)
					if(buttons[j][i].getX()==demo.getX()&&
						buttons[j][i].getY()==demo.getY())
					{
					
						if(validMove( j ,  i ,pc)){
						if (buttons[j][i].getIcon()==bl)
						{
							
							for(Point p : pc.squares)
							{
								
								if(p.x!=0)
								if ((j+p.getX())>=0  && (j+p.getX())<2 
								&&  (buttons[(int) (j+p.getX())][i].getIcon()==bl))
								{	
										buttons[(int) (j+p.getX())][i].setIcon(im);
										g.b.setBoard(turn, i,(int) (j+p.getX()) );
								}
								if(p.y!=0)
								if((i+p.y)>=0&&(i+p.y)<buttons[0].length
								&& (buttons[j][i+p.y].getIcon()==bl))
								{
										buttons[j][i+p.y].setIcon(im);
										g.b.setBoard(turn,i+p.y ,j );
								}
								
								buttons[j][i].setIcon(im);
								g.b.setBoard(turn, i,j );
								if(g.checkend())
									System.out.println("end");

							}
						g.setTurn();
						}
					}
						
						}
			}
		
			
			
		
			
	}
		if(g.checkend()) {
			JOptionPane cong=new JOptionPane("Congratulations");
			cong.showMessageDialog(frame, g.getWinner()+" congratulations for winning");
		}
	}
	 public boolean validMove(int j , int i ,Piece pce) {
	        
	        int r = 0;
	        int c = 0;
	        
	        for (Point p : pce.squares) {
	            
	            // Uses the relative x,y positions of the current piece point to its origin block to get a real tile on the grid
	            r = j + p.x;
	            c = i + p.y;
	            
	            // Makes sure point is within the grid and no other piece is on that tile
	            if(!((r >= 0 && r < 2) && (c >= 0 && c < buttons[0].length)) 
	            		|| buttons[r][c].getIcon() != bl ) {
	                System.out.println("ggggggggggggg");
	            	return false;
	            }
	        }
	        
	        return true;
	    }
	    
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		JButton demo=(JButton) arg0.getComponent();
		 int row ,col;
		if(arg0.getComponent() instanceof JButton) {
			
			
			if (pc!=null )
			{
				for (int j=0; j< 2;j++)
				for(int i=0;i<buttons[0].length;i++)
					if(buttons[j][i].getX()==demo.getX()&&
							buttons[j][i].getY()==demo.getY())
					
					{ 

					if (buttons[j][i].getIcon()==null)
						{
						
							buttons[j][i].setIcon(bl);
							for(Point p : pc.squares)
							{
								if(p.x!=0)
									if ((j+p.getX())>=0  && (j+p.getX())<2 &&  (buttons[(int) (j+p.getX())][i].getIcon()==null))
										buttons[(int) (j+p.getX())][i].setIcon(bl);
								if(p.y!=0)
									if((i+p.y)>=0&&(i+p.y)<buttons[0].length&& (buttons[j][i+p.y].getIcon()==null))
										buttons[j][i+p.y].setIcon(bl);

							}
						}
						}
			}
		}
				

		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {

		for (int j=0; j< 2;j++)
			for(int i=0;i<buttons[0].length;i++)
				if (buttons[j][i].getIcon()==bl)
				{
					buttons[j][i].setIcon(null);
				}
					
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	 private void showPreviews() {
		 
	 }
	
}