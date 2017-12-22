package andi.sicentung.coba.event.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener{
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Material material = block.getType();
		
		if(material != Material.GRASS) {
			event.setCancelled(true);
			player.sendMessage("lol Nope");
			event.getPlayer().setHealth(0.0);
		}
	}
}

//@EventHandler
//public void onPlayerUse(PlayerInteractEvent event) {
//	if(event.getAction() == Action.RIGHT_CLICK_BLOCK) 
//	{
//		Block block = event.getClickedBlock();
//		BlockState blockState = block.getState();
//		MaterialData blockData = blockState.getData();
//		
//		if((blockData instanceof Tree))
//		{
//			Tree tree = (Tree) blockData;
//			
//			tree.setDirection(BlockFace.UP);
//			blockState.update();
//		}
//	}
//}