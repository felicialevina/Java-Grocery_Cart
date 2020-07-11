public class GroceryItem
{
    private String label;
    private double price;
    private int foodCode;

    public GroceryItem(int foodCode, String label, double price)
    {
	this.label = label;
	this.price = price;
	this.foodCode = foodCode;
    }

    public int getFoodCode()
    {
	return foodCode;
    }

    public void setFoodCode(int foodCode)
    {
	this.foodCode = foodCode;
    }

    public String getLabel()
    {
	return this.label;
    }

    public void setLabel (String label)
    {
	this.label = label;
    }

    public double getPrice()
    {
	return price;
    }

    public void setPrice(double price)
    {
	this.price = price;
    }
}
/** 
    Dairy.java
*/

class Dairy extends GroceryItem
{
    private double volume;

    public Dairy(int foodCode, String label, double price, double volume)
    {
	super(foodCode, label, price);
	this.volume = volume;
    }

    public double getPrice()
    {
	return super.getPrice() * volume;
    }
}

/**
   Meat.java
*/

class Meat extends GroceryItem
{
    private double weight;

    public Meat(int foodCode, String label, double price, double weight)
    {
	super(foodCode, label, price);
	this.weight = weight;
    }

    public double getPrice()
    {
	return super.getPrice() * weight;
    }
}
