import java.util.concurrent.Semaphore;

public class Func3 extends Thread {

    private Data data;
    private Semaphore sem;

    // конструктор класу Func3
    Func3(String name, int priority, Data data, Semaphore sem){
        setName(name);
        setPriority(priority);
        this.data = data;
        this.sem = sem;
    }

    // S = (MO*MP)*V+t*MR*(O+P)
    @Override
    public void run() {
        System.out.println("Func 3 started.");
        try {
            int t;
            int[] V, O, P;
            int[][] MO, MP, MR;

            // Generate Input Values

            sleep(50);
            System.out.println("Func 3 is waiting for a permit.");

            sem.acquire();
            sleep(100);

            System.out.println("Func 3 gets a permit.\n");
            t = data.numInput('t');
            V = data.vectorInput('V'); O = data.vectorInput('O'); P = data.vectorInput('P');
            MO = data.matrixInput("MO"); MP = data.matrixInput("MP"); MR = data.matrixInput("MR");

            System.out.println("Func 3 releases the permit.");
            sem.release();

            // Calculate The Result
            int[] result = data.func3(t, V, O, P, MO, MP, MR);
            sleep(100);

            // Output
            System.out.println("Func 3 is waiting for a permit.");
            sem.acquire();

            System.out.println("Func 3 gets a permit.\n");
            System.out.print("Func 3 result:\n");
            data.vectorOutput(result, 'S');

            System.out.println("Func 3 releases the permit.");
            sem.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Func 3 finished.\n");
    }
}