import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class snakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld  extends World
{
    private final int MAX_DOTS = (600*400)/(20*20);

    private int[] x = new int[MAX_DOTS];
    private int[] y = new int[MAX_DOTS];
    private int dots = 4;
    private Dot body;

    /**
     * Constructor for objects of class snakeWorld.
     * 
     */
    public SnakeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        for(int i = 0; i < dots; i++){
            x[i] = 100 - i*20;
            y[i] = 20;
        }

        addObject ( new Food(), Greenfoot.getRandomNumber(12)*50+25, Greenfoot.getRandomNumber(8)*50+25);

        prepareSnake();
    }

    /**
     * act handles the actions that must be taken every time the program is run
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        for (int i = dots; i > 0; i--)
        {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
    }

    private void prepareSnake(){
        for(int i = 0; i < dots; i++){
            body = new Dot(i);
            addObject(body, x[i], y[i]);
        }
    }

    /**
     * setDX changes the stored x coordinate for a given Dot Object
     * @param d is the dot number
     * @param dx is the new x coordinate of the Dot object
     * @return Nothing is returned
     */
    public void setDX(int d, int dx)
    {
        x[d] = dx;
    }

    /**
     * setDY changes the stored x coordinate for a given Dot Object
     * @param d is the dot number
     * @param dy is the new y coordinate of the Dot object
     * @return Nothing is returned
     */
    public void setDY(int d, int dy)
    {
        y[d] = dy;
    }

    /**
     * getMyX returns the x coordinate of the given Dot object
     * @param d is the dot number
     * @return an integer that represents the x coordinate
     */
    public int getMyX(int d)
    {
        return x[d];
    }

    /**
     * getMyY returns the y coordinate of the given Dot object
     * @param d is the dot number
     * @return an integer that represents the y coordinate
     */
    public int getMyY(int d)
    {
        return y[d];
    }

    /**
     * addFood will add a random number of Food objects into the world
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void addFood()
    {
        if( getObjects(Food.class).size() < 3 )
        {
            for(int i = 0; i < Greenfoot.getRandomNumber(2)+1; i++)
            {
                addObject ( new Food(), Greenfoot.getRandomNumber(12)*50+25, Greenfoot.getRandomNumber(8)*50+25);
            }
        }
    }

    /**
     * addDot will add a new Dot object to the end of our Snake
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void addDot()
    {
        int parentX = x[dots-1];
        int parentY = y[dots-1];
        
        body = new Dot(dots);
        addObject( body, parentX, parentY);
        dots++;
    }
    
    
    
    
}
