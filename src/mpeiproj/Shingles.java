package mpeiproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shingles {
	public static int numFiles;
	
	public static void main(String[] args) throws FileNotFoundException {
		minHash mh = new minHash(100);

		String dirname;
		System.out.println("Que dataset quer utilizar? ");
		Scanner scan = new Scanner(System.in);
		dirname=scan.nextLine();
		scan.close();

		if(dirname.contentEquals("equal")) {
			numFiles=2;
		}
		else {
			numFiles=100;
		}

		for (int i = 0; i < numFiles; i++) {
			ArrayList<String> ds = new ArrayList<String>();

			String fname= "/Users/botto/Desktop/"+dirname+"/file" + i + ".txt";
			Scanner sc = new Scanner(new File(fname));
			sc.useDelimiter("[\\s\\t\\n”“\\\".,:;-]");	

			String shingle = "";

			int count = 1;
			while (sc.hasNext()) {
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
			ds.add(shingle);
			sc.close();		
			mh.addMinHash(ds);
		}
		mh.printMinHash();


	}
}

