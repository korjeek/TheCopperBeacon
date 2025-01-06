package net.korjeek.copperbeaconsmod.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin extends HandledScreenMixin {

  @ModifyArg(method = "drawBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawItem(Lnet/minecraft/item/ItemStack;II)V"), index = 1)
  private int modifyXPositions(int x) {
    // Get the base x position from the original x coordinate
    int i = (this.width - this.backgroundWidth) / 2;

    // Determine where to move each item's sprite based on the original x position
    if (x == i + 20) return i + 13;      // Netherite Ingot
    if (x == i + 41) return i + 34;      // Emerald Ingot
    if (x == i + 41 + 22) return i + 34 + 22;  // Diamond
    if (x == i + 42 + 44) return i + 35 + 44;  // Gold Ingot
    if (x == i + 42 + 66) return i + 35 + 66;  // Iron Ingot
    return x;
  }

  @Inject(method = "drawBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawItem(Lnet/minecraft/item/ItemStack;II)V", shift = At.Shift.AFTER))
  private void addCopperIngot(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
    int i = (this.width - this.backgroundWidth) / 2;
    int j = (this.height - this.backgroundHeight) / 2;
    context.drawItem(new ItemStack(Items.COPPER_INGOT), i + 35 + 88, j + 109);
  }

  @ModifyArg(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ingame/BeaconScreen$DoneButtonWidget;<init>(Lnet/minecraft/client/gui/screen/ingame/BeaconScreen;II)V"), index = 1)
  public int changeDoneButtonPos(int x) {
    return x + 5;
  }

  @ModifyArg(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ingame/BeaconScreen$CancelButtonWidget;<init>(Lnet/minecraft/client/gui/screen/ingame/BeaconScreen;II)V"), index = 1)
  public int changeCancelButtonPos(int x) {
    return x + 5;
  }
}