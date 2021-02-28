public class Func5 implements Runnable {

    private Data data;
    private String t_name;

    Func5(String name, Data data){
        t_name = name;
        this.data = data;
    }

    // f = MAX(MG*MK) - MIN(ML + MH)
    public void run(){
        System.out.println(t_name + " started.");
        try {
            int[][] MG, MK, ML, MH;

            // Input
            Thread.sleep(60);
            MG = data.allOnesMatrix(); MK = data.allOnesMatrix();
            ML = data.allOnesMatrix(); MH = data.allOnesMatrix();

            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Input Data -----");
                data.matrixOutput(MG, "MG"); data.matrixOutput(MK, "MK");
                data.matrixOutput(ML, "ML"); data.matrixOutput(MH, "MH");
                System.out.println("-----------------------------\n");
            }

            // Calculation
            int result = data.func5(MG, MK, ML, MH);
            Thread.sleep(100);

            // Output
            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Result Data ----");
                data.numOutput(result, 'f');
                System.out.println("-----------------------------\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(t_name + " finished.\n");
    }
}