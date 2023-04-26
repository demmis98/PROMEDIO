package dev.demis.game.states;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.entities.Entity;
import dev.demis.game.entities.EntityManager;
import dev.demis.game.entities.cratures.Player;
import dev.demis.game.entities.statics.Tree;
import dev.demis.game.gfx.Assets;
import dev.demis.game.gfx.ImageLoader;
import dev.demis.game.input.MouseManager;
import dev.demis.game.items.Item;
import dev.demis.game.tile.Tile;
import dev.demis.game.ui.UIManager;
import dev.demis.game.ui.ClickListener;
import dev.demis.game.ui.UIImageButton;
import dev.demis.game.worlds.World;

public class GameState extends State {
	private UIManager uiManager;
	private World world;
	private Item selectedItem;
	private Item mouseEntity;
	private EntityManager entityManager;
	private Handler handler;
	private MouseManager mouseManager;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(0, 399, 64, 81, Assets.editorBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(64, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(128, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(192, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(256, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(320, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(384, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(448, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(512, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(576, 399, 64, 81, Assets.editorItemBtn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
	
	}
	@Override
	public void tick() {
		world.tick();
		uiManager.tick();
	}

	@Override
	public void render(Graphics g){
		world.render(g);
		uiManager.render(g);
	}
}