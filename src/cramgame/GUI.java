package cramgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import com.sun.glass.events.WindowEvent;
import com.sun.prism.Image;

public class GUI  {
    JButton button1; 
    JButton button2;
    JButton button3;
    JButton Reset;
    JButton back;
    JButton Hint;
    JButton Trash;
  JPanel  Panelbutton1  ,Panelbutton2, Panelbutton3;
    Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,23);
    JFrame frame;
   Container c;
   JPanel GUIcontainerPanel;
   JLabel background;
   boolean PvPflag=false ;
   boolean PvCflag =false;
   PVP PvP;
   PVC PvC;
   WallPaper wall;
    
	 MouseListener mouse=new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getComponent() instanceof JButton) {
				JButton demo= (JButton) e.getComponent();
				if(demo == button1) { //
			    	  
			    	  background.setIcon(wall.getbackground());
					
					GUIcontainerPanel.add(background);
					//GUIcontainerPanel.setVisible(true);
					button1.setVisible(false);
					Panelbutton2.setVisible(false);
					Panelbutton3.setVisible(false);
				StartMode();
				PvP=new PVP();
				PvPflag = true;
                for(JButton jButton:PvP.getbuttons()) 
                	c.add(jButton);          
                for(JButton jButton: PvP.leftbuttons()) {
                	c.add(jButton);}
                for(JLabel jLabel: PvP.leftjlabels()) 
                	c.add(jLabel);

                c.add(GUIcontainerPanel);
                c.repaint();
                c.revalidate();
				}
				
				
				if(demo == Reset) { 
                     if(PvPflag) {
		              for(JButton jButton:PvP.getbuttons()) 
		                	jButton.setVisible(false);
		                
		                for(JButton jButton: PvP.leftbuttons()) {
		                 jButton.setVisible(false);
		                	}
		                for(JLabel jLabel: PvP.leftjlabels()) 
		                	jLabel.setVisible(false);
		                
		                
						PvP=new PVP();
						PvPflag = true;
				    	  
				    	  background.setIcon(wall.getbackground());
						
						GUIcontainerPanel.add(background);
						
		                for(JButton jButton:PvP.getbuttons()) 
		                	c.add(jButton);
		                
		                for(JButton jButton: PvP.leftbuttons()) {
		                	
		  
		                	
		                	c.add(jButton);}
		                for(JLabel jLabel: PvP.leftjlabels()) 
		                	c.add(jLabel);

		                c.add(GUIcontainerPanel);
		                c.repaint();
		                c.revalidate();  
		                
		                
                     }
                     if(PvCflag) {
    		                for(JButton jButton: PvC.getbuttons()) {
    	   		                 jButton.setVisible(false);
    	   		                	}
   		            
   		                	
   		                
   		                for(JButton jButton: PvC.leftbuttons()) {
   		                 jButton.setVisible(false);
   		                	}
   		                for(JLabel jLabel: PvC.leftjlabels()) 
   		                	jLabel.setVisible(false);      
   						PvC=new PVC();
   						PvCflag = true;
   				    	
   				    	  background.setIcon(wall.getbackground());
   						
   						GUIcontainerPanel.add(background);
   		                for(JButton jButton: PvC.getbuttons()) {
   		                	
   		  
   		                	
   		                	c.add(jButton);}
   		                
   		                for(JButton jButton: PvC.leftbuttons()) {
   		                	
   		  
   		                	
   		                	c.add(jButton);}
   		                for(JLabel jLabel: PvC.leftjlabels()) 
   		                	c.add(jLabel);

   		                c.add(GUIcontainerPanel);
   		                c.repaint();
   		                c.revalidate();  
   		                
   		                
                        }
					
				}
	if(demo == button2) { //
					
					StartMode();
			    	background.setIcon(wall.getbackground());
					GUIcontainerPanel.add(background);
					button1.setVisible(false);
					Panelbutton2.setVisible(false);
					Panelbutton3.setVisible(false);
					
				    PvC=new PVC();
				    PvCflag = true;

		              for(JButton jButton: PvC.getbuttons()) 
		                  c.add(jButton);
              
              
              for(JButton jButton: PvC.leftbuttons()) 
              c.add(jButton);
              for(JLabel jLabel: PvC.leftjlabels()) 
              c.add(jLabel);

              c.add(GUIcontainerPanel);
              c.repaint();
              c.revalidate();
				}
				
	if(demo == Hint) {
					game g=null;
					if(PvPflag) g=PvP.GetGame();
					if(PvCflag) g=PvC.GetGame();
					
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
						Vector<JButton> buttons=new Vector<JButton>();
						
						if(PvPflag) buttons = PvP.getbuttons();
						if(PvCflag)  buttons= PvC.getbuttons();
						for(JButton j : buttons) {///////////////////////////////////////////////////
							 c=Integer.parseInt(j.getName());
							if((c == 2*line.getStart()+arr.get(0) )|| (c == 2*line.getStart()+arr.get(1)) || (c == 2*line.getStart()+arr.get(2)) ) 
							{ 
								container.add(j);    
							}
							}
			
    Timer timer = new Timer(); 
	timer.schedule( new TimerTask()  
			{public void run() { for(JButton j : container)  j.setIcon(wall.gethintpeace());}}
	                      ,  5*(1000*1));
						 // TODO Auto-generated catch block    
						try {Thread.sleep(2000);
							} catch (InterruptedException el) {el.printStackTrace();}
						
							
							
						

    timer.schedule( new TimerTask() 
			{ public void run() {for(JButton j : container)  j.setIcon(wall.getRandom());}}	
						  ,5*(1000*1));  }
					}//close if hint
				
	if(demo == back) {
					     if(PvPflag) {					 
			                  for(JButton jButton:PvP.getbuttons()) 
			                	jButton.setVisible(false);
			                  for(JButton jButton: PvP.leftbuttons()) 
			                 jButton.setVisible(false);   	
			                  for(JLabel jLabel: PvP.leftjlabels()) 
			                	jLabel.setVisible(false);
			                    PvPflag=false;
					}
					     if(PvCflag) {
                                for(JButton j: PvC.getbuttons()) 
	                    			 j.setVisible(false); 
			                    for(JButton jButton: PvC.leftbuttons()) 
			                         jButton.setVisible(false);
			                     for(JLabel jLabel: PvC.leftjlabels()) 
			                	jLabel.setVisible(false);			                
			                     PvCflag=false;

					}
					  StopMode();
					  c.repaint();
					  c.revalidate();
					  
					  button1.setVisible(true);
					  Panelbutton2.setVisible(true);
					  Panelbutton3.setVisible(true);					
				}
	if(demo == Trash) {
		if(PvPflag) {
			
			if(PvP.GetGame().forremove != null) {
			  PvP.removeIcons(PvP.GetGame().forremove);
			  PvP.GetGame().remove();
			}
			  
		}
		if(PvCflag) {
			
			if(PvC.GetGame().forremove != null) {
			  PvC.removeIcons(PvC.GetGame().forremove);
			  PvC.GetGame().remove();
			}
			  
		}
		
		
		
	}
				
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,23);
				JButton demo =(JButton) e.getComponent() ;

			
			if((demo == button1) ) {
				demo.setSize(230,40);
	    	    demo.setFont(font);}
			if (demo == button2) {
				Panelbutton2.setSize(230,40);
	    	    demo.setFont(font);}
			if(demo == button3) {
				Panelbutton3.setSize(230,40);
	    	    demo.setFont(font);}
			
			if(demo == back) 
		        back.setSize(90,90);

			if(demo == Reset) 
                Reset.setSize(60,70);
			if(demo == Hint) Hint.setLocation(700, 5);
			if(demo == Trash) Trash.setLocation(800, 20);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
 	       font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,26);
 	       JButton demo=(JButton) e.getComponent();
 	       
			if((demo == button1) ) {
				demo.setSize(280,40);
	    	    demo.setFont(font);}
			if (demo == button2) {
				Panelbutton2.setSize(280,40);
	    	    demo.setFont(font);}
				
			if(demo == button3) {
				Panelbutton3.setSize(280,40);
	    	    demo.setFont(font);}
			
			
			if(demo == back) 	
				back.setSize(85,70);

			if(demo == Reset)
				Reset.setSize(70,70);
	        if(demo == Hint) Hint.setLocation(700, 0);
	        if(demo == Trash) Trash.setLocation(800, 10);
			}
		

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	   	   
       };
	  public GUI(){
        frame = new JFrame("Cram Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,650);
        frame.setLayout(null);
        
        c=frame.getContentPane();
         GUIcontainerPanel=new JPanel();
        
   button1 = new JButton("Play With Friend");
    
   button2 = new JButton("Play With Computer");
   button3 = new JButton("Whats Is Cram?");
   Panelbutton1 =new JPanel();
   
    Panelbutton2=new JPanel();
    Panelbutton3=new JPanel();
  Color col=new Color(216,180,96);
  button1.setForeground(col);
  button2.setForeground(col);
  button3.setForeground(col);
  button1.setSize(230,40);
  Panelbutton2.setSize(230,40);
  Panelbutton3.setSize(230,40);
  button1.setLocation(330, 110);
  Panelbutton2.setLocation(330, 180);
  Panelbutton3.setLocation(330, 250); 
  Panelbutton1.setOpaque(false);
  Panelbutton2.setOpaque(false);
  Panelbutton3.setOpaque(false);
 // Panelbutton2.setBorderPainted(false);      
 // Panelbutton2.setFocusPainted(false);
       button1.setOpaque(false);
       button1.setContentAreaFilled(false);
       button1.setBorderPainted(false);      
       button1.setFocusPainted(false);
       button1.setFont(font);
       button2.setOpaque(false);
       button2.setContentAreaFilled(false);
       button2.setBorderPainted(false);      
       button2.setFocusPainted(false);
       button2.setFont(font);
       button3.setOpaque(false);
       button3.setContentAreaFilled(false);
       button3.setBorderPainted(false);      
       button3.setFocusPainted(false);
       button3.setFont(font);
       button1.addMouseListener(mouse);
       button2.addMouseListener(mouse);
       button3.addMouseListener(mouse);
              //Push to Panel and frame container
          wall= new WallPaper();
    	  frame.setIconImage(wall.getcramIcon());
    	  background=new JLabel(wall.getbackground());	 
    	  GUIcontainerPanel.setLocation(0, 0);
    	  GUIcontainerPanel.setSize(1000, 750);
    	  Panelbutton1.add(button1);
    	  Panelbutton2.add(button2);
    	  Panelbutton3.add(button3);
    	   GUIcontainerPanel.add(background);       
           c.add(button1);
           c.add( Panelbutton2);
           c.add( Panelbutton3);
           c.add(GUIcontainerPanel);
           frame.setVisible(true);
	}
	  
	  public void StartMode() {
		 
		  
   	    back=new JButton("Back");
   	    back.setIcon(wall.getbackbutton());
   	    back.setLocation(0,0);
   	    back.setSize(90, 90);
   	    back.setOpaque(false);
   	    back.setContentAreaFilled(false);
   	    back.setBorderPainted(false);      
   	    back.setFocusPainted(false);
   	    
 	    Hint=new JButton();
 	    Hint.setOpaque(false);	
 	    Hint.setIcon(wall.gethint());
 	    Hint.setLocation(700,5);
 	    Hint.setSize(90, 90);
 	    Hint.setContentAreaFilled(false);
 	    Hint.setBorderPainted(false);      
 	    Hint.setFocusPainted(false);
        
 	    Trash=new JButton();
 	    Trash.setOpaque(false);	
 	    Trash.setIcon(wall.getTrashIcon());
 	    Trash.setLocation(800,20);
 	    Trash.setSize(60, 60);
 	    Trash.setContentAreaFilled(false);
 	    Trash.setBorderPainted(false);      
 	    Trash.setFocusPainted(false);
 	    
 	    Reset=new JButton("new Game");
 	    Reset.setName("Restart");
 	    Reset.setOpaque(false);
 	    Reset.setLocation(100,10);
 	    Reset.setSize(60, 70);
 	    Reset.setIcon(wall.getplayback());
 	    Reset.setContentAreaFilled(false); 
 	    Reset.setBorderPainted(false);      
 	    Reset.setFocusPainted(false);
 	    Reset.addMouseListener(mouse);
 	    Hint.addMouseListener(mouse);
 	    back.addMouseListener(mouse);
 	   Trash.addMouseListener(mouse);
 	    c.add(Reset);
 	    c.add(Hint);
 	   c.add(Trash);
 	    c.add(back);}
	  public void StopMode() {


             Reset.setVisible(false);
	 	   
	 	    Hint.setVisible(false);
	 	   back.setVisible(false);
	 	  Trash.setVisible(false);
	 	   PvPflag=false;
	 	   PvCflag=false;
		  
		  
	  }

	 public static void main(String[] args)
	 {

		 new GUI();
	 }

}
