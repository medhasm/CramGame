package cramgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sun.net.www.content.image.jpeg;

import java.awt.Point;

public class PVP extends JPanel implements MouseListener {
	game g;
	
	JLabel jb,p1,background;
	private JButton A1,A4,A3,A2,Reset,back;
	int row, col ;

    public ImageIcon im1=new ImageIcon("edited1.png");
    public ImageIcon im2=new ImageIcon("edited2.png");
    public ImageIcon bl=new ImageIcon("black.png");
    Font font=new Font("Serif",Font.BOLD | Font.ITALIC,24);


	static Piece pc = null;
	JButton[][] buttons;
	JFrame frame = new JFrame();
	
	
	
	
	public PVP() {
		 frame = new JFrame();
				frame.setSize(800, 600);
				frame.setTitle("Cram Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
        JLabel background;
        
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
	       int rows=Integer.parseInt(input);
        	
     	   ;
     	   this.setSize(800, 600);
     	   this.setLayout(null);
     	   background=new JLabel(getbackground());   	   
     	   background.setSize(800, 600);
     	   background.setName("background");
     	   	
     	   p1=new JLabel("** first player turn **");//,this place has been already been taken.
     	   p1.setLocation(300, 60);
     	   p1.setName("MyLabel");
     	   p1.setSize(0, 0);
     	   p1.setSize(670, 30);
     	   p1.setForeground(Color.CYAN);
     	   this.add(p1);
			
			   
     	   jb=new JLabel("Cant place this piece her");//,this place has been already been taken.
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
     	   
     	  this.back=new JButton("");
    	  this.back.setIcon(new ImageIcon("back.png"));
    	  this.back.setLocation(30,400);
    	  this.back.setSize(60, 60);
   	   	  this.add(this.back);
   	    
     	   this.add(jb);
     	   this.Reset.addMouseListener(this);
     	   this.A1.addMouseListener(this);
     	   this.A2.addMouseListener(this);
     	   this.A3.addMouseListener(this);
     	   this.A4.addMouseListener(this);
     	   this.back.addMouseListener(this);

     	   getRows(rows);
     	   this.add(background);
     	   p1.setFont(font);

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
			e.printStackTrace();
		}
		 return null;
	}
	
	public void Reset() {  
		frame.setVisible(false);
		new PVP();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		JButton demo=(JButton) arg0.getComponent();
		if(demo == this.Reset) {			
			Reset();
			return;
		}
		
		
		else if(demo == this.A1) {
			pc=new piece1();
			return;
		}
		else if(demo == this.A2) {
			pc=new piece2();
			return;
		}
		else if(demo == this.A3) {
			pc=new piece3();
			return;
		}
		else if(demo == this.A4) {
			pc=new piece4();
			return;
		}
		else if(demo == this.back) {
			System.out.println("back");
			for(Point p : pc.squares){
				
				if(p.x!=0)
					if ((row+p.getX())>=0  && (row+p.getX())<2 
						)
					{	
						buttons[(int) (row+p.getX())][col].setIcon(null);
						g.b.setBoard(Player.EMPTY, col,(int) (row+p.getX()) );
					}
				if(p.y!=0)
					if((col+p.y)>=0&&(col+p.y)<buttons[0].length
						)
					{
						buttons[row][col+p.y].setIcon(null);
						g.b.setBoard(Player.EMPTY,col+p.y ,row );
					}
			
				buttons[row][col].setIcon(null);
				g.b.setBoard(Player.EMPTY, col,row);
				g.setTurn1();
				if(g.getTurn()==Player.PLAYERONE)
					this.p1.setText("** first player turn **");
				else if(g.getTurn()==Player.PLAYERTWO)
					this.p1.setText("** second player turn **");		
			}
			return;
		}
		
		else if(arg0.getComponent() instanceof JButton) {
			 
			jb.setText("");
			Player turn=g.getTurn();
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
							row=j; 
							col =i;
							
							if (buttons[j][i].getIcon()==bl)
							{
							
								for(Point p : pc.squares){
								
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
								}
							
								g.setTurn1();
								if(g.checkend()) {
									JOptionPane cong=new JOptionPane("Congratulations");
									cong.showMessageDialog(frame, g.getWinner()+" congratulations for winning");
								}
								if(g.getTurn()==Player.PLAYERONE)
									this.p1.setText("** first player turn **");
								else if(g.getTurn()==Player.PLAYERTWO)
									this.p1.setText("** second player turn **");		
							}
						}
						else {
							jb.setText("Cant place this piece her");
							jb.setFont(font);
							   jb.setSize(670, 30);
								jb.setForeground(Color.CYAN);
								this.setSize(800, 600);
								return;
						}
						}
			}
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
		if(arg0.getComponent() instanceof JButton) {
			if (pc!=null )
			{
				for (int j=0; j< 2;j++)
					for(int i=0;i<buttons[0].length;i++)
						if(buttons[j][i].getX()==demo.getX()&&
							buttons[j][i].getY()==demo.getY()){ 
							if (buttons[j][i].getIcon()==null){
								buttons[j][i].setIcon(bl);
							for(Point p : pc.squares){
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
				if (buttons[j][i].getIcon()==bl){
					buttons[j][i].setIcon(null);
				}
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
	public static void main(String[] args) {
		new PVP();
	}
}