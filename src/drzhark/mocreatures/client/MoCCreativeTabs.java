package drzhark.mocreatures.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MoCCreativeTabs extends CreativeTabs {

    public MoCCreativeTabs(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        // TODO Auto-generated method stub
        return null;
    }

}