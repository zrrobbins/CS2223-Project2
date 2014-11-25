/*
 * Class: CS2223 B01
 * Group: Zachary Robbins & Fiona Heaney
 * Project #2
 * Due: 11/24/14
 */

import java.io.*;
import java.util.*;

public class Traversals {
	
	private static int index = 0;
	
    public static void getInput() throws IOException{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String[] traversal1 = new String[100];
    	String[] traversal2 = new String[100];
        boolean readAtLeastOneLine = false;
        boolean readTwoLines = false;
        
        System.out.println("Enter 1 or 2 binary trees, where each node is separated by a space,"
        		+ " and each tree is separated by a new line:");

        // whitespace will separate our strings in a given input line
        // this doesn't work for leading/trailing whitespace, so we use trim() below.
        String delims = "[ ]+";

        String s1 = (in.readLine()).trim();
        if  (s1 != null && s1.length() != 0) {
           traversal1 = s1.split(delims);
            readAtLeastOneLine = true;
        }
        /* at this point the first line of input has been read into an array of Strings, namely 
           traversal1 */

        String s2 = (in.readLine()).trim();
        if  (s2 != null && s2.length() != 0) {
           traversal2 = s2.split(delims);
            readTwoLines = true;
        }

        /* at this point one or two lines of input have been read into an array or two of Strings, namely 
           traversal1  and traversal2.  The boolean variables readAtLeastOneLine and readTwoLines
           capture how much was read.
        */

        
        /* Testing */
        System.out.println(readAtLeastOneLine);            
        if (readAtLeastOneLine && !readTwoLines) {
            System.out.println("traversal1 length was : " + traversal1.length);
            System.out.println("search_pre_to_post:");
            search_pre_to_post(traversal1);
        }

        System.out.println(readTwoLines);            
        if (readTwoLines) {
        	System.out.println("traversal1 length was : " + traversal1.length);
            System.out.println("traversal2 length was : " + traversal2.length);
            System.out.println("pre_in_to_post:");
            pre_in_to_post(traversal1, traversal2);
            System.out.println("pre_post_to_in:");
            pre_post_to_in(traversal1, traversal2);
        }

    }
    
    // Prints out the preorder traversal of a tree
    public static void preOrderTraverse(TreeNode node) {
    	if (node != null) {
    		System.out.print(node.getData() + " ");
    		preOrderTraverse(node.getLeft());
    		preOrderTraverse(node.getRight());
    	}
    }
    
    // Prints out the inorder traversal of a tree
    public static void inOrderTraverse(TreeNode node) {
    	if (node != null) {
    		preOrderTraverse(node.getLeft());
    		System.out.print(node.getData() + " ");
    		preOrderTraverse(node.getRight());
    	}
    }
    	
    // Prints out the postorder traversal of a tree
    public static void postOrderTraverse(TreeNode node) {
    	if (node != null) {
    		postOrderTraverse(node.getLeft());
    		postOrderTraverse(node.getRight());
    		System.out.print(node.getData() + " ");
    	}
    }
   
    // Takes a list that represents the preorder traversal of a BST, and builds the BST
    public static TreeNode buildBST(String[] list, int listLength, int low, int high) {
    	int i;
    	
    	if (index >= listLength)
    		return null;
    	
    	TreeNode root = new TreeNode(list[low]);
    	index++;
    	
    	// If the current subarray is only one element, return root
    	if (low == high) {
    		return root;
    	}
    	
    	// Find first element greater than root element
    	// This indicates where the dividing line is between the data of a left and right branch
    	for(i = low; i <= high; i++) {
    		if (list[i].compareTo(list[low]) > 0)
    			break;
    	}
    	
    	// Recurse through left branch
    	if (low + 1 <= i - 1)
    		root.setLeft(buildBST(list, listLength, low + 1, i - 1));
    	
    	// Recurse through right branch
    	if (i <= high)
    		root.setRight(buildBST(list, listLength, i, high));
    	
    	return root;
    }
    
