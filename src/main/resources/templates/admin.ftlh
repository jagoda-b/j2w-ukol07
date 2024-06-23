[#ftl]
[@c.page title="My blog = admin"]
    <h1>Posts - administration</h1>
    <div class="d-flex justify-content-end">
        <a href="/new" class="btn btn-success">New post</a>
    </div>
    [#list posts.content]
        <div class="admin-table">
            <table>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Published</th>
                    <th>Slug</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                [#items as post]
                    <tr>
                        <td>${post.title}</td>
                        <td>${post.author}</td>
                        <td>${post.published?date?string}</td>
                        <td><a href="/post/${post.slug}">${post.slug}</a></td>
                        <td>
                            <a href="/post/${post.slug}/edit" class="btn btn-primary">Edit</a>
                            <a href="/post/${post.slug}/delete" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                [/#items]
                </tbody>
            </table>
        </div>
    [#else]
    [/#list]
[/@c.page]
<p>No posts found</p>