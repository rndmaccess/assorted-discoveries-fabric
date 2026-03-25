const VOWELS = new Set(['a', 'e', 'i', 'o', 'u']);

async function cycle_recipe(items, backImg, cycleItems, state) {
    state.typeIndex = (state.typeIndex + 1) % items.length; // Moves to the next index. When we hit the last index it will return to 0.
    const woodType = items[state.typeIndex]

    for (let itemIndex = 0; itemIndex < cycleItems.length; itemIndex++) {
        let item = cycleItems[itemIndex];
        const pattern = item.dataset.srcPattern;

        if (pattern && item.hasAttribute("src")) {
            const newSrc = pattern.replaceAll("{blockType}", woodType);
            item.setAttribute("src", newSrc);
        }
    }
    const woodTypeName = woodType.replaceAll("_", " ")
    const pattern = backImg.dataset.altPattern;

    if(pattern) {
        const firstLetter = woodType[0]
        const a = isVowel(firstLetter) ? "an" : "a"
        const newAlt = pattern.replaceAll("{blockType}", woodTypeName).replaceAll("{a}", a);
        backImg.setAttribute("alt", newAlt)
    }
}

function isVowel(char) {
    char = char.toLowerCase()
    return VOWELS.has(char)
}

/**
 * The back HTML class must be on the crafting background image. This is used to update the alt text.
 * The cycle-item HTML class must be on the items you would like to cycle!
 *
 * {a}: Dynamically fills in 'a' or 'an' based on whether the current {blockType} starts with a vowel.
 *
 * {blockType}: Can be used in the data-alt-pattern or data-src-pattern to insert the item name from the list of items passed.
 *
 * data-alt-pattern and data-src-pattern should define the pattern of the new src and alt the cycle method
 * to use for the image and alt text.
 *
 * Style classes:
 * crafting-area: Defines the crafting area's size and content flow around the crafting area.
 * front: Used for items these are positioned in front of the gui background element.
 * back: Styles the crafting area's background image.
 * slot: Centers the element in a crafting area slot.
 * crafting-item: Determines the size of the crafting item.
 * front-result and result-item: Works together to position the result item in the result slot.
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
 * @param items type list<string>: This should be the item names to cycle through.
 * @param guiId type string (ID): This should be the id for that recipe.
 * The id should be on the outermost parent element surrounding the recipe.
 */
function createRecipeCycle(items, guiId) {
    let state = { typeIndex: 0 };
    const backImg = guiId.getElementsByClassName("back")[0]
    const cycleItems = guiId.getElementsByClassName('cycle-item')

    setInterval(function() {
        cycle_recipe(items, backImg, cycleItems, state).catch(error => {
            console.log("An error occurred when cycling the recipe: ", error)
        })
    }, 1000);
}

/**
 * One button must start with id="selected". This ID is automatically moved to the newly clicked button.
 * Each button must be labeled with the menu-btn class to be considered.
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
 * {a}: Can be used in the data-alt-pattern to fill in 'a' or 'an' dynamically!
 *
 * {type}: Can be used in data-src-pattern or data-alt-pattern to dynamically insert a word!
 * Underscores used in the substitution will automatically be replaced by spaces in the alt text.
 *
 * @param event type PointerEvent: The event object from the click event!
 */
function createButtonPanel(event) {
    const selectedElement = document.getElementById('selected')
    const button = event.target.closest('.menu-btn');
    if (!button) return;

    const type = button.dataset.type;
    const typeName = type.replaceAll("_", " ")
    const firstLetter = type[0]
    const a = isVowel(firstLetter) ? "an" : "a"
    const srcPattern = button.dataset.srcPattern
    const altPattern = button.dataset.altPattern
    const newSrc = srcPattern.replaceAll("{type}", type)
    const newAlt = altPattern.replaceAll("{a}", a).replaceAll("{type}", typeName)

    mainImg.src = newSrc;
    mainImg.alt = newAlt;
    selectedElement.removeAttribute('id')
    button.setAttribute('id', 'selected')
}