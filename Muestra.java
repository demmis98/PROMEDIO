public class Muestra extends Frame {
// atributos de la clase
Button si;
Button no;
// m�todos de la clase:
public Muestra () {
Label comentario = new Label("Presione un bot�n", Label.CENTER);
si = new Button("S�");
no = new Button("No");
add("North", comentario);
add("East", si);
add("West", no);
}
}