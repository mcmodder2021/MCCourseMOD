package com.kaupenjoe.coppermod.data;

import com.kaupenjoe.coppermod.CopperModMAIN;
import com.kaupenjoe.coppermod.block.ModBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public class ModStoryAdvancements implements Consumer<Consumer<FinishedAdvancement>>
{
    @Override
    public void accept(Consumer<FinishedAdvancement> consumer)
    {
        FinishedAdvancement.Builder.builder()
                .advancement(Advancement.Builder.builder()
                    .withParentId(new ResourceLocation("story/iron_tools"))
                    .withDisplay(ModBlocks.COPPER_BLOCK.get(),
                            new TranslationTextComponent("advancements.story.copper_block.title"),
                            new TranslationTextComponent("advancements.story.copper_block.description"),
                        null, FrameType.TASK, true, true, false)
                        .withCriterion("copper_block", InventoryChangeTrigger.Instance.forItems(ModBlocks.COPPER_BLOCK.get())))
                        .build(consumer, new ResourceLocation(CopperModMAIN.MOD_ID, "story/copper_block"));
    }
}
