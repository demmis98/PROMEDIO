package dev.demis.game.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.demis.game.Handler;
import dev.demis.game.entities.Entity;
import dev.demis.game.gfx.Assets;

public class Item {
	private Handler handlerItem;
	public static Item[] items = new Item[256];
	public static Item woodItem = new WoodItem(Assets.wood, "Wood", 0, 0, 1, 1);
	public static Item rockItem = new RockItem(Assets.rocks, "Rock", 1, 1, 1, 1);
	public static Item boxItem = new BoxItem(Assets.box, "Box",  2, 0, 2, 1);
	
	public static final int ITEMWIDTH = 20, ITEMHEIGHT = 20;
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id, craftId, craftCant, craftingResult;
	protected Rectangle bounds;
	
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, String name, int id, int craftId, int craftCant, int craftingResult) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		this.craftId = craftId;
		this.craftCant = craftCant;
		this.craftingResult = craftingResult;
		count = 1;
		
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		
		items[id] = this;
		items[id] = items[craftId];
		items[craftCant] = this;
	}
	public void tick() {
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	public void render(Graphics g) {
		if (handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id, craftId, craftCant, craftingResult);
		i.setPosition(x-3+(int)(Math.random() * 7)-(int)(Math.random() * 7), y-3+(int)(Math.random() * 7)-(int)(Math.random() * 7));
		return i;
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	public void use(Entity e) {
		return;
	};
	
	
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public BufferedImage getTexture() {
		return texture;
	}
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public boolean isPickedUp() {
		return pickedUp;
	}
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
	public int getCraftId() {
		return craftId;
	}
	public int getCraftCant() {
		return craftCant;
	}
	public int getCraftingResult() {
		return craftingResult;
	}
}