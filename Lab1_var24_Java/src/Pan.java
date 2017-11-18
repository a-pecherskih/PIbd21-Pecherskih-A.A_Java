
public class Pan {
	 private Oil[] oil;
     private Potato[] potatos;

     /// Состояние готовности
     public boolean getReadyToGo()
     {
    	 if (CheckOil() && CheckPotato())
         {
             return true;
         }
         else return false;     
         
     }

     public void Init(int countPotatos)
     {
         potatos = new Potato[countPotatos];
     }

     public void InitOil()
     {
         oil = new Oil[3];
     }

     /// Добавляем масло в кастрюлю
     public void AddOil(Oil o)
     {
         for (int i = 0; i < oil.length; ++i)
         {
             if (oil[i] == null)
             {
                 oil[i] = o;
                 return;
             }
         }
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

     /// Проверка. Все ли ингредиенты есть для готовки
     private boolean CheckOil()
     {

         if (oil.length == 0)
         {
             return false;
         }

         for (int i = 0; i < oil.length; ++i)
         {
             if (oil[i] == null)
             {
                 return false;
             }
         }


         return true;
     }

     private boolean CheckPotato()
     {
         if (potatos.length == 0)
         {
             return false;
         }
         for (int i = 0; i < potatos.length; ++i)
         {
             if (potatos[i] == null)
             {
                 return false;
             }
         }
         return true;
     }

     int flag = 0;
     /// готовка. Изменяем состояние масла
     public void GetHeat()
     {
         if (!CheckOil())
         {
             return;
         }
         if (oil.length > 0)
         {
             while (oil[0].getTemperature() < 100)
             {
                 for (int i = 0; i < oil.length; ++i)
                 {
                     oil[i].GetHeat();
                 }
             }
             if (flag == 1)
             {
                 for (int i = 0; i < potatos.length; ++i)
                 {
                     potatos[i].GetHeat();
                 }
             }
             flag++;
         }
     }

     /// Проверяем готова ли картошка
     public boolean IsReady()
     {
         for (int i = 0; i < oil.length; ++i)
         {
             if (oil[i].getTemperature() < 100)
             {
                 return false;
             }
         }
         for (int i = 0; i < potatos.length; ++i)
         {
             if (potatos[i].getHas_ready() < 10)
             {
                 return false;
             }
         }

         return true;
     }

     public Potato[] GetPotatos()
     {
         return potatos;
     }
}
