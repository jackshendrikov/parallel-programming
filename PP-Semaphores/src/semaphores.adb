package body Semaphores is

   protected body SIMA is
      
      entry P when Count > 0 is
	      begin
	      Count := Count - 1;
	   end P;
      
      entry V when Count < Max_Count is
	      begin
	      Count := Count + 1;
      end V;
      
   end SIMA;

end Semaphores;
