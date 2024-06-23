[#ftl]
[@c.page title="My blog"]

<h1>Posts</h1>
<div class="d-flex justify-content-end">
    <a href="/admin" class="btn btn-success">Administration</a>
</div>
[#list posts.content as post]
    <div class="post">
        <h2>${post.title}</h2>
        <div class="meta">
            <span>Author: ${post.author}</span>
            [#if post.published??]
                <span>Published: ${post.published?date?string}</span>
            [/#if]

        </div>
        <p class="perex">${post.perex}</p>
        <a href="/post/${post.slug}">Read more...</a>
    </div>

[#else]
    <p>No posts found</p>
[/#list]

[@c.pager /]
[/@c.page]



[#--                TODO dodać walidację formularza--]
[#--                TODO dodać obsługę błędów--]
[#--                TODO dodać obsługę wyjątków--]
