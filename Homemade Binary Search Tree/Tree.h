//****************************************************************************************************
//
//		File:					Tree.h
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
//		category data from a csv file. I've made most functions to accept arguments of objects
//      so in the future if the key is not a char, this will still work. Just simply change the 
//      overloaded comparison operators in main.cpp. 
//****************************************************************************************************
#ifndef Tree_H
#define Tree_H
#include<string>
#include<iostream>
#include<iomanip>
using namespace std;
//****************************************************************************************************
template <class DT>
struct treeNode
{
	treeNode* left;
	DT info;
	treeNode* right;

};
//****************************************************************************************************
template <class DT>
class binaryTree
{
private:
	treeNode<DT> *root;
	void destroy(treeNode<DT> *&root); //destructor code
	void addBST(treeNode<DT> *&root, treeNode<DT> *newNode); //add items to tree code
	void graphAux(int indent, treeNode<DT> *root); //code to display tree sideways
	void search(treeNode<DT>* root, DT& item, bool& found);
	void deleteTheNode(treeNode<DT>*& root, DT item);
	int nodeCount(treeNode<DT> *root);
	int treeHeight(treeNode<DT> *root);
	void inorder(treeNode<DT> *root);
	void preorder(treeNode<DT> *root);
	void postorder(treeNode<DT> *root);
	int max(int, int);
	treeNode<DT> *smallestNode(treeNode<DT> *root);
	treeNode<DT> *largestNode(treeNode<DT> *root);

public:
	binaryTree();
	~binaryTree();
	bool isEmpty();
	void inorderTraversal();
	void preorderTraversal();
	void postorderTraversal();
	bool findValue(DT&, bool&);
	void insertNode(DT);
	void callDelete(DT);
	DT smallestValue();
	DT largestValue();
	int callHeight();
	int countNodes();
	int callMax();
	void displayTree(int); //ASSUME USER PICKS INDENT AMOUNT
};
//****************************************************************************************************
								//CONSTRUCTOR BELOW\\
//****************************************************************************************************
template <class DT>
binaryTree<DT>::binaryTree()
{
	root = NULL;
}
//****************************************************************************************************
								//PRIVATE DESTROY FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
inline void binaryTree<DT>::destroy(treeNode<DT>*& root)
{
	{
		if (root != NULL)
		{
			destroy(root->left);
			destroy(root->right);
			delete root;
			root = NULL;
		}
	}
}
//****************************************************************************************************
								//PUBLIC DESTROY FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
binaryTree<DT>::~binaryTree()
{
	destroy(root);
}
//****************************************************************************************************
									//PUBLIC IS_EMPTY FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
bool binaryTree<DT>::isEmpty()
{
	return root == NULL; //returns true if root is NULL
}
//****************************************************************************************************
									//PRIVATE INORDER FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
void binaryTree<DT>::inorder(treeNode<DT> *root)
{
	if (root != NULL)
	{
		inorder(root->left);
		cout << root->info;
		inorder(root->right);
	}
}
//****************************************************************************************************
								//PUBLIC INORDERtRAVERSAL FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
void binaryTree<DT>::inorderTraversal()
{
	inorder(root);
}
//****************************************************************************************************
							//PRIVATE PREORDER FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
void binaryTree<DT>::preorder(treeNode<DT> *root)
{
	if (root != NULL)
	{
		cout << root->info;
		preorder(root->left);
		preorder(root->right);
	}
}
//****************************************************************************************************
								//PUBLIC PREORDER TRAVERSAL FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
void binaryTree<DT>::preorderTraversal()
{
	preorder(root);
}
//****************************************************************************************************
								//PRIVATE POSTORDER FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
void binaryTree<DT>::postorder(treeNode<DT> *root)
{

	if (root != NULL)
	{
		postorder(root->left);
		postorder(root->right);
		cout << root->info;
	}
}
//****************************************************************************************************
								//PUBLIC POSTORDER TRAVERSAL FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
void binaryTree<DT>::postorderTraversal()
{
	postorder(root);
}
//****************************************************************************************************
							//PRIVATE NODE_COUNT FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
int binaryTree<DT>::nodeCount(treeNode<DT> *root)
{
	if (root == NULL)
		return 0;
	else
		return nodeCount(root->left) + nodeCount(root->right) + 1;
}
//****************************************************************************************************
							//PUBLIC COUNT_NODES FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
int binaryTree<DT>::countNodes()
{
	return nodeCount(root);
}
//****************************************************************************************************
							//PRIVATE GET_HEIGHT FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
int binaryTree<DT>::treeHeight(treeNode<DT>*root)
{
	if (root == NULL)
		return 0;
	else
		return 1 + max(treeHeight(root->left), treeHeight(root->right));
}
//****************************************************************************************************
							//PUBLIC GET_HEIGHT FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
int binaryTree<DT>::callHeight()
{
	return treeHeight(root);
}

