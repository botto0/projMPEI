package mpeiproj;

import java.util.Arrays;
import java.util.Random;

public class UHASH {
	private int[] v1;
	private int[] v2;
	private int numHashes = 100;
	private int prime = 1000003 - 1;
	public UHASH() {
		this.v1 = new int[this.numHashes];
		this.v2 = new int[this.numHashes];

		Random rand = new Random();
		for (int i = 0; i < this.numHashes; i++) {
			this.v1[i] = rand.nextInt(this.prime + 1) + 1;
			this.v2[i] = rand.nextInt(this.prime + 1) + 1;
		}
		//System.out.println(Arrays.toString(v1));
		//System.out.println(Arrays.toString(v2));

	}

	public int[] getV1() {
		return v1;
	}

	public int[] getV2() {
		return v2;
	}

	public int hash(int hcode, int i) {
		return Math.abs((v1[i] * hcode + v2[i]) % (this.prime +1)) ;
	}
}
