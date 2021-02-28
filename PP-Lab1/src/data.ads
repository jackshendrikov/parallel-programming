generic
   N: Integer;
package Data is
   type Vector is private;
   type Matrix is private;

   --Procedures, that fills random values into Vectors and Matrixes
   procedure Random_Vector (A: out Vector);
   procedure Random_Matrix (MA: out Matrix);

   --Procedures, that fills Matrixes and Vectors with 1:
   procedure All_Ones_Vector(A: out Vector);
   procedure All_Ones_Matrix(MA: out Matrix);

   --Procedures, that shows values of Vectors and Matrixes in the screen
   procedure Vector_Output (A: in Vector; str: in String);
   procedure Matrix_Output (MA: in Matrix; str: in String);

    --Procedures, that fills a values into Vectors and Matrixes
   procedure Vector_Input (A: out Vector; str: in String);
   procedure Matrix_Input (MA: out Matrix; str: in String);


   -- Procedures, that generates initial values for each Function
   -- Depending on the option chosen by the user (val)
   procedure Input_Val_F1 (A,B,C: out Vector; MA,ME: out Matrix; val: Integer);
   procedure Input_Val_F2 (MG,MH,MK: out Matrix; val: Integer);
   procedure Input_Val_F3 (t: out Integer; V,O,P: out Vector; MO,MP,MR: out Matrix; val: Integer);

   --Function 1 (SORT(A)+SORT(B)+SORT(C)*(MA*ME))
   function Func1 (A,B,C: out Vector; MA,ME: in Matrix) return Vector;

   --Function 2 ((MG*MH)*TRANS(MK))
   function Func2 (MG,MH,MK: in Matrix) return Matrix;

   --Function 3 ((MO*MP)*V+t*MR*(O+P))
   function Func3 (t: in Integer; V, O, P: in Vector; MO, MP, MR: in Matrix) return Vector;

   private
   type Vector is array (1..N) of Integer;
   type Matrix is array (1..N, 1..N) of Integer;

end Data;
