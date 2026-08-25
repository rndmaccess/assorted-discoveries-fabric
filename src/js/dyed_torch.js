// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./page_util";

import whiteTorch from "../anim_block_img/white_torch.webp";
import lightGrayTorch from "../anim_block_img/light_gray_torch.webp";
import grayTorch from "../anim_block_img/gray_torch.webp";
import blackTorch from "../anim_block_img/black_torch.webp";
import brownTorch from "../anim_block_img/brown_torch.webp";
import redTorch from "../anim_block_img/red_torch.webp";
import orangeTorch from "../anim_block_img/orange_torch.webp";
import yellowTorch from "../anim_block_img/yellow_torch.webp";
import limeTorch from "../anim_block_img/lime_torch.webp";
import greenTorch from "../anim_block_img/green_torch.webp";
import cyanTorch from "../anim_block_img/cyan_torch.webp";
import lightBlueTorch from "../anim_block_img/light_blue_torch.webp";
import blueTorch from "../anim_block_img/blue_torch.webp";
import purpleTorch from "../anim_block_img/purple_torch.webp";
import magentaTorch from "../anim_block_img/magenta_torch.webp";
import pinkTorch from "../anim_block_img/pink_torch.webp";

import whiteTorchItem from "../item_img/white_torch.webp";
import lightGrayTorchItem from "../item_img/light_gray_torch.webp";
import grayTorchItem from "../item_img/gray_torch.webp";
import blackTorchItem from "../item_img/black_torch.webp";
import brownTorchItem from "../item_img/brown_torch.webp";
import redTorchItem from "../item_img/red_torch.webp";
import orangeTorchItem from "../item_img/orange_torch.webp";
import yellowTorchItem from "../item_img/yellow_torch.webp";
import limeTorchItem from "../item_img/lime_torch.webp";
import greenTorchItem from "../item_img/green_torch.webp";
import cyanTorchItem from "../item_img/cyan_torch.webp";
import lightBlueTorchItem from "../item_img/light_blue_torch.webp";
import blueTorchItem from "../item_img/blue_torch.webp";
import purpleTorchItem from "../item_img/purple_torch.webp";
import magentaTorchItem from "../item_img/magenta_torch.webp";
import pinkTorchItem from "../item_img/pink_torch.webp";

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
    "dyed_torch": [whiteTorchItem, lightGrayTorchItem, grayTorchItem, blackTorchItem, brownTorchItem,
        redTorchItem, orangeTorchItem, yellowTorchItem, limeTorchItem, greenTorchItem,
    cyanTorchItem, lightBlueTorchItem, blueTorchItem, purpleTorchItem,
    magentaTorchItem, pinkTorchItem],
    "dye": [whiteDye, lightGrayDye, grayDye, blackDye, brownDye, redDye, orangeDye, yellowDye, limeDye, greenDye,
        cyanDye, lightBlueDye, blueDye, purpleDye, magentaDye, pinkDye],
}
const optionList = {
    "white": [
        {
            "src": whiteTorch,
            "alt": "White Torch",
        }
    ],
    "light_gray": [
        {
            "src": lightGrayTorch,
            "alt": "Light Gray Torch",
        }
    ],
    "gray": [
        {
            "src": grayTorch,
            "alt": "Gray Torch",
        }
    ],
    "black": [
        {
            "src": blackTorch,
            "alt": "Black Torch",
        }
    ],
    "brown": [
        {
            "src": brownTorch,
            "alt": "Brown Torch",
        }
    ],
    "red": [
        {
            "src": redTorch,
            "alt": "Red Torch",
        }
    ],
    "orange": [
        {
            "src": orangeTorch,
            "alt": "Orange Torch",
        }
    ],
    "yellow": [
        {
            "src": yellowTorch,
            "alt": "Yellow Torch",
        }
    ],
    "lime": [
        {
            "src": limeTorch,
            "alt": "Lime Torch",
        }
    ],
    "green": [
        {
            "src": greenTorch,
            "alt": "Green Torch",
        }
    ],
    "cyan": [
        {
            "src": cyanTorch,
            "alt": "Cyan Torch",
        }
    ],
    "light_blue": [
        {
            "src": lightBlueTorch,
            "alt": "Light Blue Torch",
        }
    ],
    "blue": [
        {
            "src": blueTorch,
            "alt": "Blue Torch",
        }
    ],
    "purple": [
        {
            "src": purpleTorch,
            "alt": "Purple Torch",
        }
    ],
    "magenta": [
        {
            "src": magentaTorch,
            "alt": "Magenta Torch",
        }
    ],
    "pink": [
        {
            "src": pinkTorch,
            "alt": "Pink Torch",
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