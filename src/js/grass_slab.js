// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./page_util";

import grassSlab from "../block_img/grass_slab.webp";
import podzolSlab from "../block_img/podzol_slab.webp";
import myceliumSlab from "../block_img/mycelium_slab.webp";

import topGrassSlab from "../block_img/grass_slab_top.webp";
import topPodzolSlab from "../block_img/podzol_slab_top.webp";
import topMyceliumSlab from "../block_img/mycelium_slab_top.webp";

import grassBlock from "../block_img/grass_block.webp";
import podzolBlock from "../block_img/podzol.webp";
import myceliumBlock from "../block_img/mycelium.webp";

const optionList = {
    "grass": [
        {
            "src": grassSlab,
            "alt": "Grass Slab"
        },
        {
            "src": topGrassSlab,
            "alt": "Grass Slab"
        },
        {
            "src": grassBlock,
            "alt": "Grass Slab"
        }
    ],
    "podzol": [
        {
            "src": podzolSlab,
            "alt": "Podzol Slab"
        },
        {
            "src": topPodzolSlab,
            "alt": "Podzol Slab"
        },
        {
            "src": podzolBlock,
            "alt": "Podzol Slab"
        }
    ],
    "mycelium": [
        {
            "src": myceliumSlab,
            "alt": "Mycelium Slab"
        },
        {
            "src": topMyceliumSlab,
            "alt": "Mycelium Slab"
        },
        {
            "src": myceliumBlock,
            "alt": "Mycelium Slab"
        }
    ]
}

const craftingLists = {
    "grass_slab": [grassSlab, podzolSlab, myceliumSlab],
    "grass": [grassBlock, podzolBlock, myceliumBlock]
}

createRecipeCycle(craftingLists);

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}