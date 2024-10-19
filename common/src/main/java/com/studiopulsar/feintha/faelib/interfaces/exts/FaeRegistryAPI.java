package com.studiopulsar.feintha.faelib.interfaces.exts;

import com.mojang.datafixers.util.Pair;
import com.studiopulsar.feintha.faelib.interfaces.FaeExtension;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class FaeRegistryAPI implements FaeExtension {
    static final HashMap<String, RegistrarManager> Registrars = new HashMap<>();
    public static <T> Registrar<T> getCachedManager(String modid, ResourceKey<Registry<T>> registry) {

        if (Registrars.containsKey(modid)) {
            var a1 =  Registrars.get(modid);
            return a1.get(registry);
        }
        RegistrarManager mgr = RegistrarManager.get(modid);
        Registrars.put(modid, mgr);
        return mgr.get(registry);
    }
    public <T> void register(ResourceKey<Registry<T>> registry, ResourceLocation location, Supplier<T> object) {
        var mgr = getCachedManager(location.getNamespace(), registry);
        mgr.register(location, object);
    }
    public <T> void register(ResourceKey<Registry<T>> registry, String id, Supplier<T> object) { register(registry, new ResourceLocation(id), object); }

    @Override
    public String name() {
        return "registry";
    }
}
