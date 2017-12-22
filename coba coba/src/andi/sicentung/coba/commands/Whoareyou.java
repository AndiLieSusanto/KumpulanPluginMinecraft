package andi.sicentung.coba.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Whoareyou implements CommandExecutor{
	
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player)
		{
			if(label.equalsIgnoreCase("whoareyou"))
			{
				Player player =  (Player) sender;
				player.sendMessage(ChatColor.AQUA +  "I AM NO ONE! BEGONE!");
				Location l = new Location(player.getWorld(),0,64,0);
				player.teleport(l);
				return true;
			}
		}
		
		return false;
	}

}
