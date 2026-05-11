import paleWolfPlushieStanding from "../img/pale_wolf_plushie_standing.webp";
import paleWolfPlushieSitting from "../img/pale_wolf_plushie_sitting.webp";
import ashenWolfPlushieStanding from "../img/ashen_wolf_plushie_standing.webp";
import ashenWolfPlushieSitting from "../img/ashen_wolf_plushie_sitting.webp";
import blackWolfPlushieStanding from "../img/black_wolf_plushie_standing.webp";
import blackWolfPlushieSitting from "../img/black_wolf_plushie_sitting.webp";
import chestnutWolfPlushieStanding from "../img/chestnut_wolf_plushie_standing.webp";
import chestnutWolfPlushieSitting from "../img/chestnut_wolf_plushie_sitting.webp";
import rustyWolfPlushieStanding from "../img/rusty_wolf_plushie_standing.webp";
import rustyWolfPlushieSitting from "../img/rusty_wolf_plushie_sitting.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./side_page";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const optionList = {
    "pale": [
        {
            "src": paleWolfPlushieStanding,
            "alt": "Standing pale wolf plushie"
        },
        {
            "src": paleWolfPlushieSitting,
            "alt": "Sitting pale wolf plushie"
        }
    ],
    "ashen": [
        {
            "src": ashenWolfPlushieStanding,
            "alt": "Standing ashen wolf plushie"
        },
        {
            "src": ashenWolfPlushieSitting,
            "alt": "Sitting ashen wolf plushie"
        }
    ],
    "black": [
        {
            "src": blackWolfPlushieStanding,
            "alt": "Standing black wolf plushie"
        },
        {
            "src": blackWolfPlushieSitting,
            "alt": "Sitting black wolf plushie"
        }
    ],
    "chestnut": [
        {
            "src": chestnutWolfPlushieStanding,
            "alt": "Standing chestnut wolf plushie"
        },
        {
            "src": chestnutWolfPlushieSitting,
            "alt": "Sitting chestnut wolf plushie"
        }
    ],
    "rusty": [
        {
            "src": rustyWolfPlushieStanding,
            "alt": "Standing rusty wolf plushie"
        },
        {
            "src": rustyWolfPlushieSitting,
            "alt": "Sitting rusty wolf plushie"
        }
    ]
}

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});