import { createRecipeCycle, createButtonPanel } from "./side_page";

const container = document.getElementById('button-container');
const craftingGui = document.getElementById('crafting-gui');
const woodTypes = ["oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove",
    "cherry", "pale_oak", "bamboo", "warped", "crimson"];

if (craftingGui) createRecipeCycle(woodTypes, craftingGui);

container.addEventListener('click', (event) => {
    createButtonPanel(event);
});