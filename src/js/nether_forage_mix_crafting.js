import twistingVines from "../img/twisting_vines_plant.webp";
import warpedRoots from "../img/warped_roots.webp";

import weepingVines from "../img/weeping_vines_plant.webp";
import crimsonRoots from "../img/crimson_roots.webp";

// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle } from "./side_page";

const craftingLists = {
    "warped_vegetation": [twistingVines, warpedRoots],
    "crimson_vegetation": [weepingVines, crimsonRoots]
}

createRecipeCycle(craftingLists);