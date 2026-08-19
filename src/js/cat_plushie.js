import ocelotPlushieStanding from "../block_img/ocelot_plushie_standing.webp";
import ocelotPlushieSitting from "../block_img/ocelot_plushie_sitting.webp";
import whiteCatPlushieStanding from "../block_img/white_cat_plushie_standing.webp";
import whiteCatPlushieSitting from "../block_img/white_cat_plushie_sitting.webp";
import tabbyCatPlushieStanding from "../block_img/tabby_cat_plushie_standing.webp";
import tabbyCatPlushieSitting from "../block_img/tabby_cat_plushie_sitting.webp";
import tuxedoCatPlushieStanding from "../block_img/tuxedo_cat_plushie_standing.webp";
import tuxedoCatPlushieSitting from "../block_img/tuxedo_cat_plushie_sitting.webp";
import redCatPlushieStanding from "../block_img/red_cat_plushie_standing.webp";
import redCatPlushieSitting from "../block_img/red_cat_plushie_sitting.webp";
import siameseCatPlushieStanding from "../block_img/siamese_cat_plushie_standing.webp";
import siameseCatPlushieSitting from "../block_img/siamese_cat_plushie_sitting.webp";
import britishShorthairCatPlushieStanding from "../block_img/british_shorthair_cat_plushie_standing.webp";
import britishShorthairCatPlushieSitting from "../block_img/british_shorthair_cat_plushie_sitting.webp"
import calicoCatPlushieStanding from "../block_img/calico_cat_plushie_standing.webp";
import calicoCatPlushieSitting from "../block_img/calico_cat_plushie_sitting.webp";
import persianCatPlushieStanding from "../block_img/persian_cat_plushie_standing.webp";
import persianCatPlushieSitting from "../block_img/persian_cat_plushie_sitting.webp";
import ragdollCatPlushieStanding from "../block_img/ragdoll_cat_plushie_standing.webp";
import ragdollCatPlushieSitting from "../block_img/ragdoll_cat_plushie_sitting.webp";
import blackCatPlushieStanding from "../block_img/black_cat_plushie_standing.webp";
import blackCatPlushieSitting from "../block_img/black_cat_plushie_sitting.webp";
import jellieCatPlushieStanding from "../block_img/jellie_cat_plushie_standing.webp";
import jellieCatPlushieSitting from "../block_img/jellie_cat_plushie_sitting.webp";

import cod from "../item_img/cod.webp";
import salmon from "../item_img/salmon.webp";

// No module declaration needed; esbuild-loader handles imports.
import {createButtonPanel, createRecipeCycle} from "./side_page";

const headerImages = document.getElementsByClassName('header-image');
const container = document.getElementById('button-container');
const optionList = {
    "ocelot": [
        {
            "src": ocelotPlushieStanding,
            "alt": "An ocelot plushie with brown spots, brown nose, green eyes and a yellow body."
        },
        {
            "src": ocelotPlushieSitting,
            "alt": "An ocelot plushie with brown spots, brown nose, green eyes and a yellow body."
        }
    ],
    "white": [
        {
            "src": whiteCatPlushieStanding,
            "alt": "A white cat plushie with a pink nose, yellow left eye, and light blue right eye."
        },
        {
            "src": whiteCatPlushieSitting,
            "alt": "A white cat plushie with a pink nose, yellow left eye, and light blue right eye."
        }
    ],
    "tabby": [
        {
            "src": tabbyCatPlushieStanding,
            "alt": "A brown tabby cat plushie with yellow-orange eyes."
        },
        {
            "src": tabbyCatPlushieSitting,
            "alt": "A brown tabby cat plushie with yellow-orange eyes."
        }
    ],
    "tuxedo": [
        {
            "src": tuxedoCatPlushieStanding,
            "alt": "A tuxedo cat plushie with green eyes and a pink nose."
        },
        {
            "src": tuxedoCatPlushieSitting,
            "alt": "A tuxedo cat plushie with green eyes and a pink nose."
        }
    ],
    "red": [
        {
            "src": redCatPlushieStanding,
            "alt": "An orange cat with white paws and green eyes."
        },
        {
            "src": redCatPlushieSitting,
            "alt": "An orange cat with white paws and green eyes."
        }
    ],
    "siamese": [
        {
            "src": siameseCatPlushieStanding,
            "alt": "A siamese cat plushie with blue eyes."
        },
        {
            "src": siameseCatPlushieSitting,
            "alt": "A siamese cat plushie with blue eyes."
        }
    ],
    "british_shorthair": [
        {
            "src": britishShorthairCatPlushieStanding,
            "alt": "A british shorthair cat plushie with light yellow eyes."
        },
        {
            "src": britishShorthairCatPlushieSitting,
            "alt": "A british shorthair cat plushie with light yellow eyes."
        }
    ],
    "calico": [
        {
            "src": calicoCatPlushieStanding,
            "alt": "A calico cat with a yellow left eye, and light blue right eye."
        },
        {
            "src": calicoCatPlushieSitting,
            "alt": "A calico cat with a yellow left eye, and light blue right eye."
        }
    ],
    "persian": [
        {
            "src": persianCatPlushieStanding,
            "alt": "A persian cat plushie with light blue eyes."
        },
        {
            "src": persianCatPlushieSitting,
            "alt": "A persian cat plushie with light blue eyes."
        }
    ],
    "ragdoll": [
        {
            "src": ragdollCatPlushieStanding,
            "alt": "A ragdoll cat plushie with light blue eyes."
        },
        {
            "src": ragdollCatPlushieSitting,
            "alt": "A ragdoll cat plushie with light blue eyes."
        }
    ],
    "black": [
        {
            "src": blackCatPlushieStanding,
            "alt": "A black cat plushie with orange eyes and a pink nose."
        },
        {
            "src": blackCatPlushieSitting,
            "alt": "A black cat plushie with orange eyes and a pink nose."
        }
    ],
    "jellie": [
        {
            "src": jellieCatPlushieStanding,
            "alt": "A Jellie cat plushie with light yellow-green eyes and a pink nose."
        },
        {
            "src": jellieCatPlushieSitting,
            "alt": "A Jellie cat plushie with light yellow-green eyes and a pink nose."
        }
    ]
}

const craftingLists = {
    "fish": [cod, salmon]
};

createRecipeCycle(craftingLists);

container.addEventListener('click', (event) => {
    createButtonPanel(event, optionList, container, headerImages);
});