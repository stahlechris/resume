//****************************************************************************************************
//
//		File:					drvrTree.cpp
//
//		Student:				Chris Stahle
//
//		Assignment:	 			Program  # 6
//
//		Course Name:			Data Structures II
//
//		Course Number:			COSC 3100 - 01
//
//		Due:					May 3, 2016
//
//
//		This program uses a binary search tree and many of its related operations in use with   
//		category data from a csv file. 
//****************************************************************************************************
#include "Tree.h"
#include <iostream>
#include <fstream>
#include <string>
#include <limits> //validation checking
using namespace std;
//****************************************************************************************************
struct categoryStructure
{
	char key;
	string categoryName;
	categoryStructure() { key = 0; categoryName = "Unassigned"; }
	//*****************************************
				//GREATER THAN\\
	//*****************************************
	bool operator > (const categoryStructure&c)
	{
		if (this->key > c.key)
			return true; return false;
	}
	//*****************************************
					//LESS THAN\\
	//*****************************************
	bool operator < (const categoryStructure&c)
	{
		if (this->key < c.key)
			return true; return false;
	}
	//*****************************************
			//GREATER THAN EQUAL TO\\
	//*****************************************
	bool operator>= (const categoryStructure&c)
	{
		if (this->key >= c.key)
			return true; return false;
	}
	//*****************************************
			   //LESS THAN EQUAL TO\\
	//*****************************************
	bool operator<= (const categoryStructure&c)
	{
		if (this->key <= c.key)
			return true; return false;
	}
	//*****************************************
					//EQUAL TO\\
	//*****************************************
	bool operator == (const categoryStructure&c)
	{
		if (this->key == c.key)
			return true; return false;
	}
	//*****************************************
			//COUT OBJECT FOR GRAPHING\\
	//*****************************************
	friend ostream& operator<< (ostream& out, const categoryStructure& c)
	{
		out << c.key << "(" << c.categoryName << ")\n";
		return out;
	}
}; //End structure definition
//****************************************************************************************************
void getData(binaryTree<categoryStructure>&);
void displayTree(binaryTree<categoryStructure>&);
void coutMenu(int &userChoice);
void addUserData(binaryTree<categoryStructure>&, char &stopAdding);
void updateTree(binaryTree<categoryStructure>&);
void deleteNode(binaryTree<categoryStructure>&);
void searchNode(binaryTree<categoryStructure>&, bool &foundSearch);
void determineNumNodes(binaryTree<categoryStructure>&);
void determineSmallestCategory(binaryTree<categoryStructure>&);
void determineLargestCategory(binaryTree<categoryStructure>&);
void determineHeight(binaryTree<categoryStructure>&);
void determineAscendingSequence(binaryTree<categoryStructure>&);
void determinePreorder(binaryTree<categoryStructure>&);
void determinePostorder(binaryTree<categoryStructure>&);
//****************************************************************************************************
int main(binaryTree<categoryStructure>&c)
{
	binaryTree<categoryStructure> categoryList; //make a BST
	getData(categoryList);                      //load the BST
	displayTree(categoryList);					//display the BST
	int userChoice = 0;
	char stopAdding = 'Y';
	bool foundSearch = true;
	while (userChoice != 13)
	{
		coutMenu(userChoice);				   //display the menu
		switch (userChoice)
		{
		case 1:
			while (stopAdding != 'N')
			{
				addUserData(categoryList, stopAdding);
			}
			break;
		case 2:
			updateTree(categoryList);
			break;
		case 3:
			deleteNode(categoryList);
			break;
		case 4:
			searchNode(categoryList, foundSearch);
			break;
		case 5:
			determineNumNodes(categoryList);
			break;
		case 6:
			determineSmallestCategory(categoryList);
			break;
		case 7:
			determineLargestCategory(categoryList);
			break;
		case 8:
			determineHeight(categoryList);
			break;
		case 9:
			determineAscendingSequence(categoryList);
			break;
		case 10:
			determinePreorder(categoryList);
			break;
		case 11:
			determinePostorder(categoryList);
			break;
		case 12:
			displayTree(categoryList);
			break;
		case 13:
			break;
		default:
			cout << "Invalid choice! Enter a new number:\n";
			cin >> userChoice;
		} //end switch
	}//end while 
	return 0;
}
//****************************************************************************************************
void getData(binaryTree<categoryStructure>&c)
{
	categoryStructure category;
	ifstream inFile("Categories.csv");

	if (!inFile)
	{
		cout << "Error opening file!\n";
		exit(99);
	}
	else
	{
		inFile >> category.key;
		inFile.ignore();
		getline(inFile, category.categoryName);
		while (!inFile.eof())
		{
			c.insertNode(category);
			inFile >> category.key;
			inFile.ignore();
			getline(inFile, category.categoryName);
		}
		inFile.close();
	} //close else
}
//****************************************************************************************************
void addUserData(binaryTree<categoryStructure>& c, char &stopAdding)
{
	categoryStructure usersCategory;
	bool found = false;
	char newLetter;
	string categoryName; 

	cout << "You chose to add a category.\n"
		<< "Enter the name of the category you want to add:";
	cin >> categoryName;
	categoryName[0] = toupper(categoryName[0]); 
	usersCategory.key = categoryName[0]; //ensures that when adding key is first letter 
	usersCategory.categoryName = categoryName;
	found = (c.findValue(usersCategory, found));
	while (found)
	{
		cout << "That category already exists because the letter representing it is in use!\n";
		cout << "Lets try this...\n"
			<< "Enter the letter that will represent your new category you want to add: ";
		cin >> newLetter; //simplify process if mess up 
		newLetter = toupper(newLetter);
		usersCategory.key = newLetter;

		cout << "Now enter the name of the category you want to add\n";
		cin >> categoryName;
		usersCategory.categoryName = categoryName;
		found = (c.findValue(usersCategory, found)); //check if category exists in BST(search on key)
	}

	c.insertNode(usersCategory);
	cout << "Got it! You succesfully added " << categoryName << " to your tree!\n"
		<< "or if you want to keep adding, say Y for yes, or N for no:  ";
	cin >> stopAdding;
	stopAdding = toupper(stopAdding);
	while (!isalpha(stopAdding))
	{
		cout << "Oops! Enter either Y or N: ";
		cin >> stopAdding;
		stopAdding = toupper(stopAdding);
	}
}
//****************************************************************************************************
void updateTree(binaryTree<categoryStructure>&c)
{
	categoryStructure usersUpdateCategory;
	categoryStructure temp;
	bool found = false;
	char updateLetter;
	string updateName; 

	cout << "You chose to update a category.\n"
		<< "Enter the letter representing the category you wish to update: ";
	cin >> updateLetter;
	updateLetter = toupper(updateLetter);
	usersUpdateCategory.key = updateLetter;
	found = (c.findValue(usersUpdateCategory, found)); //searching on the key!
													   //aka when u type christmas it finds carpets
	while (!found)
	{
		cout << "That category doesn't exist!"
			<< " How do you plan on updating a category that doesn't exist??\n";

		cout << "Let's try again...Enter the letter representing the EXISTING category"
			<< " you want to update: ";
		cin >> updateLetter;
		updateLetter = toupper(updateLetter);
		usersUpdateCategory.key = updateLetter;
		found = (c.findValue(usersUpdateCategory, found)); //check if category exists in BST
	}
	temp = usersUpdateCategory; //store what they searched to update in temp
	cout << "Ok. Found it.\n"
		<< "What is the letter that is going to newly represent this category?: ";

	cin >> updateLetter;
	usersUpdateCategory.key = updateLetter;
	cout << "Got it. Now enter the name of the category: ";
	cin >> updateName;
	usersUpdateCategory.categoryName = updateName;
	cout << "Changing...\n";
	c.callDelete(temp); //delete the one they wanted to update
	c.insertNode(usersUpdateCategory); //replace it with their new input 
	cout << "Got it! You succesfully updated your tree!\n"
		<< "Enter 12 to see the new tree.\n";
}
//****************************************************************************************************
void deleteNode(binaryTree<categoryStructure>&c)
{
	char deleteLetter; 
	categoryStructure usersDeleteCategory;
	bool found = false;
	cout << "You chose to delete a category.\n"
		<< "What is the letter representing the category you want to delete?";
	cin >> deleteLetter;
	deleteLetter = toupper(deleteLetter);
	usersDeleteCategory.key = deleteLetter;
	found = (c.findValue(usersDeleteCategory, found)); //satisfy argument of object
	while (!found)
	{
		cout << "That category doesn't exist!"
			<< " How do you plan on deleting a category that doesn't exist??\n";

		cout << "Let's try again...Enter the letter representing the EXISTING category "
			<< "you want to delete: ";
		cin >> deleteLetter;
		deleteLetter = toupper(deleteLetter);
		usersDeleteCategory.key = deleteLetter;
		found = (c.findValue(usersDeleteCategory, found)); //check if category exists in BST
	}

	cout << "Ok. Found it...Deleting...\n";
	c.callDelete(usersDeleteCategory);
	cout << "Got it! You succesfully deleted the category!"
		<< " Enter 12 to see the new tree.\n";
}
//****************************************************************************************************
void searchNode(binaryTree<categoryStructure>&c, bool &foundSearch)
{
	char searchLetter; 
	categoryStructure usersSearchCategory;

	cout << "You chose to search to see if a letter is already representing a category.\n"
		<< "What is the letter representing the category you want to search for?";
	cin >> searchLetter;
	searchLetter = toupper(searchLetter);
	usersSearchCategory.key = searchLetter;
	foundSearch = (c.findValue(usersSearchCategory, foundSearch));//satisfy argument of object
	if (foundSearch)
	{
		cout << "Found it! That letter is in use representing a category\n";
	}//end if 
	else
	{
		cout << "Didn't find it! That letter is not representing a category!\n";
	}
}
//****************************************************************************************************
void determineNumNodes(binaryTree<categoryStructure>&c)
{
	cout << "The number of nodes in the tree is: " << c.countNodes() << endl;
}
//****************************************************************************************************
void determineSmallestCategory(binaryTree<categoryStructure>&c)
{
	cout << "The smallest category in the tree is: \n" << c.smallestValue() << endl;

}
//****************************************************************************************************
void determineLargestCategory(binaryTree<categoryStructure>&c)
{
	cout << "The largest category in the tree is: " << c.largestValue() << endl;
}
//****************************************************************************************************
void determineHeight(binaryTree<categoryStructure>&c)
{
	cout << "The height of the tree is: " << c.callHeight() << endl;
}
//****************************************************************************************************
void determineAscendingSequence(binaryTree<categoryStructure>&c)
{
	cout << "The tree in ascending sequence is: \n";
	c.inorderTraversal();
}
//****************************************************************************************************
void determinePreorder(binaryTree<categoryStructure>&c)
{
	cout << "The tree in preOrder sequence is: \n";
	c.preorderTraversal();
}
//****************************************************************************************************
void determinePostorder(binaryTree<categoryStructure>&c)
{
	cout << "The tree in postOrder sequence is: \n";
	c.postorderTraversal();
}
//****************************************************************************************************
void displayTree(binaryTree<categoryStructure>&c)
{
	if (!c.isEmpty())
	{
		c.displayTree(3); //assume user has control over indentation amount 
	}
}
//****************************************************************************************************
void coutMenu(int &userChoice)
{
	cout << "---------------------------------------------------\n"
		<< "Select an option from the menu below!\n"
		<< "---------------------------------------------------\n"
		<< "1. Add categories\n"
		<< "2. Update a category\n"
		<< "3. Delete a category\n"
		<< "4. Search for a category\n"
		<< "5. Determine the number of nodes in the tree\n"
		<< "6. Determine the smallest category in the tree\n"
		<< "7. Determine the largest category in the tree\n"
		<< "8. Determine the height of the tree\n"
		<< "9. Display the categories in ascending sequence\n"
		<< "10. Display the categories in preorder sequence\n"
		<< "11. Display the categories in postorder sequence\n"
		<< "12. Display the tree graphically\n"
		<< "13. Quit\n"
		<< "---------------------------------------------------\n";
	while (!(cin >> userChoice) || userChoice < 1 || userChoice > 13) //bounds checking
	{
		cout << "Enter a valid choice from the menu: \t";
		cin.clear(); //reset the error state flags that a non int would have caused
		cin.ignore(numeric_limits<streamsize>::max(), '\n');
	}
}
//****************************************************************************************************
//Did a little research on some easy to use bounds checking functions. I've included these 
//with #include <limits>. Modified the ignore() to ignore any remaining characters
//in the buffer. The first argument tells buffer to allow the max stream size for input,
//the second argument is a delimiter that says when a \n(enter) is found, stop getting characters.
//!(cin >> userChoice) tests for datatype mismatch. A null ptr returns if you dont enter
//an int...which causes the innards of this loop to run.
//
// *****I only chose to implement this validation check here due to the program requirements-- how they
//didn't state that we needed to do this elsewhere. I was researching on my own and found this an 
//interesting and efficient way to perform validation/bounds checking after any time the user is asked to input a 
//data.
//****************************************************************************************************