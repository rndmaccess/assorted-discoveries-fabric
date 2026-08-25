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
            "src": strippedOakWall,
            "alt": "Stripped Oak Wall"
        }
    ],
    "spruce": [
        {
            "src": strippedSpruceWall,
            "alt": "Stripped Spruce Wall"
        }
    ],
    "birch": [
        {
            "src": strippedBirchWall,
            "alt": "Stripped Birch Wall"
        }
    ],
    "jungle": [
        {
            "src": strippedJungleWall,
            "alt": "Stripped Jungle Wall"
        }
    ],
    "acacia": [
        {
            "src": strippedAcaciaWall,
            "alt": "Stripped Acacia Wall"
        }
    ],
    "dark_oak": [
        {
            "src": strippedDarkOakWall,
            "alt": "Stripped Dark Oak Wall"
        }
    ],
    "mangrove": [
        {
            "src": strippedMangroveWall,
            "alt": "Stripped Mangrove Wall"
        }
    ],
    "cherry": [
        {
            "src": strippedCherryWall,
            "alt": "Stripped Cherry Wall"
        }
    ],
    "pale_oak": [
        {
            "src": strippedPaleOakWall,
            "alt": "Stripped Pale Oak Wall"
        }
    ],
    "bamboo": [
        {
            "src": strippedBambooWall,
            "alt": "Stripped Bamboo Wall"
        }
    ],
    "crimson": [
        {
            "src": strippedCrimsonWall,
            "alt": "Stripped Crimson Wall"
        }
    ],
    "warped": [
        {
            "src": strippedWarpedWall,
            "alt": "Stripped Warped Wall"
        }
    ]
}

const craftingLists = {
    "oak": [strippedOakLog, strippedOakWood],
    "spruce": [strippedSpruceLog, strippedSpruceWood],
    "birch": [strippedBirchLog, strippedBirchWood],
    "jungle": [strippedJungleLog, strippedJungleWood],
    "acacia": [strippedAcaciaLog, strippedAcaciaWood],
    "dark_oak": [strippedDarkOakLog, strippedDarkOakWood],
    "mangrove": [strippedMangroveLog, strippedMangroveWood],
    "cherry": [strippedCherryLog, strippedCherryWood],
    "pale_oak": [strippedPaleOakLog, strippedPaleOakWood],
    "crimson": [strippedCrimsonStem, strippedCrimsonHyphae],
    "warped": [strippedWarpedStem, strippedWarpedHyphae]
};

createRecipeCycle(craftingLists)

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}