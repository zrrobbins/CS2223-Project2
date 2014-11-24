Class: CS2223 B01
Group: Zachary Robbins & Fiona Heaney
Project #2
Due 11/24/14

PURPOSE :Represent the traversals of trees as arrays of strings using 3 different traversal methods. Users input one or two strings, a tree is built, and based on how many strings are input, different traversal methods are run. 

COMPILATION:
Compile using the command "javac *.java"

RUN:
Run using the command "java Launcher"

HOW TO USE: Users can input strings of max size 100, with characters seperated by a single space character, and terminated with a newline character. In the event only one string is to be entered, need 2 newline characters to execute. 

DESCRIPTION: 
preOrderTraverse, inOrderTraverse, and postOrderTraverse are 3 methods that iterate through a tree and print the nodes in the named order. 

buildBST takes a preordered traversal of a BST and builds the BST by iterating through the tree to find the root of each branch by looking for next elt greater than root and recursively building the left and right branch of the root.

buildBTPreIn takes a preordered traversal and a inorder traversal of a binary tree and builds the original tree by iterating through tree to find the root of each branch by looking for next available elt in preordered list in inordered list and making subtrees from the right and left values of these. 

buildBTPrePost takes a preordered and postordered traversal and returns the original binary tree by iterating through preordered tree and equal elt in postordered array, then create left and right subtrees from remainder of postordered traversal. This method does not currently work, as it can properly print the first three elements of the original binary tree, but then repeats elements due to crossed indexes. 


