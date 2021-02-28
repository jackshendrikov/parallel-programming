using System;
using System.Threading;
using static Lab3.Lab3;

namespace Lab3
{
    public class F2
    {
        // MF = (MG*MH)*TRANS(MK)
        public void Run()
        {
            Console.WriteLine("T2 started.");
            Data data = new Data(N);

            int[ , ] MG, MH, MK;

            // Generate Input Values
            Thread.Sleep(50);
            Console.WriteLine("T2 is waiting for a permit.");

            Lab3.sem.WaitOne();
            Thread.Sleep(100);
            Console.WriteLine("\nT2 gets a permit.\n");

            MG = data.MatrixInput("MG"); 
            MH = data.MatrixInput("MH"); 
            MK = data.MatrixInput("MK");
                
            Console.WriteLine("\nT2 releases the permit.");
            Lab3.sem.Release();
            Console.WriteLine("\nT2 is waiting for a permit.");

            // Calculate The Result
            int[ , ] result = data.Func2(MG, MH, MK);
            Thread.Sleep(100);

            // Output
            Lab3.sem.WaitOne();
            
            Console.WriteLine("T2 gets a permit.\n");
            Console.Write("T2 result:\n");
            data.MatrixOutput(result, "MF");

            Console.WriteLine("T2 releases the permit.");
            Lab3.sem.Release();

            Console.WriteLine("T2 finished.\n");
        }
    }

}
