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
            "alt": "Pale wolf plushie"
        },
        {
            "src": paleWolfPlushieSitting,
            "alt": "Pale wolf plushie"
        }
    ],
    "ashen": [
        {
            "src": ashenWolfPlushieStanding,
            "alt": "Ashen wolf plushie"
        },
        {
            "src": ashenWolfPlushieSitting,
            "alt": "Ashen wolf plushie"
        }
    ],
    "black": [
        {
            "src": blackWolfPlushieStanding,
            "alt": "Black wolf plushie"
        },
        {
            "src": blackWolfPlushieSitting,
            "alt": "Black wolf plushie"
        }
    ],
    "chestnut": [
        {
            "src": chestnutWolfPlushieStanding,
            "alt": "Chestnut wolf plushie"
        },
        {
            "src": chestnutWolfPlushieSitting,
            "alt": "Chestnut wolf plushie"
        }
    ],
    "rusty": [
        {
            "src": rustyWolfPlushieStanding,
            "alt": "Rusty wolf plushie"
        },
        {
            "src": rustyWolfPlushieSitting,
            "alt": "Rusty wolf plushie"
        }
    ]
}

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});