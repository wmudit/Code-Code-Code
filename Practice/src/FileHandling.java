import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) throws Exception {
		
		File input = new File("G:\\New folder\\A-small-practice.in");
		Scanner scanner = new Scanner(input);
		PrintWriter output = new PrintWriter("G:\\New folder\\output.out", "UTF-8");
		
		int T = scanner.nextInt();
		int N = scanner.nextInt();
		System.out.println(T + " " + N);
		for(int i=0; i<N; i++) {
			int a1 = scanner.nextInt();
			int a2 = scanner.nextInt();
			output.print("a1 = " + a1 + " a2 = " + a2);
			output.println();
		}
		scanner.close();
		output.close();
	}
	
}
