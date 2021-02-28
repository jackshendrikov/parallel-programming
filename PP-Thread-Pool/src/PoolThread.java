/*----------------------------------------------------
  |                    Thread Pools                  |
  ----------------------------------------------------
  |   Author   |    Jack (Yevhenii) Shendrikov       |
  |   Group    |                IO-82                |
  |   Variant  |                 #25                 |
  |    Date    |             17.12.2020              |
  ----------------------------------------------------
  | Function 1 |    e = ((A + B)*(C + D*(MA*ME)))    |
  | Function 1 |    f = MAX(MG*MK) - MIN(ML + MH)    |
  | Function 3 |       O = (SORT(MP*MR)*S)           |
  | Function 4 |      MF = (MG*MH)*TRANS(MK)         |
  | Function 5 |     S = (MO*MP)*V+t*MR*(O+P)        |
  ----------------------------------------------------
*/

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThread{

    private static final int T_MAX = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N;

        System.out.print("!!! Note that if the value of N > 10 -> the result will not be displayed !!!\n" +
                "!!! If you enter N <= 0 - execution will be terminated !!!\n\n" + "Enter N: ");
        N = scanner.nextInt();

        if (N <= 0) throw new ArithmeticException("Restart the program and enter N > 0.");

        System.out.println("\nProgram started!\n");

        Data data = new Data(N);

        Runnable T1 = new Func1("Task 1", data);
        Runnable T2 = new Func2("Task 2", data);
        Runnable T3 = new Func3("Task 3", data);
        Runnable T4 = new Func4("Task 4", data);
        Runnable T5 = new Func5("Task 5", data);

        ExecutorService pool = Executors.newFixedThreadPool(T_MAX);

        pool.execute(T1);
        pool.execute(T2);
        pool.execute(T3);
        pool.execute(T4);
        pool.execute(T5);

        pool.shutdown();

        System.out.println("\nProgram finished!\n");
    }
}