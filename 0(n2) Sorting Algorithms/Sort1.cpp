//
//		This program uses 3 different sorting algorithms(selection, bubble, insertion) to sort a csv file. Then, it compares
//		the efficiency of each algorithm. 
//****************************************************************************************************
#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
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
int insertionSort(recordStructure[], int &size);
int selectionSort(recordStructure[], int &size);
int bubbleSort(recordStructure[], int &size);
//****************************************************************************************************
int main()
{
	int size = 0;
	int	insertionSortCounter = 0;
	int selectionSortCounter = 0;
	int bubbleSortCounter = 0;
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
		<< "First and Last 10 Elements After Insertion Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	insertionSortCounter = insertionSort(sortedArray, size);
	displayArray(sortedArray, size, out);  //second time
	out << "Insertion Sort Iterations: " << insertionSortCounter << endl;
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
		<< "First and Last 10 Elements After Selection Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	selectionSortCounter = selectionSort(sortedArray, size);
	displayArray(sortedArray, size, out);   //second time
	out << "Selection Sort Iterations: " << selectionSortCounter << endl;
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
		<< "First and Last 10 Elements After Bubble Sort\n"
		<< "----------------------------------------------\n"
		<< left
		<< setw(9) << "Index"
		<< setw(19) << "State"
		<< setw(30) << "County"
		<< setw(13) << "Population"
		<< setw(4) << "Rank\n"
		<< "----------------------------------------------\n";
	bubbleSortCounter = bubbleSort(sortedArray, size);
	displayArray(sortedArray, size, out);   //second time
	out << "Bubble Sort Iterations: " << bubbleSortCounter << endl;
	out << "----------------------------------------------\n";
/////////////////////////////////////////////////////////////////////////////////////////////////////
	out << "Amount of iterations the Insertion Sort took: " << insertionSortCounter;
	out << "\nAmount of iterations the Selection Sort took: " << selectionSortCounter;
	out << "\nAmount of iterations the Bubble Sort took: " << bubbleSortCounter;

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
int insertionSort(recordStructure sortedArray[], int &size)
{
	int counter = 0;

	for (int i = 1; i < size; ++i)
	{
		int insert = i;
		while (insert > 0 && sortedArray[insert - 1] > sortedArray[insert])
		{
			counter++;
			recordStructure temp = sortedArray[insert];
			sortedArray[insert] = sortedArray[insert - 1];
			sortedArray[insert - 1] = temp;
			--insert;
		}
	}
	return counter;
}
//****************************************************************************************************
int bubbleSort(recordStructure sortedArray[], int& size)
{
	int counter = 0;

	for (int i = size - 1; i > 0; --i)
	{
		for (int n = 0; n < i; ++n)
		{
			counter++;
			if (sortedArray[n] > sortedArray[n + 1])
			{
				recordStructure temp = sortedArray[n];
				sortedArray[n] = sortedArray[n + 1];
				sortedArray[n + 1] = temp;
			}
		}
	}
	return counter;
}
//****************************************************************************************************
int selectionSort(recordStructure sortedArray[], int& size)
{
	int counter = 0;

	for (int i = 0; i < size - 1; ++i)
	{
		int smallest = i;

		for (int j = i + 1; j < size; ++j)
		{
			counter++;
			if (sortedArray[smallest] > sortedArray[j])
			{
				smallest = j;
			}
		}
		recordStructure temp = sortedArray[smallest];
		sortedArray[smallest] = sortedArray[i];
		sortedArray[i] = temp;
	}
	return counter;
}
//****************************************************************************************************
