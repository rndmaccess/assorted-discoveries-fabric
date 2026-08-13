import cindersnapBerries from "../img/cindersnap_berries.webp";
import frostbiteBerries from "../img/frostbite_berries.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./side_page";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
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

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});