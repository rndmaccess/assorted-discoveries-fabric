import { isValidQuery } from './search_util.js';

const searchInput = document.getElementById('search');

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase();

        if (!isValidQuery(query)) {
            alert('Please type at least 3 characters.');
            return;
        }

        window.location.href = (`pages/search.html?q=${encodeURIComponent(query)}`);
    }
})