package Algoritmi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws IOException {
		long average = 0;
		for(int i = 0; i < 80; i++) {
			switch(i){
				case 0: System.out.println("LOW OPERATION NUMBER, LOW SAMPLE SPREAD, LOW DELETION COUNT");
					average = 0;
					break;
				case 10: System.out.println("LOW OPERATION NUMBER, HIGH SAMPLE SPREAD, LOW DELETION COUNT");
					average = 0;
					break;
				case 20: System.out.println("HIGH OPERATION NUMBER, LOW SAMPLE SPREAD, LOW DELETION COUNT");
					average = 0;
					break;
				case 30: System.out.println("HIGH OPERATION NUMBER, HIGH SAMPLE SPREAD, LOW DELETION COUNT");
					average = 0;
					break;
				case 40: System.out.println("LOW OPERATION NUMBER, LOW SAMPLE SPREAD, HIGH DELETION COUNT");
					average = 0;
					break;
				case 50: System.out.println("LOW OPERATION NUMBER, HIGH SAMPLE SPREAD, HIGH DELETION COUNT");
					average = 0;
					break;
				case 60: System.out.println("HIGH OPERATION NUMBER, LOW SAMPLE SPREAD, HIGH DELETION COUNT");
					average = 0;
					break;
				case 70: System.out.println("HIGH OPERATION NUMBER, HIGH SAMPLE SPREAD, HIGH DELETION COUNT");
					average = 0;
					break;
				default:
					break;
			}
			CoadaDePrioritate coadaAVL = new AVLTreePQ();
			CoadaDePrioritate coadaHeap = new MaxHeapPQ();
			Scanner readAVL = new Scanner(new File(new String("in/test" + i + ".in")));
			Scanner readHeap = new Scanner(new File(new String("in/test" + i + ".in")));
			BufferedWriter AVLOut = new BufferedWriter(new FileWriter(new String("AVLOut/test" + i + ".out")));
			BufferedWriter HeapOut = new BufferedWriter(new FileWriter(new String("heapOut/test" + i + ".out")));
			
			long AVLStartTime = System.nanoTime();
			int noOp = readAVL.nextInt();
			for(int j = 0; j < noOp; j++) {
				switch(readAVL.next()) {
					case "A":
						coadaAVL.insert(readAVL.nextInt());
						break;
					case "MAX":
						AVLOut.write("" + coadaAVL.getMax());
						AVLOut.newLine();
						break;
					case "D":
						AVLOut.write("" + coadaAVL.removeMax());
						AVLOut.newLine();
						break;
					default:
						break;
				}
			}
			long AVLTime = System.nanoTime() - AVLStartTime;
			
			long HeapStartTime = System.nanoTime();
			noOp = readHeap.nextInt();
			for(int j = 0; j < noOp; j++) {
				switch(readHeap.next()) {
					case "A":
						coadaHeap.insert(readHeap.nextInt());
						break;
					case "MAX":
						HeapOut.write("" + coadaHeap.getMax());
						HeapOut.newLine();
						break;
					case "D":
						HeapOut.write("" + coadaHeap.removeMax());
						HeapOut.newLine();
						break;
					default:
						break;
				}
			}
			long HeapTime = System.nanoTime() - HeapStartTime;
			readAVL.close();
			readHeap.close();
			AVLOut.close();
			HeapOut.close();
				
			System.out.println("Test " + i + ": MaxHeapPQ time is " + (HeapTime * 100 / AVLTime) + " % of AVLTreePQ time.");
			average += HeapTime * 100 / AVLTime;
			if(i % 10 == 9) {
				System.out.println("MaxHeapPQ time is on average " + (average/10) + " % of AVLTreePQ time.");
				System.out.println("=======================================================================");
			}
		}
	}
}
