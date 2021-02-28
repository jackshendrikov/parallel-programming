#include "F2.h"

F2::F2(int N) {
	this->N = N;
}

DWORD F2::run() {
	cout << "T2 started." << endl;
	Data* data = new Data(N);

	vector<vector<int>> MG, MH, MK;

	// Generate Input Values
	Sleep(100);
	cout << "T2 gets a permit." << endl;

	MG = data->FillMatrixWithNumber(2);
	MH = data->FillMatrixWithNumber(2);
	MK = data->FillMatrixWithNumber(2);

	// Calculate The Result
	vector<vector<int>> result = data->Func2(MG, MH, MK);
	Sleep(100);

	// Output
	if (N <= 10) {
		cout << "T2 result:\n";
		data->MatrixOutput(result, "MF");
	}

	cout << "T2 releases the permit." << endl;
	cout << "T2 finished.\n" << endl;

	delete data;

	return 0;
}
