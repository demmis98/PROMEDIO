//package dev.demis.game.entities.cratures;
//
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
//import java.awt.image.BufferedImage;
//
//import dev.demis.game.Handler;
//import dev.demis.game.entities.Entity;
//import dev.demis.game.gfx.Animation;
//import dev.demis.game.gfx.Assets;
//import dev.demis.game.inventory.Inventory;
//import dev.demis.game.items.Item;
//
//public class PlayerSave extends Creature {
//	private Animation upAni;
//	private Animation downAni;
//	private Animation down_atk;
//	private Animation downAtk;
//	private Animation leftAni;
//	private Animation rightAni;
//	private boolean atk = false;
//	boolean acting = false, tossing = false, running = false;
//	private int atacking = 3, actionListener, tossListener;
//	private boolean moving = false, itemTossBouundsCollide;
//	private Rectangle itemTossBounds;
//	
//	private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;
//	
//	private Inventory inventory;
//	
//	private int still;
//	public PlayerSave(Handler handler, float x, float y) {
//		super(handler, x, y, Creature.DEFAULT_CRATURE_WIDTH, Creature.DEFAULT_CRATURE_HEIGHT);
//		actionListener = 0;
//		
//		bounds.x = 0;
//		bounds.y = 21;
//		bounds.width = 31;
//		bounds.height = 10;
//		itemTossBounds = new Rectangle();
//
//		upAni = new Animation(250, Assets.player_up);
//		downAni = new Animation(250, Assets.player_down);
//		down_atk = new Animation(250, Assets.player_down_attack);
//		downAtk = new Animation(250, Assets.player_downAttack);
//		leftAni = new Animation(250, Assets.player_left);
//		rightAni = new Animation(250, Assets.player_right);
//		
//		inventory = new Inventory(handler);
//	}
//	@Override
//	public void tick() {
//		//Animations
//		upAni.tick();
//		downAni.tick();
//		leftAni.tick();
//		rightAni.tick();
//		//Movement
//		getInput();
//		move();
//		handler.getGameCamera().centerOnEntity(this);
//		// Attack
//		checkAttacks();
//		// Inventory
//		inventory.tick();
//		
//	}
//	private void checkAttacks() {
//		atk = true;
//		attackTimer += System.currentTimeMillis() - lastAttackTimer;
//		lastAttackTimer = System.currentTimeMillis();
//		if(attackTimer < attackCooldown)
//			return;
//		if(inventory.isActive())
//			return;
//		
//		Rectangle cb = getCollisionBounds(0, 0);
//		Rectangle ar = new Rectangle();
//		int arSize= 20;
//		ar.width = arSize;
//		ar.height = arSize;
//		
//		switch (still) {
//		case 0:
//			ar.x = cb.x - arSize;
//			ar.y = cb.y;
//			ar.width = arSize;
//			ar.height = cb.height;
//			break;
//		case 1:
//			ar.x = cb.x + cb.width;
//			ar.y = cb.y;
//			ar.width = arSize;
//			ar.height = cb.height;
//			break;
//		case 2:
//			ar.x = cb.x + cb.width /2 - arSize;
//			ar.y = cb.y - arSize;
//			ar.height = arSize;
//			ar.width = cb.width;
//			break;
//		case 3:
//			ar.x = cb.x + cb.width /2 - arSize;
//			ar.y = cb.y + cb.height;
//			ar.height = arSize;
//			ar.width = cb.width;
//			break;
//		default:
//			ar.x = cb.x + cb.width /2 - arSize;
//			ar.y = cb.y + cb.height;
//			ar.height = arSize;
//			ar.width = cb.width;
//			break;
//		}
//		attackTimer = 0;
//		
//		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
//			if(e.equals(this))
//				continue;
//			if(e.isImmortal())
//				continue;
//			if(e.getCollisionBounds(0, 0).intersects(ar)) {
//				e.hurt(1);
//				return;
//			}
//		}
//	}
//	private void getInput() {
//		xMove = 0;
//		yMove = 0;
//		if(inventory.isActive())
//			return;
//		
//		if(handler.getKeyManager().up)
//			if(!running)
//				yMove = -speed;
//			else
//				yMove = -speed*3/2;
//		if(handler.getKeyManager().down)
//			if(!running)
//				yMove = speed;
//			else
//				yMove = speed*3/2;
//		if(handler.getKeyManager().left)
//			if(!running)
//				xMove = -speed;
//			else
//				xMove = -speed*3/2;
//		if(handler.getKeyManager().right)
//			if(!running)
//				xMove = speed;
//			else
//				xMove = speed*3/2;
//		
//	}
//	public void die() {
//		System.out.println("You lose");
//	}
//	
//	@Override
//	public void render(Graphics g) {
//		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//	}
//	
//	public void postRender(Graphics g){
//		inventory.render(g);
//	}
//	
//	private BufferedImage getCurrentAnimationFrame() {
//		if(xMove < 0) {
//			moving = true;
//			still = 0;
//			return leftAni.getCurrentFrame();
//		}else if(xMove > 0) {
//			moving = true;
//			still = 1;
//			return rightAni.getCurrentFrame();
//		}else if(yMove < 0) {
//			moving = true;
//			still = 2;
//			return upAni.getCurrentFrame();
//		}else if(yMove > 0){
//				moving = true;
//				still = 3;
//				return downAni.getCurrentFrame();
//		}else {
//			moving = false;
//				switch (still) {
//					case 0:
//						return Assets.player_leftStill;
//					case 1:
//						return Assets.player_rightStill;
//					case 2:
//						return Assets.player_upStill;
//					case 3:
//						return Assets.player_downStill;
//				default:
//					return Assets.player_downStill;
//				}
//		}
//	}
//	public void toss(Item e, int direction) {
//		if(e.getCount()==0)
//			return;
//		inventory.restItem(e, 1);
//		switch(direction) {
//		case 0:
//			handler.getWorld().getItemManager().addItem(e.createNew((int) x-Item.ITEMWIDTH-((width-Item.ITEMWIDTH)/2), (int) y+((height-Item.ITEMHEIGHT)/2)+((height-Item.ITEMHEIGHT)/4)));
//			break;
//		case 1:
//			handler.getWorld().getItemManager().addItem(e.createNew((int) x+width+((width-Item.ITEMWIDTH)/2)+((width-Item.ITEMWIDTH)/4)+((width-Item.ITEMWIDTH)/8), (int) y+((height-Item.ITEMHEIGHT)/2)+((height-Item.ITEMHEIGHT)/4)));
//			break;
//		case 2:
//			handler.getWorld().getItemManager().addItem(e.createNew((int) x+((width-Item.ITEMWIDTH)/2)+((width-Item.ITEMWIDTH)/4), (int) y-Item.ITEMHEIGHT-((height-Item.ITEMHEIGHT)/2)));
//			break;
//		case 3:
//			handler.getWorld().getItemManager().addItem(e.createNew((int) x+((width-Item.ITEMWIDTH)/2)+((width-Item.ITEMWIDTH)/4), (int) y+height+((height-Item.ITEMHEIGHT)/2)+((height-Item.ITEMHEIGHT)/2)));
//			break;
//		default:
//			break;
//		}
//	}
//	public Inventory getInventory() {
//		return inventory;
//	}
//	public void setInventory(Inventory inventory) {
//		this.inventory = inventory;
//	}
//}