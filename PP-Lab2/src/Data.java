import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Data {
    private int N;

    Data(int N){
        this.N = N;
    }

    int getN(){
        return N;
    }

    // -------------------- Create All-Ones Matrix And Vector --------------------
    int[][] allOnesMatrix(){
        int[][] MA = new int[N][N];
        for (int i = 0; i < MA.length; i++) {
            for (int j = 0; j < MA[i].length; j++) {
                MA[i][j] = 1;
            }
        }
        return MA;
    }

    int[] allOnesVector(){
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = 1;
        }
        return A;
    }


    // ----------------- Create Random Matrix, Vector And Number -----------------
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

    int[] randomVector(){
        int[] A = new int[N];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(10);
        }
        return A;
    }

    int randomNum(){
        Random random = new Random();
        return random.nextInt(10);
    }


    // ----------- Data Entry Handler For Matrices, Vectors And Numbers -----------
    int[][] matrixInput(String name){
        System.out.println("Enter the " + N*N + " elements of the Matrix " + name + ":");
        int[][] MA = new int[N][N];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < MA.length; i++) {
            for (int j = 0; j < MA[i].length; j++) {
                System.out.print(name + "[" + i + "][" + j + "] = ");
                MA[i][j] = scanner.nextInt();
            }
        }
        return MA;
    }

    int[] vectorInput(char name){
        System.out.println("Enter the " + N + " elements of the Vector " + name + ":");
        int[] input = new int[N];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < input.length; i++) {
            System.out.print(name + "[" + i + "] = ");
            input[i] = scanner.nextInt();
        }
        return input;
    }

    int numInput(char name){
        System.out.print("Enter number " + name + " = ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    // --------------- Print Matrix, Vector And Number Into Console ---------------
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


    // Sort Vector
    private int[] sortVector(int[] A){
        Arrays.sort(A);
        return A;
    }


    // Calculates Sum Of 2 Vectors
    private int[] sumVectors(int[] A, int[] B){
        int[] C = new int[N];
        for (int i = 0; i < N ; i++){
            C[i] = A[i] + B[i];
        }
        return C;
    }


    // Transposing Matrix
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


    // Multiply 2 Matrices
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


    // Multiply Matrix And Vector
    private int[] vectorMatrixMult(int[] A, int[][] MA){
        int[] B = new int[N];
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < N ; j++){
                B[i] += A[j] * MA[j][i];
            }
        }
        return B;
    }


    // Multiply Integer And Matrix
    private int[] intVectorMult(int a, int[] A) {
        int[] B = new int[N];
        for (int i = 0; i < N ; i++){
            B[i] = a * A[i];
        }
        return B;
    }


    // F1 -> D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
    int[] func1(int[] A, int[] B, int[] C, int[][] MA, int[][] ME){
        return sumVectors(sumVectors(sortVector(A), sortVector(B)),
                vectorMatrixMult(sortVector(C), matrixMult(MA, ME)));
    }

    // F2 -> MF = (MG*MH)*TRANS(MK)
    int[][] func2(int[][] MG, int[][] MH, int[][] MK){
        return matrixMult(matrixMult(MG, MH), matrixTransp(MK));
    }

    // F3 -> S = (MO*MP)*V+t*MR*(O+P)
    int[] func3(int t, int[] V, int[] O, int[] P, int[][] MO, int[][] MP, int[][] MR){
        return sumVectors((vectorMatrixMult(V, matrixMult(MO, MP))),
                intVectorMult(t, vectorMatrixMult(sumVectors(O, P), MR))
        );
    }
}