package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug).orElse(null);
    }

    public Page<Post> list() {
        return postRepository.findByPublishedBeforeOrderByPublishedDesc(LocalDate.now(), PageRequest.of(0, 20));
    }


}
