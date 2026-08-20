import cindersnapBerryJuice from "../item_img/cindersnap_berry_juice.webp";
import frostbiteBerryJuice from "../item_img/frostbite_berry_juice.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./page_util";

const optionList = {
    "cindersnap": [
        {
            "src": cindersnapBerryJuice,
            "alt": "Cindersnap Berry Juice"
        }
    ],
    "frostbite": [
        {
            "src": frostbiteBerryJuice,
            "alt": "Frostbite Berry Juice"
        }
    ]
}

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}