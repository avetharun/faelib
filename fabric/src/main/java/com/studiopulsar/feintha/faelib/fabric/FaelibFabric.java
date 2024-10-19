package com.studiopulsar.feintha.faelib.fabric;

import com.studiopulsar.feintha.faelib.Faelib;
import com.studiopulsar.feintha.faelib.interfaces.FaeAPI;
import com.studiopulsar.feintha.faelib.interfaces.exts.FaeRegistryAPI;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public final class FaelibFabric implements ModInitializer {
    static {
        Faelib.init();
        Faelib.CurrentLoader = Faelib.ModloaderType.FABRIC;
    }
    @Override
    public void onInitialize() {
        var regAPI = FaeAPI.getExtension(FaeRegistryAPI.class);
        regAPI.register(Registries.ITEM, new ResourceLocation("faelib:test_item"), ()->new Item(new Item.Properties()));
    }
}
