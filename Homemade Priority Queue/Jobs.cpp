//****************************************************************************************************
//
//		File:					Jobs.cpp
//
//		Student:				Chris Stahle
//
//		Assignment:	 			Program  # 3
//
//		Course Name:			Data Structures II
//
//		Course Number:			COSC 3100 - 01
//
//		Due:					April 12, 2016
//
//
//		This program simulates the operating system function to manage and schedule resource usage,  
//		specifically printers.
//****************************************************************************************************
#include "PriorityQueue.h"
#include <iostream>
#include <fstream>
#include <string>
using namespace std;
//****************************************************************************************************
struct jobStructure
{
	int key;
	int level;
	int numLines;
	string jobName;
	jobStructure() { key = 0; level = 0; numLines = 0; jobName = "Unassigned"; }
	bool operator > (const jobStructure&j)
	{
		if (this->key > j.key)
			return true; return false;
	}
	bool operator>= (const jobStructure&j)
	{
		if (this->key >= j.key)
			return true; return false;
	}
	bool operator<= (const jobStructure&j)
	{
		if (this->key <= j.key)
			return true; return false;
	}
	bool operator == (const jobStructure&j)
	{
		if (this->key == j.key)
			return true; return false;
	}
	friend ostream& operator<< (ostream& out, const jobStructure& j)
	{
		out << j.level << "\t" << j.jobName << "\t" << j.numLines << "\t" << j.key;
		return out;
	}
}; //End structure definition
//****************************************************************************************************
void getData(PriorityQueue<jobStructure>&, jobStructure[], int &size);
void displayData(PriorityQueue<jobStructure>&);
void getPrintData(PriorityQueue<jobStructure>&, jobStructure[], int &size);
//****************************************************************************************************
int main()
{
	int size = 0;
	jobStructure job[11];  //Jobs.csv + PrintActivity.csv
	cout << "------------------------------------------------------------\n"
		 << "Records in the array prior to placing in the Priority Queue:\n"
		 << "------------------------------------------------------------\n"
		 << "Index\tLevel\tName\tLines\tKey\n";

	PriorityQueue<jobStructure> jobList;
	getData(jobList, job, size);
	displayData(jobList);
	cout << "------------------------------------------------------------\n"
		 << "Records processed from the Print Activity file:\n"
		 << "------------------------------------------------------------\n"
		 << "Action\tLevel\tName\tLines\tKey\n";
	//declare second priority queue using overloaded operator, process PrintActivity, then call display again passing it the 2nd PQ
	PriorityQueue<jobStructure> printActivity(job, size);
	getPrintData(printActivity, job, size); //PrintActivity.csv
	displayData(printActivity);
	return 0;
}
//****************************************************************************************************
void getData(PriorityQueue<jobStructure>&j, jobStructure jobArray[], int &size)
{
	int i = 0;  //Earray index
	int PriorityLevel; //holds either 15, 10, 1 
	char switchPriorityLevel;
	jobStructure job;
	ifstream inFile("Jobs.csv");
	if (!inFile)
	{
		cout << "Error opening file!\n";
	}
	else
	{
		inFile >> job.numLines;
		inFile.ignore();
		getline(inFile, job.jobName);
		cout << i << "\t";
		while (!inFile.eof())
		{
			if (job.numLines > 0 && job.numLines < 10000)
				switchPriorityLevel = 'A';
			else if (job.numLines > 10000 && job.numLines < 50000)
				switchPriorityLevel = 'B';
			else
				switchPriorityLevel = 'C';
			switch (switchPriorityLevel)
			{
			case 'A':
				PriorityLevel = 15;
				break;
			case 'B':
				PriorityLevel = 10;
				break;
			case 'C':
				PriorityLevel = 1;
				break;
			default:
				cout << "Invalid case\n";
			} //end switch
			job.level = PriorityLevel;
			job.key = 100000 * PriorityLevel - job.numLines;
			j.enqueue(job); //a job is added to the joblist PriorityQueue
			jobArray[i] = job;
			cout << jobArray[i] << endl;
			i++;
			size++;
			inFile >> job.numLines;
			inFile.ignore();
			getline(inFile, job.jobName);
			if (i < 11) //where 11 is numberOfLines in the file.
				cout << i << "\t";
		}//end while
		inFile.close();
	} //end else
}
//****************************************************************************************************
void displayData(PriorityQueue<jobStructure>& j)
{
	jobStructure job;

	cout << "------------------------------------------------------------\n"
		<< "The Jobs Priority Queue:\n"
		<< "------------------------------------------------------------\n"
		<< "Level\tName\tLines\tKey\n";

	while (!j.isEmpty())
	{
		j.dequeue(job);
		cout << job << endl;
	}
}
//****************************************************************************************************
void getPrintData(PriorityQueue<jobStructure>& j, jobStructure jobArray[], int &size)
{
	int i = 0;
	int PriorityLevel; //holds either 15, 10, 1 
	char switchPriorityLevel;
	char Operation;
	jobStructure job;
	ifstream inFile("PrintActivity.csv");
	if (!inFile)
	{
		cout << "Error opening file!\n";
	}
	else
	{
		inFile >> Operation;
		inFile.ignore();
		inFile >> job.numLines;
		inFile.ignore();
		getline(inFile, job.jobName);
		while (!inFile.eof())
		{
			if (Operation == 'E')
			{
				if (job.numLines > 0 && job.numLines < 10000)
					switchPriorityLevel = 'A';
				else if (job.numLines > 10000 && job.numLines < 50000)
					switchPriorityLevel = 'B';
				else
					switchPriorityLevel = 'C';
				switch (switchPriorityLevel)
				{
				case 'A':
					PriorityLevel = 15;
					break;
				case 'B':
					PriorityLevel = 10;
					break;
				case 'C':
					PriorityLevel = 1;
					break;
				default:
					cout << "Invalid case\n";
				} //end switch
				job.level = PriorityLevel;
				job.key = 100000 * PriorityLevel - job.numLines;
				jobArray[i] = job;
				cout << "Enqueue\t";
				cout << jobArray[i] << endl;
				i++;
				j.enqueue(job);
			} //end if
			else //operation 'D' shoots to here:
			{
				cout << "Dequeue\t";
				j.dequeue(job);
				cout << job << endl;
			}
			inFile >> Operation;
			inFile.ignore();
			inFile >> job.numLines;
			inFile.ignore();
			getline(inFile, job.jobName);
		}//end while
		inFile.close();
	} //end else
}
//****************************************************************************************************