
public class Oil {
	/// ����� � �������. ����/���
    private boolean State;
    public void setState(boolean value)
    {
    	State = value;
    }
    
    public boolean getState(){
    	return State;
    }

    /// ������� ���������� �����
    private int temperature = 0;

    /// ������ ����������� �����
    public int getTemperature(){
    	return temperature;
    }

    /// �������� ���-�� �����, ���� ��� �� �������
    public void GetHeat()
    {
        if (temperature < 100)
        {
            temperature++;
        }
    }

    /// ���� ����� ����, �� ���� �����
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
