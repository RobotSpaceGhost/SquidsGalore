package com.robotspaceghost.squidsgalore.items;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase(){
        super(new Item.Properties().group(SquidsGalore.TAB));
    }
}

