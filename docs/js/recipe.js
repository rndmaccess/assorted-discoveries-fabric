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
 * @param {list} items: This should be the item names to cycle through.
 * @param {Element} guiId: This should be the id for that recipe.
 *                         The id should be on the outermost parent element surrounding the recipe.
 *
 * The back html class must be on the crafting background image. This is used to update the alt text.
 * The cycle-item html class must be on the items you would like to cycle!
 * {a}: Can be used in a data-alt-pattern or data-src-pattern to insert a or an into the string.
 * {blockType}: Can be used in a data-alt-pattern or data-src-pattern to insert the item name from the list of items passed.
 *
 * data-alt-pattern and data-src-pattern should define the pattern of the new src and alt the cycle method
 * to use for the image and alt text.
 *
 * ex:
 * data-alt-pattern="A Minecraft 3x3 crafting grid with seven {blockType} slabs arranged in a U-shape and one dirt block in the center, giving {a} {blockType} planter box, with planter box variations cycling."
 * on the recipe gui image,
 * data-src-pattern="./image_renders/{blockType}_slab.png"
 * on a gui item. This pattern defines a slab of {blockType} from the image_renders folder.
 *
 * Here is a full example of a cycling recipe:
 * <div class="crafting-area" id="crafting-gui">
 *     <img class="back" src="./gui_images/crafting_table_display.png" data-alt-pattern="A Minecraft 3x3 crafting grid with three {blockType} planks lined up in the center three slots and four string in the four corners of the crafting grid, giving {a} {blockType} rope ladder, with rope ladder variations cycling." alt="A Minecraft 3x3 crafting grid with three oak planks lined up in the center three slots and four string in the four corner slots of the crafting grid, giving an oak rope ladder, with rope ladder variations cycling.">
 *     <div class="front">
 *         <div class="slot"><img class="crafting-item" loading="lazy" src="image_renders/string.png" alt=""></div>
 *         <div class="slot"></div>
 *         <div class="slot"><img class="crafting-item" loading="lazy" src="image_renders/string.png" alt=""></div>
 *
 *         <div class="slot"><img class="crafting-item cycle-item" loading="lazy" data-src-pattern="./image_renders/{blockType}_planks.png" src="image_renders/oak_planks.png" alt=""></div>
 *         <div class="slot"><img class="crafting-item cycle-item" loading="lazy" data-src-pattern="./image_renders/{blockType}_planks.png" src="image_renders/oak_planks.png" alt=""></div>
 *         <div class="slot"><img class="crafting-item cycle-item" loading="lazy" data-src-pattern="./image_renders/{blockType}_planks.png" src="image_renders/oak_planks.png" alt=""></div>
 *
 *         <div class="slot"><img class="crafting-item" loading="lazy" src="image_renders/string.png" alt=""></div>
 *         <div class="slot"><div class="crafting-item"></div></div>
 *         <div class="slot"><img class="crafting-item" loading="lazy" src="image_renders/string.png" alt=""></div>
 *     </div>
 *     <div class="front-result">
 *         <div><img class="result-item cycle-item" loading="lazy" data-src-pattern="./image_renders/{blockType}_rope_ladder.png" src="./image_renders/oak_rope_ladder.png" alt=""></div>
 *     </div>
 * </div>
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