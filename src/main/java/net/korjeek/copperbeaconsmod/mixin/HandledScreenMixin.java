package net.korjeek.copperbeaconsmod.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin extends ScreenMixin{
    @Shadow
    protected int backgroundHeight;
    @Shadow
    protected int backgroundWidth;
}
