package mpeiproj;

import java.lang.String;

public class BloomFilter {

	private byte[] bfArray; // declarar array que vai conter os valores do filtro
	private int sizebfArray; // tamanho do bloom filter
	private int nhashfnct;  	private int nElementos; // numero de elementos
	private static final double LN2 = 0.6931471805599453; // ln(2)

	public BloomFilter(int factor, int nElementos) {
		this.sizebfArray = (int) Math.round((double) nElementos / factor);
		this.nhashfnct = (int) Math.round((sizebfArray / nElementos) * LN2);

	}

	public byte[] initbfArray() {
		bfArray = new byte[this.sizebfArray];
		return bfArray;
	}

	public int string2hash(String str) {
		int hash = str.hashCode();
		return hash;
	}

	public byte[] getBfArray() {
		return bfArray;
	}

	public void setBfArray(byte[] bfArray) {
		this.bfArray = bfArray;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}


