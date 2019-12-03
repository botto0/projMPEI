package mpeiproj;

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
			BloomFilter[pos] = 1;
		}
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
		return ret;
	}

	// returns hash values of string
	private int hashFunct(String s, int k) {
		int h = 0;
		for (int i = 0; i < s.length(); i++)
		{
			h += k * (((int) s.charAt(i)) % this.prime) % this.m;
		}
		return h;
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