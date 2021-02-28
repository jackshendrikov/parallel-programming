#include "F1.h"

F1::F1(int N) {
	this->N = N;
}

DWORD F1::run() {
	cout << "T1 started." << endl;
	Data* data = new Data(N);

	vector<int> A, B, C;
	vector<vector<int>> MA, ME;

	// Generate Input Values
	Sleep(50);
	cout << "T1 gets a permit." << endl;

	A = data->FillVectorWithNumber(1);
	B = data->FillVectorWithNumber(1);
	C = data->FillVectorWithNumber(1);
	MA = data->FillMatrixWithNumber(1);
	ME = data->FillMatrixWithNumber(1);

	// Calculate The Result
	vector<int> result = data->Func1(A, B, C, MA, ME);
	Sleep(100);

	// Output
	if (N <= 10) {
		cout << "T1 result:\n";
		data->VectorOutput(result, 'D');
	}

	cout << "T1 releases the permit." << endl;
	cout << "T1 finished.\n" << endl;

	delete data;

	return 0;
}
