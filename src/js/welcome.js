let miniSearch = new MiniSearch({
    fields: ['title'],
    storeFields: ['title']
})

const documents = [
    {
        id: 1,
        title: 'bog_blossom'
    },
    {
        id: 2,
        title: 'planter box'
    }
]

miniSearch.addAll(documents)

const searchInput = document.getElementById('search')
const suggestionsList = document.getElementById('suggestion-list')

const getSuggestions = (query) => {

    return miniSearch.autoSuggest(query, {
        prefix: true, // partial word matching
        fuzzy: 0.2    // allow minor misspellings
    }).slice(0, 5)
}

const renderSuggestions = (suggestions) => {
    suggestionsList.innerHTML = suggestions.map(({ suggestion }) => {
        return `<li class="suggestion">${suggestion}</li>`
    }).join('\n')
    suggestionsList.style.display = 'block'
}

// Typing into search bar updates search results and suggestions
searchInput.addEventListener('input', () => {
    const query = searchInput.value

    const suggestions = (query.length > 1) ? getSuggestions(query) : []

    if (suggestions.length === 0) {
        suggestionsList.style.display = 'none'
    } else {
        renderSuggestions(suggestions)
    }
})

const getSearchResults = (query) => {
    const searchOptions = {
        prefix: true, // partial word matching
        fuzzy: 0.2    // allow minor misspellings
    }
    return miniSearch.search(query, searchOptions)
}

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase();

        if (query.trim() === '') return;

        let results = getSearchResults(query)
        const topResult = results[0].title

        window.location.href = ('pages/' + topResult + '.html').replaceAll(' ', '_')
    }
})