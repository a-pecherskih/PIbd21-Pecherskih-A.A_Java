import java.awt.Color;
import java.awt.Graphics;


public class LightPlane extends Plane{
	private boolean wings;
    private boolean screw;
    private Color dopColor2;

    public LightPlane(int MaxCountPassengers, int MaxSpeed, double MaxAltitude, double weight, Color color,
    		boolean wings, boolean screw, Color dopColor, Color dopColor2)
    {
        super(MaxCountPassengers, MaxSpeed, MaxAltitude, weight, color, dopColor);
        this.wings = wings;
        this.screw = screw;
        this.dopColor2 = dopColor2;
    }

    @Override
    protected void drawLightPlane(Graphics g)
    { 
        if (wings)
        {
            g.setColor(Color.BLACK);
            g.drawRect(startPosX + 89, startPosY + 42, 4, 19); // обводка винта
            g.setColor(this.dopColor2);
            g.fillRect(startPosX + 90, startPosY + 43, 3, 18); //винт
        }
        if (screw)
        {
        	g.setColor(Color.BLACK);
            g.drawRect(startPosX + 44, startPosY + 21, 11, 62); // обводка крыльев
            g.setColor(this.dopColor2);
            g.fillRect(startPosX + 45, startPosY + 22, 10, 61); //крылья 
        }
        super.drawLightPlane(g);
        g.setColor(this.dopColor2);
        g.fillRect(startPosX + 60, startPosY + 50, 10, 5);
        g.setColor(Color.BLACK);
        g.drawRect(startPosX + 59, startPosY + 49, 11, 6);
    }
}
