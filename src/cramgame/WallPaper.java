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
		img= new ImageIcon(getClass().getClassLoader().getResource("newback.png"));//background4.jpg
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
	public  ImageIcon getTrashIcon() {
		    ImageIcon img;
			img= new ImageIcon(getClass().getClassLoader().getResource("trash.png"));
			return img;

	}
	public  ImageIcon getL() {
	    ImageIcon img;
		img= new ImageIcon(getClass().getClassLoader().getResource("L.png"));
		return img;

}
	public  ImageIcon getLL() {
	    ImageIcon img;
		img= new ImageIcon(getClass().getClassLoader().getResource("LL.png"));
		return img;

}
	public  ImageIcon getLLL() {
	    ImageIcon img;
		img= new ImageIcon(getClass().getClassLoader().getResource("LLL.png"));
		return img;

}
	public  ImageIcon getLLLL() {
	    ImageIcon img;
		img= new ImageIcon(getClass().getClassLoader().getResource("LLLL.png"));
		return img;

}
	public  ImageIcon getblack() {
		 ImageIcon img;
	
			img= new ImageIcon(getClass().getClassLoader().getResource("black.png"));
			return img;

	}
	//public  ImageIcon getl() {
		// ImageIcon img;
	
		//	img= new ImageIcon(getClass().getClassLoader().getResource("l.png"));
			
		//	return img;

	//}
	public  ImageIcon getl2() {
		 ImageIcon img;
	
			img= new ImageIcon(getClass().getClassLoader().getResource("l2.png"));
			
			return img;

	}
	public  ImageIcon getl3() {
		 ImageIcon img;
	
			img= new ImageIcon(getClass().getClassLoader().getResource("l3.png"));
			
			
			return img;

	}
	public  ImageIcon getl4() {
		 ImageIcon img;
	
			img= new ImageIcon(getClass().getClassLoader().getResource("l4.png"));
			
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
