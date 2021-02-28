public class Func1 implements Runnable {

    private Data data;
    private String t_name;

    Func1(String name, Data data){
        t_name = name;
        this.data = data;
    }

    // F1 -> D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
    public void run(){
        System.out.println(t_name + " started.");

        try {
            int[] A, B, C;
            int[][] MA, ME;

            // Input
            A = data.allOnesVector(); B = data.allOnesVector(); C = data.allOnesVector();
            MA = data.allOnesMatrix(); ME = data.allOnesMatrix();

            Thread.sleep(50);
            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Input Data -----");
                data.vectorOutput(A, 'A'); data.vectorOutput(A, 'B'); data.vectorOutput(A, 'C');
                data.matrixOutput(MA, "MA"); data.matrixOutput(MA, "ME");
                System.out.println("-----------------------------\n");
            }

            // Calculation
            int[] result = data.func1(A, B, C, MA, ME);
            Thread.sleep(100);

            // Output
            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Result Data ----");
                data.vectorOutput(result, 'D');
                System.out.println("-----------------------------\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(t_name + " finished.\n");
    }
}