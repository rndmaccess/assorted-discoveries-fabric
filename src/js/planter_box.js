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
import poplarPlanterBox from '../block_img/poplar_planter_box.webp';
import warpedPlanterBox from '../block_img/warped_planter_box.webp';
import crimsonPlanterBox from '../block_img/crimson_planter_box.webp';

import oakPlanterBoxItem from '../crafting_block_img/oak_planter_box.webp';
import sprucePlanterBoxItem from '../crafting_block_img/spruce_planter_box.webp';
import birchPlanterBoxItem from '../crafting_block_img/birch_planter_box.webp';
import junglePlanterBoxItem from '../crafting_block_img/jungle_planter_box.webp';
import acaciaPlanterBoxItem from '../crafting_block_img/acacia_planter_box.webp';
import darkOakPlanterBoxItem from '../crafting_block_img/dark_oak_planter_box.webp';
import mangrovePlanterBoxItem from '../crafting_block_img/mangrove_planter_box.webp';
import cherryPlanterBoxItem from '../crafting_block_img/cherry_planter_box.webp';
import paleOakPlanterBoxItem from '../crafting_block_img/pale_oak_planter_box.webp';
import bambooPlanterBoxItem from '../crafting_block_img/bamboo_planter_box.webp';
import poplarPlanterBoxItem from '../crafting_block_img/poplar_planter_box.webp';

import oakSlab from '../crafting_block_img/oak_slab.webp';
import spruceSlab from '../crafting_block_img/spruce_slab.webp';
import birchSlab from '../crafting_block_img/birch_slab.webp';
import jungleSlab from '../crafting_block_img/jungle_slab.webp';
import acaciaSlab from '../crafting_block_img/acacia_slab.webp';
import darkOakSlab from '../crafting_block_img/dark_oak_slab.webp';
import mangroveSlab from '../crafting_block_img/mangrove_slab.webp';
import cherrySlab from '../crafting_block_img/cherry_slab.webp';
import paleOakSlab from '../crafting_block_img/pale_oak_slab.webp';
import bambooSlab from '../crafting_block_img/bamboo_slab.webp';
import poplarSlab from '../crafting_block_img/poplar_slab.webp';

import soulSoil from '../crafting_block_img/soul_soil.webp';
import soulSand from '../crafting_block_img/soul_sand.webp';

// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./page_util";

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
    "poplar": [
        {
            "src": poplarPlanterBox,
            "alt": "Poplar Planter Box"
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

const craftingLists = {
    "planter_box": [oakPlanterBoxItem, sprucePlanterBoxItem, birchPlanterBoxItem, junglePlanterBoxItem,
        acaciaPlanterBoxItem, darkOakPlanterBoxItem, mangrovePlanterBoxItem, cherryPlanterBoxItem,
        paleOakPlanterBoxItem, bambooPlanterBoxItem, poplarPlanterBoxItem],
    "slab": [oakSlab, spruceSlab, birchSlab, jungleSlab, acaciaSlab, darkOakSlab, mangroveSlab,
        cherrySlab, paleOakSlab, bambooSlab, poplarSlab],
    "soul_soil": [soulSoil, soulSand]
}

createRecipeCycle(craftingLists);

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}