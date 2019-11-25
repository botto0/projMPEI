public class hash {
	static int hash(String s, int tableSize) {
		
		// esta função hash baseia-se na função hash apresentada no slide 25 
		// da TP de funções hash
		
		char[] key = s.toCharArray()
;		
		int hashval = 0;
		
		for (int i = 0; i < key.length; i++) {
			hashval = 37 * hashval + key[i];
		}
		
		hashval = hashval % tableSize;
		
		if (hashval < 0) {
			hashval = hashval + tableSize;
		}
		return hashval;
	}
}
