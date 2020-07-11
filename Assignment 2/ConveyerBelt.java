import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConveyerBelt extends JComponent
{
    private class LinkGroceryItem
    {
	GroceryItem gitem;
	LinkGroceryItem next;
	Rectangle box;
	int xPosition = 60;
	int yPosition = 40;
	int width = 60;
	int height = 40;

	public LinkGroceryItem(GroceryItem gitem, LinkGroceryItem next)
	{
	    this.gitem = gitem;
	    this.next = next;
	    box = new Rectangle(xPosition, yPosition, width, height);
	}

	/**
	   Sets location of box and string based on coordinate
	   @param int x coordinate and int y coordinate
	 */
	public void setLocation(int x, int y)
	{
      	    box.setLocation(x,y);
	    xPosition = x;
	    yPosition = y;
	    repaint();
	}

	/**
	   Checks if the box intersects with any box in the conveyer belt
	   @param the picked up link grocery item object
	   @return true if it intersects and false if it does not intersect
	 */
	public boolean intersects(LinkGroceryItem item)
	{
	    if (item.box.intersects(this.box))
		{
		    return true;
		}
	    else
		{
		    return false;
		}
	}
	
	/**
	   Draw the box of the link grocery object and the name of the grocery item
	   @param g2 the graphic context
	 */
	public void draw(Graphics2D g2)
	{
	    g2.draw(box);
	    g2.setFont(new Font("TimesRoman", Font.PLAIN, 9));
	    g2.drawString(gitem.getLabel(), xPosition + 3, yPosition + 10);
	}       
    }

    private LinkGroceryItem first;
    private LinkGroceryItem pickedUpItem = null;
    private boolean checkIntersect = false;
    private int xPost = 60;
    private int yPost = 40;

    public ConveyerBelt()
    {

	/**
	   Mouse Listener for picked up item
	   If the mouse is pressed, the box will be drawn in that coordinate
	   If the mouse is released and the box intersects any box in the conveyer, it will be added to the conveyer after the box at the conveyer
	   Checks if there is no picked up item, catch exception for the mouse pressed and mouse released listener
	 */
	class ConveyerMouseListener implements MouseListener
	{
	    public void mousePressed(MouseEvent event)
      	    {
		try
		    {
			xPost = event.getX();
			yPost = event.getY();
			pickedUpItem.setLocation(xPost,yPost);
			repaint();
		    }
		catch(NullPointerException exception)
		    {}
	    }
	    public void mouseReleased(MouseEvent event)
	    {
		try
		    {
			LinkGroceryItem position = null;
			if(numItems() <= 5)
			    {
				for(LinkGroceryItem i = first; i != null && pickedUpItem != null; i = i.next)
				    {
					if(pickedUpItem.box.intersects(i.box))
					    {
						position = i.next;
						i.next = pickedUpItem;
						i = i.next;
						i.next = position;
						pickedUpItem = null;
						checkIntersect = true;
						repaint();
					    }
				    }
			    }
		    }
		catch(NullPointerException exception)
		    {}
	    }
		   
	    public void mouseClicked(MouseEvent event){}
	    public void mouseEntered(MouseEvent event){}
	    public void mouseExited(MouseEvent event){}
	}
    
	MouseListener conveyerListener = new ConveyerMouseListener();
	addMouseListener(conveyerListener);

	/**
	   Motion Listener for picked up item
	   When the mouse is dragged, it will move the box around according to the mouse
	   Checks if there is no picked up item, catch exception for the mouse motion dragged listener
	 */
	class ConveyerMotionListener implements MouseMotionListener
	{
	    public void mouseDragged(MouseEvent event)
	    {
		try
		    {
			xPost = event.getX();
			yPost = event.getY();
			pickedUpItem.setLocation(xPost,yPost);
			repaint();
		    }
		catch(NullPointerException exception)
		    {}
	    }
            	    public void mouseMoved(MouseEvent event){}
	}
		ConveyerMotionListener conveyerMotion = new ConveyerMotionListener();
		addMouseMotionListener(conveyerMotion);
    }
    
    /**
       Makes sure no other items are taken from the grocery cart if picked up item is not null
       @return boolean stored in checkIntersect if picked up item is null and returns false if picked up item is not null'
     */
    public boolean checkIntersection()
    {
	if(pickedUpItem == null)
	    {
		return checkIntersect;
	    }
	else
	    {
		return false;
	    }
    }
    /**
       Makes sure pickedUpItem is null
       @return boolean true if null and false if it stores link grocery object
     */
    public boolean checkPickedUp()
    {
	if(pickedUpItem == null)
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }

    /**
       Show the number of linked grocery item
       @return int size of linked list
     */
    private int numItems()
    {
       	int num = 1;
	for(LinkGroceryItem i = first; i != null; i = i.next)
	    {
		num++;
	    }
	return num;
    }

    /**
       Adds item to the beginning of linked list
       Sets picked up item back to null after adding it to linked list
     */
    public void addItem()
    {
	if(numItems() <= 5)
	    {
		LinkGroceryItem temp = pickedUpItem;
		pickedUpItem = null;
		
		if (first == null && temp != null)
		    {
			first = temp;
		    }
		else if (temp != null)
		    {
			temp.next = first;
			first = temp;
		    }
		repaint();
	    }
    }
    /**
       Removes last item of the linked list
       @return last grocery item in the linked list
     */
    public GroceryItem removeItem()
    {
	LinkGroceryItem position = first;
	LinkGroceryItem previous = first;
	GroceryItem returnitem;
	if (first == null)
	    {
		return null;
	    }
	else if (first.next == null)
	    {
		returnitem = first.gitem;
		first = null;
	    }
	else
	    {
		while (position.next != null)
		    {
			previous = position;
			position = position.next;
		    }
		previous.next = null;
		returnitem = position.gitem;		
	    }
       	repaint();
	return position.gitem;
    }
   
    /**
       Set the next grocery item into the picked up link grocery item
       @return false if picked up item is not null and true if it is null
     */
    public boolean setPickedUpItem(GroceryItem item)
    {
	if(pickedUpItem == null)
	    {
			LinkGroceryItem pick = new LinkGroceryItem(item, null);
			pickedUpItem = pick;
			repaint();
			return false;
		    }
		else
		    {
			return true;
		    }
	    
    }

    /**
       Draw all the object to the panel
       @param g the graphic context g2 sent to the draw method
     */
    public void paintComponent(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.fillRect(50, 180, 340, 15);

	if (pickedUpItem != null)
	    {
		pickedUpItem.draw(g2);
	    }

	int xPos = 60;
	int yPos = 135;

	for(LinkGroceryItem i = first; i != null; i = i.next)
	    {
		i.setLocation(xPos, yPos);
		i.draw(g2);
		xPos += 65;
	    }
    }
    
}