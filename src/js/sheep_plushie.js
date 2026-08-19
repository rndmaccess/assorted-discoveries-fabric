// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

import whiteSheepPlushie from "../block_img/sheep_plushie_white.webp";
import lightGraySheepPlushie from "../block_img/sheep_plushie_light_gray.webp";
import graySheepPlushie from "../block_img/sheep_plushie_gray.webp";
import blackSheepPlushie from "../block_img/sheep_plushie_black.webp";
import brownSheepPlushie from "../block_img/sheep_plushie_brown.webp";
import redSheepPlushie from "../block_img/sheep_plushie_red.webp";
import orangeSheepPlushie from "../block_img/sheep_plushie_orange.webp";
import yellowSheepPlushie from "../block_img/sheep_plushie_yellow.webp";
import limeSheepPlushie from "../block_img/sheep_plushie_lime.webp";
import greenSheepPlushie from "../block_img/sheep_plushie_green.webp";
import cyanSheepPlushie from "../block_img/sheep_plushie_cyan.webp";
import lightBlueSheepPlushie from "../block_img/sheep_plushie_light_blue.webp";
import blueSheepPlushie from "../block_img/sheep_plushie_blue.webp";
import purpleSheepPlushie from "../block_img/sheep_plushie_purple.webp";
import magentaSheepPlushie from "../block_img/sheep_plushie_magenta.webp";
import pinkSheepPlushie from "../block_img/sheep_plushie_pink.webp";

import whiteWool from "../block_img/white_wool.webp";
import lightGrayWool from "../block_img/light_gray_wool.webp";
import grayWool from "../block_img/gray_wool.webp";
import blackWool from "../block_img/black_wool.webp";
import brownWool from "../block_img/brown_wool.webp";
import redWool from "../block_img/red_wool.webp";
import orangeWool from "../block_img/orange_wool.webp";
import yellowWool from "../block_img/yellow_wool.webp";
import limeWool from "../block_img/lime_wool.webp";
import greenWool from "../block_img/green_wool.webp";
import cyanWool from "../block_img/cyan_wool.webp";
import lightBlueWool from "../block_img/light_blue_wool.webp";
import blueWool from "../block_img/blue_wool.webp";
import purpleWool from "../block_img/purple_wool.webp";
import magentaWool from "../block_img/magenta_wool.webp";
import pinkWool from "../block_img/pink_wool.webp";

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