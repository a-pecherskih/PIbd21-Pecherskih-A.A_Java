
public class Potato {
	 /// ��������� ����������
    private int has_ready = 0;
    private boolean have_skin = true;
    private int dirty = 10;
    /// �� ������� ������ ��������
    private int have_parts = 0;
    
    /// ������� ������
    public void setHave_skin(boolean value){
    	have_skin = value;
    }
    
    public boolean getHave_skin(){
    	return have_skin;
    }

    /// �������� �� ������� ������ ��������
    public void setHave_parts(int value){
    	if (value > -1 && value < 11) have_parts = value;
    }
    
    public int getHave_parts(){
    	return have_parts;
    }
    
    /// C�������� ����������
    public int getHas_ready(){
    	return has_ready;
    }

    /// ������ ��������� ��������������
    public void setDirty(int value){
    	if (value > -1 && value < 11) dirty = value; 
    }
    
    public int getDirty(){
    	return dirty;
    }

    /// �������� ��������� ����������
    public void GetHeat()
    {
        if (has_ready < 10)
        {
            has_ready += 10;
        }
    }
}
