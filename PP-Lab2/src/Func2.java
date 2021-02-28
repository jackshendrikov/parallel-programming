import java.util.concurrent.Semaphore;

public class Func2 extends Thread {

    private Data data;
    private Semaphore sem;

    // конструктор класу Func2
    Func2(String name, int priority, Data data, Semaphore sem){
        setName(name);
        setPriority(priority);
        this.data = data;
        this.sem = sem;
    }


    // MF = (MG*MH)*TRANS(MK)
    @Override
    public void run(){
        System.out.println("Func 2 started.");
        try {
            int[][] MG, MH, MK;

            // Generate Input Values
            sleep(50);
            System.out.println("Func 2 is waiting for a permit.");

            sem.acquire();
            sleep(100);

            System.out.println("Func 2 gets a permit.\n");
            MG = data.matrixInput("MG"); MH = data.matrixInput("MH"); MK = data.matrixInput("MK");

            System.out.println("Func 2 releases the permit.");
            sem.release();

            // Calculate The Result
            int[][] result = data.func2(MG, MH, MK);
            sleep(100);

            // Output
            System.out.println("Func 2 is waiting for a permit.");
            sem.acquire();

            System.out.println("Func 2 gets a permit.\n");
            System.out.print("Func 2 result:\n");
            data.matrixOutput(result, "MF");

            System.out.println("Func 2 releases the permit.");
            sem.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Func 2 finished.\n");
    }
}