import java.util.*;
import javax.swing.*;
import java.io.*;

public class GroceryCart
{

    private Stack<GroceryItem> items;
    private ListIterator<GroceryItem> iter;

    public GroceryCart()
    {
	items = new Stack<GroceryItem>();
    }

    /**
       Adds item to the stack
       @param GroceryItem instance
    */
    public void addItem(GroceryItem item)
    {
	items.push(item);
    }

    /**
       Fill the stack with all grocery items from a text file
    */
    public void fill()
    {
	try
	    {
		Scanner scanner = new Scanner(new File("groceryItems.txt"));
		while(scanner.hasNextLine())
		    {
			String line = scanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			int foodcode = Integer.parseInt(lineScanner.next());
			String types = lineScanner.next();
			String label = "";
			double price = 0;
			double amount = 0;
				
			if(types.equals("Meat") || types.equals("Dairy"))
			    {
				while(!lineScanner.hasNextDouble())
				    {
					label = label + lineScanner.next() + " ";
				    }
				price = Double.parseDouble(lineScanner.next());
				amount = Double.parseDouble(lineScanner.next());
				Meat grocery1 = new Meat(foodcode, label, price, amount);
				addItem(grocery1);
			    }
				
			else if(types.equals("Dairy"))
			    {
				while(!lineScanner.hasNextDouble())
				    {
					label = label + lineScanner.next() + " ";
				    }
				price = Double.parseDouble(lineScanner.next());
				amount = Double.parseDouble(lineScanner.next());
				Dairy grocery2 = new Dairy(foodcode, label, price, amount);
				addItem(grocery2);
			    }
				
			else 
			    {
				label = types;
				price = Double.parseDouble(lineScanner.next());
				GroceryItem grocery3 = new GroceryItem(foodcode, label, price);
				addItem(grocery3);
			    }
		    }
	    }
	catch (IOException exception)
	    {
		System.out.println("Error: no grocery item input available");
		System.exit(1);
	    }
	catch (NumberFormatException exception)
	    {
		System.out.println("Invalid data input format");
		System.exit(1);
	    }
	catch (InputMismatchException exception)
	    {
		System.out.println("Invalid data input format");
		System.exit(1);
	    }
    }
    /**
       Display all grocery items in the stack to GroceryCart text area
     */
    public void display(JTextArea area)
    {
	iter = items.listIterator(items.size());
	while(iter.hasPrevious())
	    {
		GroceryItem print = iter.previous();
		area.append(print.getLabel() + "\n" + "\n");
		area.setEditable(false);
	    }

    }
    /**
       Remove top item from the stack
       @return GroceryItem instance
     */
    public GroceryItem removeTopItem()
    {
       	return items.pop();
    }

    /**
       Get the total size of stack      
       @return integer of size of stack
     */
    public int getTotalItems()
    {
	return items.size();
    }

    /**
       Get the top item on the stack  without removing
       @return GroceryItem instance or null if no more items in the stack
     */
    public GroceryItem getNextItem()
    {
	if (iter.hasNext())
	    {
		return iter.next();	
	    }
	return null;
    }
    
    /**
       Reset the next Item back into the first object in the stack by using iterator 
    */
    public void resetNextItem()
    {
	iter = items.listIterator();
    }
}