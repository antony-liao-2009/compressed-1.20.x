package net.antony.compressed.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import io.netty.buffer.Unpooled;

public class BufferTest {
    public static void main(String[] args) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        BlockPos pos = new BlockPos(1, 2, 3);
        buffer.writeBlockPos(pos); // Test if this works
        System.out.println("BlockPos written to buffer: " + pos);
    }
}