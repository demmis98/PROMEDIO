import java.io.*; // Uso la biblioteca de entradas/salidas
public class Ejemplo1 { // IMPORTANTE: Nombre de la clase
// igual al nombre del archivo!
 // entero para asignarle el valor del contador e imprimirlo
 // aunque en realidad no me hace falta.
 static int n;
 // y una variable tipo Contador para instanciar el objeto…
 static Contador laCuenta;
 // ESTE METODO, MAIN, ES EL QUE HACE QUE ESTO SE COMPORTE
 // COMO APLICACION. Es donde arranca el programa cuando ejecuto "java Ejemplo1"
 // NOTA: main debe ser public & static.
 public static void main ( String args[] ) {
 System.out.println ("Cuenta… "); // Imprimo el título
 laCuenta = new Contador(); // Creo una instancia del Contador
 System.out.println (laCuenta.getCuenta()); // 0 - Imprimo el valor actual (cero!)
 n = laCuenta.incCuenta(); // 1 - Asignación e incremento
 System.out.println (n); // Ahora imprimo n
 laCuenta.incCuenta(); // 2 - Lo incremento (no uso el valor…
 System.out.println (laCuenta.getCuenta()); // …de retorno) y lo imprimo
 System.out.println (laCuenta.incCuenta()); // 3 - Ahora todo en un paso!
 }
}