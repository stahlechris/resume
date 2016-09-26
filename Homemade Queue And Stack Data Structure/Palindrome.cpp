//****************************************************************************************************
//
//		File:					Palindrome.cpp
//
//		Student:				Chris Stahle
//
//		Assignment:	 			Program  # 6
//
//		Course Name:			Data Structures I
//
//		Course Number:			COSC 3050 - 01
//
//		Due:					March 1, 2016
//
//
//		This program uses a linked stack or a linked queue to determine if a user's input is a 
//		palindrome or not.
//
//****************************************************************************************************
#include <iostream>
#include <iomanip>
#include <string>
#include "Stack.h"
#include "Queue.h"
using namespace std;
//****************************************************************************************************
void getData(Stack<char>&, Queue<char>&);
//****************************************************************************************************
int main()
{
	Stack<char> s;        
	Queue<char> q;
	getData(s,q);

	return 0;
}
//****************************************************************************************************
void getData(Stack<char>&s, Queue<char>&q)
{
	string userInput;
	bool isPalindrome = true;
	char stackTemp;
	char queueTemp; 
	bool quit = false; //false, we don't wanna quit

	while(!quit) //while we dont wanna quit...
	{
		cout << "Enter an expression that you think might be a palindrome:\n";
		getline(cin, userInput); //get the string of chars, store the string in "userinput"
		//length = userInput.length();
		for(int i=0; i<userInput.length(); i++)   //signed/unsigned mismatch?
		{
			if(isalnum(userInput[i]))
			{
				q.enqueue(tolower(userInput[i]));
				s.push(tolower(userInput[i]));    
			}
		} 
		//each structure got the same line of text 
		while(!s.empty() && !q.empty() )
		{
			stackTemp = s.getTop ();
			//cout<<stackTemp << " top of stack\n";
			s.pop ();

			queueTemp = q.getFront();
			//cout <<queueTemp << " front of queue\n";
			q.dequeue ();
			if ( stackTemp != queueTemp ) 
			{
				isPalindrome = false; //every element must match..
			}
			else
			{
				isPalindrome = true;
			}
		}
		if ( isPalindrome )
		{
			cout << "String is a palindrome." << endl;
		}
		else
		{
			cout << "String is not a palindrome." << endl;
		}
		cout << "Enter another expression? 0 for Yes, 1 for No:  \n";
		cin >> quit;
		cin.ignore();
	} 
} //end function