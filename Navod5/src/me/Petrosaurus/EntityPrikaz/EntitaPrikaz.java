package me.Petrosaurus.EntityPrikaz;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EntitaPrikaz implements CommandExecutor {


	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("spawnentity")){
			
			if (sender instanceof Player){
				Player p = (Player) sender;
				
				if (args.length == 2){
					
					if (args[0].equals("spawn")){
						 
						EntityType et = null;
						
						try {
							et = EntityType.valueOf(args[1].toUpperCase());    
						
						}
						catch (IllegalArgumentException ex){
							
							p.sendMessage(ChatColor.RED + "Neplatna entita!!! Pro zobrazeni seznamu entit napis "
									+ "/spawnentity list");
							return false;
						}
						
						if (et != null && et.isSpawnable() && et != EntityType.PAINTING && et != EntityType.ITEM_FRAME){
						
							Entity en = null;
							
							try {
								en = p.getWorld().spawnEntity(p.getLocation(), et);
								
							}
							catch (IllegalArgumentException ex){
								p.sendMessage(ChatColor.RED + "Neplatna entita!!! Pro zobrazeni seznamu entit napis "
										+ "/spawnentity list");
								return false;
								
							}
							
							p.sendMessage("Entita " + en.toString() + " byla spawnuta");
						}
						else {
							p.sendMessage(ChatColor.RED + "Neplatna entita!!! Pro zobrazeni seznamu entit napis "
									+ "/spawnentity list");
							
						}
					}
					else {
						p.sendMessage(ChatColor.RED + "Pouziti: /spawnentity spawn [entita]");
						
					}
					
				}
				else if (args.length == 1) {
					
					if (args[0].equalsIgnoreCase("list")){
						
						EntityType[] et = EntityType.values();
						
						String seznam = "";
						
						for (int i = 0; i < et.length; i++){
							
							if (et[i].isSpawnable() && et[i] != EntityType.PAINTING && et[i] 
									!= EntityType.ITEM_FRAME){
								
								seznam += et[i] + ", ";
								//seznam = seznam + et[i] + ", ";
								
								
								
							}
							
							
						}
						
						p.sendMessage("Seznam entit: " + seznam);
					
						
						
					}
					else {
						p.sendMessage(ChatColor.RED + "Neplatny prikaz");
						
					}
					
					// inicializace --> øídící promìnná
					//  i++  =   i = i+1
					
					//inicializace --> podmínka --> blok kódu --> 
					//iterace -> podmínka --> (podmínka true) -> 
					//blok kódu atd.   (podmínka false) --> za blok kódu 
				}
				else {
					p.sendMessage(ChatColor.RED + "Neplatny prikaz");
					
				}
				
			}
			
		}
				
		return false;

	}
	
	
	
}


//world.spawnEntity(Location, EntityType)


   /*  /spawnentity spawn [entita]
		/spawnentity list
     */