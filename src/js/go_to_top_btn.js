const go_to_top_btn = document.getElementById('go-to-top-btn');

window.onscroll = () => {
    scrollFunction()
}

function scrollFunction() {
    if (document.body.scrollTop > 300 || document.documentElement.scrollTop > 300) {
        go_to_top_btn.style.display = 'block';
    } else {
        go_to_top_btn.style.display = 'none';
    }
}

go_to_top_btn.addEventListener('click', function(){
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
});