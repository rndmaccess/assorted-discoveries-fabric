import oakWall from "../block_img/oak_wall.webp";
import spruceWall from "../block_img/spruce_wall.webp";
import birchWall from "../block_img/birch_wall.webp";
import jungleWall from "../block_img/jungle_wall.webp";
import acaciaWall from "../block_img/acacia_wall.webp";
import darkOakWall from "../block_img/dark_oak_wall.webp";
import mangroveWall from "../block_img/mangrove_wall.webp";
import cherryWall from "../block_img/cherry_wall.webp";
import paleOakWall from "../block_img/pale_oak_wall.webp";
import bambooWall from "../block_img/bamboo_wall.webp";
import crimsonWall from "../block_img/crimson_wall.webp";
import warpedWall from "../block_img/warped_wall.webp";

import oakLog from "../block_img/oak_log.webp";
import spruceLog from "../block_img/spruce_log.webp";
import birchLog from "../block_img/birch_log.webp";
import jungleLog from "../block_img/jungle_log.webp";
import acaciaLog from "../block_img/acacia_log.webp";
import darkOakLog from "../block_img/dark_oak_log.webp";
import mangroveLog from "../block_img/mangrove_log.webp";
import cherryLog from "../block_img/cherry_log.webp";
import paleOakLog from "../block_img/pale_oak_log.webp";
import crimsonStem from "../block_img/crimson_stem.webp";
import warpedStem from "../block_img/warped_stem.webp";

import oakWood from "../block_img/oak_wood.webp";
import spruceWood from "../block_img/spruce_wood.webp";
import birchWood from "../block_img/birch_wood.webp";
import jungleWood from "../block_img/jungle_wood.webp";
import acaciaWood from "../block_img/acacia_wood.webp";
import darkOakWood from "../block_img/dark_oak_wood.webp";
import mangroveWood from "../block_img/mangrove_wood.webp";
import cherryWood from "../block_img/cherry_wood.webp";
import paleOakWood from "../block_img/pale_oak_wood.webp";
import crimsonHyphae from "../block_img/crimson_hyphae.webp";
import warpedHyphae from "../block_img/warped_hyphae.webp";

import strippedOakWall from "../block_img/stripped_oak_wall.webp";
import strippedSpruceWall from "../block_img/stripped_spruce_wall.webp";
import strippedBirchWall from "../block_img/stripped_birch_wall.webp";
import strippedJungleWall from "../block_img/stripped_jungle_wall.webp";
import strippedAcaciaWall from "../block_img/stripped_acacia_wall.webp";
import strippedDarkOakWall from "../block_img/stripped_dark_oak_wall.webp";
import strippedMangroveWall from "../block_img/stripped_mangrove_wall.webp";
import strippedCherryWall from "../block_img/stripped_cherry_wall.webp";
import strippedPaleOakWall from "../block_img/stripped_pale_oak_wall.webp";
import strippedBambooWall from "../block_img/stripped_bamboo_wall.webp";
import strippedCrimsonWall from "../block_img/stripped_crimson_wall.webp";
import strippedWarpedWall from "../block_img/stripped_warped_wall.webp";

import strippedOakLog from "../block_img/stripped_oak_log.webp";
import strippedSpruceLog from "../block_img/stripped_spruce_log.webp";
import strippedBirchLog from "../block_img/stripped_birch_log.webp";
import strippedJungleLog from "../block_img/stripped_jungle_log.webp";
import strippedAcaciaLog from "../block_img/stripped_acacia_log.webp";
import strippedDarkOakLog from "../block_img/stripped_dark_oak_log.webp";
import strippedMangroveLog from "../block_img/stripped_mangrove_log.webp";
import strippedCherryLog from "../block_img/stripped_cherry_log.webp";
import strippedPaleOakLog from "../block_img/stripped_pale_oak_log.webp";
import strippedCrimsonStem from "../block_img/stripped_crimson_stem.webp";
import strippedWarpedStem from "../block_img/stripped_warped_stem.webp";

