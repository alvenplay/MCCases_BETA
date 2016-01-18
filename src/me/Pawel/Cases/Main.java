package me.Pawel.Cases;

import me.Pawel.Cases.commands.Case;
import me.Pawel.Cases.listeners.GetMenu;
import me.Pawel.Cases.listeners.RandMenu;
import me.Pawel.Cases.listeners.StdCase;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public void onEnable(){
		instance = this;
		
		getCommand("case").setExecutor(new Case());

		getServer().getPluginManager().registerEvents(new StdCase(), this);
		getServer().getPluginManager().registerEvents(new RandMenu(), this);
		getServer().getPluginManager().registerEvents(new GetMenu(), this);
	}
//---------------------------------------------------------------------
	private static Main instance;
	public static Main getInst() {
		return instance;
	}
}
