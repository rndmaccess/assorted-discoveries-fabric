// Image imports so that webpack knows about them
import oakPlanterBox from '../img/oak_planter_box.webp';
import sprucePlanterBox from '../img/spruce_planter_box.webp';
import birchPlanterBox from '../img/birch_planter_box.webp';
import junglePlanterBox from '../img/jungle_planter_box.webp';
import acaciaPlanterBox from '../img/acacia_planter_box.webp';
import darkOakPlanterBox from '../img/dark_oak_planter_box.webp';
import mangrovePlanterBox from '../img/mangrove_planter_box.webp';
import cherryPlanterBox from '../img/cherry_planter_box.webp';
import paleOakPlanterBox from '../img/pale_oak_planter_box.webp';
import bambooPlanterBox from '../img/bamboo_planter_box.webp';

import oakSlab from '../img/oak_slab.webp';
import spruceSlab from '../img/spruce_slab.webp';
import jungleSlab from '../img/jungle_slab.webp';
import acaciaSlab from '../img/acacia_slab.webp';
import darkOakSlab from '../img/dark_oak_slab.webp';
import mangroveSlab from '../img/mangrove_slab.webp';
import cherrySlab from '../img/cherry_slab.webp';
import paleOakSlab from '../img/pale_oak_slab.webp';
import bambooSlab from '../img/bamboo_slab.webp';

import soulSoil from '../img/soul_soil.webp';
import soulSand from '../img/soul_sand.webp';

// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

const craftingLists = {
    "planter_box": [oakPlanterBox, sprucePlanterBox, birchPlanterBox, junglePlanterBox, acaciaPlanterBox,
        darkOakPlanterBox, mangrovePlanterBox, cherryPlanterBox, paleOakPlanterBox, bambooPlanterBox],
    "slab": [oakSlab, spruceSlab, jungleSlab, acaciaSlab, darkOakSlab, mangroveSlab,
        cherrySlab, paleOakSlab, bambooSlab],
    "soul_soil": [soulSoil, soulSand]
}

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const craftingId = document.getElementById('crafting');

if (craftingId) createRecipeCycle(craftingLists, craftingId);

container.addEventListener('click', (event) => {
    createButtonPanel(event, container, headerImages);
});