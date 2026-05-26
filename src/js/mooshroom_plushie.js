import redMooshroomPlushie from "../img/red_mooshroom_plushie.webp";
import brownMooshroomPlushie from "../img/brown_mooshroom_plushie.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./side_page";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const optionList = {
    "red": [
        {
            "src": redMooshroomPlushie,
            "alt": "A red mooshroom plushie sitting with its legs sprawled out!"
        }
    ],
    "brown": [
        {
            "src": brownMooshroomPlushie,
            "alt": "A brown mooshroom plushie sitting with its legs sprawled out!"
        }
    ]
}

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});