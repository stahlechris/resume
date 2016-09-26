//****************************************************************************************************
//
//		File:					Queue.h
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
//		This program uses a linked queue data structure.
//		
//
//****************************************************************************************************
#ifndef QUEUE_H
#define QUEUE_H
#include <iostream>
using namespace std;
//****************************************************************************************************
template <class DT>
struct Node2                 
{
	DT info;
	Node2<DT> *next;
};
//****************************************************************************************************
template <class DT>
class Queue                 
{
private:
	Node2<DT> *front;    //ptr to front of the queue
	int	count;           //count of elements 
	Node2<DT> *back;     //ptr to the back of the queue
public:         
	Queue();
	~Queue();
	bool empty();      //check if empty
	void makeEmpty();  //deallocate memory
	DT getFront();     //gimme the front data
	bool dequeue();    //get him(front) out of line, it's my turn
	void enqueue(const DT&);
}; // end of class declaration
#endif
//****************************************************************************************************
template <class DT>
Queue<DT>::Queue() //constructor 
{
	front = back = NULL;
	count = 0;
}
//****************************************************************************************************
template <class DT>
Queue<DT>::~Queue() //destructor 
{
	makeEmpty();
}
//****************************************************************************************************
template <class DT>
void Queue<DT>::makeEmpty() 
{
	Node2<DT> *temp;						
	while(!empty())		                // while the queue is not empty
	{
		temp = front;					// temp gets the fronts &
		front = front->next;			// so front can get the obj in front of it
		delete temp;					// delete what front used to have 
	}
}
//****************************************************************************************************
template <class DT>
bool Queue<DT>::empty() //check if empty 
{
	if(front==NULL)               //would be NULL when empty or 1 in there   
		return true;return false; //true, it has nothing in it, or false it has something in it!
}
//****************************************************************************************************
template <class DT>
void Queue<DT>::enqueue(const DT& obj)  
{
	Node2<DT> *nodePtr = new Node2<DT>; //make a ptr to point to newly allocated Node box
	nodePtr -> info = obj;
	nodePtr -> next = NULL;
	if(empty())
	{
		front = back = nodePtr;
	}
	else
	{
		back -> next = nodePtr; //previous box now pts to next one
		back = nodePtr;         //previous box gets 
	             //we added a new box
	}
	count++;   
}
//****************************************************************************************************
template <class DT>
bool Queue<DT>::dequeue()       //removes box from the front 
{
	if (empty())
	{
		back = NULL;            //if it is empty...now we start over front = back = NULL for refill
		return false;           //false, we didnt dequeue, bc it's empty or 1 node
	}		
	else
	{
		Node2<DT> *tempPtr;          
		tempPtr = front;
		//obj = front -> info;        
		front = front -> next;    
		count--;
		delete tempPtr; 
		return true;            //true, we removed something.
	}							

}
//****************************************************************************************************
template <class DT>
DT Queue<DT>::getFront()
{
	if(empty())
	{
		cerr << "The queue is empty. I can't return anything!\n";
		exit(99);
	}
	else
	{
		return front -> info;
	}
}
//****************************************************************************************************