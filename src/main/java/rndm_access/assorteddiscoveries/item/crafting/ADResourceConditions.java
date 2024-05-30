package rndm_access.assorteddiscoveries.item.crafting;

import com.google.common.collect.Maps;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ADConfig;

import java.util.Map;

public class ADResourceConditions {
    private static final Map<String, Boolean> NAME_TO_CONFIG_ENTRY;
    private static final Identifier CONFIG_ENTRY_ENABLED;

    public static void registerResourceConditions() {
        populateEntries();
        ResourceConditions.register(CONFIG_ENTRY_ENABLED, object -> {
            String config_entry = JsonHelper.getString(object, "value");

            if(NAME_TO_CONFIG_ENTRY.containsKey(config_entry)) {
                return NAME_TO_CONFIG_ENTRY.get(config_entry);
            } else {
                AssortedDiscoveries.LOGGER.error("{} is not a known config entry!", config_entry);
                return true;
            }
        });
    }

    private static void putEntry(String name, boolean config_entry) {
        if(!NAME_TO_CONFIG_ENTRY.containsKey(name)) {
            NAME_TO_CONFIG_ENTRY.put(ADReference.makeModId(name).toString(), config_entry);
        } else {
            AssortedDiscoveries.LOGGER.error("{} is already registered!", name);
        }
    }

    private static void populateEntries() {
        ADConfig config = AutoConfig.getConfigHolder(ADConfig.class).getConfig();

        // Plush config options
        putEntry("enable_blaze_plush", config.getPlushies().isBlazePlushEnabled());
        putEntry("enable_bat_plush", config.getPlushies().isBatPlushEnabled());
        putEntry("enable_chicken_plush", config.getPlushies().isChickenPlushEnabled());
        putEntry("enable_cow_plush", config.getPlushies().isCowPlushEnabled());
        putEntry("enable_creeper_plush", config.getPlushies().isCreeperPlushEnabled());
        putEntry("enable_enderman_plush", config.getPlushies().isEndermanPlushEnabled());
        putEntry("enable_ghast_plush", config.getPlushies().isGhastPlushEnabled());
        putEntry("enable_guardian_plush", config.getPlushies().isGuardianPlushEnabled());
        putEntry("enable_horse_plushies", config.getPlushies().areHorsePlushiesEnabled());
        putEntry("enable_mooshroom_plushies", config.getPlushies().areMooshroomPlushiesEnabled());
        putEntry("enable_pale_wolf_plush", config.getPlushies().isPaleWolfPlushEnabled());
        putEntry("enable_ocelot_plush", config.getPlushies().isOcelotPlushEnabled());
        putEntry("enable_tabby_cat_plush", config.getPlushies().isTabbyCatPlushEnabled());
        putEntry("enable_tuxedo_cat_plush", config.getPlushies().isTuxedoCatPlushEnabled());
        putEntry("enable_red_cat_plush", config.getPlushies().isRedCatPlushEnabled());
        putEntry("enable_siamese_cat_plush", config.getPlushies().isSiameseCatPlushEnabled());
        putEntry("enable_british_shorthair_cat_plush", config.getPlushies().isBritishShorthairCatPlushEnabled());
        putEntry("enable_calico_cat_plush", config.getPlushies().isCalicoCatPlushEnabled());
        putEntry("enable_persian_cat_plush", config.getPlushies().isPersianCatPlushEnabled());
        putEntry("enable_ragdoll_cat_plush", config.getPlushies().isRagdollCatPlushEnabled());
        putEntry("enable_white_cat_plush", config.getPlushies().isWhiteCatPlushEnabled());
        putEntry("enable_black_cat_plush", config.getPlushies().isBlackCatPlushEnabled());
        putEntry("enable_jellie_cat_plush", config.getPlushies().isJellieCatPlushEnabled());
        putEntry("enable_pig_plush", config.getPlushies().isPigPlushEnabled());
        putEntry("enable_rabbit_plushies", config.getPlushies().areRabbitPlushiesEnabled());
        putEntry("enable_sheep_plushies", config.getPlushies().areSheepPlushiesEnabled());
        putEntry("enable_skeleton_plush", config.getPlushies().isSkeletonPlushEnabled());
        putEntry("enable_slime_plush", config.getPlushies().isSlimePlushEnabled());
        putEntry("enable_magma_cube_plush", config.getPlushies().isMagmaCubePlushEnabled());
        putEntry("enable_spider_plush", config.getPlushies().isSpiderPlushEnabled());
        putEntry("enable_cave_spider_plush", config.getPlushies().isCaveSpiderPlushEnabled());
        putEntry("enable_squid_plushies", config.getPlushies().areSquidPlushiesEnabled());
        putEntry("enable_bee_plush", config.getPlushies().isBeePlushEnabled());
        putEntry("enable_villager_plushies", config.getPlushies().areVillagerPlushiesEnabled());
        putEntry("enable_wandering_trader_plush", config.getPlushies().isWanderingTraderPlushEnabled());
        putEntry("enable_zombie_villager_plushies", config.getPlushies().areZombieVillagerPlushiesEnabled());
        putEntry("enable_witch_plush", config.getPlushies().isWitchPlushEnabled());
        putEntry("enable_zombie_plush", config.getPlushies().isZombiePlushEnabled());
        putEntry("enable_piglin_plushies", config.getPlushies().arePiglinPlushiesEnabled());
        putEntry("enable_hoglin_plushies", config.getPlushies().areHoglinPlushiesEnabled());
        putEntry("enable_pufferfish_plush", config.getPlushies().isPufferfishPlushEnabled());
        putEntry("enable_wither_plush", config.getPlushies().isWitherPlushEnabled());
        putEntry("enable_strider_plushies", config.getPlushies().areStriderPlushiesEnabled());
        putEntry("enable_phantom_plush", config.getPlushies().isPhantomPlushEnabled());
        putEntry("enable_polar_bear_plush", config.getPlushies().isPolarBearPlushEnabled());
        putEntry("enable_allay_plush", config.getPlushies().isAllayPlushEnabled());
        putEntry("enable_vex_plush", config.getPlushies().isVexPlushEnabled());
        putEntry("enable_illager_plushies", config.getPlushies().areIllagerPlushiesEnabled());
        putEntry("enable_ravager_plush", config.getPlushies().isRavagerPlushEnabled());
        putEntry("enable_shulker_plush", config.getPlushies().isShulkerPlushEnabled());
        putEntry("enable_camel_plush", config.getPlushies().isCamelPlushEnabled());

        // Farming config options
        putEntry("enable_overworld_planter_boxes", config.getFarming().areOverworldPlanterBoxesEnabled());
        putEntry("enable_nether_planter_boxes", config.getFarming().areNetherPlanterBoxesEnabled());
        putEntry("enable_green_onions_and_wild_green_onions", config.getFarming().getGreenOnionsAndWildGreenOnionsEnabled());
        putEntry("enable_noodles_and_noodle_soup", config.getFarming().getNoodlesAndNoodleSoupEnabled());
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
