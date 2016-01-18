package me.Pawel.Cases.listeners;

import java.util.HashMap;
import java.util.Random;

import me.Pawel.Cases.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class RandMenu implements Listener {
	private int taskId;
	@EventHandler(ignoreCancelled=false, priority=EventPriority.HIGHEST)
	public boolean InventoryClick(InventoryClickEvent e) throws InterruptedException{

    	Player p = (Player) e.getWhoClicked();  
		InvCheck:
		{
	        if(e.getInventory().getTitle().contains("§cMine:GO Case")){
	        	if(e.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)){
					try{
						if(e.getInventory().getItem(12).getType().equals(Material.CHEST) && e.getInventory().getItem(14).getType().equals(Material.TRIPWIRE_HOOK)){
							int chest = e.getInventory().getItem(12).getAmount();
							int key = e.getInventory().getItem(14).getAmount();
							
							if(chest == 1 && key == 1){
								e.getInventory().setItem(12, new ItemStack(Material.AIR));
								e.getInventory().setItem(14, new ItemStack(Material.AIR));
								p.sendMessage("§cLosowanie...");
								p.closeInventory();
								break InvCheck;
							} else {
								chest--;
								key--;
								
								e.getInventory().setItem(12, new ItemStack(Material.AIR));
								e.getInventory().setItem(14, new ItemStack(Material.AIR));
								
								if(chest != 0)
									p.getInventory().addItem(new ItemStack(Material.CHEST, chest));
								if(key != 0)
									p.getInventory().addItem(new ItemStack(Material.TRIPWIRE_HOOK, key));
								p.sendMessage("§cLosowanie...");
								p.closeInventory();
								break InvCheck;
							}
						}
					} catch (NullPointerException event){
	        			e.setCancelled(true);
	        			p.sendMessage("§cZla zawartosc okien.");
					}
	        	}
	        }
	        return true;
		}
    	Inventory RandMenuInv;
    	RandMenuInv = Bukkit.createInventory(null, 27, "§cMine Case - LOSOWANIE");
		{
			
			RandMenuInv.setItem(0, emptyglasspanel);
			RandMenuInv.setItem(1, emptyglasspanel);
			RandMenuInv.setItem(2, emptyglasspanel);
			RandMenuInv.setItem(3, emptyglasspanel);
			RandMenuInv.setItem(4, thisitem);
			RandMenuInv.setItem(5, emptyglasspanel);
			RandMenuInv.setItem(6, emptyglasspanel);
			RandMenuInv.setItem(7, emptyglasspanel);
			RandMenuInv.setItem(8, emptyglasspanel);
			//-------
			RandMenuInv.setItem(9, emptyglasspanel);
			RandMenuInv.setItem(10, emptyglasspanel);
			RandMenuInv.setItem(11, new ItemStack(Material.AIR));
			RandMenuInv.setItem(12, new ItemStack(Material.AIR));
			RandMenuInv.setItem(13, new ItemStack(Material.AIR));
			RandMenuInv.setItem(14, new ItemStack(Material.AIR));
			RandMenuInv.setItem(15, new ItemStack(Material.AIR));
			RandMenuInv.setItem(16, emptyglasspanel);
			RandMenuInv.setItem(17, emptyglasspanel);
			//-------
			RandMenuInv.setItem(18, emptyglasspanel);
			RandMenuInv.setItem(19, emptyglasspanel);
			RandMenuInv.setItem(20, emptyglasspanel);
			RandMenuInv.setItem(21, emptyglasspanel);
			RandMenuInv.setItem(22, thisitem);
			RandMenuInv.setItem(23, emptyglasspanel);
			RandMenuInv.setItem(24, emptyglasspanel);
			RandMenuInv.setItem(25, emptyglasspanel);
			RandMenuInv.setItem(26, emptyglasspanel);
		}
		Inventory GetMenuInv;
		GetMenuInv = Bukkit.createInventory(null, 27, "§cMine Case - WYNIKI");
		{
			
			GetMenuInv.setItem(0, emptyglasspanel);
			GetMenuInv.setItem(1, emptyglasspanel);
			GetMenuInv.setItem(2, emptyglasspanel);
			GetMenuInv.setItem(3, emptyglasspanel);
			GetMenuInv.setItem(4, wonitem);
			GetMenuInv.setItem(5, emptyglasspanel);
			GetMenuInv.setItem(6, emptyglasspanel);
			GetMenuInv.setItem(7, emptyglasspanel);
			GetMenuInv.setItem(8, emptyglasspanel);
			//-------
			GetMenuInv.setItem(9, emptyglasspanel);
			GetMenuInv.setItem(10, emptyglasspanel);
			GetMenuInv.setItem(11, emptyglasspanel);
			GetMenuInv.setItem(12, redglasspanel);
			GetMenuInv.setItem(13, new ItemStack(Material.AIR));
			GetMenuInv.setItem(14, redglasspanel);
			GetMenuInv.setItem(15, emptyglasspanel);
			GetMenuInv.setItem(16, emptyglasspanel);
			GetMenuInv.setItem(17, emptyglasspanel);
			//-------
			GetMenuInv.setItem(18, emptyglasspanel);
			GetMenuInv.setItem(19, emptyglasspanel);
			GetMenuInv.setItem(20, emptyglasspanel);
			GetMenuInv.setItem(21, emptyglasspanel);
			GetMenuInv.setItem(22, redglasspanel);
			GetMenuInv.setItem(23, emptyglasspanel);
			GetMenuInv.setItem(24, emptyglasspanel);
			GetMenuInv.setItem(25, emptyglasspanel);
			GetMenuInv.setItem(26, emptyglasspanel);
		}
		p.openInventory(RandMenuInv);
		HashMap<Integer, ItemStack> cache = new HashMap<Integer, ItemStack>();
		ItemStack test = null;
		Randomowe random = new Randomowe();
//================================
		for(int i = 0; i <= 30; i++){
			int z = random.Rand(1, 10);
			switch(z){
				case 1:
					test = new ItemStack(Material.DIRT, 1);
					break;
				case 2:
					test = new ItemStack(Material.WOOD, 1);
					break;
				case 3:
					test = new ItemStack(Material.DIAMOND_SWORD, 1);
					break;
				case 4:
					test = new ItemStack(Material.LEATHER, 1);
					break;
				case 5:
					test = new ItemStack(Material.DIAMOND_BLOCK, 1);
					break;
				case 6:
					test = new ItemStack(Material.DRAGON_EGG, 1);
					break;
				case 7:
					test = new ItemStack(Material.DIAMOND_HELMET, 1);
					break;
				case 8:
					test = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
					break;
				case 9:
					test = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
					break;
				case 10:
					test = new ItemStack(Material.DIAMOND_BOOTS, 1);
					break;
			}
			cache.put(i, test);
		}
//------------------------------------------
		taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInst(), new BukkitRunnable() {
				int i = 0;
				public void run() {
					Bukkit.broadcastMessage("Wygrana " +i +" = " +cache.get(i));
					if(i < 31)
						RandMenuInv.setItem(15, cache.get(i));
					if(i > 0)
						RandMenuInv.setItem(14, cache.get(i-1));
					if(i > 1)
						RandMenuInv.setItem(13, cache.get(i-2));
					if(i > 2)
						RandMenuInv.setItem(12, cache.get(i-3));
					if(i > 3)
						RandMenuInv.setItem(11, cache.get(i-4));
					i++;
					if(i > 30){
						Bukkit.getServer().getScheduler().cancelTask(taskId);
						Bukkit.getScheduler().runTaskLater(Main.getInst(), new Runnable(){
							public void run(){
								p.openInventory(GetMenuInv);
								GetMenuInv.setItem(13, cache.get(28));
								p.getInventory().addItem(cache.get(28));
								cache.clear();
							}
						}, 2*20);
					}
				}
			}, 0, (int) (0.5*20));
	return true;
	}
