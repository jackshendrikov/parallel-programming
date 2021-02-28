#pragma once
#include <iostream>
#include <Windows.h>
#include "Data.h"

class F3 {
private:
	int N;
public:
	F3(int N);
	DWORD run();
};