import java.util.*;

public class FoodTypeSugarComparator implements Comparator<FoodType>
{
    public int compare(FoodType object1, FoodType object2)
    {
	if (object1.getSugar() * object1.getMeasure() > object2.getSugar() * object2.getMeasure())
	    {
		return -1;
	    }
	else if (object1.getSugar() * object1.getMeasure() < object2.getSugar() * object2.getMeasure())
	    {
		return 1;
	    }
	else 
	    {
		return 0;
	    }
    }
}