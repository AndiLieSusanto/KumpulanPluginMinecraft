package com.andisusanto.safetrade;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Safetrade extends JavaPlugin
{
	public void  onEnable() 
	{
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + "Has been enabled! (V." + pdfFile.getVersion() + ")");
	}
	
	public void onDisable() 
	{
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + "Has been Disabled! (V." + pdfFile.getVersion() + ")");
	}
}
