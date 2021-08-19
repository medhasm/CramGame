package cramgame;

import java.awt.BorderLayout;
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

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import com.sun.prism.Image;

public class GUI extends JFrame {
    JButton button1; 
    JButton button2;
    JButton button3;
    Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,18);
    JFrame frame;
    
	 MouseListener mouse=new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getComponent() instanceof JButton) {
				JButton demo= (JButton) e.getComponent();
				if(demo == button1) { //
				PVP nframe=new PVP();
				frame.setVisible(false);
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,18);
			if(e.getComponent() instanceof JButton) {
				JButton k=(JButton) e.getComponent();
				
				k.setSize(230,40);
	    	    k.setFont(font);
			}

		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
 	       font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,25);
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
        frame.setSize(701,526);
        frame.setLayout(null);
        
   button1 = new JButton("Play With Friend");
    
   button2 = new JButton("Play With Computer");
   button3 = new JButton("Whats Is Cram?");
       
       button1.setSize(230,40);
       button2.setSize(230,40);
       button3.setSize(230,40);
       button1.setLocation(230, 100);
       button2.setLocation(230, 170);
       button3.setLocation(230, 240);  
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
              
       try {
    	
    	   ImageIcon img=new ImageIcon(ImageIO.read(new File("background2.jpg")));//
    	  JLabel background=new JLabel(img);
    	 
    	   
    	   background.setSize(701, 526);
           frame.getContentPane().add(button1);
    	   frame.getContentPane().add(button2);
    	   frame.getContentPane().add(button3);
           frame.getContentPane().add(background);

          background.setLocation(0, 0);
           
       } catch (IOException e   ) {
           e.printStackTrace();
       }

          

     frame.setSize(701, 526);
  
       frame.setVisible(true);
	
	}

	 public static void main(String[] args)
	 {

		 new GUI();
	 }

}