//****************************************************************************************************
								//PRIVATE MAX FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
int binaryTree<DT>::max(int first, int second)
{
	if (first > second)
		return first;
	else
		return second;
}
//****************************************************************************************************
								//PUBLIC MAX FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
int binaryTree<DT>::callMax()
{
	return max(int, int);
}
//****************************************************************************************************
									//PRIVATE SEARCH FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
void binaryTree<DT>::search(treeNode<DT>* root, DT& item, bool& found)
{
	if (root == NULL)
		found = false;		// item is not found.
	else if (item < root->info)	// Search left subtree.
		search(root->left, item, found);
	else if (item > root->info)	// Search right subtree
		search(root->right, item, found);
	else
	{
		item = root->info;  // item is found.
		found = true;
	}
}
//****************************************************************************************************
									//PUBLIC SEARCH FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
bool binaryTree<DT>::findValue(DT &item, bool &found)
{
	search(root, item, found);
	return found;
}
//****************************************************************************************************
									//PRIVATE INSERT FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
inline void binaryTree<DT>::addBST(treeNode<DT> *& root, treeNode<DT> *newNode)
{
	if (root == NULL) //if the root is null, reset the root to be a new node first time)
		root = newNode;
	else
		if (newNode->info < root->info)//treeNode has DT info and overloaded ops in main compare char
			addBST(root->left, newNode);
		else
			addBST(root->right, newNode);
}
//****************************************************************************************************
									//PUBLIC INSERT FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
void binaryTree<DT>::insertNode(DT item)
{
	treeNode<DT> *pNew; //make a ptr
	pNew = new treeNode<DT>;// to point to a new treeNode box
	pNew->info = item; //info gets the item were sending to it in main
	pNew->right = NULL;
	pNew->left = NULL;
	addBST(root, pNew); //call the private function to do the work ^
}
//****************************************************************************************************
								//PRIVATE DELETE_NODE FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
void binaryTree<DT>::deleteTheNode(treeNode<DT>*& root, DT item)
{
	treeNode<DT> *tempPtr;
	if (item < root->info)
		deleteTheNode(root->left, item);
	else if (item > root->info)
		deleteTheNode(root->right, item);
	else //item==root->key bc not greater nor less 
	{
		if (root->left == NULL)
		{
			tempPtr = root;
			root = root->right;
			delete tempPtr;
		}
		else if (root->right == NULL)
		{
			tempPtr = root;
			root = root->left;
			delete tempPtr;
		}
		else
		{
			tempPtr = root->left;
			while (tempPtr->right != NULL)
				tempPtr = tempPtr->right;
			root->info = tempPtr->info;
			deleteTheNode(root->left, tempPtr->info);
		}
	}
}
//****************************************************************************************************
							//PUBLIC CALL_DELETE FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
void binaryTree<DT>::callDelete(DT item)
{
	deleteTheNode(root, item);
}
//****************************************************************************************************
							//PRIVATE SIDEWAYS DISPLAY FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
inline void binaryTree<DT>::graphAux(int indent, treeNode<DT> *root)
{
	if (root != 0) //NULL
	{
		graphAux(indent + 8, root->right);
		cout << setw(indent) << " " << root->info << endl;
		graphAux(indent + 8, root->left);
	}
}
//****************************************************************************************************
								//PUBLIC SIDEWAYS DISPLAY FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
inline void binaryTree<DT>::displayTree(int indent)
{
	graphAux(indent, root); 
	cout << "------------------------------------------------------------\n"
		<< "Tilt your head to the left to view your above BST .\n"
		<< "The left subtree's values will all be lesser than the root.\n"
		<< "The right subtree's values will all be greater than the root\n"
		<< "-------------------------------------------------------------\n";
}
//****************************************************************************************************
								//PRIVATE SMALLESTNODE FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
treeNode<DT>* binaryTree<DT>::smallestNode(treeNode<DT> *root)
{
	if (root->left == NULL)
		return root;
	else
		return smallestNode(root->left);
}
//****************************************************************************************************
									//PUBLIC SMALLEST VALUE FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
DT binaryTree<DT>::smallestValue()
{
	treeNode<DT> *p = smallestNode(root);
	return p->info;
}

//****************************************************************************************************
									//PRIVATE LARGESTESTNODE FUNCTION BELOW\\
//****************************************************************************************************
template<class DT>
treeNode<DT>* binaryTree<DT>::largestNode(treeNode<DT> *root)
{
	if (root->right == NULL)
		return root;
	else
		return largestNode(root->right);
}
//****************************************************************************************************
									//PUBLIC LARGEST VALUE FUNCTION BELOW\\
//****************************************************************************************************
template <class DT>
DT binaryTree<DT>::largestValue()
{
	treeNode<DT> *p = largestNode(root);
	return p->info;
}
//****************************************************************************************************
#endif
