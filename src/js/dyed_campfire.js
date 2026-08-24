// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./page_util";

import whiteCampfire from "../anim_block_img/white_campfire.webp";
import lightGrayCampfire from "../anim_block_img/light_gray_campfire.webp";
import grayCampfire from "../anim_block_img/gray_campfire.webp";
import blackCampfire from "../anim_block_img/black_campfire.webp";
import brownCampfire from "../anim_block_img/brown_campfire.webp";
import redCampfire from "../anim_block_img/red_campfire.webp";
import orangeCampfire from "../anim_block_img/orange_campfire.webp";
import yellowCampfire from "../anim_block_img/yellow_campfire.webp";
import limeCampfire from "../anim_block_img/lime_campfire.webp";
import greenCampfire from "../anim_block_img/green_campfire.webp";
import cyanCampfire from "../anim_block_img/cyan_campfire.webp";
import lightBlueCampfire from "../anim_block_img/light_blue_campfire.webp";
import blueCampfire from "../anim_block_img/blue_campfire.webp";
import purpleCampfire from "../anim_block_img/purple_campfire.webp";
import magentaCampfire from "../anim_block_img/magenta_campfire.webp";
import pinkCampfire from "../anim_block_img/pink_campfire.webp";
import unlitCampfire from "../block_img/unlit_campfire.webp";

import whiteCampfireItem from "../item_img/white_campfire.webp";
import lightGrayCampfireItem from "../item_img/light_gray_campfire.webp";
import grayCampfireItem from "../item_img/gray_campfire.webp";
import blackCampfireItem from "../item_img/black_campfire.webp";
import brownCampfireItem from "../item_img/brown_campfire.webp";
import redCampfireItem from "../item_img/red_campfire.webp";
import orangeCampfireItem from "../item_img/orange_campfire.webp";
import yellowCampfireItem from "../item_img/yellow_campfire.webp";
import limeCampfireItem from "../item_img/lime_campfire.webp";
import greenCampfireItem from "../item_img/green_campfire.webp";
import cyanCampfireItem from "../item_img/cyan_campfire.webp";
import lightBlueCampfireItem from "../item_img/light_blue_campfire.webp";
import blueCampfireItem from "../item_img/blue_campfire.webp";
import purpleCampfireItem from "../item_img/purple_campfire.webp";
import magentaCampfireItem from "../item_img/magenta_campfire.webp";
import pinkCampfireItem from "../item_img/pink_campfire.webp";

import whiteDye from "../item_img/white_dye.webp";
import lightGrayDye from "../item_img/light_gray_dye.webp";
import grayDye from "../item_img/gray_dye.webp";
import blackDye from "../item_img/black_dye.webp";
import brownDye from "../item_img/brown_dye.webp";
import redDye from "../item_img/red_dye.webp";
import orangeDye from "../item_img/orange_dye.webp";
import yellowDye from "../item_img/yellow_dye.webp";
import limeDye from "../item_img/lime_dye.webp";
import greenDye from "../item_img/green_dye.webp";
import cyanDye from "../item_img/cyan_dye.webp";
import lightBlueDye from "../item_img/light_blue_dye.webp";
import blueDye from "../item_img/blue_dye.webp";
import purpleDye from "../item_img/purple_dye.webp";
import magentaDye from "../item_img/magenta_dye.webp";
import pinkDye from "../item_img/pink_dye.webp";

const craftingLists = {
    "dyed_campfire": [whiteCampfireItem, lightGrayCampfireItem, grayCampfireItem, blackCampfireItem, brownCampfireItem,
        redCampfireItem, orangeCampfireItem, yellowCampfireItem, limeCampfireItem, greenCampfireItem,
    cyanCampfireItem, lightBlueCampfireItem, blueCampfireItem, purpleCampfireItem,
    magentaCampfireItem, pinkCampfireItem],
    "dye": [whiteDye, lightGrayDye, grayDye, blackDye, brownDye, redDye, orangeDye, yellowDye, limeDye, greenDye,
        cyanDye, lightBlueDye, blueDye, purpleDye, magentaDye, pinkDye],
}
const optionList = {
    "white": [
        {
            "src": whiteCampfire,
            "alt": "White Campfire",
        }
    ],
    "light_gray": [
        {
            "src": lightGrayCampfire,
            "alt": "Light Gray Campfire",
        }
    ],
    "gray": [
        {
            "src": grayCampfire,
            "alt": "Gray Campfire",
        }
    ],
    "black": [
        {
            "src": blackCampfire,
            "alt": "Black Campfire",
        }
    ],
    "brown": [
        {
            "src": brownCampfire,
            "alt": "Brown Campfire",
        }
    ],
    "red": [
        {
            "src": redCampfire,
            "alt": "Red Campfire",
        }
    ],
    "orange": [
        {
            "src": orangeCampfire,
            "alt": "Orange Campfire",
        }
    ],
    "yellow": [
        {
            "src": yellowCampfire,
            "alt": "Yellow Campfire",
        }
    ],
    "lime": [
        {
            "src": limeCampfire,
            "alt": "Lime Campfire",
        }
    ],
    "green": [
        {
            "src": greenCampfire,
            "alt": "Green Campfire",
        }
    ],
    "cyan": [
        {
            "src": cyanCampfire,
            "alt": "Cyan Campfire",
        }
    ],
    "light_blue": [
        {
            "src": lightBlueCampfire,
            "alt": "Light Blue Campfire",
        }
    ],
    "blue": [
        {
            "src": blueCampfire,
            "alt": "Blue Campfire",
        }
    ],
    "purple": [
        {
            "src": purpleCampfire,
            "alt": "Purple Campfire",
        }
    ],
    "magenta": [
        {
            "src": magentaCampfire,
            "alt": "Magenta Campfire",
        }
    ],
    "pink": [
        {
            "src": pinkCampfire,
            "alt": "Pink Campfire",
        }
    ],
    "unlit": [
        {
            "src": unlitCampfire,
            "alt": "Unlit Dyed Campfire",
        }
    ],
}

createRecipeCycle(craftingLists);

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}