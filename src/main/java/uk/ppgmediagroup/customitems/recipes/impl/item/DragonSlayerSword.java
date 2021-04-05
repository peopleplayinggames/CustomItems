package uk.ppgmediagroup.customitems.recipes.impl.item;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EnderDragonChangePhaseEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.ppgmediagroup.customitems.recipes.Recipe;
import uk.ppgmediagroup.customitems.utils.RecipeChecker;

import java.util.UUID;

public class DragonSlayerSword extends Recipe {
    @Override
    public String getName() {
        return "DRAGONSLAYER_SWORD";
    }

    @Override
    public ItemStack getItem() {
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta itemMeta = sword.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "DragonSlayer Sword");

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);

        itemMeta.setCustomModelData(4);
        sword.setItemMeta(itemMeta);
        return sword;
    }

    @Override
    public ShapedRecipe recipe(ItemStack itemStack) {
        return null;
    }

    @EventHandler
    public void onDragon(EntityDeathEvent e) {
        if (e.getEntityType() == EntityType.ENDER_DRAGON) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), getItem());
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "THE DRAGON IS DYING, THE SWORD HAS DROPPED");
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if (RecipeChecker.isItem(this, damager.getInventory().getItemInMainHand())) {
                if (damager.getWorld().getName().contains("end")) {
                    e.setDamage(e.getDamage() * 1.5f);
                }
            }
        }
    }
}
