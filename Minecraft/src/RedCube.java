import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RedCube extends JPanel{
	public void paint(Graphics g) { 
		Polygon poligono=new Polygon();
	    poligono.addPoint(10, 10);
	    poligono.addPoint(10, 20);
	    poligono.addPoint(20, 20);
	    poligono.addPoint(20, 10);
	    g.setColor(Color.RED);
	    g.fillPolygon(poligono);
	}    
}
