import allayPlushie from '../img/allay_plushie.webp';
import vexPlushie from '../img/vex_plushie.webp';
import striderPlushie from '../img/strider_plushie.webp';
import endermanPlushie from '../img/enderman_plushie.webp';
import oakPlanterBox from '../img/oak_planter_box.webp';
import paleWolfPlushieStanding from '../img/pale_wolf_plushie_standing.webp';
import zombiePlushie from '../img/zombie_plushie.webp';
import oakRopeLadder from '../img/oak_rope_ladder.webp';
import bogBlossom from '../img/bog_blossom.webp';

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
        img: bogBlossom,
    },
    {
        id: 2,
        title: 'planter box',
        description: 'The planter box',
        link: './planter_box.html',
        img: oakPlanterBox,
    },
    {
        id: 3,
        title: 'rope ladder',
        description: 'The rope ladder',
        link: './rope_ladder.html',
        img: oakRopeLadder,
    },
    {
        id: 4,
        title: 'enderman plushie',
        description: 'The enderman plushie',
        link: './enderman_plushie.html',
        img: endermanPlushie,
    },
    {
        id: 5,
        title: 'zombie plushie',
        description: 'The zombie plushie',
        link: './zombie_plushie.html',
        img: zombiePlushie,
    },
    {
        id: 6,
        title: 'wolf plushie',
        description: 'The wolf plushie',
        link: './wolf_plushie.html',
        img: paleWolfPlushieStanding,
    },
    {
        id: 7,
        title: 'strider plushie',
        description: 'The strider plushie',
        link: './strider_plushie.html',
        img: striderPlushie,
    },
    {
        id: 8,
        title: 'allay plushie',
        description: 'The allay plushie',
        link: './allay_plushie.html',
        img: allayPlushie,
    },
    {
        id: 9,
        title: 'vex plushie',
        description: 'The vex plushie',
        link: './vex_plushie.html',
        img: vexPlushie,
    }
];

miniSearch.addAll(documents);

const getSearchResults = (query) => {
    const searchOptions = {
        prefix: true, // partial word matching
        fuzzy: 0.2    // allow minor misspellings
    };
    return miniSearch.search(query, searchOptions);
}

const renderResults = (results) => {
    const searchList = document.getElementById('search-results');

    if (!searchList) {
        console.error('Search results not found');
        return;
    }

    searchList.innerHTML = "";
    searchList.insertAdjacentHTML('beforeend', results.map(({ title, description, link, img }) => {
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

const searchInput = document.getElementById('search');

window.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const query = urlParams.get('q');

    if (query) {
        if (searchInput) searchInput.value = query;

        const results = getSearchResults(query);
        renderResults(results);
    }
});

searchInput.addEventListener('keydown', function (event) {
    if (event.key === 'Enter') {
        const query = event.target.value.toLowerCase();
        if (query.trim() === '') return;
        const urlParams = new URLSearchParams(window.location.search);
        urlParams.set('q', query); // Update the url param if the user searches something new.

        const results = getSearchResults(query);
        renderResults(results);
    }
})