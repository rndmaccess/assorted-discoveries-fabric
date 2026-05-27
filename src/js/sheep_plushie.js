// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

import whiteSheepPlushie from "../img/sheep_plushie_white.webp";
import lightGraySheepPlushie from "../img/sheep_plushie_light_gray.webp";
import graySheepPlushie from "../img/sheep_plushie_gray.webp";
import blackSheepPlushie from "../img/sheep_plushie_black.webp";
import brownSheepPlushie from "../img/sheep_plushie_brown.webp";
import redSheepPlushie from "../img/sheep_plushie_red.webp";
import orangeSheepPlushie from "../img/sheep_plushie_orange.webp";
import yellowSheepPlushie from "../img/sheep_plushie_yellow.webp";
import limeSheepPlushie from "../img/sheep_plushie_lime.webp";
import greenSheepPlushie from "../img/sheep_plushie_green.webp";
import cyanSheepPlushie from "../img/sheep_plushie_cyan.webp";
import lightBlueSheepPlushie from "../img/sheep_plushie_light_blue.webp";
import blueSheepPlushie from "../img/sheep_plushie_blue.webp";
import purpleSheepPlushie from "../img/sheep_plushie_purple.webp";
import magentaSheepPlushie from "../img/sheep_plushie_magenta.webp";
import pinkSheepPlushie from "../img/sheep_plushie_pink.webp";

import whiteWool from "../img/white_wool.webp";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const craftingGui = document.getElementById('crafting-gui');

const craftingLists = {
    "sheep_plushie": [whiteSheepPlushie],
    "wool": [whiteWool]
}
const optionList = {
    "white": [
        {
            "src": whiteSheepPlushie,
            "alt": "White sheep plushie sitting",
        }
    ],
    "light_gray": [
        {
            "src": lightGraySheepPlushie,
            "alt": "Light gray sheep plushie sitting",
        }
    ],
    "gray": [
        {
            "src": graySheepPlushie,
            "alt": "Gray sheep plushie sitting",
        }
    ],
    "black": [
        {
            "src": blackSheepPlushie,
            "alt": "Black sheep plushie sitting",
        }
    ],
    "brown": [
        {
            "src": brownSheepPlushie,
            "alt": "Brown sheep plushie sitting",
        }
    ],
    "red": [
        {
            "src": redSheepPlushie,
            "alt": "Red sheep plushie sitting",
        }
    ],
    "orange": [
        {
            "src": orangeSheepPlushie,
            "alt": "Orange sheep plushie sitting",
        }
    ],
    "yellow": [
        {
            "src": yellowSheepPlushie,
            "alt": "Yellow sheep plushie sitting",
        }
    ],
    "lime": [
        {
            "src": limeSheepPlushie,
            "alt": "Lime sheep plushie sitting",
        }
    ],
    "green": [
        {
            "src": greenSheepPlushie,
            "alt": "Green sheep plushie sitting",
        }
    ],
    "cyan": [
        {
            "src": cyanSheepPlushie,
            "alt": "Cyan sheep plushie sitting",
        }
    ],
    "light_blue": [
        {
            "src": lightBlueSheepPlushie,
            "alt": "Light blue sheep plushie sitting",
        }
    ],
    "blue": [
        {
            "src": blueSheepPlushie,
            "alt": "Blue sheep plushie sitting",
        }
    ],
    "purple": [
        {
            "src": purpleSheepPlushie,
            "alt": "Purple sheep plushie sitting",
        }
    ],
    "magenta": [
        {
            "src": magentaSheepPlushie,
            "alt": "Magenta sheep plushie sitting",
        }
    ],
    "pink": [
        {
            "src": pinkSheepPlushie,
            "alt": "Pink sheep plushie sitting",
        }
    ]
}

if (craftingGui) createRecipeCycle(craftingLists, craftingGui);

if (container) {
    container.addEventListener('click', (event) => {
        createButtonPanel(event, optionList, container, headerImages);
    });
}