package mpeiproj;

import java.util.ArrayList;
import java.util.HashMap;
import mpeiproj.Shingles;

public class minHash {
	private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	private  ArrayList<String> ds;
	private double totalHashes;
	private UHASH hashFunct = new UHASH();

	public minHash(int t) {
		this.totalHashes=t;
	}

	public void addMinHash(ArrayList<String> ds) {
		ArrayList<Integer> a = new ArrayList<Integer>();

		int[] h = new int[ds.size()];
		int min;


		for (int j = 0; j < this.totalHashes; j++) {
			for (int i = 0; i < ds.size(); i++) {
				h[i] = hashFunct.hash(ds.get(i).hashCode(), j);
			}
			min = Integer.MAX_VALUE;
			for (int i : h) {
				if (i < min) {
					min = i;
				}
			}
			a.add(min);

		}		
		this.matrix.add(a);

	}

	public void printMinHash() {
		int len = this.matrix.size();
		int count=0;
		for (int j = 0; j < this.totalHashes; j++) {

			for (int i = 0; i < len; i++) {
				System.out.printf("%d      ", this.matrix.get(i).get(j));
			}
			System.out.println();
		}

		int c =0;

		for (int x =0; x<Shingles.numFiles-1 ; x++) {
			for (int y =x+1; y<Shingles.numFiles ; y++) {
				for (int k =0; k<100 ; k++) {
					if (this.matrix.get(x).get(k).intValue() == this.matrix.get(y).get(k).intValue()) {
						c++;
					}
				}
				
				if(c/100.0 >=0.8) {
					System.out.println("SIMILAR FILES!");
					System.out.println("file"+x);
					System.out.println("file"+y);
					System.out.println();
				}
				System.out.printf("%s ", c/100.0);
				c = 0;
			}
		}
		

	}
}




