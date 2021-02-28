------------------------------------------------------
--|                    Semaphores                    |
------------------------------------------------------
--|   Author   |    Jack (Yevhenii) Shendrikov       |
--|   Group    |                IO-82                |
--|   Variant  |                 #25                 |
--|    Date    |             29.11.2020              |
------------------------------------------------------
--| Function 1 | D = SORT(A)+SORT(B)+SORT(C)*(MA*ME) |
--| Function 2 |      MF = (MG*MH)*TRANS(MK)         |
--| Function 3 |     S = (MO*MP)*V+t*MR*(O+P)        |
------------------------------------------------------

with Data;
with Ada.Integer_Text_IO, Ada.Text_IO, Ada.Characters.Latin_1;
use Ada.Integer_Text_IO, Ada.Text_IO, Ada.Characters.Latin_1;
with System.Multiprocessors; use System.Multiprocessors;

with Semaphores;
use Semaphores;

procedure Lab1 is
   N: Integer;

   MY_SIMA : SIMA (1,2);

   procedure Tasks is
      package My_Data is new Data(N);
      use My_Data;

      CPU_0: CPU_Range := 0;
      CPU_1: CPU_Range := 1;
      CPU_2: CPU_Range := 2;


      task T1 is
         pragma Task_Name("T1");
         pragma Priority(4);
         pragma Storage_Size(500000000);
         pragma CPU (CPU_0);
      end T1;

      task T2 is
         pragma Task_Name("T2");
         pragma Priority(3);
         pragma Storage_Size(500000000);
         pragma CPU (CPU_1);
      end T2;

      task T3 is
         pragma Task_Name("T3");
         pragma Priority(7);
         pragma Storage_Size(500000000);
         pragma CPU (CPU_2);
      end T3;


      task body T1 is
         A,B,C,D: Vector;
         MA,ME: Matrix;
      begin
         Put_Line("Task T1 started");
         delay 0.7;
         Put_Line("T1 is waiting for a permit.");

         -- Generate Input Values
         MY_SIMA.P; -- Acquire the semaphore
         New_Line; Put_Line("T1 gets a permit.");
         delay 1.0;
         Input_Val_F1(A,B,C,MA,ME);
         Put_Line("T1 releases the permit.");
         MY_SIMA.V; -- Release  the semaphore
         New_Line; Put_Line("T1 is waiting for a permit.");

         -- Calculate The Result
         D := Func1(A,B,C,MA,ME);
         delay 1.0;

         -- Output
         MY_SIMA.P; -- Acquire the semaphore
         Put_Line("T1 gets a permit.");
         Put("T1 | ");
         Vector_Output(D, "D");
         Put_Line("T1 releases the permit."); New_Line;
         MY_SIMA.V; -- Release  the semaphore

         Put_Line("Task T1 finished"); New_Line;
      end T1;

      task body T2 is
         MG,MH,MK,MF: Matrix;
      begin
         Put_Line("Task T2 started");
         delay 1.0;
         Put_Line("T2 is waiting for a permit.");

         -- Generate Input Values
         MY_SIMA.P; -- Acquire the semaphore
         New_Line; Put_Line("T2 gets a permit.");
         delay 1.0;
         Input_Val_F2(MG,MH,MK);
         Put_Line("T2 releases the permit."); New_Line;
         MY_SIMA.V; -- Release  the semaphore
         New_Line; Put_Line("T2 is waiting for a permit.");

         -- Calculate The Result
         MF := Func2(MG,MH,MK);
         delay 1.0;

         -- Output
         MY_SIMA.P; -- Acquire the semaphore
         Put_Line("T2 gets a permit.");
         Put_Line("T2 | ");
         Matrix_Output(MF, "MF");
         Put_Line("T2 releases the permit.");
         MY_SIMA.V; -- Release  the semaphore

         Put_Line("Task T2 finished"); New_Line;
      end T2;

      task body T3 is
         t: Integer;
         V,O,P,S: Vector;
         MO,MP,MR: Matrix;
      begin
         Put_Line("Task T3 started");
         delay 0.5;
         Put_Line("T3 is waiting for a permit.");

         -- Generate Input Values
         MY_SIMA.P; -- Acquire the semaphore
         New_Line; Put_Line("T3 gets a permit.");
         delay 1.0;
         Input_Val_F3(t,V,O,P,MO,MP,MR);
         Put_Line("T3 releases the permit.");
         MY_SIMA.V; -- Release  the semaphore
         New_Line; Put_Line("T3 is waiting for a permit.");

         -- Calculate The Result
         S := Func3(t,V,O,P,MO,MP,MR);
         delay 1.0;

         -- Output
         MY_SIMA.P; -- Acquire the semaphore
         Put_Line("T3 gets a permit.");
         Put("T3 | ");
         Vector_Output(S, "S");
         Put_Line("T3 releases the permit."); New_Line;
         MY_SIMA.V; -- Release  the semaphore

         Put_Line("Task T3 finished"); New_Line;
      end T3;


   begin
      Put_Line("Calculations started");
      New_Line;
   end Tasks;

begin
   Put_Line("Function 1: D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)" & CR & LF
          & "Function 2: MF = (MG*MH)*TRANS(MK)" & CR & LF
          & "Function 3: S = (MO*MP)*V+t*MR*(O+P)" & CR & LF);

   Put_Line("!!! Note that if the value of N > 10 -> the result will not be displayed !!!" & CR & LF
          & "!!! If you enter N <= 0 - execution will be terminated !!!"  & CR & LF);
   Put("Enter N: ");
   Get(N);
   New_Line;

   Tasks;
   Put_Line("All task finished");
end Lab1;
