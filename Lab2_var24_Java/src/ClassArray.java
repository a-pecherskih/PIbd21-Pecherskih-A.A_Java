import java.util.HashMap;
import java.util.Map;


public class ClassArray<T extends ITransport> {
	private Map<Integer,T> places;
	private int maxCount;
	private T defaultValue;
	

    public ClassArray(int sizes, T defVal)
    {
        defaultValue = defVal;
        places = new HashMap<Integer,T>();
        maxCount = sizes;
    }
    
    public int add(T plane)
    {
    	if(places.size() == maxCount){
    		return -1;
    	}
        for (int i = 0; i < places.size(); i++)
        {
            if (CheckFreePlace(i))
            {
                places.put(i, plane);
                return i;
            }
        }
        places.put(places.size(), plane);
        return places.size()-1;
    }
    
    public T dec(int index)
    {
        if (places.containsKey(index))
        {
            T plane = places.get(index);
            places.remove(index);
            return plane;
        }
        return defaultValue;
    }

    private boolean CheckFreePlace(int index)
    {
        return !places.containsKey(index);
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
