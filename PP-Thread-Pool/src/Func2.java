public class Func2 implements Runnable {

    private Data data;
    private String t_name;

    Func2(String name, Data data){
        t_name = name;
        this.data = data;
    }

    // F2 -> MF = (MG*MH)*TRANS(MK)
    public void run(){
        System.out.println(t_name + " started.");
        try {
            int[][] MG, MH, MK;

            // Input
            Thread.sleep(100);
            MG = data.allOnesMatrix(); MH = data.allOnesMatrix(); MK = data.allOnesMatrix();

            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Input Data -----");
                data.matrixOutput(MG, "MG"); data.matrixOutput(MH, "MH"); data.matrixOutput(MK, "MK");
                System.out.println("-----------------------------\n");
            }

            // Calculation
            int result[][] = data.func2(MG, MH, MK);
            Thread.sleep(100);

            // Output
            if (data.getN() < 10) {
                System.out.println("\n----- " + t_name + " Result Data ----");
                data.matrixOutput(result, "MF");
                System.out.println("-----------------------------\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(t_name + " finished.\n");
    }
}
