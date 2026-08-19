// Image imports so that webpack knows about them
import oakPlanterBox from '../block_img/oak_planter_box.webp';
import sprucePlanterBox from '../block_img/spruce_planter_box.webp';
import birchPlanterBox from '../block_img/birch_planter_box.webp';
import junglePlanterBox from '../block_img/jungle_planter_box.webp';
import acaciaPlanterBox from '../block_img/acacia_planter_box.webp';
import darkOakPlanterBox from '../block_img/dark_oak_planter_box.webp';
import mangrovePlanterBox from '../block_img/mangrove_planter_box.webp';
import cherryPlanterBox from '../block_img/cherry_planter_box.webp';
import paleOakPlanterBox from '../block_img/pale_oak_planter_box.webp';
import bambooPlanterBox from '../block_img/bamboo_planter_box.webp';
import warpedPlanterBox from '../block_img/warped_planter_box.webp';
import crimsonPlanterBox from '../block_img/crimson_planter_box.webp';

import oakSlab from '../block_img/oak_slab.webp';
import spruceSlab from '../block_img/spruce_slab.webp';
import birchSlab from '../block_img/birch_slab.webp';
import jungleSlab from '../block_img/jungle_slab.webp';
import acaciaSlab from '../block_img/acacia_slab.webp';
import darkOakSlab from '../block_img/dark_oak_slab.webp';
import mangroveSlab from '../block_img/mangrove_slab.webp';
import cherrySlab from '../block_img/cherry_slab.webp';
import paleOakSlab from '../block_img/pale_oak_slab.webp';
import bambooSlab from '../block_img/bamboo_slab.webp';

import soulSoil from '../block_img/soul_soil.webp';
import soulSand from '../block_img/soul_sand.webp';

// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

const craftingLists = {
    "planter_box": [oakPlanterBox, sprucePlanterBox, birchPlanterBox, junglePlanterBox, acaciaPlanterBox,
        darkOakPlanterBox, mangrovePlanterBox, cherryPlanterBox, paleOakPlanterBox, bambooPlanterBox],
    "slab": [oakSlab, spruceSlab, birchSlab, jungleSlab, acaciaSlab, darkOakSlab, mangroveSlab,
        cherrySlab, paleOakSlab, bambooSlab],
    "soul_soil": [soulSoil, soulSand]
}
const optionList = {
    "oak": [
        {
            "src": oakPlanterBox,
            "alt": "Oak Planter Box"
        }
    ],
    "spruce": [
        {
            "src": sprucePlanterBox,
            "alt": "Spruce Planter Box"
        }
    ],
    "birch": [
        {
            "src": birchPlanterBox,
            "alt": "Birch Planter Box"
        }
    ],
    "jungle": [
        {
            "src": junglePlanterBox,
            "alt": "Jungle Planter Box"
        }
    ],
    "acacia": [
        {
            "src": acaciaPlanterBox,
            "alt": "Acacia Planter Box"
        }
    ],
    "dark_oak": [
        {
            "src": darkOakPlanterBox,
            "alt": "Dark Oak Planter Box"
        }
    ],
    "mangrove": [
        {
            "src": mangrovePlanterBox,
            "alt": "Mangrove Planter Box"
        }
    ],
    "cherry": [
        {
            "src": cherryPlanterBox,
            "alt": "Cherry Planter Box"
        }
    ],
    "pale_oak": [
        {
            "src": paleOakPlanterBox,
            "alt": "Pale Oak Planter Box"
        }
    ],
    "bamboo": [
        {
            "src": bambooPlanterBox,
            "alt": "Bamboo Planter Box"
        }
    ],
    "warped": [
        {
            "src": warpedPlanterBox,
            "alt": "Warned Planter Box"
        }
    ],
    "crimson": [
        {
            "src": crimsonPlanterBox,
            "alt": "Crimson Planter Box"
        }
    ]
}

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');

createRecipeCycle(craftingLists);

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});