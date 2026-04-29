async function cycle_recipe(items, backImg, cycleItems, state) {
    state.typeIndex = (state.typeIndex + 1) % items.length; // Moves to the next index. When we hit the last index it will return to 0.
    const woodType = items[state.typeIndex];

    for (let itemIndex = 0; itemIndex < cycleItems.length; itemIndex++) {
        let item = cycleItems[itemIndex];
        const pattern = item.dataset.srcPattern;

        if (pattern && item.hasAttribute("src")) {
            const newSrc = pattern.replaceAll("{blockType}", woodType);
            item.setAttribute("src", newSrc);
        }
    }
}

/**
 * Cycles item types within a crafting GUI.
 *
 * HTML Classes:
 * .cycle-item: Required on any element that should change per cycle.
 * .crafting-area: Sets dimensions and text-wrap.
 * .front / .back / .slot: Layout and positioning for grid items.
 * .crafting-item / .result-item: Sizing for specific icons.
 *
 * Dynamic Placeholders:
 * {blockType}: Injected from the 'items' list into data-src-pattern.
 *
 * @param items {string[]} List of item names to cycle through.
 * @param guiId {HTMLElement} The parent container of the recipe.
 */
export function createRecipeCycle(items, guiId) {
    let state = { typeIndex: 0 };
    const backImg = guiId.getElementsByClassName("back")[0];
    const cycleItems = guiId.getElementsByClassName('cycle-item');
    const timeout = 2000

    setInterval(function() {
        cycle_recipe(items, backImg, cycleItems, state).catch(error => {
            console.log("An error occurred when cycling the recipe: ", error);
        });
    }, timeout);
}

/**
 * Manages button selection and dynamic attribute updates.
 *
 * HTML Requirements:
 * .menu-btn: Required class for all selectable buttons.
 * #selected: Must be present on exactly one button initially; moves on click.
 *
 * Placeholders:
 * {type}: Injected from data-type into data-src-pattern or data-alt-pattern in @param mainImg.
 *         (Note: Underscores in {type} are converted to spaces for alt text).
 *
 * @param event {PointerEvent} The click event from the button container.
 * @param containerId The container's id surrounding the button panel.
 * @param mainImg The image to change. This is where data-src-pattern and data-alt-pattern should be defined.
 */
export function createButtonPanel(event, containerId, mainImg) {
    const selectedElement = containerId.querySelector('.selected');
    const button = event.target.closest('.menu-btn');
    if (!button) return;

    const type = button.dataset.type;
    const typeName = type.replaceAll("_", " ");
    const srcPattern = mainImg.dataset.srcPattern;
    const altPattern = mainImg.dataset.altPattern;
    const newSrc = srcPattern.replaceAll("{type}", type);
    const newAlt = altPattern.replaceAll("{type}", typeName);

    mainImg.src = newSrc;
    mainImg.alt = newAlt;

    if (selectedElement) {
        selectedElement.classList.remove('selected');
    }
    button.classList.add('selected');
}