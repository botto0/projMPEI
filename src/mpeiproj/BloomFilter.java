package mpeiproj;

import java.util.Random;
import java.util.Scanner;

public class BloomFilter {

	private long[] BloomFilter; // Declare bloom filter array
	private int n; // num elements 
	private int m; // size Bloom Filter
	private int k; // num hash functions
	private int prime = 31; // prime num for hash functions 
	private double p; //prob max of false positives

	public BloomFilter(int n, double p) {
		this.m = (int) Math.ceil((n * Math.log(p)) / Math.log(1 / Math.pow(2, Math.log(2))));
		this.k = (int) Math.round(((double) m / (double) n) * Math.log(2));

	}

	// initializes the bf	
	public void init() {
		BloomFilter = new long[this.m];
		for (int i = 0; i < n; i++) {
			BloomFilter[i] = 0;
		}
	}

	// insert element in bf
	public boolean insert(String elem) {
		int pos;

		for (int i = 1; i <= k; i++) {
			pos = hashFunct(elem,i) % (BloomFilter.length);
			if(BloomFilter[pos] == 1) {
				System.out.printf("File %s already exists!\n", elem);
				return false;
			}
			BloomFilter[pos] = 1;
		}
		System.out.printf("Inserted %s\n", elem);

		return true;
	}

	// check if element is in bf
	public boolean check(String elem) {
		int pos;
		boolean ret = true;
		for (int i = 1; i <=k; i++) {
			pos = hashFunct(elem,i) % BloomFilter.length;
			if (BloomFilter[pos] == 0) {
				ret = false;
			}
		}
		System.out.printf("Check %s: %b\n", elem, ret);
		return ret;
	}

	// returns hash values of string
	private int hashFunct(String s, int k) {
		int hK = 0;
		for (int i = 0; i < s.length(); i++)
		{
			hK += k * (((int) s.charAt(i)) % this.prime) % this.m;
		}
		return hK;
	}

	// size of bf array 
	public int getN() {
		return n;
	}

	// returns the bf array

	public long[] getBF() {
		return BloomFilter;
	}
}