[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Můj blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="/images/favicon.png">
</head>
<body>
<h1>Posts</h1>
    [#list posts.content]
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Published</th>
                    <th>Slug</th>
                </tr>
            </thead>
            <tbody>
            [#items as post]
                <tr>
                    <td>${post.title}</td>
                    <td>${post.author}</td>
                    <td>${post.published?date?string}</td>
                    <td><a href="/post/${post.slug}">${post.slug}</a></td>
                </tr>
            [/#items]
            </tbody>
        </table>
        [#else]
            <p>No posts found</p>
    [/#list]

</body>
</html>
