package dev.demis.game.entities.statics;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.entities.EntityManager;
import dev.demis.game.entities.cratures.Player;
import dev.demis.game.gfx.Assets;
import dev.demis.game.tile.Tile;

public class Rock extends StaticEntity{
	private EntityManager entityManager;
	
	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		entityManager = new EntityManager(handler, new Player(handler, 64, 64));
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void die() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	@Override
	public boolean isImmortal() {
		return true;
	}
	
}