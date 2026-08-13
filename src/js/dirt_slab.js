// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

import dirtSlab from "../img/dirt_slab.webp";
import coarseDirtSlab from "../img/coarse_dirt_slab.webp";
import rootedDirtSlab from "../img/rooted_dirt_slab.webp";

import topDirtSlab from "../img/dirt_slab_top.webp";
import topCoarseDirtSlab from "../img/coarse_dirt_slab_top.webp";
import topRootedDirtSlab from "../img/rooted_dirt_slab_top.webp";

import dirtBlock from "../img/dirt.webp";
import coarseDirtBlock from "../img/coarse_dirt.webp";
import rootedDirtBlock from "../img/rooted_dirt.webp";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const craftingGui = document.getElementById('crafting-gui');

const craftingLists = {
    "dirt_slab": [dirtSlab, coarseDirtSlab, rootedDirtSlab],
    "dirt": [dirtBlock, coarseDirtBlock, rootedDirtBlock]
}
const optionList = {
    "normal": [
        {
            "src": dirtSlab,
            "alt": "Dirt Slab"
        },
        {
            "src": topDirtSlab,
            "alt": "Dirt Slab"
        },
        {
            "src": dirtBlock,
            "alt": "Dirt Slab"
        }
    ],
    "coarse": [
        {
            "src": coarseDirtSlab,
            "alt": "Coarse Dirt Slab"
        },
        {
            "src": topCoarseDirtSlab,
            "alt": "Coarse Dirt Slab"
        },
        {
            "src": coarseDirtBlock,
            "alt": "Coarse Dirt Slab"
        }
    ],
    "rooted": [
        {
            "src": rootedDirtSlab,
            "alt": "Rooted Dirt Slab"
        },
        {
            "src": topRootedDirtSlab,
            "alt": "Rooted Dirt Slab"
        },
        {
            "src": rootedDirtBlock,
            "alt": "Rooted Dirt Slab"
        }
    ]
}

if (craftingGui) createRecipeCycle(craftingLists, craftingGui);

if (container) {
    container.addEventListener('click', (event) => {
        createButtonPanel(event, optionList, container, headerImages);
    });
}