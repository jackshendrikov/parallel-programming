#include "T3.h"

T3::T3(int N, HANDLE mutex) {
	this->N = N;
	this->mutex = mutex;
}

DWORD WINAPI T3::startThread(void* param) {
	T3* This = (T3*)param;
	return This->run();
}

DWORD T3::run() {
	cout << "T3 started." << endl;
	Data* data = new Data(N);
	
	int t;
	vector<int> V, O, P;
	vector<vector<int>> MO, MP, MR;

	// Generate Input Values
	Sleep(50);
	cout << "T3 is waiting for a permit." << endl;

	WaitForSingleObject(mutex, INFINITE);
	Sleep(100);
	cout << "\nT3 gets a permit.\n" << endl;

	t = data->NumInput('t');
	V = data->VectorInput('V');
	O = data->VectorInput('O');
	P = data->VectorInput('P');
	MO = data->MatrixInput("MO");
	MP = data->MatrixInput("MP");
	MR = data->MatrixInput("MR");

	cout << "\nT3 releases the permit." << endl;
	ReleaseMutex(mutex);
	cout << "\nT3 is waiting for a permit." << endl;

	// Calculate The Result
	vector<int> result = data->Func3(t, V, O, P, MO, MP, MR);
	Sleep(100);

	// Output
	WaitForSingleObject(mutex, INFINITE);

	cout << "T3 gets a permit.\n" << endl;
	cout << "T3 result:\n";
	data->VectorOutput(result, 'S');

	cout << "T3 releases the permit." << endl;
	ReleaseMutex(mutex);

	cout << "T3 finished.\n" << endl;

	delete data;

	return 0;
}
