import cindersnapBerries from "../img/cindersnap_berries.webp";
import frostbiteBerries from "../img/frostbite_berries.webp";

import twistingVines from "../img/twisting_vines_plant.webp";
import warpedRoots from "../img/warped_roots.webp";

import weepingVines from "../img/weeping_vines_plant.webp";
import crimsonRoots from "../img/crimson_roots.webp";

import crimsonForageMix from "../img/crimson_forage_mix.webp";
import warpedForageMix from "../img/warped_forage_mix.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel, createRecipeCycle } from "./side_page";

const craftingLists = {
    "warped_vegetation": [twistingVines, warpedRoots],
    "crimson_vegetation": [weepingVines, crimsonRoots]
}
const optionList = {
    "cindersnap_berries": [
        {
            "src": cindersnapBerries,
            "alt": "Cindersnap Berries"
        }
    ],
    "frostbite_berries": [
        {
            "src": frostbiteBerries,
            "alt": "Frostbite Berries"
        }
    ],
    "warped_forage_mix": [
        {
            "src": warpedForageMix,
            "alt": "Warped Forage Mix"
        }
    ],
    "crimson_forage_mix": [
        {
            "src": crimsonForageMix,
            "alt": "Crimson Forage Mix"
        }
    ]
}

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');

createRecipeCycle(craftingLists);

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});