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
    fields: ['title', 'key_words'],
    storeFields: ['title', 'key_words', 'description', 'link', 'img'],
});

const documents = [
    {
        id: 1,
        title: 'bog blossom',
        key_words: 'flower swamp plant',
        description: 'An illuminated swamp flower with majestic yellow particles.',
        link: './bog_blossom.html',
        img: bogBlossom,
    },
    {
        id: 2,
        title: 'planter boxes',
        key_words: 'growing overworld nether crops oak spruce birch jungle acacia dark mangrove cherry pale bamboo crimson warped',
        description: 'A planter box that can dynamically expand and is great for growing any overworld or nether crops!',
        link: './planter_boxes.html',
        img: oakPlanterBox,
    },
    {
        id: 3,
        title: 'rope ladders',
        key_words: '',
        description: 'These ladders can be hung from any solid block!',
        link: './rope_ladders.html',
        img: oakRopeLadder,
    },
    {
        id: 4,
        title: 'enderman plushie',
        key_words: '',
        description: 'A plushie inspired by the enderman mob that features a grass block that changes color by biome.',
        link: './enderman_plushie.html',
        img: endermanPlushie,
    },
    {
        id: 5,
        title: 'zombie plushie',
        key_words: '',
        description: 'A plushie inspired by the zombie mob.',
        link: './zombie_plushie.html',
        img: zombiePlushie,
    },
    {
        id: 6,
        title: 'wolf plushies',
        key_words: 'dog',
        description: 'Plushies inspired by the wolf mob variants, the wolf plushie can both sit and stand.',
        link: './wolf_plushies.html',
        img: paleWolfPlushieStanding,
    },
    {
        id: 7,
        title: 'strider plushies',
        key_words: '',
        description: 'Plushies inspired by the strider mob\'s different forms',
        link: './strider_plushies.html',
        img: striderPlushie,
    },
    {
        id: 8,
        title: 'allay plushie',
        key_words: '',
        description: 'An illuminated plushie inspired by the allay mob.',
        link: './allay_plushie.html',
        img: allayPlushie,
    },
    {
        id: 9,
        title: 'vex plushie',
        key_words: '',
        description: 'An illuminated plushie inspired by the vex mob.',
        link: './vex_plushie.html',
        img: vexPlushie,
    },
    {
        id: 10,
        title: 'cat plushies',
        key_words: '',
        description: 'Plushies inspired by the cat and ocelot mob variants, the cat plushie can both sit and stand.',
        link: './cat_plushies.html',
        img: ocelotPlushieStanding,
    },
    {
        id: 11,
        title: 'cow plushies',
        key_words: '',
        description: 'A plushie inspired by the cow mob.',
        link: './cow_plushies.html',
        img: temperateCowPlushie,
    },
    {
        id: 12,
        title: 'mooshroom plushies',
        key_words: '',
        description: 'Plushies inspired by the mooshroom mob variants.',
        link: './mooshroom_plushies.html',
        img: redMooshroomPlushie,
    },
    {
        id: 13,
        title: 'sheep plushies',
        key_words: 'white light gray black brown red orange yellow lime green cyan blue purple magenta pink',
        description: 'Plushies inspired by the sheep mob variants.',
        link: './sheep_plushies.html',
        img: whiteSheepPlushie,
    },
    {
        id: 14,
        title: 'hoglin plushies',
        key_words: '',
        description: 'Plushies inspired by hoglin mob variants.',
        link: './hoglin_plushies.html',
        img: hoglinPlushie,
    },
    {
        id: 15,
        title: 'wild green onions',
        key_words: 'plant seeds',
        description: 'A plant that drops green onion seeds when broken.',
        link: './wild_green_onions.html',
        img: wildGreenOnions,
    },
    {
        id: 16,
        title: 'green onion seeds',
        key_words: 'plant',
        description: 'The seeds used to plant green onion crops.',
        link: './green_onion_seeds.html',
        img: greenOnionSeeds,
    },
    {
        id: 17,
        title: 'green onion',
        key_words: 'plant seeds food',
        description: 'A food item that can be eaten as is or used in crafting recipes.',
        link: './green_onion.html',
        img: greenOnion,
    },
    {
        id: 18,
        title: 'grass slabs',
        key_words: 'podzol mycelium',
        description: 'Read all about the grass, podzol, and mycelium slabs.',
        link: './grass_slabs.html',
        img: grassSlab,
    },
    {
        id: 19,
        title: 'dirt slabs',
        key_words: 'coarse rooted',
        description: 'Everything you need to know about dirt, coarse dirt, and rooted dirt slabs.',
        link: './dirt_slabs.html',
        img: dirtSlab,
    },
    {
        id: 20,
        title: 'dirt path slab',
        key_words: 'grass mycelium coarse rooted podzol',
        description: 'The path variant for all grass and dirt slabs!',
        link: './dirt_path_slab.html',
        img: dirtPathSlab,
    },
    {
        id: 21,
        title: 'nether berries',
        key_words: 'cindersnap frostbite berry',
        description: 'Learn where to find, harvest, and use the frostbite and cindersnap berry bushes.',
        link: './nether_berries.html',
        img: cindersnapBerries,
    },
    {
        id: 22,
        title: 'spruce cone',
        key_words: 'cones forest\'s bounty forest',
        description: 'Learn more about spruce cones and what you need for forest\'s bounty!',
        link: './spruce_cone.html',
        img: spruceCone,
    },
    {
        id: 23,
        title: 'forest\'s bounty',
        key_words: 'spruce cone cones forest',
        description: 'Learn more about forest\'s bounty!',
        link: './forests_bounty.html',
        img: forestsBounty,
    },
    {
        id: 24,
        title: 'nether forage mixes',
        key_words: 'crimson warped berry cindersnap berries frostbite',
        description: 'Discover more about the crimson and warped forage mixes.',
        link: './nether_forage_mixes.html',
        img: crimsonForageMix,
    },
    {
        id: 25,
        title: 'nether berry juices',
        key_words: 'crimson warped cindersnap frostbite berries',
        description: 'Discover more about the cindersnap and frostbite berry juices.',
        link: './nether_berry_juices.html',
        img: cindersnapBerryJuice,
    },
    {
        id: 26,
        title: 'wooden walls',
        key_words: 'oak spruce birch jungle acacia dark mangrove cherry pale bamboo crimson warped',
        description: 'Read all about the various wooden walls! These include oak, spruce, birch, etc.',
        link: './wooden_walls.html',
        img: oakWall,
    },
    {
        id: 27,
        title: 'witch\'s cradle branch',
        key_words: '',
        description: 'Read all about the witch\'s cradle and their branches.',
        link: './witchs_cradle_branch.html',
        img: witchsCradleBranch,
    },
    {
        id: 28,
        title: 'witch\'s cradle soup',
        key_words: 'branch',
        description: 'Read all about the witch\'s cradle soup. A food that gives night vision!',
        link: './witchs_cradle_soup.html',
        img: witchsCradleSoup,
    },
    {
        id: 29,
        title: 'dyed campfires',
        key_words: 'white light gray black brown red orange yellow lime green cyan blue purple magenta pink',
        description: 'Read all about dyed campfires. These come in all vanilla dye colors!',
        link: './dyed_campfires.html',
        img: whiteCampfire,
    },
    {
        id: 30,
        title: 'plushies',
        key_words: '',
        description: 'Find out what all plushies have in common!',
        link: './plushies.html',
        img: endermanPlushie,
    },
    {
        id: 31,
        title: 'dyed torches',
        key_words: 'white light gray black brown red orange yellow lime green cyan blue purple magenta pink',
        description: 'Read all about dyed torches. These come in all vanilla dye colors!',
        link: './dyed_torches.html',
        img: whiteTorch,
    },
    {
        id: 32,
        title: 'stripped wooden walls',
        key_words: 'oak spruce birch jungle acacia dark mangrove cherry pale bamboo crimson warped',
        description: 'Read all about the various stripped wooden walls! These include oak, spruce, birch, etc.',
        link: './stripped_wooden_wall.html',
        img: strippedOakWall,
    },
];

miniSearch.addAll(documents);

const getSearchResults = (query) => {
    const searchOptions = {
        prefix: true, // partial word matching
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

const searchInput = document.getElementById('search');

window.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const query = urlParams.get('q');

    if (query) {
        if (searchInput) searchInput.value = query;

        const results = getSearchResults(query);
        renderResults(results);
    }
});

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase();
        if (query.trim() === '') return;
        const urlParams = new URLSearchParams(window.location.search);
        urlParams.set('q', query); // Update the url param if the user searches something new.

        window.history.pushState({}, '', `${window.location.pathname}?${urlParams.toString()}`);

        const results = getSearchResults(query);
        renderResults(results);
    }
})