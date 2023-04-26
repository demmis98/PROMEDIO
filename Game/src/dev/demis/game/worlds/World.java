package dev.demis.game.worlds;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.entities.Entity;
import dev.demis.game.entities.EntityManager;
import dev.demis.game.entities.cratures.Creature;
import dev.demis.game.entities.cratures.GenericEnemy;
import dev.demis.game.entities.cratures.Player;
import dev.demis.game.entities.statics.BigTree;
import dev.demis.game.entities.statics.Box;
import dev.demis.game.entities.statics.Chest;
import dev.demis.game.entities.statics.Rock;
import dev.demis.game.entities.statics.Rocks;
import dev.demis.game.entities.statics.Tree;
import dev.demis.game.items.ItemManager;
import dev.demis.game.tile.Tile;
import dev.demis.game.utils.Utils;

public class World {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	int tilesNum = 4;
	private int[][] creatures;
	
	private EntityManager entityManager;
	private ItemManager itemManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 64, 64));
		itemManager = new ItemManager(handler);
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX*Tile.TILEWIDTH);
		entityManager.getPlayer().setY(spawnY*Tile.TILEHEIGHT);
	}
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 8);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
		
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public ItemManager getItemManager() {
		return itemManager;
	}
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.brickTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.brickTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++) {
				tilesNum++;
				tiles[x][y] = Utils.parseInt(tokens[(x + y*width + 4)]);
			}
		}
		creatures = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++) {
				creatures[x][y] = Utils.parseInt(tokens[(x + y*width + tilesNum)]);
				switch(creatures[x][y]){
				case 0:
					break;
				case 1:
					entityManager.addEntity(new Tree(handler, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT));
					break;
				case 2:
					entityManager.addEntity(new Rock(handler, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT));
					break;
				case 3:
					entityManager.addEntity(new Rocks(handler, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT));
					break;
				case 4:
					entityManager.addEntity(new Box(handler, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT));
					break;
				case 5:
					entityManager.addEntity(new Chest(handler, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT));
					break;
				case 6:
					entityManager.addEntity(new BigTree(handler, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT));
					break;
				default:
					break;
				}
			}
		}

	}
	public void addEntity(Entity e) {
		entityManager.addEntity(e);
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}