package me.pixel.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.api.criar.Criar;

public class ShopInv {
	
	@SuppressWarnings("deprecation")
	public static void open(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 6*3,"§aAjudante§c Pagamentos");
		
		ItemStack meld = Criar.add(Material.EMERALD_BLOCK, "§cSalário Minimo", new String[] {"§bCusto 5 pontos"});
		ItemStack pepi = Criar.add(Material.GOLD_NUGGET, "§cTroféu do Ajudante", new String[] {"§bCusto 100 pontos", "§7- Trófeu do ajudante "+ p.getName()});
		
		inv.setItem(1, pepi);
		inv.setItem(0, meld);
		
		
		
		  ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

		 SkullMeta meta = (SkullMeta) skull.getItemMeta();
         meta.setOwner(p.getName());
         meta.setDisplayName("§aAjudante Status");
         skull.setItemMeta(meta);
         inv.setItem(4, skull);
		
		p.openInventory(inv);
		p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1f, 1.5f);
	}

}
