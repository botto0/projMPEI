package mpeiproj;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataSet {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {

			try {
				Scanner dataset = new Scanner(new File("ds.txt"),"UTF-8");
				try {
					Formatter files = new Formatter(new File("file"+1+".txt"));
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}
}
