package cramgame;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WallPaper {

	
	
	public ImageIcon getbackground() {
		ImageIcon img;
	//	try {
  	 ///  try {
  		// System.out.println(getClass().getClassLoader().getResource(".").getPath());
		img= new ImageIcon(getClass().getClassLoader().getResource("background4.jpg"));
		return img;
	//} catch (IOException e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
	//}//ImageIO.read(new File(""))
  	// return null;
   
    // } catch (IOException e   ) {
     //    e.printStackTrace();
    // }
		//return null;
		//
	}
	public ImageIcon getbackbutton() {
		ImageIcon img;
		
			img= new ImageIcon(getClass().getClassLoader().getResource("back3.png"));
  	 return img;
   

  
		
		
	}
	public ImageIcon getplayback() {
		ImageIcon img;

		img= new ImageIcon(getClass().getClassLoader().getResource("back5.png"));
  	 return img;
   

		
	}
	public Image getcramIcon() {
		Image img;
		try {
			img =ImageIO.read(getClass().getClassLoader().getResource("cramicon.png"));
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		 return null;
		
		
	}
	public ImageIcon gethintpeace() {
		ImageIcon img;
		
			img= new ImageIcon(getClass().getClassLoader().getResource("bluewood.png"));
  	 return img;
   
  

		
	}
	public ImageIcon gethint() {
		ImageIcon img;
		
			img= new ImageIcon(getClass().getClassLoader().getResource("lamp80x80.png"));
  	 return img;
   


		
	}
	public  ImageIcon getfirst() {
		 ImageIcon img;
	
			img= new ImageIcon(getClass().getClassLoader().getResource("edited1.png"));
			return img;



		
		
	}
	public  ImageIcon getRandom() {
		 ImageIcon img;
		
			img= new ImageIcon(getClass().getClassLoader().getResource("edited5.jpg"));
			return img;
	
			
		
		
		
		
		
	}
	
	public  ImageIcon getsecond() {
		 ImageIcon img;
	
			img= new ImageIcon(getClass().getClassLoader().getResource("edited2.png"));
			return img;

	
		
		
	}
}
