package andi.sicentung.coba.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kerikil implements CommandExecutor{
	
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player)
		{
			if(label.equalsIgnoreCase("kerikil"))
			{
				if(args[1].equalsIgnoreCase("make"))
				{
					Player player =  (Player) sender;
					if(player.getInventory().contains(Material.COBBLESTONE))
					{
						
					}
				}
			}
		}
		
		return false;
	}

}