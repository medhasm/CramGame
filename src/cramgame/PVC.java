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

import java.awt.Graphics;
import java.awt.Point;

public class PVC extends JPanel implements MouseListener {
	game g;
	JLabel jb;
     private JButton fi;
     private JButton si;
     private JLabel fil;
     private JLabel sil;
     Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,23);
     Color col=new Color(216,180,96);
	Vector<JButton> buttons=new Vector<JButton>();
	

	ImageIcon random;
	ImageIcon fpi;
	ImageIcon spi;

	public PVC() {

        JLabel background;
        Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
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
           
    		  for(int i = 0; i<g.b.getBoard().size();i++) 
    			for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) 
    			 if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) 
    				for(JButton ss : buttons )  	
    				  if(Integer.parseInt(ss.getName())	== 2*i + j +1)	
    					ss.setIcon(this.fpi);
 
    				 
    				
  
    		           

	}
	public void getRows(int rows) {
		//String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
		int numrow=rows;
		g=new game(numrow,true);
		int x=(numrow / 2) * 50;
		int counter=1;
		for(int i=0; i < numrow ; i++ ) {
			JButton j=new JButton();
			JButton k=new JButton();
			j.setName(Integer.toString(counter));
			k.setName(Integer.toString(counter + 1));

			//j.setSize(50, 50);
			//k.setSize(50, 50);
			//j.setLocation(350 - x , 100);
			//k.setLocation(350 - x, 150);
			j.setBounds(350-x, 100, 50, 50);
			k.setBounds(350-x, 150, 50, 50);
			x=x-50;
			j.setIcon(this.random);
			k.setIcon(this.random);
			this.add(j);
			this.add(k);

			counter=counter + 2;
			buttons.add(j);
			buttons.add(k);

			j.addMouseListener(this);
			k.addMouseListener(this);
            this.revalidate();
            this.repaint();
			
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
			vec.add(this.fi);
			vec.add(this.si);
			return vec;
			
		}
		public Vector<JLabel> leftjlabels(){
			Vector<JLabel> vec=new Vector<JLabel>();
			vec.add(this.fil);
			vec.add(this.sil);
			vec.add(this.jb);

			return vec;
			
		}
		 public Vector<JButton> getbuttons(){
			 return buttons;
			 
		 }
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		
		for(int i = 0; i<g.b.getBoard().size();i++) {
			for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) {
				if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) {
				for(JButton ss : buttons ) {
					
				if(Integer.parseInt(ss.getName()) == (2*i + j +1)) {
					
					ss.setIcon(this.fpi);
				}
				}
			}
					
				
			}
			

		}
		//*/
		
		
		if(g.checkend()) {
			JOptionPane cong=new JOptionPane("Congratulations");
			cong.showMessageDialog(this, g.getWinner()+" congratulations for winning");
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

}
