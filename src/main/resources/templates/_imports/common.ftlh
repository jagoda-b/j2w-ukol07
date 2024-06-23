[#ftl]

[#macro page title]
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="/images/favicon.png">
        <link rel="stylesheet" href="/css/normalize.css"/>
        <link rel="stylesheet" href="/css/main.css"/>
    </head>
    <body>
    <main class="container">
        [#nested]
    </main>
    </body>
    </html>
[/#macro]

[#macro pager]
    <div class="pager">
        [@pagerLink page=0 active=false text="⇤" /]
        [@pagerLink page=posts.number - 1 active=posts.first text="←" /]
        [#list (0..!posts.totalPages) as pageNumber]
            [@pagerLink page=pageNumber active=pageNumber==posts.number text=pageNumber + 1 /]
        [/#list]
        [@pagerLink page=posts.number + 1 active=posts.last text="→" /]
        [@pagerLink page=posts.totalPages - 1 active=false text="⇥" /]
    </div>
[/#macro]

[#macro pagerLink page text active]
    [#if active]
        <span class="page active">${text}</span>
    [#else ]
        <a href="${createURL({"size": posts.size, "page": page})}" class="page">${text}</a>
    [/#if]
[/#macro]

