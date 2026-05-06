async function cycle_recipe(items, cycleItems, state) {
    state.step++; // Moves to the next index. When we hit the last index it will return to 0.

    for (let item of cycleItems) {
        const type = item.dataset.type;

        if (!items.has(type)) continue;

        const variants = items[type];
        const localIndex = state.step % variants.length;

        const newSrc = items.get(type)[localIndex];
        item.setAttribute("src", newSrc);
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
 * @param items {map[element[]]} List of item names to cycle through.
 * @param guiId {HTMLElement} The parent container of the recipe.
 */
export function createRecipeCycle(items, guiId) {
    let state = { step: 0 };
    const cycleItems = guiId.getElementsByClassName('cycle-item');
    const timeout = 2000;

    setInterval(function() {
        cycle_recipe(items, cycleItems, state).catch(error => {
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
 * @param headerImages The images to change. This is where each data-src-pattern and data-alt-pattern should be defined.
 */
export function createButtonPanel(event, containerId, headerImages) {
    const selectedElement = containerId.querySelector('.selected');
    const button = event.target.closest('.menu-btn');
    if (!button) return;

    const type = button.dataset.type;
    const typeName = type.replaceAll("_", " ");

    for (const headerImage of headerImages) {
        const srcPattern = headerImage.dataset.srcPattern;
        const altPattern = headerImage.dataset.altPattern;
        const newSrc = srcPattern.replaceAll("{type}", type);
        const newAlt = altPattern.replaceAll("{type}", typeName);

        headerImage.src = newSrc;
        headerImage.alt = newAlt;
    }

    if (selectedElement) {
        selectedElement.classList.remove('selected');
    }
    button.classList.add('selected');
}