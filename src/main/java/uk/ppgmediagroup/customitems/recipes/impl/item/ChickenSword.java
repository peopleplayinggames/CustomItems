package uk.ppgmediagroup.customitems.recipes.impl.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.ppgmediagroup.customitems.Core;
import uk.ppgmediagroup.customitems.recipes.Recipe;
import uk.ppgmediagroup.customitems.utils.RecipeChecker;

import java.util.Arrays;
import java.util.Random;

public class ChickenSword extends Recipe {
    @Override
    public String getName() {
        return "CHICKEN_SWORD";
    }

    @Override
    public ItemStack getItem() {
        ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemMeta = sword.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Chicken Sword");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "50% chance to turn passive mob into chicken", ChatColor.YELLOW + "5% chance to turn any hostile mob into chicken"));
        itemMeta.setCustomModelData(3);
        sword.setItemMeta(itemMeta);
        return sword;
    }

    @Override
    public ShapedRecipe recipe(ItemStack itemStack) {
        NamespacedKey namespacedKey = new NamespacedKey(Core.getInstance(), "chickenSword");
        ShapedRecipe recipe = new ShapedRecipe(namespacedKey, itemStack);
        recipe.shape("GBG", "GBG", "GCG");
        recipe.setIngredient('B', Material.EGG);
        recipe.setIngredient('C', Material.STICK);
        recipe.setIngredient('G', Material.AIR);

        return recipe;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if (RecipeChecker.isItem(this, damager.getInventory().getItemInMainHand())) {
                if (e.getEntity() instanceof Player) {
                    e.setCancelled(true);
                    return;
                }
                if (e.getEntity() instanceof Monster) {
                    Random r = new Random();
                    int game = r.nextInt(100);
                    System.out.println("Hostile: " + game);
                    if (game >= 95) {
                        damager.sendMessage(ChatColor.YELLOW + "You just turned that " + e.getEntity().getType().name().toLowerCase() + " into a chicken...");
                        e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.CHICKEN);
                        e.getEntity().remove();
                        damager.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        damager.playSound(damager.getLocation(), Sound.BLOCK_ANVIL_BREAK, 5, 0.8f);
                    }
                } else {
                    Random r = new Random();
                    int game = r.nextInt(100);
                    System.out.println("Friendly:" + game);
                    if (game >= 50) {
                        damager.sendMessage(ChatColor.YELLOW + "You just turned that " + e.getEntity().getType().name().toLowerCase() + " into a chicken...");
                        e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.CHICKEN);
                        e.getEntity().remove();
                        damager.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        damager.playSound(damager.getLocation(), Sound.BLOCK_ANVIL_BREAK, 5, 0.8f);
                    }
                }
            }
        }
    }
}