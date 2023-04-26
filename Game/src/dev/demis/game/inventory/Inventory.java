package dev.demis.game.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.demis.game.Handler;
import dev.demis.game.gfx.Assets;
import dev.demis.game.gfx.Text;
import dev.demis.game.items.Item;

public class Inventory {
	private Handler handler;
	private boolean active = false, craft = false;
	private ArrayList<Item> inventoryItems;
	private ArrayList<Item> totalItems;
	private ArrayList<Item> avilableCrafts;
	private boolean[] inventoryCrafts;
	private int[] craftsInventory;
	private int itemId;
	private Item craftItem, craftedItem;
	public Item itemInHand;
	private boolean crafting, craftListener;
	public boolean itemInHandListener;
	private int length;
	
	private int craftNum, num, numb, quantity;
	
	private int invListX = 100,
			invListY = 75,
			invListCenterX = 228,
			invListCenterY = 222,
			invListSpacing = 32,
			invListNum = 0;
	
	private int invTitleX = 465,
			invTitleY = 320;
	
	private int invImageWidth = 100, invImageHeight = 100,
			invImageX = 450, invImageY = 80;
	
	private int selectedItem = 0;
	private int selectedCraft = 0;
	
	public Inventory(Handler handler) {
		itemInHandListener = false;
		this.handler = handler;
		length = 0;
		inventoryItems = new ArrayList<Item>();
		totalItems = new ArrayList<Item>();
		for(Item i : Item.items) {
			if(i != null) {
				totalItems.add(i);
			}
		}
		avilableCrafts = new ArrayList<Item>();
		craftsInventory = new int[Item.items.length];
		inventoryCrafts = new boolean[256];
	}
	public void tick() {
		if(itemInHand != null)
			itemInHandListener = true;
		else
			itemInHandListener = false;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)) {
			if(!craft)
				selectedItem--;
			else
				selectedCraft--;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)) {
			if(!craft)
				selectedItem++;
			else
				selectedCraft++;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT))
			craft = !craft;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT))
			craft = !craft;
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
		if(selectedCraft < 0)
			selectedCraft = avilableCrafts.size() - 1;
		else if(selectedCraft >= avilableCrafts.size())
			selectedCraft = 0;
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {
			crafting = true;
		}
		if(!handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {
			crafting = false;
		}
		if(craft)
			if(crafting) {
				craftListener = true;
			}else craftListener = false;
		else
			craftListener = false;
	}
	@SuppressWarnings("static-access")
	public void render(Graphics g) {
		if(!active)
			return;
		g.drawImage(Assets.inventoryScreen, 0, 0, 640, 480, null);
		if(!craft) {
			Text.drawString(g, "Inventory", invTitleX, invTitleY, true, Color.BLACK, Assets.font32);
			int len = inventoryItems.size();
			if(len == 0)
				return;
			invListNum = 0;
			for(Item i : inventoryItems) {
				if(invListNum == selectedItem) {
					itemInHand = i;
					if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {
						active = false;
					}
					Text.drawString(g, "~" + i.getName() + "*" + i.getCount(), invListX, invListY+(invListSpacing*invListNum), false, Color.BLACK, Assets.font32);
				}else 
					Text.drawString(g, i.getName() + "*" + i.getCount(), invListX, invListY+(invListSpacing*invListNum), false, Color.BLACK, Assets.font32);
				invListNum += 1;
			}
			Item item = inventoryItems.get(selectedItem);
			g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		}else {
			Text.drawString(g, "Crafts", invTitleX, invTitleY, true, Color.BLACK, Assets.font32);
			int len = inventoryItems.size();
			if(len == 0)
				return;
			avilableCrafts = new ArrayList<Item>();
			if(inventoryItems.size() <= 0)
				return;
			craftNum = 0;
			for(Item i : totalItems) {
				for(Item t : inventoryItems) {
					if(t.getId() == i.getCraftId()) {
						if(t.getCount() >= i.getCraftCant())
							avilableCrafts.add(i);
					}
				}
			}avilableCrafts = new ArrayList<Item>();
			if(inventoryItems.size() <= 0)
				return;
			craftNum = 0;
			for(Item i : totalItems) {
				for(Item t : inventoryItems) {
					if(t.getId() == i.getCraftId()) {
						if(t.getCount() >= i.getCraftCant())
							avilableCrafts.add(i);
					}
				}
			}
			for(Item i : avilableCrafts) {
				if(craftNum == selectedCraft) {
					craftedItem = i;
					g.drawImage(i.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
					Text.drawString(g, "~" + i.getName(), invListX, invListY+(invListSpacing*craftNum), false, Color.BLACK, Assets.font32);
				}else 
					Text.drawString(g, i.getName(), invListX, invListY+(invListSpacing*craftNum), false, Color.BLACK, Assets.font32);
				craftNum ++;
			}
			len = inventoryItems.size();
			if(len == 0)
				return;
			avilableCrafts = new ArrayList<Item>();
			if(inventoryItems.size() <= 0)
				return;
			craftNum = 0;
			for(Item i : totalItems) {
				for(Item t : inventoryItems) {
					if(t.getId() == i.getCraftId()) {
						if(t.getCount() >= i.getCraftCant())
							avilableCrafts.add(i);
					}
				}
			}
		}
		if(craftListener) {
			craft(craftedItem);
			avilableCrafts = new ArrayList<Item>();
			if(inventoryItems.size() <= 0)
				return;
			craftNum = 0;
			for(Item i : totalItems) {
				for(Item t : inventoryItems) {
					if(t.getId() == i.getCraftId()) {
						if(t.getCount() >= i.getCraftCant())
							avilableCrafts.add(i);
					}
				}
			}
			selectedCraft = 0;
		}
	}
	
	
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
		itemInHandListener = true;
		length++;
	}
	public void addItem(Item item, int cant) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + cant);
				return;
			}
		}
		inventoryItems.add(item);
		itemInHandListener = true;
		length++;
	}
	public void restItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() - item.getCount());
				if(i.getCount() == 0) {
					inventoryItems.remove(item);
				}
				length--;
				return;
			}
		}
	}
	public void restItem(Item item, int cant) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() - cant);
				if(i.getCount() == 0)
					inventoryItems.remove(item);
				length--;
				return;
			}
		}
	}
	public void craft(Item itemer) {
		craftNum = 0;
		selectedCraft = 0;
		
		addItem(itemer, itemer.getCraftingResult());
		for(Item i : inventoryItems) {
			if(i.getId() == itemer.getCraftId()) {
				restItem(i, itemer.getCraftCant());
				return;
			}
		}
	}
	
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public boolean isActive() {
		return active;
	}
	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}
	public void setInventoryItems(ArrayList<Item> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}
	public int[] getCraftsInventory() {
		return craftsInventory;
	}
	public void setCraftsInventory(int[] craftsInventory) {
		this.craftsInventory = craftsInventory;
	}
	public boolean isCraft() {
		return craft;
	}
	public void setCraft(boolean craft) {
		this.craft = craft;
	}
	public boolean isCrafting() {
		return crafting;
	}
	public void setCrafting(boolean crafting) {
		this.crafting = crafting;
	}
	public Item getCraftedItem() {
		return craftedItem;
	}
	public void setCraftedItem(Item craftedItem) {
		this.craftedItem = craftedItem;
	}
}