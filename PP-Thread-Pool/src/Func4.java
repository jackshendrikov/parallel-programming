public class Func4 implements Runnable {

    private Data data;
    private String t_name;

    Func4(String name, Data data){
        t_name = name;
        this.data = data;
    }

    // e = ((A + B)*(C + D*(MA*ME)))
    public void run(){
        System.out.println(t_name + " started.");
        try {
            int[] A, B, C, D;
            int[][] MA, ME;

            // Input
            A = data.allOnesVector(); B = data.allOnesVector(); C = data.allOnesVector(); D = data.allOnesVector();
            MA = data.allOnesMatrix(); ME = data.allOnesMatrix();

            Thread.sleep(30);
            if (data.getN() < 15) {
                System.out.println("\n----- " + t_name + " Input Data -----");
                data.vectorOutput(A, 'A'); data.vectorOutput(A, 'B'); data.vectorOutput(A, 'C'); data.vectorOutput(A, 'D');
                data.matrixOutput(MA, "MA"); data.matrixOutput(MA, "ME");
                System.out.println("-----------------------------\n");
            }

            // Calculation
            int result = data.func4(A, B, C, D, MA, ME);
            Thread.sleep(100);

            // Output
            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Result Data ----");
                data.numOutput(result, 'e');
                System.out.println("-----------------------------\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(t_name + " finished.\n");
    }
}