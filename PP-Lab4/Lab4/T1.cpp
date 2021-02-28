#include "T1.h"

T1::T1(int N, HANDLE mutex) {
	this->N = N;
	this->mutex = mutex;
}

DWORD WINAPI T1::startThread(void* param) {
	T1* This = (T1*)param;
	return This->run();
}

DWORD T1::run() {
	cout << "T1 started." << endl;
	Data* data = new Data(N);

	vector<int> A, B, C;
	vector<vector<int>> MA, ME;

	// Generate Input Values
	Sleep(50);
	cout << "T1 is waiting for a permit." << endl;

	WaitForSingleObject(mutex, INFINITE);
	Sleep(100);
	cout << "\nT1 gets a permit.\n" << endl;

	A = data->VectorInput('A');
	B = data->VectorInput('B');
	C = data->VectorInput('C');
	MA = data->MatrixInput("MA");
	ME = data->MatrixInput("ME");

	cout << "\nT1 releases the permit." << endl;
	ReleaseMutex(mutex);
	cout << "\nT1 is waiting for a permit." << endl;

	// Calculate The Result
	vector<int> result = data->Func1(A, B, C, MA, ME);
	Sleep(100);

	// Output
	WaitForSingleObject(mutex, INFINITE);

	cout << "T1 gets a permit.\n" << endl;
	cout << "T1 result:\n";
	data->VectorOutput(result, 'D');

	cout << "T1 releases the permit." << endl;
	ReleaseMutex(mutex);

	cout << "T1 finished.\n" << endl;

	delete data;
	
	return 0;
}
