#pragma once
#include <random>
#include <ctime>
#include <string>
using namespace std;

class Data {
private:
	int N;

public:
	Data(int N);
	
	// ------------------- Fill Matrix/Vector With Specific Number -------------------
	vector<vector<int>> FillMatrixWithNumber(int number);
	vector<int> FillVectorWithNumber(int number);
	
	// ---------- Data Entry Handler For Matrices, Vectors And Numbers ---------
	vector<vector<int>> MatrixInput(string name);
	vector<int> VectorInput(char name);
	int NumInput(char name);

	// ------------- Print Matrix, Vector And Number Into Console --------------
	void MatrixOutput(vector<vector<int>> MA, string name);
	void VectorOutput(vector<int> A, char name);
	void NumOutput(int a, char name);


	// Transposing Matrix
	vector<vector<int>> MatrixTransp(vector<vector<int>> MA);

	// Multiply 2 Matrices
	vector<vector<int>> MatrixMult(vector<vector<int>> MA, vector<vector<int>> MB);


	// Multiply Matrix And Vector
	vector<int> VectorMatrixMult(vector<int> A, vector<vector<int>> MA);

	// Calculates Sum Of 2 Vectors
	vector<int> SumVectors(vector<int> A, vector<int> B);

	// Multiply Integer And Matrix
	vector<int> IntVectorMult(int a, vector<int> A);

	// Sort Vector
	vector<int> SortVector(vector<int> A);


	// F1 -> D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)
	vector<int> Func1(vector<int> A, vector<int> B, vector<int> C, vector<vector<int>> MA, vector<vector<int>> ME);
	
	// F2 -> MF = (MG*MH)*TRANS(MK)
	vector<vector<int>> Func2(vector<vector<int>> MG, vector<vector<int>> MH, vector<vector<int>> MK);
	
	// F3 -> S = (MO*MP)*V+t*MR*(O+P)
	vector<int> Func3(int t, vector<int> V, vector<int> O, vector<int> P, vector<vector<int>> MO, vector<vector<int>> MP, vector<vector<int>> MR);

};
