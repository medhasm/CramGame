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

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import com.sun.glass.events.WindowEvent;
import com.sun.prism.Image;

public class GUI  {
    JButton button1; 
    JButton button2;
    JButton button3;
  JPanel  Panelbutton1  ,Panelbutton2, Panelbutton3;
    Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,23);
    JFrame frame;
   Container c;
   JPanel GUIcontainerPanel;
   JLabel background;
    
	 MouseListener mouse=new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getComponent() instanceof JButton) {
				JButton demo= (JButton) e.getComponent();
				if(demo == button1) { //
			    	 WallPaper wall= new WallPaper();
			    	  background.setIcon(wall.getbackground());
					
					GUIcontainerPanel.add(background);
					//GUIcontainerPanel.setVisible(true);
					button1.setVisible(false);
					Panelbutton2.setVisible(false);
					Panelbutton3.setVisible(false);
				PVP nframe=new PVP();
				
               // c.add(nframe);
               // nframe.setVisible(true);
                for(JButton jButton:nframe.getbuttons()) 
                	c.add(jButton);
                
                for(JButton jButton: nframe.leftbuttons()) 
                	c.add(jButton);
                for(JLabel jLabel: nframe.leftjlabels()) 
                	c.add(jLabel);

                c.add(GUIcontainerPanel);
                c.repaint();
                c.revalidate();
				}
				if(demo == button2) { //
				PVC nframe=new PVC();
				frame.dispose();
				frame.setVisible(false);
				}
				
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,23);
			if(e.getComponent() instanceof JButton) {
				JButton k=(JButton) e.getComponent();
				
				k.setSize(230,40);
	    	    k.setFont(font);
			}

		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
 	       font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,26);
 	       
			if(e.getComponent() instanceof JButton) {
				JButton k=(JButton) e.getComponent();
				k.setSize(280,40);
	    	    k.setFont(font);
			}
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
        frame.setSize(800,600);
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
  button1.setLocation(230, 100);
  Panelbutton2.setLocation(230, 170);
  Panelbutton3.setLocation(230, 240); 
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
              
       WallPaper wall= new WallPaper();
    	
    	 frame.setIconImage(wall.getcramIcon());
    	
    	  background=new JLabel(wall.getbackground());
    	 
    	  GUIcontainerPanel.setLocation(0, 0);
    	  GUIcontainerPanel.setSize(800, 600);
    	  
    	   //GUIcontainerPanel.add(button1);
    	   //GUIcontainerPanel.add(button2);
    	   //GUIcontainerPanel.add(button3);
    	  Panelbutton1.add(button1);
    	  Panelbutton2.add(button2);
    	  Panelbutton3.add(button3);
    	   GUIcontainerPanel.add(background);
    	   

          
       c.add(button1);
       c.add( Panelbutton2);
       c.add( Panelbutton3);
       c.add(GUIcontainerPanel);
       

          

    
  //GUIcontainerPanel.setVisible(true);
       frame.setVisible(true);
	
	}

	 public static void main(String[] args)
	 {

		 new GUI();
	 }

}
