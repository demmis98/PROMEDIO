package dev.demis.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.demis.game.Handler;
import dev.demis.game.entities.cratures.Player;
import dev.demis.game.tile.BrickTile;
import dev.demis.game.tile.Tile;
import dev.demis.game.worlds.World;

public class EntityManager {
	private Handler handler;
	private Player player;
	private Rectangle cameraRect;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + a.getHeight())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	public void tick(){
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
		}
		entities.sort(renderSorter);
	}
	public void render(Graphics g) {
		cameraRect = new Rectangle((int)handler.getGameCamera().getxOffset(), (int)handler.getGameCamera().getyOffset(),  680+(int)handler.getGameCamera().getxOffset(), 500+(int)handler.getGameCamera().getyOffset());
		for(Entity e : entities) {
			if(cameraRect.intersects(e.getCollisionBounds(handler.getGameCamera().getxOffset(), handler.getGameCamera().getyOffset()))) {
				e.render(g);
			}
		}
		player.postRender(g);
	}
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}