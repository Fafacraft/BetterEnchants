package fafacraft.betterenchants.items;

import fafacraft.betterenchants.BetterEnchants;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    /* Add a new register ; ITEMS */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterEnchants.MODID);

    /* Add the items */
    public static final RegistryObject<Item> FIRST_ITEM = ITEMS.register("first_item", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SECOND_ITEM = ITEMS.register("second_item", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}