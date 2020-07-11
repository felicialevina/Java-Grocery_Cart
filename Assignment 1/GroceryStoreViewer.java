import javax.swing.JFrame;

/**
   This program allows the user to view font effects.
*/
public class GroceryStoreViewer
{  
	
   public static void main(String[] args)
   {  
      JFrame frame = new GroceryStoreFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Grocery Store Simulator");
      frame.setVisible(true);      
   }

}