//------------------------------------------------------------------------------------------------------------
	ItemStack emptyglasspanel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
	ItemStack thisitem = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemStack wonitem = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemStack redglasspanel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
	{
		ItemMeta im = emptyglasspanel.getItemMeta();
		im.setDisplayName(" ");
		emptyglasspanel.setItemMeta(im);
	}
	{
		ItemMeta im = thisitem.getItemMeta();
		im.setDisplayName("§cWygrany przedmiot.");
		thisitem.setItemMeta(im);
	}
	{
		ItemMeta im = wonitem.getItemMeta();
		im.setDisplayName("§cWygrany przedmiot.");
		wonitem.setItemMeta(im);
	}
	{
		ItemMeta im = redglasspanel.getItemMeta();
		im.setDisplayName(" ");
		redglasspanel.setItemMeta(im);
	}
	@EventHandler()
	public void InventoryRandMenuClick(InventoryClickEvent e){
		if(e.getInventory().getTitle().contains("§cMine Case - LOSOWANIE") || e.getInventory().getTitle().contains("§cMine Case - WYNIKI")){
    		e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
        }
	}
}
class Randomowe{
	int Rand(int min, int max) {
	    Random foo = new Random();
	    int randomNumber = min + foo.nextInt(max - min + 1);;
	    return randomNumber;
	}	
}
