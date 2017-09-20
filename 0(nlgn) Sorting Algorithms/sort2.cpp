//
//		This program uses 3 different sorting algorithms (heapsort, merge sort, quick sort) to sort a csv file. Then, it compares
//		the efficiency of each algorithm. +
//****************************************************************************************************
#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <cassert>
using namespace std;
//****************************************************************************************************
struct recordStructure
{
	string state;
	string county;
	int population;
	int rank;
	recordStructure() { state = "unassigned"; county = "unassigned"; population = 0; rank = 0; }

	bool operator==(const recordStructure& s)
	{
		if (population == s.population)return true; return false;
	}
	bool operator>(recordStructure &s)
	{
		if (rank > s.rank)
			return true; return false;
	}
	bool operator>=(recordStructure &s)
	{
		if (rank >= s.rank)
			return true; return false;
	}
	bool operator<(recordStructure &s)
	{
		if (rank < s.rank)
			return true; return false;
	}
	bool operator<=(recordStructure &s)
	{
		if (rank <= s.rank)
			return true; return false;
	}
	friend ostream& operator<< (ostream& out, const recordStructure& s)
	{
		out << s.state << '\t' << s.county << '\t' << s.population << 't' << s.rank << '\t' << endl;
		return out;
	}
};

//****************************************************************************************************
void getData(recordStructure[], int &size);
void copyArray(recordStructure[], recordStructure[], int &size);
void displayArray(recordStructure[], int &size, ofstream &out);
void heapify(recordStructure[], int low, int high, int& heapSortCounter);
void shiftRight(recordStructure[], int low, int high, int& heapSortCounter);
void heapSort(recordStructure[], int &size, int& heapSortCounter);
void quickSort(recordStructure[], int left, int right, int &size, int& quickSortCounter);
void merge(recordStructure[], int low, int middle, int high, int& size, int& mergeSortCounter);
void mergeSort(recordStructure[], int low, int high, int &size, int& mergeSortCounter);
//****************************************************************************************************
int main()
{
	int size = 0;
	int	heapSortCounter = 0;
	int quickSortCounter = 0;
	int mergeSortCounter = 0;
	recordStructure unsortedArray[1000];
	recordStructure sortedArray[1000];
	ofstream out("PopulationReport.txt");

	getData(unsortedArray, size);
	out << "----------------------------------------------\n"
		<< "First and Last 10 Elements After No Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	copyArray(unsortedArray, sortedArray, size);
	displayArray(unsortedArray, size, out); //first time
	out << "----------------------------------------------\n"
		<< "First and Last 10 Elements After Heap Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	heapSort(sortedArray, size, heapSortCounter);
	displayArray(sortedArray, size, out);  //second time
	out << "Heap Sort Iterations: " << heapSortCounter << endl;
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	out << "----------------------------------------------\n"
		<< "First and Last 10 Elements After No Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	copyArray(unsortedArray, sortedArray, size);
	displayArray(unsortedArray, size, out); //first time 
	out << "----------------------------------------------\n"
		<< "First and Last 10 Elements After Quick Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	int left = 0;
	int right = size - 1;
	quickSort(sortedArray, left, right, size, quickSortCounter);
	displayArray(sortedArray, size, out);   //second time
	out << "Quick Sort Iterations: " << quickSortCounter << endl;
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	out << "----------------------------------------------\n"
		<< "First and Last 10 Elements After No Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	copyArray(unsortedArray, sortedArray, size);
	displayArray(unsortedArray, size, out); //first time 
	out << "----------------------------------------------\n"
		<< "First and Last 10 Elements After Merge Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";

	int low = 0, high = size - 1;
	mergeSort(sortedArray, low, high, size, mergeSortCounter);
	displayArray(sortedArray, size, out);   //second time
	out << "Merge Sort Iterations: " << mergeSortCounter << endl;
	out << "----------------------------------------------\n";
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	out << "Amount of iterations the Heap Sort took: " << heapSortCounter;
	out << "\nAmount of iterations the Quick Sort took: " << quickSortCounter;
	out << "\nAmount of iterations the Merge Sort took: " << mergeSortCounter;

	return 0;
}
//****************************************************************************************************
void getData(recordStructure unsortedArray[], int &size)
{
	int i = 0;
	recordStructure record;
	ifstream inFile("Population.csv");
	if (!inFile)
	{
		cout << "Error opening file!\n";
	}
	else
	{
		getline(inFile, record.state, ',');
		getline(inFile, record.county, ',');

		inFile >> record.population;
		inFile.ignore();
		inFile >> record.rank;
		inFile.ignore();
		while (!inFile.eof())
		{
			unsortedArray[i] = record;

			getline(inFile, record.state, ',');
			getline(inFile, record.county, ',');

			inFile >> record.population;
			inFile.ignore();
			inFile >> record.rank;
			inFile.ignore();
			i++;
			size++;
		}
		inFile.close();
	} //end else
}
//****************************************************************************************************
void copyArray(recordStructure unsortedArray[], recordStructure sortedArray[], int &size)
{
	for (int i = 0; i < size; i++)
		sortedArray[i] = unsortedArray[i];
}
//****************************************************************************************************
void displayArray(recordStructure displayArray[], int &size, ofstream &out)
{
	for (int i = 0; i < 10; i++)
	{
		out << right
			<< setw(3) << i << setw(5) << ""
			<< left
			<< setw(19) << displayArray[i].state
			<< setw(22) << displayArray[i].county
			<< right
			<< setw(18) << displayArray[i].population
			<< "\t" << displayArray[i].rank
			<< endl;
	}

	for (int i = size - 10; i < size; i++)
	{
		out << right
			<< setw(3) << i << setw(5) << ""
			<< left
			<< setw(19) << displayArray[i].state
			<< setw(22) << displayArray[i].county
			<< right
			<< setw(18) << displayArray[i].population
			<< "\t" << displayArray[i].rank
			<< endl;
	}

}
//****************************************************************************************************
void shiftRight(recordStructure sortedArray[], int low, int high, int& heapSortCounter)
{
	int root = low;
	while ((root * 2) + 1 <= high)
	{
		heapSortCounter++;
		int leftChild = (root * 2) + 1;
		int rightChild = leftChild + 1;
		int swapIdx = root;
		/*Check if root is less than left child*/
		if (sortedArray[swapIdx] < sortedArray[leftChild])
		{
			swapIdx = leftChild;
		}
		/*If right child exists check if it is less than current root*/
		if ((rightChild <= high) && (sortedArray[swapIdx] < sortedArray[rightChild]))
		{
			swapIdx = rightChild;
		}
		/*Make the biggest element of root, left and right child the root*/
		if (swapIdx != root)
		{
			recordStructure tmp = sortedArray[root];
			sortedArray[root] = sortedArray[swapIdx];
			sortedArray[swapIdx] = tmp;
			/*Keep shifting right and ensure that swapIdx satisfies
			heap property aka left and right child of it is smaller than
			itself*/
			root = swapIdx;
		}
		else
		{
			break;
		}
	}
	return;
}
//****************************************************************************************************
void heapify(recordStructure sortedArray[], int low, int high, int& heapSortCounter)
{
	/*Start with middle element. Middle element is chosen in
	such a way that the last element of array is either its
	left child or right child*/
	int midIdx = (high - low - 1) / 2;
	while (midIdx >= 0)
	{
		shiftRight(sortedArray, midIdx, high, heapSortCounter);
		--midIdx;
	}
	return;
}
//****************************************************************************************************
void heapSort(recordStructure sortedArray[], int &size, int& heapSortCounter)
{
	//assert(sortedArray);
	//assert(size > 0);
	/*This will put max element in the index 0*/
	heapify(sortedArray, 0, size - 1, heapSortCounter); //why can this accept 3 arguments??
	int high = size - 1;
	while (high > 0)
	{
		/*Swap max element with high index in the array*/
		recordStructure tmp = sortedArray[high];
		sortedArray[high] = sortedArray[0];
		sortedArray[0] = tmp;
		--high;
		/*Ensure heap property on remaining elements*/
		shiftRight(sortedArray, 0, high, heapSortCounter);
	}
	return;
}
//****************************************************************************************************
void quickSort(recordStructure sortedArray[], int left, int right, int& size, int& quickSortCounter)
{
	int i = left, j = right; // i = [0].rank | j = [size-1].rank
	recordStructure tmp;
	recordStructure pivot = sortedArray[(left + right) / 2];

	while (i <= j) //step 1: partition
	{
		while (sortedArray[i] < pivot)
		{
			i++;
			quickSortCounter++;
		}
		while (sortedArray[j] > pivot)
		{
			j--;
			quickSortCounter++;
		}
		if (i <= j) //step 2: sort
		{
			tmp = sortedArray[i];
			sortedArray[i] = sortedArray[j];
			sortedArray[j] = tmp;
			i++;
			j--;
		}
	}; //why is this semicoloned???

	/* recursion */
	if (left < j)
		quickSort(sortedArray, left, j, size, quickSortCounter);
	if (i < right)
		quickSort(sortedArray, i, right, size, quickSortCounter);

	return;
}
//****************************************************************************************************
void merge(recordStructure sortedArray[], int low, int middle, int high, int& size, int& mergeSortCounter)
{
	recordStructure *tmp = new recordStructure[high - low + 1];
	int i = low;
	int j = middle + 1;
	int k = 0;
	while ((i <= middle) && (j <= high))
	{
		mergeSortCounter++;
		if (sortedArray[i] < sortedArray[j])
			tmp[k++] = sortedArray[i++];
		else
			tmp[k++] = sortedArray[j++];
	}
	if (i <= middle)
	{
		while (i <= middle)
		{
			mergeSortCounter++;
			tmp[k++] = sortedArray[i++];
		}
	}
	if (j <= high)
	{
		while (j <= high)
		{
			mergeSortCounter++;
			tmp[k++] = sortedArray[j++];
		}
	}
	for (k = low; k <= high; ++k)
	{
		sortedArray[k] = tmp[k - low];
		mergeSortCounter++;
	}
	delete[] tmp;
	return;
}
//****************************************************************************************************
void mergeSort(recordStructure sortedArray[], int low, int high, int &size, int& mergeSortCounter)
{
	assert(sortedArray);
	if (low < high)
	{
		int middle = (high + low) / 2;
		mergeSort(sortedArray, low, middle, size, mergeSortCounter);
		mergeSort(sortedArray, middle + 1, high, size, mergeSortCounter);
		merge(sortedArray, low, middle, high, size, mergeSortCounter);
	}
	return;
}
//****************************************************************************************************


