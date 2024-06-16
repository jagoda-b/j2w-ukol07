package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ModelAndView list() {
        return new ModelAndView("index")
                .addObject("posts", postService.list());
    }

    @GetMapping("/post/{slug}")
    public ModelAndView singlePost(String slug) {
        return new ModelAndView("post")
                .addObject("post", postService.singlePost(slug));
    }

}
