import allayPlushie from '../block_img/allay_plushie.webp';
import vexPlushie from '../block_img/vex_plushie.webp';
import striderPlushie from '../block_img/strider_plushie.webp';
import endermanPlushie from '../block_img/enderman_plushie.webp';
import oakPlanterBox from '../block_img/oak_planter_box.webp';
import paleWolfPlushieStanding from '../block_img/pale_wolf_plushie_standing.webp';
import zombiePlushie from '../block_img/zombie_plushie.webp';
import oakRopeLadder from '../item_img/oak_rope_ladder.webp';
import bogBlossom from '../block_img/bog_blossom.webp';
import ocelotPlushieStanding from '../block_img/ocelot_plushie_standing.webp';
import temperateCowPlushie from '../block_img/temperate_cow_plushie.webp';
import redMooshroomPlushie from '../block_img/red_mooshroom_plushie.webp';
import whiteSheepPlushie from '../block_img/sheep_plushie_white.webp';
import hoglinPlushie from '../block_img/hoglin_plushie.webp';
import wildGreenOnions from '../block_img/wild_green_onions.webp';
import greenOnionSeeds from '../item_img/green_onion_seeds.webp';
import greenOnion from '../item_img/green_onion.webp';
import grassSlab from '../block_img/grass_slab.webp';
import dirtSlab from '../block_img/dirt_slab.webp';
import dirtPathSlab from '../block_img/dirt_path_slab.webp';
import cindersnapBerries from '../item_img/cindersnap_berries.webp';
import forestsBounty from '../item_img/forests_bounty.webp';
import spruceCone from '../item_img/spruce_cone.webp';
import crimsonForageMix from '../item_img/crimson_forage_mix.webp';
import cindersnapBerryJuice from '../item_img/cindersnap_berry_juice.webp';
import oakWall from '../block_img/oak_wall.webp';
import witchsCradleSoup from '../item_img/witchs_cradle_soup.webp';
import witchsCradleBranch from '../item_img/witchs_cradle_branch.webp';
import whiteCampfire from '../anim_block_img/white_campfire.webp';
import whiteTorch from '../anim_block_img/white_torch.webp';
import strippedOakWall from '../block_img/stripped_oak_wall.webp';

let miniSearch = new MiniSearch({
    fields: ['title', 'keywords'],
    storeFields: ['title', 'keywords', 'description', 'link', 'img'],
});

