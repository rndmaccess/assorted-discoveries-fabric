function cycle_recipe(items, cycleItems, state) {
    state.step++; // Moves to the next index. When we hit the last index it will return to 0.

    for (let item of cycleItems) {
        const type = item.dataset.type;
        const variants = items[type];

        // Guard against missing types or empty variant arrays
        if (!variants || !variants.length) continue;

        const newSrc = variants[state.step % variants.length];
        if (item.src !== newSrc) {
            item.src = newSrc;
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
 * @param items {map[element[]]} List of item names to cycle through.
 */
export function createRecipeCycle(items) {
    const craftingId = document.getElementById('crafting-anim');

    if (!craftingId) {
        console.error("Could not find the crafting-anim id on any element!");
        return;
    }

    let state = { step: 0 };
    const cycleItems = Array.from(craftingId.getElementsByClassName('cycle-item'));
    const timeout = 2000;

    setInterval(() => {
        try {
            cycle_recipe(items, cycleItems, state);
        } catch (error) {
            console.log("An error occurred when cycling the recipe: ", error);
        }
    }, timeout);
}

/**
 * Manages button selection and dynamic attribute updates.
 *
 * HTML Requirements:
 * .menu-btn: Required class for all selectable buttons.
 * .swappable-img: Required class for all swappable images.
 * #selected: Must be present on exactly one button initially; moves on click.
 * data-type: Use this to specify what type the images are that should be swapped in. This is
 *
 * @param event {PointerEvent} The click event from the button container.
 * @param optionList A JSON-like object that maps the data-types to a
 * list of src and alt attributes that are then later looked up.
 */
export function createButtonPanel(event, optionList) {
    const button = event.target.closest('.menu-btn');
    if (!button) return;

    const imagePanel = event.currentTarget;
    const selectedElement = imagePanel.querySelector('.selected');

    if (!button) return;

    const type = button.dataset.type;
    if (!type) {
        console.log("No type for button: ", button);
        return;
    }

    const variants = optionList[type];
    if (!variants || variants.length === 0) {
        console.log("No images for button: ", button);
        return;
    }

    const swappableImages = imagePanel.getElementsByClassName('swappable-img');

    for (let i = 0; i < swappableImages.length; i++) {
        const headerImage = swappableImages[i];

        if (!variants[i] || i >= variants.length) {
            console.log("Missing image for index: ", i);
            continue;
        }

        headerImage.src = variants[i].src;
        headerImage.alt = variants[i].alt;
    }

    if (selectedElement) {
        selectedElement.classList.remove('selected');
    }
    button.classList.add('selected');
}