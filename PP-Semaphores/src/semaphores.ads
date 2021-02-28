package Semaphores is

    protected type SIMA (Initial_Value: Natural; Max_Value: Natural;) is
      entry P;
      entry V;
   private
      Count : Natural := Initial_Value;
      Max_Count : Natural := Max_Value;
   end SIMA;   

end Semaphores;
