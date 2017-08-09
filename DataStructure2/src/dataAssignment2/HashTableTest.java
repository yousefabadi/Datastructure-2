package dataAssignment2;

/**
 * Java program to implement Hash Table
 **///

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
 
class HashTable
{
    int[] arr;
    int capacity;
 
    /** constructor **/
    public HashTable(int capacity)
    {
        this.capacity = nextPrime(capacity);
        arr = new int[this.capacity];
    }
 
    /** function to insert **/
    public void insert(int ele)
    {
        arr[ele % capacity] = ele;
    }
 
    /** function to clear **/
    public void clear()
    {
        arr = new int[capacity];
    }
 
    /** function contains **/
    public boolean contains(int ele)
    {
        return arr[ele % capacity] == ele;
    }
 
    /** function to delete **/
    public void delete(int ele)
    {
        if (arr[ele % capacity] == ele)
            arr[ele % capacity] = 0;
        else
            System.out.println("\nError : Element not found\n");
    }
 
    /** Function to generate next prime number >= n **/
    private static int nextPrime( int n )
    {
        if (n % 2 == 0)
            n++;
        for (; !isPrime(n); n += 2);
 
        return n;
    }
 
    /** Function to check if given number is prime **/
    private static boolean isPrime(int n)
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
 
    /** function to print hash table **/
    public void printTable()
    {
        System.out.print("\nHash Table = ");
        for (int i = 0; i < capacity; i++)
            System.out.print(arr[i] +" ");
        System.out.println();
    }
}
 
