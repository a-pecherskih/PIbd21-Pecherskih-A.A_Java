
public class Dish {
	 private Potato[] potatos;

     private Salt salt;

     public void Init(int countPotatos)
     {
         potatos = new Potato[countPotatos];
     }

     public void AddSalt(Salt s)
     {
         salt = s;
     }

     public void AddPotato(Potato p)
     {
         for (int i = 0; i < potatos.length; ++i)
         {
             if (potatos[i] == null)
             {
                 potatos[i] = p;
                 return;
             }
         }
     }
}
