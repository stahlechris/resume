//****************************************************************************************************
//
//		File:					Stack.h
//
//		Student:				Chris Stahle
//
//		Assignment:	 			Program  # 5
//
//		Course Name:			Data Structures I
//
//		Course Number:			COSC 3050 - 01
//
//		Due:					Feb 23, 2016
//
//
//		This program uses a linked stack structure. 
//		
//
//****************************************************************************************************
#ifndef STACK_H
#define STACK_H
#include <iostream>
using namespace std;
//****************************************************************************************************
template <class DT>
struct Node                 //NODE STRUCT = STILL USING NODES
{
	DT info;
	Node<DT> *next;
};
//****************************************************************************************************
template <class DT>
class Stack                 //CLASS STACK = PUT ROUNDS (NODES) INTO THE  STACK (MAGAZINE)
{
private:
	Node<DT> *top;          //this points to the top round in the mag 
	
public:         
	Stack();
	~Stack();
	void makeEmpty();
	bool empty();            //returns true if the stack is empty
	void push(const DT&);    //WE CAN PUSH ANOTHER ROUND(NODE) INTO THE MAG(STACK)
	DT getTop();			 //WE CAN GETTOP ROUND(NODE) BY COCKING THE CHAMBER 
	bool pop();				 //WE CAN POP OFF A ROUND(NODE) BY FIRING
 }; // end of class declaration
#endif
//****************************************************************************************************
template <class DT>
Stack<DT>::Stack()      //CONSTRUCTOR
{
	top = NULL;         //start with an unfilled top
}
//****************************************************************************************************
template <class DT>
Stack<DT>::~Stack()      
{
	makeEmpty();
}
//****************************************************************************************************
template <class DT>
void Stack<DT>::makeEmpty()
{
	bool found;
	while(top != NULL)  //when top has something...
	{
		found = pop();  //pop can return true only if we deleted something...
	}          
}
//****************************************************************************************************
template <class DT>
bool Stack<DT>::empty()
{
	if(top==NULL)       //if top has nothing ...
		return true;return false; //true, it has nothing in it, or false it has something in it!
								  //this is useful to insert in following tests...if(!empty)...
}
//****************************************************************************************************
template <class DT>
void Stack<DT>::push(const DT& obj)  //this obj is an int. stored in a box(node)
{
	Node<DT> *pushPTR = new Node<DT>;   //create a new ptr pointing to a new box
	pushPTR->info = obj;                //pushPTR's data gets an obj thats fed to it
	pushPTR->next = top;                //pushPTR's next gets top bc it is the new top if we added
	top = pushPTR;					    //top gets updated
}
//****************************************************************************************************
template <class DT>
DT Stack<DT>::getTop()
{
	if(!empty())
	{
		return top->info;                        //if the stack isnt empty, gimme the first(top) data
	}
	else
	{
		cerr << "Cannot access empty stack\n";   //else it's empty, game over ur stack sucks 
		exit(99);
	}
}
//****************************************************************************************************
template <class DT>
bool Stack<DT>::pop()
{
	if(!empty())
	{
		Node<DT> *popPTR = top;   //make a temp ptr to pt at top
		top = top->next;          //top gets top's next ptr which is like the one below top 
		delete popPTR;            //deallocate ptr's mem...erasing the box 
		return true;              //true, we erased something 
	}
	return false;
}
//****************************************************************************************************