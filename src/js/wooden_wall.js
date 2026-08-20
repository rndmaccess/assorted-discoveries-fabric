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

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel, createRecipeCycle} from "./page_util";

const optionList = {
    "oak": [
        {
            "src": oakWall,
            "alt": "Oak Wall"
        }
    ],
    "spruce": [
        {
            "src": spruceWall,
            "alt": "Spruce Wall"
        }
    ],
    "birch": [
        {
            "src": birchWall,
            "alt": "Birch Wall"
        }
    ],
    "jungle": [
        {
            "src": jungleWall,
            "alt": "Jungle Wall"
        }
    ],
    "acacia": [
        {
            "src": acaciaWall,
            "alt": "Acacia Wall"
        }
    ],
    "dark_oak": [
        {
            "src": darkOakWall,
            "alt": "Dark Oak Wall"
        }
    ],
    "mangrove": [
        {
            "src": mangroveWall,
            "alt": "Mangrove Wall"
        }
    ],
    "cherry": [
        {
            "src": cherryWall,
            "alt": "Cherry Wall"
        }
    ],
    "pale_oak": [
        {
            "src": paleOakWall,
            "alt": "Pale Oak Wall"
        }
    ],
    "bamboo": [
        {
            "src": bambooWall,
            "alt": "Bamboo Wall"
        }
    ],
    "crimson": [
        {
            "src": crimsonWall,
            "alt": "Crimson Wall"
        }
    ],
    "warped": [
        {
            "src": warpedWall,
            "alt": "Warped Wall"
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
    "warped": [warpedStem, warpedHyphae]
};

createRecipeCycle(craftingLists)

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}