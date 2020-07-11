import java.util.*;

public class NutritionChart
{
    private ArrayList<FoodType> foodTypes = new ArrayList<FoodType>();

    public NutritionChart()
    {
	FoodType bananas = new FoodType(182, "bananas", 94, 20, 3, 22);
	FoodType apple = new FoodType(903, "apple", 52, 44, 2, 14);
	FoodType grapes = new FoodType(109, "grapes", 114, 15, 1, 28);
	FoodType steak = new FoodType(710, "beef", 250, 0, 35, 20);
	FoodType milk = new FoodType(131, "milk", 90, 12, 7, 4);
	FoodType carrots = new FoodType(412, "carrots", 25, 0, 3, 4);
	FoodType roastBeef = new FoodType(710, "beef", 250, 0, 35, 28);
	FoodType cheese = new FoodType(121, "cheese", 110, 2, 9, 1);
	FoodType strawberries = new FoodType(605, "strawberries", 46, 24, 1, 11);
	FoodType sausages = new FoodType(710, "beef", 250, 0, 35, 20);
	FoodType peaches = new FoodType(219, "peaches", 42, 9, 0, 11);

	foodTypes.add(bananas);
	foodTypes.add(apple);
	foodTypes.add(grapes);
	foodTypes.add(steak);
	foodTypes.add(milk);
	foodTypes.add(carrots);
	foodTypes.add(roastBeef);
	foodTypes.add(cheese);
	foodTypes.add(strawberries);
	foodTypes.add(sausages);
	foodTypes.add(peaches);
    }
    /**
       Get the food type that has the same food code as the parameter foodCode
       @param integer foodCode
       @return Food type object that has the same food code as parameter and null if none of the object matches
     */
    public FoodType getFoodType(int foodCode)
    {
	for (int i = 0; i < foodTypes.size(); i++)
	    {
		if (foodCode == foodTypes.get(i).getFoodCode())
		    {
			FoodType match = new FoodType (foodTypes.get(i).getFoodCode(), foodTypes.get(i).getLabel(), foodTypes.get(i).getCalories(), foodTypes.get(i).getSugar(), foodTypes.get(i).getFat(), foodTypes.get(i).getCarbs());
			return match;
		    }
	    }
	return null;    
    }
}	    
    
