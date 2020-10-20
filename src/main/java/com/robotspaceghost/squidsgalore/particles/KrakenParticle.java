package com.robotspaceghost.squidsgalore.particles;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.model.KrakenModel;
import com.robotspaceghost.squidsgalore.client.model.KrakenTentacleModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KrakenParticle extends Particle {
    private final Model krakenModel = new KrakenModel();
    private final RenderType krakenModelRender = RenderType.getEntityTranslucent(new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/kraken.png"));
    private final Model tentacleModelLeft = new KrakenTentacleModel<>();
    private final Model tentacleModelRight = new KrakenTentacleModel<>();
    private final RenderType tentacleModelRender = RenderType.getEntityTranslucent(new ResourceLocation(SquidsGalore.MOD_ID, "textures/entity/kraken_tentacle.png"));


    private KrakenParticle(ClientWorld clientWorld, double prevPosX, double prevPosY, double prevPosZ) {
        super(clientWorld, prevPosX, prevPosY, prevPosZ);
        this.particleGravity = 0.0F;
        this.maxAge = 30;
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.CUSTOM;
    }

    public void renderParticle(IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
        float f = ((float)this.age + partialTicks) / (float)this.maxAge;
        float f1 = 0.05F + 0.5F * MathHelper.sin(f * (float)Math.PI);
        //----------------------------------------------
        // kraken head
        //--------------------------------------------
        MatrixStack krakenHead = new MatrixStack();
        krakenHead.rotate(renderInfo.getRotation());
        krakenHead.rotate(Vector3f.XP.rotationDegrees(150.0F * f - 60.0F));
        krakenHead.scale(-1.0F, -1.0F, 1.0F);
        krakenHead.translate(0.0D, -1.101F, 1.5D);
        IRenderTypeBuffer.Impl irendertypebuffer$impl_head = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        IVertexBuilder ivertexbuilder_head = irendertypebuffer$impl_head.getBuffer(this.krakenModelRender);
        this.krakenModel.render(krakenHead, ivertexbuilder_head, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, f1);
        irendertypebuffer$impl_head.finish();
        //----------------------------------------------
        // kraken tentacle left
        //--------------------------------------------
        MatrixStack tentacleLeft = new MatrixStack();
        tentacleLeft.rotate(renderInfo.getRotation());
        tentacleLeft.rotate(Vector3f.YP.rotationDegrees(40));
        tentacleLeft.rotate(Vector3f.XP.rotationDegrees(-150.0F * f + 60.0F));
        tentacleLeft.scale(-1.75F, -1.75F, 1.75F);
        tentacleLeft.translate(0.0D, -1.101F, 1D);
        IRenderTypeBuffer.Impl irendertypebuffer$impl_left = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        IVertexBuilder ivertexbuilder_left = irendertypebuffer$impl_left.getBuffer(this.tentacleModelRender);
        this.tentacleModelLeft.render(tentacleLeft, ivertexbuilder_left, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, f1);
        irendertypebuffer$impl_left.finish();
        //----------------------------------------------
        // kraken tentacle right
        //--------------------------------------------
        MatrixStack tentacleRight = new MatrixStack();
        tentacleRight.rotate(renderInfo.getRotation());
        tentacleRight.rotate(Vector3f.YP.rotationDegrees(-40));
        tentacleRight.rotate(Vector3f.XP.rotationDegrees(-150.0F * f + 60.0F));
        tentacleRight.scale(-1.75F, -1.75F, 1.75F);
        tentacleRight.translate(0.0D, -1.101F, 1D);
        IRenderTypeBuffer.Impl irendertypebuffer$impl_right = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        IVertexBuilder ivertexbuilder_right = irendertypebuffer$impl_right.getBuffer(this.tentacleModelRender);
        this.tentacleModelLeft.render(tentacleRight, ivertexbuilder_right, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, f1);
        irendertypebuffer$impl_right.finish();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new KrakenParticle(worldIn, x, y, z);
        }
    }
}
