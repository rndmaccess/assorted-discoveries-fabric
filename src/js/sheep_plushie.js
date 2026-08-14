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
import lightGrayWool from "../img/light_gray_wool.webp";
import grayWool from "../img/gray_wool.webp";
import blackWool from "../img/black_wool.webp";
import brownWool from "../img/brown_wool.webp";
import redWool from "../img/red_wool.webp";
import orangeWool from "../img/orange_wool.webp";
import yellowWool from "../img/yellow_wool.webp";
import limeWool from "../img/lime_wool.webp";
import greenWool from "../img/green_wool.webp";
import cyanWool from "../img/cyan_wool.webp";
import lightBlueWool from "../img/light_blue_wool.webp";
import blueWool from "../img/blue_wool.webp";
import purpleWool from "../img/purple_wool.webp";
import magentaWool from "../img/magenta_wool.webp";
import pinkWool from "../img/pink_wool.webp";

const craftingLists = {
    "sheep_plushie": [whiteSheepPlushie, lightGraySheepPlushie, graySheepPlushie, blackSheepPlushie, brownSheepPlushie,
        redSheepPlushie, orangeSheepPlushie, yellowSheepPlushie, limeSheepPlushie, greenSheepPlushie, cyanSheepPlushie,
        lightBlueSheepPlushie, blueSheepPlushie, purpleSheepPlushie, magentaSheepPlushie, pinkSheepPlushie
    ],
    "wool": [whiteWool, lightGrayWool, grayWool, blackWool, brownWool, redWool, orangeWool, yellowWool, limeWool,
        greenWool, cyanWool, lightBlueWool, blueWool, purpleWool, magentaWool, pinkWool
    ],
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

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');

createRecipeCycle(craftingLists);

if (container) {
    container.addEventListener('click', (event) => {
        createButtonPanel(event, optionList, container, headerImages);
    });
}