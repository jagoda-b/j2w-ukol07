[#ftl]
[@c.page title="My blog"]

<h1>Posts</h1>
    <div class="d-flex justify-content-end">
        <a href="/admin" class="btn btn-success">Administration</a>
    </div>
    [#list posts.content]
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Published</th>
                    <th>Perex</th>
                    <th>Link</th>
                </tr>
            </thead>
            <tbody>
            [#items as post]
[#--                TODO zmienić układ na bardziej naturalny dla bloga (nie tabela--]
[#--                TODO dodać edycję posta--]
[#--                TODO data publikacje nie obowiązkowa--]
[#--                TODO dodać usuwanie postów--]
[#--
[#--                TODO dodać walidację formularza--]
[#--                TODO układ pól w formularzu edycji--]
[#--                TODO dodać obsługę błędów--]
[#--                TODO dodać obsługę wyjątków--]
[#--                TODO css może?--]


                <tr>
                    <td>${post.title} </td>
                    <td>${post.author}</td>
                    <td>${post.published?date?string}</td>
                    <td>${post.perex}</td>
                    <td><a href="/post/${post.slug}">Read more...</a></td>
                </tr>
            [/#items]
            </tbody>
        </table>

        [@c.pager /]

        [#else]
            <p>No posts found</p>
    [/#list]

[/@c.page]