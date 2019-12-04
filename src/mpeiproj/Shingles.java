package mpeiproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shingles {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> ds = new ArrayList<String>();
		Scanner sc = new Scanner(new File("/Users/botto/Desktop/ds/file0.txt"));
		sc.useDelimiter("[\\shingle\\t\\n.,:';?!*{}=+&/()”“\"-_]+");		
		/*String x = "";
		int count=0;

		while (sc.hasNext()) {
			x = sc.next();
			if (count % 10 != 0) {
				shingle = shingle + x;
			}
			count++;
			ds.add(shingle);
			shingle="";
		}
		if (shingle.length()!=0) {
			ds.add(shingle);
		}
		sc.close();
		System.out.println(ds);*/

		int count = 1;
		String shingle = "";
		
		while (sc.hasNext()) {
			System.out.println(count);
			if((count % 10) != 0) {
				shingle += sc.next();
				count = count +1;
			}
			else {
				ds.add(shingle);
				count = 1;
				shingle = "";
			}
		}
		sc.close();
		System.out.println(ds);
		minHash mh = new minHash(ds,100);
	}
}

