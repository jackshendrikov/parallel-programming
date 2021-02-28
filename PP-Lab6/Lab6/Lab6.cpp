/*-----------------------------------------------------
 |                      Labwork #6                    |
 ------------------------------------------------------
 |  Author  |       Jack (Yevhenii) Shendrikov        |
 |  Group   |                IO-82                    |
 |  Variant |                 #25                     |
 |  Date    |             01.11.2020                  |
 ------------------------------------------------------
 | Function 1 |  D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)  |
 | Function 2 |       MF = (MG*MH)*TRANS(MK)          |
 | Function 3 |      S = (MO*MP)*V+t*MR*(O+P)         |
 ------------------------------------------------------
*/

#include "mpi.h"
#include "F1.h"
#include "F2.h"
#include "F3.h"

int N;

int main(int argc, char* argv[]) {
	//---------------------------- Input Handler ---------------------------
	// header
	printf("----------------------------------------------------\n"
		"| Function 1 | D = SORT(A)+SORT(B)+SORT(C)*(MA*ME) |\n"
		"| Function 2 |      MF = (MG*MH)*TRANS(MK)         |\n"
		"| Function 3 |     S = (MO*MP)*V+t*MR*(O+P)        |\n"
		"----------------------------------------------------\n\n"
		"!!! Note that if the value of N > 10 -> the result will not be displayed !!!\n"
		"!!! If you enter N <= 0 - execution will be terminated !!!\n\n"
		"Enter N: ");
	cin >> N;

	// check for int value of N, else N = 3
	if (cin.fail()) {
		cout << "\n!!! You should enter data of type int, N will be taken as 3 !!!\n" << endl;
		N = 3;
	}

	// check for positive value of N
	if (N <= 0) {
		cout << "Restart the program and enter N > 0." << endl;
		exit(EXIT_FAILURE);
	}

	//------------------------- Main Body ----------------------------------
	MPI_Init(&argc, &argv);
	cout << "\nLab6 started!\n" << endl;
	
	int rank;

	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	
	F1 T1 = F1(N);
	F2 T2 = F2(N);
	F3 T3 = F3(N);
	
	switch (rank) {
	case 0: T1.run();
	case 1: T2.run();
	case 2: T3.run();
	}

	MPI_Barrier(MPI_COMM_WORLD);

	cout << "\nLab6 finished!\n";
	cin.get();
	MPI_Finalize();
}