package dev.demis.game.items;

import java.awt.image.BufferedImage;

import dev.demis.game.Handler;
import dev.demis.game.entities.Entity;
import dev.demis.game.entities.statics.Box;
import dev.demis.game.tile.Tile;

public class BoxItem extends Item{
	private Handler handler;
	private int x, y, halfHeight,
	boxX, boxY;

	public BoxItem(BufferedImage texture, String name, int id, int craftId, int craftCant, int craftingResult) {
		super(texture, name, id, craftId, craftCant, craftingResult);
	}

	@Override
	public void use(Entity e) {
		halfHeight = e.getHeight();
		x = (int) (e.getX()/Tile.TILEWIDTH);
		y = (int) (e.getY()+halfHeight);
		y = (int) (y/Tile.TILEHEIGHT);
		boxX = x;
		boxY = y+1;
		return;
	}
}