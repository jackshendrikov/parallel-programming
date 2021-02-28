import java.util.concurrent.Semaphore;

public class Func1 extends Thread {

    private Data data;
    private Semaphore sem;

    // конструктор класу Func1
    Func1(String name, int priority, Data data, Semaphore sem){
        setName(name);
        setPriority(priority);
        this.data = data;
        this.sem = sem;
    }

    // D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
    @Override
    public void run(){
        System.out.println("Func 1 started.");
        try {
            int[] A, B, C;
            int[][] MA, ME;

            // Generate Input Values
            sleep(50);
            System.out.println("Func 1 is waiting for a permit.");

            sem.acquire();
            sleep(100);

            System.out.println("Func 1 gets a permit.\n");
            A = data.vectorInput('A'); B = data.vectorInput('B'); C = data.vectorInput('C');
            MA = data.matrixInput("MA"); ME = data.matrixInput("ME");

            System.out.println("Func 1 releases the permit.");
            sem.release();

            // Calculate The Result
            int[] result = data.func1(A, B, C, MA, ME);
            sleep(100);

            // Output
            System.out.println("Func 1 is waiting for a permit.");
            sem.acquire();

            System.out.println("Func 1 gets a permit.\n");
            System.out.print("Func 1 result:\n");
            data.vectorOutput(result, 'D');

            System.out.println("Func 1 releases the permit.");
            sem.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Func 1 finished.\n");
    }
}