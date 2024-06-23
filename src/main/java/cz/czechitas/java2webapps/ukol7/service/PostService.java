package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug).orElse(null);
    }

    public Page<Post> list(Pageable pageable) {
        return postRepository.findByPublishedBeforeOrderByPublishedDesc(LocalDate.now(), pageable);
    }

    public void save(Post form) throws Exception {
        if (postRepository.findBySlug(form.getSlug()).isPresent()) {
            throw new Exception("A post with the same slug already exists.");
        }
        postRepository.save(form);
    }

    public Page<Post> allList() {
        return postRepository.findAll(PageRequest.of(0, 20));
    }
}
