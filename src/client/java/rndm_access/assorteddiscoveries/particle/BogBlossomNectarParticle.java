package rndm_access.assorteddiscoveries.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleGroup;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

import java.util.Optional;

public class BogBlossomNectarParticle extends BillboardParticle {
    @Override
    public RenderType getRenderType() {
        return BillboardParticle.RenderType.PARTICLE_ATLAS_OPAQUE;
    }

    protected BogBlossomNectarParticle(ClientWorld clientWorld, double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ, Sprite sprite) {
        super(clientWorld, x, y - 0.125D, z, velocityX, velocityY, velocityZ, sprite);
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.scale *= this.random.nextFloat() * 0.6F + 0.6F;
        this.maxAge = MathHelper.nextBetween(clientWorld.random, 500, 1000);
        this.collidesWithWorld = false;
        this.velocityMultiplier = 1.0F;
        this.gravityStrength = 0.01F;
        this.setColor(1.0F, 0.8F, 0.5F);
    }

    @Override
    public void tick() {
        this.updateAge();

        if(this.isAlive()) {
            super.tick();
        }
    }

    private void updateAge() {
        if(this.maxAge-- <= 0) {
            this.markDead();
        }
    }

    @Override
    public int getBrightness(float tint) {
        return 240;
    }

    public record Factory(SpriteProvider spriteProvider) implements ParticleFactory<SimpleParticleType> {

        @Override
        public Particle createParticle(SimpleParticleType particle, ClientWorld world, double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ, Random random) {
            return new BogBlossomNectarParticle(world, x, y, z,
                    0.0D, -0.8D, 0.0D, this.spriteProvider.getSprite(random)) {
                public Optional<ParticleGroup> getGroup() {
                    return Optional.of(ParticleGroup.SPORE_BLOSSOM_AIR);
                }
            };
        }
    }
}
