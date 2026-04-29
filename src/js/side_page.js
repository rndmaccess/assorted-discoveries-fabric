const VOWELS = new Set(['a', 'e', 'i', 'o', 'u']);

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
    const woodTypeName = woodType.replaceAll("_", " ");
    const pattern = backImg.dataset.altPattern;

    if(pattern) {
        const firstLetter = woodType[0];
        const a = isVowel(firstLetter) ? "an" : "a";
        const newAlt = pattern.replaceAll("{blockType}", woodTypeName).replaceAll("{a}", a);
        backImg.setAttribute("alt", newAlt);
    }
}

function isVowel(char) {
    char = char.toLowerCase();
    return VOWELS.has(char);
}

/**
 * Cycles item types within a crafting GUI.
 *
 * HTML Classes:
 * .back: Required on the background image for alt-text updates.
 * .cycle-item: Required on any element that should change per cycle.
 * .crafting-area: Sets dimensions and text-wrap.
 * .front / .back / .slot: Layout and positioning for grid items.
 * .crafting-item / .result-item: Sizing for specific icons.
 *
 * Dynamic Placeholders:
 * {blockType}: Injected from the 'items' list into data-alt-pattern or data-src-pattern.
 * {a}: Auto-resolves to 'a' or 'an' based on whether {blockType} starts with a vowel in data-alt-pattern.
 *
 * @example
 * HTML:
 * <div class="crafting-area" id="crafting-gui">
 *   <img class="back" src="./gui_images/crafting_table_display.png" data-alt-pattern="A Minecraft 3x3 crafting grid with seven {blockType} slabs arranged in a U-shape and one dirt block in the center, giving {a} {blockType} planter box, with planter box variations cycling." alt="A Minecraft 3x3 crafting grid with seven oak slabs arranged in a U-shape and one dirt block in the center, giving an oak planter box, with planter box variations cycling.">
 *   <div class="front">
 *     <div class="slot"><img class="crafting-item cycle-item" data-src-pattern="./image_renders/{blockType}_slab.png" src="image_renders/oak_slab.png" alt=""></div>
 *     <div class="slot"></div>
 *     <div class="slot"><img class="crafting-item cycle-item" data-src-pattern="./image_renders/{blockType}_slab.png" src="image_renders/oak_slab.png" alt=""></div>
 *
 *     <div class="slot"><img class="crafting-item cycle-item" data-src-pattern="./image_renders/{blockType}_slab.png" src="image_renders/oak_slab.png" alt=""></div>
 *     <div class="slot"><img class="crafting-item" src="image_renders/dirt.png" alt=""></div>
 *     <div class="slot"><img class="crafting-item cycle-item" data-src-pattern="./image_renders/{blockType}_slab.png" src="image_renders/oak_slab.png" alt=""></div>
 *
 *     <div class="slot"><img class="crafting-item cycle-item" data-src-pattern="./image_renders/{blockType}_slab.png" src="image_renders/oak_slab.png" alt=""></div>
 *     <div class="slot"><img class="crafting-item cycle-item" data-src-pattern="./image_renders/{blockType}_slab.png" src="image_renders/oak_slab.png" alt=""></div>
 *     <div class="slot"><img class="crafting-item cycle-item" data-src-pattern="./image_renders/{blockType}_slab.png" src="image_renders/oak_slab.png" alt=""></div>
 *   </div>
 *   <div class="front-result">
 *     <div><img class="result-item cycle-item" data-src-pattern="./image_renders/{blockType}_planter_box.png" src="./image_renders/oak_planter_box.png" alt=""></div>
 *   </div>
 * </div>
 *
 * JS:
 * const craftingGui = document.getElementById('crafting-gui')
 * const woodTypes = ["oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove",
 *         "cherry", "pale_oak", "bamboo"]
 * createRecipeCycle(woodTypes, craftingGui)
 *
 * @param items {string[]} List of item names to cycle through.
 * @param guiId {HTMLElement} The parent container of the recipe.
 */
export function createRecipeCycle(items, guiId) {
    let state = { typeIndex: 0 };
    const backImg = guiId.getElementsByClassName("back")[0];
    const cycleItems = guiId.getElementsByClassName('cycle-item');

    setInterval(function() {
        cycle_recipe(items, backImg, cycleItems, state).catch(error => {
            console.log("An error occurred when cycling the recipe: ", error);
        });
    }, 1000);
}

/**
 * Manages button selection and dynamic attribute updates.
 *
 * HTML Requirements:
 * .menu-btn: Required class for all selectable buttons.
 * #selected: Must be present on exactly one button initially; moves on click.
 *
 * Placeholders:
 * {type}: Injected from data-type into data-src-pattern or data-alt-pattern.
 *         (Note: Underscores in {type} are converted to spaces for alt text).
 * {a}: Dynamically resolves to 'a' or 'an' based on whether {type} starts with a vowel in data-alt-pattern.
 *
 * @example
 * HTML:
 * <div id="button-container">
 *     <button class="menu-btn" id="selected" data-type="oak" data-src-pattern="./image_renders/{type}_planter_box.png" data-alt-pattern="A picture of {a} {type} planter box">Oak</button>
 *     <button class="menu-btn" data-type="spruce" data-src-pattern="./image_renders/{type}_planter_box.png" data-alt-pattern="A picture of {a} {type} planter box">Spruce</button>
 * </div>
 *
 * JS:
 * const container = document.getElementById('button-container');
 * container.addEventListener('click', (event) => {
 *   createButtonPanel(event)
 * });
 *
 * @param event {PointerEvent} The click event from the button container.
 * @param containerId The container's id
 * @param mainImg The image to replace
 */
export function createButtonPanel(event, containerId, mainImg) {
    const selectedElement = containerId.querySelector('.selected');
    const button = event.target.closest('.menu-btn');
    if (!button) return;

    const type = button.dataset.type;
    const typeName = type.replaceAll("_", " ");
    const firstLetter = type[0];
    const a = isVowel(firstLetter) ? "an" : "a";
    const srcPattern = mainImg.dataset.srcPattern;
    const altPattern = mainImg.dataset.altPattern;
    const newSrc = srcPattern.replaceAll("{type}", type);
    const newAlt = altPattern.replaceAll("{a}", a).replaceAll("{type}", typeName);

    mainImg.src = newSrc;
    mainImg.alt = newAlt;

    if (selectedElement) {
        selectedElement.classList.remove('selected');
    }
    button.classList.add('selected');
}