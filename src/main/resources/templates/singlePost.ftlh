[#ftl]
[@c.page title="${post.title}"]


    <body>
        <h1>${post.title}</h1>
        <div>${post.body?no_esc}</div>
    </body>
[/@c.page]