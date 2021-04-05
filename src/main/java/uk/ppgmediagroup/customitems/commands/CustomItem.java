package uk.ppgmediagroup.customitems.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.ppgmediagroup.customitems.Core;
import uk.ppgmediagroup.customitems.recipes.Recipe;

public class CustomItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You can only do this in game.");
            return false;
        }

        Player player = (Player) sender;

        if (!player.isOp() || !player.hasPermission("customitems.give")) {
            player.sendMessage(ChatColor.RED + "No permission");
            return false;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /customitem <name>");
            return false;
        }

        String itemName = args[0];

        Recipe recipe = null;

        for (Recipe all : Core.getInstance().getRecipeManager().getRecipes()) {
            if (all.getName().equalsIgnoreCase(itemName)) {
                recipe = all;
            }
        }

        if (recipe == null) {
            player.sendMessage(ChatColor.RED + "Unknown item.");
            return false;
        }

        player.getInventory().addItem(recipe.getItem());
        player.sendMessage(ChatColor.GREEN + "Added " + recipe.getName() + " to your inventory.");

        return false;
    }
}