    // Takes a tree root and passes data to validBST to determine if the tree is indeed a valid BST
    public static boolean isValidBST(TreeNode node) {
    	String minString = " ";
    	String maxString = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    	return validBST(node, minString, maxString);
    }
    
    // Takes a tree root, a minimum and maximum to compare to, and determines recursively if the tree is valid BST
    public static boolean validBST(TreeNode node, String min, String max) 
    {
         if(node == null)
             return true;
         if(node.getData().compareTo(min) > 0 && node.getData().compareTo(max) < 0
        	 && validBST(node.getLeft(), min, node.getData())
             && validBST(node.getRight(), node.getData(), max))
             return true;
         else 
             return false;
    }
    
    // Takes a tree root, and recursively determines if the tree is a valid full tree
    public static boolean isFullBT(TreeNode node) {
    	if (node.getLeft() == null && node.getRight() == null)
    		return true;
    	if (node.getLeft() != null && node.getRight() != null
    			&& isFullBT(node.getLeft()) && isFullBT(node.getRight()))
    		return true;
    	else
    		return false;
    }
    
    /*
     * - Takes as input an array purportedly representing the preorder traversal of some binary search tree T.
     * - Returns as output an array representing the postorder traversal of T.
     * - If the given input array cannot possibly be the preorder traversal of any binary search tree, write
     *   a message to that effect to standard output and return the empty array.
     */
    public static void search_pre_to_post(String[] pre) {
    	
    	// Build BST from its preorder traversal
    	TreeNode root = buildBST(pre, pre.length, 0, pre.length - 1);
    	
    	// Check to see if the constructed tree is a valid BST
    	if (isValidBST(root))
    		System.out.println("The tree constructed is a valid BST");
    	else
    		System.out.println("The tree constructed is NOT a valid BST");
    	
    	// Use a post order traversal and print out results to STDIN
    	postOrderTraverse(root);
    }
    
    /*
     * - Takes as input two arrays, representing the preorder traversal and inorder traversal (in that order)
     *   of some full binary tree T.
     * - Returns as output an array representing the postorder traversal of T.
     * - If the given input arrays cannot possibly be the preorder and inorder traversals of any full binary
     *   tree, write a message to that effect to standard output and return the empty array
     */
    public static void pre_in_to_post(String[] tree1, String[] tree2) {
    	if (tree1.length != tree2.length) {
    		System.out.println("Input is NOT a valid full tree");
    		return;
    	}
    	TreeNode root = bTPreIn(tree1, tree2);
    	if (isFullBT(root)) {
    		System.out.println("Input is a valid full tree");
    		postOrderTraverse(root);
    	}
    	else
    		System.out.println("Input is NOT a valid full tree");
    }
    
