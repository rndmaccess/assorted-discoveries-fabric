import { createRecipeCycle, createButtonPanel } from "./side_page";

const container = document.getElementById('button-container');
const overworldCraftingGui = document.getElementById('overworld-crafting-gui');
const warpedCraftingGui = document.getElementById('warped-crafting-gui');
const crimsonCraftingGui = document.getElementById('crimson-crafting-gui');
const woodTypes = ["oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove",
    "cherry", "pale_oak", "bamboo"];
const soilTypes = ["soul_soil", "soul_sand"];

if (overworldCraftingGui) createRecipeCycle(woodTypes, overworldCraftingGui);
if (warpedCraftingGui) createRecipeCycle(soilTypes, warpedCraftingGui);
if (crimsonCraftingGui) createRecipeCycle(soilTypes, crimsonCraftingGui);

if (container) {
    container.addEventListener('click', (event) => {
        createButtonPanel(event);
    });
}