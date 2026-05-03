// No module declaration needed; esbuild-loader handles imports.
import { createButtonPanel } from "./side_page";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');

container.addEventListener('click', (event) => {
    createButtonPanel(event, container, headerImages);
});