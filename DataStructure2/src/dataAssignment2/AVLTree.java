package dataAssignment2;

	
	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

	

	public class AVLTree {
		
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

	    private static class Node {
	        Node left, right;
	        Node parent;
	        int value ;
	        int height = 0;

	        public Node(int data, Node parent) {
	            this.value = data;
	            this.parent = parent;
	        }

	        @Override
	        public String toString() {
	        	return value + " height " + height;
	        }

	        void setLeftChild(Node child) {
	            if (child != null) {
	                child.parent = this;
	            }

	            this.left = child;
	        }

	        void setRightChild(Node child) {
	            if (child != null) {
	                child.parent = this;
	            }

	            this.right = child;
	        }
	    }

	    private Node root = null;

	    public void insert(int data) {
	        insert(root, data);
	    }

	    private int height(Node node) {
	        return node == null ? -1 : node.height;
	    }

	    private void insert(Node node, int value) {
	        if (root == null) {
	            root = new Node(value, null);
	            return;
	        }

	        if (value < node.value) {
	            if (node.left != null) {
	                insert(node.left, value);
	            } else {
	                node.left = new Node(value, node);
	            }

	            if (height(node.left) - height(node.right) == 2) { //left heavier
	                if (value < node.left.value) {
	                    rotateRight(node);
	                } else {
	                    rotateLeftThenRight(node);
	                }
	            }
	        } else if (value > node.value) {
	            if (node.right != null) {
	                insert(node.right, value);
	            } else {
	                node.right = new Node(value, node);
	            }

	            if (height(node.right) - height(node.left) == 2) { //right heavier
	                if (value > node.right.value)
	                    rotateLeft(node);
	                else {
	                    rotateRightThenLeft(node);
	                }
	            }
	        }

	        reHeight(node);
	    }

	    private void rotateRight(Node pivot) {
	        Node parent = pivot.parent;
	        Node leftChild = pivot.left;
	        Node rightChildOfLeftChild = leftChild.right;
	        pivot.setLeftChild(rightChildOfLeftChild);
	        leftChild.setRightChild(pivot);
	        if (parent == null) {
	            this.root = leftChild;
	            leftChild.parent = null;
	            return;
	        }

	        if (parent.left == pivot) {
	            parent.setLeftChild(leftChild);
	        } else {
	            parent.setRightChild(leftChild);
	        }

	        reHeight(pivot);
	        reHeight(leftChild);
	    }

	    private void rotateLeft(Node pivot) {
	        Node parent = pivot.parent;
	        Node rightChild = pivot.right;
	        Node leftChildOfRightChild = rightChild.left;
	        pivot.setRightChild(leftChildOfRightChild);
	        rightChild.setLeftChild(pivot);
	        if (parent == null) {
	            this.root = rightChild;
	            rightChild.parent = null;
	            return;
	        }

	        if (parent.left == pivot) {
	            parent.setLeftChild(rightChild);
	        } else {
	            parent.setRightChild(rightChild);
	        }

	        reHeight(pivot);
	        reHeight(rightChild);
	    }

	    private void reHeight(Node node) {
	        node.height = Math.max(height(node.left), height(node.right)) + 1;
	    }

	    private void rotateLeftThenRight(Node node) {
	        rotateLeft(node.left);
	        rotateRight(node);
	    }

	    private void rotateRightThenLeft(Node node) {
	        rotateRight(node.right);
	        rotateLeft(node);
	    }

	    public boolean delete(int key) {
	        Node target = search(key);
	        if (target == null) return false;
	        target = deleteNode(target);
	        balanceTree(target.parent);
	        return true;
	    }

	    private Node deleteNode(Node target) {
	        if (isLeaf(target)) { //leaf
	            if (isLeftChild(target)) {
	                target.parent.left = null;
	            } else {
	                target.parent.right = null;
	            }
	        } else if (target.left == null ^ target.right == null) { //exact 1 child
	            Node nonNullChild = target.left == null ? target.right : target.left; 
	            if (isLeftChild(target)) {
	                target.parent.setLeftChild(nonNullChild); 
	            } else {
	                target.parent.setRightChild(nonNullChild);
	            }
	        } else {//2 children
	            Node immediatePredInOrder = immediatePredInOrder(target);
	            target.value = immediatePredInOrder.value;
	            target = deleteNode(immediatePredInOrder);
	        }

	        reHeight(target.parent);
	        return target;
	    }

	    private Node immediatePredInOrder(Node node) {
	        Node current = node.left;
	        while (current.right != null) {
	            current = current.right;
	        }

	        return current;
	    }

	    private boolean isLeftChild(Node child) {
	        return (child.parent.left == child);
	    }

	    private boolean isLeaf(Node node) {
	        return node.left == null && node.right == null;
	    }

	    private int calDifference(Node node) {
	        int rightHeight = height(node.right);
	        int leftHeight = height(node.left);
	        return rightHeight - leftHeight;
	    }

	    private void balanceTree(Node node) {
	        int difference = calDifference(node);
	        Node parent = node.parent;
	        if (difference == -2) {
	            if (height(node.left.left) >= height(node.left.right)) {
	                rotateRight(node);
	            } else {
	                rotateLeftThenRight(node);
	            }
	        } else if (difference == 2) {
	            if (height(node.right.right) >= height(node.right.left)) {
	                rotateLeft(node);
	            } else {
	                rotateRightThenLeft(node);
	            }
	        }

	        if (parent != null) {
	            balanceTree(parent);
	        }

	        reHeight(node);
	    }

	    public Node search(int key) {
	        return binarySearch(root, key);
	    }

	    private Node binarySearch(Node node, int key) {
	        if (node == null) return null;

	        if (key == node.value) {
	            return node;
	        }

	        if (key < node.value && node.left != null) {
	            return binarySearch(node.left, key);
	        }

	        if (key > node.value && node.right != null) {
	            return binarySearch(node.right, key);
	        }

	        return null;
	    }

	    public void traverseInOrder() {
	        System.out.println("ROOT " + root.toString());
	        //inorder(root);
	    }

	    private void inorder(Node node) {
	        if (node != null) {
	            inorder(node.left);
	            System.out.print(node.toString());
	            inorder(node.right);
	        }
	    }
	    
	    public int performSearch(int key) {
	        Node target = search(key);
	        if (target == null) return 0;
	        else return 0;
	    }

	    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
	        
	    	// Creating Object of AVL Trees
	    	AVLTree avl1 = new AVLTree();
	    	AVLTree avl2 = new AVLTree();
	    	AVLTree avl3 = new AVLTree();
	    	AVLTree avl4 = new AVLTree();
	    	AVLTree avl5 = new AVLTree();
	    	
	    	
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
			 
			 // creation 
			 long avl1start = System.currentTimeMillis();
			 for(int a : Array1){
				 avl1.insert(a);
			 }
			 long avl1end = System.currentTimeMillis();
			 
			 long avl2start = System.currentTimeMillis();
			 for(int a : Array2){
				 avl2.insert(a);
			 }
			 long avl2end = System.currentTimeMillis();
			 
			 long avl3start = System.currentTimeMillis();
			 for(int a : Array3){
				 avl3.insert(a);
			 }
			 long avl3end = System.currentTimeMillis();
			 
			 long avl4start = System.currentTimeMillis();
			 for(int a : Array4){
				 avl4.insert(a);
			 }
			 long avl4end = System.currentTimeMillis();
			 
			 long avl5start = System.currentTimeMillis();
			 for(int a : Array5){
				 avl5.insert(a);
			 }
			 long avl5end = System.currentTimeMillis();
			 
			 System.out.println("AVL Trees Creation...");
			 System.out.println("The time for creation AVl 1 is: "+(avl1end - avl1start)+" ms");
			 System.out.println("The time for creation AVl 2 is: "+(avl2end - avl2start)+" ms");
			 System.out.println("The time for creation AVl 3 is: "+(avl3end - avl3start)+" ms");
			 System.out.println("The time for creation AVl 4 is: "+(avl4end - avl4start)+" ms");
			 System.out.println("The time for creation AVl 5 is: "+(avl5end - avl5start)+" ms");
			 
			 // Insertion
			 // For insertion process
			 AVLTree avl1ins = avl1;
			 AVLTree avl2ins = avl2;
			 AVLTree avl3ins = avl3;
			 AVLTree avl4ins = avl4;
			 AVLTree avl5ins = avl5;
			 
			 long avl1insstart = System.nanoTime(); 
			 avl1ins.insert(z1);
			 avl1ins.insert(z2);
			 avl1ins.insert(z3);
			 long avl1insend = System.nanoTime();
			 
			 long avl2insstart = System.nanoTime();
			 avl2ins.insert(z4);
			 avl2ins.insert(z5);
			 avl2ins.insert(z6);
			 long avl2insend = System.nanoTime();
			 
			 long avl3insstart = System.nanoTime();
			 avl3.insert(z7);
			 avl3.insert(z8);
			 avl3.insert(z9);
			 long avl3insend = System.nanoTime();
			 
			 long avl4insstart = System.nanoTime();
			 avl4.insert(z10);
			 avl4.insert(z11);
			 avl4.insert(z12);
			 long avl4insend= System.nanoTime();
			 
			 long avl5insstart = System.nanoTime();
			 avl5.insert(z13);
			 avl5.insert(z14);
			 avl5.insert(z15);
			 long avl5insend = System.nanoTime();
			 
			 System.out.println("\nAVL Tree Insertion...");
			 System.out.println("The time for insertion for AVL1 is: "+(avl1insend - avl1insstart)+" ns");
			 System.out.println("The time for insertion for AVL2 is: "+(avl2insend - avl2insstart)+" ns");
			 System.out.println("The time for insertion for AVL3 is: "+(avl3insend - avl3insstart)+" ns");
			 System.out.println("The time for insertion for AVL4 is: "+(avl4insend - avl4insstart)+" ns");
			 System.out.println("The time for insertion for AVL5 is: "+(avl5insend - avl5insstart)+" ns");
			 
			 // Deletion process
			// For Deletion process
			 AVLTree avl1del = avl1;
			 AVLTree avl2del = avl2;
			 AVLTree avl3del = avl3;
			 AVLTree avl4del = avl4;
			 AVLTree avl5del = avl5;
			 
			 long avl1delstart = System.nanoTime();
			 avl1del.delete(x1);
			 avl1del.delete(x2);
			 avl1del.delete(x3);
			 long avl1delend = System.nanoTime();
			 
			 long avl2delstart = System.nanoTime();
			 avl2del.delete(x4);
			 avl2del.delete(x5);
			 avl2del.delete(x6);
			 long avl2delend = System.nanoTime();
			 
			 long avl3delstart = System.nanoTime();
			 avl3del.delete(x7);
			 avl3del.delete(x8);
			 avl3del.delete(x9);
			 long avl3delend = System.nanoTime();
			 
			 long avl4delstart = System.nanoTime();
			 avl4del.delete(x10);
			 avl4del.delete(x11);
			 avl4del.delete(x12);
			 long avl4delend = System.nanoTime();
			 
			 long avl5delstart = System.nanoTime();
			 avl5del.delete(x13);
			 avl5del.delete(x14);
			 avl5del.delete(x15);
			 long avl5delend = System.nanoTime();
			 
			 System.out.println("\nAVL Tree Deletion...");
			 System.out.println("The time for Deletion for AVL 1 is: "+ (avl1delend - avl1delstart)+" ns");
			 System.out.println("The time for Deletion for AVL 2 is: "+ (avl2delend - avl2delstart)+" ns");
			 System.out.println("The time for Deletion for AVL 3 is: "+ (avl3delend - avl3delstart)+" ns");
			 System.out.println("The time for Deletion for AVL 4 is: "+ (avl4delend - avl4delstart)+" ns");
			 System.out.println("The time for Deletion for AVL 5 is: "+ (avl5delend - avl5delstart)+" ns");
			
			 
	    	// Searching process
	    	// For Search process
	    	AVLTree avl1sch = avl1;
	    	AVLTree avl2sch = avl2;
	    	AVLTree avl3sch = avl3;
	    	AVLTree avl4sch = avl4;
	    	AVLTree avl5sch = avl5;
	    	
	    	long avl1schstart = System.nanoTime();
	    	avl1sch.performSearch(c1);
	    	avl1sch.performSearch(c2);
	    	avl1sch.performSearch(c3);
	    	long avl1schend = System.nanoTime();
	    	
	    	long avl2schstart = System.nanoTime();
	    	avl2sch.performSearch(c4);
	    	avl2sch.performSearch(c5);
	    	avl2sch.performSearch(c6);
	    	long avl2schend = System.nanoTime();
	    	
	    	long avl3schstart = System.nanoTime();
	    	avl3sch.performSearch(c7);
	    	avl3sch.performSearch(c8);
	    	avl3sch.performSearch(c9);
	    	long avl3schend = System.nanoTime();
	    	
	    	long avl4schstart = System.nanoTime();
	    	avl4sch.performSearch(c10);
	    	avl4sch.performSearch(c11);
	    	avl4sch.performSearch(c12);
	    	long avl4schend = System.nanoTime();
	    	
	    	long avl5schstart = System.nanoTime();
	    	avl5sch.performSearch(c13);
	    	avl5sch.performSearch(c14);
	    	avl5sch.performSearch(c15);
	    	long avl5schend = System.nanoTime();
	    	
	    	System.out.println("\nAVL Tree Searching...");
	    	System.out.println("The time for searching for AVL 1 is: "+ (avl1schend - avl1schstart)+" ns");
	    	System.out.println("The time for searching for AVL 2 is: "+ (avl2schend - avl2schstart)+" ns");
	    	System.out.println("The time for searching for AVL 3 is: "+ (avl3schend - avl3schstart)+" ns");
	    	System.out.println("The time for searching for AVL 4 is: "+ (avl4schend - avl4schstart)+" ns");
	    	System.out.println("The time for searching for AVL 5 is: "+ (avl5schend - avl5schstart)+" ns");
			 
			 
			//calculate the height
	    	System.out.println("");
			System.out.print("AVL1: ");
	    	avl1.traverseInOrder();
	    	System.out.print("AVL2: ");
			avl2.traverseInOrder();
			System.out.print("AVL3: ");
			avl3.traverseInOrder();
			System.out.print("AVL4: ");
			avl4.traverseInOrder();
			System.out.print("AVL5: ");
			avl5.traverseInOrder();
	    }
	}
