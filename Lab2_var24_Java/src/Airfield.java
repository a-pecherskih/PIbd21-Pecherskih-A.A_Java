import java.awt.Color;
import java.awt.Graphics;


public class Airfield {
	ClassArray<ITransport> airfield;

    int countPlaces = 20;
    int placeSizeWidth = 210;
    int placeSizeHeight = 80;

    public Airfield()
    {
        airfield = new ClassArray<ITransport>(countPlaces, null);
    }

    public int PutPlaneInAirfield(ITransport plane)
    {
        return airfield.add(airfield, plane);
    }

    public ITransport GetPlaneFromAirfield(int ticket)
    {
        return airfield.dec(airfield, ticket);
    }

    public void Draw(Graphics g)
    {
    	DrawMarking(g);
        for (int i = 0; i < countPlaces; i++)
        {
        	ITransport plane = airfield.getObject(i);
            if (plane != null)
            {
                plane.setPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight - 15);
                plane.drawPlane(g);
            }
        }
    }

    private void DrawMarking(Graphics g)
    { 		
        g.setColor(Color.black);
        //границы парковки
        g.drawRect(0, 0, (countPlaces / 5) * placeSizeWidth, 480);

        for (int i = 0; i < countPlaces / 5; i++)
        { //отрисовка по 5 мест на линии
            for (int j = 0; j < 6; ++j)
            {//линия разметки места
            	 g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 100, j * placeSizeHeight);
            }
            g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
        }
    }
}
