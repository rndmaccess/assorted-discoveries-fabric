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

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}