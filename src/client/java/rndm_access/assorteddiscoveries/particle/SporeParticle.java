package rndm_access.assorteddiscoveries.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;

public class SporeParticle extends BillboardParticle {
    protected SporeParticle(ClientWorld clientWorld, double x, double y, double z,
                            double xd, double yd, double zd, Sprite sprite) {
        super(clientWorld, x, y, z, sprite);
        this.setBoundingBoxSpacing(0.01F, 0.01F);
        this.velocityX = xd * 0.2F + (Math.random() * 2.0D - 1.0D) * 0.02F;
        this.velocityY = yd * 0.2F + (Math.random() * 2.0D - 1.0D) * 0.02F;
        this.velocityZ = zd * 0.2F + (Math.random() * 2.0D - 1.0D) * 0.02F;
        this.maxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
    }

    @Override
    public int getBrightness(float tint) {
        return 240;
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.PARTICLE_ATLAS_OPAQUE;
    }

    @Override
    public void tick() {
        this.lastX = this.x;
        this.lastY = this.y;
        this.lastZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        } else {
            this.velocityY += 0.002D;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= 0.85F;
            this.velocityY *= 0.85F;
            this.velocityZ *= 0.85F;
        }
    }

    public record Factory(SpriteProvider spriteProvider) implements ParticleFactory<SimpleParticleType> {
        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world,
                                       double x, double y, double z, double xd, double yd, double zd, Random random) {
            return new SporeParticle(world, x, y, z, xd, yd, zd, this.spriteProvider.getSprite(random));
        }
    }
}
