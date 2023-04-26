package dev.demis.game;

import dev.demis.game.gfx.GameCamera;
import dev.demis.game.input.KeyManager;
import dev.demis.game.input.MouseManager;
import dev.demis.game.inventory.Inventory;
import dev.demis.game.items.Item;
import dev.demis.game.worlds.World;

public class Handler {
	private Game game;
	private World world;
	private Item item;
	private Inventory inventory;
	public Handler(Game game) {
		this.game = game;
	}
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	public int getWidth() {
		return game.getWidth();
	}
	public int getHeight() {
		return game.getHeight()-300;
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}