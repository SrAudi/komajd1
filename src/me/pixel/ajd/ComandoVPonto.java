package me.pixel.ajd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoVPonto implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String lbl, String[] args) {
		Player p = (Player)snd;
		
			if(cmd.getName().equalsIgnoreCase("verpontos")) {
		if(!p.hasPermission("kom.staff")) {
			p.sendMessage("�cVoc� n�o tem permiss�o");
			return true;
		}
		if(args.length == 0) {
			p.sendMessage("�7�l[�6�lK�e�lo�6�lM�7�l] >>�7 Digite /verpontos (nome do ajudante)");

			return true;
		}

		Player pls = Bukkit.getPlayer(args[0]);
		if(pls == null) {
			p.sendMessage("�7�l[�6�lK�e�lo�6�lM�7�l] >>�7 Ajudante n�o encontrado ou inexistente");

			return true;
		}
		if(!pls.hasPermission("kom.ajd")) {
			p.sendMessage("�7�l[�6�lK�e�lo�6�lM�7�l] >>�7 O Player n�o � um ajudante");
			return true;
			
		}
		if(ComandoPonto.pts.getConfig().getString("Pontos."+pls.getName()) != null) {
			int pts = ComandoPonto.pts.getConfig().getInt("Pontos."+pls.getName());
			p.sendMessage("�7�l[�6�lK�e�lo�6�lM�7�l] >>�7 O Ajudante �a"+pls.getName()+" �7Cont�m �e"+pts+" �7ponto(s)!");
			
		}
		if(ComandoPonto.pts.getConfig().getString("Pontos."+pls.getName()) == null) {
			p.sendMessage("�7�l[�6�lK�e�lo�6�lM�7�l] >>�7 Ajudante n�o possui pontos!!");
		}
			
			
			
	}
		
		
		
		
		
		
		
		
		return false;
	}

}
