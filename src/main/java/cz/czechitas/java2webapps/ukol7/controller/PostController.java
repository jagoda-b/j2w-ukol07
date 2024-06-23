package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ModelAndView list(@RequestParam(required = false, defaultValue = "0") int page,
                             @RequestParam(required = false, defaultValue = "20") int size) {
        return new ModelAndView("index")
                .addObject("posts", postService.list(PageRequest.of(page, size)));
    }

    @GetMapping("/admin")
    public ModelAndView adminList() {
        return new ModelAndView("admin")
                .addObject("posts", postService.allList());
    }


    @GetMapping("/post/{slug}")
    public ModelAndView singlePost(@PathVariable String slug) {
        return new ModelAndView("singlePost")
                .addObject("post", postService.singlePost(slug));
    }

    @GetMapping("/post/{slug}/edit")
    public ModelAndView editPost(@PathVariable String slug) {
        return new ModelAndView("edit")
                .addObject("form", postService.singlePost(slug));
    }

    @PostMapping("/post/{slug}/edit")
public String updatePost(@PathVariable String slug, @ModelAttribute("form") @Valid Post form, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "edit";
    }
    try {
        Post existingPost = postService.singlePost(slug);
        if (existingPost == null) {
            throw new IllegalArgumentException("Post with slug " + slug + " does not exist");
        }
        // Copy the updated fields from the form to the existing post
        existingPost.setTitle(form.getTitle());
        existingPost.setAuthor(form.getAuthor());
        existingPost.setPerex(form.getPerex());
        existingPost.setBody(form.getBody());
        existingPost.setPublished(form.getPublished());
        // The slug should not be changed, so no need to copy it
        postService.update(existingPost);
    } catch (Exception e) {
        bindingResult.rejectValue("slug", null, e.getMessage());
        return "edit";
    }
    return "redirect:/post/" + slug;
}

    @GetMapping("/new")
    public ModelAndView newPost() {
        return new ModelAndView("new")
                .addObject("form", new Post());
    }

    @PostMapping("/new")
    public String newPost(@ModelAttribute("form") @Valid Post form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        try {
            postService.save(form);
        } catch (Exception e) {
            bindingResult.rejectValue("slug", null, e.getMessage());
            return "/new";
        }
        return "redirect:/";
    }
}
