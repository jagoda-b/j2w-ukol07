[#ftl]
[@c.page title="${post.title}"]
    <body>
        <div class="single-post">
            <h1>${post.title}</h1>
            <div class="meta">
                <span>Author: ${post.author}</span>
                [#if post.published??]
                    <span>Published: ${post.published?date?string}</span>
                [/#if]
            </div>
            <div>${post.perex?no_esc}</div>
            <div>${post.body?no_esc}</div>
        </div>
    </body>
[/@c.page]