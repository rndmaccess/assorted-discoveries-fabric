import oakWall from "../img/oak_wall.webp";
import spruceWall from "../img/spruce_wall.webp";
import birchWall from "../img/birch_wall.webp";
import jungleWall from "../img/jungle_wall.webp";
import acaciaWall from "../img/acacia_wall.webp";
import darkOakWall from "../img/dark_oak_wall.webp";
import mangroveWall from "../img/mangrove_wall.webp";
import cherryWall from "../img/cherry_wall.webp";
import paleOakWall from "../img/pale_oak_wall.webp";
import bambooWall from "../img/bamboo_wall.webp";
import crimsonWall from "../img/crimson_wall.webp";
import warpedWall from "../img/warped_wall.webp";

import oakLog from "../img/oak_log.webp";
import spruceLog from "../img/spruce_log.webp";
import birchLog from "../img/birch_log.webp";
import jungleLog from "../img/jungle_log.webp";
import acaciaLog from "../img/acacia_log.webp";
import darkOakLog from "../img/dark_oak_log.webp";
import mangroveLog from "../img/mangrove_log.webp";
import cherryLog from "../img/cherry_log.webp";
import paleOakLog from "../img/pale_oak_log.webp";
import crimsonStem from "../img/crimson_stem.webp";
import warpedStem from "../img/warped_stem.webp";

import oakWood from "../img/oak_wood.webp";
import spruceWood from "../img/spruce_wood.webp";
import birchWood from "../img/birch_wood.webp";
import jungleWood from "../img/jungle_wood.webp";
import acaciaWood from "../img/acacia_wood.webp";
import darkOakWood from "../img/dark_oak_wood.webp";
import mangroveWood from "../img/mangrove_wood.webp";
import cherryWood from "../img/cherry_wood.webp";
import paleOakWood from "../img/pale_oak_wood.webp";
import crimsonHyphae from "../img/crimson_hyphae.webp";
import warpedHyphae from "../img/warped_hyphae.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel, createRecipeCycle} from "./side_page";

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

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
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

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});