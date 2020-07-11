import java.util.*;
import javax.swing.*;
import java.io.*;

public class NutritionScanner
{
    private ArrayList<FoodType> items = new ArrayList<FoodType>();
    private NutritionChart chart;

    public NutritionScanner()
    {    
	chart = new NutritionChart();
    }

    /**
       Adds Food type to the items arraylist if none of the food code matches with the object in the arraylist and increment if it matches any food type
       @param integer foodCode
     */
    public void scanFoodCode(int foodCode) 
    {
	/**
	   If arraylist size is 0, add the food type into the arraylist
	*/
	if (items.size() == 0)
	  {
	      items.add(chart.getFoodType(foodCode));
	  }
	/**
	   If arraylist size is not 0, check if the same food type is in the arraylist and if it's the same, increment measure
	 */
	else 
	    {
		for (int i = 0; i < items.size(); i++)
		    {
			if ((items.get(i)).getFoodCode() == foodCode)
			    {
				(items.get(i)).incMeasure();
				break;
			    }
		    }
		/**
		   Adds item to arraylist
		*/
		items.add(chart.getFoodType(foodCode));

		/**
		   Loops through the arraylist, if any food type object has measure greater than 1
		   Loops through the arraylist with index greater than the original object, if the object has the same food code, remove it from arraylist
		*/
		for (int i = 0; i < items.size(); i++)
		    {
			if (items.get(i).getMeasure() > 1)
			    {
				for (int j = i+1; j < items.size(); j++)
				    {
					if (items.get(i).getFoodCode() == items.get(j).getFoodCode())
					    {
						items.remove(j);
					    }
				    }
			    }
		    }
	    }
    }			    

    /**
       Display the label and nutrition information in JTextArea
       @param JTextArea of nutrition information text area
     */
    public void displayAll(JTextArea area)
    {
	for (int i = 0; i < items.size(); i++)
	    {
		area.append(items.get(i).display() + "\n");
	    }

	area.setEditable(false);
    }

    /**
       Get the arraylist of item to be compared
       @return Arraylist of FoodType
    */
    public ArrayList<FoodType> getFinalList()
    {
	return items;
    }

    /**
       Empty the arraylist to scan object from the first object in grocery cart
    */
    public void clearList()
    {
	items = new ArrayList<FoodType>();
    }
}