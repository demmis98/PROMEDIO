package dev.demis.game.tile;

import dev.demis.game.gfx.Assets;

public class RockGrassTile extends Tile {

	public RockGrassTile(int id) {
		super(Assets.rockGrass, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}