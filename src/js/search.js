let miniSearch = new MiniSearch({
    fields: ['title', 'description', 'link', 'img'],
    storeFields: ['title', 'description', 'link', 'img'],
});

const documents = [
    {
        id: 1,
        title: 'bog blossom',
        description: 'The bog blossom',
        link: './bog_blossom.html',
        img: './img/bog_blossom.png',
    },
    {
        id: 2,
        title: 'planter box',
        description: 'The planter box',
        link: './planter_box.html',
        img: './static/img/oak_planter_box.png',
    },
    {
        id: 3,
        title: 'rope ladder',
        description: 'The rope ladder',
        link: './rope_ladder.html',
        img: './static/img/oak_rope_ladder.png',
    },
    {
        id: 4,
        title: 'enderman plushie',
        description: 'The enderman plushie',
        link: './enderman_plushie.html',
        img: './img/enderman_plushie.png',
    },
    {
        id: 5,
        title: 'zombie plushie',
        description: 'The zombie plushie',
        link: './zombie_plushie.html',
        img: './static/img/zombie_plushie.png',
    },
    {
        id: 6,
        title: 'wolf plushie',
        description: 'The wolf plushie',
        link: './wolf_plushie.html',
        img: './static/img/wolf_plushie.png',
    },
    {
        id: 7,
        title: 'strider plushie',
        description: 'The strider plushie',
        link: './strider_plushie.html',
        img: './static/img/strider_plushie.png',
    }
];

miniSearch.addAll(documents);

const searchInput = document.getElementById('search');
const searchList = document.getElementById('search-results');

const getSearchResults = (query) => {
    const searchOptions = {
        prefix: true, // partial word matching
        fuzzy: 0.2    // allow minor misspellings
    };
    return miniSearch.search(query, searchOptions);
}

const renderResults = (results) => {
    searchList.insertAdjacentHTML('beforeend', results.map((title, description, link, img ) => {
        if (title === undefined) {
            return "";
        }
        return `<li class="result-item">
                <div>
                    <div>
                        <a class="result-title" href="${link}">${title}</a>
                        <p>
                            ${description}
                        </p>
                    </div>
                </div>
                <img class="result-img" src="${img}" alt="${title}">
            </li>`;
    }).join('\n'));
}

window.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const query = urlParams.get('q');

    if (query) {
        const searchInput = document.getElementById('search');
        if (searchInput) searchInput.value = query;

        const results = getSearchResults(query);
        renderResults(results);
    }
});