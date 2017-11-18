
public class Stove {
	private Pan pan;
    /// —осто€ние плиты. ¬кл/выкл
    private boolean State;
    public void setState(boolean value)
    {
    	State = value;
    }
    
    public boolean getState(){
    	return State;
    }
    
    public void setPan(Pan pan){
    	this.pan = pan;
    }
    
    public Pan getPan(){
    	return pan;
    }
    
    int count = 0;
    public void Cook()
    {
        if (State && count == 0)
        {
            pan.GetHeat();

        }
    }
}
