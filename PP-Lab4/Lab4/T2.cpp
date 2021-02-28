#include "T2.h"

T2::T2(int N, HANDLE mutex) {
	this->N = N;
	this->mutex = mutex;
}

DWORD WINAPI T2::startThread(void* param) {
	T2* This = (T2*)param;
	return This->run();
}

DWORD T2::run() {
	cout << "T2 started." << endl;
	Data* data = new Data(N);

	vector<vector<int>> MG, MH, MK;

	// Generate Input Values
	Sleep(50);
	cout << "T2 is waiting for a permit." << endl;

	WaitForSingleObject(mutex, INFINITE);
	Sleep(100);
	cout << "\nT2 gets a permit.\n" << endl;

	MG = data->MatrixInput("MG");
	MH = data->MatrixInput("MH");
	MK = data->MatrixInput("MK");

	cout << "\nT2 releases the permit." << endl;
	ReleaseMutex(mutex);
	cout << "\nT2 is waiting for a permit." << endl;

	// Calculate The Result
	vector<vector<int>> result = data->Func2(MG, MH, MK);
	Sleep(100);

	// Output
	WaitForSingleObject(mutex, INFINITE);

	cout << "T2 gets a permit.\n" << endl;
	cout << "T2 result:\n";
	data->MatrixOutput(result, "MF");

	cout << "T2 releases the permit." << endl;
	ReleaseMutex(mutex);

	cout << "T2 finished.\n" << endl;

	delete data;

	return 0;
}
