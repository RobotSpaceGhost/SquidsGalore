package com.robotspaceghost.squidsgalore.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.robotspaceghost.squidsgalore.entities.KrakenTentacleEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class KrakenTentacleModel<T extends KrakenTentacleEntity> extends EntityModel<T> {
    private final ModelRenderer tentacleBody;
    private final ModelRenderer tentacleBase;
    private final ModelRenderer tentacleLowerMid;
    private final ModelRenderer tentacleUpperMid;
    private final ModelRenderer tentacleTip;

    public KrakenTentacleModel() {
        textureWidth = 64;
        textureHeight = 64;

        tentacleBody = new ModelRenderer(this);
        tentacleBody.setRotationPoint(1.0F, 24.0F, 0.0F);


        tentacleBase = new ModelRenderer(this);
        tentacleBase.setRotationPoint(-1.0F, 0.0F, 0.0F);
        tentacleBody.addChild(tentacleBase);
        tentacleBase.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 9.0F, 0.0F, false);
        tentacleBase.setTextureOffset(38, 0).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);

        tentacleLowerMid = new ModelRenderer(this);
        tentacleLowerMid.setRotationPoint(0.0F, -8.0F, -4.0F);
        tentacleBase.addChild(tentacleLowerMid);
        tentacleLowerMid.setTextureOffset(0, 18).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 7.0F, 0.0F, false);
        tentacleLowerMid.setTextureOffset(30, 17).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 8.0F, 1.0F, 0.0F, false);

        tentacleUpperMid = new ModelRenderer(this);
        tentacleUpperMid.setRotationPoint(0.0F, -8.0F, 0.0F);
        tentacleLowerMid.addChild(tentacleUpperMid);
        tentacleUpperMid.setTextureOffset(0, 33).addBox(-3.0F, -8.0F, 0.0F, 6.0F, 8.0F, 5.0F, 0.0F, false);
        tentacleUpperMid.setTextureOffset(23, 33).addBox(-2.0F, -8.0F, -1.0F, 4.0F, 8.0F, 1.0F, 0.0F, false);

        tentacleTip = new ModelRenderer(this);
        tentacleTip.setRotationPoint(0.0F, -8.0F, 0.0F);
        tentacleUpperMid.addChild(tentacleTip);
        tentacleTip.setTextureOffset(0, 46).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 8.0F, 3.0F, 0.0F, false);
        tentacleTip.setTextureOffset(14, 47).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(KrakenTentacleEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        tentacleBody.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
