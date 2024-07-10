package net.korjeek.copperbeaconsmod.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin extends HandledScreenMixin {

	@Unique
	private static final Identifier TEXTURE = Identifier.ofVanilla("textures/gui/container/beacon.png");

	/**
	 * @author korjeek
	 * @reason Because the changes affect important aspects of the original method
	 */
	@Overwrite
	public void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
		int i = (this.width - this.backgroundWidth) / 2;
		int j = (this.height - this.backgroundHeight) / 2;
		context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
		context.getMatrices().push();
		context.getMatrices().translate(0.0F, 0.0F, 100.0F);
		context.drawItem(new ItemStack(Items.NETHERITE_INGOT), i + 13, j + 109);
		context.drawItem(new ItemStack(Items.EMERALD), i + 34, j + 109);
		context.drawItem(new ItemStack(Items.DIAMOND), i + 34 + 22, j + 109);
		context.drawItem(new ItemStack(Items.GOLD_INGOT), i + 35 + 44, j + 109);
		context.drawItem(new ItemStack(Items.IRON_INGOT), i + 35 + 66, j + 109);
		context.drawItem(new ItemStack(Items.COPPER_INGOT), i + 35 + 88, j + 109);
		context.getMatrices().pop();
	}

	@ModifyArg(method = "init", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/gui/screen/ingame/BeaconScreen$DoneButtonWidget;<init>(Lnet/minecraft/client/gui/screen/ingame/BeaconScreen;II)V"),
			index = 1)
	public int changeDoneButtonPos(int x){
		return x + 5;
	}

	@ModifyArg(method = "init", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/gui/screen/ingame/BeaconScreen$CancelButtonWidget;<init>(Lnet/minecraft/client/gui/screen/ingame/BeaconScreen;II)V"),
			index = 1)
	public int changeCancelButtonPos(int x){
		return x + 5;
	}
}