const documents = [
    {
        id: 1,
        title: 'bog blossom',
        keywords: 'flower swamp plant configure',
        description: 'An illuminated swamp flower with majestic yellow particles. ' +
            'Learn how to find, grow, use, and multiply the Bog Blossom.',
        link: './bog_blossom.html',
        img: bogBlossom,
    },
    {
        id: 2,
        title: 'planter boxes',
        keywords: 'growing overworld nether crops oak spruce birch jungle acacia dark mangrove cherry pale bamboo crimson warped',
        description: 'A planter box that dynamically expands to fit your farm. Grow any Overworld or Nether crop with ease. ' +
            'Learn how to craft and use it.',
        link: './planter_boxes.html',
        img: oakPlanterBox,
    },
    {
        id: 3,
        title: 'rope ladders',
        keywords: '',
        description: 'Attach these hanging ladders to any solid block, then extend them downward up to 16 blocks!',
        link: './rope_ladders.html',
        img: oakRopeLadder,
    },
    {
        id: 4,
        title: 'enderman plushie',
        keywords: '',
        description: 'Bring your world to life with an Enderman plushie holding a biome-changing grass block! ' +
            'Learn how to craft yours.',
        link: './enderman_plushie.html',
        img: endermanPlushie,
    },
    {
        id: 5,
        title: 'zombie plushie',
        keywords: '',
        description: 'An adorable plushie inspired by the Zombie mob. ' +
            'Learn how to craft and display this decoration.',
        link: './zombie_plushie.html',
        img: zombiePlushie,
    },
    {
        id: 6,
        title: 'wolf plushies',
        keywords: 'dog',
        description: 'Bring Minecraft\'s wolf variants to life with these poseable DIY plushies ' +
            'that sit and stand! Learn how to craft and display your soft decorations.',
        link: './wolf_plushies.html',
        img: paleWolfPlushieStanding,
    },
    {
        id: 7,
        title: 'strider plushies',
        keywords: '',
        description: 'Bring the Nether to life with Strider plushies! Collect and craft adorable ' +
            'variants inspired by every Strider form.',
        link: './strider_plushies.html',
        img: striderPlushie,
    },
    {
        id: 8,
        title: 'allay plushie',
        keywords: '',
        description: 'Light up your world with the Allay plushie! Discover how to craft this adorable, ' +
            'illuminated plush inspired by Minecraft\'s glowing, music-loving mob.',
        link: './allay_plushie.html',
        img: allayPlushie,
    },
    {
        id: 9,
        title: 'vex plushie',
        keywords: '',
        description: 'Haunt your base with the Vex plushie! Discover how to craft this glowing, ' +
            'illuminated plush inspired by the illager\'s flying, red-eyed phantom mob.',
        link: './vex_plushie.html',
        img: vexPlushie,
    },
    {
        id: 10,
        title: 'cat plushies',
        keywords: '',
        description: 'Bring home your favorite feline! Discover how to craft cat and ocelot plushies ' +
            'that sit or stand. Check out all 11+ cat variants.',
        link: './cat_plushies.html',
        img: ocelotPlushieStanding,
    },
    {
        id: 11,
        title: 'cow plushies',
        keywords: '',
        description: 'Start your pasture with the temperate cow plushie! Discover how to craft this adorable ' +
            'bovine plush, with more unique cow variants coming soon.',
        link: './cow_plushies.html',
        img: temperateCowPlushie,
    },
    {
        id: 12,
        title: 'mooshroom plushies',
        keywords: '',
        description: 'Sprout some fun in your base with Mooshroom plushies! ' +
            'Craft these adorable fungal bovine plushies. ' +
            'View recipes for both the red and brown variants.',
        link: './mooshroom_plushies.html',
        img: redMooshroomPlushie,
    },
    {
        id: 13,
        title: 'sheep plushies',
        keywords: 'white light gray black brown red orange yellow lime green cyan blue purple magenta pink',
        description: 'Create your perfect flock! Discover how to craft and collect cute sheep plushies in your world. ' +
            'Check out all 16 vibrant color variants.',
        link: './sheep_plushies.html',
        img: whiteSheepPlushie,
    },
    {
        id: 14,
        title: 'hoglin plushies',
        keywords: 'zoglin',
        description: 'Bring the Crimson Forest to life! Discover how to craft fierce Hoglin and Zoglin plushies. ' +
            'Check out all the unique Nether mob variants and recipes.',
        link: './hoglin_plushies.html',
        img: hoglinPlushie,
    },
    {
        id: 15,
        title: 'wild green onions',
        keywords: 'plant seeds',
        description: 'Forage the wilderness for wild green onions! Discover where to find this useful plant, ' +
            'how to harvest its seeds, and start your own farm.',
        link: './wild_green_onions.html',
        img: wildGreenOnions,
    },
    {
        id: 16,
        title: 'green onion seeds',
        keywords: 'plant',
        description: 'Grow your own custom crops! Discover how to plant green onion seeds, accelerate growth, ' +
            'and harvest fresh green onions for cooking.',
        link: './green_onion_seeds.html',
        img: greenOnionSeeds,
    },
    {
        id: 17,
        title: 'green onion',
        keywords: 'plant seeds food',
        description: 'Cook up something delicious with green onions! Discover hunger values, saturation levels, ' +
            'and all crafting recipes for this versatile food item.',
        link: './green_onion.html',
        img: greenOnion,
    },
    {
        id: 18,
        title: 'grass slabs',
        keywords: 'podzol mycelium',
        description: 'Upgrade your landscapes with grass, podzol, and mycelium slabs! Discover how to craft ' +
            'these custom building blocks and view all unique block behaviors.',
        link: './grass_slabs.html',
        img: grassSlab,
    },
    {
        id: 19,
        title: 'dirt slabs',
        keywords: 'coarse rooted',
        description: 'Perfect your natural builds with dirt, coarse dirt, and rooted dirt slabs! ' +
            'Discover how to craft these building blocks and view all block properties.',
        link: './dirt_slabs.html',
        img: dirtSlab,
    },
    {
        id: 20,
        title: 'dirt path slab',
        keywords: 'grass mycelium coarse rooted podzol',
        description: 'Carve out beautiful trails! Right-click grass and dirt slabs with any shovel to transform them ' +
            'into path slabs. View full block properties here.',
        link: './dirt_path_slab.html',
        img: dirtPathSlab,
    },
    {
        id: 21,
        title: 'nether berries',
        keywords: 'cindersnap frostbite berry',
        description: 'Forage the Nether for frostbite and cindersnap berries! ' +
            'Learn where to find these custom bushes in warped and crimson forests, harvest them, and use them.',
        link: './nether_berries.html',
        img: cindersnapBerries,
    },
    {
        id: 22,
        title: 'spruce cone',
        keywords: 'cones forest\'s bounty forest',
        description: 'Forage for spruce cones and create the forest\'s bounty! ' +
            'Learn how to collect this custom food item from spruce trees and check out all recipe data.',
        link: './spruce_cone.html',
        img: spruceCone,
    },
    {
        id: 23,
        title: 'forest\'s bounty',
        keywords: 'spruce cone cones forest',
        description: 'Feast on forest\'s bounty! Learn how to combine spruce cones and other raw ' +
            'ingredients to craft this custom food item. View all food properties.',
        link: './forests_bounty.html',
        img: forestsBounty,
    },
    {
        id: 24,
        title: 'nether forage mixes',
        keywords: 'crimson warped berry cindersnap berries frostbite',
        description: 'Master Nether cooking! Discover how to craft crimson and warped forage mixes using ' +
            'frostbite and cindersnap berries to unlock Fire Resistance. View all late-game food properties.',
        link: './nether_forage_mixes.html',
        img: crimsonForageMix,
    },
    {
        id: 25,
        title: 'nether berry juices',
        keywords: 'crimson warped cindersnap frostbite berries',
        description: 'Quench your thirst and gain Fire Resistance! Learn how to craft frostbite and cindersnap ' +
            'berry juices. View full food properties and crafting guides.',
        link: './nether_berry_juices.html',
        img: cindersnapBerryJuice,
    },
    {
        id: 26,
        title: 'wooden walls',
        keywords: 'oak spruce birch jungle acacia dark mangrove cherry pale bamboo crimson warped',
        description: 'Transform your world and add depth to your structures! Learn how to craft ' +
            'wooden walls in every wood type, and view full block properties.',
        link: './wooden_walls.html',
        img: oakWall,
    },
    {
        id: 27,
        title: 'witch\'s cradle branch',
        keywords: '',
        description: 'Conquer the dark and master the swamp! Learn how to harvest the witch\'s cradle bush ' +
            'and craft its soup. View full recipes and mechanics.',
        link: './witchs_cradle_branch.html',
        img: witchsCradleBranch,
    },
    {
        id: 28,
        title: 'witch\'s cradle soup',
        keywords: 'branch',
        description: 'Conquer the dark and master the swamp! Learn how to craft witch\'s cradle soup and gain ' +
            'night vision. View full food properties and saturation stats.',
        link: './witchs_cradle_soup.html',
        img: witchsCradleSoup,
    },
    {
        id: 29,
        title: 'dyed campfires',
        keywords: 'white light gray black brown red orange yellow lime green cyan blue purple magenta pink',
        description: 'Illuminate your camps and color your world! Learn how to craft dyed campfires in all ' +
            'sixteen colors. View full block variations and smoke signal guides.',
        link: './dyed_campfires.html',
        img: whiteCampfire,
    },
    {
        id: 30,
        title: 'plushies',
        keywords: '',
        description: 'Decorate your world and collect them all! Learn how to find and craft over ninety ' +
            'unique plushies. View full block properties and common mechanics.',
        link: './plushies.html',
        img: endermanPlushie,
    },
    {
        id: 31,
        title: 'dyed torches',
        keywords: 'white light gray black brown red orange yellow lime green cyan blue purple magenta pink',
        description: 'Illuminate your builds and color your world! Learn how to craft dyed torches in all ' +
            'sixteen colors. View full block properties and light level stats.',
        link: './dyed_torches.html',
        img: whiteTorch,
    },
    {
        id: 32,
        title: 'stripped wooden walls',
        keywords: 'oak spruce birch jungle acacia dark mangrove cherry pale bamboo crimson warped',
        description: 'Transform your world and add depth to your structures! Learn how to obtain stripped wooden walls ' +
            'in every wood type. View full block properties.',
        link: './stripped_wooden_walls.html',
        img: strippedOakWall,
    },
];

