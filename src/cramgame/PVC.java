package cramgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Point;

public class PVC extends JPanel implements MouseListener {
	
	game g;

	//JLabel jb;
     private JButton fi;
     private JButton si;
     private JLabel fil;
     private JLabel sil;
    // Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,23);
     Color col=new Color(216,180,96);
	//Vector<JButton> buttons=new Vector<JButton>();
	

	ImageIcon random;
	ImageIcon fpi;
	ImageIcon spi;
	WallPaper wall=new WallPaper();
	JLabel jb,p;
	private JButton A1,A2,A3,A4,Reset;
    public ImageIcon bl=wall.getblack();
    public ImageIcon im1=wall.getfirst();
    public ImageIcon im2=wall.getsecond();
    static Piece pc = null;
	JButton[][] buttons;
    Font font=new Font("Serif",Font.BOLD | Font.ITALIC,24);
	//JFrame frame = new JFrame();

	public void PVCr() {

        JLabel background;
        font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
        WallPaper wall=new WallPaper();

      //  frame.setIconImage(wall.getcramIcon());

   	 random=wall.getRandom();
   	 fpi=wall.getfirst();
   	 spi=wall.getsecond();
   	 
   	 

     random=wall.getRandom();
     fpi=wall.getfirst();
     spi=wall.getsecond();
     fi=new JButton();
     fi.setLocation(60, 300);
     fi.setIcon(wall.getfirst());
     fi.setSize(50,50);
     si=new JButton();
     si.setLocation(60, 365);
     si.setIcon(wall.getsecond());
     si.setSize(50,50);


     fil=new JLabel("First player");
     fil.setLocation(120, 290);
     fil.setSize(300,70);
     fil.setFont(font);
     fil.setForeground(col);

     sil=new JLabel("Second player");
     sil.setLocation(120, 355);
     sil.setSize(300,70);
     sil.setFont(font);
     sil.setForeground(col);

   	int rows=0;
   	while (rows <=2) {
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
	        rows=Integer.parseInt(input);
   	}
        	
     	   
     	   this.setSize(800, 600);
     	   this.setLayout(null);
     	    jb=new JLabel("Cant place this peace her");//,this place has been already been taken.
     	    jb.setLocation(80, 210);
     	    jb.setName("MyLabel");
     	    jb.setForeground(col);
     	    jb.setSize(0, 0);
     	    jb.setLocation(80, 210);
     	    jb.setName("MyLabel");
     	    jb.setSize(0, 0);
     	    
     	   getRows(rows);

	
          
           /// g.play=Player.PLAYERTWO;
            
            g.RobotMove(g.getTurn());
           /*
    		  for(int i = 0; i<g.b.getBoard().size();i++) 
    			for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) 
    			 if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) 
    				for(JButton ss : buttons )  	
    				  if(Integer.parseInt(ss.getName())	== 2*i + j +1)	
    					ss.setIcon(this.fpi);
 
    				 
    				*/
  
	}
	



	
	
