#include "F3.h"

F3::F3(int N) {
	this->N = N;
}

DWORD F3::run() {
	cout << "T3 started." << endl;
	Data* data = new Data(N);

	int t;
	vector<int> V, O, P;
	vector<vector<int>> MO, MP, MR;

	// Generate Input Values
	cout << "T3 gets a permit." << endl;

	t = 3;
	V = data->FillVectorWithNumber(3);
	O = data->FillVectorWithNumber(3);
	P = data->FillVectorWithNumber(3);
	MO = data->FillMatrixWithNumber(3);
	MP = data->FillMatrixWithNumber(3);
	MR = data->FillMatrixWithNumber(3);

	// Calculate The Result
	vector<int> result = data->Func3(t, V, O, P, MO, MP, MR);
	Sleep(100);

	// Output
	if (N <= 10) {
		cout << "T3 result:\n";
		data->VectorOutput(result, 'S');
	}

	cout << "T3 releases the permit." << endl;
	cout << "T3 finished.\n" << endl;

	delete data;

	return 0;
}
