import java.util.Scanner;

class Flojera {
	public static void main(String args[]) {
		System.out.println("How many numbers there are?");
		Scanner scan = new Scanner(System.in);
		int cant;
		cant = scan.nextInt();
		int cant2 = cant;
		List<String> list=new ArrayList<String>(); 
		while (cant != 0) {
			System.out.println(cant);
			--cant;
		}
	}
}