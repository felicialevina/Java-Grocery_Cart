import java.util.*;

public class FoodTypeCarbsComparator implements Comparator<FoodType>
{
    public int compare(FoodType object1, FoodType object2)
    {
	if (object1.getCarbs() * object1.getMeasure() > object2.getCarbs() * object2.getMeasure())
	    {
		return -1;
	    }
	else if (object1.getCarbs() * object1.getMeasure() < object2.getCarbs() * object2.getMeasure())
	    {
		return 1;
	    }
	else 
	    {
		return 0;
	    }
    }
}