with Ada.Numerics.Discrete_Random;
with Ada.Integer_Text_IO, Ada.Text_IO; 
use Ada.Integer_Text_IO, Ada.Text_IO;

package body Data is
   
    -- Create All-Ones Matrix And Vector
   procedure All_Ones_Matrix (MA: out Matrix) is
   begin
      for i in 1..N loop
         for j in 1..N loop
            MA(i,j) := 1;
         end loop;
      end loop;
   end All_Ones_Matrix;
    
   procedure All_Ones_Vector (A: out Vector) is
   begin
      for i in 1..N loop
         A(i) := 1;
      end loop;
   end All_Ones_Vector;   
   
   
   -- Function That Generate Random Numbers From -10..10
   function Rand_Gen return Integer is
      subtype randRange is Integer range -10..10;
      package Rand_Int is new Ada.Numerics.Discrete_Random(randRange);
      use Rand_Int;
      gen: Rand_Int.Generator;
   begin
      Rand_Int.Reset(gen);
      return Rand_Int.Random(gen);
   end Rand_Gen;
   
   
   -- Generate And Fill Random Matrix And Vector
   procedure Random_Matrix (MA: out Matrix) is
   begin          
      for i in 1..N loop        
         for j in 1..N loop     
            MA(i,j) := Rand_Gen;
         end loop;     
      end loop;        
   end Random_Matrix;                  
              
   procedure Random_Vector (A: out Vector) is          
   begin          
      for i in 1..N loop        
         A(i) := Rand_Gen; 
      end loop;        
   end Random_Vector;          
    
   
   -- Print Matrix And Vector Into Console
   procedure Matrix_Output (MA: in Matrix; str: in String) is
   begin
      Put_Line("Matrix " & str & ":");
      for i in 1..N loop
         for j in 1..N loop
            Put(MA(i,j));
         end loop;
         New_Line;
      end loop;
      New_Line;
   end Matrix_Output;             
                
   procedure Vector_Output (A: in Vector; str: in String) is             
   begin
      Put("Vector " & str & ":");
      for i in 1..N loop           
         Put(A(i));       
      end loop;
      New_Line; 
   end Vector_Output;  
   
   procedure Num_Output (a: in Integer; str: in String) is             
   begin
      Put("Number " & str & ":");
      Put(a);       
      New_Line; 
   end Num_Output;      
   
   
    --Fill And Print Matrices And Vectors Into Console
   procedure Matrix_Input (MA: out Matrix; str: in String) is
   begin
      Put_Line("Enter the" & Positive'Image(N * N) & " elements of the Matrix " & str & ":");
      for i in 1..N loop
         for j in 1..N loop
            Put(str & "(" & Integer'Image(i) & "." & Integer'Image(j) & " ) = ");
            Get(MA(i,j));
         end loop;
         New_Line;
      end loop; 
   end Matrix_Input;
   
   procedure Vector_Input (A: out Vector; str: in String) is  
   begin
      Put_Line("Enter the" & Positive'Image(N) & " elements of the Vector " & str & ":");
      for i in 1..N loop          
         Put(str & "(" & Integer'Image(i) & " ) = ");
         Get(A(i));       
      end loop;          
   end Vector_Input;            
   
   
   -- Sort Vector
   procedure Sort_Vector(A: in out Vector) is
      temp: Integer;
   begin
      for i in 1..n loop
         for j in i..n loop
            if A(i)>A(j) then
               temp:=A(j);
               A(j):=A(i);
               A(i):=temp;
            end if;
         end loop;
      end loop;
   end Sort_Vector;
   
   
   -- Calculates Sum Of 2 Vectors
   function Sum_Vectors (A, B: in Vector) return Vector is          
      result: Vector;          
   begin          
      for i in 1..N loop        
         result(i) := A(i) + B(i);    
      end loop;        
      return result;          
   end Sum_Vectors; 
   
   
   -- Transposing Matrix
   function Matrix_Transposition(MA: in Matrix) return Matrix is         
      temp: Integer;
      MZ: Matrix;
   begin    
      for i in 1..N loop        
         for j in 1..N loop    
            temp := MA(j,i);
            MZ(j,i) := MA(i,j);
            MZ(i,j) := temp;
         end loop;    
      end loop;
      return MZ;
   end Matrix_Transposition;   
   
   
   -- Multiply 2 Matrices
   function Matrix_Multiplication (MA, MB: in Matrix) return Matrix is          
      product : Integer;          
      result: Matrix;          
   begin
      for i in 1..N loop      
         for j in 1..N loop    
            product := 0;
            for k in 1..N loop
               product := product + MA(i,k) * MB(k,j);   
            end loop;
            result(i,j) := product;    
         end loop;    
      end loop;
      return result;       
   end Matrix_Multiplication;          
   
   
   -- Multipy Matrix And Vector
   function Matrix_Vector_Multiplication (MA: in Matrix; A: in Vector) return Vector is        
      product: Integer;  
      result: Vector;          
   begin          
      for i in 1..N loop
         product := 0;
         for j in 1..N loop    
            product := product + A(j) * MA(j,i);
         end loop;
         result(i) := product;
      end loop;    
      return result;
   end Matrix_Vector_Multiplication;          
        
   
   -- Multipy Integer And Matrix
   function Matrix_Integer_Multiplication (MA:in Matrix; a: in Integer) return Matrix is
      MZ: Matrix;
   begin
      for i in 1..N loop
         for j in 1..N loop
            MZ(i,j) := a * MA(i,j);
         end loop;
      end loop;
      return MZ;
   end Matrix_Integer_Multiplication;
   
   
   -- Generate Initial Values
   procedure Input_Val_F1 (A,B,C: out Vector; MA,ME: out Matrix) is
   begin
      Random_Vector(A);
      Random_Vector(B);
      Random_Vector(C);
      Random_Matrix(MA);
      Random_Matrix(ME);
               
      Put_Line("Entered values T1:");
      Vector_Output(A, "A");
      Vector_Output(B, "B");
      Vector_Output(C, "C");
      Matrix_Output(MA, "MA");
      Matrix_Output(ME, "ME");
   end Input_Val_F1;

   procedure Input_Val_F2 (MG,MH,MK: out Matrix) is
   begin
      Random_Matrix(MG);
      Random_Matrix(MH);
      Random_Matrix(MK);
            
      Put_Line("Entered values T2:");
      Matrix_Output(MG, "MG");
      Matrix_Output(MH, "MH");
      Matrix_Output(MK, "MK");
   end Input_Val_F2;

   procedure Input_Val_F3 (t: out Integer; V,O,P: out Vector; MO,MP,MR: out Matrix) is
   	begin	
      Put("t = ");
      t := Rand_Gen;
      Random_Vector(V);
      Random_Vector(O);
      Random_Vector(P);
      Random_Matrix(MO);
      Random_Matrix(MP);
      Random_Matrix(MR);
               
      Put_Line("Entered values T3:");
      Num_Output(t, "t");
      Vector_Output(V, "V");
      Vector_Output(O, "O");
      Vector_Output(P, "P");
      Matrix_Output(MO, "MO");
      Matrix_Output(MP, "MP");
      Matrix_Output(MR, "MR");
   end Input_Val_F3;
  
   
   --Function 1 (SORT(A)+SORT(B)+SORT(C)*(MA*ME))           
   function Func1 (A,B,C: out Vector; MA,ME: in Matrix) return Vector is
   begin
      Sort_Vector(A);
      Sort_Vector(B);
      Sort_Vector(C);

      return Sum_Vectors(Sum_Vectors(A, B), Matrix_Vector_Multiplication(Matrix_Multiplication(MA, ME), C));  
   end Func1;           
              
   --Function 2 ((MG*MH)*TRANS(MK))          
   function Func2 (MG,MH, MK: in Matrix) return Matrix is
   begin
      return Matrix_Multiplication(Matrix_Multiplication(MG,MH), Matrix_Transposition(MK));    
   end Func2;           
              
   --Function 3 ((MO*MP)*V+t*MR*(O+P))           
   function Func3 (t: in Integer; V, O, P: in Vector; MO, MP, MR: in Matrix) return Vector is 
   begin
      return Sum_Vectors(Matrix_Vector_Multiplication(Matrix_Multiplication(MO, MP), V), Matrix_Vector_Multiplication(Matrix_Integer_Multiplication(MR, t), Sum_Vectors(O,P)));        
   end Func3;           
end data;
