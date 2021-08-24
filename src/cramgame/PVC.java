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

import java.awt.Graphics;
import java.awt.Point;

public class PVC extends JPanel implements MouseListener {
	game g;
	JLabel jb;
	JLabel background;
     private JButton Reset;
	Vector<JButton> buttons=new Vector<JButton>();
	JFrame frame = new JFrame();
	public PVC() {
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
     	   this.add(jb);
     	   this.Reset.addMouseListener(this);
     	   getRows(rows);
            this.add(background); 
            //System.out.println("check");
            g.RobotMove(g.getTurn());
           // System.out.println("check22");
    		for(int i = 0; i<g.b.getBoard().size();i++) {
    			for (int j=0 ; j<g.b.getBoard().get(i).size();j++ ) {
    				if(g.b.getBoard().get(i).get(j) == Player.PLAYERONE) {
    				for(JButton ss : buttons ) {
    					
    				if(Integer.parseInt(ss.getName())	== 2*i + j +1) {
    				//10
    					//System.out.println("true");
    					ss.setIcon(getfirst());
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
			j.setIcon(getRandom());
			k.setIcon(getRandom());
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
	public  ImageIcon getRandom() {
		 ImageIcon img;
		try {
			img = new ImageIcon(ImageIO.read(new File("edited5.jpg")));
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
				jb.setForeground(Color.CYAN);
				this.setSize(800, 600);
			
				
				return;
			}
				
				
		
			if(turn == Player.PLAYERTWO) {
				
			demo.setIcon(getsecond());
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
					//System.out.println(ss.getName() +"   "+ (2*i + j +1));
					ss.setIcon(getfirst());
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
