package fafacraft.betterenchants.items;

import fafacraft.betterenchants.BetterEnchants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

@Mod.EventBusSubscriber(modid = BetterEnchants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModTab {
    /* create registeries CREATIVE_MODE_TABS */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterEnchants.MODID);

    /* create a new tab betterenchants_tab, with ModItems.FIRST_ITEM as the icon */
    public static final RegistryObject<CreativeModeTab> BETTERENCHANTS_TAB = CREATIVE_MODE_TABS.register("betterenchants_tab", 
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FIRST_ITEM.get()))
            .title(Component.translatable("creativetab.betterenchants_tab" ))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.FIRST_ITEM.get());
                pOutput.accept(ModItems.SECOND_ITEM.get());

                pOutput.accept(Items.DIAMOND);
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
