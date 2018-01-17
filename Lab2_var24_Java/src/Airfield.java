import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Airfield {
	List<ClassArray<ITransport>> airfield;

    int countPlaces = 20;
    int placeSizeWidth = 210;
    int placeSizeHeight = 80;
    int currentLevel;

    public int getCurrentLevel(){
    	return currentLevel;
    }
    
    public Airfield(int countStages)
    {
        airfield = new ArrayList<ClassArray<ITransport>>();
        for (int i = 0; i < countStages; i++){
        	airfield.add(new ClassArray<ITransport>(countPlaces, null));
        }
        currentLevel = 0;
    }
    
    public void LevelUp(){
    	if(currentLevel + 1 < airfield.size()){
    		currentLevel++;
    	}
    }
    
    public void LevelDown(){
    	if(currentLevel > 0){
    		currentLevel--;
    	}
    }


    public int PutPlaneInAirfield(ITransport plane)
    {
        return airfield.get(currentLevel).add(plane);
    }

    public ITransport GetPlaneFromAirfield(int ticket)
    {
        return airfield.get(currentLevel).dec(ticket);
    }

    public void Draw(Graphics g)
    {
    	DrawMarking(g);
        for (int i = 0; i < countPlaces; i++)
        {
        	ITransport plane = airfield.get(currentLevel).getObject(i);
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
