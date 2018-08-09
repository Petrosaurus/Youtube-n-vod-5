package me.Petrosaurus.EntityPrikaz;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	public void onEnable(){
		
		getCommand("spawnentity").setExecutor(new EntitaPrikaz());
		
	}

}
