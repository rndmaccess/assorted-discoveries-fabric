import cindersnapBerries from "../item_img/cindersnap_berries.webp";
import frostbiteBerries from "../item_img/frostbite_berries.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./side_page";

const optionList = {
    "cindersnap": [
        {
            "src": cindersnapBerries,
            "alt": "Cindersnap Berries"
        }
    ],
    "frostbite": [
        {
            "src": frostbiteBerries,
            "alt": "Frostbite Berries"
        }
    ]
}

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});