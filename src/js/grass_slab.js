// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

import grassSlab from "../img/grass_slab.webp";
import podzolSlab from "../img/podzol_slab.webp";
import myceliumSlab from "../img/mycelium_slab.webp";

import topGrassSlab from "../img/grass_slab_top.webp";
import topPodzolSlab from "../img/podzol_slab_top.webp";
import topMyceliumSlab from "../img/mycelium_slab_top.webp";

import grassBlock from "../img/grass_block.webp";
import podzolBlock from "../img/podzol.webp";
import myceliumBlock from "../img/mycelium.webp";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const craftingGui = document.getElementById('crafting-gui');

const craftingLists = {
    "grass_slab": [grassSlab, podzolSlab, myceliumSlab],
    "grass": [grassBlock, podzolBlock, myceliumBlock]
}
const optionList = {
    "normal": [
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

if (craftingGui) createRecipeCycle(craftingLists, craftingGui);

if (container) {
    container.addEventListener('click', (event) => {
        createButtonPanel(event, optionList, container, headerImages);
    });
}