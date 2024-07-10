package net.korjeek.copperbeaconsmod.mixin;

import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Screen.class)
public abstract class ScreenMixin {
    @Shadow
    public int width;
    @Shadow
    public int height;
}
