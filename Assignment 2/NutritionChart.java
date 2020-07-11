import java.util.*;
import java.io.*;

public class NutritionChart
{
    private Map<Integer, FoodType> foodTypes = new HashMap<Integer, FoodType>();

    /**
       Scans food types from nutrition text file
       Checks for IOException and NumberFormatException
       Prints message and closes the program is exception occurs
     */

    public NutritionChart()
    {
	try
	    {
		Scanner scanner = new Scanner(new File("nutrition.txt"));
		
		while(scanner.hasNextLine())
		    {
			String line = scanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			int foodcode = Integer.parseInt(lineScanner.next());
			String label = "";
				
			while(!lineScanner.hasNextDouble())
			    {
				label = label + lineScanner.next() + "";
			    }
			int calories = Integer.parseInt(lineScanner.next());
			int sugar = Integer.parseInt(lineScanner.next());
			int fat = Integer.parseInt(lineScanner.next());
			int carbs = Integer.parseInt(lineScanner.next());
			FoodType food = new FoodType(foodcode, label, calories, sugar, fat, carbs);
			foodTypes.put(foodcode, food);
		    }
	    }
	catch (IOException exception)
	    {
		System.out.println("Error: no grocery item available for nutrition scanner");
		System.exit(1);
	    }
	catch (NumberFormatException exception)
	    {
		System.out.println("Invalid data input format for nutrition scanner");
		System.exit(1);
	    }
	catch (InputMismatchException exception)
	    {
		System.out.println("Invalid data input format for nutrition scanner");
		System.exit(1);
	    }
    }

    /**
       Get the food type that has the same food code as the parameter foodCode
       @param integer foodCode
       @return Food type object that has the same food code as parameter and null if none of the object matches
     */
    public FoodType getFoodType(int foodCode)
    {
	FoodType match = new FoodType(foodTypes.get(foodCode).getFoodCode(), foodTypes.get(foodCode).getLabel(), foodTypes.get(foodCode).getCalories(), foodTypes.get(foodCode).getSugar(), foodTypes.get(foodCode).getFat(), foodTypes.get(foodCode).getCarbs());
	return match;
    }
}	    
    
