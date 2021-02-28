#pragma once
#include <iostream>
#include <Windows.h>
#include "Data.h"

class T3 {
private:
	int N;
	HANDLE mutex;
public:
	T3(int N, HANDLE mutex);
	static DWORD WINAPI startThread(void* param);
	DWORD run();
};