import cindersnapBerryJuice from "../item_img/cindersnap_berry_juice.webp";
import frostbiteBerryJuice from "../item_img/frostbite_berry_juice.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./side_page";

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

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});