import java.util.*;

public class FoodType implements Comparable<FoodType>
{
    private String label;
    private int foodCode, measure, calories, sugar, fat, carbs;

    public FoodType(int foodCode, String label, int calories, int sugar, int fat, int carbs)
    {
	measure = 1;
	this.foodCode = foodCode;
	this.label = label;
	this.calories = calories;
	this.sugar = sugar;
	this.fat = fat;
	this.carbs = carbs;
    }

    public void incMeasure()
    {
	measure++;
    }

    public int getMeasure()
    {
	return measure;
    }

    public int getFoodCode()
    {
	return this.foodCode;
    }

    public String getLabel()
    {
	return this.label;
    }

    public int getCalories()
    {
	return this.calories;
    }

    public int getSugar()
    {
	return this.sugar;
    }

    public int getFat()
    {
	return this.fat;
    }

    public int getCarbs()
    {
	return this.carbs;
    }

    /**
       Display the label, total calories, total sugar, total fat, total carbs of FoodType
       @return string with the label, calories, sugar, fat and carbs
     */    
    public String display()
    {
	String result = label + ": Cals " + calories*measure + " Sugar " + sugar*measure + " Fat " + fat*measure + " Carbs " + carbs*measure;
	return result;
    }
        
    /**
       Method to sort the FoodType object according to total calories
       @return integer for comparison
     */
    public int compareTo(FoodType other)
    {
	if ((this.calories * this.measure) < (other.calories * other.measure))
	    {
		return 1;
	    }

	else if ((this.calories * this.measure) > (other.calories * other.measure))
	    {
		return -1;
	    }

	else
	    {
		return 0;
	    }
    }
}