miniSearch.addAll(documents);

const getSearchResults = (query) => {
    const searchOptions = {
        prefix: true, // partial word matching
        combineWith: 'AND',
        boost: {
            title: 3, // Give the title priority
            keywords: 1
        },
        fuzzy: 0.2    // allow minor misspellings
    };
    return miniSearch.search(query, searchOptions);
}

const renderResults = (results) => {
    const searchList = document.getElementById('search-results');

    if (!searchList) {
        console.error('Search results not found');
        return;
    }

    if (Array.isArray(results) && results.length === 0) {
        searchList.innerHTML = "No results found.";
        return;
    }

    if (results.length === 1) {
        window.location.href = results[0].link;
    }

    searchList.innerHTML = "";
    searchList.insertAdjacentHTML('beforeend', results.map(({ title, description, link, img }) => {
        if (title === undefined) {
            return "";
        }
        return `<li class="result-item">
                <div>
                    <div>
                        <a class="result-title" href="${link}">${title}</a>
                        <p>
                            ${description}
                        </p>
                    </div>
                </div>
                <img class="result-img" src="${img}" alt="${title}">
            </li>`;
    }).join('\n'));
}

function isValidQuery(query) {
    const searchList = document.getElementById('search-results');
    const test = query && query.trim().length >= 3;

    if (!test) {
        searchList.innerHTML = "Please type at least 3 characters.";
    }
    return test;
}

const searchInput = document.getElementById('search');

window.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const query = urlParams.get('q');

    if (query) {
        if (searchInput) searchInput.value = query;

        if (!isValidQuery(query)) {
            return;
        }

        const results = getSearchResults(query);
        renderResults(results);
    }
});

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase().trim();

        if (!isValidQuery(query)) {
            event.preventDefault(); // Stops the page from submitting/navigating
            return;
        }

        const urlParams = new URLSearchParams(window.location.search);
        urlParams.set('q', query); // Update the url param if the user searches something new.

        window.history.pushState({}, '', `${window.location.pathname}?${urlParams.toString()}`);

        const results = getSearchResults(query);
        renderResults(results);
    }
})