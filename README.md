# Parallel Programming

Functions `F1`, `F2`, `F3` (same for each thread):

`F1: D = SORT(A)+SORT(B)+SORT(C)*(MA*ME)`

`F2: MF = (MG*MH)*TRANS(MK)`

`F3: S = (MO*MP)*V+t*MR*(O+P) `


<h3 align="center">Lab 1</h3> 
<b>Task:</b> 

1. Develop a program that contains parallel threads using `Ada`, each of which implements the function `F1`, `F2`, `F3` according to the obtained option.
2. The program must consist of a `Data` package and the main program - `Lab1`. The package implements the resources needed to calculate the functions `F1`, `F2`, `F3` through subroutines `Func1`, `Func2`, `Func3`.
3. When creating threads you need:
	* specify the name of the thread;
	* set the priority of the thread;
	* set the size of the thread stack;
	* select and set the process number (core) to perform each thread.
4. In the body of the problem to use the delay operator when performing functions `F1`, `F2`, `F3` with a small delay time.
5. Investigate when running the program:
	* the influence of thread priorities on the task start queue;
	* the influence of the delay operator on the order of threads;
	* Booting the central multi-core processor of a parallel computer system (PCS). Changing the number of cores is set using the Windows Task Manager.


<h3 align="center">Lab 2</h3> 
<b>Task:</b> 

1. Develop a program using `Java`, which contains parallel threads, each of which implements the corresponding function `F1`, `F2`, `F3` according to the obtained option.
2. The program must consist of a `Data` package and the main program -  class `Lab2`. The package implements the resources needed to calculate the functions `F1`, `F2`, `F3` through subroutines `T1`, `T2`, `T3`.
3. Each thread must perform the actions required for parallel calculation of the corresponding function, namely: input of the corresponding data, calculation of the function `F1`, `F2`, `F3`, output of the result.
4. In the body of the problem to use the delay operator when performing functions `F1`, `F2`, `F3` with a small delay time.

In this work, a `semaphores` was used to work with a shared resource.


<h3 align="center">Lab 3</h3> 
<b>Task:</b> 

1. Develop a program using `C#`, which contains parallel threads, each of which implements the corresponding function `F1`, `F2`, `F3` according to the obtained option.
2. The program must consist of a `Data` package and the main program -  class `Lab3`. The package implements the resources needed to calculate the functions `F1`, `F2`, `F3` through subroutines `T1`, `T2`, `T3`.
3. Each thread must perform the actions required for parallel calculation of the corresponding function, namely: input of the corresponding data, calculation of the function `F1`, `F2`, `F3`, output of the result.
4. In the body of the problem to use the delay operator when performing functions `F1`, `F2`, `F3` with a small delay time.

In this work, a `semaphores` was used to work with a shared resource.

<h3 align="center">Lab 4</h3> 
<b>Task:</b> 

1. Develop a program using the tools of the `WinAPI` library, which contains parallel threads, each of which implements the corresponding function `F1`, `F2`, `F3` according to the obtained option.
2. When creating threads you need:
	* specify the name of the thread;
	* set the priority of the thread;
	* set the size of the thread stack;
	* select and set the process number (core) to perform each thread.
3. In the body of the problem to involve the delay operator when performing functions `F1`, `F2`, `F3` with a small delay time.

In this work, a `mutexes` was used to work with a shared resource.


<h3 align="center">Lab 5</h3> 
<b>Task:</b> 

1. Develop a program using `OpenMP` library, which contains parallel threads, each of which implements the corresponding function `F1`, `F2`, `F3` according to the obtained option.
2. The program must consist of a `Data` package and the main program - procedure (class) `Lab6`. The package implements the resources needed to calculate the functions `F1`, `F2`, `F3` through subroutines `T1`, `T2`, `T3`.
3. Each thread must perform the actions required for parallel calculation of the corresponding function, namely: input of the corresponding data, calculation of the function `F1`, `F2`, `F3`, output of the result.
4. In the body of the problem to use the delay operator when performing functions `F1`, `F2`, `F3` with a small delay time.

<h3 align="center">Lab 6</h3> 
<b>Task:</b> 

1. Develop a program using `MPI` library, which contains parallel threads, each of which implements the corresponding function `F1`, `F2`, `F3` according to the obtained option.
2. The program must consist of a `Data` package and the main program - procedure (class) `Lab6`. The package implements the resources needed to calculate the functions `F1`, `F2`, `F3` through subroutines `T1`, `T2`, `T3`.
3. Each thread must perform the actions required for parallel calculation of the corresponding function, namely: input of the corresponding data, calculation of the function `F1`, `F2`, `F3`, output of the result.
4. In the body of the problem to use the delay operator when performing functions `F1`, `F2`, `F3` with a small delay time.

<h3 align="center">Semaphores</h3> 
<b>Task:</b>  

Write your own implementation of a multiple semaphore in `Ada`, show on examples the efficiency and correctness of execution.

<h3 align="center">Thread Pool</h3> 
<b>Task:</b>  

Implement thread pools in `Java`.