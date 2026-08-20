import crimsonForageMix from "../item_img/crimson_forage_mix.webp";
import warpedForageMix from "../item_img/warped_forage_mix.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./page_util";

const optionList = {
    "warped": [
        {
            "src": warpedForageMix,
            "alt": "Warped Forage Mix"
        }
    ],
    "crimson": [
        {
            "src": crimsonForageMix,
            "alt": "Crimson Forage Mix"
        }
    ]
}

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}