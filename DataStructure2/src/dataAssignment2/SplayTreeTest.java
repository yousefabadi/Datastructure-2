package dataAssignment2;

/**
 *  Java Program to Implement SplayTree
 **///
 
 import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;
 
 /** Class Node **/
 class SplayNode
 {    
     SplayNode left, right, parent;
     int element;
 
     /** Constructor **/
     public SplayNode()
     {
         this(0, null, null, null);
     }          
     /** Constructor **/
     public SplayNode(int ele)
     {
         this(ele, null, null, null);
     } 
     /** Constructor **/
     public SplayNode(int ele, SplayNode left, SplayNode right, SplayNode parent)
     {
         this.left = left;
         this.right = right;
         this.parent = parent;
         this.element = ele;         
     }    
 }
 
 /** Class SplayTree **/
 class SplayTree
 {
     private SplayNode root;
     private int count = 0;
 
     /** Constructor **/
     public SplayTree()
     {
         root = null;
     }
 
     /** Function to check if tree is empty **/
     public boolean isEmpty()
     {
         return root == null;
     }
 
     /** clear tree **/
     public void clear()
     {
         root = null;
     }
 
     /** function to insert element */
     public void insert(int ele)
     {
         SplayNode z = root;
         SplayNode p = null;
         while (z != null)
         {
             p = z;
             if (ele < p.element)
                 z = z.right;
             else
                 z = z.left;
         }
         z = new SplayNode();
         z.element = ele;
         z.parent = p;
         if (p == null)
             root = z;
         else if (ele < p.element)
             p.right = z;
         else
             p.left = z;
         Splay(z);
         count++;
     }
     /** rotate **/
     public void makeLeftChildParent(SplayNode c, SplayNode p)
     {
         if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
             throw new RuntimeException("WRONG");
 
         if (p.parent != null)
         {
             if (p == p.parent.left)
                 p.parent.left = c;
             else 
                 p.parent.right = c;
         }
         if (c.right != null)
             c.right.parent = p;
 
         c.parent = p.parent;
         p.parent = c;
         p.left = c.right;
         c.right = p;
     }
 
     /** rotate **/
     public void makeRightChildParent(SplayNode c, SplayNode p)
     {
         if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
             throw new RuntimeException("WRONG");
         if (p.parent != null)
         {
             if (p == p.parent.left)
                 p.parent.left = c;
             else
                 p.parent.right = c;
         }
         if (c.left != null)
             c.left.parent = p;
         c.parent = p.parent;
         p.parent = c;
         p.right = c.left;
         c.left = p;
     }
 
     /** function splay **/
     private void Splay(SplayNode x)
     {
         while (x.parent != null)
         {
             SplayNode Parent = x.parent;
             SplayNode GrandParent = Parent.parent;
             if (GrandParent == null)
             {
                 if (x == Parent.left)
                     makeLeftChildParent(x, Parent);
                 else
                     makeRightChildParent(x, Parent);                 
             } 
             else
             {
                 if (x == Parent.left)
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeLeftChildParent(Parent, GrandParent);
                         makeLeftChildParent(x, Parent);
                     }
                     else 
                     {
                         makeLeftChildParent(x, x.parent);
                         makeRightChildParent(x, x.parent);
                     }
                 }
                 else 
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeRightChildParent(x, x.parent);
                         makeLeftChildParent(x, x.parent);
                     } 
                     else 
                     {
                         makeRightChildParent(Parent, GrandParent);
                         makeRightChildParent(x, Parent);
                     }
                 }
             }
         }
         root = x;
     }
 
     /** function to remove element **/
     public void remove(int ele)
     {
         SplayNode node = findNode(ele);
        remove(node);
     }
 
     /** function to remove node **/
     private void remove(SplayNode node)
     {
         if (node == null)
             return;
 
         Splay(node);
         if( (node.left != null) && (node.right !=null))
         { 
             SplayNode min = node.left;
             while(min.right!=null)
                 min = min.right;
 
             min.right = node.right;
             node.right.parent = min;
             node.left.parent = null;
             root = node.left;
         }
         else if (node.right != null)
         {
             node.right.parent = null;
             root = node.right;
         } 
         else if( node.left !=null)
         {
             node.left.parent = null;
             root = node.left;
         }
         else
         {
             root = null;
         }
         node.parent = null;
         node.left = null;
         node.right = null;
         node = null;
         count--;
     }
 
     /** Functions to count number of nodes **/
     public int countNodes()
     {
         return count;
     }
 
     /** Functions to search for an element **/
     public boolean search(int val)
     {
         return findNode(val) != null;
     }
     private SplayNode findNode(int ele)
     {
         SplayNode z = root;
         while (z != null)
         {
             if (ele < z.element)
                 z = z.right;
             else if (ele > z.element)
                 z = z.left;
             else
                 return z;
         }
         return null;
     }
 
     /** Function for inorder traversal **/ 
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(SplayNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.element +" ");
             inorder(r.right);
         }
     }
 
     /** Function for preorder traversal **/
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(SplayNode r)
     {
         if (r != null)
         {
             System.out.print(r.element +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
 
     /** Function for postorder traversal **/
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(SplayNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.element +" ");
         }
     } 
     public int height() 
     { 
    	 return height(root); 
     }
     
     private int height (SplayNode x) {
         if (x == null) return -1;
         return 1 + Math.max(height(x.left), height(x.right));
     }
     
     public int theRootis (){
    	 return root.element;
     }
 }
 
 /** Class SplayTreeTest **/
 public class SplayTreeTest
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
  	
    	/* Creating objects of SplayTree */
    	SplayTree spt1 = new SplayTree();
    	SplayTree spt2 = new SplayTree();
    	SplayTree spt3 = new SplayTree();
    	SplayTree spt4 = new SplayTree();
    	SplayTree spt5 = new SplayTree();
    	
    	
	    // for insert process
    	SplayTree spt1ins = new SplayTree();
    	SplayTree spt2ins = new SplayTree();
    	SplayTree spt3ins = new SplayTree();
    	SplayTree spt4ins = new SplayTree();
    	SplayTree spt5ins = new SplayTree();
    	
    	// for Deletion process
    	SplayTree spt1del = new SplayTree();
    	SplayTree spt2del = new SplayTree();
    	SplayTree spt3del = new SplayTree();
    	SplayTree spt4del = new SplayTree();
    	SplayTree spt5del = new SplayTree();
    	
    	// for searching process
    	SplayTree spt1sch = new SplayTree();
    	SplayTree spt2sch = new SplayTree();
    	SplayTree spt3sch = new SplayTree();
    	SplayTree spt4sch = new SplayTree();
    	SplayTree spt5sch = new SplayTree();
    	
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
		 
		 // Creation SplayTree
		 
		 long spt1insstart = System.currentTimeMillis();
		 for(int a :Array1){
			 spt1.insert(a);
		 }
		 long spt1insend = System.currentTimeMillis();
		 
		 long spt2insstart = System.currentTimeMillis();
		 for(int a :Array2){
			 spt2.insert(a);
		 }
		 long spt2insend = System.currentTimeMillis();
		 
		 long spt3insstart = System.currentTimeMillis();
		 for(int a :Array3){
			 spt3.insert(a);
		 }
		 long spt3insend = System.currentTimeMillis();
		 
		 long spt4insstart = System.currentTimeMillis();
		 for(int i = 0; i<Array4.length;i++){
			 spt4.insert(Array4[i]);
		 }
		 long spt4insend = System.currentTimeMillis();
		 
		 long spt5insstart = System.currentTimeMillis();
		 for(int a :Array5){
			 spt5.insert(a);
		 }
		 long spt5insend = System.currentTimeMillis();
		 
		 
		 
		 System.out.println("Splay Tree Creation...");
		 System.out.println("The time for creation Splay Tree 1 is: "+ (spt1insend - spt1insstart)+" ms");
		 System.out.println("The time for creation Splay Tree 2 is: "+ (spt2insend - spt2insstart)+" ms");
		 System.out.println("The time for creation Splay Tree 3 is: "+ (spt3insend - spt3insstart)+" ms");
		 System.out.println("The time for creation Splay Tree 4 is: "+ (spt4insend - spt4insstart)+" ms");
		 System.out.println("The time for creation Splay Tree 5 is: "+ (spt5insend - spt5insstart)+" ms");
		 
		 //Insertion Proceess
		 spt1ins = spt1;
		 spt2ins = spt2;
		 spt3ins = spt3;
		 spt4ins = spt4;
		 spt5ins = spt5;
		 
		 // Deletion process
		 spt1del = spt1;
		 spt2del = spt2;
		 spt3del = spt3;
		 spt4del = spt4;
		 spt5del = spt5;
		 
		 // Searching process
		 spt1sch = spt1;
		 spt2sch = spt2;
		 spt3sch = spt3;
		 spt4sch = spt4;
		 spt5sch = spt5;
	 		
		//Insertion Proceess
		 long SPT1insst = System.nanoTime(); 
		 spt1ins.insert(z1);
		 spt1ins.insert(z2);
		 spt1ins.insert(z3);
		 long SPT1insend = System.nanoTime();
		 
		 long SPT2insst = System.nanoTime();
		 spt2ins.insert(z4);
		 spt2ins.insert(z5);
		 spt2ins.insert(z6);
		 long SPT2insend = System.nanoTime();
		 
		 long SPT3insst = System.nanoTime();
		 spt3ins.insert(z7);
		 spt3ins.insert(z8);
		 spt3ins.insert(z9);
		 long SPT3insend = System.nanoTime();
		 
		 long SPT4insst = System.nanoTime();
		 spt4ins.insert(z10);
		 spt4ins.insert(z11);
		 spt4ins.insert(z12);
		 long SPT4insend = System.nanoTime();
		 
		 long SPT5insst = System.nanoTime();
		 spt5ins.insert(z13);
		 spt5ins.insert(z14);
		 spt5ins.insert(z15);
		 long SPT5insend = System.nanoTime();
		 
		 System.out.println("\nSplay Tree Insertion...");
		 System.out.println("The insertion time for Splay Tree 1 is : "+(SPT1insend - SPT1insst)+ " ns");
		 System.out.println("The insertion time for Splay Tree 2 is : "+(SPT2insend - SPT2insst)+ " ns");
		 System.out.println("The insertion time for Splay Tree 3 is : "+(SPT3insend - SPT3insst)+ " ns");
		 System.out.println("The insertion time for Splay Tree 4 is : "+(SPT4insend - SPT4insst)+ " ns");
		 System.out.println("The insertion time for Splay Tree 5 is : "+(SPT5insend - SPT5insst)+ " ns");
		 
		
		 // Deletion process	
		 long SPT1delst = System.nanoTime(); 
		 spt1del.remove(x1);
		 spt1del.remove(x2);
		 spt1del.remove(x3);
		 long SPT1delend = System.nanoTime();
	 		
		 long SPT2delst = System.nanoTime();
		 spt2del.remove(x4);
		 spt2del.remove(x5);
		 spt2del.remove(x6);
		 long SPT2delend = System.nanoTime();
		 
		 long SPT3delst = System.nanoTime();
		 spt3del.remove(x7);
		 spt3del.remove(x8);
		 spt3del.remove(x9);
		 long SPT3delend = System.nanoTime();
		 
		 long SPT4delst = System.nanoTime();
		 spt4del.remove(x10);
		 spt4del.remove(x11);
		 spt4del.remove(x12);
		 long SPT4delend = System.nanoTime();
	 		
		 long SPT5delst = System.nanoTime();
		 spt5del.remove(x13);
		 spt5del.remove(x14);
		 spt5del.remove(x15);
		 long SPT5delend = System.nanoTime();
		 
		 System.out.println("\nSplay Tree Deletion...");
		 System.out.println("The Deletion time for Splay Tree 1 is: "+ (SPT1delend - SPT1delst)+" ns");
		 System.out.println("The Deletion time for Splay Tree 2 is: "+ (SPT2delend - SPT2delst)+" ns");
		 System.out.println("The Deletion time for Splay Tree 3 is: "+ (SPT3delend - SPT3delst)+" ns");
		 System.out.println("The Deletion time for Splay Tree 4 is: "+ (SPT4delend - SPT4delst)+" ns");
		 System.out.println("The Deletion time for Splay Tree 5 is: "+ (SPT5delend - SPT5delst)+" ns");
		 	
		 // Search Process
	 		
		 long SPT1schst = System.nanoTime();
		 spt1sch.search(c1);
		 spt1sch.search(c2);
		 spt1sch.search(c3);
		 long SPT1schend = System.nanoTime();
		 
		 long SPT2schst = System.nanoTime();
		 spt2sch.search(c4);
		 spt2sch.search(c5);
		 spt2sch.search(c6);
		 long SPT2schend = System.nanoTime();
		 
		 long SPT3schst = System.nanoTime();
		 spt3sch.search(c7);
		 spt3sch.search(c8);
		 spt3sch.search(c9);
		 long SPT3schend = System.nanoTime();
		 
		 long SPT4schst = System.nanoTime();
		 spt4sch.search(c10);
		 spt4sch.search(c11);
		 spt4sch.search(c12);
		 long SPT4schend = System.nanoTime();
		 
		 long SPT5schst = System.nanoTime();
		 spt5sch.search(c13);
		 spt5sch.search(c14);
		 spt5sch.search(c15);
		 long SPT5schend = System.nanoTime();
		 
		 System.out.println("\nSplay Tree Searching...");
		 System.out.println("The Searching time for Splay Tree 1 is:"+(SPT1schend - SPT1schst)+" ns");
		 System.out.println("The Searching time for Splay Tree 2 is:"+(SPT2schend - SPT2schst)+" ns");
		 System.out.println("The Searching time for Splay Tree 3 is:"+(SPT3schend - SPT3schst)+" ns");
		 System.out.println("The Searching time for Splay Tree 4 is:"+(SPT4schend - SPT4schst)+" ns");
		 System.out.println("The Searching time for Splay Tree 5 is:"+(SPT5schend - SPT5schst)+" ns");
		 
		 // height 
		 System.out.println("\nHeight...");
		 System.out.println("The height for the Splay Tree 1 is: "+spt1.height());
		 System.out.println("The height for the Splay Tree 2 is: "+spt2.height());
		 System.out.println("The height for the Splay Tree 3 is: "+spt3.height());
		 System.out.println("The height for the Splay Tree 4 is: "+spt4.height());
		 System.out.println("The height for the Splay Tree 5 is: "+spt5.height());
		 
    }	
}	