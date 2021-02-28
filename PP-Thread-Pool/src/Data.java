import java.util.Arrays;
import java.util.Random;

class Data {
    private int N;

    Data(int N){
        this.N = N;
    }

    int getN(){
        return N;
    }

    // ------------------------------------------
    int[] allOnesVector(){
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = 1;
        }
        return A;
    }

    int[][] allOnesMatrix(){
        int[][] MA = new int[N][N];
        for (int i = 0; i < MA.length; i++) {
            for (int j = 0; j < MA[i].length; j++) {
                MA[i][j] = 1;
            }
        }
        return MA;
    }

    // ------------------------------------------
    int randomNum(){
        Random random = new Random();
        return random.nextInt(10);
    }

    int[] randomVector(){
        int[] A = new int[N];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(10);
        }
        return A;
    }

    int[][] randomMatrix(){
        int[][] MA = new int[N][N];
        Random random = new Random();
        for (int i = 0; i < MA.length; i++) {
            for (int j = 0; j < MA[i].length; j++) {
                MA[i][j] = random.nextInt(10);
            }
        }
        return MA;
    }

    // ------------------------------------------
    void matrixOutput(int[][] MA, String name){
        System.out.println("\tMatrix " + name + ":");
        for (int[] i : MA) {
            System.out.print("\t\t");
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void vectorOutput(int[] A, char name){
        System.out.print("\tVector " + name + ": ");
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void numOutput(int a, char name){
        System.out.print("\tNumber " + name + ": " + a + "\n");
    }

    // ------------------------------------------
    private int maxMatrix(int[][] MA){
        int max = MA[0][0];
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++) {
                if (MA[i][j] > max) {
                    max = MA[i][j];
                }
            }
        }
        return max;
    }

    private int minMatrix(int[][] MA){
        int min = MA[0][0];
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++) {
                if (MA[i][j] < min) {
                    min = MA[i][j];
                }
            }
        }
        return min;
    }

    private int[][] matrixTransp(int[][] MA){
        int buf;
        for (int i = 0; i < MA.length ; i++){
            for (int j = 0; j <=i; j++){
                buf = MA[i][j];
                MA[i][j] = MA[j][i];
                MA[j][i] = buf;
            }
        }
        return MA;
    }

    // ------------------------------------------
    private int[] sortVector(int[] A){
        Arrays.sort(A);
        return A;
    }

    private int[][] sortMatrix(int[][] MA){
        int temp[] = new int[N * N];
        int k = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                temp[k++] = MA[i][j];

        // sort temp[]
        Arrays.sort(temp);

        k = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                MA[i][j] = temp[k++];

        return MA;
    }

    // ------------------------------------------
    private int[] sumVectors(int[] A, int[] B){
        int[] C = new int[N];
        for (int i = 0; i < N ; i++){
            C[i] = A[i] + B[i];
        }
        return C;
    }

    private int[][] sumMatrix(int[][] MA, int[][] MB){
        int[][] MC = new int[N][N];
        for (int i = 0; i < N ; i++)
            for (int j = 0; j < N ; j++)
                MC[i][j] = MA[i][j] + MB[i][j];
        return MC;
    }

    // ------------------------------------------
    private int vectorMult(int[] A, int[] B){
        int c = 0;
        for (int i = 0; i < N ; i++){
            c += A[i] * B[i];
        }
        return c;
    }

    private int[][] matrixMult(int[][] MA, int[][] MB){
        int[][] MC = new int[N][N];
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++){
                for (int k = 0; k < N ; k++){
                    MC[i][j] += MA[i][k] * MB[k][j];
                }
            }
        }
        return MC;
    }

    private int[] vectorMatrixMult(int[] A, int[][] MA){
        int[] B = new int[N];
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++){
                B[i] += A[j] * MA[j][i];
            }
        }
        return B;
    }

    // ------------------------------------------
    // F1 -> D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
    int[] func1(int[] A, int[] B, int[] C, int[][] MA, int[][] ME){
        return sumVectors(sumVectors(sortVector(A), sortVector(B)), vectorMatrixMult(sortVector(C), matrixMult(MA, ME)));
    }

    // F2 -> MF = (MG*MH)*TRANS(MK)
    int[][] func2(int[][] MG, int[][] MH, int[][] MK){
        return matrixMult(matrixMult(MG, MH), matrixTransp(MK));
    }

    // F3 ->  O = (SORT(MP*MR)*S)
    int[] func3(int[] S,int[][] MP, int[][] MR){
        return vectorMatrixMult(S, sortMatrix(matrixMult(MP, MR)));
    }

    // F4 -> e = ((A + B)*(C + D*(MA*ME)))
    int func4(int[] A, int[] B, int[] C, int[] D, int[][] MA, int[][] ME){
        return vectorMult(sumVectors(A, B), sumVectors(C, vectorMatrixMult(D, matrixMult(MA, ME))));
    }

    // F5 -> f = MAX(MG*MK) - MIN(ML + MH)
    int func5(int[][] MG, int[][] MK, int[][] ML, int[][] MH){
        return maxMatrix(matrixMult(MG, MK)) - minMatrix(sumMatrix(ML, MH));
    }
}