async function cycle_recipe(items, backImg, cycleItems, state) {
    state.typeIndex = (state.typeIndex + 1) % items.length; // Moves to the next index. When we hit the last index it will return to 0.
    const woodType = items[state.typeIndex]

    for (let itemIndex = 0; itemIndex < cycleItems.length; itemIndex++) {
        let item = cycleItems[itemIndex];
        let blockType = item.dataset.type;

        if (item.hasAttribute("src")) {

            if (blockType === "slab") {
                item.setAttribute("src", "./image_renders/" + woodType + "_slab.png")
            } else if (blockType === "planter_box") {
                item.setAttribute("src", "./image_renders/" + woodType + "_planter_box.png")
            } else if (blockType === "soul_soil") {
                item.setAttribute("src", "./image_renders/" + woodType + ".png")
            }
        }
    }
    const woodTypeName = woodType.replaceAll("_", " ")

    const alt_text = `A Minecraft 3x3 crafting grid with seven ${woodTypeName} slabs arranged in a U-shape
        and one dirt block in the center, producing an ${woodTypeName} planter box, with planter box variations cycling.`

    backImg.setAttribute("alt", alt_text)
}

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