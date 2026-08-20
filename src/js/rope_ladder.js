// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

import oakRopeLadder from "../item_img/oak_rope_ladder.webp";
import spruceRopeLadder from "../item_img/spruce_rope_ladder.webp";
import birchRopeLadder from "../item_img/birch_rope_ladder.webp";
import jungleRopeLadder from "../item_img/jungle_rope_ladder.webp";
import acaciaRopeLadder from "../item_img/acacia_rope_ladder.webp";
import darkOakRopeLadder from "../item_img/dark_oak_rope_ladder.webp";
import mangroveRopeLadder from "../item_img/mangrove_rope_ladder.webp";
import cherryRopeLadder from "../item_img/cherry_rope_ladder.webp";
import paleOakRopeLadder from "../item_img/pale_oak_rope_ladder.webp";
import bambooRopeLadder from "../item_img/bamboo_rope_ladder.webp";
import warpedRopeLadder from "../item_img/warped_rope_ladder.webp";
import crimsonRopeLadder from "../item_img/crimson_rope_ladder.webp";

import oakPlanks from "../block_img/oak_planks.webp";
import sprucePlanks from "../block_img/spruce_planks.webp";
import birchPlanks from "../block_img/birch_planks.webp";
import junglePlanks from "../block_img/jungle_planks.webp";
import acaciaPlanks from "../block_img/acacia_planks.webp";
import darkOakPlanks from "../block_img/dark_oak_planks.webp";
import mangrovePlanks from "../block_img/mangrove_planks.webp";
import cherryPlanks from "../block_img/cherry_planks.webp";
import paleOakPlanks from "../block_img/pale_oak_planks.webp";
import bambooPlanks from "../block_img/bamboo_planks.webp";
import warpedPlanks from "../block_img/warped_planks.webp";
import crimsonPlanks from "../block_img/crimson_planks.webp";

const craftingLists = {
    "rope_ladder": [oakRopeLadder, spruceRopeLadder, birchRopeLadder, jungleRopeLadder, acaciaRopeLadder,
        darkOakRopeLadder, mangroveRopeLadder, cherryRopeLadder, paleOakRopeLadder, bambooRopeLadder,
        warpedRopeLadder, crimsonRopeLadder],
    "planks": [oakPlanks, sprucePlanks, birchPlanks, junglePlanks, acaciaPlanks, darkOakPlanks, mangrovePlanks,
        cherryPlanks, paleOakPlanks, bambooPlanks, warpedPlanks, crimsonPlanks]
}
const optionList = {
    "oak": [
        {
            "src": oakRopeLadder,
            "alt": "Oak Rope Ladder"
        }
    ],
    "spruce": [
        {
            "src": spruceRopeLadder,
            "alt": "Spruce Rope Ladder"
        }
    ],
    "birch": [
        {
            "src": birchRopeLadder,
            "alt": "Birch Rope Ladder"
        }
    ],
    "jungle": [
        {
            "src": jungleRopeLadder,
            "alt": "Jungle Rope Ladder"
        }
    ],
    "acacia": [
        {
            "src": acaciaRopeLadder,
            "alt": "Acacia Rope Ladder"
        }
    ],
    "dark_oak": [
        {
            "src": darkOakRopeLadder,
            "alt": "Dark Oak Rope Ladder"
        }
    ],
    "mangrove": [
        {
            "src": mangroveRopeLadder,
            "alt": "Mangrove Rope Ladder"
        }
    ],
    "cherry": [
        {
            "src": cherryRopeLadder,
            "alt": "Cherry Rope Ladder"
        }
    ],
    "pale_oak": [
        {
            "src": paleOakRopeLadder,
            "alt": "Pale Oak Rope Ladder"
        }
    ],
    "bamboo": [
        {
            "src": bambooRopeLadder,
            "alt": "Bamboo Rope Ladder"
        }
    ],
    "warped": [
        {
            "src": warpedRopeLadder,
            "alt": "Warped Rope Ladder"
        }
    ],
    "crimson": [
        {
            "src": crimsonRopeLadder,
            "alt": "Crimson Rope Ladder"
        }
    ]
}

createRecipeCycle(craftingLists);

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}