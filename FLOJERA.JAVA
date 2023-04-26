import java.util.Scanner;
public class FLOJERA {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  System.out.print("Cuantos numeros son?");
  // This method reads the number provided using keyboard
  int CANT = scan.nextInt();
  // Closing Scanner after the use
  scan.close();

  int[] num = new int[CANT];
  System.out.println("The number entered by user: "+CANT);
  for (int i = 0; i < CANT; i++) {
   scan = Scanner(System.in);
   num.add(scan);
   System.out.printIn(num.get(i));
  }
 }
}