import redMooshroomPlushie from "../block_img/red_mooshroom_plushie.webp";
import brownMooshroomPlushie from "../block_img/brown_mooshroom_plushie.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./page_util";

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

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}