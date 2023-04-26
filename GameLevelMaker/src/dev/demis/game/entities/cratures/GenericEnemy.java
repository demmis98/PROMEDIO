package dev.demis.game.entities.cratures;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.gfx.Assets;

public class GenericEnemy extends Creature{

	public GenericEnemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		xMove = speed;
	}

	@Override
	public void tick() {
		moveX();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.enemy,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
	}

}