package me.pixel.ajd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class ComandoLog implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
				Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("ajdcheck")) {
			if(!p.hasPermission("kom.staff")) {
				
				p.sendMessage("§cVocê não tem permissao");
				/* caso  o jogador não tenha permissão  */
				
				return true;
			}
			  if(args[0].equalsIgnoreCase("reset")) {
				  ComandoResponder.log.set("Player", null);
				  
				  p.sendMessage("§cTodas as logs foram resetadas!");
			  }
		if(args.length == 0) {
			
			p.sendMessage("§7§l[§6§lK§e§lo§6§lM§7§l] >>§7 Digite /ajdcheck <ajudante>");
			return true;
			
			
		}
		
		if(args.length > 0) {
			Player pl = Bukkit.getPlayer(args[0]);
			if(pl == null) {
				return true;
			}
			String nome = pl.getName();
			
			ConfigurationSection cs = ComandoResponder.log.getConfig().getConfigurationSection("Player."+nome);
	
			   for(String ajd : cs.getKeys(true)){
			       String str = cs.getString(ajd);
//			       p.sendMessage(ajd+ ": " + str);
					p.sendMessage(" ");
					p.sendMessage(str.replace("&", "§").replace("$es", "\n"));
					p.sendMessage(" ");

		}
			   
			   
	}		   
		
			   
			   
			   
			   
			   
			   
		
		
	}
		return false;

}
	}
