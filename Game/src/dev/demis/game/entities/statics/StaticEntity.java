package dev.demis.game.entities.statics;

import dev.demis.game.Handler;
import dev.demis.game.entities.Entity;
import dev.demis.game.tile.BrickTile;
import dev.demis.game.tile.Tile;

public abstract class StaticEntity extends Entity{
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
}