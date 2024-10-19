package com.studiopulsar.feintha.faelib.forge;

import com.studiopulsar.feintha.faelib.Faelib;
import com.studiopulsar.feintha.faelib.interfaces.FaeAPI;
import com.studiopulsar.feintha.faelib.interfaces.exts.FaeRegistryAPI;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Faelib.MOD_ID)
public final class FaelibForge {
    static {

        EventBuses.registerModEventBus(Faelib.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        Faelib.init();
        Faelib.CurrentLoader = Faelib.ModloaderType.FABRIC;
    }
    public FaelibForge() {
        var regAPI = FaeAPI.getExtension(FaeRegistryAPI.class);
        regAPI.register(Registries.ITEM, new ResourceLocation("faelib:test_item"), ()->new Item(new Item.Properties()));
    }
}
