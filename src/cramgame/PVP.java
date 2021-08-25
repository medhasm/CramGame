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
	JFrame frame = new JFrame();
      JButton Reset;
      JButton back;
      JButton Hint;
    JButton fi;
   JButton si;
     JLabel fil;
     JLabel sil;
    ImageIcon playback;
	ImageIcon backg;
	ImageIcon random;
	ImageIcon fpi;
	ImageIcon spi;
	ImageIcon bluewood;
	public PVP() {
	//	 frame = new JFrame();
			//	frame.setSize(800, 600);
			//	frame.setTitle("Cram Game");
			//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//frame.setLayout(null);
        JLabel background;
        Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
        WallPaper wall=new WallPaper();
        playback=wall.getplayback();
      //  frame.setIconImage(wall.getcramIcon());
   	 backg=wall.getbackground();
   	 random=wall.getRandom();
   	 fpi=wall.getfirst();
   	 spi=wall.getsecond();
   	 bluewood=wall.gethintpeace();
   	 
backg=wall.getbackground();
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
this.add(fil);
this.add(sil);


this.add(si);
this.add(fi);
   	int rows=0;
   	while (rows <=2) {
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
	        rows=Integer.parseInt(input);
   	}
        	
     	   
     	   this.setSize(800, 600);
     	   this.setLayout(null);
     	   background=new JLabel(this.backg);   	   
     	   background.setSize(800, 600);
     	   background.setName("background");
     	    jb=new JLabel("Cant place this peace her");//,this place has been already been taken.
     	    jb.setLocation(80, 210);
     	    jb.setName("MyLabel");
     	    jb.setForeground(col);
     	    jb.setSize(0, 0);
     	    back=new JButton("Back");
     	    
     	    this.back.setIcon(wall.getbackbutton());
     	    this.back.setLocation(0,0);
     	    this.back.setSize(90, 90);
     	    back.setOpaque(false);
     	 //   this.back.setOpaque(false);
     	    this.back.setContentAreaFilled(false);
     	    
     	    this.back.setBorderPainted(false);      
     	    this.back.setFocusPainted(false);
     	//this.back.setFont(font);
     	    		
     	  
     	    Hint=new JButton();
     	      	Hint.setOpaque(false);	
     	    this.Hint.setIcon(wall.gethint());
   
     	    this.Hint.setLocation(650,5);
     	    this.Hint.setSize(90, 90);
     	 //   this.back.setOpaque(false);
     	    this.Hint.setContentAreaFilled(false);
     	    
     	    this.Hint.setBorderPainted(false);      
     	    this.Hint.setFocusPainted(false);
     	    this.Hint.addMouseListener(this);
     	//this.back.setFont(font);
     	    		
     	    		
     	   this.add(Hint);
     	    jb.setLocation(80, 210);
     	    jb.setName("MyLabel");
     	    jb.setSize(0, 0);
     	    this.Reset=new JButton("new Game");
     	    Reset.setOpaque(false);
     	    this.Reset.setLocation(100,10);
     	    this.Reset.setSize(60, 70);
     	    this.Reset.setIcon(playback);
     	    this.Reset.setContentAreaFilled(false);
     	    
     	    this.Reset.setBorderPainted(false);      
     	    this.Reset.setFocusPainted(false);
     	    //this.add(this.Reset);
     	    this.add(back);
     	    this.add(jb);
     	    this.back.addMouseListener(this);
     	   this.Reset.addMouseListener(this);
     	   getRows(rows);
            //this.add(background); 		
   	//	 this.repaint();
   		 //this.revalidate();
        //  frame.getContentPane().add(this);
        //frame.setVisible(true);

	}
	public Vector<JButton> leftbuttons(){
		Vector<JButton> vec=new Vector<JButton>();
		vec.add(Reset);
		vec.add(this.back);
		vec.add(this.fi);
		vec.add(this.si);
		vec.add(this.Hint);
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
		//String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
		int numrow=rows;
		g=new game(numrow,false);
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
			//this.add(j);
			//this.add(k);

			counter=counter + 2;
			buttons.add(j);
			buttons.add(k);
            j.setIcon(random);
            k.setIcon(random);
			j.addMouseListener(this);
			k.addMouseListener(this);
            //this.revalidate();
         //   this.repaint();
			
		}
	}
//public static void main(String[] args)
	// {

	//	 new PVP();
	 //}
	 public Vector<JButton> getbuttons(){
		 return buttons;
		 
	 }
	  public void Reset() {  		  
		
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
			
			this.setVisible(false);
			new GUI();
			return;
		}
		if(demo == this.Hint) {
			Algorithms algo=new Algorithms();
			Line line=algo.XORBoard(g.b);
			if(line.getWin()==false) {
				JOptionPane cong=new JOptionPane("Hint!");
				cong.showMessageDialog(frame,"Sorry,no Hint to give your in losing state");
				
			}else
			{
			ArrayList<Integer> arr=algo.getOpMoves(line);
			int c;
				Vector<JButton> container=new Vector<JButton>();
				for(JButton j : buttons) {
					 c=Integer.parseInt(j.getName());
					if((c == 2*line.getStart()+arr.get(0) )|| (c == 2*line.getStart()+arr.get(1)) || (c == 2*line.getStart()+arr.get(2)) ) { 
						container.add(j);
				        
					}
				}
				
				
				
				Timer timer = new Timer(); 
				timer.schedule( new TimerTask() 
				{ 
				    public void run() { 
				    // do your work 
				    	for(JButton j : container)  j.setIcon(bluewood);
				    	//System.out.println("yes");
				    } 
				},  5*(1000*1));
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//int i=10000;
				
				//while(i > 0) i--;
				timer.schedule( new TimerTask() 
				{ 
				    public void run() { 
				 //   // do your work 
				   for(JButton j : container)  j.setIcon(random);	
				    //	System.out.println("yes");
				    } 
				},  5*(1000*1));
				
				
			
		}
			return;
		}
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
				    	//System.out.println("yes");
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

			//frame.repaint();
			//frame.revalidate();
			
		}
			
			
	}
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
