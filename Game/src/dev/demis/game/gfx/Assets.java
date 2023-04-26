package dev.demis.game.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 16, height = 16;
	public static Font font32;
	
	public static BufferedImage brick, stone, grass, rockBricks, rockGrass,
	brickDiagonal0, brickDiagonal1, brickDiagonal2, brickDiagonal3,
	bigTree;
	public static BufferedImage player_upStill, player_downStill, player_leftStill, player_rightStill;
	public static BufferedImage cube, enemy,cubeBlink, enemyBlink, rock, tree, mouse, box, rocks, chest;
	public static BufferedImage wood;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_down_attack, player_downAttack;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_config;
	public static BufferedImage[] btn_inventory;
	public static BufferedImage inventoryScreen;
	public static BufferedImage roadHorizontalBorderUp, roadHorizontalBorderDown, roadHorizontalBorderLeft, roadHorizontal, roadHorizontalBorderRight,
	roadVerticalBorderUp, roadVerticalBorderDown, roadVerticalBorderLeft, roadVertical, roadVerticalBorderRight,
	roadLargeDiagonal0, roadLargeDiagonal1, roadLargeDiagonal2, roadLargeDiagonal3, roadEmpty,
	roadSmallDiagonal0, roadSmallDiagonal1, roadSmallDiagonal2, roadSmallDiagonal3, roadFull;
	
	public static void init() {
		font32 = FontLoader.loadFont("res/fonts/gameboy.ttf", 26);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprites.png"));
		
		brick =  sheet.crop(width*4, 0, width, height);
		stone = sheet.crop(0, height, width, height);
		grass = sheet.crop(width, height, width, height);
		rockBricks = sheet.crop(width*2, height, width, height);
		rockGrass = sheet.crop(width*3, height, width, height);
		brickDiagonal0 = sheet.crop(width*8, height*3, width, height);
		brickDiagonal1 = sheet.crop(width*9, height*3, width, height);
		brickDiagonal2 = sheet.crop(width*8, height*4, width, height);
		brickDiagonal3 = sheet.crop(width*9, height*4, width, height);
		bigTree = sheet.crop(width*10, height*3, width*2, height*2);
		
		cube = sheet.crop(0, 0, width, height);
		enemy =  sheet.crop(width, 0, width, height);
		cubeBlink = sheet.crop(width*2, 0, width, height);
		enemyBlink =  sheet.crop(width*3, 0, width, height);
		rock = sheet.crop(width*4, height*3, width, height);
		tree = sheet.crop(width*5, height*3, width, height);
		mouse = sheet.crop(width*6, height*3, width, height);
		box = sheet.crop(width*7, height*3, width, height);
		rocks = sheet.crop(width*5, height*5, width, height);
		chest = sheet.crop(width*6, height*5, width, height);
		
		player_up = new BufferedImage[4];
		player_upStill = sheet.crop(width*5, 0, width, height);
		player_up[0] = sheet.crop(width*5, height, width, height);
		player_up[1]= sheet.crop(width*5, 0, width, height);
		player_up[2] = sheet.crop(width*5, height*2, width, height);
		player_up[3] = sheet.crop(width*5, 0, width, height);
		
		player_down = new BufferedImage[4];
		player_downStill = sheet.crop(width*4, height, width, height);
		player_down[0] = sheet.crop(0, height*2, width, height);
		player_down[1] = sheet.crop(width*4, height, width, height);
		player_down[2] = sheet.crop(width, height*2, width, height);
		player_down[3] = sheet.crop(width*4, height, width, height);
		
		player_down_attack = new BufferedImage[4];
		player_down[0] = sheet.crop(width*7, 0, width, height);
		player_down[1] = sheet.crop(width*4, height, width, height);
		player_down[2] = sheet.crop(width*7, height, width, height);
		player_down[3] = sheet.crop(width*4, height, width, height);
		player_downAttack = new BufferedImage[4];
		player_down[0] = sheet.crop(width*7, height*2, width, height);
		player_down[1] = sheet.crop(width*4, height, width, height);
		player_down[2] = sheet.crop(width*8, 0, width, height);
		player_down[3] = sheet.crop(width*4, height, width, height);
		
		player_left = new BufferedImage[4];
		player_leftStill = sheet.crop(width*6, 0, width, height);
		player_left[0] = sheet.crop(width*6, height, width, height);
		player_left[1] = sheet.crop(width*6, 0, width, height);
		player_left[2] = sheet.crop(width*6, height*2, width, height);
		player_left[3] = sheet.crop(width*6, 0, width, height);
		
		player_right = new BufferedImage[4];
		player_rightStill = sheet.crop(width*2, height*2, width, height);
		player_right[0] = sheet.crop(width*3, height*2, width, height);
		player_right[1] = sheet.crop(width*2, height*2, width, height);
		player_right[2] = sheet.crop(width*4, height*2, width, height);
		player_right[3] = sheet.crop(width*2, height*2, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(0, height*4, width*2, height);
		btn_start[1] = sheet.crop(width*2, height*4, width*2, height);

		btn_config = new BufferedImage[2];
		btn_config[0] = sheet.crop(width*4, height*4, width*2, height);
		btn_config[1] = sheet.crop(width*6, height*4, width*2, height);
		
		btn_inventory = new BufferedImage[2];
		btn_inventory[0] = sheet.crop(width, height*5, width*2, height);
		btn_inventory[1] = sheet.crop(width*3, height*5, width*2, height);
		inventoryScreen = ImageLoader.loadImage("/textures/inventory.png");
		
		wood = sheet.crop(0, height*5, width, height);
		

		roadHorizontalBorderUp = sheet.crop(width*12, height*3, width, height);
		roadHorizontalBorderDown = sheet.crop(width*12, height*4, width, height);
		roadHorizontalBorderLeft = sheet.crop(width*13, height, width, height);
		roadHorizontal = sheet.crop(width*14, height, width, height);
		roadHorizontalBorderRight = sheet.crop(width*15, height, width, height);
		roadVerticalBorderUp = sheet.crop(width*13, height*2, width, height);
		roadVertical = sheet.crop(width*13, height*3, width, height);
		roadVerticalBorderDown = sheet.crop(width*13, height*4, width, height);
		roadVerticalBorderLeft = sheet.crop(width*12, height*5, width, height);
		roadVerticalBorderRight = sheet.crop(width*13, height*5, width, height);
		roadLargeDiagonal0 = sheet.crop(width*15, height*4, width, height);
		roadLargeDiagonal1 = sheet.crop(width*14, height*4, width, height);
		roadLargeDiagonal2 = sheet.crop(width*14, height*5, width, height);
		roadLargeDiagonal3 = sheet.crop(width*15, height*5, width, height);
		roadEmpty = sheet.crop(width*11, height*5, width, height);
		roadSmallDiagonal0 = sheet.crop(width*15, height*2, width, height);
		roadSmallDiagonal1 = sheet.crop(width*14, height*2, width, height);
		roadSmallDiagonal2 = sheet.crop(width*14, height*3, width, height);
		roadSmallDiagonal3 = sheet.crop(width*15, height*3, width, height);
		roadFull = sheet.crop(width*10, height*5, width, height);
	}
}