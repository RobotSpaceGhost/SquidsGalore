package com.robotspaceghost.squidsgalore.items;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class RawSquidMeat extends Item {
    public RawSquidMeat() {
        super(new Item.Properties()
            .group(SquidsGalore.TAB)
                .food(new Food.Builder()
                .hunger(3)
                .saturation(1.8f)
                .meat()
                .build())
        );
    }
}
