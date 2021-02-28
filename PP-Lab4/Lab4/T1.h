#pragma once
#include <iostream>
#include <Windows.h>
#include "Data.h"

class T1 {
private:
	int N;
	HANDLE mutex;
public:
	T1(int N, HANDLE mutex);
	static DWORD WINAPI startThread(void* param);
	DWORD run();
};
