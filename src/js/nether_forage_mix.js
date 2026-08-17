import crimsonForageMix from "../img/crimson_forage_mix.webp";
import warpedForageMix from "../img/warped_forage_mix.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./side_page";

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

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});