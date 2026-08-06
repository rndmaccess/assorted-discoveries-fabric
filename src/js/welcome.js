let miniSearch = new MiniSearch({
    fields: ['title'],
    storeFields: ['title']
})

const documents = [
    {
        id: 1,
        title: 'bog blossom'
    },
    {
        id: 2,
        title: 'planter box'
    },
    {
        id: 3,
        title: 'rope ladder'
    },
    {
        id: 4,
        title: 'enderman plushie'
    },
    {
        id: 5,
        title: 'zombie plushie'
    },
    {
        id: 6,
        title: 'wolf plushie'
    },
    {
        id: 7,
        title: 'strider plushie'
    },
    {
        id: 8,
        title: 'allay plushie'
    },
    {
        id: 9,
        title: 'vex plushie'
    },
    {
        id: 10,
        title: 'cat plushie'
    },
    {
        id: 11,
        title: 'cow plushie'
    },
    {
        id: 12,
        title: 'mooshroom plushie'
    },
    {
        id: 13,
        title: "sheep plushie"
    },
    {
        id: 14,
        title: "hoglin plushie"
    }
]

miniSearch.addAll(documents)

const searchInput = document.getElementById('search')
const suggestionsList = document.getElementById('suggestion-list')
const app = document.getElementById('app')

const getSuggestions = (query) => {
    return miniSearch.autoSuggest(query, {
        prefix: true, // partial word matching
        fuzzy: 0.2    // allow minor misspellings
    }).slice(0, 5)
}

const getSearchResults = (query) => {
    const searchOptions = {
        prefix: true, // partial word matching
        fuzzy: 0.2    // allow minor misspellings
    }
    return miniSearch.search(query, searchOptions)
}

const renderResults = (suggestions, results) => {
    let suggestion_words = suggestions.map(suggestion => suggestion.suggestion)
    let result_words = results.map(result => result.title)

    suggestionsList.innerHTML = result_words.map(( result ) => {
        let display_result = result

        if (result === undefined) {
            return ""
        }

        suggestion_words.forEach(term => {
            if (result.toLowerCase().includes(term.toLowerCase())) {
                display_result = result.replace(term, "<b>" + term + "</b>")
            }
        });

        return `<li class="suggestion" data-value="${result}">${display_result}</li>`;
    }).join('\n')
    suggestionsList.style.display = 'block'
}

app.addEventListener('click', (e) => {
    suggestionsList.style.display = 'none'; // Hide list
});

suggestionsList.addEventListener('click', (e) => {
    const li = e.target.closest('.suggestion');
    if (li) {
        searchInput.value = li.dataset.value; // Get text from data attribute
        suggestionsList.style.display = 'none'; // Hide list
        searchInput.focus()
    }
});

// Typing into search bar updates search results and suggestions
searchInput.addEventListener('input', () => {
    const query = searchInput.value

    const suggestions = (query.length > 1) ? getSuggestions(query) : []
    const results = (query.length > 1) ? getSearchResults(query) : []

    if (suggestions.length === 0) {
        suggestionsList.style.display = 'none'
    } else {
        renderResults(suggestions, results)
    }
})

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase();

        if (query.trim() === '') return;

        let results = getSearchResults(query)
        const topResult = results[0].title

        window.location.href = ('pages/' + topResult + '.html').replaceAll(' ', '_')
    }
})