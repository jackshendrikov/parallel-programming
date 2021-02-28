using System;
using System.Threading;
using static Lab3.Lab3;

namespace Lab3
{
    public class F1
    {
        // D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
        public void Run()
        {
            Console.WriteLine("T1 started.");
            Data data = new Data(N);

            int[] A, B, C;
            int[ , ] MA, ME;
            
            // Generate Input Values
            Thread.Sleep(50);
            Console.WriteLine("T1 is waiting for a permit.");

            Lab3.sem.WaitOne();
            Thread.Sleep(100);
            Console.WriteLine("\nT1 gets a permit.\n");

            A = data.VectorInput('A');
            B = data.VectorInput('B');
            C = data.VectorInput('C');
            MA = data.MatrixInput("MA");
            ME = data.MatrixInput("ME");

            Console.WriteLine("\nT1 releases the permit.");
            Lab3.sem.Release();
            Console.WriteLine("\nT1 is waiting for a permit.");

            // Calculate The Result
            int[] result = data.Func1(A, B, C, MA, ME);
            Thread.Sleep(100);

            // Output
            Lab3.sem.WaitOne();
           
            Console.WriteLine("T1 gets a permit.\n");
            Console.Write("T1 result:\n");
            data.VectorOutput(result, 'D');

            Console.WriteLine("T1 releases the permit.");
            Lab3.sem.Release();

            Console.WriteLine("T1 finished.\n");
            
        }
    }
}