import {getSearchResults, isValidQuery, renderResults} from "./search";

const searchInput = document.getElementById('search');

window.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const query = urlParams.get('q');

    if (query) {
        if (searchInput) searchInput.value = query;

        if (!isValidQuery(query)) {
            return;
        }

        const results = getSearchResults(query);
        renderResults(results);
    }
});

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase().trim();

        if (!isValidQuery(query)) {
            event.preventDefault(); // Stops the page from submitting/navigating
            return;
        }

        const urlParams = new URLSearchParams(window.location.search);
        urlParams.set('q', query); // Update the url param if the user searches something new.

        window.history.pushState({}, '', `${window.location.pathname}?${urlParams.toString()}`);

        const results = getSearchResults(query);
        renderResults(results);
    }
})