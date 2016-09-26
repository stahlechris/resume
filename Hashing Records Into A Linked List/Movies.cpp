//****************************************************************************************************
//
//		File:					Movies.cpp
//
//		Student:				Chris Stahle
//
//		Assignment:	 			Program  # 2
//
//		Course Name:			Data Structures II
//
//		Course Number:			COSC 3100 - 01
//
//		Due:					March 29, 2016
//
//
//		This program uses a hash table containing movie data and the collision resolution is to 
//		build linked lists as array elements.
//****************************************************************************************************
#include"HashTable.h"
//#include"List.h"
#include <fstream>
#include <iomanip>
#include <iostream>
#include <string>
using namespace std;
//****************************************************************************************************
struct movieStructure
{
	int MPAC;
	string title;
	movieStructure() { MPAC = 0;title = "Unassigned"; }
	friend ostream& operator<< (ostream& out, const movieStructure& m)
	{
		out << m.MPAC << "-" << m.title;
		return out; //unable to read memory due to m being NULL ? ERR
	}
	bool operator >= (const movieStructure&m)
	{
		if (this->MPAC >= m.MPAC) //test if 'this' is neccessary 
			return true; return false;
	}
	bool operator == (const movieStructure&m)
	{
		if (this->MPAC == m.MPAC) //test if 'this' is neccessary 
			return true; return false;
	}
}; //End structure definition

//****************************************************************************************************
void getData(HashTable<movieStructure>&); 
void findMovies(HashTable<movieStructure>&);
int hf(const movieStructure&);
const int SIZE = 10; //global constant variable SIZE 
//****************************************************************************************************
int main()
{
	HashTable<movieStructure> movieStore(hf, SIZE); 
	getData(movieStore); //load the data
	findMovies(movieStore); //search through data

	return 0;
}
//****************************************************************************************************
int hf(const movieStructure&m)
{
	int index = 0;

	 index = int(0.618033 * m.MPAC) % SIZE; //result casted to an int.
	 return index;
}
//****************************************************************************************************
void getData(HashTable<movieStructure>& mov)
{
	movieStructure movies;
	ifstream inFile("Movies.txt");
	if (!inFile)
	{
		cout << "Error opening file!\n";
		exit(99);
	}
	else
	{
		inFile >> movies.MPAC;
		inFile.ignore();
		getline(inFile, movies.title);
		while (!inFile.eof())
		{
			mov.insert(movies);
			inFile >> movies.MPAC;
			inFile.ignore();
			if (movies.MPAC != 0)
			{
				getline(inFile, movies.title);
			}
		}
		cout << "The number of collisions is "  << numCollisions << endl; 
		inFile.close();
	} //close else
}
//****************************************************************************************************
void findMovies(HashTable<movieStructure>& m)
{
	movieStructure movies;
	int MPAC;
	bool found = false; //assume we haven't found it yet..
	//bool isInList = false; //its not in the list, prove me wrong 

	cout << "Enter an MPAC to locate (0 to end): ";
	cin >> MPAC;
	cout << "-------------------------------------------------------\n";

	while (MPAC != 0) //until they type '0', keep loopin'
	{
		cout << "Will search for " << MPAC << endl;
		movies.MPAC = MPAC;
		found = m.retrieve(movies);
		if (found)
		{
			cout << "Retrieved from hash table " << movies << endl;
		}
		else
			cout << "Could not find " << MPAC << endl;
			cout << "-------------------------------------------------------\n";
			cout << "Enter an MPAC to locate (0 to end): ";
			cin >> MPAC;
			cout << "-------------------------------------------------------\n";
	}
	cout << "The number of collisions is " << numCollisions << endl;
}
//****************************************************************************************************