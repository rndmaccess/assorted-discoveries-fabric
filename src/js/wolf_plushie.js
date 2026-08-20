import paleWolfPlushieStanding from "../block_img/pale_wolf_plushie_standing.webp";
import paleWolfPlushieSitting from "../block_img/pale_wolf_plushie_sitting.webp";
import ashenWolfPlushieStanding from "../block_img/ashen_wolf_plushie_standing.webp";
import ashenWolfPlushieSitting from "../block_img/ashen_wolf_plushie_sitting.webp";
import blackWolfPlushieStanding from "../block_img/black_wolf_plushie_standing.webp";
import blackWolfPlushieSitting from "../block_img/black_wolf_plushie_sitting.webp";
import chestnutWolfPlushieStanding from "../block_img/chestnut_wolf_plushie_standing.webp";
import chestnutWolfPlushieSitting from "../block_img/chestnut_wolf_plushie_sitting.webp";
import rustyWolfPlushieStanding from "../block_img/rusty_wolf_plushie_standing.webp";
import rustyWolfPlushieSitting from "../block_img/rusty_wolf_plushie_sitting.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./page_util";

const optionList = {
    "pale": [
        {
            "src": paleWolfPlushieStanding,
            "alt": "A white wolf plushie with black eyes, and black ear tuffs."
        },
        {
            "src": paleWolfPlushieSitting,
            "alt": "A white wolf plushie with black eyes, and black ear tuffs."
        }
    ],
    "ashen": [
        {
            "src": ashenWolfPlushieStanding,
            "alt": "A wolf plushie with dark purplish-gray top fur, matching ear tuffs, a white belly, and black eyes."
        },
        {
            "src": ashenWolfPlushieSitting,
            "alt": "A wolf plushie with dark purplish-gray top fur, matching ear tuffs, a white belly, and black eyes."
        }
    ],
    "black": [
        {
            "src": blackWolfPlushieStanding,
            "alt": "A black wolf plushie with gray eyes."
        },
        {
            "src": blackWolfPlushieSitting,
            "alt": "A black wolf plushie with gray eyes."
        }
    ],
    "chestnut": [
        {
            "src": chestnutWolfPlushieStanding,
            "alt": "A light brown wolf plushie with dark brown feet, snout, and ear tuffs, along with black eyes."
        },
        {
            "src": chestnutWolfPlushieSitting,
            "alt": "A light brown wolf plushie with dark brown feet, snout, and ear tuffs, along with black eyes."
        }
    ],
    "rusty": [
        {
            "src": rustyWolfPlushieStanding,
            "alt": "A brownish-red wolf plushie with white feet, and matching ear tuffs, along with black eyes."
        },
        {
            "src": rustyWolfPlushieSitting,
            "alt": "A brownish-red wolf plushie with white feet, and matching ear tuffs, along with black eyes."
        }
    ]
}

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}