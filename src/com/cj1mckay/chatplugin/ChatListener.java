package com.cj1mckay.chatplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent chat){
		Player p = chat.getPlayer();
		String message = chat.getMessage();
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if (player.getWorld().equals(p.getWorld())){
				player.sendMessage("[WORLD] <"+p.getDisplayName() + "> " + message);
			}
		}
		chat.setCancelled(true);
	}
}
