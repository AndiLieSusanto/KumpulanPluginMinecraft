package com.andisusanto.timber;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.andisusanto.timber.events.block.TreeBreak;

public class Timber extends JavaPlugin
{
	public void  onEnable() 
	{
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerEvents();
		
		logger.info(pdfFile.getName() + "Has been enabled! (V." + pdfFile.getVersion() + ")");
	}
	
	public void onDisable() 
	{
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + "Has been Disabled! (V." + pdfFile.getVersion() + ")");
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();		
		pm.registerEvents(new TreeBreak(), this);
	}
}
