package com.robotspaceghost.squidsgalore.items;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class SquidMeat extends Item {
    public SquidMeat() {
        super(new Item.Properties()
                .group(SquidsGalore.TAB)
                .food(new Food.Builder()
                        .hunger(8)
                        .saturation(12.8f)
                        .meat()
                        .build())
        );
    }
}
