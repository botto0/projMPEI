package mpeiproj;

import java.io.IOException;
import java.util.Scanner;

public class BFtest {

	public static void main(String args[]) throws IOException {

		double p;
		int n;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("p ? ");
		p = sc.nextDouble();

		System.out.println("n ? ");
		n = sc.nextInt();
		sc.close();

		/*------INSERT------*/
		long start = System.nanoTime();
		
		BloomFilter bf = new BloomFilter(n,p);
		String in;
		bf.init();
		for (int i = 0; i< n; i++) {
			in = "file" + i + ".txt";
			bf.insert(in);
		}
		
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.printf("Bloom Filter Insert Time: %f\n",timeElapsed*Math.pow(10, -9));
		/*-------*/

		/*------CHECK------*/
		start = System.nanoTime();
		
		for (int i = 0; i< n; i++) {
			in = "file" + i + ".txt";
			bf.check(in);
		}
		
		finish = System.nanoTime();
		timeElapsed = finish - start;
		System.out.printf("Bloom Filter Check Time: %f\n",timeElapsed*Math.pow(10, -9));
		/*-------*/






		//for (int i = 0; i< 50000; i++) {
		//BufferedReader br = new BufferedReader(new FileReader("/Users/botto/Desktop/ds/file" + i + ".txt"));
		// ((Scanner) fr).useDelimiter(" .;");			

		//br.close();
		//

	}


}

