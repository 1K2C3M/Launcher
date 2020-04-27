package me.Corey.Launch;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch") ) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Bruh this is the console I don't know what you expected...");
				return true;
			}
			Player player = (Player) sender;
			
			// /launch     /launch <number>
			if (args.length == 0) {
				// /launch
				player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "WOAH DUDE YOU'VE BEEN LAUNCHED!");
				player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
				
				return true;
			}
			
			// /launch <number>
			if (isNum(args [0])) {
				player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "WOAH DUDE YOU'VE BEEN LAUNCHED!");
				player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
			}
			else {
				player.sendMessage(ChatColor.RED + "Usage: /launch <number-value>");
			}
			return true;
		}
		return false;
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
				return false;
		}
		return true;
	}
	
}
