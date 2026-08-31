const searchInput = document.getElementById('search');

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase().trim();
        window.location.href = (`pages/search.html?q=${encodeURIComponent(query)}`);
    }
})