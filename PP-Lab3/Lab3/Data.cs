using System;
using static Lab3.Lab3;

namespace Lab3
{
    class Data
    {
        private int N;

        public Data(int N)
        {
            this.N = N;
        }


        // ------------------- Fill Matrix/Vector With Specific Number -------------------
        public int [ , ] FillMatrixWithNumber(int number)
        {
            int [ , ] MA = new int[N, N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    MA[i, j] = number;
                }
            }
            return MA;
        }

        public int[] FillVectorWithNumber(int number)
        {
            int[] A = new int[N];
            for (int i = 0; i < N; i++)
            {
                A[i] = number;
            }
            return A;
        }


        // ---------- Data Entry Handler For Matrices, Vectors And Numbers ---------
        public int [ , ] MatrixInput(String name)
        {
            Console.WriteLine("Enter the " + N * N + " elements of the Matrix " + name + ":");
            int[ , ] MA = new int[N, N];

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    Console.Write(name + "[" + i + "][" + j + "] = ");
                    MA[i, j] = Convert.ToInt32(Console.ReadLine());
                }
            }
            return MA;
        }

        public int[] VectorInput(char name)
        {
            Console.WriteLine("Enter the " + N + " elements of the Vector " + name + ":");
            int[] input = new int[N];

            for (int i = 0; i < N; i++)
            {
                Console.Write(name + "[" + i + "] = ");
                input[i] = Convert.ToInt32(Console.ReadLine());
            }
            return input;
        }

        public int NumInput(char name)
        {
            Console.Write("Enter number " + name + " = ");
            return Convert.ToInt32(Console.ReadLine());
        }


        // ------------- Print Matrix, Vector And Number Into Console --------------
        public void MatrixOutput(int[ , ] MA, String name)
        {
            Console.WriteLine("\tMatrix " + name + ":");
            for (int i = 0; i < N; i++)
            {
                Console.Write("\t\t");
                for (int j = 0; j < N; j++)
                {
                    Console.Write(string.Format("{0} ", MA[i, j]));
                }
                Console.WriteLine();
            }
        }

        public void VectorOutput(int[] A, char name)
        {
            Console.Write("\tVector " + name + ": ");
            for (int i = 0; i < N; i++)
            {
                Console.Write(string.Format("{0} ", A[i]));
            }
            Console.WriteLine();
        }

        public void NumOutput(int a, char name)
        {
            Console.Write("\tNumber " + name + ": " + a + "\n");
        }


        // Sort Vector
        public int[] SortVector(int[] A)
        {
            Array.Sort(A);
            return A;
        }


        // Calculates Sum Of 2 Vectors
        public int[] SumVectors(int[] A, int[] B)
        {
            int[] C = new int[N];
            for (int i = 0; i < N; i++)
            {
                C[i] = A[i] + B[i];
            }
            return C;
        }


        // Transposing Matrix
        public int[ , ] MatrixTransp(int[ , ] MA)
        {
            int buf;
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    buf = MA[i, j];
                    MA[i, j] = MA[j, i];
                    MA[j, i] = buf;
                }
            }
            return MA;
        }


        // Multiply 2 Matrices
        public int[ , ] MatrixMult(int[ , ] MA, int[ , ] MB)
        {
            int[ , ] MC = new int[N, N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    for (int k = 0; k < N; k++)
                    {
                        MC[i, j] += MA[i, k] * MB[k, j];
                    }
                }
            }
            return MC;
        }


        // Multiply Matrix And Vector
        public int[] VectorMatrixMult(int[] A, int[ , ] MA)
        {
            int[] B = new int[N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    B[i] += A[j] * MA[i , j];
                }
            }
            return B;
        }


        // Multiply Integer And Matrix
        public int[] IntVectorMult(int a, int[] A)
        {
            int[] B = new int[N];
            for (int i = 0; i < N; i++)
            {
                B[i] = a * A[i];
            }
            return B;
        }


        // F1 -> D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
        public int[] Func1(int[] A, int[] B, int[] C, int[ , ] MA, int[ , ] ME)
        {
            return SumVectors(SumVectors(SortVector(A), SortVector(B)),
                              VectorMatrixMult(SortVector(C), MatrixMult(MA, ME)));
        }

        // F2 -> MF = (MG*MH)*TRANS(MK)
        public int[ , ] Func2(int[ , ] MG, int[ , ] MH, int[ , ] MK)
        {
            return MatrixMult(MatrixMult(MG, MH), MatrixTransp(MK));
        }

        // F3 -> S = (MO*MP)*V+t*MR*(O+P)
        public int[] Func3(int t, int[] V, int[] O, int[] P, int[ , ] MO, int[ , ] MP, int[ , ] MR)
        {
            return SumVectors((VectorMatrixMult(V, MatrixMult(MO, MP))),
                               IntVectorMult(t, VectorMatrixMult(SumVectors(O, P), MR)));
        }
    }
}
