public class Muestra extends Frame {
// atributos de la clase
Button si;
Button no;
// métodos de la clase:
public Muestra () {
Label comentario = new Label("Presione un botón", Label.CENTER);
si = new Button("Sí");
no = new Button("No");
add("North", comentario);
add("East", si);
add("West", no);
}
}