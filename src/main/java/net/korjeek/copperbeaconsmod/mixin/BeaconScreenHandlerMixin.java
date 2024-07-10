package net.korjeek.copperbeaconsmod.mixin;

import net.minecraft.screen.BeaconScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BeaconScreenHandler.class)
public abstract class BeaconScreenHandlerMixin {

    @ModifyArg(method = "<init>(ILnet/minecraft/inventory/Inventory;Lnet/minecraft/screen/PropertyDelegate;Lnet/minecraft/screen/ScreenHandlerContext;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/BeaconScreenHandler$PaymentSlot;<init>(Lnet/minecraft/screen/BeaconScreenHandler;Lnet/minecraft/inventory/Inventory;III)V"),
            index = 3)
    public int changeSlotPos(int x){
        return x + 10;
    }
}