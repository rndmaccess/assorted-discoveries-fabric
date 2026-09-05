import {getSearchResults} from "./search";

const searchInput = document.getElementById('search');

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase().trim();
        const results = getSearchResults(query);

        if (results && results.length === 1) {
            window.location.href = "pages/" + results[0].link;
        } else {
            window.location.href = (`pages/search.html?q=${encodeURIComponent(query)}`);
        }
    }
})