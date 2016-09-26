//****************************************************************************************************
//
//		File:					timeComplexities.cpp
//
//		Student:				Chris Stahle
//
//		Assignment:	 			Program  # 1
//
//		Course Name:			Data Structures II
//
//		Course Number:			COSC 3100 - 01
//
//		Due:					March 22, 2016
//
//
//		This program compares the time complexities of several algorithms by simply implementing a 
//		counter in examples of n = 30 & n = 1000.
//****************************************************************************************************
#include <iostream>
#include <iomanip>
using namespace std;
//****************************************************************************************************
void O1(int n, int counter);
void On(int n, int counter);
void On2(int n, int counter);
void On3(int n, int counter);
void Olog2n(int n, int counter);
void Onlog2n(int n, int counter);
//****************************************************************************************************
int main()
{
	int n = 30;
	int counter = 0;

	cout << "\t\tn=30\t\tn=1000\n";

	O1(n, counter);
	On(n, counter);
	On2(n, counter);
	On3(n, counter);
	Olog2n(n, counter);
	Onlog2n(n, counter);

	return 0;
}
//****************************************************************************************************
void O1(int n, int counter)
{
	cout << "O(1)\t\t";

	if (n > 0)
		counter++;

	cout << counter << "\t\t";

	n = 1000;
	counter = 0;

	if (n > 0)
		counter++;

	cout << counter << endl; 
}
//****************************************************************************************************
void On(int n, int counter)
{
	cout << "O(n)\t\t";

	for (int i = 0; i < n; i++)
		counter++;

	cout <<counter << "\t\t";

	n = 1000;
	counter = 0;

	for (int i = 0; i < n; i++)
		counter++; 

	cout << counter << endl;
}

//****************************************************************************************************
void On2(int n, int counter)
{
	cout << "O(n2)\t\t";

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			counter++;
	cout << counter << "\t\t";

	n = 1000;
	counter = 0;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			counter++;
	cout << counter << endl;
}
//****************************************************************************************************
void On3(int n, int counter)
{
	cout << "O(n3)\t\t";

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			for (int k = 0; k < n; k++)
				counter++;
	cout << counter << "\t\t";

	n = 1000;
	counter = 0;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			for (int k = 0; k < n; k++)
				counter++;
	cout << counter << endl;
}
//****************************************************************************************************
void Olog2n(int n, int counter)
{
	cout << "O(log2n)\t";

	for (int i = n; i > 0; i /= 2)
		counter++;
	cout << counter << "\t\t";

	n = 1000;
	counter = 0;

	for (int i = n; i > 0; i /= 2)
		counter++;
	cout << counter << endl;
}
//****************************************************************************************************
void Onlog2n(int n, int counter)
{
	cout << "O(nlog2n\t";

	for (int i = 0; i < n; i++)
		for (int j = n; j > 0; j /= 2)
			counter++;
	cout << counter << "\t\t";

	n = 1000;
	counter = 0;

	for (int i = 0; i < n; i++)
		for (int j = n; j > 0; j /= 2)
			counter++;
	cout << counter << endl;
}
//****************************************************************************************************