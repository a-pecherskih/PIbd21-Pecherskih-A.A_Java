
public class Potato {
	 /// —осто€ние готовности
    private int has_ready = 0;
    private boolean have_skin = true;
    private int dirty = 10;
    /// на сколько частей нарезана
    private int have_parts = 0;
    
    /// Ќаличие кожуры
    public void setHave_skin(boolean value){
    	have_skin = value;
    }
    
    public boolean getHave_skin(){
    	return have_skin;
    }

    /// проверка на сколько частей нарезана
    public void setHave_parts(int value){
    	if (value > -1 && value < 11) have_parts = value;
    }
    
    public int getHave_parts(){
    	return have_parts;
    }
    
    /// Cосто€ние готовности
    public int getHas_ready(){
    	return has_ready;
    }

    /// «адаем состо€ние загр€зненности
    public void setDirty(int value){
    	if (value > -1 && value < 11) dirty = value; 
    }
    
    public int getDirty(){
    	return dirty;
    }

    /// »змен€ем состо€ние готовности
    public void GetHeat()
    {
        if (has_ready < 10)
        {
            has_ready += 10;
        }
    }
}
