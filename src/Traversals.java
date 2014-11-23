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
        if  (s1 !=null && s1.length() != 0) {
           traversal1 = s1.split(delims);
            readAtLeastOneLine = true;
        }
        /* at this point the first line of input has been read into an array of Strings, namely 
           traversal1 */

        String s2 = (in.readLine()).trim();
        if  (s2 !=null && s2.length() != 0) {
           traversal2 = s2.split(delims);
            readTwoLines = true;
        }

        /* at this point one or two lines of input have been read into an array or two of Strings, namely 
           traversal1  and traversal2.  The boolean variables readAtLeastOneLine and readTwoLines
           capture how much was read.
        */

        
        /* Testing */
        System.out.println(readAtLeastOneLine);            
        if (readAtLeastOneLine)
            System.out.println("traversal1 length was : " + traversal1.length);

        System.out.println(readTwoLines);            
        if (readTwoLines)
            System.out.println("traversal2 length was : " + traversal2.length);
        
        System.out.println("search_pre_to_post:");
        search_pre_to_post(traversal1);

    }
    
    /*
     * - Takes as input an array purportedly representing the preorder traversal of some binary search tree T.
     * - Returns as output an array representing the postorder traversal of T.
     * - If the given input array cannot possibly be the preorder traversal of any binary search tree, write
     *   a message to that effect to standard output and return the empty array.
     */
    public static void search_pre_to_post(String[] pre) {
    	/*
    	String root = pre[0]; // get root of tree
    	String[] leftBranch = getLeftBranch(pre); //get left branch of tree
		System.out.println("leftBranch.length = " + leftBranch.length);
    	String[] rightBranch = getRightBranch(pre, leftBranch.length); // get right branch of tree
    	
    	// Traverse left branch
    	if (leftBranch.length != 0) {
    		System.out.println("leftBranch.length = " + leftBranch.length);
    		System.out.println("Left branch exists");
    		search_pre_to_post(leftBranch);
    	}
    	
    	// Traverse right branch
    	if (rightBranch.length != 0) {
    		System.out.println("rightBranch.length = " + rightBranch.length);
    		System.out.println("Right branch exists");
    		search_pre_to_post(rightBranch);
    	}
    	
    	// Print root
    	System.out.print(root + " ");
    	*/
    	//TreeNode root = buildBST(pre, pre.length, " ", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	TreeNode root = buildBST(pre, pre.length, 0, pre.length - 1);
    	preOrderTraverse(root);
    	System.out.println();
    	inOrderTraverse(root);
    	System.out.println();
    	postOrderTraverse(root);
    	
    }
    
    
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
    	else if (low > high){
    		return null;//new TreeNode(list[low-1]);
    	}
    	
    	// Find first element greater than root element
    	// This indicates where the dividing line is between the data of a left and right branch
    	for(i = low; i <= high; i++) {
    		if (list[i].compareTo(list[low]) > 0)
    		{
    			break;
    		}
    		
    	}
    	
    	// Recurse through left branch
    	root.setLeft(buildBST(list, listLength, low + 1, i - 1));
    	
    	// Recurse through right branch
    	root.setRight(buildBST(list, listLength, i, high));
    	
    	return root;
    }
    
    
    /*
    public static TreeNode buildBST(String[] list, int length, String min, String max) {
	        
		if (index >= length) {
	        return null;
	    }
	    
	    TreeNode root = null;
	    
	    String thisNode = list[index];
	    
	    if (thisNode.compareTo(min) > 0 && thisNode.compareTo(max) < 0) {
	        root = new TreeNode(thisNode);
	        index++;
	        
	        if (index < length) {
	            root.setLeft(buildBST(list, length, min, thisNode));
	        }
	        
	        if (index < length) {
	            root.setRight(buildBST(list, length, thisNode, max));
	        }
	    }
	    
	    return root;
	}
	*/
    /*
    public static TreeNode buildBST(TreeNode current, String[] list, int i, int largest)
    {
        if (i == list.length) 
        	return i;

        // recurse left
        if (list[i].compareTo(current.getData()) > 0)
        {
          current.getLeft() = new node(arr[i++]);
          i = buildBST(current.getLeft(), list, i, current.getData());
        }

        // recurse right
        if (i < arr.length && arr[i] < largest)
        {
          current.right = new node(arr[i++]);
          i = buildbst(current.right, arr, i, largest);
        }

        return i;
    }*/
    
    public static void preOrderTraverse(TreeNode node) {
    	if (node == null)
    		return;
    	System.out.print(node.getData() + " ");
    	preOrderTraverse(node.getLeft());
    	preOrderTraverse(node.getRight());
    }
    
    public static void inOrderTraverse(TreeNode n)
    {
     if (n != null)
     {
      inOrderTraverse(n.getLeft());
      System.out.print(n.getData() + " ");
      inOrderTraverse(n.getRight());
     }
    }
    	
    public static void postOrderTraverse(TreeNode node)
    {
    	if (node != null) {
    		postOrderTraverse(node.getLeft());
    		postOrderTraverse(node.getRight());
    		System.out.print(node.getData() + " ");
    	}
    }
    /*
    public static void postOrderTraverse(TreeNode node) {
    	if (node == null)
    		return;
    	postOrderTraverse(node.getLeft());
    	postOrderTraverse(node.getRight());
    	System.out.print(node.getData() + " ");
    }
    */
    /*
    public static String[] getLeftBranch(String[] tree) {
    	int junk = 0;
    	int i, j, k;
    	for (i = 0, j = 0; tree[i].compareTo(tree[0]) <= 0; i++, j++) {} // Find length of left branch
    	String[] lBranch = new String[j];
    	if (lBranch.length == 0)
    		return lBranch;
    	for (j = 0, k = 0; j < i; j++, k++)   //Construct left branch array
    		lBranch[k] = tree[j+1];
    	return lBranch;
    }
    
    public static String[] getRightBranch(String[] tree, int lBLength) {
    	int junk = 0;
    	int i, j, k;
    	for (i = lBLength, j = 0; tree[i].compareTo(tree[lBLength]) <= 0; i++, j++) {} // Find length of right branch
    	String[] rBranch = new String[j];
    	if (rBranch.length == 0)
    		return rBranch;
    	for (j = lBLength, k = 0; j < i; j++, k++)   // Construct right branch array
    		rBranch[k] = tree[j+1];
    	return rBranch;
    }
    */
    
    /*
     * - Takes as input two arrays, representing the preorder traversal and inorder traversal (in that order)
     *   of some full binary tree T.
     * - Returns as output an array representing the postorder traversal of T.
     * - If the given input arrays cannot possibly be the preorder and inorder traversals of any full binary
     *   tree, write a message to that effect to standard output and return the empty array
     */
    public static String[] pre_in_to_post(String[] tree1, String[] tree2) {
    	return new String[0];
    }
    
    
    /*
     * - Takes as input two arrays, representing the preorder traversal and postorder traversal (in that
     *   order) of some full binary tree T.
     * - Returns as output an array representing the inorder traversal of T.
     * - If the given input arrays cannot possibly be the preorder and postorder traversals of any full
     *   binary tree, write a message to that effect to standard output and return the empty array.
     */
    public static String[] pre_post_to_in(String[] tree1, String[] tree2) {
    	return new String[0];
    }
}
