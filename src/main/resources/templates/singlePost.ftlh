[#ftl]
[@c.page title="${post.title}"]
    <body>
        <div class="single-post">
            <h1>${post.title}</h1>
            <div>${post.body?no_esc}</div>
        </div>
    </body>
[/@c.page]