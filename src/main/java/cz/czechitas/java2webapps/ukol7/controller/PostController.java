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