import strippedOakWood from "../block_img/stripped_oak_wood.webp";
import strippedSpruceWood from "../block_img/stripped_spruce_wood.webp";
import strippedBirchWood from "../block_img/stripped_birch_wood.webp";
import strippedJungleWood from "../block_img/stripped_jungle_wood.webp";
import strippedAcaciaWood from "../block_img/stripped_acacia_wood.webp";
import strippedDarkOakWood from "../block_img/stripped_dark_oak_wood.webp";
import strippedMangroveWood from "../block_img/stripped_mangrove_wood.webp";
import strippedCherryWood from "../block_img/stripped_cherry_wood.webp";
import strippedPaleOakWood from "../block_img/stripped_pale_oak_wood.webp";
import strippedCrimsonHyphae from "../block_img/stripped_crimson_hyphae.webp";
import strippedWarpedHyphae from "../block_img/stripped_warped_hyphae.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel, createRecipeCycle} from "./page_util";

const optionList = {
    "oak": [
        {
            "src": oakWall,
            "alt": "Oak Wall"
        },
        {
            "src": strippedOakWall,
            "alt": ""
        }
    ],
    "spruce": [
        {
            "src": spruceWall,
            "alt": "Spruce Wall"
        },
        {
            "src": strippedSpruceWall,
            "alt": ""
        }
    ],
    "birch": [
        {
            "src": birchWall,
            "alt": "Birch Wall"
        },
        {
            "src": strippedBirchWall,
            "alt": ""
        }
    ],
    "jungle": [
        {
            "src": jungleWall,
            "alt": "Jungle Wall"
        },
        {
            "src": strippedJungleWall,
            "alt": ""
        }
    ],
    "acacia": [
        {
            "src": acaciaWall,
            "alt": "Acacia Wall"
        },
        {
            "src": strippedAcaciaWall,
            "alt": ""
        }
    ],
    "dark_oak": [
        {
            "src": darkOakWall,
            "alt": "Dark Oak Wall"
        },
        {
            "src": strippedDarkOakWall,
            "alt": ""
        }
    ],
    "mangrove": [
        {
            "src": mangroveWall,
            "alt": "Mangrove Wall"
        },
        {
            "src": strippedMangroveWall,
            "alt": ""
        }
    ],
    "cherry": [
        {
            "src": cherryWall,
            "alt": "Cherry Wall"
        },
        {
            "src": strippedCherryWall,
            "alt": ""
        }
    ],
    "pale_oak": [
        {
            "src": paleOakWall,
            "alt": "Pale Oak Wall"
        },
        {
            "src": strippedPaleOakWall,
            "alt": ""
        }
    ],
    "bamboo": [
        {
            "src": bambooWall,
            "alt": "Bamboo Wall"
        },
        {
            "src": strippedBambooWall,
            "alt": ""
        }
    ],
    "crimson": [
        {
            "src": crimsonWall,
            "alt": "Crimson Wall"
        },
        {
            "src": strippedCrimsonWall,
            "alt": ""
        }
    ],
    "warped": [
        {
            "src": warpedWall,
            "alt": "Warped Wall"
        },
        {
            "src": strippedWarpedWall,
            "alt": ""
        }
    ]
}

const craftingLists = {
    "oak": [oakLog, oakWood],
    "spruce": [spruceLog, spruceWood],
    "birch": [birchLog, birchWood],
    "jungle": [jungleLog, jungleWood],
    "acacia": [acaciaLog, acaciaWood],
    "dark_oak": [darkOakLog, darkOakWood],
    "mangrove": [mangroveLog, mangroveWood],
    "cherry": [cherryLog, cherryWood],
    "pale_oak": [paleOakLog, paleOakWood],
    "crimson": [crimsonStem, crimsonHyphae],
    "warped": [warpedStem, warpedHyphae],

    "stripped_oak": [strippedOakLog, strippedOakWood],
    "stripped_spruce": [strippedSpruceLog, strippedSpruceWood],
    "stripped_birch": [strippedBirchLog, strippedBirchWood],
    "stripped_jungle": [strippedJungleLog, strippedJungleWood],
    "stripped_acacia": [strippedAcaciaLog, strippedAcaciaWood],
    "stripped_dark_oak": [strippedDarkOakLog, strippedDarkOakWood],
    "stripped_mangrove": [strippedMangroveLog, strippedMangroveWood],
    "stripped_cherry": [strippedCherryLog, strippedCherryWood],
    "stripped_pale_oak": [strippedPaleOakLog, strippedPaleOakWood],
    "stripped_crimson": [strippedCrimsonStem, strippedCrimsonHyphae],
    "stripped_warped": [strippedWarpedStem, strippedWarpedHyphae]
};

createRecipeCycle(craftingLists)

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}