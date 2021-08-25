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
	JLabel background;
     private JButton Reset;
     private JButton back;
     private JButton Hint;
     private JButton fi;
     private JButton si;
     private JLabel fil;
     private JLabel sil;
     Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,23);
     Color col=new Color(216,180,96);
	Vector<JButton> buttons=new Vector<JButton>();
	JFrame frame = new JFrame();
	ImageIcon backg;
	ImageIcon random;
	ImageIcon fpi;
	ImageIcon spi;
	ImageIcon playback;
	public PVC() {
		 frame = new JFrame();
				frame.setSize(800, 600);
				frame.setTitle("Cram Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				        WallPaper wall=new WallPaper();
				        playback=wall.getplayback();
    	 backg=wall.getbackground();
    	 random=wall.getRandom();
    	 fpi=wall.getfirst();
    	 spi=wall.getsecond();
    	 frame.setIconImage(wall.getcramIcon());
    	 fi=new JButton();
    	fi.setLocation(60, 300);
    	fi.setIcon(wall.getfirst());
    	fi.setSize(50,50);
   	 si=new JButton();
   	si.setLocation(60, 365);
   	si.setIcon(wall.getsecond());
   	si.setSize(50,50);
   	
        JLabel background;
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
        this.add(fil);
        this.add(sil);
        
        

   	
        Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
        int rows=0;
        while(rows <= 2) {
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
	       rows=Integer.parseInt(input);
        }
        	
     	   
     	   this.setSize(800, 600);
     	   this.setLayout(null);
     	   background=new JLabel(this.backg);   	   
     	   background.setSize(800, 600);
     	   background.setName("background");
     	    jb=new JLabel("Cant place this peace her");//,this place has been already been taken.
     	    jb.setForeground(col);
     	    Hint=new JButton();
	      		
     	    this.Hint.setIcon(wall.gethint());
   
     	    this.Hint.setLocation(650,5);
     	    this.Hint.setSize(90, 90);
     	 //   this.back.setOpaque(false);
     	    this.Hint.setContentAreaFilled(false);
     	    
     	    this.Hint.setBorderPainted(false);      
     	    this.Hint.setFocusPainted(false);
     	//this.back.setFont(font);
     	    		
     	    		
     	   this.add(Hint);
     	    back=new JButton("Back");
     	    this.back.setLocation(0,0);
     	    this.back.setSize(90, 90);
     	 //   this.back.setOpaque(false);
     	    this.back.setContentAreaFilled(false);
     	    
     	    this.back.setBorderPainted(false);      
     	    this.back.setFocusPainted(false);
     	//this.back.setFont(font);
     	    		
     	    		
     	    this.back.setIcon(wall.getbackbutton());
     	    jb.setLocation(80, 210);
     	    jb.setName("MyLabel");
     	    jb.setSize(0, 0);
     	    this.Reset=new JButton("new Game");
     	    this.Reset.setLocation(100,10);
     	    this.Reset.setSize(60, 70);
     	    this.Reset.setIcon(playback);
     	    this.Reset.setContentAreaFilled(false);
     	    
     	    this.Reset.setBorderPainted(false);      
     	    this.Reset.setFocusPainted(false);
     	    this.add(this.back);
     	   this.add(this.Reset);
     	   this.add(jb);
     	   this.Reset.addMouseListener(this);
     	   this.back.addMouseListener(this);
     	   getRows(rows);
     	   this.add(fi);
     	   this.add(si);
            this.add(background);
            
          
           /// g.play=Player.PLAYERTWO;
            
            g.RobotMove(g.getTurn());
           
    		for(int i = 0; i<g.b.getBoard().size();i++) {
    			for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) {
    				if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) {
    				for(JButton ss : buttons ) {
    					
    				if(Integer.parseInt(ss.getName())	== 2*i + j +1) {
    				
    				
    					ss.setIcon(this.fpi);
    				}
    				}  
    				}
    			}
    		}
   		 this.repaint();
   		 this.revalidate();
          frame.getContentPane().add(this);
        frame.setVisible(true);

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
	  public void Reset() {  
		  
		  frame.setVisible(false);
		  new PVC();
		  
		  
		  /*
    // System.out.println( this.getComponentCount());
      for(JButton but : buttons) {		  
    		 // but.setVisible(false);
    		  this.remove(but);

    	  }
      frame.revalidate();
      frame.repaint();
      
    buttons=new Vector<JButton>();
       this.setVisible(false);
       frame.remove(this);
       frame.revalidate();
       
    	//  this.setLayout(null);
      // System.out.println(buttons.size());
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
       int rows=Integer.parseInt(input);
		getRows(rows);
		this.setVisible(true);
       frame.getContentPane().add(this);
       
       
       //g=new game(rows,false);
       //System.out.println("size"+this.getComponentCount());
       //frame.getContentPane().remove(this);
       //frame.getContentPane().add(this);
     frame.revalidate();
     frame.repaint();
     */

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
	
		if(demo == this.back) {
			
			this.back.setSize(85,70);
			frame.setVisible(false);
			new GUI();
			return;
		}
		
		if( g.getTurn() != Player.PLAYERONE) {
		if(arg0.getComponent() instanceof JButton) {
			
		
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
				{ 
				    public void run() { 
				    // do your work 
				    	jb.setSize(670, 30);
				    	//System.out.println("yes");
				    } 
				},  1*(1000*1));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				timer.schedule( new TimerTask() 
				{ 
				    public void run() { 
				    // do your work 
				    	jb.setSize(0, 0);
				    	
				    } 
				},  3*(1000*1));
				
				this.setSize(800, 600);
			
				
				return;
			}
				
				
		
			if(turn == Player.PLAYERTWO) {
				
			demo.setIcon(this.spi);
			frame.revalidate();
			frame.repaint();
			
			
		}

			frame.repaint();
			frame.revalidate();
			
		}
			
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
			
			frame.repaint();
			frame.revalidate();
		}
		//*/
		
		
		if(g.checkend()) {
			JOptionPane cong=new JOptionPane("Congratulations");
			cong.showMessageDialog(frame, g.getWinner()+" congratulations for winning");
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JButton demo=(JButton) arg0.getComponent();
		if(demo == this.back) {
			
			this.back.setSize(85,70);
			return;
		}
		if(demo == this.Reset) {
			
			this.Reset.setSize(70,70);
			return;
		}
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if((JButton) arg0.getComponent() == this.back) {
			
			this.back.setSize(90,90);
			return;
		}
		if((JButton) arg0.getComponent() == this.Reset) {
			
			this.Reset.setSize(60,70);
			return;
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
