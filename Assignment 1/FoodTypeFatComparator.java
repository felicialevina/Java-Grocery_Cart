import java.util.*;

public class FoodTypeFatComparator implements Comparator<FoodType>
{
    public int compare(FoodType object1, FoodType object2)
    {
	if (object1.getFat() * object1.getMeasure()> object2.getFat() * object2.getMeasure())
	    {
		return -1;
	    }
	else if (object1.getFat() * object1.getMeasure() < object2.getFat() * object2.getMeasure())
	    {
		return 1;
	    }
	else 
	    {
		return 0;
	    }
    }
}