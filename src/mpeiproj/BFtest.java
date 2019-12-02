package mpeiproj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BFtest {

	public static void main(String args[]) throws IOException {
		/*double p;
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("p ? ");
		p = sc.nextDouble();
		
		System.out.println("n ? ");
		n = sc.nextInt();
		sc.close();
*/
		BloomFilter bf = new BloomFilter(10,0.01);
		bf.init();
		
		bf.insert("Lucas");
		bf.check("Lucas");
		bf.check("asd");
		
		FileReader fr = new FileReader("ds.txt"); 

		int i; 
		while ((i=fr.read()) != -1) 
			System.out.print((char) i); 
		
		fr.close();
		
	}
}
