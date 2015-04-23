package drzhark.mocreatures.block;

import drzhark.mocreatures.MoCreatures;

import com.google.common.base.Function;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;

public class MultiItemBlock extends ItemMultiTexture {

    public MultiItemBlock(Block block) {
        super(block, block, new Function() {

            public String apply(ItemStack stack) {
                return MoCBlock.EnumType.byMetadata(stack.getMetadata()).getUnlocalizedName();
            }

            @Override
            public Object apply(Object p_apply_1_) {
                return this.apply((ItemStack) p_apply_1_);
            }
        });
        setHasSubtypes(true);
        //this.setUnlocalizedName("multiBlock");
        String name = block.getUnlocalizedName().replace("tile.", "").replace("MoC", "").toLowerCase();
        ModelBakery.addVariantName(this, "mocreatures:wyvern_" + name);
        ModelBakery.addVariantName(this, "mocreatures:ogre_" + name);

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(this, 0, new ModelResourceLocation("mocreatures:wyvern_" + name, "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(this, 1, new ModelResourceLocation("mocreatures:ogre_" + name, "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(this, 2, new ModelResourceLocation("mocreatures:" + name, "variant=wyvern_lair"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(this, 3, new ModelResourceLocation("mocreatures:" + name, "variant=ogre_lair"));

    }

    @Override
    public int getMetadata(int damageValue) {
        return damageValue;
    }

}
