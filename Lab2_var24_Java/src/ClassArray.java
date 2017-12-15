import java.util.ArrayList;


public class ClassArray<T extends ITransport> {
	private ArrayList<T> places;	
	private T defaultValue;
	

    public ClassArray(int sizes, T defVal)
    {
        defaultValue = defVal;
        places = new ArrayList<T>();
        for (int i = 0; i < sizes; i++)
        {
            places.add(i, defVal);
        }
    }
    
    public int add(ClassArray<T> p, T plane)
    {
        for (int i = 0; i < p.places.size(); i++)
        {
            if (p.CheckFreePlace(i))
            {
                p.places.set(i, plane);
                return i;

            }
        }
        return -1;
    }
    
    public T dec(ClassArray<T> p, int index)
    {
        if (!p.CheckFreePlace(index))
        {
            T plane = p.places.get(index);
            p.places.set(index, p.defaultValue);
            return plane;
        }
        return p.defaultValue;
    }

    private boolean CheckFreePlace(int index)
    {
        if (index < 0 || index > places.size())
        {
            return false;
        }
        if (places.get(index) == null)
        {
            return true;
        }
        if (places.get(index).equals(defaultValue))
        {
            return true;
        }
        return false;
    }
    
    public T getObject(int ind)
    {
        if (ind > -1 && ind < places.size())
        {
            return places.get(ind);
        }
        return defaultValue;
    }
}
