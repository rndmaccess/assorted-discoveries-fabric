searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase();
        if (query.trim() === '') return;
        window.location.href = (`pages/search.html?q=${encodeURIComponent(query)}`);
    }
})