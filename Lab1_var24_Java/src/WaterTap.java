
public class WaterTap {
	private boolean State;
	/// Состояние крана. Открыт/закрыт
	public void setState(boolean value){
		State = value;
	}
	
    public boolean getState(){
    	return State;
    }

    /// Если кран открыт, то картошка будет вымыта
    public void Wash(Potato p)
    {
        if (State)
        {
            p.setDirty(0);
        }
    }
}
