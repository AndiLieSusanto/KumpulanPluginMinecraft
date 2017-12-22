package andi.sicentung.coba.event.player;

import java.util.Vector;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class PlayerUse implements Listener{
	
	Arrow arrow;
	Vector<Arrow> arrows = new Vector<>();
	
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.LEFT_CLICK_AIR) 
		{
			ItemStack item = player.getInventory().getItemInMainHand();
			if(item.getType() == Material.COBBLESTONE)
			{
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-1);
				arrow = event.getPlayer().launchProjectile(Arrow.class);
				arrows.add(arrow);
			}
		}
	}
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) 
	{
		if (event.getDamager() instanceof Arrow) 
		{
			Arrow hit = (Arrow) event.getDamager();
			Arrow tempArr = findArrow(hit);
			
			if(tempArr != null)
			{
				event.setDamage(0.5);
				Bukkit.broadcastMessage(event.getEntity().getName() + " just got sniped");
				tempArr.remove();
			}
		}
	}
	
	@EventHandler
	public void onArrowHit(ProjectileHitEvent event)
	{
		if (event.getEntity() instanceof Arrow) 
		{
			if(event.getHitBlock() instanceof Block)
			{
				
				Block block = event.getHitBlock();
				Arrow hit = (Arrow) event.getEntity();
				Arrow tempArr = findArrow(hit);
				
				if(tempArr != null)
				{
					World w =  block.getWorld();
					
					if(block.getType() == Material.GLASS ||
							block.getType() == Material.STAINED_GLASS ||
							block.getType() == Material.STAINED_GLASS_PANE ||
							block.getType() == Material.THIN_GLASS 
							)
					{
						if( tempArr != null )
						{
							event.getHitBlock().breakNaturally();
							w.playSound(block.getLocation(),Sound.BLOCK_GLASS_BREAK,10,1);
						}
					}
					
					tempArr.remove();
				}
			}
		}
	}
	
	public Arrow findArrow(Arrow hit){
		
		for ( int i = 0 ; i < arrows.size(); i++){
			if( hit == arrows.get(i)){
				return arrows.remove(i);
			}
		}
		return null;                                       
		   
	}
}
