package dev.demis.game;

import dev.demis.game.display.Display;

public class Launcher {
	public static void main(String[] args) {

		Game game = new Game("Game", 640, 480);
		game.start();
	}
}
