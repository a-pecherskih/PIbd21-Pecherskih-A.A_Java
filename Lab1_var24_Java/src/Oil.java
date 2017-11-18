
public class Oil {
	/// Масло в наличии. Есть/нет
    private boolean State;
    public void setState(boolean value)
    {
    	State = value;
    }
    
    public boolean getState(){
    	return State;
    }

    /// Степень готовности масла
    private int temperature = 0;

    /// Узнаем температуру масла
    public int getTemperature(){
    	return temperature;
    }

    /// Повышаем тем-ру масла, пока оно не закипит
    public void GetHeat()
    {
        if (temperature < 100)
        {
            temperature++;
        }
    }

    /// Если масло есть, то даем масло
    public Oil GetOil()
    {
        if (State)
        {
            return new Oil();
        }
        else
        {
            return null;
        }
    }
}