	public PVC() {
		

        JLabel background;
        
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
	       int rows=Integer.parseInt(input);
     	   ;
     	   this.setSize(800, 600);
     	   this.setLayout(null);
     	   p=new JLabel("* YOUR  TURN *");//,this place has been already been taken.
     	   p.setLocation(300, 60);
     	   p.setName("MyLabel");
     	   p.setSize(0, 0);
     	   jb=new JLabel();//,this place has been already been taken.
     	   jb.setLocation(80, 210);
     	   jb.setName("MyLabel");
     	   jb.setSize(0, 0);
     	   
     	   this.Reset=new JButton("new Game");
     	   this.Reset.setLocation(0,0);
     	   this.Reset.setSize(100, 30);
     	   this.add(this.Reset);
     	   this.add(jb);
     	   this.add(p);
     	   
     	   this.A1=new JButton("");
    	   this.A1.setIcon(wall.getl());
    	   this.A1.setLocation(100,300);
    	   this.A1.setSize(100, 100);
    	   this.add(this.A1);
   	    
    	   this.A2=new JButton("");
     	   this.A2.setIcon(wall.getl2());
    	   this.A2.setLocation(250,300);
    	   this.A2.setSize(100, 100);
    	   this.add(this.A2);
    	    
    	   this.A3=new JButton("");
    	   this.A3.setIcon(wall.getl3());
    	   this.A3.setLocation(400,300);
    	   this.A3.setSize(100, 100);
    	   this.add(this.A3);
   	    
    	   this.A4=new JButton("");
     	   this.A4.setIcon(wall.getl4());
    	   this.A4.setLocation(550,300);
    	   this.A4.setSize(100, 100);
    	   this.add(this.A4);
    	   
    	   this.add(jb);
    	   
    	   this.A1.addMouseListener(this);
    	   this.A2.addMouseListener(this);
    	   this.A3.addMouseListener(this);
    	   this.A4.addMouseListener(this);

     	   
     	   getRows(rows);
           
          
           g.RobotMove(g.getTurn());
           p.setFont(font);
		   p.setSize(670, 30);
		   p.setForeground(Color.CYAN);
		   this.setSize(800, 600);
           for(int i = 0; i<g.b.getBoard().size();i++) {
    			for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) {
    				if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) {
    					buttons[j][i].setIcon(im1);
    				}
    			}
    		}
           


	}
	
	
	
	
	public void getRows(int rows) {
		//String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
		int numrow=rows;
		g=new game(numrow,true);
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

			j.setIcon(this.random);
			k.setIcon(this.random);

			j.addMouseListener(this);
			k.addMouseListener(this);

			//this.add(j);
			//this.add(k);

			counter=counter + 2;
			buttons[0][i]=j;
			buttons[1][i]=k;

			j.addMouseListener(this);
			k.addMouseListener(this);
           // this.revalidate();
           // this.repaint();
		}
	}


	
	 public static void main(String[] args)
	 {
		 
    new PVC();
	 }
	 public game GetGame() {
		 return this.g;
	 }


		public Vector<JButton> leftbuttons(){
			Vector<JButton> vec=new Vector<JButton>();
			//vec.add(this.fi);
			//vec.add(this.si);
			vec.add(A1);
			vec.add(A2);
			vec.add(A3);
			vec.add(A4);
			return vec;
			
		}
		public Vector<JLabel> leftjlabels(){
			Vector<JLabel> vec=new Vector<JLabel>();
			vec.add(this.fil);
			vec.add(this.sil);
			vec.add(this.jb);

			return vec;
			
		}
		 public JButton[][] getbuttons(){
			 return buttons;
			 
		 }

	
	
	
	public void Reset() {  
		//frame.setVisible(false);
		new PVC();
	  }
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JButton demo=(JButton) arg0.getComponent();
		

			
		int row , col;

	

		
		if( g.getTurn() != Player.PLAYERONE) {
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
			boolean flag=g.move(turn, row, col);
			if(!flag) {
				jb.setFont(font);
			   jb.setSize(670, 30);
				Timer timer = new Timer();
				timer.schedule( new TimerTask()
				{public void run() { jb.setSize(670, 30);} },  1*(1000*1));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {e.printStackTrace();}
					
					
				
				
				
				timer.schedule( new TimerTask() 
				{ public void run() { jb.setSize(0, 0); } },  3*(1000*1));

				return;
			}
				

			if(turn == Player.PLAYERTWO) 	
			demo.setIcon(this.spi);

			
			
		

			
		}
			
	
		
		//g.RobotMove(g.getTurn());
		//*
		/*
		for(int i = 0; i<g.b.getBoard().size();i++) {
			for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) {
				if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) {
				for(JButton ss : buttons ) {
					
				if(Integer.parseInt(ss.getName()) == (2*i + j +1)) {
					
					ss.setIcon(this.fpi);
				}*/

		if(demo == this.Reset) {
			Reset();
			return;
		}
		
		if( g.getTurn() != Player.PLAYERONE) {
			
			if(demo == this.A1) {
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
			jb.setText("");
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
							buttons[j][i].getY()==demo.getY()){
						
					if(validMove( j ,  i ,pc)){
						if (buttons[j][i].getIcon()==bl)
						{
							for(Point p : pc.squares)
								{
								if(p.x!=0)
									if ((j+p.getX())>=0  && (j+p.getX())<2 
									&&  (buttons[(int) (j+p.getX())][i].getIcon()==bl)){	
										buttons[(int) (j+p.getX())][i].setIcon(im);
										g.b.setBoard(turn, i,(int) (j+p.getX()) );
									}
								if(p.y!=0)
									if((i+p.y)>=0&&(i+p.y)<buttons[0].length
									&& (buttons[j][i+p.y].getIcon()==bl)){
										buttons[j][i+p.y].setIcon(im);
										g.b.setBoard(turn,i+p.y ,j );
									}
									
									buttons[j][i].setIcon(im);
									g.b.setBoard(turn, i,j );
							}
							
							g.setTurn();
							if(g.checkend()) {
								JOptionPane cong=new JOptionPane("Congratulations");
								if(g.getWinner()=="second player")
									cong.showMessageDialog(this, "** congratulations you win **");
								else if(g.getWinner()=="first player")
									cong.showMessageDialog(this, "** congratulations computer win **");
							}
							jb.setText("");
							g.RobotMove(g.getTurn());
						}
					}

			

				}
			}
					
			for(int i = 0; i<g.b.getBoard().size();i++) {
			  for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) {
			  	if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) {
			  		buttons[j][i].setIcon(im1);
			  	}
			  }
			}
			if(g.checkend()) {
				JOptionPane cong=new JOptionPane("Congratulations");
				if(g.getWinner()=="second player")
					cong.showMessageDialog(this, "** congratulations you win **");
				else if(g.getWinner()=="first player")
					cong.showMessageDialog(this, "** congratulations computer win **");
			}
			return ;
			}
			

		}
	
		
		
		if(g.checkend()) {
			JOptionPane cong=new JOptionPane("Congratulations");
			cong.showMessageDialog(this, g.getWinner()+" congratulations for winning");
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
			jb.setText("");

	        return true;
	    }
	    
	@Override
	public void mouseEntered(MouseEvent arg0) {

		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	



}
