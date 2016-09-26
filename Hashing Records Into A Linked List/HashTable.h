// HashTable.h -- class template for a hash table using chaining

#include "List.h"

// client must provide a hash function with the following characteristics:
//		1 input parameter of DT (see below), passed by const reference
//	    returns an integer between 0 and size - 1, inclusive, where size is the
//		number of elements in the hash table
//		the name of the function is passed as the first parameter to the HashTable 
//		constructor
//		client may make as many hash functions for as many HashTables as desired
// if a struct is used for DT, a typical use of retrieve, remove, and update would
// be to set the key of an object and then pass the object into the function
// retrieve, remove, and update will return false if:
//		(1) the hash function supplied above does not return a valid index
//	    (2) the supplied key or element cannot be found in the hash table
// otherwise, these functions will return true if successful
// For retrieve, remove and update functions, if you are using an object as an element, a 
// typical use would be to set the key of the desired object to retrieve, remove, or
// update; then pass the object into the function.
// If an object of a struct is used for DT, the == operator must be 
// overloaded for it; the left and right operands are both DT objects
// the == comparison is used for finding elements, usually by key value

template <class DT>
class HashTable 
{
    private:
        int size;
        int (*hf) (const DT&); //hash function pointer pting to the app's hash function(s)
        List<DT> *array;       //This is the table containing the data in List.h's linked list.
                               //each element of the array contains a list to
    public:
		HashTable();           //compiler requires default constructor ...this cause syntax error 'return'
		HashTable(int (*Chf) (const DT&), int);  //Constructor Hash Function  //ERR misisng int
    ~HashTable();
    bool insert(const DT&);              //if success, return true.
    bool retrieve(DT&);                  //retrieve function returns false if not found.
                                         //
};

// HashTable.cpp -- function definitions for a hash table using chaining
template<class DT>
HashTable<DT>::HashTable( )
{
	//Compiler requires a default constructor to build & run.
}

template<class DT>
inline HashTable<DT>::HashTable(int (*Chf)(const DT &), int s)  //ERR missing int and s
{
	size = s;
	hf = Chf; //hf is pting to where the app's hash function ptr  //ERR c is C
	array = new List<DT>[size];
}

template<class DT>    //ERR need space between class and DT
HashTable<DT>::~HashTable()
{
    delete []array;
}

template<class DT>   //ERR need space between class and DT
bool HashTable<DT>::insert(const DT& obj)
{
    int location = hf(obj);   
	movieStructure m;
	bool isCollision = false;							 //this calls the app's hashing function to calc. the index.
    if(location < 0 || location > (size -1)) //checking the location to be between 0 || size - 1
        return false;
	cout << obj << " is being added\n";
	cout << "The hashed location is " << location << endl;
	if (array[location].first(m)) //this is the only way i could think of to count
	{
		numCollisions++;
		isCollision = true;
	}
    array[location].insert(obj);

	if (isCollision)
	{
		cout << "There was a collision loading " << obj;
		cout << "\nIt collided with " << m;
		cout << "\n-------------------------------\n";
	}
	else
	{
		cout << "There was no collision loading " << obj << endl;
		cout << "-------------------------------\n";
	}
    return true;                             //This uses the linked list insert for the linked list located at array[loc] to insert
                                             //linkedlist function has to be called "insert"
}

template<class DT>  //ERR need space between class and DT
bool HashTable<DT>::retrieve(DT& obj)
{
    int location = hf(obj);  //This calls the app's hash function to calc. the index
	cout << "At the hashed location is " << location << endl;
    if(location < 0 || location > (size -1)) //checking the location to be between 0 || size - 1
        return false;
	return array[location].retrieve(obj);

}