/** Class HashTableTest **/
public class HashTableTest
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
    	
    	// Creating Object of HashTables
    	HashTable ht1 = new HashTable(1000);
    	HashTable ht2 = new HashTable(10000);
    	HashTable ht3 = new HashTable(50000);
    	HashTable ht4 = new HashTable(100000);
    	HashTable ht5 = new HashTable(1000000);
    	
    	
    	
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
    	
    	//Fetch the elements from the files and save them into Arrays
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
		 
		 // Creation HashTable
		 long ht1createst = System.currentTimeMillis();
		 for(int a : Array1){
			 ht1.insert(a);
		 }
		 long ht1createend = System.currentTimeMillis();
		 
		 long ht2createst = System.currentTimeMillis();
		 for(int a : Array2){
			 ht2.insert(a);
		 }
		 long ht2createend = System.currentTimeMillis();
		 
		 long ht3createst = System.currentTimeMillis();
		 for(int a : Array3){
			 ht3.insert(a);
		 }
		 long ht3createend = System.currentTimeMillis();
		 
		 long ht4createst = System.currentTimeMillis();
		 for(int a : Array4){
			 ht4.insert(a);
		 }
		 long ht4createend = System.currentTimeMillis();
		 
		 long ht5createst = System.currentTimeMillis();
		 for(int a : Array5){
			 ht5.insert(a);
		 }
		 long ht5createend = System.currentTimeMillis();
		 
		 System.out.println("Hash Table Creation...");
		 System.out.println("The time for creation Hash Table 1 is: "+(ht1createend - ht1createst)+" ms");
		 System.out.println("The time for creation Hash Table 2 is: "+(ht2createend - ht2createst)+" ms");
		 System.out.println("The time for creation Hash Table 3 is: "+(ht3createend - ht3createst)+" ms");
		 System.out.println("The time for creation Hash Table 4 is: "+(ht4createend - ht4createst)+" ms");
		 System.out.println("The time for creation Hash Table 5 is: "+(ht5createend - ht5createst)+" ms");
		 
		 // for insert process
		 HashTable ht1ins = ht1;
		 HashTable ht2ins = ht2;
		 HashTable ht3ins = ht3;
		 HashTable ht4ins = ht4;
		 HashTable ht5ins = ht5;
		 
		 // for Deletion process
		 HashTable ht1del = ht1;
		 HashTable ht2del = ht2;
		 HashTable ht3del = ht3;
		 HashTable ht4del = ht4;
		 HashTable ht5del = ht5;
		 
		 // for Searching process
		 HashTable ht1sch = ht1;
		 HashTable ht2sch = ht2;
		 HashTable ht3sch = ht3;
		 HashTable ht4sch = ht4;
		 HashTable ht5sch = ht5;
		 
		 
		 //Insertion Proceess
		 
		 long ht1insstart = System.nanoTime();
		 ht1ins.insert(z1);
		 ht1ins.insert(z2);
		 ht1ins.insert(z3);
		 long ht1insend = System.nanoTime();
		 
		 long ht2insstart = System.nanoTime();
		 ht2ins.insert(z4);
		 ht2ins.insert(z5);
		 ht2ins.insert(z6);
		 long ht2insend = System.nanoTime();
		 
		 long ht3insstart = System.nanoTime();
		 ht3ins.insert(z7);
		 ht3ins.insert(z8);
		 ht3ins.insert(z9);
		 long ht3insend = System.nanoTime();
		 
		 long ht4insstart = System.nanoTime();
		 ht4ins.insert(z10);
		 ht4ins.insert(z11);
		 ht4ins.insert(z12);
		 long ht4insend = System.nanoTime();
		 
		 long ht5insstart = System.nanoTime();
		 ht5ins.insert(z13);
		 ht5ins.insert(z14);
		 ht5ins.insert(z15);
		 long ht5insend = System.nanoTime();
		 
		 System.out.println("\nHash Table Insertion... ");
		 System.out.println("The time for insertion Hash Table 1 is: "+(ht1insend - ht1insstart)+" ns");
		 System.out.println("The time for insertion Hash Table 2 is: "+(ht2insend - ht2insstart)+" ns");
		 System.out.println("The time for insertion Hash Table 3 is: "+(ht3insend - ht3insstart)+" ns");
		 System.out.println("The time for insertion Hash Table 4 is: "+(ht4insend - ht4insstart)+" ns");
		 System.out.println("The time for insertion Hash Table 5 is: "+(ht5insend - ht5insstart)+" ns");
		 
		 //Deletion process
		 
		 long ht1delstart = System.nanoTime();
		 ht1del.delete(x1);
		 ht1del.delete(x2);
		 ht1del.delete(x3);
		 long ht1delend = System.nanoTime();
		 
		 long ht2delstart = System.nanoTime();
		 ht2del.delete(x4);
		 ht2del.delete(x5);
		 ht2del.delete(x6);
		 long ht2delend = System.nanoTime();
		 
		 long ht3delstart = System.nanoTime();
		 ht3del.delete(x7);
		 ht3del.delete(x8);
		 ht3del.delete(x9);
		 long ht3delend = System.nanoTime();
		 
		 long ht4delstart = System.nanoTime();
		 ht4del.delete(x10);
		 ht4del.delete(x11);
		 ht4del.delete(x12);
		 long ht4delend = System.nanoTime();
		 
		 long ht5delstart = System.nanoTime();
		 ht5del.delete(x13);
		 ht5del.delete(x14);
		 ht5del.delete(x15);
		 long ht5delend = System.nanoTime();
		 
		 System.out.println("\nHash Table Deletion...");
		 System.out.println("The time for insertion Hash Table 1 is: "+(ht1delend - ht1delstart)+ " ns");
		 System.out.println("The time for insertion Hash Table 2 is: "+(ht2delend - ht2delstart)+ " ns");
		 System.out.println("The time for insertion Hash Table 3 is: "+(ht3delend - ht3delstart)+ " ns");
		 System.out.println("The time for insertion Hash Table 4 is: "+(ht4delend - ht4delstart)+ " ns");
		 System.out.println("The time for insertion Hash Table 5 is: "+(ht5delend - ht5delstart)+ " ns");
		 
		 // searching process
		 long ht1schstart = System.nanoTime();
		 ht1sch.contains(c1);
		 ht1sch.contains(c2);
		 ht1sch.contains(c3);
		 long ht1schend = System.nanoTime();
		 
		 long ht2schstart = System.nanoTime();
		 ht2sch.contains(c4);
		 ht2sch.contains(c5);
		 ht2sch.contains(c6);
		 long ht2schend = System.nanoTime();
		 
		 long ht3schstart = System.nanoTime();
		 ht3sch.contains(c7);
		 ht3sch.contains(c8);
		 ht3sch.contains(c9);
		 long ht3schend = System.nanoTime();
		 
		 long ht4schstart = System.nanoTime();
		 ht4sch.contains(c10);
		 ht4sch.contains(c11);
		 ht4sch.contains(c12);
		 long ht4schend = System.nanoTime();
		 
		 long ht5schstart = System.nanoTime();
		 ht5sch.contains(c13);
		 ht5sch.contains(c14);
		 ht5sch.contains(c15);
		 long ht5schend = System.nanoTime();
		 
		 System.out.println("\nHash Table Searching...");
		 System.out.println("The time for Searching Hash Table 1 is:"+ (ht1schend - ht1schstart)+" ns");
		 System.out.println("The time for Searching Hash Table 2 is:"+ (ht2schend - ht2schstart)+" ns");
		 System.out.println("The time for Searching Hash Table 3 is:"+ (ht3schend - ht3schstart)+" ns");
		 System.out.println("The time for Searching Hash Table 4 is:"+ (ht4schend - ht4schstart)+" ns");
		 System.out.println("The time for Searching Hash Table 5 is:"+ (ht5schend - ht5schstart)+" ns");
		 
		 
    }
}