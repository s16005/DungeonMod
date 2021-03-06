package jp.ac.itcollege.std.jinkokanmiryo.dungeonmod

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLConstructionEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.EntityRegistry

@Mod(modid = DungeonMod.ID, name = DungeonMod.Name, version = DungeonMod.Version, modLanguage = "kotlin", modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
@Mod.EventBusSubscriber
class DungeonMod
{
    companion object
    {
        const val ID = "dungeonmod"
        const val Name = "DungeonMod"
        const val Version = "1.0.1"

        private val ctab = object : CreativeTabs("dungeonmod")
        {
            override fun getTabIconItem() = ItemStack(Items.STICK)
        }

        @SubscribeEvent @JvmStatic
        fun registeritem(e: RegistryEvent.Register<Item>) {
            e.registry.register(FrostyRod.setCreativeTab(ctab))
            e.registry.register(SoulEater.setCreativeTab(ctab))
        }

        @Mod.EventHandler
    fun construction(event: FMLConstructionEvent) {
            MinecraftForge.EVENT_BUS.register(this)
        }
        @SubscribeEvent @JvmStatic
    fun registerModels(e: ModelRegistryEvent) {
            ModelLoader.setCustomModelResourceLocation(FrostyRod, 0, ModelResourceLocation(FrostyRod.registryName!!,"inventory"))
            ModelLoader.setCustomModelResourceLocation(SoulEater, 0, ModelResourceLocation(SoulEater.registryName!!,"inventory"))
        }
    }
}