package dev.demis.game.states;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.gfx.Assets;
import dev.demis.game.tile.Tile;
import dev.demis.game.ui.ClickListener;
import dev.demis.game.ui.UIImageButton;
import dev.demis.game.ui.UIManager;
import dev.demis.game.ui.UIObject;

public class ConfigState extends State {
	private UIManager uiManager;
	
	public ConfigState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.removeAllObjects();
		uiManager.addObject(new UIImageButton(256, 180, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().menuState);
				uiManager.removeAllObjects();
			}}));
		uiManager.addObject(new UIImageButton(256, 30, 128, 64, Assets.btn_inventory, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().menuState);
			}}));
		
	}
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		g.drawImage(Assets.mouse ,handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}
}