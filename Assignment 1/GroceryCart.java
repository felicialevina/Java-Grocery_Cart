import java.util.*;
import javax.swing.*;

public class GroceryCart
{
    private ArrayList<GroceryItem> items;
    private GroceryItem nextItem;
    private int itemIndex = 0;

    public GroceryCart()
    {
	items = new ArrayList<GroceryItem>();
    }

    /**
       Adds item to the arraylist
       @param GroceryItem instance
    */
    public void addItem(GroceryItem item)
    {
	items.add(item);
    }

    /**
       Fill the arraylist with all grocery items
    */
    public void fill()
    {
	GroceryItem bananas = new GroceryItem(182, "bananas", 3.25);
	GroceryItem apple = new GroceryItem(903, "apple", 2.43);
	GroceryItem grapes = new GroceryItem(109, "grapes", 3.54);
	Meat steak = new Meat(710, "steak", 3.3, 1.0);
	Dairy milk = new Dairy(131, "milk", 2.4, 1.5);
	GroceryItem carrots = new GroceryItem(412, "carrots", 4.36);
	Meat roastBeef = new Meat(710, "roastBeef", 4.0, 2.2);
	GroceryItem cheese = new GroceryItem(121, "cheese", 7.04);
	GroceryItem strawberries = new GroceryItem(605, "strawberries", 4.89);
	Meat sausages = new Meat(710, "sausages", 2.4, 2.8);
	GroceryItem peaches = new GroceryItem(219, "peaches", 3.21);

	addItem(bananas);
	addItem(apple);
	addItem(grapes);
	addItem(steak);
	addItem(milk);
	addItem(apple);
	addItem(carrots);
	addItem(roastBeef);
	addItem(cheese);
	addItem(strawberries);
	addItem(sausages);
	addItem(peaches);
    }
    /**
       Display all grocery items in arraylist to GroceryCart text area
     */
    public void display(JTextArea area)
    {
	for (int i = 0; i < items.size() && items.size() > 0; i++)
	    {
		area.append((items.get(i)).getLabel() + "\n" + "\n");
		area.setEditable(false);
	    }
    }
    /**
       Remove first item from the arraylist
       @return GroceryItem instance
     */
    public GroceryItem removeTopItem()
    {
       	GroceryItem grocery = items.get(0);
       	items.remove(0);
       	return grocery;
    }

    /**
       Get the total size of arraylist       
       @return integer of size of arraylist
     */
    public int getTotalItems()
    {
	return items.size();
    }

    /**
       Get the next item in arraylist without removing
       @return GroceryItem instance or null if no more items in arraylist
     */
    public GroceryItem getNextItem()
    {
       	if (itemIndex < items.size())
	{
	    nextItem = items.get(itemIndex);	
	    itemIndex++; 
	    return nextItem;	
	}
       	return null;
    }
    
    /**
       Reset the next Item back into the first object in arraylist
    */
    public void resetNextItem()
    {
	itemIndex = 0;
    }
   
}