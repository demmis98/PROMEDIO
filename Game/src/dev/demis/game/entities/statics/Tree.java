package dev.demis.game.entities.statics;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.gfx.Assets;
import dev.demis.game.items.Item;
import dev.demis.game.tile.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.y += bounds.height - 10;
		bounds.height = 10;
	}

	@Override
	public void tick() {
		
	}
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
}