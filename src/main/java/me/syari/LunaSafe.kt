package me.syari

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.*
import org.bukkit.event.enchantment.EnchantItemEvent
import org.bukkit.event.entity.*
import org.bukkit.event.hanging.HangingBreakEvent
import org.bukkit.event.inventory.*
import org.bukkit.event.player.*
import org.bukkit.event.weather.LightningStrikeEvent
import org.bukkit.event.world.StructureGrowEvent
import org.bukkit.plugin.java.JavaPlugin

class LunaSafe : JavaPlugin(), Listener {
    override fun onEnable() {
        Bukkit.getServer().pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun on(e: BlockBurnEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: BlockBreakEvent){
        if(!isOPCreative(e.player)) {
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: BlockExplodeEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: BlockFadeEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: BlockFromToEvent){
        if(e.block.isLiquid) {
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: BlockGrowEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: StructureGrowEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: BlockFormEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: BlockIgniteEvent){
        if(!isOPCreative(e.player)){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: BlockPhysicsEvent){
        if(isFallBlock(e.block)){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: BlockPlaceEvent){
        if(!isOPCreative(e.player)){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: LeavesDecayEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: EnchantItemEvent){
        if(!isOPCreative(e.enchanter)){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: CreeperPowerEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: EntityExplodeEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: EntityInteractEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: EntityTameEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: EntityPortalEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: PigZapEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: SheepDyeWoolEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: SlimeSplitEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: PlayerLeashEntityEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: HangingBreakEvent){
        if(e.cause == HangingBreakEvent.RemoveCause.PHYSICS){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: BrewEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: FurnaceBurnEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: FurnaceSmeltEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: CraftItemEvent){
        if(!isOPCreative(e.whoClicked as Player)){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: InventoryMoveItemEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: InventoryPickupItemEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: PlayerCommandPreprocessEvent){
        if(!e.player.hasPermission("*")){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: PlayerEditBookEvent){
        if(!isOPCreative(e.player)){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: PlayerArmorStandManipulateEvent){
        if(!isOPCreative(e.player)) {
            e.isCancelled = true
        }
    }

    @EventHandler
    fun on(e: PlayerItemDamageEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: LightningStrikeEvent){
        e.isCancelled = true
    }

    @EventHandler
    fun on(e: PlayerInteractEvent){
        if(e.item != null && canThrow(e.item.type)){
            e.isCancelled = true
        }
    }

    private fun isOPCreative(p: Player?) : Boolean {
        return (p != null) && (p.hasPermission("*") && p.gameMode == GameMode.CREATIVE)
    }

    private fun isFallBlock(b: Block?) : Boolean {
        return when(b){
            Material.SAND, Material.GRAVEL, Material.RED_SAND, Material.ANVIL, Material.CHIPPED_ANVIL, Material.DAMAGED_ANVIL, Material.LADDER -> true
            else -> false
        }
    }

    private fun canThrow(m: Material?) : Boolean {
        return when(m){
            Material.SNOWBALL, Material.ENDER_PEARL, Material.ENDER_EYE, Material.EGG, Material.EXPERIENCE_BOTTLE -> true
            else -> false
        }
    }
}