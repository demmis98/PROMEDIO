package dev.demis.game.tile;

import dev.demis.game.gfx.Assets;

public class RockBricksTile extends Tile {

	public RockBricksTile(int id) {
		super(Assets.rockBricks, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}