package me.Pawel.Cases.commands;

import me.Pawel.Cases.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Case implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		Main.getInst().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInst(), new Runnable(){
		    public void run(){
		    	arg0.sendMessage("TEST");
		    }
		},20);
		arg0.sendMessage("PO CZASIE");
		return false;
	}

}
