/*----------------------------------------------------
  |                    Labwork #2                    |
  ----------------------------------------------------
  |   Author   |    Jack (Yevhenii) Shendrikov       |
  |   Group    |                IO-82                |
  |   Variant  |                 #25                 |
  |    Date    |             18.09.2020              |
  ----------------------------------------------------
  | Function 1 | D = SORT(A)+SORT(B)+SORT(C)*(MA*ME) |
  | Function 2 |      MF = (MG*MH)*TRANS(MK)         |
  | Function 3 |     S = (MO*MP)*V+t*MR*(O+P)        |
  ----------------------------------------------------
*/

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Lab2 extends Thread{

    @Override
    public void run(){
        setName("Lab2");
        Scanner scanner = new Scanner(System.in);
        int N;

        //------------------------------------- Input Handler -------------------------------------
        // header
        System.out.print("----------------------------------------------------\n" +
                "| Function 1 | D = SORT(A)+SORT(B)+SORT(C)*(MA*ME) |\n" +
                "| Function 2 |      MF = (MG*MH)*TRANS(MK)         |\n" +
                "| Function 3 |     S = (MO*MP)*V+t*MR*(O+P)        |\n" +
                "----------------------------------------------------\n\n" +
                "!!! Note that if the value of N > 10 -> the result will not be displayed !!!\n" +
                "!!! If you enter N <= 0 - execution will be terminated !!!\n\n" + "Enter N: ");

        // check for int value of N, else N = 3
        if (scanner.hasNextInt()){
            N = scanner.nextInt();
        } else{
            System.out.println("\n!!! You should enter data of type int, N will be taken as 3 !!!\n");
            N = 3;
        }

        // check for positive value of N
        if (N <= 0) throw new ArithmeticException("Restart the program and enter N > 0.");



        if (N > 10){
            throw new IllegalArgumentException("If you want to enter a value from the keyboard - enter N <= 10.");
        }

        System.out.print("\n!!! Enter All Values From The Keyboard !!!\n");

        //------------------------------------- Main Body -------------------------------------
        System.out.println("\nLab2 started!\n");

        Data data = new Data(N);
        Semaphore sem = new Semaphore(1);

        Func1 T1 = new Func1("Func1", Thread.NORM_PRIORITY, data, sem);
        Func2 T2 = new Func2("Func2", Thread.MIN_PRIORITY, data, sem);
        Func3 T3 = new Func3("Func3", Thread.MAX_PRIORITY, data, sem);

        T1.start();
        T2.start();
        T3.start();

        try {
            T1.join();
            T2.join();
            T3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Lab2 finished.");
    }

    public static void main(String[] args){
        new Lab2().start();
    }
}
