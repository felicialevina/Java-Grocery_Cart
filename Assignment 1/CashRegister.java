import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;

/**
 A Cash Register that compute the total price of grocery items.
*/

public class CashRegister
{
    private ArrayList<GroceryItem> items;

    /**
       Constructs a cash register with no item
    */

    public CashRegister()
    {
	items = new ArrayList<GroceryItem>();
    }

    /**
       Adds an item to the cash register.
       @param GroceryItem instance
    */

    public void scanItem(GroceryItem item)
    {
	items.add(item);
    }

    /**
       Gets the price of all items of the current sale.
       @return the total price
    */

    public double getTotal()
    {
	double total = 0.0;
	for(int i = 0; i < items.size(); i++)
	    {
		total += items.get(i).getPrice();
	    }
	return total;
    }
    /**
       Clears the array list
    */

    public void clear()
    {
	items = new ArrayList<GroceryItem>();
    }

    /**
       Display Item's price, Total Price and Current Date and Time
    */

    public void displayAll(JTextArea area)
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date thisDate = new Date();

	for (int i = 0; i < items.size() && items.size() > 0; i++)
	    {
		area.append((items.get(i)).getLabel() + "     " + String.format("%.2f", (items.get(i)).getPrice()) + "\n" + "\n");
		area.setEditable(false);
	    }
	area.append("-----------------" + "\n" + "Total:    " + String.format("%.2f", getTotal()) + "\n" + "\n");
	area.append(dateFormat.format(thisDate));
    }

}