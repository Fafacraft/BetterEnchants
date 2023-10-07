package fafacraft.betterenchants.blocks;

import java.util.function.Supplier;

import fafacraft.betterenchants.BetterEnchants;
import fafacraft.betterenchants.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    /* create a new register for BLOCKS */
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterEnchants.MODID);

    /* create the first_block block */
    public static final RegistryObject<Block> FIRST_BLOCK = registerBlock("first_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    /* register the block and his associated block item */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        // register the block
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        // register the block item
        registerBlockItem(name, toReturn);
        // return the block
        return toReturn;
    }

    /* register the item associated witht the new block */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}