using System;
using System.Threading;
using static Lab3.Lab3;

namespace Lab3
{
    public class F3
    {
        // S = (MO*MP)*V+t*MR*(O+P)
        public void Run()
        {
            Console.WriteLine("T3 started.");
            Data data = new Data(N);

            int t;
            int[] V, O, P;
            int[ , ] MO, MP, MR;

            // Generate Input Values
            Thread.Sleep(50);
            Console.WriteLine("T3 is waiting for a permit.");

            Lab3.sem.WaitOne();
            Thread.Sleep(100);
            Console.WriteLine("\nT3 gets a permit.\n");

            t = data.NumInput('t');
            V = data.VectorInput('V'); O = data.VectorInput('O'); P = data.VectorInput('P');
            MO = data.MatrixInput("MO"); MP = data.MatrixInput("MP"); MR = data.MatrixInput("MR");
                
            Console.WriteLine("\nT3 releases the permit.");
            Lab3.sem.Release();
            Console.WriteLine("\nT3 is waiting for a permit.");

            // Calculate The Result
            int[] result = data.Func3(t, V, O, P, MO, MP, MR);
            Thread.Sleep(100);


            // Output
            Lab3.sem.WaitOne();

            Console.WriteLine("T3 gets a permit.\n");
            Console.Write("T3 result:\n");
            data.VectorOutput(result, 'S');

            Console.WriteLine("T3 releases the permit.");
            Lab3.sem.Release();

            Console.WriteLine("T3 finished.\n");
        }
    }

}
