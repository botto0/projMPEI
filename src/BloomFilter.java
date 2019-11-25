public class BloomFilter {

	private int[] bfArray; // Declarar array que vai conter os valores do filtro
	private int sizebfArray; // tamanho do bloom filter
	private int fc; // Fator de Carga
	private int hashfnct; // funçoes hash
	private int nElementos; // numero de elementos

	public BloomFilter(int fc, int nElementos) {
		this.fc = fc;
		this.sizebfArray = (int) Math.round((double) nElementos / fc);
		this.nhash = (int) Math.round((sizebfArray / nElementos) * Math.log(2));

	}

	public int[] initbfArray() {
		bfArray = new int[this.sizebfArray];
		return bfArray;
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
