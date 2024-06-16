[#ftl]
<!DOCTYPE html>
<html>
    <head>
     <title>${post.title}</title>
    </head>
    <body>
        <h1>${post.title}</h1>
        <div>${post.body?no_esc}</div>
    </body>
</html>