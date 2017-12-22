package andi.sicentung.coba;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import andi.sicentung.coba.commands.Whoami;
import andi.sicentung.coba.commands.Whoareyou;
//import andi.sicentung.coba.event.block.BlockBreak;
import andi.sicentung.coba.event.player.PlayerUse;


public class coba extends JavaPlugin{
	
	public void  onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerCommands();
		registerEvents();
		
		logger.info(pdfFile.getName() + "Has been enabled! (V." + pdfFile.getVersion() + ")");
	}
	
	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + "Has been Disabled! (V." + pdfFile.getVersion() + ")");
	}
	
	public void registerCommands() {
		getCommand("whoami").setExecutor(new Whoami());
		getCommand("whoareyou").setExecutor(new Whoareyou()); 
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		//pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new PlayerUse(), this);
	}
}
