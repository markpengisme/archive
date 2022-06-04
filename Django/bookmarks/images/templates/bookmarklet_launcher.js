;(function () {
    if (window.myBookmarklet !== undefined) {
        myBookmarklet()
    } else {
        let script = document.body.appendChild(document.createElement('script'));
        script.src =
            'https://{{host}}/static/js/bookmarklet.js?r=' +
            Math.floor(Math.random() * 99999999999999999999);
        script.dataset.host = '{{host}}';
    }
})()
