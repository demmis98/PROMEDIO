package dev.demis.game.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.demis.game.gfx.Assets;

public class UIImageButton extends UIObject{
	private BufferedImage[] images;
	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int heght, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, heght);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		}else {
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
			}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}
	
}