package com.cj1mckay.chatplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatPlugin extends JavaPlugin{
	private Player p;
	private static final ChatListener chatListen = new ChatListener();
	
	@Override
	public void onDisable(){
	}
	
	@Override
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(chatListen, this);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		p = (Player) sender;
		
		
		if(cmd.getName().equalsIgnoreCase("g") && p instanceof Player){
			if(args.length >= 1){
				StringBuilder messageBuilder = new StringBuilder();
				String message;
				for(int i = 0; i < args.length; i++)messageBuilder.append(args[i]);
				message = messageBuilder.toString();
				for(Player player : Bukkit.getOnlinePlayers())player.sendMessage("[GLOBAL] <"+p.getDisplayName() + "> " + message);
			}else{
				sender.sendMessage("Usage: /g (message)");
			}
		}
		return false;
	}
	
	
}
