package dev.demis.game.states;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.entities.cratures.Player;
import dev.demis.game.entities.statics.Tree;
import dev.demis.game.tile.Tile;
import dev.demis.game.worlds.World;

public class GameState extends State {
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	
	}
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g){
		world.render(g);
	}
}