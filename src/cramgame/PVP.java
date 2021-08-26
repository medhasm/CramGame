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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.corba.se.spi.orbutil.fsm.FSMImpl;

import java.awt.Graphics;
import java.awt.Point;

public class PVP extends JPanel implements MouseListener {
	game g;
	JLabel jb;
	JLabel background;
	Vector<JButton> buttons=new Vector<JButton>();
	  Color col=new Color(216,180,96);
	  Font font=new Font("Amasis MT Pro Black",Font.BOLD | Font.ITALIC,23);
    JButton fi;
   JButton si;
   JButton L;
   JButton LL;
   JButton LLL;
   JButton LLLL;
     JLabel fil;
     JLabel sil;
	ImageIcon random;
	ImageIcon fpi;
	ImageIcon spi;
	ImageIcon bluewood;
	public PVP() {

        JLabel background;
        Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
        WallPaper wall=new WallPaper();
         L=new JButton();
         LL=new JButton();
         LLL=new JButton();
         LLLL=new JButton();
         L.setSize(125,125);
         L.setLocation(270,300);
         L.setIcon(wall.getL());
         L.setOpaque(false);
         L.setBorderPainted(false);
  	     L.setContentAreaFilled(false); 
  	     L.setBorderPainted(false);      
  	     L.setFocusPainted(false);
         LL.setSize(125,125);
         LL.setLocation(375,300);
         LL.setIcon(wall.getLL());
         LL.setOpaque(false);
         LL.setBorderPainted(false);
  	     LL.setContentAreaFilled(false); 
  	     LL.setBorderPainted(false);      
  	     LL.setFocusPainted(false);
         LLL.setSize(125,125);
         LLL.setLocation(480,300);
         LLL.setIcon(wall.getLLL());
         LLL.setOpaque(false);
         LLL.setBorderPainted(false);
  	     LLL.setContentAreaFilled(false); 
  	     LLL.setBorderPainted(false);      
  	     LLL.setFocusPainted(false);
         LLLL.setSize(125,125);
         LLLL.setLocation(585,300);
         LLLL.setIcon(wall.getLLLL());
         LLLL.setOpaque(false);
         LLLL.setBorderPainted(false);
  	     LLLL.setContentAreaFilled(false); 
  	     LLLL.setBorderPainted(false);      
  	     LLLL.setFocusPainted(false);
      //  frame.setIconImage(wall.getcramIcon());

   	 random=wall.getRandom();
   	 fpi=wall.getfirst();
   	 spi=wall.getsecond();
   	 bluewood=wall.gethintpeace();
   	 

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

	}
	public Vector<JButton> leftbuttons(){
		Vector<JButton> vec=new Vector<JButton>();
		vec.add(this.fi);
		vec.add(this.si);
		vec.add(L);
		vec.add(LL);
		vec.add(LLL);
		vec.add(LLLL);
		return vec;	
	}
	public Vector<JLabel> leftjlabels(){
		Vector<JLabel> vec=new Vector<JLabel>();
		vec.add(this.fil);
		vec.add(this.sil);
		vec.add(this.jb);
		return vec;	
	}
	public void getRows(int rows) {
		int numrow=rows;
		g=new game(numrow,false);
		int x=(numrow / 2) * 50;
		int counter=1;
		for(int i=0; i < numrow ; i++ ) {
			JButton j=new JButton();
			JButton k=new JButton();
			j.setName(Integer.toString(counter));
			k.setName(Integer.toString(counter + 1));
			j.setBounds(480-x, 110, 50, 50);
			k.setBounds(480-x, 160, 50, 50);
			x=x-50;
			counter=counter + 2;
			buttons.add(j);
			buttons.add(k);
            j.setIcon(random);
            k.setIcon(random);
			j.addMouseListener(this);
			k.addMouseListener(this);

			
		}
	}

	 public Vector<JButton> getbuttons(){
		 return buttons;
		 
	 }
	 
	 public game GetGame() {
		 return this.g;
	 }
		public void removeIcons(ArrayList<Integer> arr) {
			
			for(JButton but : buttons) 
					for(int i : arr) 
						if(i == Integer.parseInt(but.getName())) but.setIcon(random);

			}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
			JButton demo=(JButton) arg0.getComponent();
		int row , col;
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
			   
				Timer timer = new Timer(); 
				timer.schedule( new TimerTask() 
				{ 
				    public void run() { 
				    	jb.setSize(670, 30);
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
				
				
		
			if(turn == Player.PLAYERONE) {
				
			demo.setIcon(this.fpi);
			this.revalidate();
			this.repaint();
			
			
		}else  {
			
			demo.setIcon(this.spi);
			this.revalidate();
			this.repaint();		
		}
			
			
	}
		if(g.checkend()) {
			JOptionPane cong=new JOptionPane("Congratulations");
			cong.showMessageDialog(this, g.getWinner()+" congratulations for winning");
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	          if(arg0.getComponent() instanceof JButton) {
	        	  JButton demo =(JButton) arg0.getComponent();
	        	  demo.setSize(60, 60);
	        	  
	        	  
	        	  
	          }
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
        if(arg0.getComponent() instanceof JButton) {
      	  JButton demo =(JButton) arg0.getComponent();
      	  demo.setSize(50, 50);
      	  
      	  
      	  
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
