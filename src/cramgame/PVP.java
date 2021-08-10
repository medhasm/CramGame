package cramgame;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PVP extends JFrame {
	game g;
	
	public PVP() {
		this.setSize(701, 526);
        this.setTitle("Cram Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        JLabel background;
        try {
        	
     	   ImageIcon img=new ImageIcon(ImageIO.read(new File("background2.jpg")));
     	   background=new JLabel(img);   	   
     	   background.setSize(701, 526);
     	getRows();
            this.getContentPane().add(background);
            
        } catch (IOException e   ) {
            e.printStackTrace();
        }
          
          this.revalidate();
          this.repaint();
         
         this.setSize(701, 526);
        this.setVisible(true);
        
        
	
	}
	public void getRows() {
		String input =JOptionPane.showInputDialog(this,"Please insert number of Rows (number of rows should be bigger  than 2");
		int numrow=Integer.parseInt(input);
		g=new game(numrow,false);
		int x=(numrow / 2) * 30;
		int counter=1;
		for(int i=0; i < numrow ; i++ ) {
			JButton j=new JButton();
			JButton k=new JButton();
			j.setName(Integer.toString(counter));
			k.setName(Integer.toString(counter + 1));
			j.setSize(30, 30);
			k.setSize(30, 30);
			j.setLocation(350 - x , 100);
			k.setLocation(350 - x, 130);
			x=x-30;
			this.getContentPane().add(j);
			this.getContentPane().add(k);
			counter=counter + 1;
			
		}
	}
	 public static void main(String[] args)
	 {

		 new PVP();
	 }

}
