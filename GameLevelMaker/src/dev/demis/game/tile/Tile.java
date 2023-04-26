package dev.demis.game.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static Tile[] tiles = new Tile[256];
	public static Tile brickTile = new BrickTile(0);
	public static Tile stoneTile = new StoneTile(1);
	public static Tile grassTile = new GrassTile(2);
	public static Tile rockBricksTile = new RockBricksTile(3);
	public static Tile rockGrassTile = new RockGrassTile(4);
	public static Tile brickDiagonal0 = new BrickDiagonal0(6);
	public static Tile brickDiagonal1 = new BrickDiagonal1(7);
	public static Tile brickDiagonal2 = new BrickDiagonal2(8);
	public static Tile brickDiagonal3 = new BrickDiagonal3(9);
	public static Tile roadHorizontalBorderUp = new RoadHorizontalBorderUp(10);
	public static Tile roadHorizontalBorderDown = new RoadHorizontalBorderDown(11);
	public static Tile roadHorizontalBorderLeft = new RoadHorizontalBorderLeft(12);
	public static Tile roadHorizontalBorderRight = new RoadHorizontalBorderRight(13);
	public static Tile roadHorizontal = new RoadHorizontal(14);
	public static Tile roadVerticalBorderUp = new RoadVerticalBorderUp(15);
	public static Tile roadVerticalBorderDown = new RoadVerticalBorderDown(16);
	public static Tile roadVerticalBorderLeft = new RoadVerticalBorderLeft(17);
	public static Tile roadVerticalBorderRight = new RoadVerticalBorderRight(18);
	public static Tile roadVertical = new RoadVertical(19);
	public static Tile roadLargeDiagonal0 = new RoadLargeDiagonal0(20);
	public static Tile roadLargeDiagonal1 = new RoadLargeDiagonal1(21);
	public static Tile roadLargeDiagonal2 = new RoadLargeDiagonal2(22);
	public static Tile roadLargeDiagonal3 = new RoadLargeDiagonal3(23);
	public static Tile roadEmpty = new RoadEmpty(24);
	public static Tile roadSmallDiagonal0 = new RoadSmallDiagonal0(25);
	public static Tile roadSmallDiagonal1 = new RoadSmallDiagonal1(26);
	public static Tile roadSmallDiagonal2 = new RoadSmallDiagonal2(27);
	public static Tile roadSmallDiagonal3 = new RoadSmallDiagonal3(28);
	public static Tile roadFull = new RoadFull(29);
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}