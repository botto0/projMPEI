public class BloomFilter {

	private int[] bfArray; // Declarar array que vai conter os valores do filtro
	private int fc; // Fator de Carga
	private int n; // number of hash functions

	public BloomFilter(int fc, int n, int size) {
		this.fc = fc;
		this.n = n;
		bfArray = new int[size];
	}

	public int[] getBfArray() {
		return bfArray;
	}

	public void setBfArray(int[] bfArray) {
		this.bfArray = bfArray;
	}

	public int getFc() {
		return fc;
	}

	public void setFc(int fc) {
		this.fc = fc;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	

}
