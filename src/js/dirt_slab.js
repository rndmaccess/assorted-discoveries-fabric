// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./page_util";

import dirtSlab from "../block_img/dirt_slab.webp";
import coarseDirtSlab from "../block_img/coarse_dirt_slab.webp";
import rootedDirtSlab from "../block_img/rooted_dirt_slab.webp";

import topDirtSlab from "../block_img/dirt_slab_top.webp";
import topCoarseDirtSlab from "../block_img/coarse_dirt_slab_top.webp";
import topRootedDirtSlab from "../block_img/rooted_dirt_slab_top.webp";

import dirtBlock from "../block_img/dirt.webp";
import coarseDirtBlock from "../block_img/coarse_dirt.webp";
import rootedDirtBlock from "../block_img/rooted_dirt.webp";

const craftingLists = {
    "dirt_slab": [dirtSlab, coarseDirtSlab, rootedDirtSlab],
    "dirt": [dirtBlock, coarseDirtBlock, rootedDirtBlock]
}
const optionList = {
    "dirt": [
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

createRecipeCycle(craftingLists);

const imagePanel = document.getElementById('image-changer-panel');

if (imagePanel) {
    imagePanel.addEventListener('click', (event) => {
        createButtonPanel(event, optionList);
    });
}