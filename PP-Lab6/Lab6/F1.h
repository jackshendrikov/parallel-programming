#pragma once
#include <iostream>
#include <Windows.h>
#include "Data.h"

class F1 {
private:
	int N;
public:
	F1(int N);
	DWORD run();
};
