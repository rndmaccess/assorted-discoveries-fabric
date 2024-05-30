package rndm_access.assorteddiscoveries.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "assorted-discoveries")
public class ADConfig implements ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    Plushies plushies = new Plushies();

    @ConfigEntry.Gui.CollapsibleObject
    Farming farming = new Farming();

    @ConfigEntry.Gui.CollapsibleObject
    Misc misc = new Misc();

    public Plushies getPlushies() {
        return plushies;
    }

    public Farming getFarming() {
        return farming;
    }

    public boolean getIsRabbitsSafeFallIncreased() {
        return misc.rabbits_safe_fall_increased;
    }

    public static class Plushies {
        @ConfigEntry.Gui.RequiresRestart
        boolean enable_slime_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_magma_cube_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_ocelot_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_tabby_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_tuxedo_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_red_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_siamese_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_british_shorthair_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_calico_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_persian_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_ragdoll_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_white_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_black_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_jellie_cat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_pale_wolf_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_zombie_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_skeleton_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_enderman_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_creeper_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_spider_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_cave_spider_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_guardian_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_phantom_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_bat_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_squid_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_bee_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_piglin_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_hoglin_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_ghast_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_blaze_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_strider_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_chicken_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_pig_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_cow_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_mooshroom_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_sheep_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_horse_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_rabbit_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_illager_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_villager_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_wandering_trader_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_zombie_villager_plushies = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_witch_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_pufferfish_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_wither_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_polar_bear_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_allay_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_vex_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_ravager_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_shulker_plush = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_camel_plush = true;

        public boolean isBatPlushEnabled() {
            return enable_bat_plush;
        }

        public boolean isBlazePlushEnabled() {
            return enable_blaze_plush;
        }

        public boolean isChickenPlushEnabled() {
            return enable_chicken_plush;
        }

        public boolean isCowPlushEnabled() {
            return enable_cow_plush;
        }

        public boolean isCreeperPlushEnabled() {
            return enable_creeper_plush;
        }

        public boolean isEndermanPlushEnabled() {
            return enable_enderman_plush;
        }

        public boolean isGhastPlushEnabled() {
            return enable_ghast_plush;
        }

        public boolean isGuardianPlushEnabled() {
            return enable_guardian_plush;
        }

        public boolean areHorsePlushiesEnabled() {
            return enable_horse_plushies;
        }

        public boolean areMooshroomPlushiesEnabled() {
            return enable_mooshroom_plushies;
        }

        public boolean isPaleWolfPlushEnabled() {
            return enable_pale_wolf_plush;
        }

        public boolean isOcelotPlushEnabled() {
            return enable_ocelot_plush;
        }

        public boolean isTabbyCatPlushEnabled() {
            return enable_tabby_cat_plush;
        }

        public boolean isTuxedoCatPlushEnabled() {
            return enable_tuxedo_cat_plush;
        }

        public boolean isRedCatPlushEnabled() {
            return enable_red_cat_plush;
        }

        public boolean isSiameseCatPlushEnabled() {
            return enable_siamese_cat_plush;
        }

        public boolean isBritishShorthairCatPlushEnabled() {
            return enable_british_shorthair_cat_plush;
        }

        public boolean isCalicoCatPlushEnabled() {
            return enable_calico_cat_plush;
        }

        public boolean isPersianCatPlushEnabled() {
            return enable_persian_cat_plush;
        }

        public boolean isRagdollCatPlushEnabled() {
            return enable_ragdoll_cat_plush;
        }

        public boolean isWhiteCatPlushEnabled() {
            return enable_white_cat_plush;
        }

        public boolean isBlackCatPlushEnabled() {
            return enable_black_cat_plush;
        }

        public boolean isJellieCatPlushEnabled() {
            return enable_jellie_cat_plush;
        }

        public boolean isPigPlushEnabled() {
            return enable_pig_plush;
        }

        public boolean areRabbitPlushiesEnabled() {
            return enable_rabbit_plushies;
        }

        public boolean areSheepPlushiesEnabled() {
            return enable_sheep_plushies;
        }

        public boolean isSkeletonPlushEnabled() {
            return enable_skeleton_plush;
        }

        public boolean isSlimePlushEnabled() {
            return enable_slime_plush;
        }

        public boolean isMagmaCubePlushEnabled() {
            return enable_magma_cube_plush;
        }

        public boolean isSpiderPlushEnabled() {
            return enable_spider_plush;
        }

        public boolean isCaveSpiderPlushEnabled() {
            return enable_cave_spider_plush;
        }

        public boolean areSquidPlushiesEnabled() {
            return enable_squid_plushies;
        }

        public boolean isBeePlushEnabled() {
            return enable_bee_plush;
        }

        public boolean areVillagerPlushiesEnabled() {
            return enable_villager_plushies;
        }

        public boolean isWanderingTraderPlushEnabled() {
            return enable_wandering_trader_plush;
        }

        public boolean areZombieVillagerPlushiesEnabled() {
            return enable_zombie_villager_plushies;
        }

        public boolean isWitchPlushEnabled() {
            return enable_witch_plush;
        }

        public boolean isZombiePlushEnabled() {
            return enable_zombie_plush;
        }

        public boolean arePiglinPlushiesEnabled() {
            return enable_piglin_plushies;
        }

        public boolean areHoglinPlushiesEnabled() {
            return enable_hoglin_plushies;
        }

        public boolean isPufferfishPlushEnabled() {
            return enable_pufferfish_plush;
        }

        public boolean isWitherPlushEnabled() {
            return enable_wither_plush;
        }

        public boolean areStriderPlushiesEnabled() {
            return enable_strider_plushies;
        }

        public boolean isPhantomPlushEnabled() {
            return enable_phantom_plush;
        }

        public boolean isPolarBearPlushEnabled() {
            return enable_polar_bear_plush;
        }

        public boolean isAllayPlushEnabled() {
            return enable_allay_plush;
        }

        public boolean isVexPlushEnabled() {
            return enable_vex_plush;
        }

        public boolean areIllagerPlushiesEnabled() {
            return enable_illager_plushies;
        }

        public boolean isRavagerPlushEnabled() {
            return enable_ravager_plush;
        }

        public boolean isShulkerPlushEnabled() {
            return enable_shulker_plush;
        }

        public boolean isCamelPlushEnabled() {
            return enable_camel_plush;
        }
    }

    public static class Farming {
        @ConfigEntry.Gui.RequiresRestart
        boolean enable_overworld_planter_boxes = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_nether_planter_boxes = true;

        @Comment("If disabled noodle soup does not use green onions.")
        @ConfigEntry.Gui.RequiresRestart
        boolean enable_green_onions_and_wild_green_onions = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean enable_noodles_and_noodle_soup = true;

        public boolean getGreenOnionsAndWildGreenOnionsEnabled() {
            return enable_green_onions_and_wild_green_onions;
        }

        public boolean getNoodlesAndNoodleSoupEnabled() {
            return enable_noodles_and_noodle_soup;
        }

        public boolean areOverworldPlanterBoxesEnabled() {
            return enable_overworld_planter_boxes;
        }

        public boolean areNetherPlanterBoxesEnabled() {
            return enable_nether_planter_boxes;
        }
    }

    static class Misc {
        @Comment("Rabbits can fall for 2 more blocks before taking fall damage.")
        boolean rabbits_safe_fall_increased = true;
    }
}
