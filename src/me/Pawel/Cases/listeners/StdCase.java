package me.Pawel.Cases.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StdCase implements Listener {
	Inventory StandardEQ;
	
	@EventHandler()
	public void onRightClick(PlayerInteractEvent e) {
		if(e.getPlayer().getItemInHand() !=null && e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND)){
			StandardEQ = Bukkit.createInventory(null, 27, "§cMine:GO Case");
			{
				
				StandardEQ.setItem(0, emptyglasspanel);
				StandardEQ.setItem(1, emptyglasspanel);
				StandardEQ.setItem(2, emptyglasspanel);
				StandardEQ.setItem(3, undercasewool);
				StandardEQ.setItem(4, emptyglasspanel);
				StandardEQ.setItem(5, underkeywool);
				StandardEQ.setItem(6, emptyglasspanel);
				StandardEQ.setItem(7, emptyglasspanel);
				StandardEQ.setItem(8, emptyglasspanel);
				//-------
				StandardEQ.setItem(9, emptyglasspanel);
				StandardEQ.setItem(10, emptyglasspanel);
				StandardEQ.setItem(11, emptyglasspanel);
				StandardEQ.setItem(12, new ItemStack(Material.AIR));
				StandardEQ.setItem(13, startemerald);
				StandardEQ.setItem(14, new ItemStack(Material.AIR));
				StandardEQ.setItem(15, emptyglasspanel);
				StandardEQ.setItem(16, emptyglasspanel);
				StandardEQ.setItem(17, emptyglasspanel);
				//-------
				StandardEQ.setItem(18, emptyglasspanel);
				StandardEQ.setItem(19, emptyglasspanel);
				StandardEQ.setItem(20, emptyglasspanel);
				StandardEQ.setItem(21, emptyglasspanel);
				StandardEQ.setItem(22, emptyglasspanel);
				StandardEQ.setItem(23, emptyglasspanel);
				StandardEQ.setItem(24, emptyglasspanel);
				StandardEQ.setItem(25, emptyglasspanel);
				StandardEQ.setItem(26, emptyglasspanel);
			}
			e.getPlayer().openInventory(StandardEQ);
		}
	}
	
	@EventHandler(ignoreCancelled=false, priority=EventPriority.HIGHEST)
	public void InventoryClick(InventoryClickEvent e){
        if(e.getInventory().getTitle().contains("§cMine:GO Case")){
            if(e.getCurrentItem() == null){
                return;
            }
        	if(e.getCurrentItem().getType().equals(Material.CHEST) || e.getCurrentItem().getType().equals(Material.TRIPWIRE_HOOK) || e.getCurrentItem().getType().equals(Material.AIR)){
        		e.setCancelled(false);
        	} else{
        		e.setCancelled(true);
        	}
        }
	}
//----------------------------------------------------------------------------------------------------------------------------------
	ItemStack emptyglasspanel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
	ItemStack undercasewool = new ItemStack(Material.WOOL, 1, (short) 14);
	ItemStack underkeywool = new ItemStack(Material.WOOL, 1, (short) 5);
	ItemStack startemerald = new ItemStack(Material.EMERALD_BLOCK, 1);
	{
		ItemMeta im = emptyglasspanel.getItemMeta();
		im.setDisplayName(" ");
		emptyglasspanel.setItemMeta(im);
	}
	{
		ItemMeta im = undercasewool.getItemMeta();
		im.setDisplayName("§cNizej postaw Mine:Case");
		undercasewool.setItemMeta(im);
	}
	{
		ItemMeta im = underkeywool.getItemMeta();
		im.setDisplayName("§cNizej postaw Mine:Key");
		underkeywool.setItemMeta(im);
	}
	{
		ItemMeta im = startemerald.getItemMeta();
		im.setDisplayName("§cKliknij aby zaczac losowanie.");
		startemerald.setItemMeta(im);
	}
}
