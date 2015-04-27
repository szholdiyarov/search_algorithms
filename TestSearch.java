/******************************************************/
/*** Purpose: Test class to illustrate Search class ***/
/***                                                ***/
/*** Author: L. J. Steggles,                        ***/
/*** Zholdiyarov Sanzhar 110562618                  ***/
/*** Date: 20/08/2014                               ***/
/******************************************************/

import java.io.*;
import java.text.*;

public class TestSearch {
	public static void main(String[] args) {

		/** Local variables to store average of the comparisons made. **/
		int averageCompSeq = 0;
		int averageCompBin = 0;
		int averageCompHash = 0;

		/** String formatter **/
		String leftFormat = "| %-8s | %-6s | %-9s |%n";

		/** Search 1 for the data1.txt **/
		Search S = new Search(100, 151);

		/** Read in data **/
		S.readFileIn("data1.txt");

		/** Display data array **/
		S.displayData(20, "Data Array");

		/** Display hash array which will be empty **/
		S.displayHash(20);

		/** Read in data into Hash array **/
		S.readIntoHash("data1.txt");

		/** Display hash array which now is not empty **/
		S.displayHash(20);

		/** Sequential search for search1.txt **/
		System.out.println("\nSequential search for search1.txt");
		System.out.format("+----------+--------+-----------+%n");
		System.out.printf("| Test     | Result | Comp. made|%n");
		System.out.format("+----------+--------+-----------+%n");
		System.out.format(leftFormat, 18, S.seqSearch(18), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 69, S.seqSearch(69), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 201, S.seqSearch(201), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 331, S.seqSearch(331), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 492, S.seqSearch(492), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 17, S.seqSearch(17), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 67, S.seqSearch(67), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 209, S.seqSearch(209), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 372, S.seqSearch(372), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 498, S.seqSearch(498), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format("+----------+--------+-----------+%n");
		System.out.println("Average compSeq is : " + averageCompSeq / 10);

		/** Binary search for search1.txt **/
		System.out.println("\nBinary search for search1.txt");
		System.out.format("+----------+--------+-----------+%n");
		System.out.printf("| Test     | Result | Comp. made|%n");
		System.out.format("+----------+--------+-----------+%n");
		System.out.format(leftFormat, 18, S.binSearch(18, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 69, S.binSearch(69, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 201, S.binSearch(201, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 331, S.binSearch(331, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 492, S.binSearch(492, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 17, S.binSearch(17, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 67, S.binSearch(67, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 209, S.binSearch(209, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 372, S.binSearch(372, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 498, S.binSearch(498, 0, 100),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format("+----------+--------+-----------+%n");
		System.out.println("Average compBin is : " + averageCompBin / 10);

		/** Hash search for search1.txt **/
		System.out.println("\nHash search for search1.txt");
		System.out.format("+----------+--------+-----------+%n");
		System.out.printf("| Test     | Result | Comp. made|%n");
		System.out.format("+----------+--------+-----------+%n");
		System.out.format(leftFormat, 18, S.hashSearch(18), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 69, S.hashSearch(69), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 201, S.hashSearch(201), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 331, S.hashSearch(331), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 492, S.hashSearch(492), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 17, S.hashSearch(17), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 67, S.hashSearch(67), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 209, S.hashSearch(209), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 372, S.hashSearch(372), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 498, S.hashSearch(498), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format("+----------+--------+-----------+%n");
		System.out.println("Average is : " + averageCompHash / 10);

		/** Test2 data **/
		S = new Search(1000, 1499);
		averageCompSeq = 0;
		averageCompBin = 0;
		averageCompHash = 0;

		S.readFileIn("data2.txt");
		S.readIntoHash("data2.txt");
		S.displayData(20, "Data Array"); // Display array data
		/** Sequential search for search2.txt **/
		System.out.println("\nSequential search for search2.txt");
		System.out.format("+----------+--------+-----------+%n");
		System.out.printf("| Test     | Result | Comp. made|%n");
		System.out.format("+----------+--------+-----------+%n");
		System.out.format(leftFormat, 20, S.seqSearch(20), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 832, S.seqSearch(832), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 1452, S.seqSearch(1452), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 1937, S.seqSearch(1937), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 2615, S.seqSearch(2615), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 87, S.seqSearch(87), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 851, S.seqSearch(851), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 1350, S.seqSearch(1350), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 1990, S.seqSearch(1990), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format(leftFormat, 2631, S.seqSearch(2631), S.getCompSeq());
		averageCompSeq = S.getCompSeq() + averageCompSeq;
		S.setToZeroCompSeq();
		System.out.format("+----------+--------+-----------+%n");
		System.out.println("Average is : " + averageCompSeq / 10);

		/** Binary search for search2.txt **/
		System.out.println("\nBinary search for search2.txt");
		System.out.format("+----------+--------+-----------+%n");
		System.out.printf("| Test     | Result | Comp. made|%n");
		System.out.format("+----------+--------+-----------+%n");
		System.out.format(leftFormat, 20, S.binSearch(20, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 832, S.binSearch(832, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 1452, S.binSearch(1452, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 1937, S.binSearch(1937, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 2615, S.binSearch(2615, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 87, S.binSearch(87, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 851, S.binSearch(851, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 1350, S.binSearch(1350, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 1990, S.binSearch(1990, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format(leftFormat, 2631, S.binSearch(2631, 0, 1000),
				S.getCompBin());
		averageCompBin = S.getCompBin() + averageCompBin;
		S.setToZeroCompBin();
		System.out.format("+----------+--------+-----------+%n");
		System.out.println("Average compBin is : " + averageCompBin / 10);

		/** Hash search for search2.txt **/
		System.out.println("\nHash search for search2.txt");
		System.out.format("+----------+--------+-----------+%n");
		System.out.printf("| Test     | Result | Comp. made|%n");
		System.out.format("+----------+--------+-----------+%n");
		System.out.format(leftFormat, 20, S.hashSearch(20), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 832, S.hashSearch(832), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out
				.format(leftFormat, 1452, S.hashSearch(1452), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out
				.format(leftFormat, 1937, S.hashSearch(1937), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out
				.format(leftFormat, 2615, S.hashSearch(2615), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 87, S.hashSearch(87), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format(leftFormat, 851, S.hashSearch(851), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out
				.format(leftFormat, 1350, S.hashSearch(1350), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out
				.format(leftFormat, 1990, S.hashSearch(1990), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out
				.format(leftFormat, 2631, S.hashSearch(2631), S.getCompHash());
		averageCompHash = S.getCompHash() + averageCompHash;
		S.setToZeroCompHash();
		System.out.format("+----------+--------+-----------+%n");
		System.out.println("Average compHash is : " + averageCompHash / 10);

	}
}