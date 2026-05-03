// No module declaration needed; esbuild-loader handles imports.
import { createRecipeCycle, createButtonPanel } from "./side_page";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const craftingGui = document.getElementById('crafting-gui');
const woodTypes = ["oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove",
    "cherry", "pale_oak", "bamboo", "warped", "crimson"];

if (craftingGui) createRecipeCycle(woodTypes, craftingGui);

if (container) {
    container.addEventListener('click', (event) => {
        createButtonPanel(event, container, headerImages);
    });
}