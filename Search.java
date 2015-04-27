/************************************************/
/*** Purpose: Investigate the performance    ***/
/*** required for searching algorithms        ***/
/***                                          ***/
/***                                          ***/
/*** Author: Zholdiyarov Sanzhar              ***/
/*** Date:   25.10.2014                       ***/
/***                                          ***/
/*** Note: Based on skeleton code provided by ***/
/*** Jason Steggles 23/08/2014                ***/
/************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Search {

	/** Global var for counting comparisons **/
	public static int compSeq = 0;
	public static int compBin = 0;
	public static int compHash = 0;

	/** Array of values to be searched and size **/
	private int[] A;
	private int[] H;
	private int size;
	private int hSize;

	/** Constructor **/
	Search(int n, int hn) {
		/** set size of array **/
		size = n;
		hSize = hn;

		/** Create arrays **/
		A = new int[size];
		H = new int[hSize];

		/** Initialize hash array **/
		/** Assume -1 indicates a location is empty **/
		for (int i = 0; i < hSize; i++) {
			H[i] = -1;
		}
	}

	/********************************************/
	/*** Read a file of numbers into an array ***/
	/********************************************/
	public void readFileIn(String file) {
		try {
			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data **/
			for (int i = 0; i < size; i++) {
				/** Get net value **/
				A[i] = in.nextInt();
			}
		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/*********************/
	/*** Hash Function ***/
	/*********************/
	public int hash(int key) {
		return key % hSize;
	}

	/*****************************/
	/*** Display array of data ***/
	/*****************************/
	public void displayData(int line, String header) {
		/* ** Integer Formatter ** */
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n\n" + header);

		/** Display array data **/
		for (int i = 0; i < size; i++) {
			/** New line? **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display value **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}

	/**************************/
	/*** Display hash array ***/
	/**************************/
	public void displayHash(int line) {
		/** Integer Formatter **/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n\nHash Array of size " + hSize);

		/** Display array data **/
		for (int i = 0; i < hSize; i++) {
			/** New line? **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display value **/
			System.out.print(FI.format(H[i]) + " ");
		}

	}

	/** Implementation of the sequential search **/
	public int seqSearch(int key) {
		for (int i = 0; i < A.length; i++) {
			compSeq = compSeq + 1; // Count the number of the comparisons made
			if (A[i] == key) {
				return i;
			} else if (A[i] > key) {
				return -1;
			}
		}
		return -1;
	}

	/* Getter for compSeq */
	public int getCompSeq() {
		return compSeq;
	}

	public void setToZeroCompSeq() {
		compSeq = 0; // Set global var compSeq to zero.
	}

	/** Implementation of the binary search **/
	public int binSearch(int key, int L, int R) {
		compBin = compBin + 1; // Count the number of the comparisons made.
		int m = 0;
		m = (R + L) / 2; // Calculate index of the middle point.
		if (R < L) {
			return -1; // If there is no elements left.
		} else if (key == A[m]) {
			return m; // If key is found.
		} else if (key > A[m]) {
			return binSearch(key, m + 1, R); // Search right side of the array.
		} else {
			return binSearch(key, L, m - 1); // Search left side of the array.
		}
	}

	/* Getter for compBin */
	public int getCompBin() {
		return compBin;
	}

	public void setToZeroCompBin() {
		compBin = 0; // Set global var compBin to zero.
	}

	/** Method which adds new elements to the hash array **/
	private void addToHash(int value) {
		int hashOfValue = 0; /* Local variable to store hash of the value. */
		hashOfValue = hash(value);
		if (H[hashOfValue] == -1) { /* If the position is empty. */
			H[hashOfValue] = value;
		} else {
			for (int i = hashOfValue + 1; i < H.length; i++) {
				if (H[i] == -1) {
					H[i] = value;
					break;
				} else if (i == H.length - 1) { // if i is at the end of array
					for (int j = 0; j < hashOfValue; j++) {
						if (H[j] == -1) {
							H[j] = value;
							break;
						}
					}
				}
			}
		}
	}

	/** Method which read data from a file and add it to the hash array. **/
	public void readIntoHash(String file) {
		try {
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);
			while (in.hasNext()) {
				addToHash(in.nextInt());
			}
		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/** Implementation of the hash search algorithm. **/
	public int hashSearch(int key) {
		int hashOfValue = hash(key); // Local var to store hash of the value.
		compHash = compHash + 1; // Comparisons counter
		if (H[hashOfValue] == key) {
			return hashOfValue; // If found immediately.
		} else {
			/* Search upwards through the array */
			for (int i = hashOfValue + 1; i < H.length; i++) {
				compHash = compHash + 1;
				if (H[i] == key) {
					return i;
				} else if (H[i] == -1) {
					return -1;
				}
				/* Search from the beginning of the array until hash(key) */
				else if (i == H.length - 1) {
					for (int j = 0; j < hashOfValue; j++) {
						compHash = compHash + 1;
						if (H[j] == key) {
							return j;
						}
					}
				}
			}
		}
		return -1;
	}

	/* Getter for compHash */
	public int getCompHash() {
		return compHash;
	}

	public void setToZeroCompHash() {
		compHash = 0; // Set global var compHash to zero.
	}


}
/*** End of class Search ***/
