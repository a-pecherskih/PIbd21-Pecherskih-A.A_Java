import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Plane extends Vehicle {
	@Override
	protected void setMaxCountPassengers(int value)
    {
            if (value > 0 && value < 7)
            {
                super.setMaxCountPassengers(value);
            }
            else
            {
            	super.setMaxCountPassengers(5);
            }
    }
	
	@Override
	protected  void setMaxSpeed(int value)
    {

            if (value > 0 && value < 750)
            {
            	super.setMaxSpeed(value);
            }
            else
            {
            	super.setMaxSpeed(630);
            }
    }

	@Override
	protected  void setMaxAltitude(double value)
    {
            if (value > 0 && value < 1.50)
            {
            	super.setMaxAltitude(value);
            }
            else
            {
            	super.setMaxAltitude(1.20);
            }
    }
	
	@Override
	protected  void setWeight(double value)
    {        
            if (value > 1650 && value < 4100)
            {
            	super.setWeight(value);
            }
            else
            {
            	super.setWeight(2500);
            }
        }
	
    public Plane(int maxCountPassengers, int maxSpeed, double maxAltitude, double weight, Color color, Color dopcolor)
    {
        setMaxCountPassengers(maxCountPassengers);
        setMaxSpeed(maxSpeed);
        setMaxAltitude(maxAltitude);
        setColorBody(color);
        setDopColor(dopcolor);
        setWeight(weight);
        this.countPassengers = 0;
        Random rand = new Random();
        startPosX = rand.nextInt(10)+ 90;
        startPosY = rand.nextInt(10) + 90;
    }
    
	@Override
	public void drawPlane(Graphics g) {
		drawLightPlane(g);
	}

	@Override
	public void movePlane() {
		startPosX += 10;
        //(MaxSpeed * 500 / (float)Weight) /
          //  (countPassengers == 0 ? 1 : countPassengers);
	}
	
	protected void drawLightPlane(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawOval(startPosX + 69, startPosY + 44, 21, 16); // обводка переда
        g.setColor(super.getColorBody());
        g.fillOval(startPosX + 70, startPosY + 45, 20, 15); //перед
        g.setColor(Color.BLACK);
        g.drawRect(startPosX + 54, startPosY + 19, 16, 66); // обводка крыльев
        g.setColor(super.getDopColor());
        g.fillRect(startPosX + 55, startPosY + 20, 15, 65); //крылья 
        g.setColor(Color.BLACK);
        g.drawRect(startPosX-1, startPosY + 44, 81, 16); // обводка основы
        g.setColor(super.getColorBody());
        g.fillRect(startPosX, startPosY + 45, 80, 15); //основная линия
        g.setColor(Color.BLACK);
        g.drawRect(startPosX - 1, startPosY + 34, 11, 36); // обводка зада
        g.setColor(super.getDopColor());
        g.fillRect(startPosX, startPosY + 35, 10, 35); //зад
    }
}
