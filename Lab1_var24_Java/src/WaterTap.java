
public class WaterTap {
	private boolean State;
	/// ��������� �����. ������/������
	public void setState(boolean value){
		State = value;
	}
	
    public boolean getState(){
    	return State;
    }

    /// ���� ���� ������, �� �������� ����� ������
    public void Wash(Potato p)
    {
        if (State)
        {
            p.setDirty(0);
        }
    }
}
