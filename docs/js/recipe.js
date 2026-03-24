const vowels = new Set(['a', 'e', 'i', 'o', 'u']);

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
    return vowels.has(char)
}

function createRecipeCycle(items, guiId) {
    // The back class is used to define the gui image and the cycle-item class is used to choose which items should cycle!
    let state = { typeIndex: 0 };
    const backImg = guiId.getElementsByClassName("back")[0]
    const cycleItems = guiId.getElementsByClassName('cycle-item')

    setInterval(function() {
        cycle_recipe(items, backImg, cycleItems, state).catch(error => {
            console.log("An error occurred when cycling the recipe: ", error)
        })
    }, 1000);
}