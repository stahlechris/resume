//*********************************************************************************
//*    Example of  a Linked List class used in a Hash Table class
//*    Will be completed in class
//*    ?? signifies a change is needed
//*********************************************************************************

#ifndef List_H
#define List_H
#include<string>
#include<iostream>
using namespace std;

static int numCollisions = 0;

template <class DT>
struct Node {
	DT info;
	Node<DT> *next;
};

template <class DT>
class List
{
public:
	List( );
	List( const List<DT> & );
	~List( );
	List<DT> & operator =( const List<DT> & );
	void insert( const DT &); // no current position after use
	bool first( DT & );	  // returns first element of list in listEl
										  // and current position is set to this element; 
										  // if list is empty, returns false and there is
										  // no current position; otherwise, returns true
	inline bool getNext( DT & );	      // retrieves the next element of a linked list
										  // beyond the last element that was retrieved
										  // by first or getNext functions and returns
										  // it in listEl;
										  // current position is set to this element.
										  // if no element exists at this position, 
										  // getNext returns false and there is no 
										  // current position; returns true otherwise	
	bool find ( const DT & );             // returns true if element is found
									      // returns false if element is not found
										  // if found, found element becomes current
										  // position in list; if not found, there is
										  // no current position
	bool retrieve( DT & );                // like find, except returns found element
	bool isEmpty( ) const;				  // returns true if linked list is empty
										  // returns false otherwise; current position
										  // unchanged
	void makeEmpty( );	
	//static int getNumCollisions(); // no current position
private:
	Node<DT> *start;
	Node<DT> *current;			          // points to node at current position	
	inline void deepCopy( const List<DT> & );
	static int collisionCount; //3/29/2016 keep track of collisions at each element of the array
};

#endif
/*template <class DT>
int List<DT>::collisionCount;//I could not reference the static variable in main.cpp									
							// so i moved it out of the class and it worked. 
template <class DT>
int List<DT>::getNumCollisions()
{
	return collisionCount;
}
*/
template <class DT>
List<DT>::List( )
{
	start = current = NULL;
}

template <class DT>
List<DT>::List( const List<DT> & aplist )
{
	deepCopy( aplist );
}

template <class DT>
List<DT>::~List( )
{
	makeEmpty( );
}

template <class DT>
List<DT> & List<DT>::operator =( const List<DT> & rlist )
{
	if ( this == &rlist )
		return *this;
	makeEmpty( );
	deepCopy( rlist );
	return *this;
}

// inserts at the beginning of the linked list
// no current position after use		
template <class DT>
void List<DT>::insert( const DT & element )
{
	current = NULL;
	Node<DT> *newNode = new Node<DT>;
	newNode->info = element;
	newNode->next = start;
	start = newNode;
	Node<DT> *ptr = start;
	while (ptr != NULL)
	{ //  i can't get this to work in list.h. Always says there is a collision.
	/*	if (!first(ptr->info)) 
		{
			cout << "There was no collision loading " << ptr->info << endl;
			cout << "-------------------------------\n";
			
		}
		else
		{
			cout << "There was a collision loading " << ptr->info;
			cout << "\nIt collided with " << start->info;
			cout << "\n-------------------------------\n";
		}
		*/
		ptr = ptr->next;
	}
}	

// returns first element of list in listEl and current position is set to this element; 
// if list is empty, returns false and there is no current position; 
// otherwise, returns true
template <class DT>
bool List<DT>::first( DT & listEl )
{
	if ( start == NULL ) 
		return false;

	current = start;
	listEl = start->info;
	return true;
}

// retrieves the next element of a linked list beyond the last element that was retrieved
// by first or getNext functions and returns it in listEl;
// current position is set to this element.
// if no element exists at this position, getNext returns false and there is no 
// current position; returns true otherwise	
template <class DT>
inline bool List<DT>::getNext( DT & listEl )				  
{
	if ( current == NULL ) 
		return false;
	if ( current->next == NULL ) {
		current = NULL;
		return false;
		}

	current = current->next;
	listEl = current->info;
	return true;
}


// returns true if element is found; returns false if element is not found
// if found, found element becomes current position in list; 
// if not found, there is no current position
template <class DT>
bool List<DT>::find( const DT & element )
{
	int pass = 1;
	DT item;
	if ( !first( item ) )
		return false;
	do 
	{
		if ( item == element ) 
			return true;
	}
	while ( getNext( item ) );

	return false;
}

// returns true if element is found; returns false if element is not found
// if found, found element becomes current position in list; 
// if not found, there is no current position
template <class DT>
bool List<DT>::retrieve( DT & element )
{
	if ( !find( element ) )
		return false;
	Node<DT> *ptr = start;
	while(ptr!=NULL)
	{
		cout << "There was a collision here with " << ptr->info << endl;
		ptr=ptr->next;
	}
	element = current->info;
	return true;
}

template <class DT>
bool List<DT>::isEmpty( ) const				  
{
	return start == NULL;
}

template <class DT>
void List<DT>::makeEmpty( )					  
{
	while ( start != NULL ) {
		current = start;
		start = start->next;
		delete current;
	}

	current = NULL;
}

template <class DT>
inline void List<DT>::deepCopy( const List<DT> & original )
{
	start = current = NULL;
	if ( original.start == NULL )
		return;
	Node<DT> *copyptr = start = new Node<DT>;
	Node<DT> *originalptr = original.start;
	copyptr->info = originalptr->info;
	if ( originalptr == original.current )
		current = copyptr;
	while ( originalptr->next != NULL ) {
		originalptr = originalptr->next;
		copyptr->next = new Node<DT>;
		copyptr = copyptr->next;
		copyptr->info = originalptr->info;
		if ( originalptr == original.current )
			current = copyptr;
	}
	copyptr->next = NULL;
}


