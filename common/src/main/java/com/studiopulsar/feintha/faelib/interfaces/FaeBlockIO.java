package com.studiopulsar.feintha.faelib.interfaces;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

// Class for strictly value IO of blocks
public interface FaeBlockIO {
    public interface FaeBlockIOForwarder{
        FaeBlockIO getIO();
    }
    Tag getBlockProperty(String property);
    Tag getBlockPropertyOrDefault(String property, Tag _default);
    void setBlockProperty(String property, Tag data);
    public static @Nullable FaeBlockIO getBlockIO(Level level, BlockPos pos) {
        var be= level.getBlockEntity(pos);
        if (be == null) {return null;}
        if (be instanceof FaeBlockIOForwarder forwarder) {
            return forwarder.getIO();
        }
        if (be instanceof FaeBlockIO fbio) {
            return fbio;
        }
        return null;
    }
}
