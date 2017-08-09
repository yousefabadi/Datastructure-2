package dataAssignment2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class generateDatasets {
	public generateDatasets(int elements) {
		switch (elements) {
		case 1000:
			File file1 = new File("1st-Dataset.txt");
			try (BufferedWriter br = new BufferedWriter(new FileWriter(file1))) {
				Random r = new Random();
				for (int i = 0; i < 1000; i++) {
					int line = r.nextInt(1000);
					br.write(new Integer(line).toString());
					br.newLine();
				}
			} catch (IOException e) {
				System.out
						.println("unable to write file:  " + file1.toString());
			}
		case 10000:
			File file2 = new File("2nd-Dataset.txt");
			try (BufferedWriter br = new BufferedWriter(new FileWriter(file2))) {
				Random r = new Random();
				for (int i = 0; i < 10000; i++) {
					int line = r.nextInt(10000);
					br.write(new Integer(line).toString());
					br.newLine();
				}
			} catch (IOException e) {
				System.out
						.println("unable to write file:  " + file2.toString());
			}
		case 50000:
			File file3 = new File("3rd-Dataset.txt");
			try (BufferedWriter br = new BufferedWriter(new FileWriter(file3))) {
				Random r = new Random();
				for (int i = 0; i < 50000; i++) {
					int line = r.nextInt(50000);
					br.write(new Integer(line).toString());
					br.newLine();
				}
			} catch (IOException e) {
				System.out
						.println("unable to write file:  " + file3.toString());
			}
		case 100000:
			File file4 = new File("4th-Dataset.txt");
			try (BufferedWriter br = new BufferedWriter(new FileWriter(file4))) {
				Random r = new Random();
				for (int i = 0; i < 100000; i++) {
					int line = r.nextInt(100000);
					br.write(new Integer(line).toString());
					br.newLine();
				}
			} catch (IOException e) {
				System.out
						.println("unable to write file:  " + file4.toString());
			}
		case 1000000:
			File file5 = new File("5th-Dataset.txt");
			try (BufferedWriter br = new BufferedWriter(new FileWriter(file5))) {
				Random r = new Random();
				for (int i = 0; i < 1000000; i++) {
					int line = r.nextInt(1000000);
					br.write(new Integer(line).toString());
					br.newLine();
				}
			} catch (IOException e) {
				System.out
						.println("unable to write file:  " + file5.toString());
			}

		}
	}
}

public class generateFile {
	public static void main(String[] args) {
		generateDatasets dataSet1 = new generateDatasets(1000);
		generateDatasets dataSet2 = new generateDatasets(10000);
		generateDatasets dataSet3 = new generateDatasets(50000);
		generateDatasets dataSet4 = new generateDatasets(100000);
		generateDatasets dataSet5 = new generateDatasets(1000000);
		
	}
}
