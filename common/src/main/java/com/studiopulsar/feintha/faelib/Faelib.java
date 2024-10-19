package com.studiopulsar.feintha.faelib;

import com.studiopulsar.feintha.faelib.interfaces.FaeAPI;
import com.studiopulsar.feintha.faelib.interfaces.FaeExtension;
import com.studiopulsar.feintha.faelib.interfaces.exts.FaeRegistryAPI;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.architectury.event.events.common.EntityEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

public final class Faelib {

    public static enum ModloaderType {
        FABRIC, FORGE, ;

        @Override
        public String toString() {
            return super.name().toLowerCase();
        }
    }
    public static final String MOD_ID = "faelib";
    final public static boolean DEBUG_ENABLED =
            Boolean.parseBoolean(System.getProperty("fabric.development", "false")) ||
            Boolean.parseBoolean(System.getProperty("forge.development", "false")) ||
            Boolean.parseBoolean(System.getProperty("development", "false")) ||
            Boolean.parseBoolean(System.getProperty("mc.development", "false")) ||
            Boolean.parseBoolean(System.getProperty("minecraft.development", "false")) ||
            System.getProperty("javaagent", "").toLowerCase().contains("intellij") ||
            System.getProperty("javaagent", "").toLowerCase().contains("idea") ||
            System.getProperty("javaagent", "").toLowerCase().contains("eclipse");
    public static ModloaderType CurrentLoader;
    public static void init() {
    }
    static {
        FaeAPI.registerFaeExt(new FaeRegistryAPI());
    }
}
