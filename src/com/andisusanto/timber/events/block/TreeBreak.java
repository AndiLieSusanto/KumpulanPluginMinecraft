package com.andisusanto.timber.events.block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Tree;

public class TreeBreak implements Listener
{
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		//Starting Block
		Block startBlock = event.getBlock();
		if(startBlock.getType() == Material.LOG)
		{
			Location startLocation = startBlock.getLocation();
			Tree startTree = (Tree) startBlock.getState().getData();
			
			//check if its a tree or not
			boolean isTree = false;
			
			//check if it has starting leaves
			Location leavesLocation = null;
			
			if(startTree.getDirection() == BlockFace.UP)
			{
				for(Location checkLocation = new Location(startLocation.getWorld(),startLocation.getX(),
						startLocation.getY(),startLocation.getZ())
						;;checkLocation.setY(checkLocation.getY()+1))
				{
					if(checkLocation.getBlock().getType() == Material.LEAVES)
					{
						isTree = true;
						break;
					}
					else
					{
						if(checkLocation.getBlock().getType() != Material.LOG)
						{
							break;
						}
					}
					
					if(leavesLocation == null)
					{
						Location checkLeavesLocation = new Location(checkLocation.getWorld(),
								checkLocation.getX(),checkLocation.getY(),checkLocation.getZ());
						checkLeavesLocation.setX(checkLeavesLocation.getX()+1);
						if(checkLeavesLocation.getBlock().getType() == Material.LEAVES ||
								checkLeavesLocation.getBlock().getType() == Material.LOG
								)
						{
							checkLeavesLocation.setX(checkLeavesLocation.getX()-1);
							leavesLocation = checkLeavesLocation;
						}
						else
						{
							checkLeavesLocation.setX(checkLeavesLocation.getX()-2);
							if(checkLeavesLocation.getBlock().getType() == Material.LEAVES ||
									checkLeavesLocation.getBlock().getType() == Material.LOG
									)
							{
								checkLeavesLocation.setX(checkLeavesLocation.getX()+1);
								leavesLocation = checkLeavesLocation;
							}
							else
							{
								checkLeavesLocation.setX(checkLeavesLocation.getX()+1);
								checkLeavesLocation.setZ(checkLeavesLocation.getZ()+1);
								if(checkLeavesLocation.getBlock().getType() == Material.LEAVES ||
										checkLeavesLocation.getBlock().getType() == Material.LOG
										)
								{
									checkLeavesLocation.setZ(checkLeavesLocation.getZ()-1);
									leavesLocation = checkLeavesLocation;
								}
								else
								{
									checkLeavesLocation.setZ(checkLeavesLocation.getZ()-2);
									if(checkLeavesLocation.getBlock().getType() == Material.LEAVES ||
											checkLeavesLocation.getBlock().getType() == Material.LOG
											)
									{
										checkLeavesLocation.setZ(checkLeavesLocation.getZ()+1);
										leavesLocation = checkLeavesLocation;
									}
								}
							}
						}			
					}
				}

				if(isTree == true && leavesLocation != null && leavesLocation.getY()-startLocation.getY() >= 2)
				{	
					for(;startLocation.getY() != leavesLocation.getY();
							startLocation.setY(startLocation.getY()+1))
					{
						startLocation.getBlock().breakNaturally();
					}
					
					
					for(;;leavesLocation.setY(leavesLocation.getY()+1))
					{
						if(leavesLocation.getBlock().getType() != Material.LOG && leavesLocation.getBlock().getType() != Material.LEAVES)
						{
							break;
						}
						
						int lengthX = 0;
						int lengthZ = 0;
						
						for(Location lengthLocation = new Location(leavesLocation.getWorld(),
								leavesLocation.getX(),leavesLocation.getY(),leavesLocation.getZ());;)
							{
								lengthLocation.setX(lengthLocation.getX()+1);
								if(lengthLocation.getBlock().getType() == Material.LEAVES || 
										lengthLocation.getBlock().getType() == Material.LOG)
								{
									lengthX = lengthX + 1;
								}
								else if(lengthX > 3)
								{
									break;
								}
								else
								{
									lengthX = lengthX + 1;
								}
								
								if(lengthX >=6)
								{
									break;
								}
							}
						
						if(lengthX <= 5)
						{
							int tempLengthX = 0;
							for(Location lengthLocation = new Location(leavesLocation.getWorld(),
									leavesLocation.getX(),leavesLocation.getY(),leavesLocation.getZ());;)
								{
									lengthLocation.setX(lengthLocation.getX()-1);
									if(lengthLocation.getBlock().getType() == Material.LEAVES || 
											lengthLocation.getBlock().getType() == Material.LOG)
									{
										tempLengthX  = tempLengthX  + 1;
									}
									else if(tempLengthX > 3)
									{
										break;
									}
									else
									{
										tempLengthX  = tempLengthX  + 1;
									}
									
									if(tempLengthX >=6)
									{
										break;
									}
								}
							
							if(tempLengthX > lengthX)
							{
								lengthX = tempLengthX;
							}
						}

						for(Location lengthLocation = new Location(leavesLocation.getWorld(),
								leavesLocation.getX(),leavesLocation.getY(),leavesLocation.getZ());;)
							{
								lengthLocation.setZ(lengthLocation.getZ()+1);
								if(lengthLocation.getBlock().getType() == Material.LEAVES || 
										lengthLocation.getBlock().getType() == Material.LOG)
								{
									lengthZ = lengthZ + 1;
								}
								else if(lengthZ > 3)
								{
									break;
								}
								else
								{
									lengthZ = lengthZ + 1;
								}
								
								if(lengthZ >=6)
								{
									break;
								}
							}
						
						
						if(lengthZ <= 5)
						{
							int tempLengthZ = 0;
							for(Location lengthLocation = new Location(leavesLocation.getWorld(),
									leavesLocation.getX(),leavesLocation.getY(),leavesLocation.getZ());;)
								{
									lengthLocation.setZ(lengthLocation.getZ()-1);
									if(lengthLocation.getBlock().getType() == Material.LEAVES || 
											lengthLocation.getBlock().getType() == Material.LOG)
									{
										tempLengthZ  = tempLengthZ  + 1;
									}
									else if(lengthZ > 3)
									{
										break;
									}
									else
									{
										tempLengthZ  = tempLengthZ  + 1;
									}
									
									if(tempLengthZ >=6)
									{
										break;
									}
								}
							
							if(tempLengthZ > lengthZ)
							{
								lengthZ = tempLengthZ;
							}
						}
					
						Location timberLocation = new Location(leavesLocation.getWorld(),leavesLocation.getX()-lengthX,
								leavesLocation.getY(),leavesLocation.getZ()-lengthZ);
						for(int X = 1 ;X <= (lengthX*2)+1 ; X++)
						{
							for(int Z = 1;Z <= (lengthZ*2)+1 ; Z++)
							{
								if(timberLocation.getBlock().getType() == Material.LOG || 
										timberLocation.getBlock().getType() == Material.LEAVES)
								{
									timberLocation.getBlock().breakNaturally();
								}
								timberLocation.setZ(timberLocation.getZ()+1);
							}
							timberLocation.setX(timberLocation.getX()+1);
							timberLocation.setZ(timberLocation.getZ()-((lengthZ*2)+1));
						}
					}
				}
			}
		}
	}
}