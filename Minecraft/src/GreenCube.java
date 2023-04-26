import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GreenCube extends JPanel{
	public void paint(Graphics g) {
		Polygon poligono=new Polygon();
		int x = 0;
		int y = 0;
		int z = y + 10;
		int w = x + 10;
	    poligono.addPoint(x, y);
	    poligono.addPoint(x, z);
	    poligono.addPoint(w, z);
	    poligono.addPoint(w, y);
	    g.setColor(Color.GREEN);
	    g.fillPolygon(poligono);
	}    
}
