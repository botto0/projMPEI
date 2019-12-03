package mpeiproj;

import java.util.ArrayList;
import java.util.HashMap;

public class minHash {
	private ArrayList<ArrayList<Integer>> minHash;
	private ArrayList<String> ds;
	private double totalHashes;
	private int prime = 31; // prime num for hash functions 

	public minHash(ArrayList<String> ds, int totalHashes) {
		this.ds = ds;
		this.totalHashes = totalHashes;
		initMinHash(ds);
	}

	private void initMinHash( ArrayList<String> ds) {

		this.minHash = new ArrayList<>();
		ArrayList<Integer> a=new ArrayList<Integer>();
		this.minHash.add(a);
		int[] h = new int[ds.size()];
		int min;

		for (int j = 1; j <= this.totalHashes; j++) {

			for (int i = 0; i < ds.size(); i++) {

				h[i] = hashFunct(ds.get(i), j);

			}
			min = Integer.MAX_VALUE;
			for (int i : h) {
				if (i < min) {
					min = i;
				}
			}
			this.minHash.get(0).add(min);

		}
		printMinHash();

	}

	public void printMinHash() {
		int len = this.minHash.size();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < this.totalHashes; j++) {
				System.out.printf("%d ", this.minHash.get(i).get(j));
			}	
			System.out.println("");
		}
	}
	private int hashFunct(String s, int k) {
		int h = 0;
		for (int i = 0; i < s.length(); i++)
		{
			h += k * (((int) s.charAt(i)) % this.prime) % (this.ds.size());
		}
		return h;
	}

}