    // Takes in a preorder traversal and an inorder traversal, and uses a helper function to recursively rebuild the original full binary tree
    public static TreeNode bTPreIn(String[] pre, String[] in) {
    	return buildBTPreIn(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    // Recursively builds original full binary tree from given preorder and inorder traversal lists
    public static TreeNode buildBTPreIn(String[] pre, int preStrt, int preEnd, String[] in, int inStart, int inEnd){
    	if(inStart > inEnd)
    		return null;
    	
    	String root = pre[preStrt];
    	
    	int root_ind = 0;
    	int i;
    	for(i = inStart; i <= inEnd; i++) {
    		if(in[i].compareTo(root) == 0) {
    			root_ind = i;
    			break;
    		}
    	}

    	int length = i - inStart;
    	TreeNode newRoot = new TreeNode(root);
    	newRoot.setLeft(buildBTPreIn(pre, preStrt+1, preStrt+length, in, inStart, i-1));
    	newRoot.setRight(buildBTPreIn(pre, preStrt+length+1, preEnd, in, i+1, inEnd));

    	return newRoot;
    }

    
    /*
     * - Takes as input two arrays, representing the preorder traversal and postorder traversal (in that
     *   order) of some full binary tree T.
     * - Returns as output an array representing the inorder traversal of T.
     * - If the given input arrays cannot possibly be the preorder and postorder traversals of any full
     *   binary tree, write a message to that effect to standard output and return the empty array.
     */
    public static void pre_post_to_in(String[] tree1, String[] tree2) {
    	index = 0;
    	// Build a tree out of its preorder and postorder traversals
    	TreeNode root = buildBTPrePost(tree1, tree2, 0, tree1.length - 1);
    	
    	// Use in order traversal to print out created tree
    	preOrderTraverse(root);
    	System.out.println();
    	
    	postOrderTraverse(root);
    	System.out.println();
    	
    	inOrderTraverse(root);
    }

    
    //Takes a preordered and postordered traversal and returns the binary tree
    //preIndex = index used in preOrdered traversal
    //l and h are used as high and low pointers in postOrdered traversal
    
    /*
    public static TreeNode buildBTPrePost( String[] preTree, String[] postTree, int preIndex,int low, int high, int size)
    {
    	if(pIndex > size || startSub > high)
    		return null;
    	
    	//make 1st preorder value root
    	TreeNode root = new TreeNode(preTree[pIndex]);
    	preIndex++;
    	
    	//check for single elt array
    	if (startSub == high)
    		return root;
    	
    	//search for next elt of pre in post
    	int i;
    	for(i = startSub; i<= high; i++){
    		if(preTree[pIndex] == postTree[i])
    			break;
    	}
    	
    	//divide postArray into left and right subtrees
    	if(i <= high)
    	{
    		root.setLeft(buildBTPrePost(preTree, postTree, pIndex, startSub, i, size));
    		root.setRight(buildBTPrePost(preTree, postTree, pIndex, i+1, high, size));
    	}
    	
    	return root;
    	
    }
    */
    
 
    public static TreeNode buildBTPrePost(String[] pre, String[] post, int low, int high) {
    	
    	if (low >= high)
    		return null;
    	
    	int pre_root_pos = 0;
    	// If all elements have been visited, return null, otherwise increment index and continue
    	if (index >= pre.length)
    		return null;
    	else {
    		pre_root_pos = index;
    		index++;
    	}
    	
    	String root_val = pre[pre_root_pos];
    	
    	// Simple search for root_val in post[]
    	int i;
    	int post_root_pos = -1;
    	for (i = low; i <= high; i++) {
    		if (post[i].compareTo(root_val) == 0) {
    			post_root_pos = i;
    			break;
    		}		
    	}
    	
    	TreeNode newRoot = new TreeNode(root_val);
    	
    	// If value in pre was not found in range low->high in post, then it is not a child of previous caller
    	if (post_root_pos == -1)
    		return newRoot;
    	
    	System.out.println("post_root_pos = " + post_root_pos);
    	
    	// Check to see if there are any children for this node
    	// If so, recursively place them
    	// If not, or when done, return new root
    	
    	// Go left
    	System.out.println("calling left(" + low +", " + post_root_pos + ")");
    	newRoot.setLeft(buildBTPrePost(pre, post, low, post_root_pos));
    	
    	// Go right
    	System.out.println("calling right(" + post_root_pos +", " + high + ")");
    	newRoot.setRight(buildBTPrePost(pre, post, post_root_pos, high));
    	
    	return newRoot;
    	
    	/*
    	increment through every element one by one in pre
    		each time we get to an element in pre, we check to find its location in post
    		when in pre, we can assume that it is a root in pre, since the order of traversal for pre is root-left-right
    		since the order of post is left-right-root, if the current element from pre that we are about to
    		check is before what node the current function call is checking, then the new element is the child
    		of the current (at this point, check to see if it already has a left child, otherwise be left child)
    		
    		if the element we are about to check is after what the current function call is checking, exit function call
    		and go up to previous call and check again (since we are doing recursion)
    	
    	*/
    	
    }
}
