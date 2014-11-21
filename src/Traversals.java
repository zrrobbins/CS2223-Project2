/*
 * Class: CS2223 B01
 * Group: Zachary Robbins & Fiona Heaney
 * Project #2
 * Due: 11/24/14
 */

import java.io.*;
import java.util.*;

public class Traversals {
	
	
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

    }
    
    /*
     * - Takes as input an array purportedly representing the preorder traversal of some binary search tree T.
     * - Returns as output an array representing the postorder traversal of T.
     * - If the given input array cannot possibly be the preorder traversal of any binary search tree, write
     *   a message to that effect to standard output and return the empty array.
     */
    public static String[] search_pre_to_post(String[] tree) {
    	return new String[0];
    }
    
    
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
