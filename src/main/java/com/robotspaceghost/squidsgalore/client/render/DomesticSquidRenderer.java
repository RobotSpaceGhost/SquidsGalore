package com.robotspaceghost.squidsgalore.client.render;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.BabyKrakenModel;
import com.robotspaceghost.squidsgalore.client.model.DomesticSquidModel;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.entities.DomesticSquidEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.ResourceLocation;

public class DomesticSquidRenderer extends MobRenderer<DomesticSquidEntity, DomesticSquidModel<DomesticSquidEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/domestic_squid.png");


    public DomesticSquidRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DomesticSquidModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(DomesticSquidEntity entity) {
        return TEXTURE;
    }
}
