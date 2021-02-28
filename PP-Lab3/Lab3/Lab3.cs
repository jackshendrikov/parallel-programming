/*-----------------------------------------------------
 |                      Labwork #2                    |
 ------------------------------------------------------
 |  Author  |       Jack (Yevhenii) Shendrikov        |
 |  Group   |                IO-82                    |
 |  Variant |                 #25                     |
 |  Date    |             01.10.2020                  |
 ------------------------------------------------------
 | Function 1 |  D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)  |
 | Function 2 |       MF = (MG*MH)*TRANS(MK)          |
 | Function 3 |      S = (MO*MP)*V+t*MR*(O+P)         |
 ------------------------------------------------------
*/

using System;
using System.Threading;

namespace Lab3 {

    class Lab3 {
        public static Semaphore sem = new Semaphore(1, 1);
        public static int N;

        public static void Main(string[] args) {
            lock (new Lab3())
            {
                //---------------------------- Input Handler ---------------------------
                // header
                Console.Write("----------------------------------------------------\n" +
                                  "| Function 1 | D = SORT(A)+SORT(B)+SORT(C)*(MA*ME) |\n" +
                                  "| Function 2 |      MF = (MG*MH)*TRANS(MK)         |\n" +
                                  "| Function 3 |     S = (MO*MP)*V+t*MR*(O+P)        |\n" +
                                  "----------------------------------------------------\n\n" +
                "!!! Note that if the value of N > 10 -> the result will not be displayed !!!\n" +
                "!!! If you enter N <= 0 - execution will be terminated !!!\n\n" + "Enter N: ");

                // check for int value of N, else N = 3
                try
                {
                    N = Convert.ToInt32(Console.ReadLine());
                }
                catch (FormatException)
                {
                    Console.WriteLine("\n!!! You should enter data of type int, N will be taken as 3 !!!\n");
                    N = 3;
                }

                // check for positive value of N
                if (N <= 0) throw new ArithmeticException("Restart the program and enter N > 0.");

                // if N > 10 - input from the keyboard denied
                if (N > 10)
                {
                    throw new ArgumentException("If you want to enter a value from the keyboard - enter N <= 10.");
                }

                Console.WriteLine("\n!!! Enter All Values From The Keyboard !!!");


                //------------------------- Main Body ----------------------------------
                Console.WriteLine("\nLab3 started!\n");

                var T1 = new Thread(new F1().Run);
                var T2 = new Thread(new F2().Run);
                var T3 = new Thread(new F3().Run);

                T1.Priority = ThreadPriority.Normal;
                T2.Priority = ThreadPriority.Lowest;
                T3.Priority = ThreadPriority.Highest;


                T1.Start();
                T2.Start();
                T3.Start();

                T1.Join();
                T2.Join();
                T3.Join();

                Thread.Sleep(100);
                Console.WriteLine("Lab 3 finished.\n");
                Console.Write("Press any key to end the program...");
                Console.ReadKey();
            }
        }
    }       
}