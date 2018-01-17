import java.awt.Color;
import java.awt.Graphics;


public abstract class Vehicle implements ITransport{
	protected int startPosX;
    protected int startPosY;
    protected int countPassengers;
    protected int maxSpeed;
    protected double maxAltitude;
    protected double weight;
    
    private Color colorBody;
    private Color dopColor;

    public int getMaxCountPassengers() {
    	return countPassengers;
    }
    
    protected void setMaxCountPassengers(int countPassengers) {
    	this.countPassengers = countPassengers;
    }
    
    public int getMaxSpeed() {
    	return maxSpeed;
    }
    
    protected void setMaxSpeed(int maxSpeed) {
    	this.maxSpeed = maxSpeed;
    }
    
    public double getMaxAltitude() {
    	return countPassengers;
    }
    
    protected void setMaxAltitude(double maxAltitude) {
    	this.maxAltitude = maxAltitude;
    }
    
    public double getWeight() {
    	return countPassengers;
    }
    
    protected void setWeight(double weight) {
    	this.weight = weight;
    }
    
    public Color getColorBody() {
    	return colorBody;
    }
    
    protected void setColorBody(Color color) {
    	this.colorBody = color;
    }
    
    public Color getDopColor() {
    	return dopColor;
    }
    
    protected void setDopColor(Color color) {
    	this.dopColor = color;
    }

    public abstract void drawPlane(Graphics g);
    public abstract void movePlane();

    public void loadPassenger(int count)
    {
        if (countPassengers + count < getMaxCountPassengers())
        {
            countPassengers += count;
        }
    }

    public int getPassenger()
    {
        int count = countPassengers;
        countPassengers = 0;
        return count;
    }

    public void setPosition(int x, int y)
    {
        startPosX = x;
        startPosY = y;
    }
    
    @Override
	public void setMainColor(Color color) {
		colorBody = color;		
	}
}
