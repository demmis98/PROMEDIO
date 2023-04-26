package dev.demis.game.states;

import java.awt.Graphics;

import dev.demis.game.Handler;
import dev.demis.game.gfx.Assets;
import dev.demis.game.tile.Tile;
import dev.demis.game.ui.ClickListener;
import dev.demis.game.ui.UIImageButton;
import dev.demis.game.ui.UIManager;

public class MenuState extends State {
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.removeAllObjects();
		uiManager.addObject(new UIImageButton(256, 280, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		uiManager.addObject(new UIImageButton(256, 350, 128, 64, Assets.btn_config, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getGame().configState);
			}}));
//		uiManager.addObject(new UIImageButton(256, 350, 128, 64, Assets.btn_config, new ClickListener() {
//				@Override
//				public void onClick() {
//					State.setState(handler.getGame().configState);
//				}}));

		
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