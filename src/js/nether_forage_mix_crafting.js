import twistingVines from "../item_img/twisting_vines_plant.webp";
import warpedRoots from "../item_img/warped_roots.webp";

import weepingVines from "../item_img/weeping_vines_plant.webp";
import crimsonRoots from "../item_img/crimson_roots.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle } from "./page_util";

const craftingLists = {
    "warped_vegetation": [twistingVines, warpedRoots],
    "crimson_vegetation": [weepingVines, crimsonRoots]
}

createRecipeCycle(craftingLists);