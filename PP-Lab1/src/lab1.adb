------------------------------------------------------
--|                    Labwork #1                    |
------------------------------------------------------
--|   Author   |    Jack (Yevhenii) Shendrikov       |
--|   Group    |                IO-82                |
--|   Variant  |                 #25                 |
--|    Date    |             06.09.2020              |
------------------------------------------------------
--| Function 1 | D = SORT(A)+SORT(B)+SORT(C)*(MA*ME) |
--| Function 2 |      MF = (MG*MH)*TRANS(MK)         |
--| Function 3 |     S = (MO*MP)*V+t*MR*(O+P)        |
------------------------------------------------------

with Data;
with Ada.Integer_Text_IO, Ada.Text_IO, Ada.Characters.Latin_1;
use Ada.Integer_Text_IO, Ada.Text_IO, Ada.Characters.Latin_1;
with System.Multiprocessors; use System.Multiprocessors;

procedure Lab1 is
   N, val: Integer;
   -- val -> a variable that determines what kind of input data will be sent for processing in each task for each function (Func1..3), for example, the input data can be random, all-ones or entered from the keyboard, it is selected by the user in the body of the main program .

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
         delay 1.0;
         Input_Val_F1(A,B,C,MA,ME,val);
         D := Func1(A,B,C,MA,ME);
         delay 2.0;

         if N <= 10 then
            Put("T1 | ");
            Vector_Output(D, "D");
            New_Line;
         end if;

         Put_Line("Task T1 finished");
         New_Line;
      end T1;

      task body T2 is
         MG,MH,MK,MF: Matrix;
      begin
         Put_Line("Task T2 started");
         delay 4.0;
         Input_Val_F2(MG,MH,MK,val);
         MF := Func2(MG,MH,MK);
         delay 5.0;

         if N <= 10 then
            Put_Line("T2 | ");
            Matrix_Output(MF, "MF");
            New_Line;
         end if;

         Put_Line("Task T2 finished");
         New_Line;
      end T2;

      task body T3 is
         t: Integer;
         V,O,P,S: Vector;
         MO,MP,MR: Matrix;
      begin
         Put_Line("Task T3 started");
         delay(7.0);
         Input_Val_F3(t,V,O,P,MO,MP,MR,val);
         S := Func3(t,V,O,P,MO,MP,MR);
         delay(5.0);
         if N <= 10 then
            Put("T3 | ");
            Vector_Output(S, "S");
            New_Line;
         end if;

         Put_Line("Task T3 finished");
         New_Line;
      end T3;


   begin
      Put_Line("Calculations started");
      New_Line;
   end Tasks;

begin
   Put_Line("----------------------------------------------------" & CR & LF
          & "| Function 1 | D = SORT(A)+SORT(B)+SORT(C)*(MA*ME) |" & CR & LF
          & "| Function 2 |      MF = (MG*MH)*TRANS(MK)         |" & CR & LF
          & "| Function 3 |     S = (MO*MP)*V+t*MR*(O+P)        |" & CR & LF
          & "----------------------------------------------------" & CR & LF);

   Put_Line("!!! Note that if the value of N > 10 -> the result will not be displayed !!!" & CR & LF
          & "!!! If you enter N <= 0 - execution will be terminated !!!"  & CR & LF
          & "!!! Also note that the header may also be distorted if exe is running in GNAT Studio !!!" & CR & LF);
   Put("Enter N: ");
   Get(N);

   if N <= 0 then
      raise PROGRAM_ERROR with "Restart the program and enter N > 0.";
   end if;

   New_Line;
   Put_Line("Select the method according to which the initial data will be generated:");
   Put_Line("   [1] - Create All-Ones Matrices And Vectors.");
   Put_Line("   [2] - Create Matrices And Vectors With Random Values.");
   Put_Line("   [3] - Enter All Values From The Keyboard (The program works, but due to threads the input can be a little distorted).");
   Put("Your choice [1] / [2] / [3]: ");
   Get(val);
   New_Line;

   if N > 10 and val = 3 then
      raise PROGRAM_ERROR with "If you want to enter a value from the keyboard - enter N <= 10.";
   end if;

   Tasks;
end Lab1;
