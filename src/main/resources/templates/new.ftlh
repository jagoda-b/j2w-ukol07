[#ftl]
[@c.page title="New post"]
<form action="/new" method="post">
    <div class="row">
        <div>
            <label for="title">Title</label>
            <input id="title" name="title" type="text" value="${(form.title)!}">
        </div>
        <div>
            <label for="author">Author</label>
            <input id="author" name="author" class="u-full-width" type="text" value="${(form.author)!}">
            </div>
        <div>
            <label for="Perex">Perex</label>
            <input id="perex" name="perex" class="u-full-width" type="text" value="${(form.perex)!}">
        </div>
        <div>
            <label for="body">Content</label>
            <textarea id="body" name="body" class="u-full-width" required>${(form.body)!}</textarea>
        </div>
        <div>
            <label for="slug">Slug</label>
            <input id="slug" name="slug" class="u-full-width" type="text" value="${(form.slug)!}">
        </div>
        <div>
            <label for="Published">Published</label>
            <input id="published" name="published" class="u-full-width" type="date" value="${(form.published?date)!}">
        </div>
        <div class="two columns submit">
            <button class="button-primary" type="submit">Save</button>
        </div>
    </div>
</form>

[/@c.page]