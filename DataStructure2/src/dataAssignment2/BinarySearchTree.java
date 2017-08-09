package dataAssignment2;

/*
 *  Java Program to Implement Binary Search Tree
 */
 
 import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
 
 /* Class BSTNode */
 class BSTNode
 {
     BSTNode left, right;
     int data;
 
     /* Constructor */
     public BSTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     /* Constructor */
     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     /* Function to set left node */
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     /* Function to set right node */ 
     public void setRight(BSTNode n)
     {
         right = n;
     }
     /* Function to get left node */
     public BSTNode getLeft()
     {
         return left;
     }
     /* Function to get right node */
     public BSTNode getRight()
     {
         return right;
     }
     /* Function to set data to node */
     public void setData(int d)
     {
         data = d;
     }
     /* Function to get data from node */
     public int getData()
     {
         return data;
     }     
 }
 
 /* Class BST */
 class BST
 {
     private BSTNode root;
 
     /* Constructor */
     public BST()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Functions to insert data */
     public void insert(int data)
     {
         root = insert(root, data);
     }
     /* Function to insert data recursively */
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     /* Functions to delete data */
     public void delete(int k)
     {
         if (isEmpty())
             System.out.println("Tree Empty");
         else if (search(k) == false)
             System.out.println("Sorry "+ k +" is not present");
         else
         {
             root = delete(root, k);
             //System.out.println(k+ " deleted from the tree");
         }
     }
     private BSTNode delete(BSTNode root, int k)
     {
         BSTNode p, p2, n;
         if (root.getData() == k)
         {
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (k < root.getData())
         {
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else
         {
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
     
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     
     /* Function to count number of nodes recursively */
     private int countNodes(BSTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     /* Functions to search for an element */
     public boolean search(int val)
     {
         return search(root, val);
     }
     /* Function to search for an element recursively */
     private boolean search(BSTNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(BSTNode r)
     {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }
     
     /* Functions to calculate The height */
     public int findHeight(){
    	    if(this.isEmpty()){
    	        return 0;
    	    }
    	    else{
    	        return findHeight(root);
    	    }
    	}
     private int findHeight(BSTNode r){
    	 int heightLeft = -1;
    	 int heightRight = -1;
    	 
    	 if(r.left!=null)
    		 heightLeft = findHeight(r.left);
    	    	
    	 if(r.right!=null)
    		 heightRight = findHeight(r.right);
    	    	
    	 if(heightLeft > heightRight){
    		 return heightLeft+1;
    		 
    	 }
    	 else{
    		 return heightRight+1;
    	 }
     }
 }
 
 /* Class BinarySearchTree */
 public class BinarySearchTree
 
 {

	 private static int z1= 240;
	 private static int z2= 500;
	 private static int z3= 780;
	 private static int z4= 2500;
	 private static int z5= 6400;
	 private static int z6= 8700;
	 private static int z7= 23000;
	 private static int z8= 33000;
	 private static int z9= 43500;
	 private static int z10= 35000;
	 private static int z11= 67000;
	 private static int z12= 83000;
	 private static int z13= 285000;
	 private static int z14= 610000;
	 private static int z15= 798000;
	 
	 private static int x1= 291;
	 private static int x2= 588;
	 private static int x3= 860;
	 private static int x4= 1888;
	 private static int x5= 6469;
	 private static int x6= 9448;
	 private static int x7= 11190;
	 private static int x8= 35905;
	 private static int x9= 49212;
	 private static int x10= 20493;
	 private static int x11= 49590;
	 private static int x12= 90938;
	 private static int x13= 268442;
	 private static int x14= 797498;
	 private static int x15= 914727;
	 
	 private static int c1= 110;
	 private static int c2= 208;
	 private static int c3= 992;
	 private static int c4= 6710;
	 private static int c5= 6250;
	 private static int c6= 9482;
	 private static int c7= 12612;
	 private static int c8= 18205;
	 private static int c9= 39257;
	 private static int c10= 54005;
	 private static int c11= 42004;
	 private static int c12= 79254;
	 private static int c13= 725290;
	 private static int c14= 577505;
	 private static int c15= 334033;
	 
	 
     public static void main(String[] args) throws FileNotFoundException
    {
    	 
    	 /* Creating objects of BST */

    	 BST bst1 = new BST();
    	 BST bst2 = new BST();
    	 BST bst3 = new BST();
    	 BST bst4 = new BST();
    	 BST bst5 = new BST();
    	 
    	 // for insert process
    	 BST bst1ins = new BST();
    	 BST bst2ins = new BST();
    	 BST bst3ins = new BST();
    	 BST bst4ins = new BST();
    	 BST bst5ins = new BST();
    	 
    	 // for Deletion process
    	 BST bst1del = new BST();
    	 BST bst2del = new BST();
    	 BST bst3del = new BST();
    	 BST bst4del = new BST();
    	 BST bst5del = new BST();
    	 
    	// for Searching process
    	 BST bst1sch = new BST();
    	 BST bst2sch = new BST();
    	 BST bst3sch = new BST();
    	 BST bst4sch = new BST();
    	 BST bst5sch = new BST();
    	 
    	 // Files
    	 File file1 = new File("1st-Dataset.txt");
 		 File file2 = new File("2nd-Dataset.txt");
 		 File file3 = new File("3rd-Dataset.txt");
 		 File file4 = new File("4th-Dataset.txt");
 		 File file5 = new File("5th-Dataset.txt");
 		 
 		 
 		 //Arrays
 		 int Array1[] = new int[1000];
 		 int Array2[] = new int[10000];
 		 int Array3[] = new int[50000];
 		 int Array4[] = new int[100000];
 		 int Array5[] = new int[1000000];
    	 
 		 //Fetch the elements from the file and save them into Array
 		 FileReader fr1 = new FileReader("1st-Dataset.txt");
 		 int i1 = 0;
 		 try{
 			 Scanner input = new Scanner(fr1);
 			 while (input.hasNext())
 			 {
 				 Array1[i1] = input.nextInt();
 				 i1++;
 			 }
 			 input.close();
 		 }
 		 catch(Exception e)
 		 {
 			 e.printStackTrace();
 		 }
 		
 		 
 		 FileReader fr2 = new FileReader("2nd-Dataset.txt");
 		 int i2 = 0;
 		 try{
 			 Scanner input = new Scanner(fr2);
 			 while (input.hasNext())
 			 {
 				 Array2[i2] = input.nextInt();
 				 i2++;
 			 }
 			 input.close();
 		 }
 		 catch(Exception e)
 		 {
 			 e.printStackTrace();
 		 }
 		 

 		FileReader fr3 = new FileReader("3rd-Dataset.txt");
 		 int i3 = 0;
 		 try{
 			 Scanner input = new Scanner(fr3);
 			 while (input.hasNext())
 			 {
 				 Array3[i3] = input.nextInt();
 				 i3++;
 			 }
 			 input.close();
 		 }
 		 catch(Exception e)
 		 {
 			 e.printStackTrace();
 		 }

 		 
 		 FileReader fr4 = new FileReader("4th-Dataset.txt");
 		 int i4 = 0;
 		 try{
 			 Scanner input = new Scanner(fr4);
 			 while (input.hasNext())
 			 {
 				 Array4[i4] = input.nextInt();
 				 i4++;
 			 }
 			 input.close();
 		 }
 		 catch(Exception e)
 		 {
 			 e.printStackTrace();
 		 }
 		
 		 
 		
 		 FileReader fr5 = new FileReader("5th-Dataset.txt");
 		 int i5 = 0;
 		 try{
 			 Scanner input = new Scanner(fr5);
 			 while (input.hasNext())
 			 {
 				 Array5[i5] = input.nextInt();
 				 i5++;
 			 }
 			 input.close();
 		 }
 		 catch(Exception e)
 		 {
 			 e.printStackTrace();
 		 } 
 		
 		 // Creation BST
 		 long BST1start = System.currentTimeMillis();
 		 for(int i = 0; i<Array1.length;i++){
 			 bst1.insert(Array1[i]);
 		 }
 		 long BST1end = System.currentTimeMillis();
 		 
 		 long BST2start = System.currentTimeMillis();
 		 for(int i = 0; i<Array2.length;i++){
 			 bst2.insert(Array2[i]);
 		 }
 		 long BST2end = System.currentTimeMillis();
	 	
 		 long BST3start = System.currentTimeMillis();
 		 for(int i = 0; i<Array3.length;i++){
 			 bst3.insert(Array3[i]);
 		 }
 		 long BST3end = System.currentTimeMillis();
	 	
 		 long BST4start = System.currentTimeMillis();
 		 for(int i = 0; i<Array4.length;i++){
 			 bst4.insert(Array4[i]);
 		 }
 		 long BST4end = System.currentTimeMillis();
	 	
 		 long BST5start = System.currentTimeMillis();
 		 for(int i = 0; i<Array5.length;i++){
 			 bst5.insert(Array5[i]);
 		 }
 		 long BST5end = System.currentTimeMillis();
	 	
 		 System.out.println("BST Creation...");
 		 System.out.println("The time for Creation BST 1 is: "+ (BST1end - BST1start)+ " ms");
 		 System.out.println("The time for Creation BST 2 is: "+ (BST2end - BST2start)+ " ms");
 		 System.out.println("The time for Creation BST 3 is: "+ (BST3end - BST3start)+ " ms");
 		 System.out.println("The time for Creation BST 4 is: "+ (BST4end - BST4start)+ " ms");
 		 System.out.println("The time for Creation BST 5 is: "+ (BST5end - BST5start)+ " ms");
    	
 		// 	Insertion Proceess
 		
 		bst1ins = bst1;
 		bst2ins = bst2;
 		bst3ins = bst3;
 		bst4ins = bst4;
 		bst5ins = bst5;
 		
 		// Deletion
 		bst1del = bst1;
 		bst2del = bst2;
 		bst3del = bst3;
 		bst4del = bst4;
 		bst5del = bst5;
 		
 		// searching
 		bst1sch = bst1;
 		bst2sch = bst2;
 		bst3sch = bst3;
 		bst4sch = bst4;
 		bst5sch = bst5;
 		
 		// Insertion Proceess
 		long BST1insst = System.nanoTime(); 
 		bst1ins.insert(z1);
 		bst1ins.insert(z2);
 		bst1ins.insert(z3);
 		long BST1insend = System.nanoTime();
 		
 		long BST2insst = System.nanoTime();
 		bst2ins.insert(z4);
 		bst2ins.insert(z5);
 		bst2ins.insert(z6);
 		long BST2insend = System.nanoTime();
 		
 		long BST3insst = System.nanoTime();
 		bst3ins.insert(z7);
 		bst3ins.insert(z8);
 		bst3ins.insert(z9);
 		long BST3insend = System.nanoTime();
 		
 		long BST4insst = System.nanoTime();
 		bst4ins.insert(z10);
 		bst4ins.insert(z11);
 		bst4ins.insert(z12);
 		long BST4insend = System.nanoTime();
 		
 		long BST5insst = System.nanoTime();
 		bst5ins.insert(z13);
 		bst5ins.insert(z14);
 		bst5ins.insert(z15);
 		long BST5insend = System.nanoTime();
 		
 		System.out.println("\nBST Insertion...");
 		System.out.println("The insertion time for BST 1 is : "+(BST1insend - BST1insst)+ " ns");
 		System.out.println("The insertion time for BST 2 is : "+(BST2insend - BST2insst)+ " ns");
 		System.out.println("The insertion time for BST 3 is : "+(BST3insend - BST3insst)+ " ns");
 		System.out.println("The insertion time for BST 4 is : "+(BST4insend - BST4insst)+ " ns");
 		System.out.println("The insertion time for BST 5 is : "+(BST5insend - BST5insst)+ " ns");
 		
 		
 		// Deletion
 		long BST1delst = System.nanoTime(); 
 		bst1del.delete(x1);
 		bst1del.delete(x2);
 		bst1del.delete(x3);
 		long BST1delend = System.nanoTime();
 		
 		long BST2delst = System.nanoTime();
 		bst2del.delete(x4);
 		bst2del.delete(x5);
 		bst2del.delete(x6);
 		long BST2delend = System.nanoTime();
 		
 		long BST3delst = System.nanoTime();
 		bst3del.delete(x7);
 		bst3del.delete(x8);
 		bst3del.delete(x9);
 		long BST3delend = System.nanoTime();
 		
 		long BST4delst = System.nanoTime();
 		bst4del.delete(x10);
 		bst4del.delete(x11);
 		bst4del.delete(x12);
 		long BST4delend = System.nanoTime();
 		
 		long BST5delst = System.nanoTime();
 		bst5del.delete(x13);
 		bst5del.delete(x14);
 		bst5del.delete(x15);
 		long BST5delend = System.nanoTime();
 		
 		System.out.println("\nBST Deletion...");
 		System.out.println("The Deletion time for BST 1 is: "+ (BST1delend - BST1delst)+" ns");
 		System.out.println("The Deletion time for BST 2 is: "+ (BST2delend - BST2delst)+" ns");
 		System.out.println("The Deletion time for BST 3 is: "+ (BST3delend - BST3delst)+" ns");
 		System.out.println("The Deletion time for BST 4 is: "+ (BST4delend - BST4delst)+" ns");
 		System.out.println("The Deletion time for BST 5 is: "+ (BST5delend - BST5delst)+" ns");
 		
 		// Search Process
 		
 		long BST1schst = System.nanoTime();
 		bst1sch.search(c1);
 		bst1sch.search(c2);
 		bst1sch.search(c3);
 		long BST1schend = System.nanoTime();
 		
 		long BST2schst = System.nanoTime();
 		bst2sch.search(c4);
 		bst2sch.search(c5);
 		bst2sch.search(c6);
 		long BST2schend = System.nanoTime();
 		
 		long BST3schst = System.nanoTime();
 		bst3sch.search(c7);
 		bst3sch.search(c8);
 		bst3sch.search(c9);
 		long BST3schend = System.nanoTime();
 		
 		long BST4schst = System.nanoTime();
 		bst4sch.search(c10);
 		bst4sch.search(c11);
 		bst4sch.search(c12);
 		long BST4schend = System.nanoTime();
 		
 		long BST5schst = System.nanoTime();
 		bst5sch.search(c13);
 		bst5sch.search(c14);
 		bst5sch.search(c15);
 		long BST5schend = System.nanoTime();
 		
 		System.out.println("\nBST Searching...");
 		System.out.println("The Searching time for BST 1 is:"+(BST1schend - BST1schst)+" ns");
 		System.out.println("The Searching time for BST 2 is:"+(BST2schend - BST2schst)+" ns");
 		System.out.println("The Searching time for BST 3 is:"+(BST3schend - BST3schst)+" ns");
 		System.out.println("The Searching time for BST 4 is:"+(BST4schend - BST4schst)+" ns");
 		System.out.println("The Searching time for BST 5 is:"+(BST5schend - BST5schst)+" ns");

    	 
    	 System.out.println("\nBST1 height is: "+bst1.findHeight());
    	 System.out.println("BST2 height is: "+bst2.findHeight());
    	 System.out.println("BST3 height is: "+bst3.findHeight());
    	 System.out.println("BST4 height is: "+bst4.findHeight());
    	 System.out.println("BST5 height is: "+bst5.findHeight());
    	 
    	 
    }
 }