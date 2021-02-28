/*-----------------------------------------------------
 |                      Labwork #4                    |
 ------------------------------------------------------
 |  Author  |       Jack (Yevhenii) Shendrikov        |
 |  Group   |                IO-82                    |
 |  Variant |                 #25                     |
 |  Date    |             15.10.2020                  |
 ------------------------------------------------------
 | Function 1 |  D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)  |
 | Function 2 |       MF = (MG*MH)*TRANS(MK)          |
 | Function 3 |      S = (MO*MP)*V+t*MR*(O+P)         |
 ------------------------------------------------------
*/

#include "T1.h"
#include "T2.h"
#include "T3.h"

int N;

int main() {
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

	// if N > 10 - input from the keyboard denied
	if (N > 10) {
		cout << "If you want to enter a value from the keyboard - enter N <= 10." << endl;
		exit(EXIT_FAILURE);
	}

	cout << "\n!!! Enter All Values From The Keyboard !!!" << endl;

	//------------------------- Main Body ----------------------------------
	HANDLE mutex = CreateMutex(NULL, FALSE, NULL);
	cout << "\nLab4 started!\n" << endl;
	
	DWORD TidA, TidB, TidC;
	HANDLE hThread[3];
	
	T1* F1 = new T1(N, mutex);
	T2* F2 = new T2(N, mutex);
	T3* F3 = new T3(N, mutex);
	
	hThread[0] = CreateThread(NULL, 20000, T1::startThread, F1, 0, &TidA);
	hThread[1] = CreateThread(NULL, 0, T2::startThread, F2, CREATE_SUSPENDED, &TidB);
	hThread[2] = CreateThread(NULL, 0, T3::startThread, F3, 0, &TidC);
	
	SetThreadPriority(hThread[0], THREAD_PRIORITY_LOWEST);
	SetThreadPriority(hThread[1], THREAD_PRIORITY_NORMAL);
	SetThreadPriority(hThread[2], THREAD_PRIORITY_HIGHEST);

	int core = 8;
	for (int i = 0; i < core; i++)
		SetThreadAffinityMask(hThread[i], 1 << i);

	Sleep(10);

	ResumeThread(hThread[1]);
	
	WaitForMultipleObjects(3, hThread, true, INFINITE);

	for (int i = 0; i < 3; i++) {
		CloseHandle(hThread[i]);
	}
	CloseHandle(mutex);

	cout << "\nLab4 finished!\n";
	cin.get();
}
