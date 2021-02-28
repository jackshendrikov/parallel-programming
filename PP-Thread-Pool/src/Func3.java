public class Func3 implements Runnable {

    private Data data;
    private String t_name;

    Func3(String name, Data data){
        t_name = name;
        this.data = data;
    }

    // O = (SORT(MP*MR)*S)
    public void run(){
        System.out.println(t_name + " started.");
        try {
            int[] S;
            int[][] MP, MR;

            // Input
            Thread.sleep(70);
            S = data.allOnesVector();
            MP = data.allOnesMatrix(); MR = data.allOnesMatrix();

            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Input Data -----");
                data.vectorOutput(S, 'S');
                data.matrixOutput(MP, "MP"); data.matrixOutput(MR, "MR");
                System.out.println("-----------------------------\n");
            }

            // Calculation
            int[] result = data.func3(S, MP, MR);
            Thread. sleep(100);

            // Output
            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Result Data ----");
                data.vectorOutput(result, 'O');
                System.out.println("-----------------------------\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(t_name + " finished.\n");
    }
}