#pragma once
#include <omp.h>
#include <iostream>
#include <Windows.h>
#include "Data.h"

class F2 {
private:
	int N;
public:
	F2(int N);
	DWORD run();
};