#include "Data.h"
#include <iostream>

Data::Data(int N)
{
	this->N = N;
}


// ------------------- Fill Matrix/Vector With Specific Number -------------------
vector<vector<int>> Data::FillMatrixWithNumber(int number)
{
	vector<vector<int>> MA(N, vector <int>(N));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			MA[i][j] = number;
		}
	}
	return MA;
}

vector<int> Data::FillVectorWithNumber(int number)
{
	std::vector<int> A(N);
	for (int i = 0; i < N; i++)
	{
		A[i] = number;
	}
	return A;
}


// ---------- Data Entry Handler For Matrices, Vectors And Numbers ---------
vector<vector<int>> Data::MatrixInput(string name)
{
	cout << "Enter the " << N * N << " elements of the Matrix " << name << ":" << endl;
	vector<vector<int>> MA(N, vector <int>(N));

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cout << name << "[" << i << "][" << j << "] = ";
			cin >> MA[i][j];
		}
	}
	return MA;
}

vector<int> Data::VectorInput(char name)
{
	cout << "Enter the " << N << " elements of the Vector " << name << ":" << endl;
	vector<int> A(N);

	for (int i = 0; i < N; i++)
	{
		cout << name << "[" << i << "] = ";
		cin >> A[i];
	}
	return A;
}

int Data::NumInput(char name)
{
	int a;
	cout << "Enter number " << name << " = ";
	cin >> a;
	return a;
}


// ------------- Print Matrix, Vector And Number Into Console --------------
void Data::MatrixOutput(vector<vector<int>> MA, string name)
{
	cout << "\tMatrix " << name << ":" << endl;
	for (int i = 0; i < N; i++)
	{
		cout << "\t\t";
		for (int j = 0; j < N; j++)
		{
			cout << MA[i][j] << " ";
		}
		cout << endl;
	}
}

void Data::VectorOutput(vector<int> A, char name)
{
	cout << "\tVector " << name << ": ";
	for (int i = 0; i < N; i++)
	{
		cout << A[i] << " ";
	}
	cout << endl;
}

void Data::NumOutput(int a, char name)
{
	cout << "\tNumber " << name << ": " << a << "\n";
}


// Transposing Matrix
vector<vector<int>> Data::MatrixTransp(vector<vector<int>> MA)
{
	int buf;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			buf = MA[i][j];
			MA[i][j] = MA[j][i];
			MA[j][i] = buf;
		}
	}
	return MA;
}

// Multiply 2 Matrices
vector<vector<int>> Data::MatrixMult(vector<vector<int>> MA, vector<vector<int>> MB)
{
	vector<vector<int>> MC(N, vector <int>(N));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			for (int k = 0; k < N; k++)
			{
				MC[i][j] += MA[i][k] * MB[k][j];
			}
		}
	}
	return MC;
}


// Multiply Matrix And Vector
vector<int> Data::VectorMatrixMult(vector<int> A, vector<vector<int>> MA)
{
	vector<int> B(N);
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			B[i] += A[j] * MA[i][j];
		}
	}
	return B;
}

// Calculates Sum Of 2 Vectors
vector<int> Data::SumVectors(vector<int> A, vector<int> B)
{
	vector<int> C(N);
	for (int i = 0; i < N; i++)
	{
		C[i] = A[i] + B[i];
	}
	return C;
}

// Multiply Integer And Matrix
vector<int> Data::IntVectorMult(int a, vector<int> A)
{
	vector<int> B(N);
	for (int i = 0; i < N; i++)
	{
		B[i] = a * A[i];
	}
	return B;
}

// Sort Vector
vector<int> Data::SortVector(vector<int> A)
{
	sort(A.begin(), A.end());
	return A;
}


// F1 -> D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
vector<int> Data::Func1(vector<int> A, vector<int> B, vector<int> C, vector<vector<int>> MA, vector<vector<int>> ME)
{
	return SumVectors(SumVectors(SortVector(A), SortVector(B)), VectorMatrixMult(SortVector(C), MatrixMult(MA, ME)));
}

// F2 -> MF = (MG*MH)*TRANS(MK)
vector<vector<int>> Data::Func2(vector<vector<int>> MG, vector<vector<int>> MH, vector<vector<int>> MK)
{
	return MatrixMult(MatrixMult(MG, MH), MatrixTransp(MK));
}

// F3 -> S = (MO*MP)*V+t*MR*(O+P)
vector<int> Data::Func3(int t, vector<int> V, vector<int> O, vector<int> P, vector<vector<int>> MO, vector<vector<int>> MP, vector<vector<int>> MR)
{
	return SumVectors((VectorMatrixMult(V, MatrixMult(MO, MP))), IntVectorMult(t, VectorMatrixMult(SumVectors(O, P), MR)));
}
