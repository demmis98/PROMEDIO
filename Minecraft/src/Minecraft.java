import javax.swing.*;
import java.awt.*;

public class Minecraft {
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = 0;
		int y = 0;
		GreenCube G = new GreenCube();
		f.add(G);
		f.setSize(640, 480);
		f.setVisible(true);
		int posx = 0;
		int posz = 0;
		int posy = 1;
	}
	public static void Blue(Graphics g, int x, int y) {
		Polygon poligono=new Polygon();
	    poligono.addPoint(20, 20);
	    poligono.addPoint(20, 30);
	    poligono.addPoint(30, 30);
	    poligono.addPoint(30, 20);
		g.setColor(Color.BLUE);
		g.fillPolygon(poligono);
	}
}