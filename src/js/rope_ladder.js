// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

import oakRopeLadder from "../img/oak_rope_ladder.webp";
import spruceRopeLadder from "../img/spruce_rope_ladder.webp";
import birchRopeLadder from "../img/birch_rope_ladder.webp";
import jungleRopeLadder from "../img/jungle_rope_ladder.webp";
import acaciaRopeLadder from "../img/acacia_rope_ladder.webp";
import darkOakRopeLadder from "../img/dark_oak_rope_ladder.webp";
import mangroveRopeLadder from "../img/mangrove_rope_ladder.webp";
import cherryRopeLadder from "../img/cherry_rope_ladder.webp";
import paleOakRopeLadder from "../img/pale_oak_rope_ladder.webp";
import bambooRopeLadder from "../img/bamboo_rope_ladder.webp";
import warpedRopeLadder from "../img/warped_rope_ladder.webp";
import crimsonRopeLadder from "../img/crimson_rope_ladder.webp";

import oakPlanks from "../img/oak_planks.webp";
import sprucePlanks from "../img/spruce_planks.webp";
import birchPlanks from "../img/birch_planks.webp";
import junglePlanks from "../img/jungle_planks.webp";
import acaciaPlanks from "../img/acacia_planks.webp";
import darkOakPlanks from "../img/dark_oak_planks.webp";
import mangrovePlanks from "../img/mangrove_planks.webp";
import cherryPlanks from "../img/cherry_planks.webp";
import paleOakPlanks from "../img/pale_oak_planks.webp";
import bambooPlanks from "../img/bamboo_planks.webp";
import warpedPlanks from "../img/warped_planks.webp";
import crimsonPlanks from "../img/crimson_planks.webp";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const craftingGui = document.getElementById('crafting-gui');

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

if (craftingGui) createRecipeCycle(craftingLists, craftingGui);

if (container) {
    container.addEventListener('click', (event) => {
        createButtonPanel(event, optionList, container, headerImages);
    });
}