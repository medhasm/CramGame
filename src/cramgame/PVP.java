package cramgame;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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

public class PVP extends JFrame implements MouseListener {
	game g;
	JLabel jb;
	public PVP() {
		this.setSize(800, 600);
        this.setTitle("Cram Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        JLabel background;
        Font font=new Font("Harlow Solid Italic",Font.BOLD | Font.ITALIC,24);
        
        try {
        	
     	   ImageIcon img=new ImageIcon(ImageIO.read(new File("background4.jpg")));
     	   background=new JLabel(img);   	   
     	   background.setSize(800, 600);
     	   background.setName("backgrount");
     	    jb=new JLabel("Cant place this peace her,this place has been already been taken.");
     	    jb.setLocation(80, 210);
     	    jb.setName("MyLabel");
     	    jb.setSize(0, 0);
     	    //jb.setFont(font);
     	  // jb.setLocation(350, 250);
     	  // jb.setForeground(Color.RED);
     	   this.getContentPane().add(jb);
     	getRows();
            this.getContentPane().add(background);
           
            
        } catch (IOException e   ) {
            e.printStackTrace();
        }
          
          this.revalidate();
          this.repaint();
         
         this.setSize(800, 600);
        this.setVisible(true);
        
        
	
	}
	public void getRows() {
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
		int numrow=Integer.parseInt(input);
		g=new game(numrow,false);
		int x=(numrow / 2) * 50;
		int counter=1;
		for(int i=0; i < numrow ; i++ ) {
			JButton j=new JButton();
			JButton k=new JButton();
			j.setName(Integer.toString(counter));
			k.setName(Integer.toString(counter + 1));
			j.setSize(50, 50);
			k.setSize(50, 50);
			j.setLocation(350 - x , 100);
			k.setLocation(350 - x, 150);
			x=x-50;
			this.getContentPane().add(j);
			this.getContentPane().add(k);
			counter=counter + 2;
			
			j.addMouseListener(this);
			k.addMouseListener(this);
			
		}
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

		 new PVP();
	 }
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		int row , col;
		if(arg0.getComponent() instanceof JButton) {
			
			JButton demo=(JButton) arg0.getComponent();
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
			JPanel jpanel;
			JLabel Warning;
			if(!flag) {
				System.out.println("her");
			
					//System.out.println(this.getContentPane().getName());
				
				
				 //Warning.setText();	
				jb.setFont(font);
			   jb.setSize(670, 30);
				jb.setForeground(Color.CYAN);
				this.setSize(800, 600);
			
				
				return;
			}
				
				
		
			if(turn == Player.PLAYERONE) {
				
			demo.setIcon(getfirst());
		//	this.getContentPane().add(demo);
			this.revalidate();
			this.repaint();
			
			
		}else {
			
			demo.setIcon(getsecond());
	//		demo.repaint();
			//demo.revalidate();
			//this.getContentPane().add(demo);
			this.repaint();
			this.revalidate();
			
		}
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
